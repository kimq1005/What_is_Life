package test.map.whatislife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import test.map.whatislife.databinding.ActivityMainBinding
import test.map.whatislife.lifeContent_Package.LifeContentActivity

class MainActivity : AppCompatActivity() {

    private var mainBinding: ActivityMainBinding? = null
    private val binding get() = mainBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, LifeContentActivity::class.java)
        startActivity(intent)


    }
}