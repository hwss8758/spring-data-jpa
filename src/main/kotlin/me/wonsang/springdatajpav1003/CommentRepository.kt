package me.wonsang.springdatajpav1003

import org.springframework.data.repository.RepositoryDefinition

//@RepositoryDefinition(domainClass = Comment::class, idClass = Long::class)
interface CommentRepository : MyRepository<Comment, Long> {

//    fun save(comment: Comment): Comment
//
//    fun findAll(): MutableList<Comment>
}