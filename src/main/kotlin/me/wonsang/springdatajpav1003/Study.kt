package me.wonsang.springdatajpav1003

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Study(
        @Id
        @GeneratedValue
        var id: Long? = null,
        var name: String = "",
        @ManyToOne
        var owner: Account? = null
        //---------------------------------------------
        // @ManyToOne
        // account 관련된 foreign key가 생성된다.
        //---------------------------------------------
        // @ManyToOne
        // var owner: Account? = null
) {
}