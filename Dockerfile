FROM ubuntu:18.04

EXPOSE 22
ENV DEBIAN_FRONTEND=noninteractive
COPY ["./Docker_install.sh", "./Docker_install.sh"]
RUN ["/bin/bash", "./Docker_install.sh"]
RUN echo 'alias grun="java org.antlr.v4.runtime.misc.TestRig"' >> ~/.bashrc

CMD ["/usr/sbin/sshd","-D"]
