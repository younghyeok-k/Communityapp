# week6-3
## 비밀번호 변경하기
------------------------------------------
### 요구사항
#### - 변경하기전 비밀번호 입력받기
#### - 익명로그인 이용불가
   
    
    
    
![image](https://user-images.githubusercontent.com/97229292/165749290-f683df3d-29f6-46a8-b10a-97d28146a009.png)
### ex)
```
    fun changePassword(password:String){
        FirebaseAuth.getInstance().currentUser!!.updatePassword(password).addOnCompleteListener { task ->
            if(task.isSuccessful){
                Toast.makeText(this, "비밀번호가 변경되었습니다.", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, task.exception.toString(), Toast.LENGTH_LONG).show()

            }
        }
    }
    ```
## passwordchangeActivity  
------------------------
    ```
    package com.example.communityapp.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.example.communityapp.R
import com.example.communityapp.board.BoardEditActivity
import com.example.communityapp.databinding.ActivityLoginBinding
import com.example.communityapp.databinding.ActivityPasswordChangeBinding
import com.example.communityapp.utills.FBRef
import com.google.firebase.auth.FirebaseAuth

class PasswordChangeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPasswordChangeBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var rpassword1:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_change)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_password_change)


        binding.passwdchange.setOnClickListener {
            var isGoToJoin = true
            val realpassword1=binding.rpassword.text.toString()

            val password1 = binding.newpasswordArea1.text.toString()

            val password2 = binding.newpasswordArea2.text.toString()


            if (password1.isEmpty()) {
                Toast.makeText(this, "패스워드를 입력해주세요", Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            }

            if (password2.isEmpty()) {
                Toast.makeText(this, "패스워드를 확인해주세요", Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            }

            if (!password1.equals(password2)) {
                Toast.makeText(this, "비밀번호를 똑같이 입력해주세요", Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            }

            if (password1.length < 6) {
                Toast.makeText(this, "비밀번호를 6자리 이상 입력해주세요", Toast.LENGTH_SHORT).show()
                isGoToJoin = false
            }
            if (isGoToJoin == true) {
                changePassword(password1)

            }

        }
    }

    fun changePassword(password:String) {
        FirebaseAuth.getInstance().currentUser!!.updatePassword(password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "비밀번호가 변경되었습니다.", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, task.exception.toString(), Toast.LENGTH_LONG).show()
                Log.d("password",task.exception.toString())
                }
            }
    }


}

    ```
    
    ```
    업데이트가 안된다 더찾아서 해봐야할거같다
    ```
    
