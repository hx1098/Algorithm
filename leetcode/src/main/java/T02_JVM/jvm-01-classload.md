### 1. 类加载器
<img src="C:\Users\hx\AppData\Roaming\Typora\typora-user-images\image-20220129101840932.png" alt="image-20220129101840932" style="zoom: 67%;" />



<img src="C:\Users\hx\AppData\Roaming\Typora\typora-user-images\image-20220129101943317.png" alt="image-20220129101943317" style="zoom:67%;" />

类加载过程:

![image-20220129102139660](https://cdn.jsdelivr.net/gh/hx1098/Algorithm@master/img/algorthm/20220129102139.png)

###  2. 为啥要搞双亲委派:

为了安全,如果这时用户自己写了一个String的类, 如果用户自己写了一个string的类, 先去查找里面后没有这个string(系统类), 如果有就直接加载, 没有的话才会去自己加载, 防止用户自己写了一个是String类, 然后里面有不安全的代码.







