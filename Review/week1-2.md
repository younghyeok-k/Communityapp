#  week1-2 3/13


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
