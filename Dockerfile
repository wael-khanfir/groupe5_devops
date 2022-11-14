FROM centos:7

RUN for user in frank; do useradd $user, echo"1234" | passwd $usr --stding; done
run yum update && yum install mysql -yum