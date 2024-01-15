package com.example.coroutinesexamples.TODOList.Database

import androidx.room.Insert
import retrofit2.http.Query

interface ToDoListDAO {
    @Query("SELECT * FROM todolist")
    fun getAll(): List<ToDoListDataEntity>

    @Insert
    fun insert(toDoListData: ToDoListDataEntity):Long

    @Query("UPDATE todolist SET title = :title, date =:date, time =:time where id LIKE :id")
    fun update(title:String,date:String,time:String,id:Long)
    @Query("DELETE From todolist where id =:id")
     fun delete(id: Long)
     @Query("UPDATE todolist Set isShow = :isshow  where is LIKE :id")
     fun isShowUpdate(id: Long,isShow:Int)
     @Query("SELECT * from todolist where is Like :id")
     fun get(id:Long):ToDoListDataEntity

}