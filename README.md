## 如何设计一个JavaWeb MVC框架

通过使用Java语言实现一个完整的框架设计，这个框架中主要内容有第一小节介绍的Web框架的结构规划，例如采用MVC模式来进行开发，程序的执行流程设计等内容；第二小节介绍框架的第一个功能：路由，如何让访问的URL映射到相应的处理逻辑；第三小节介绍处理逻辑，如何设计一个公共的 `调度器`，对象继承之后处理函数中如何处理response和request；第四小节至第六小节介绍如何框架的一些辅助功能，例如配置信息，数据库操作等；最后介绍如何基于Web框架实现一个简单的增删改查，包括User的添加、修改、删除、显示列表等操作。


### MarioMVC 框架结构

common包：主要包括框架初始化接口 预定义常量 全局配置单例 线程上下文 前端过滤器

config包：配置加载器

render包：视图渲染类

db包：采用sql2o的数据库操作

route包：路由类 路由管理类 路由匹配类

servelet包：对HttpRequest和HttpResponse简单封装

util包：路径处理工具、异常处理工具、反射工具

### MarioMVC 请求流程

准备工作：

- 开发者编写Model类和View层

- 编写Controller

- 对web.xml配置（主要是前端过滤器和框架的初始化）其中前端过滤器为MVC框架的全限定名，拦截请求根据开发者需求自定义；框架初始化需要开发者实现Bootstrap初始化接口并载入路由，当然还有数据库连接的初始化

- 配置POM依赖：MVC-Mario、jstl、sql2o、jdbc驱动

请求流程：
读取Web.xml中的配置初始化框架和数据库连接 -> 请求到达 -> filter拦截根据请求的uri进行路由选择 -> 请求分发 -> 定位到Controller中具体方法

简单来说：匹配在Path上，执行靠Method，处于某个Controller中，同SpringMVC的机制类似。不同点在于SpringMVC使用前端控制器DispatcherServlet来实现请求的分发。

### 不足

没有加入IOC、AOP


![](http://i.imgur.com/QH8SRfB.png)

- 项目源码：[https://github.com/Lemonjing/MarioMVC](https://github.com/Lemonjing/MarioMVC)
- 示例代码：[https://github.com/Lemonjing/MarioSample](https://github.com/Lemonjing/MarioSample)

那么，现在[开始](docs/index.md)吧~
