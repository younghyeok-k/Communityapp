# week4-1

## 게시글 삭제/수정
-----------------


### 게시글 삭제



삭제하기는 쉽다 앞에 게시글의 만든 키값을 받아와 삭제하면 된다

![image](https://user-images.githubusercontent.com/97229292/161026934-6d81b28f-c855-4c96-b041-0de71a8c06f9.png)


## 게시글  삭제 test

![게시판글쓰기test4](https://user-images.githubusercontent.com/97229292/161028907-83b7e365-214f-4f59-8176-7dba19ce9943.gif)



## 게시글 수정

---------------------
```
게시글 수정은 BoardinsideActivity.kt 에서  BoardeditActivity.kt 로 Intent 하여 넘어가면서  putExtra 를 통해
게시글 쓸때만들어지는 key 값을 똑같이 넘겨주어 BoardEdietActiviy.kt 에서 getExtra 로 받아오려고한다.
```

![image](https://user-images.githubusercontent.com/97229292/161055045-0993cf89-7ea6-45a6-aa86-23dedfd3ae30.png)

![image](https://user-images.githubusercontent.com/97229292/161055166-6149d582-5a42-4860-9986-2aceb6fcc49b.png)

```

그리고 게시글의 기존에있던 제목 내용일 받아오기위해 앞에서썻던 getBoarddata()를 key값으로 받아오고
똑같이 이미지도 getImageData() 도 받아온다 그렇게하면 기존에 있던 제목 내용들이 잘받아져온다
```

![image](https://user-images.githubusercontent.com/97229292/161055570-920bd025-cfb4-47a5-9a5f-837f5a9d3e4e.png)
![image](https://user-images.githubusercontent.com/97229292/161055618-0c433295-5e22-4e34-8419-4441a7a3ba7e.png)

```
게시글 수정 버튼을 누르면 원래있던 데이터베이스에 덮어씌우기위해 editBoardata()를 만들어 데이터값을 넣어준다
이미지도 앞에서했던 imageupload() 함수를 이용하여 게시글의 키값을 이용하여 이미지도 새롭게 넣어줄수있다.
```
![image](https://user-images.githubusercontent.com/97229292/161056426-7721e569-23e4-42c3-bcd5-10b0ed4a7755.png)


## 게시글  수정 test
![게시판글쓰기test5](https://user-images.githubusercontent.com/97229292/161057167-eeb1dcc2-1327-404d-bd6e-29f6705f9e16.gif)

