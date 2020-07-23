package me.wonsang.springdatajpav1003

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class JpaRepositoryRunner : ApplicationRunner {
    @Autowired
    lateinit var postRepository: PostRepository

    override fun run(args: ApplicationArguments?) {
        val findAll = postRepository.findAll()

        findAll.forEach { println(it.title) }
    }
}