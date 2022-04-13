# week5-2

## 홈 레이아웃
----------------------------

홈레이아웃 틀을 대충만들어보았다 

![image](https://user-images.githubusercontent.com/97229292/163199878-b9172686-76a0-48a2-afd5-967659184376.png)

```
첫번째로 Viewpager2 를 이용한 배너만들기를 해볼것이다
Viewpager2 에대한 지식과 정보가 별로없어 시간이 조금 걸릴것으로 예상된다
일단 배달의민족 앱을 참고해서 만들어보았다 배너의 끝에 도달했을 때 페이지를 넘기면
다시 맨 처음부터 배너가 시작되는 걸 볼 수 있다
무한 뷰페이져 infinite viewPager 라는 찾아봐서 적용해볼것이다
```

------------------------------

### ViewPager2 선언
![image](https://user-images.githubusercontent.com/97229292/163200843-1193ef88-1538-4a0c-802d-30e2478f3537.png)


### Adapter 생성
![image](https://user-images.githubusercontent.com/97229292/163200937-d1592767-fca1-4384-b9e5-3456f70b6d3d.png)
```
 getItemCount(): Int = Int.MAX_VALUE 이거는 
 int 가 표현할수있는 갖아 큰숫자로 리턴 한다
 
 position 값을 사용할 때는 원하는 배너의 개수만큼 나눈 나머지 값을 사용한다.

예를 들어 배너가 3개라고 했을 때

 

0 % 3 = 0  -  첫 번째 배너

1 % 3 = 1  -  두 번째 배너

2 % 3 = 2  -  세 번째 배너

 

(여기서 계속 페이지를 넘기면)

 

3 % 3 = 0  -  첫 번째 배너

4 % 3 = 1  -  두 번째 배너

5 % 3 = 2  -  세 번째 배너

 

이렇게 페이지를 계속 넘김에 따라 position은 계속 늘어나지만

3으로 나눔으로써 배너를 반복해서 사용할 수 있는 것이다.
```
### HomeFragment
![image](https://user-images.githubusercontent.com/97229292/163201092-b7f2153d-f54a-407e-a134-e68ddc23c82f.png)
![image](https://user-images.githubusercontent.com/97229292/163201015-a3351f45-41aa-467e-8cdc-4a6eca7034e2.png)
```
메인 액티비티에서도 position을 사용할 때 '%3' 이런 식으로 사용하면 된다.
중요한 건 currentPosition이다. 현재의 위치를 Int.MAX_VALUE / 2로 정해주었는데
왼쪽으로도 무한 스크롤, 오른쪽으로도 무한 스크롤을 할 수 있도록
현재 위치를 딱 중간으로 설정해 준 것이다.
이때 사용한 메서드가 현재 위치를 설정하는 setCurrentItem이다.
setCurrentItem에 두번째 매개변수로 true값을 주면
맨 첫번째 배너로 미끄러지듯이 이동하면서 시작하기 때문에
false값을 넣어주면 된다.
```
![banner1](https://user-images.githubusercontent.com/97229292/163202728-ac2ddcd6-a3a4-4c64-827a-f00e19446ff1.gif)

```
내일은 자동으로  넘어갈수있게끔 공부해서 적용해볼예정이다
```

