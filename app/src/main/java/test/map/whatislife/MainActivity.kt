package test.map.whatislife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import test.map.whatislife.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mainBinding: ActivityMainBinding? = null
    private val binding get() = mainBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}