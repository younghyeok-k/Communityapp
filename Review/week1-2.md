#  week1-2 3/12


# 파이어 베이스 설정
-------------------------------------------------
### 1)google-services.json 파일을 Android 앱 모듈 루트 디렉터리로 이동시킨다


### 2)플러그인을 사용하려면 build.gradle(project) 파일 수정

```
buildscript {
  repositories {
    // Check that you have the following line (if not, add it):
    google()  // Google's Maven repository

  }
  dependencies {
    ...
    // Add this line
    classpath 'com.google.gms:google-services:4.3.10'

  }
}

allprojects {
  ...
  repositories {
    // Check that you have the following line (if not, add it):
    google()  // Google's Maven repository

    ...
  }
}
```

### 3)앱 수준의 build.gradle
```
apply plugin: 'com.android.application'

// Add this line
apply plugin: 'com.google.gms.google-services'


dependencies {
  // Import the Firebase BoM
  implementation platform('com.google.firebase:firebase-bom:29.2.0')


  // Add the dependency for the Firebase SDK for Google Analytics
  // When using the BoM, don't specify versions in Firebase dependencies
  implementation 'com.google.firebase:firebase-analytics-ktx'


  // Add the dependencies for any other desired Firebase products
  // https://firebase.google.com/docs/android/setup#available-libraries
}


```
### 4) Authentication (인증기능)
### 이메일 /익명 기능 사용 설정   
![image](https://user-images.githubusercontent.com/97229292/158053578-1c0cb569-5c3c-490a-b949-446cd8825a84.png)


### 5) Firebase auth android

```
dependencies {
    // Import the BoM for the Firebase platform
    implementation platform('com.google.firebase:firebase-bom:29.1.0')

    // Declare the dependency for the Firebase Authentication library
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation 'com.google.firebase:firebase-auth-ktx'
}
```

### 6) 현재 인증상태 확인

   1.FirebaseAuth의 인스턴스를 선언합니다.
   
   ```
   private lateinit var auth: FirebaseAuth
   ```
   2.onCreate() 메서드에서 FirebaseAuth 인스턴스를 초기화합니다.
   
   ```
   auth = Firebase.auth
   ```
   3.활동을 초기화할 때 사용자가 현재 로그인되어 있는지 확인합니다.
   ```
   public override fun onStart() {
    super.onStart()
    // Check if user is signed in (non-null) and update UI accordingly.
    val currentUser = auth.currentUser
    if(currentUser != null){
        reload();
    }
   }
```



# 회원가입 
-------------------------------------------------
### 1) 신규 사용자가입


```
auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(TAG, "createUserWithEmail:success")
                val user = auth.currentUser
                updateUI(user)
            } else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "createUserWithEmail:failure", task.exception)
                Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                updateUI(null)
            }
        }



```

---------------------------------------
## 적용해보았을때
![image](https://user-images.githubusercontent.com/97229292/158054984-0c0ae8c9-7cc3-460b-b617-d3414bfea5a7.png)


![image](https://user-images.githubusercontent.com/97229292/158054101-95f2f58e-309a-4828-9db4-9f2c53c380f9.png)


--------------------------------------
## Intent
회원가입을 하면 MainActivity 로 넘어가게 해놓았는데 사용자가 일부로 뒤로가기 하면 다시
회원가입 페이지가 나오게 되는데 그거를 방지하기위해 

![image](https://user-images.githubusercontent.com/97229292/158054682-f84f42fc-f508-4abe-9c47-9d5d73b9ddad.png)


  ↓↓↓↓
![image](https://user-images.githubusercontent.com/97229292/158054697-c3bdb66c-664a-4dd0-827f-a85f420f9e64.png)


```

 intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
```
남아있던 기존 액티비티를 다날리는방법이다.








