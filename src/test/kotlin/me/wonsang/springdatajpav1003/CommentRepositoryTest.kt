package me.wonsang.springdatajpav1003

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import java.util.stream.Stream

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
//        val commentList = commentRepository.findAll()
//        assertThat(commentList).isNotNull

        //val comment = Comment(comment = "spring data jpa", likeCount = 100)
        //commentRepository.save(comment)

        commentRepository.save(Comment(comment = "spring data jpa", likeCount = 100))
        commentRepository.save(Comment(comment = "spring data jpa", likeCount = 90))

        //val comments = commentRepository.findByCommentContainsIgnoreCaseAndLikeCountGreaterThan("Spring", 10)

        val comments = commentRepository.findByCommentContainsIgnoreCaseOrderByLikeCountDesc("Spring")

        assertThat(comments.size).isEqualTo(2)
        assertThat(comments).first().hasFieldOrPropertyWithValue("likeCount", 100)

        val pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "LikeCount"))
        val page = commentRepository.findByCommentContainsIgnoreCase("Spring", pageRequest)
        
        assertThat(page.numberOfElements).isEqualTo(2)
        assertThat(page).first().hasFieldOrPropertyWithValue("likeCount", 100)

    }
}