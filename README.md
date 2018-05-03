# zipkin-demo
zipkin测试demo

分别运行4个spring-boot项目即可

分别访问如下url :
http://localhost:9091/s1
http://localhost:9092/s2
http://localhost:9093/s3
http://localhost:9094/s4

zipkin展示界面为：http://118.190.46.58:32675

如需变化zipkin接收器的地址，分别修改：
demo\src\main\resources\application.properties文件中的  com.zipkin.url ，变为对应的 zipkin接收器的URL ： 端口
