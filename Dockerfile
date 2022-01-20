FROM ubuntu:18.04

EXPOSE 22
ENV DEBIAN_FRONTEND=noninteractive
COPY ["./Docker_install.sh", "./Docker_install.sh"]
RUN ["/bin/bash", "./Docker_install.sh"]

CMD ["/usr/sbin/sshd","-D"]
