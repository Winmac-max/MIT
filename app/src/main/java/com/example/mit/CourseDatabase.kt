package com.example.mit

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class CourseDatabase (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "course_database"
        private const val DATABASE_VERSION = 1

        private const val TABLE_NAME = "courses"
        private const val COLUMN_CODE = "code"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_CREDITS = "credits"
        private const val COLUMN_PREREQS = "prerequisites"
        private const val COLUMN_DESCRIPTION = "description"

        private const val CREATE_TABLE = "CREATE TABLE $TABLE_NAME (" +
                "$COLUMN_CODE TEXT PRIMARY KEY, " +
                "$COLUMN_NAME TEXT, " +
                "$COLUMN_CREDITS INTEGER, " +
                "$COLUMN_PREREQS TEXT, " +
                "$COLUMN_DESCRIPTION TEXT" +
                ")"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE)

        // Insert sample data
        val courseList = listOf(
            Course(
                "IT101",
                "Introduction to Information Technology",
                3,
                "",
                "An introduction to the field of information technology."
            ),
            Course(
                "IT102",
                "Programming I",
                3,
                "",
                "An introduction to programming using a high-level language."
            ),
            Course(
                "IT201",
                "Database Management Systems",
                3,
                "IT102",
                "An introduction to database management systems."
            ),
            Course("IT202", "Web Development I", 3, "IT102", "An introduction to web development."),
            Course(
                "IT301",
                "Networking and Security",
                3,
                "IT201",
                "An introduction to networking and security."
            ),
            Course("IT302", "Programming II", 3, "IT102", "Advanced programming concepts."),
            Course(
                "IT401",
                "Mobile App Development",
                3,
                "IT202",
                "An introduction to mobile app development."
            ),
            Course("IT402", "Web Development II", 3, "IT202", "Advanced web development concepts."),
            Course("IT501", "Capstone Project I", 3, "IT302", "Part 1 of the capstone project."),
            Course("IT502", "Capstone Project II", 3, "IT501", "Part 2 of the capstone project.")
        )
        for (course in courseList) {
            val values = ContentValues().apply {
                put(COLUMN_CODE, course.code)
                put(COLUMN_NAME, course.name)
                put(COLUMN_CREDITS, course.credits)
                put(COLUMN_PREREQS, course.prerequisites)
                put(COLUMN_DESCRIPTION, course.description)
            }

            db?.insert(TABLE_NAME, null, values)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    @SuppressLint("Range")
    fun getAllCourses() {
        val courseList = mutableListOf<Course>()

        val query = "SELECT * FROM $TABLE_NAME"
        val db = readableDatabase
        val cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                val code = cursor.getString(cursor.getColumnIndex(COLUMN_CODE))
                val name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
                val credits = cursor.getInt(cursor.getColumnIndex(COLUMN_CREDITS))
                val prerequisites = cursor.getString(cursor.getColumnIndex(COLUMN_PREREQS))
                val description = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION))
                // Do something with the retrieved data, such as adding it to a list or displaying it in a view
            }  while (cursor.moveToNext())
        }
    }
}