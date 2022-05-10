### week8-2

## 댓글삭제
--------------------
### 1)CommentModel.kt
![image](https://user-images.githubusercontent.com/97229292/167650912-1d8300bc-a7a3-446a-aa94-1673b813ae03.png)

### 2)내가쓴 댓글만 삭제표시가 보이도록
![image](https://user-images.githubusercontent.com/97229292/167651047-90ee4b37-d8c0-4f68-beae-d259cb334d9e.png)
![image](https://user-images.githubusercontent.com/97229292/167651291-077c5ead-9efc-4180-ad0b-7a85679d0c0a.png)


### 3)
```
리스트뷰에서 클릭이벤트 처리방법은 리사클러뷰 클릭이벤트 처리방법과 달라 찾아봤다
```
https://mechacat.tistory.com/7
### 이런식으로 작동한다
![image](https://user-images.githubusercontent.com/97229292/167652152-776c0846-dded-4b94-9021-ecee2f8ebcaa.png)
```
class ListAdapter(val itemList: ArrayList<ListItem>): RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        // (1) 리스트 내 항목 클릭 시 onClick() 호출
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
    }
    // (2) 리스너 인터페이스
    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }
    // (3) 외부에서 클릭 시 이벤트 설정
    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }
    // (4) setItemClickListener로 설정한 함수 실행
    private lateinit var itemClickListener : OnItemClickListener
```
### 적용
![image](https://user-images.githubusercontent.com/97229292/167652397-8066bc7d-6030-4324-96f8-30eccb70740c.png)


### BoardinsideActivity.kt
```
삭제할때 보드키밑에 댓글키를 삭제하여야해서
 commentkeylist를 만들어 getCommentData()에서 추가하여 삭제하였다
```
![image](https://user-images.githubusercontent.com/97229292/167653041-b2eeeafd-50f3-4f8c-810d-44e255637958.png)
![image](https://user-images.githubusercontent.com/97229292/167653149-64903961-8d85-4150-ad2f-5271531dc64f.png)

### 액티비티에서 리시트뷰 처리
![image](https://user-images.githubusercontent.com/97229292/167653231-20efc968-f4d4-48a4-89a3-7fa4359d732f.png)



