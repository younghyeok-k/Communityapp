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

signInWithEmailAndPassword 메서드를 사용하여    
 이메일 주소와 비밀번호를 가져와 유효성을 검사한 후 사용자를 로그인시키는 새 signIn 메서드를 만들이어한다
 
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
 

## Android에서 익명으로 Firebase에 로그인
 
 ------------------------------------------
로그인한 사용자의 linkWithCredential 메서드에 AuthCredential 객체를 전달합니다.
 
 ```
 auth.currentUser!!.linkWithCredential(credential)
        .addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                Log.d(TAG, "linkWithCredential:success")
                val user = task.result?.user
                updateUI(user)
            } else {
                Log.w(TAG, "linkWithCredential:failure", task.exception)
                Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                updateUI(null)
            }
        }
 ```
  
 
 ## User로그인 확인방법
 -------------------------------
 User 가 로그인 되어있다가 나갔다와도 로그인 상태를 유지시킴
 
![image](https://user-images.githubusercontent.com/97229292/158060723-f18524d4-d2e0-4cf5-abd6-d7f932f8e271.png)
 
 
 
 ## Android Navigation
 -------------------------------------------
 
 ```
 
  val nav_version = "2.4.1"
  implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
  implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
 
 ```
 
 
 ##  Android LinearLayout split smae size
 -------------
 프레그먼트로 아이콘을 하단바에 정렬하려고했는데
 같으사이즈로 정렬이 하기어려워 찾아봤더니
 ![image](https://user-images.githubusercontent.com/97229292/158065629-119c58bd-d4d3-49bb-8d0a-1988c4848a74.png)
 
 
 ```
  android:layout_weight="1"
 ```
 를 하나씩 다적용하면 사이즈에 맞게 정렬된다
 
 ![image](https://user-images.githubusercontent.com/97229292/158065660-43729845-4a72-42be-b025-5d9b928374d2.png)


 ![image](https://user-images.githubusercontent.com/97229292/158065699-f067cf3f-e8de-413c-bd3f-f05159359f1e.png)

 
 
 

