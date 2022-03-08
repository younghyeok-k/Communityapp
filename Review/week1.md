# Review 
## week1 

-------------------------------------------------
# 프로젝트

안드로이드 ,코틀린 ,파이어베이스

------------------------------
## 해볼것
- 웹에 있는 컨텐츠 불러오기
- 컨텐츠 북마크
- 회원가입/로그인/비회원로그인
- 게시글 생성/수정/삭제/읽기

-----------------------------
## 파이어베이스를 사용하는 이유

### 기존서버방식

![서버 안드로이드 연동시](https://user-images.githubusercontent.com/97229292/157240023-07f24c6a-e2ab-4821-a7c8-3af0ad8b1379.JPG)


회원가입 시 아이디 비밀번호를 입력하면 서버에 적은 아이디와 비밀번호를 넘겨준다
그러면 서버에서 데이터베이스로 적은 아이디와 비밀번호가 기존에 있는지 확인해 주거나 없으면 저장해 주고 
그렇게 넘어가면 Token(인증값) 을 줘서  로그인이나 회원가입을 시켜준다 
토큰 값으로 유저를 판별해서 그사람이 쓴 게시물  등을 확인할 수 있다.

### 파이어베이스를 이용한 방식
![image](https://user-images.githubusercontent.com/97229292/157241360-acd9a927-e2d6-4d97-8023-0cb6ceaac6c3.png)

파이어베이스를 이용하여
인증 (회원가입,로그인)/데이터베이스 저장 /이미지 저장)


