package me.wonsang.springdatajpav1003

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Account(
        @Id @GeneratedValue
        var id: Long? = null,
        var username: String = "",
        var password: String = ""
) {
}