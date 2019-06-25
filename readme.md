## 简介
    为了快速开发前后端分离的restful服务，使用springboot+mybatis快速开发

## 项目模块说明

### common
    web服务基础通用类库，包括异常统一处理,http响应格式规范，数据表公共字段RObj，不同类字段内容拷贝工具。
### client
    定义接口的form表单、视图bean
### rest-service
    web服务，采用mybatispuls自动生成通用代码类，提供rest访问接口
## 开发步骤
* 引用公共模块common
* 定义数据存储结构ddl sql脚本(项目的sql脚本在rest-service模块下的db目录)
* 搭建rest-service模块(controller,entity,mapper,service包都不用建)，运行WebCodeGenerator代码生成工具按步骤输入模块名称和表名(这里输入的模块为sms，然后一块输入两个表名),
整理生成的代码，开发增查改逻辑代码
    * 坑：自动生成的代码有点问题，entity需要手动格式化、去掉和RObj基类相同字段，去掉Accessors注解
    * SqlInterceptor：该类主要完成数据修改时，对version、creation、lastModified字段统一处理
    * restful接口定义：
        * 添加 POST '/{实体类}'
        * 修改 PUT '/{实体类}/{id}'
        * 添加 GET '/{实体类}/{id}'

##总结
* rest接口响应该统一结构体
* 使用mybatisplus工具可以快速开发，避免编写大量的单表增查改sql