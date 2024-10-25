package uz.gita.shoppingappwithgithub.source.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["phone"], unique = true)])
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val firstName: String?,
    val lastName: String?,
    val date: String?,
    val phone: String?
)
