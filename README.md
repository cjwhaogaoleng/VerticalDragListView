# VerticalDragListView
## 效果展示
https://github.com/cjwhaogaoleng/TextColorChangeView/assets/117556474/7f792e20-3ab4-466d-b2f8-c1711dc01c06

 ## 源码位置
/app/src/main/java/com/example/textcolorchange/VerticalDragListView.java
 ## 代码讲解
  ### 使用
  #### xml布局
```
<com.example.verticaldraglistview.VerticalDragListView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="400dp"
        android:background="@color/teal_200"
        android:gravity="center"
        android:text="后面" />

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/rv"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:text="前面!"
        />

</com.example.verticaldraglistview.VerticalDragListView>
```
 
 ## 待完成
 - [x] 自定义view
   - [x] onMeasure 源码和写法基本了解
   - [x] onDraw 源码和写法基本了解
   - [x] onTouch 触碰分发事件正在学习
 - [ ] compose 已经接触，还没有另一种熟练
 - [ ] :disappointed: :blush:

