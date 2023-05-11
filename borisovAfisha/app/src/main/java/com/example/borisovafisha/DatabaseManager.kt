package com.example.borisovafisha

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.borisovafisha.Movie


class DatabaseManager(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "MovieDatabase.db"
        private const val TABLE_MOVIES = "movies"
        private const val COLUMN_ID = "id"
        private const val COLUMN_TITLE = "title"
        private const val COLUMN_DESCRIPTION = "description"
        private const val COLUMN_POSTER = "poster"
        private const val COLUMN_DIRECTOR = "director"
        private const val COLUMN_WRITERS = "writers"
        private const val COLUMN_RELEASE_DATE = "release_date"
        private const val COLUMN_RUNNING_TIME = "running_time"
        private const val COLUMN_COUNTRY = "country"
        private const val COLUMN_BUDGET = "budget"
        private const val COLUMN_RATING = "rating"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = "CREATE TABLE $TABLE_MOVIES (" +
                "$COLUMN_ID INTEGER PRIMARY KEY," +
                "$COLUMN_TITLE TEXT," +
                "$COLUMN_DESCRIPTION TEXT," +
                "$COLUMN_POSTER TEXT," +
                "$COLUMN_DIRECTOR TEXT," +
                "$COLUMN_WRITERS TEXT," +
                "$COLUMN_RELEASE_DATE TEXT," +
                "$COLUMN_RUNNING_TIME TEXT," +
                "$COLUMN_COUNTRY TEXT," +
                "$COLUMN_BUDGET TEXT," +
                "$COLUMN_RATING TEXT" +
                ")"
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_MOVIES")
        onCreate(db)
    }

    fun addMovie(movie: Movie): Long {
        val values = ContentValues()
        values.put(COLUMN_TITLE, movie.title)
        values.put(COLUMN_DESCRIPTION, movie.description)
        values.put(COLUMN_POSTER, movie.poster)
        values.put(COLUMN_DIRECTOR, movie.director)
        values.put(COLUMN_WRITERS, movie.writers)
        values.put(COLUMN_RELEASE_DATE, movie.release_date)
        values.put(COLUMN_RUNNING_TIME, movie.running_time)
        values.put(COLUMN_COUNTRY, movie.country)
        values.put(COLUMN_BUDGET, movie.budget)
        values.put(COLUMN_RATING, movie.rating)

        val db = writableDatabase
        val id = db.insert(TABLE_MOVIES, null, values)
        db.close()
        return id
    }

    @SuppressLint("Range")
    fun getMovie(id: Long): Movie? {
        val db = readableDatabase
        val cursor: Cursor = db.query(
            TABLE_MOVIES,
            arrayOf(
                COLUMN_ID,
                COLUMN_TITLE,
                COLUMN_DESCRIPTION,
                COLUMN_POSTER,
                COLUMN_DIRECTOR,
                COLUMN_WRITERS,
                COLUMN_RELEASE_DATE,
                COLUMN_RUNNING_TIME,
                COLUMN_COUNTRY,
                COLUMN_BUDGET,
                COLUMN_RATING
            ),
            "$COLUMN_ID=?",
            arrayOf(id.toString()),
            null,
            null,
            null,
            null
        )
        var movie: Movie? = null
        if (cursor.moveToFirst()) {
            val title = cursor.getString(cursor.getColumnIndex(COLUMN_TITLE))
            val description = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION))
            val poster = cursor.getString(cursor.getColumnIndex(COLUMN_POSTER))
            val director = cursor.getString(cursor.getColumnIndex(COLUMN_DIRECTOR))
            val writers = cursor.getString(cursor.getColumnIndex(COLUMN_WRITERS))
            val releaseDate = cursor.getString(cursor.getColumnIndex(COLUMN_RELEASE_DATE))
            val runningTime = cursor.getString(cursor.getColumnIndex(COLUMN_RUNNING_TIME))
            val country = cursor.getString(cursor.getColumnIndex(COLUMN_COUNTRY))
            val budget = cursor.getString(cursor.getColumnIndex(COLUMN_BUDGET))
            val rating = cursor.getString(cursor.getColumnIndex(COLUMN_RATING))

            movie = Movie(
                title,
                description,
                poster,
                director,
                writers,
                releaseDate,
                runningTime,
                country,
                budget,
                rating
            )
        }

        cursor.close()
        db.close()

        return movie
    }

    fun updateMovie(id: Long, updatedMovie: Movie): Int {
        val values = ContentValues()
        values.put(COLUMN_TITLE, updatedMovie.title)
        values.put(COLUMN_DESCRIPTION, updatedMovie.description)
        values.put(COLUMN_POSTER, updatedMovie.poster)
        values.put(COLUMN_DIRECTOR, updatedMovie.director)
        values.put(COLUMN_WRITERS, updatedMovie.writers)
        values.put(COLUMN_RELEASE_DATE, updatedMovie.release_date)
        values.put(COLUMN_RUNNING_TIME, updatedMovie.running_time)
        values.put(COLUMN_COUNTRY, updatedMovie.country)
        values.put(COLUMN_BUDGET, updatedMovie.budget)
        values.put(COLUMN_RATING, updatedMovie.rating)

        val db = writableDatabase
        val rowsAffected = db.update(
            TABLE_MOVIES,
            values,
            "$COLUMN_ID=?",
            arrayOf(id.toString())
        )

        db.close()
        return rowsAffected
    }

    fun deleteMovie(id: Long): Int {
        val db = writableDatabase
        val rowsAffected = db.delete(
            TABLE_MOVIES,
            "$COLUMN_ID=?",
            arrayOf(id.toString())
        )

        db.close()
        return rowsAffected
    }

    @SuppressLint("Range")
    fun getAllMovies(): List<Movie> {
        val movies = mutableListOf<Movie>()

        val db = readableDatabase
        val cursor: Cursor = db.query(
            TABLE_MOVIES,
            arrayOf(
                COLUMN_ID,
                COLUMN_TITLE,
                COLUMN_DESCRIPTION,
                COLUMN_POSTER,
                COLUMN_DIRECTOR,
                COLUMN_WRITERS,
                COLUMN_RELEASE_DATE,
                COLUMN_RUNNING_TIME,
                COLUMN_COUNTRY,
                COLUMN_BUDGET,
                COLUMN_RATING
            ),
            null,
            null,
            null,
            null,
            null
        )

        while (cursor.moveToNext()) {
            val id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID))
            val title = cursor.getString(cursor.getColumnIndex(COLUMN_TITLE))
            val description = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION))
            val poster = cursor.getString(cursor.getColumnIndex(COLUMN_POSTER))
            val director = cursor.getString(cursor.getColumnIndex(COLUMN_DIRECTOR))
            val writers = cursor.getString(cursor.getColumnIndex(COLUMN_WRITERS))
            val releaseDate = cursor.getString(cursor.getColumnIndex(COLUMN_RELEASE_DATE))
            val runningTime = cursor.getString(cursor.getColumnIndex(COLUMN_RUNNING_TIME))
            val country = cursor.getString(cursor.getColumnIndex(COLUMN_COUNTRY))
            val budget = cursor.getString(cursor.getColumnIndex(COLUMN_BUDGET))
            val rating = cursor.getString(cursor.getColumnIndex(COLUMN_RATING))

            val movie = Movie(
                title,
                description,
                poster,
                director,
                writers,
                releaseDate,
                runningTime,
                country,
                budget,
                rating
            )
            movies.add(movie)
        }

        cursor.close()
        db.close()
        return movies
    }
}

