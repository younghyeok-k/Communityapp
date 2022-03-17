# week 2-1 03/17


# RecyclerView 
-------------------
### 컨텐츠리스트를 넘겨서 화면에 나오게 하려고한다 

![image](https://user-images.githubusercontent.com/97229292/158746394-adaab2e1-fce8-4a99-a1dc-6e516ff0d69d.png)


이런식으로 넘어가는데 



## 과정

### 1)에서 itmes.add("a") 3개를 넣어 ContentRVAdapter 로 넘겨주고   
![image](https://user-images.githubusercontent.com/97229292/158746536-344eb4a9-a3cb-4aa8-af89-f8b1772a41f6.png)
### 2)하나하나 아이템을 넣어  acitivty.xml (Rv) 에넘겨줘서 화면에 나오게한다
![image](https://user-images.githubusercontent.com/97229292/158746751-06f07121-483b-458d-ba15-236e959f5f0f.png)
### 3)
![image](https://user-images.githubusercontent.com/97229292/158746897-187c064b-4ab2-4e1e-a020-8c93742d3a75.png)

### 4)   
![image](https://user-images.githubusercontent.com/97229292/158746969-922b1fe0-5a49-47be-ba8a-60d34c3d99b5.png)




### 이런 방식으로 데이터모델을 넘길 생각이다 그러기 위해 데이터베이스를 이용해야 하고 그리고
### 이미지 링크 주소 와 사이트 주소를 받아와서 타이틀과 함께 데이터베이스에 넣고
### 각 아이콘을 클릭했을 때 거기에 맞는 사진과 주소창이 열릴 수 있도록 만들어야 한다.
### 데이터베이스에서 외부의 이미지를 불러와서 안드로이드로 띄우기 위해서는 Glide라이브러리를 사용해야 한다



## RecyclerView 클릭 처리
--------------------------------------------
RecyclerView 는 이미지가 클릭처리를 따로 만들어줘야한다.
![image](https://user-images.githubusercontent.com/97229292/158822187-0eca75c4-1a5d-4768-9235-a0088b501fc7.png)

![image](https://user-images.githubusercontent.com/97229292/158822391-bf9e1c61-7ad1-4929-99c9-5a3cf992591d.png)

![image](https://user-images.githubusercontent.com/97229292/158823156-05bd7c62-5ccf-48d9-8346-28fbd1f9ea48.png)

클릭했을때 ContentshowActivity 로 넘어가게 만든것이다.


#Realtime database 이용방법
-----------

## 1) 앱에 실시간 데이터베이스 SDK 추가
---------------------------------------------------
![image](https://user-images.githubusercontent.com/97229292/158809399-17118863-e226-480c-a948-cdc16c7f842b.png)

## 2) 데이터베이스에 쓰기
getInstance()를 사용하여 데이터베이스의 인스턴스를 검색하고 쓰려는 위치를 참조합니다.   
![image](https://user-images.githubusercontent.com/97229292/158809900-6306f821-2f8d-4764-b94b-7e6d225c6dae.png)


## 3) 데이터 읽기
경로에서 데이터를 읽고 변경사항을 수신 대기하려면 addValueEventListener() 메서드를 사용하여 DatabaseReference를 ValueEventListener에 추가해야 합니다.   
![image](https://user-images.githubusercontent.com/97229292/158811844-84cdbb47-2d43-49c9-9d87-46209f93ebec.png)


# Glide(이미지 로딩 라이브러리)
------------------------------------------
https://github.com/bumptech/glide

![image](https://user-images.githubusercontent.com/97229292/158824522-b1f78f66-c701-4059-9694-475fd3de50c9.png)


```
AndroidManifest.xml

<uses-permission android:name="android.permission.Internet"/> -> 추가
```
![image](https://user-images.githubusercontent.com/97229292/158826229-9a527073-76c0-4941-a31b-5c0d2b98f616.png)

![image](https://user-images.githubusercontent.com/97229292/158826233-2e618a49-c858-46f9-bc5c-890831d65545.png)

