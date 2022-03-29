# week3-3 

## 글읽어오기


-----------------------------------------------


### 1) 파이어베이스 데이터 읽어오기

![image](https://user-images.githubusercontent.com/97229292/160622038-35078aa8-185b-4574-afed-3ade5a573e9e.png)

### 2) 리스트뷰에 넣기

![image](https://user-images.githubusercontent.com/97229292/160622778-755f1daf-86be-4c48-a2b1-43c234c37cfc.png)


### 3) 확인

![image](https://user-images.githubusercontent.com/97229292/160623800-8509ae52-dd3f-456d-b5c5-e14523152a88.png)


### 글 클릭했을때 Boardinside 에서 화면 출력
--------------------------------

### 첫번째 방법으로는 listview에 있는 데이터 title content time 다 다른 액티비티로 전달해줘서 만들기
### 두번째 방법으로는 Firebase에 있는 board에 대한 데이터의 id를 기반으로 다시 데이터를 받아오는 방법


### 첫번째 방법
------------------------------------------
### 1)TalkFragment.kt

![image](https://user-images.githubusercontent.com/97229292/160628969-a62592fb-3241-4c14-8430-15f2499bfb51.png)

### 2)BoardinsideActivity.kt

![image](https://user-images.githubusercontent.com/97229292/160629110-28a532b1-8471-4549-8c19-8c9565485273.png)



### 두번째 방법
------------------------------------------
### 1)TalkFragment.kt
![image](https://user-images.githubusercontent.com/97229292/160632236-1bd3dd6f-3e17-4d4b-b8c5-90120fe42dd8.png)


### getFBBoardData()
![image](https://user-images.githubusercontent.com/97229292/160632354-0f989f9c-20f4-472f-b37e-db7af9ff95c1.png)


![image](https://user-images.githubusercontent.com/97229292/160632450-36ce7886-0a75-485f-9457-6d3dea03f81d.png)


### 2)BoardinsideActivity.kt

![image](https://user-images.githubusercontent.com/97229292/160632589-2a5a7eb2-3be6-4272-ba19-3daedae9b9c9.png)


## 실행결과
-----------------------
![게시판글쓰기test2](https://user-images.githubusercontent.com/97229292/160635592-94148bbf-7320-4995-8f61-becc57f54e81.gif)


