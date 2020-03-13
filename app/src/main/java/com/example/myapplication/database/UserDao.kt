package com.example.myapplication.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM User")
    fun getAll() : List<User>

    @Query("SELECT * FROM User WHERE id=:id")
    fun getUserById(id: Int) : User

    @Insert
    fun insertUsers(vararg user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("DELETE FROM User")
    fun deleteAll()

}