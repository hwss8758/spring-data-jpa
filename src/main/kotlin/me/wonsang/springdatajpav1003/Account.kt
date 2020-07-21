package me.wonsang.springdatajpav1003

import java.util.*
import javax.persistence.*
import kotlin.collections.HashSet

// 객체세상에서 부르는 이름
// 보통 클래스와 같은 이름을 사용하기 때문에 값을 변경하지 않음.
@Entity
// Entity의 이름이 기본값
// table의 이름은 sql에서 쓰임.
// 릴레이션 세상에서 부르는 이름임.
@Table
data class Account(
        // 엔티티의 주키를 맵필할때 사용.
        @Id
        // 주키의 생성 방법을 맵핑하는 어노테이션.
        // 생성 전략과 생성기를 설정할 수 있다.
        //  -> 기본 전략은 AUTO
        //  -> TABLE, SEQUENCE, IDENTITY 중 하나.
        @GeneratedValue
        var id: Long? = null,
        // 생략 가능.
        @Column(nullable = false, unique = true)
        var username: String = "",
        @Column
        var password: String = "",
        //@Temporal(TemporalType.TIMESTAMP)
        //@Temporal(TemporalType.TIME)
        @Temporal(TemporalType.DATE)
        var created: Date = Date(),
        // 컬럼으로 매핑되지 않는 어노테이션.
        @Transient
        var no: String = "",
        @Embedded
        var address: Address? = null,
        //---------------------------------------------
        // one to many는 데이터 타입이 collection임.
        // @OneToMany
        //---------------------------------------------
        // @OneToMany
        // var studies: MutableSet<Study> = HashSet<Study>()

        //---------------------------------------------
        // 양방향 관계 설정 시 manyToOne과 관련된 칼럼을 설정해 준다.
        // 양방향 관계 설정 시에는 외래키를 가진 쪽이 owner임.
        //---------------------------------------------
        @OneToMany(mappedBy = "owner")
        var studies: MutableSet<Study>? = null
) {
    fun addStudy(study: Study) {
        this.studies?.add(study)
        study.owner = this
    }

    fun removeStudy(study: Study) {
        this.studies?.remove(study)
        study.owner = null
    }
}