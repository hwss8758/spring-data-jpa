package me.wonsang.springdatajpav1003

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Comment(
        @Id
        @GeneratedValue
        var id: Long? = null,
        var comment: String = "",
        @ManyToOne
        var post: Post? = null
) {

}
