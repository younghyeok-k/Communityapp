### week8-1

## 로그인 UI 변경
--------------------------
#### 로그인 액티비티랑 인트로 액티비티를 하나로 만드는게좋아보여 변경하였다
### IntoActivity
![image](https://user-images.githubusercontent.com/97229292/167410661-c90105e2-3bf4-4d74-87a2-89b05b1e42fa.png)
### LoginActivity
![image](https://user-images.githubusercontent.com/97229292/167410791-0d9bfec8-6599-4847-b136-1dd947822261.png)


### 인트로액티비티에 있는 것을 다한번에 로그인 액티비티에넣었다

## 코드
![image](https://user-images.githubusercontent.com/97229292/167428633-d03ec324-3fe6-45e3-8c3b-aa76de3298e5.png)
![image](https://user-images.githubusercontent.com/97229292/167428674-99adef3d-1844-4fb3-a183-29ea3b49ba51.png)

### UI
![image](https://user-images.githubusercontent.com/97229292/167428561-bf56e5d9-eefc-4d96-8587-54eb89d098e2.png)


### 비밀번호찾기
-----------------------------
https://gist.github.com/rlarla245/8efe503562dddc91a62478b740ff6630
```
Firebase 비밀번호 찾기
// 이메일을 통해 비밀번호를 재설정합니다. 찾는 것을 불가능합니다.
// 비밀번호를 찾는 버튼을 생성합니다. -> 새로운 액티비티를 생성합니다.(이메일을 통해 비밀번호를 재설정 할 수 있도록 합니다.) -> 다이얼로그 처리해도 좋을 듯 합니다.
1. 비밀번호 재설정 메소드를 새로운 액티비티에 입력합니다.
fun findPassword() {
	FirebaseAuth.getInstance().sendPasswordResetEmail(editText_email.text.toString())
		.addOnCompleteListener {	task ->
		if (task.isSuccessful) {
			Toast("재설정 메일을 보냈습니다.")
		} else {
			Toast(task.getException)
		}
	}
}

2. 버튼을 통해 메소드를 실행합니다.

3. 로그인 액티비티의 버튼을 누를 경우 액티비티를 넘겨줘야 합니다.
4. 마찬가지로 템플릿 변경을 통해 내용을 수정할 수 있습니다.
* 스팸 리스트가 적기 때문에 메시지도 수정 가능합니다.
```
![image](https://user-images.githubusercontent.com/97229292/167446366-5a48fc75-20ae-44ed-93c3-20d7e14b07c9.png)
![image](https://user-images.githubusercontent.com/97229292/167446498-c39ab48d-cf08-470e-bc21-7b71ae2143ec.png)
![image](https://user-images.githubusercontent.com/97229292/167446901-97d9bcb9-c09d-4b0b-8158-92d2fafaff06.png)
![image](https://user-images.githubusercontent.com/97229292/167446955-0fb5c474-4945-4165-b40b-9fe7229c65bc.png)




