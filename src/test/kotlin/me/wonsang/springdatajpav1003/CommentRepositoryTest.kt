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
//        val comment = Comment(comment = "Hello Comment")
//        commentRepository.save(comment)
//
//        val commentFindAll = commentRepository.findAll()
//
//        assertThat(commentFindAll.size).isEqualTo(1)
//
//        val byId = commentRepository.findById<Comment>(100)
//        assertThat(byId).isEmpty

        // 컬렉션은 비어있는 null을 리턴 하지 않고 비어있는 콜렉션을 리턴함
        val commentList = commentRepository.findAll()
        assertThat(commentList).isNotNull

        commentRepository.save(null)



    }
}