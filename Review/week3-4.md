# week3-4


## 이미지 업로드 추가

---------------------------------



### AndroidManifest.xml

```
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>   --> 추가
```

### BoardwriteActivity.kt

![image](https://user-images.githubusercontent.com/97229292/160844031-fda045a5-ab64-4945-812a-ce2486ab85e1.png)


## 파이어베이스 Storage
----------------------------
```
Firebase Android BoM을 사용하여 모듈(앱 수준) Gradle 파일(일반적으로 app/build.gradle)에서
Cloud Storage Android 라이브러리의 종속 항목을 선언.
```
![image](https://user-images.githubusercontent.com/97229292/160848726-35d9457a-8d62-475b-8d9b-89ad05156e60.png)
```
Cloud Storage 버킷에 액세스하는 첫 단계는 FirebaseStorage 인스턴스를 만드는 것입니다

```
![image](https://user-images.githubusercontent.com/97229292/160849138-e45e859f-5fda-40f8-9d1d-08a2d1f4de48.png)


```
파일업로드
Cloud Storage에 파일을 업로드하려면 우선 파일 이름을 포함하여 파일의 전체 경로를 가리키는 참조를 만듭니다
```

![image](https://user-images.githubusercontent.com/97229292/160849374-6a2395f3-228a-4585-b438-bc52177aa0c1.png)


```
메모리 데이터에서 업로드
putBytes() 메서드는 Cloud Storage에 파일을 업로드하는 가장 간단한 방법입니다. 
putBytes()는 byte[]를 취하고 UploadTask를 반환하며 이 반환 객체를 사용하여 업로드를 관리하고 상태를 모니터링할 수 있습니다.
```
![image](https://user-images.githubusercontent.com/97229292/160849555-f2312a61-b3d4-45b9-a560-8d480e457c22.png)


```
파이어베이스 storage 에 이미지를 저장하고 싶습니다
만약에 내가 게시글을 클릭했을 때, 게시글에 대한 정보를 받아와야하는데
이미지 이름에 대한 정보를 모르기 때문에
이미지 이름을 문서의 key값을 해줘서 이미지에 대한 정보를 찾기쉽게 해야한다
val key=FBRef.boardRef.push().key.toString()
값으로 키값을 받아아와서 push() 에서 child(key) 값을 바꾸면된다

``  

![image](https://user-images.githubusercontent.com/97229292/160852662-f273c4ee-e51d-4891-8671-cbf0850f64ec.png)

![image](https://user-images.githubusercontent.com/97229292/160852909-2cd6bfc3-477e-4c3d-b2ef-ef6390ff905c.png)

![image](https://user-images.githubusercontent.com/97229292/160852796-e216b6f5-5213-4ae3-98ff-e79d6d170025.png)


 
            

