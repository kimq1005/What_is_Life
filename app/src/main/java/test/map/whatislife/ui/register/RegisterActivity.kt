package test.map.whatislife.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import test.map.whatislife.Utils.Companion.TAG
import test.map.whatislife.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private var registerBinding: ActivityRegisterBinding? = null
    private val binding get() = registerBinding!!

    private var auth : FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        val editemail = binding.idEditText.text.toString()
        val password = binding.passwordEditText.text.toString()

        binding.joinButton.setOnClickListener {
            createAccount(binding.idEditText.text.toString(), binding.passwordEditText.text.toString())

        }

    }

    private fun initregister(email: String, password: String) {
        auth!!.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "회원가입이 완료 되었습니다.", Toast.LENGTH_SHORT).show()


                } else {
                    Toast.makeText(this, "회원가입을 다시 해주세요.", Toast.LENGTH_SHORT).show()
                }
            }

            .addOnFailureListener {
                Toast.makeText(this, "회원가입을 다시 해주세요.", Toast.LENGTH_SHORT).show()
            }
    }


    private fun createAccount(email: String, password: String) {

        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth?.createUserWithEmailAndPassword(email, password)
                ?.addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            this, "계정 생성 완료.",
                            Toast.LENGTH_SHORT
                        ).show()
                        finish() // 가입창 종료
                    } else {
                        Toast.makeText(
                            this, "계정 생성 실패",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }


}