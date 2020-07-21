package me.wonsang.springdatajpav1003

import org.hibernate.Session
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Component
@Transactional
class JpaRunner : ApplicationRunner {

    // entity를 영구 저장하는 환경이라는 뜻
    @PersistenceContext
    lateinit var entityManager: EntityManager

    override fun run(args: ApplicationArguments?) {
        val account = Account(username = "yiseo",
                password = "jpa")

        //--------------------------------------------
        // ManyToOne
        //--------------------------------------------
        //val study = Study(name = "Spring data JPA", owner = account)

        //--------------------------------------------
        // OneToMany
        //--------------------------------------------
        //val study = Study(name = "Spring data JPA")
        //account.studies.add(study)

        //--------------------------------------------
        // 양방향관계.
        // 아래의 예제에서 관계의 주인은 study => ManyToOne을 가지고 있는 쪽.
        // 관계의 주인인 쪽에다가 관계를 맺어줘야한다.
        // account, study 모두 설정해줘야한다.
        //--------------------------------------------
        val study = Study(name = "Spring data JPA")
        // account.studies?.add(study)
        // study.owner = account
        account.addStudy(study)
        //-----------------------------------------------------
        // hibernate session 추출을 통해 account 저장
        //-----------------------------------------------------
        val session = entityManager.unwrap(Session::class.java)
        session.save(account)
        session.save(study)

        //-----------------------------------------------------
        // entitymanager 사용하여 처리
        //-----------------------------------------------------
        // 실제로 DB에 저장하는게 아니라 영속성 context를 통해서 entity를 영속화 한다는 뜻이다.
        // 정확히 말하면 persist() 시점에는 entity를 영속성 컨텍스트에 저장하는 것이다.
        //entityManager.persist(account)
    }
}