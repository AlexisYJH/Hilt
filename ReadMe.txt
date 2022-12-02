Hilt是基于Dagger构建而成的依赖注入框架，它提供了一种将Dagger纳入Android应用的标准方法：
使用Hilt提供的规范来实现依赖注入，可以避免很多不必要的问题

Hilt的作用
Hilt是Dagger的最强辅助：
Hilt简化了Dagger的使用，大量减少了使用Dagger时编写的重复代码。
Hilt提供一套标准组件和作用域注解：不必再自定义组件和作用域。
Hilt提供几种预定义的绑定（提供对象实例的获取成为绑定）：如Application和Activity。
Hilt提供几种预定义的限定符(Qualifier): @ApplicationContext和@ActivityContext。

$$app
Hilt的使用
原理简析
- 生成代码
- Hilt使用了APT, Javassist字节码技术（查看plugin代码，使用了Javassist）

$$javassist
测试在运行时修改字节码数据，Hilt使用时机不一样（编译后打包前）