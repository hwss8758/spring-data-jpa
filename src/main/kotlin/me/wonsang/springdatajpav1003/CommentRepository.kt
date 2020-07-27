package me.wonsang.springdatajpav1003

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.RepositoryDefinition
import java.util.stream.Stream


//@RepositoryDefinition(domainClass = Comment::class, idClass = Long::class)
interface CommentRepository : MyRepository<Comment, Long> {

    // MyRepository에 선언함
    //    fun save(comment: Comment): Comment
    //
    //    fun findAll(): MutableList<Comment>

    //--------------------------------------------------------------------
    // findByTitleContains 메소드를 보고 자동으로 쿼리 생성
    // 아래와 같이 @Query를 사용하면 함수명 전에 정의된 쿼리를 사용(USE_DECLARED_QUERY), 기본값은 JPQL을 사용
    // db에 종속된 쿼리를 그대로 사용하고 싶은 경우 아래와 같이 nativeQuery=true옵션을 부여한다.
    // @Query(value = "selet c from Comment as c", nativeQuery = true)
    // nativeQuery = true로 값을 주면 실제 DB에서 사용되는 쿼리를 정의하면 된다.
    //--------------------------------------------------------------------
    //@Query(value = "selet c from Comment as c", nativeQuery = true)
    //fun findByCommentContainsIgnoreCaseAndLikeCountGreaterThan(keyword: String, likeCount: Int): MutableList<Comment>
    fun findByCommentContainsIgnoreCaseOrderByLikeCountDesc(keyword: String): MutableList<Comment>

    fun findByCommentContainsIgnoreCase(keyword: String, pageable: Pageable): Page<Comment>

    fun findByCommentContains(keyword: String, pageable: Pageable): Stream<Comment>

    // Pageable에는 정렬을 할수 있는 기능도 있음
    fun findByLikeCountGreaterThanAndPost(likeCount: Int,
                                          post: Post,
                                          pageable: Pageable): Page<Comment>
}