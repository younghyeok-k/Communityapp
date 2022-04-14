# week5-3


# 배너 자동으로 스크롤하기
------------------------------------------------


#### 배너가 사용자가 움직이지 않아도 일정시간이 지나면 스스로 넘어갈수있도록 만들것이다


### 참고사항

1) 배너는 사용자가 클릭하지 않으면 넘어가야하고 
2) 사용자가 배너를 클릭하면 배너가 움직이지 않는다
3) 사용자가 배너를 터치한 상태로 드래그 하지않으면 페이지가 넘어간다


![image](https://user-images.githubusercontent.com/97229292/163365448-daccc9f5-eabc-46cb-a1cd-92eed9dc5e15.png)

![image](https://user-images.githubusercontent.com/97229292/163365561-3804c800-d5cd-4a94-a01b-241c21a7e14e.png)

![image](https://user-images.githubusercontent.com/97229292/163365624-5895196c-cec1-4051-ac65-547bbe8ec237.png)


```
찾아보니 자동으로 일정시간이 지나면 넘기는 작업은 동적으로 진행되어야해서 핸들러를 사용했다
 onPageScrollStateChanged 메시드를 통해 자동 스크롤을 시작할지,정지할지 정해준다
 
 하지만 넘어갈때마다 잠깐멈추는 작업에서 autoScroolStart 를 호출해서 핸들러가 중첩돼버린다
 그래서 removeMessages를 넣어주어 핸들러를 삭제해준것이다
 
 sendEmptyMessageDelayed는 메시지 큐에 메시지를 보내는 메서드이다.
0번째 위치에 '1500'이라는 메시지를 보냈고
이 메시지는 MyHandler 이너 클래스에서 받아서 처리한다

onResume에서 autoScrollStart 다른페이지 갔다가 돌아오면 다시스크롤 시작할수있게
onPause에서 autoScrollStop을 다른페이지로 떠나있는 동안 스크롤이 동작할 필요없게 정지

이렇게 라이프 사이클에 맞게 적절히 시작과 정지를 해주어야 한다.
```
