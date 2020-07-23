package me.wonsang.springdatajpav1003

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {
    abstract fun findByTitleContains(title: String, pageable: Pageable): Page<Post>
    abstract fun countByTitleContains(title: String): Long
}