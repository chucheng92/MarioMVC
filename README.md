# 如何设计一个JavaWeb MVC框架

通过使用Java语言实现一个完整的框架设计，这个框架中主要内容有第一小节介绍的Web框架的结构规划，例如采用MVC模式来进行开发，程序的执行流程设计等内容；第二小节介绍框架的第一个功能：路由，如何让访问的URL映射到相应的处理逻辑；第三小节介绍处理逻辑，如何设计一个公共的 `调度器`，对象继承之后处理函数中如何处理response和request；第四小节至第六小节介绍如何框架的一些辅助功能，例如配置信息，数据库操作等；最后介绍如何基于Web框架实现一个简单的增删改查，包括User的添加、修改、删除、显示列表等操作。

![](http://i.imgur.com/QH8SRfB.png)

- 项目源码：[https://github.com/lemonjing/mvc-mario](https://github.com/lemonjing/mvc-mario)
- 示例代码：[https://github.com/lemonjing/mario-sample](https://github.com/lemonjing/mario-sample)

# 目录

* [项目规划](docs/1.plan.md)
* [路由设计](docs/2.route.md)
* [控制器设计](docs/3.controller.md)
* [配置设计](docs/4.config.md)
* [视图设计](docs/5.view.md)
* [数据库操作](docs/6.dbutil.md)
* [增删改查](docs/7.crud.md)

接下来开始我们的 [MVC框架实现](docs/1.plan.md) 吧~
