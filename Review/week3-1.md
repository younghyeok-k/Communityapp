# week3-1
https://merry1031.tistory.com/m/18

새롭게 Fragment를 시작하면서 데이터를 처음부터 받아오는거



https://maivve.tistory.com/35

 

그리고 setOnItemClick같은 부분이 adapter에서 구현되어 있는데 Fragment에서 만들어줘서 새롭게 초기화시켜주는 것


https://yunaaaas.tistory.com/57

2일째 하는중

remove
-------------------
https://stackoverflow.com/questions/31367599/how-to-update-recyclerview-adapter-data

## 북마크  삭제
--------------------------
```
Firebase에서는 데이터가 변하면 onDataChange가 자동으로 실행되도록 구성되어 있습니다.

때문에, 리스트에 들어있는 데이터에 새로 변경된 데이터가 불러와져서 중복 데이터가 들어가는 형태이다
그래서 이미 리스트에 들어있는 값들을 clear 해야한다
북마크를 bookmakrIdList.clear() 한것처럼 
items 의 컨텐츠들도 onDataChange 부분에서 clear() 해주면 된다
```
![image](https://user-images.githubusercontent.com/97229292/161566685-e89458b9-63d5-47ef-9c76-4b90618f257a.png)

## 결과
---------------
![북마크 삭제(my)](https://user-images.githubusercontent.com/97229292/161567110-2cdcf963-c8c0-42ec-ad3a-be686eecb925.gif)



