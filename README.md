### android-aidl-4-FINAL-
* `android-aidl`系列完结篇。
* 这一篇实现了最传统的`aidl`需求：两个app之间的`IPC`通信。
* 两个app之间的`aidl`和单个app内部实现`aidl`的主要区别如下：
  * 两个App之间进行`aidl`时，客户端不仅仅需要拷贝服务端的全部`.adil`文件，还要拷贝所有的`Parcelable`类。(当然，`Parcelable`的包名也是跟随服务端的定义来的)

----

* 实现功能如下：
1. 调用另一个App中的同步方法，同步获取数据(int 类型)
2. 调用另一个App中的异步方法，异步获取数据(int 类型)
3. 调用另一个App中的网络请求方法，异步获取数据(`Parcelable` 类型)

----

* 更多关于`AIDL`
  * [** 从懵逼开始 **](https://github.com/duckAndroid/-android-aidl-/wiki/android-aidl-从懵逼开始)
  * [** 继懵逼之后 **](https://github.com/duckAndroid/-android-aidl-/wiki/android-aidl-继懵逼之后)
  * [** 多 module 版的实现 **](https://github.com/duckAndroid/android-aidl-2/wiki/android-aidl-多%60module%60版的实现)

---

* 使用到的开源库：`retrolambda & rxjava & rxandroid & retrofit & okhttp & logutils`
  
