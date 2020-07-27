package me.wonsang.springdatajpav1003

import javax.persistence.*

@Entity
data class Comment(
        @Id
        @GeneratedValue
        var id: Long? = null,
        var comment: String = "",
        @ManyToOne(fetch = FetchType.EAGER)
        var post: Post? = null,
        var likeCount: Int = 0
) {

}
