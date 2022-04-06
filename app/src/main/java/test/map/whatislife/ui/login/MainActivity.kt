package test.map.whatislife.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import test.map.whatislife.ui.memory.MemoryActivity
import test.map.whatislife.databinding.ActivityMainBinding
import test.map.whatislife.ui.register.RegisterActivity

class MainActivity : AppCompatActivity() {

    private var mainBinding: ActivityMainBinding? = null
    private val binding get() = mainBinding!!

    private var auth : FirebaseAuth? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

//        binding.loginButton.setOnClickListener {
//            initLogin(binding.idEditText.text.toString(), binding.passwordEditText.text.toString())
//        }

        binding.loginButton.setOnClickListener {
            val intent = Intent(this , MemoryActivity::class.java)
            startActivity(intent)
        }




    }

    private fun initLogin(email:String , password:String) {
        if(email.isNotEmpty() && password.isNotEmpty()){
            auth?.signInWithEmailAndPassword(email, password)
                ?.addOnCompleteListener(this){ task->
                    if(task.isSuccessful){
                        Toast.makeText(this , "로그인 성공",Toast.LENGTH_SHORT).show()
                        autoLogin(auth?.currentUser)
                    }else{
                        Toast.makeText(
                            this, "로그인에 실패 하였습니다.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }

    private fun autoLogin(user : FirebaseUser?){
        if(user!=null){
            val intent = Intent(this, MemoryActivity::class.java)
            startActivity(intent)
        }
    }

}