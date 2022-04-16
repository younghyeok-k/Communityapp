# week6-2


### 홈 콘텐츠 추가하기
----------------------------------------
#### xml상으로는 잘안보이지만 게시글 밑에 콘텐츠이미지들을 넣으려고한다

#### HomeFragement.xml
![image](https://user-images.githubusercontent.com/97229292/163676892-16c7cc5f-531d-4f70-8768-878a5792c69d.png)
![image](https://user-images.githubusercontent.com/97229292/163676916-ffe6ed54-c98a-40a5-945a-d3b2fe998df2.png)

![image](https://user-images.githubusercontent.com/97229292/163677075-2518ff95-c3c9-434a-b882-7e7d1c978c0d.png)

### HomeFragment.kt
#### 카테고리에있는 모든 콘텐츠를 가져오려고한다


![image](https://user-images.githubusercontent.com/97229292/163676972-6882750c-f8f5-40d1-8c88-684a3f25dd21.png)


#### HomeboardRVAdapter.kt 
![image](https://user-images.githubusercontent.com/97229292/163677058-2997f724-1578-49fa-90df-5658ff13be81.png)

![image](https://user-images.githubusercontent.com/97229292/163677088-5f37fab8-caef-4b9a-97ca-5b51cba19f16.png)


```
그리고 원래 recyclerview 를 쓰면 콘텐츠들이 스크롤을 이용하여 나오는데 스크롤없이 모든 이미지들이 무한대로 나왔으면 좋을꺼같아서
찾아봤더니  ScrollView 대신 NestedScrollView로 감싸고 
android:overScrollMode="never"
android:nestedScrollingEnabled="false"
이용하는방법이있어 해보았다
recyclerview 아이템 갯수만큼 잘늘어나는것을 확인했다
```

### 결과
---------------------------------------
![homeboard2](https://user-images.githubusercontent.com/97229292/163677247-a0493bb8-d189-4ee9-8723-55cdd391f2fe.gif)




