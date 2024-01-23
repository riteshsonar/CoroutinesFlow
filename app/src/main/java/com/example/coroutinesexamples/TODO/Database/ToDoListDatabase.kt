package com.example.coroutinesexamples.TODO.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ToDoListDataEntity::class), version = 1)
abstract class ToDoListDatabase: RoomDatabase() {

        abstract fun toDoListDao(): ToDoListDAO

    companion object{

        @Volatile
        private var instance : ToDoListDatabase? = null

        fun getInstance(context:Context): ToDoListDatabase? {
            if (instance == null){
                synchronized(ToDoListDatabase::class){
                    instance = Room.databaseBuilder(context.applicationContext,ToDoListDatabase::class.java,"todolistdb").allowMainThreadQueries().build()
                }
            }
            return instance
        }

    }
}