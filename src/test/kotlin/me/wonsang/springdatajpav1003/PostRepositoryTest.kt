package me.wonsang.springdatajpav1003

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.PageRequest
import org.springframework.test.annotation.Rollback

@DataJpaTest
class PostRepositoryTest {

    @Autowired
    lateinit var postRepository: PostRepository

    @Test
    @Rollback(false)
    fun repositoryTest() {
        val post = Post(title = "hello spring boot common")
        val post1 = postRepository.save(post)

        assertThat(post1.id).isNotNull()

        val findAllPost = postRepository.findAll()

        assertThat(findAllPost.size).isEqualTo(1)
        assertThat(findAllPost).contains(post1)

        val page = postRepository.findAll(PageRequest.of(0, 10))
        assertThat(page.totalElements).isEqualTo(1)
        assertThat(page.number).isEqualTo(0)
        assertThat(page.numberOfElements).isEqualTo(1)

        postRepository.findByTitleContains("hello", PageRequest.of(0, 10))
        assertThat(page.totalElements).isEqualTo(1)
        assertThat(page.number).isEqualTo(0)
        assertThat(page.numberOfElements).isEqualTo(1)

        val countByTitleContains = postRepository.countByTitleContains("spring")
        assertThat(countByTitleContains).isEqualTo(1)
    }
}