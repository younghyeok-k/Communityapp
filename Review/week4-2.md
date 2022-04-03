# week4-2


## Navigation Drawer
------------
![screen-nav](https://user-images.githubusercontent.com/97229292/161432855-dadac21f-ace5-497d-86e0-8a87c92df825.gif)


```
Drawer가 나타나지 않은 주 화면에서 버튼 이벤트 등으로 Drawer를 나타나게 할 수 있으며, view에 layout_gravity = 'left' (START)혹은 'right'(END)로 Drawer가 나타나는 방향과 layout_width로 Drawer의 size를 정할 수 있다.
기본적으로 Drawer를 여는 방법은 스와이프지만 DrawerLayout에서 제공되는 openDrawer()함수 및 closeDrawer()함수로 버튼 등을 사용하여 열거나 닫을 수 있다.이 DrawerLayout을 기본으로 하여 Navigation Drawer를 구현하게 된다.

```

### 1)  implementation 추가
```
implementation 'androidx.legacy:legacy-support-v4:1.0.0' // DrawerLayout
implementation 'com.google.android.material:material:1.0.0' // NavigationView

```

### 2) navi_item 만들기

![image](https://user-images.githubusercontent.com/97229292/161433045-015c8c05-26fa-4f44-af59-4e0b824ba234.png)

### 3) onNavigationItemSeleted 
클릭시 이벤트 처리
![image](https://user-images.githubusercontent.com/97229292/161433117-9f11908e-98b4-4de7-96c1-658aeade6b6c.png)

### 4) 클릭 이벤트 연결
![image](https://user-images.githubusercontent.com/97229292/161433157-da9c2f57-2ada-4fc8-9b92-5eb8a4872c1c.png)

