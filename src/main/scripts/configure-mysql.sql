## Use to run mysql db docker image, optional if you're not using a local mysqldb
# docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

#Create Databases
CREATE DATABASE ev;


#Create database service accounts
CREATE USER 'dev'@'localhost' IDENTIFIED BY 'dev';
CREATE USER 'dev'@'%' IDENTIFIED BY 'dev';


#Database grants
GRANT all ON dev.* to 'dev'@'localhost';

GRANT all ON dev.* to 'dev'@'%';
