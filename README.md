# springboot-multiple-dataSources

### 前言 ###

spring-boot多数据源自动切换例子项目， 利用spring aop 切面，自动切换数据源。

CommonServiceImpl是公共处理类，Test1ServiceImpl和Test2ServiceImpl是两个数据源分别的业务处理类。定义DataSourceAspect类处理切面。

### 软件环境 ###
IntelliJ IDEA 2016.3.3(或eclipse)

jdk 1.8

maven 3.3.9

### 使用的技术 ###

技术
- spring-boot
- springmvc
- mybatis
- 通用mapper(一个非常好用的mybatis插件, 详细介绍见http://git.oschina.net/free/Mapper)

### 在IDE 中查看源码并运行 ###

**1. 在IntelliJ IDEA (推荐使用)**

File -> Import Project -> select springboot-multiple-dataSources folder -> create project form existing sources -> ...

**2. 在Eclipse**

File -> Import -> Existing Maven Projects -> ...
