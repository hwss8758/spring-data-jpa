package me.wonsang.springdatajpav1003

import com.sun.xml.bind.v2.model.core.ID
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.Repository
import java.io.Serializable

@NoRepositoryBean
interface MyRepository<T, ID : Serializable> : Repository<T, ID>{

    fun <E: T> save(entity: E): E

    fun findAll(): MutableList<T>
}