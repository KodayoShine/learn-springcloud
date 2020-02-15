练习spring cloud

可以在根节点下输入mvn clean install,进行全局打包处理

在各个子服务中可以使用mvn clean package,如果出现问题在命令后面加-X,查看详细情况

打成jar包 使用命令java -Dfile.encoding=utf-8 -jar xx-service-1.0.0.jar