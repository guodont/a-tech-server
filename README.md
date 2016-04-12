## a-tech-server 农科项目server端

### Introduction
This project is an use case for [Play Framework 2](https://github.com/playframework/playframework) in real world.
农科项目server端

### Architecture
Play 2.4.2 + Spring 4.1.6 + Hibernate 4.3.6

### Prerequisites
1.JDK8+  
2.[Scala 2.11.6+](http://www.scala-lang.org/)  
3.[sbt 0.13.7+](http://www.scala-sbt.org/)  
4.[MySQL 5.5+](http://www.mysql.com/) or [MariaDB 10+](https://mariadb.org/)  
5.[Redis 2.7+](http://redis.io/)

### Project Structure
- admin：web module
- common：utility module
- order-center: business logic module
- project: sbt build directory

### How To Run
#### Init database
Run `PATH/docs/test-object.sql` in you MySQL terminal:
```
create database play;
source /PATH/docs/test-object.sql -- change it to your path
```

#### Edit configuration file
Open `PATH/admin/conf/application.conf`, replace this with your own configuration:
```
db.default {
  driver = com.mysql.jdbc.Driver
  url = "jdbc:mysql://localhost:3306/play?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull"
  username = root
  password = "root"

...

redis {
  host = 127.0.0.1
  port = 6379

...

```

#### Let's rock!
Open your favorite terminal, input this:
```
cd /PATH # change it to your project path
sbt
project admin
run
```

Open http://localhost:9000/ in your browser.

