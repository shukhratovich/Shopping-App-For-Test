package uz.gita.shoppingappwithgithub.source.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import uz.gita.shoppingappwithgithub.source.entity.UserEntity

@Dao
interface UserDao {

    @Query("Select * from UserEntity where UserEntity.phone = :phone")
    fun getUserByPhone(phone: String): UserEntity?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user: UserEntity): Long

}