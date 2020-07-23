package me.wonsang.springdatajpav1003

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

@Component
@Transactional
class JpaQueryRunner : ApplicationRunner {

    @PersistenceContext
    lateinit var entityManager: EntityManager

    override fun run(args: ApplicationArguments?) {

        //----------------------------------------------
        // JPQL 사용
        //----------------------------------------------
//        val createQuery = entityManager.createQuery("SELECT p FROM Post AS p", Post::class.java)
//        val posts = createQuery.resultList
//
//        println("==========================================")
//        println("chk post!! ~~~~~~~~~~~~~~~~~~~~")
//        posts.forEach { println(it.title) }
//        println("==========================================")

        //----------------------------------------------
        // Criteria 사용
        // 타입세이프 쿼리 
        //----------------------------------------------

//        val criteriaBuilder = entityManager.criteriaBuilder
//        val createQuery = criteriaBuilder.createQuery(Post::class.java)
//        val root = createQuery.from(Post::class.java)
//        createQuery.select(root)
//
//        val posts = entityManager.createQuery(createQuery).resultList
//
//        posts.forEach { println(it.title) }
    }
}