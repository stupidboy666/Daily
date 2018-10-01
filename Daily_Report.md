# Daily Report



## Day 1

**学到的东西**

* 学会使用Jsoup对html文件进行解析，阅读完了Jsoup中文文档
* 对Material Design有了更为深入的了解，学会了Toolbar  DrawerLayout  NavigationView FloatingActionButton等MaterialDesign风格组件的使用方式，经过一番尝试写出了比较令自己满意的UI界面
* 学习LitePal数据库的使用方式，对SQLite数据库也进行了深入的学习，掌握了一些基础的SQL数据库语句
* 基本实现了爬取每日一文的文章并显示在App中
* 基本了解了图片三级缓存的原理
* 可以将Bean中的数据设置为public 直接对其进行修改，减少调用函数需要的时间



**遇到的问题**

* 一开始对于Jsoup的使用方式不够了解，总是将Elements与Element两者混淆，所以在写爬虫的过程中遇到了许多困难，也导致我最开始的实现中文章不能够分段换行，用户体验不佳。后来我又重新阅读了一遍Jsoup的文档，对各种方法有了更为深入的理解，才得到自己满意的版本。
* 写代码时，忘记申请网路权限，导致App不能正常工作
* 使用LitePal时，出现程序不能正常运行的问题，多次调试后采取LitePal文档中建议的另一种方式，问题得以解决，但是原理我没有思考明白。



**明日计划**

* 爬取音频文档
* 音频Ui界面设计
* 继续学习LitePal
* 修改之前的代码风格，更加规范