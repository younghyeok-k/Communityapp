# week2-2 03/20

# 북마크 적용하기
------------------------------

![image](https://user-images.githubusercontent.com/97229292/159151392-1ceded78-d91d-4b46-acde-f65c253fdb32.png)

realtimeDatabase 안에있는 저기 uid 값을 사용자마다 북마크를 누르면 저 uid 값을 저장해줄것이다


![image](https://user-images.githubusercontent.com/97229292/159153736-af1a4b44-7e71-47b7-b8d6-d2b30ef80155.png)

이런식으로 설계할 예정이다

1)   
### 데이터 모델을 만들고
![image](https://user-images.githubusercontent.com/97229292/159153688-93cec2cc-b406-49b0-bf59-56ff6b6924a9.png)

2)   
## 북마크를 클릭했을때
![image](https://user-images.githubusercontent.com/97229292/159154078-539e3a58-ecfe-4f8c-b210-cf442a2e6129.png)


3)
## 각uid 마다 북마크 표시

![image](https://user-images.githubusercontent.com/97229292/159153853-7d9a17f8-6d89-4df6-9ae4-73a35dc12fa1.png)



![image](https://user-images.githubusercontent.com/97229292/159153919-3598f971-4cb8-4eb3-8b79-6d41a2084ba9.png)

![image](https://user-images.githubusercontent.com/97229292/159157372-3e7ff27c-b946-44e9-866b-8c0727b7d77b.png)

-----------------------------------------
삭제할때 하나만 삭제되고 그다음 클릭했을때 삭제가 먹지않는 버그가 발생했다

![image](https://user-images.githubusercontent.com/97229292/159154252-8abb1d70-4b0d-4ac0-90c4-621a4a218820.png)


```
로그를 찍어서 확인해보니 데이터가 원래 하나만 늘어나야하는데 두번쨰줄 보면 2개나 늘어나있다
그래서 한번더 북마크를 클릭해서 로그를 확인해보았더니
```
![image](https://user-images.githubusercontent.com/97229292/159154303-0e33b257-a6b8-4dd6-8b59-7280122f3e1c.png)

이상하게 기존에 있던 데이터에서 쌓여있는거를 확인했다
그래서 북마크 데이터가 변경될때
![image](https://user-images.githubusercontent.com/97229292/159154357-6b3389d4-68fa-4b13-b55f-730c6d4b1fa4.png)
이부부분이 실행되는데 이부분에서 bookmakrIdlist.clear() 해줘야 쌓이지 않고 잘적용되는거를 확인할수가 있었다
![image](https://user-images.githubusercontent.com/97229292/159154416-ec0e0e38-df57-4c16-b56b-6ba16036bfbc.png)


![bookmark](https://user-images.githubusercontent.com/97229292/159155275-12f4786e-330a-4580-8c67-cd7d78092382.gif)

