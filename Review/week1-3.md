# week1-3 3/13

## Binding 사용법
-------------------------

###  1)
![image](https://user-images.githubusercontent.com/97229292/158057038-00095419-2b42-4c96-ac3d-c3092849fdd8.png)

### 2)
layout.xml 파일을 layout 형태로 묶어야한다


### 3)
Activity 파일
 ```
  private lateinit var binding: ActivityLoginBinding
  binding=DataBindingUtil.setContentView(this,R.layout.activity_login)
  // setContentView(R.layout.activity_main)
 ```
 
### 원래 기존방식  
--------------------------------------

```
    val add=findViewById<Button>(R.id.loginbtn)
```

계속해서 findViewById 를 써찾아야했다

### Binding 사용했을때 
--------------------------------------
findViewById<Button>(R.id.loginbtn) 를 사용할필요없이   
  
  
  
![image](https://user-images.githubusercontent.com/97229292/158057121-85048b21-9e3d-433f-a1fa-2a2d0735d65d.png)
  
  이런식으로 사용이가능하다   
  
  
## 기존 사용자 로그인
--------------------------------------

signInWithEmailAndPassword 메서드를 사용하여 이메일 주소와 비밀번호를 가져와 유효성을 검사한 후 사용자를 로그인시키는 새 signIn 메서드를 만들이어햐나다
 
 ```
 auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(TAG, "signInWithEmail:success")
                val user = auth.currentUser
                updateUI(user)
            } else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "signInWithEmail:failure", task.exception)
                Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                updateUI(null)
            }
        }
 ```
 

  
  
