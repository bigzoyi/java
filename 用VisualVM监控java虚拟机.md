如何在windows下远程监控linux上的java虚拟机
 
##1．监控本地jvm，打开就能直接看到Local里面本地运行jvm信息，不需要做任何配置；

##2．远程监控jvm，
远程linux机器配置：

###1.1、首先需要准备一个java.policy文件，保存到如/home/admin/jstatd.java.policy
grant codebase "file:${java.home}/../lib/tools.jar" {
   permission java.security.AllPermission;
};

###1.2、        启动jstatd
jstatd -J-Djava.security.policy=/home/admin/jstatd.java.policy -J-Djava.rmi.server.logCalls=true

###1.3、        同时需要执行一个命令看看（linux需要）
Hostname –i
如果显示是127.0.0.1，则需要修改/etc/hosts文件，去掉对本机名的配置，让本机名解析到它的IP地址，如10.20.131.214
