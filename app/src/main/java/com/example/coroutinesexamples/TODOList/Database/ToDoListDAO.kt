package com.example.coroutinesexamples.TODOList.Database

import androidx.room.Insert
import androidx.room.Query

interface ToDoListDAO {
    @Query("SELECT * FROM todolist")
    fun getAll(): List<ToDoListDataEntity>

    @Insert
    fun insert(toDoListData: ToDoListDataEntity):Long

    @Query("UPDATE todolist SET title = :title, date =:date, time =:time where id LIKE :id")
    fun update(title:String,date:String,time:String,id:Long)
    @Query("DELETE From todolist where id =:id")
     fun delete(id: Long)
     @Query("UPDATE todolist set isShow = :isShow where id LIKE :id")
     fun isShowUpdate(id: Long,isShow:Int)
     @Query("SELECT * from todolist where id Like :id")
     fun get(id:Long):ToDoListDataEntity

}