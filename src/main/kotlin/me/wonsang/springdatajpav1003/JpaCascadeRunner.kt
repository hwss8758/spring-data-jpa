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
class JpaCascadeRunner : ApplicationRunner {

    // entity를 영구 저장하는 환경이라는 뜻
    @PersistenceContext
    lateinit var entityManager: EntityManager

    override fun run(args: ApplicationArguments?) {
        val post = Post(title = "Spring Data Jpa...")
        val comment1 = Comment(comment = "soon and very soon...")
        val comment2 = Comment(comment = "let's do this...")

        println(comment1)
        println(comment2)

        post.addComment(comment1)
        post.addComment(comment2)

        println(post)

        val session = entityManager.unwrap(Session::class.java)
        session.save(post)
        //session.save(comment1)
        //session.save(comment2)

    }
}