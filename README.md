# VerticalDragListView

可以下拉的viewGroup
## 效果展示

https://github.com/cjwhaogaoleng/VerticalDragListView/assets/117556474/75eee398-1dd2-43aa-965e-b28e83e8b70e

 ## 源码位置
/app/src/main/java/com/example/verticaldraglistview/VerticalDragListView.java
 ## 代码讲解
  ### 使用
  #### xml布局
  //只支持两个，一上一下两个view
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

//这个位置用列表（recycleView或者ListView
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

