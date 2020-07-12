package info.chirikualii.simplemvvm.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


/**
 * Created by chirikuAlii on 11/07/2020.
 * github.com/chirikualii
 */

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addArticle(articleEnitity: ArticleEntity)

    @Query("SELECT * FROM article")
    suspend fun getArticle() :List<ArticleEntity>
}