# 03 / 10

### Button 색상 수정 안될시 (버전에따라 다르다)
---------------------------------------------------------

```
themes.xml

<style name="Theme.Communityapp" parent="Theme.AppCompat.Light">

```
### style  적용 한번에 만들기
---------------------------------------------------------
themes.xml 파일 밑에 새로운 스타일을 만든다
```
themes.xml

    <style name="AuthEditText" parent="android:Widget.EditText">
        <item name="android:background">@android:color/transparent</item>
        <item name="android:textSize">15sp</item>
        <item name="android:layout_margin">10dp</item>
    </style>

acivity_login.xml
     <EditText
            style="@style/AuthEditText"
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:hint="email" />
            
```
### 버튼 둥글게 만들기
---------------------------------------------------------
drawable 에  background_radius.xml 파일을 만든다

```
 background_radius.xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:padding="10dp"
    android:shape="rectangle" >
    <solid android:color="@color/white" />
    <corners
        android:bottomLeftRadius="30dp"
        android:bottomRightRadius="30dp"
        android:topLeftRadius="30dp"
        android:topRightRadius="30dp" />

</shape>
activity_login.xml
      <Button
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:layout_margin="20dp"
            android:background="@drawable/background_radius"
            android:text="로그인하기"
            android:textColor="@color/white" />
```
