# HaoLin_Ioc_Sample IOC框架注入

## 什么是DIP、IOC、DI、IOC容器

- 依赖倒置原则（DIP Dependency Inverse Principe）
 
   * 强调系统中高层组件不依赖低层组件，并且不论低层组件还是高层组件都应该依赖于抽象，抽象不应当依赖于实现，实现应当
   依赖于抽象（软件设计原则）

- 控制反转(IOC Inverse of Control)
  
   * 一种反转流、依赖和接口的方式，就是将控制权往高处/上层转移，控制反转是实现依赖倒置的一种方法（DIP的具体实现方式）
   
- 依赖注入（DI Dependency Injection）

   * 组件通过构造函数或者setter方法，将其依赖暴露给上层，上层应设法取得组件的依赖，并传递给组件依赖注入是实现控制方砖
   的一种手段（IOC的具体实现方式）
   
- IOC容器
  
   * 依赖注入框架，用来映射依赖，管理对象创建和生存周期（DI架构）

## 开发者的诟病
<img  src="https://github.com/hunimeizi/HaoLin_Ioc_Sample/blob/master/raw/goubing.png"/>

## 实际用法
<img  src="https://github.com/hunimeizi/HaoLin_Ioc_Sample/blob/master/raw/shijiyongfa.png"/>


## 反射 （Reflect）
<img  src="https://github.com/hunimeizi/HaoLin_Ioc_Sample/blob/master/raw/fanshe.png"/>


## 代理 （Proxy）
<img  src="https://github.com/hunimeizi/HaoLin_Ioc_Sample/blob/master/raw/daili.png"/>



