package com.example.mit

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FacultyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faculty)

        // Initialize the list of faculty members with their photo images
        val facultyList = listOf(
            FacultyMember( R.drawable.professor,"John Doe", "123-456-7890", "jdoe@ucc.edu"),
            FacultyMember(R.drawable.lecturer"Jane Smith", "234-567-8901", "jsmith@ucc.edu"),
            FacultyMember(R.drawable.assist_professor"Bob Johnson", "345-678-9012", "bjohnson@ucc.edu")
        )

        // Set up the RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.facultyRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = FacultyAdapter(facultyList)
    }
}

data class FacultyMember(val photo: Int, val name: String, val phone: String, val email: String)

class FacultyAdapter(private val facultyList: List<FacultyMember>) :
    RecyclerView.Adapter<FacultyAdapter.FacultyViewHolder>() {

    class FacultyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photoImageView: ImageView = itemView.findViewById(R.id.facultyPhotoImageView)
        val nameTextView: TextView = itemView.findViewById(R.id.facultyNameTextView)
        val phoneTextView: TextView = itemView.findViewById(R.id.facultyPhoneTextView)
        val emailTextView: TextView = itemView.findViewById(R.id.facultyEmailTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacultyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_faculty, parent, false)
        return FacultyViewHolder(view)
    }

    override fun onBindViewHolder(holder: FacultyViewHolder, position: Int) {
        val facultyMember = facultyList[position]
        holder.photoImageView.setImageResource(facultyMember.photo)
        holder.nameTextView.text = facultyMember.name
        holder.phoneTextView.text = facultyMember.phone
        holder.emailTextView.text = facultyMember.email

        // Set up click listeners for the phone and email buttons
        holder.phoneTextView.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${facultyMember.phone}"))
            holder.itemView.context.startActivity(intent)
        }

        holder.emailTextView.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:${facultyMember.email}")
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return facultyList.size
    }
}
