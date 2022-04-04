package test.map.whatislife

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessaging
import test.map.whatislife.Utils.Companion.TAG
import test.map.whatislife.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mainBinding: ActivityMainBinding? = null
    private val binding get() = mainBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val intent = Intent(this, LifeContentActivity::class.java)
//        startActivity(intent)
        //github test

        callfirebase()

        Toast.makeText(this, " ${Build.VERSION_CODES.O}",Toast.LENGTH_SHORT).show()


    }

    private fun callfirebase() {

        FirebaseMessaging.getInstance().token
            .addOnCompleteListener { task->
                if(task.isSuccessful){
                    val token = task.result
                    binding.firebasetokenTextView.text = token
                    Log.d(TAG, "callfirebase: $token ")

                }
            }
    }
}