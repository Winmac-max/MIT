import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.mit.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageViewFaculty = findViewById<ImageView>(R.id.imageViewFaculty)
        val textViewFaculty = findViewById<TextView>(R.id.textViewFaculty)
        imageViewFaculty.setImageResource(R.drawable.ic_faculty)
        textViewFaculty.text = getString(R.string.faculty_staff_directory)

        val imageViewCourses = findViewById<ImageView>(R.id.imageViewCourses)
        val textViewCourses = findViewById<TextView>(R.id.textViewCourses)
        imageViewCourses.setImageResource(R.drawable.ic_courses)
        textViewCourses.text = getString(R.string.courses)

        val imageViewAdmissions = findViewById<ImageView>(R.id.imageViewAdmissions)
        val textViewAdmissions = findViewById<TextView>(R.id.textViewAdmissions)
        imageViewAdmissions.setImageResource(R.drawable.ic_admissions)
        textViewAdmissions.text = getString(R.string.admissions)

        val imageViewSocialMedia = findViewById<ImageView>(R.id.imageViewSocialMedia)
        val textViewSocialMedia = findViewById<TextView>(R.id.textViewSocialMedia)
        imageViewSocialMedia.setImageResource(R.drawable.ic_social_media)
        textViewSocialMedia.text = getString(R.string.social_media)
    }
}
