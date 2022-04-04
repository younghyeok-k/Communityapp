# week4-3

## 자신이 쓴글만 수정삭제가능하도록 
---------------------------------------
```
게시글을 클릭하면 연필모양 아이콘이 나오는데 수정버튼이다
저버튼이 자신만 수정 삭제할수있게 나오도록 하려고한다

```
![image](https://user-images.githubusercontent.com/97229292/161533005-26bdef2e-141e-4a02-810a-af4bc5bd94bb.png)

## 버튼 invisible
![image](https://user-images.githubusercontent.com/97229292/161533169-6bfed6bb-b677-4b8d-a3ff-ee83074f348d.png)
## BoardinsideAcitivity.kt
![image](https://user-images.githubusercontent.com/97229292/161534286-625dae22-1ea5-499d-bb38-2e34483acfd4.png)
## BoardListRVAdapter.kt
![image](https://user-images.githubusercontent.com/97229292/161536740-3984e98c-78cc-406d-afb8-5cd49cb3b1d2.png)

```
로그인한 uid 값과 데이터 모델의 uid 값이맞으면 보이도록 하였다 자신의글에는 색도 넣어보았다
```

![게시글 내글](https://user-images.githubusercontent.com/97229292/161537988-7d1ad923-a27a-4ff3-9abe-a10d251966f9.gif)

-----------------------------------------------

```
위아래로 리스트뷰를 움직이다보니 버그가생긴다 색이 그냥 전염? 되는거같다
찾아보니깐 리스트뷰를 재활용 해서 생기는 버그였다
방법은 너무나 많았다 그중하나로 null 값을 해제하니깐 되었다
```
![image](https://user-images.githubusercontent.com/97229292/161537444-36b0c93d-bd66-4862-8221-e703b84ea12e.png)

