package me.wonsang.springdatajpav1003

import javax.persistence.*

@Entity
data class Post(
        @Id
        @GeneratedValue
        var id: Long? = null,
        var title: String = "",
        @OneToMany(mappedBy = "post", cascade = [CascadeType.ALL])
        var comments: MutableSet<Comment>? = null
) {
    fun addComment(comment: Comment) {
        this.comments?.add(comment)
        comment.post = this

    }
}