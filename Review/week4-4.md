# week4-4


## 댓글 만들기 
------------------------------
### 1) 데이터 구조
![image](https://user-images.githubusercontent.com/97229292/161796797-88ab53c1-6d72-4e27-8bb9-b3ae59e1634b.png)

### 2)CommentModel 데이터 만들기
![image](https://user-images.githubusercontent.com/97229292/161797287-4b759ac6-be57-417d-a9b9-4e3418817290.png)

```
comment 에 게시글의 키값을 이용하여 넣고 게시글을 작성하여 넣을때 
새로운 댓글의 키값을 넣어서 그안에 댓글,시간,id 값을 넣을 예정이다

```

### 3)insertComment (댓글 입력할때 데이터에 넣기)
![image](https://user-images.githubusercontent.com/97229292/161797460-b8d63e06-4910-4170-ac9a-8751262290ce.png)


## 댓글 읽어오기
-----------------------------------
```
Listview 를 만들어서 댓글의 item_layout 을 따로만들어 Adapter 를 생성한뒤 BoardinsideAcivity.kt 에 연결할 예정이다

```
### 1) Listview 만들기
![image](https://user-images.githubusercontent.com/97229292/161797853-9d991c2e-f06c-4ecd-81d7-921c61bfee74.png)
![image](https://user-images.githubusercontent.com/97229292/161798039-75141ae9-88d5-4626-a722-3857bb72efc6.png)

### 2) Adpater 만들기

![image](https://user-images.githubusercontent.com/97229292/161798142-781eb09b-ba87-4134-a11f-dea7fbcc3e79.png)

### 3) Adapter 연결하기
![image](https://user-images.githubusercontent.com/97229292/161798279-67617f20-9866-4aa2-8ce0-8713f30ac7c3.png)

### 4) 데이터읽어오기 getCommentData()

![image](https://user-images.githubusercontent.com/97229292/161798385-372b0471-670b-4338-a930-7703a31e41f8.png)



![image](https://user-images.githubusercontent.com/97229292/161798212-1856343a-24c4-40cc-a58f-e17956842a6a.png)

## 실행결과
---------------

