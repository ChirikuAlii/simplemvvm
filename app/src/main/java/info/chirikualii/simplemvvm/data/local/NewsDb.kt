package info.chirikualii.simplemvvm.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


/**
 * Created by chirikuAlii on 11/07/2020.
 * github.com/chirikualii
 */

@Database(
    entities = [ArticleEntity::class],
    version = 1
)
abstract class NewsDb : RoomDatabase(){

    abstract fun articleDao() :ArticleDao

    companion object{

        fun getInstance(context: Context): NewsDb{
            return Room.databaseBuilder(context.applicationContext,
                NewsDb::class.java, "news.db")
                .build()

        }
    }
}