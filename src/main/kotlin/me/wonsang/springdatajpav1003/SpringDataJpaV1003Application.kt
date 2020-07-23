package me.wonsang.springdatajpav1003

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
class SpringDataJpaV1003Application

fun main(args: Array<String>) {
    runApplication<SpringDataJpaV1003Application>(*args)
}
