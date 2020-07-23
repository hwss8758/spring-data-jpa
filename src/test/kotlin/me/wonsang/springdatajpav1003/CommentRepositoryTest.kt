package me.wonsang.springdatajpav1003

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    lateinit var commentRepository: CommentRepository

    @Test
    fun crud() {
        val comment = Comment(comment = "Hello Comment")
        commentRepository.save(comment)

        val commentFindAll = commentRepository.findAll()

        assertThat(commentFindAll.size).isEqualTo(1)
    }
}