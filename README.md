# lp
springboot+dubbo+gradle+mybatis-plus+mysql
初学dubbo，看视频大多是eclipse下的maven+mybatis+spring+dubbo
和现在常用的框架有点脱轨，所以自己试着搭一下
第一阶段
idea多模块创建core、provider、consumer
并且能够实现各个模块的正常运转，过程中也遇到了很多坑，各种查资料，跟源码总结下：
    1. mybatis-plus基本不用写service的接口，如何实现consumer的接口调用？
        网上找到个：https://blog.csdn.net/qq_35721287/article/details/103232506
        发现里面的把service的接口拿出来，再重新实现，从而解决了这个接口调用的问题。
    2. 消费者引用的接口service，引用不到service实现的方法
        找了很长时间，最后发现是service接口没有继承IService接口，而service的实现又
        继承了ServiceImpl，然后各种引用不到。
