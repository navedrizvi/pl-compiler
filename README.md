```
docker build -t cs8803 ./
```

On a Mac, use the following run command. It creates a container named cs8803 and adds a volume mapped folder:
```
docker run -it --name cs8803 -dp 2222:22 \
    --cap-add=SYS_PTRACE --security-opt seccomp=unconfined \
    -v $PWD:/home/user/tiger-compiler cs8803
```

Use the command `ssh user@localhost -p 2222` to login to the docker container. username='user' password='password'

After exiting, you can kill and remove the container
```
docker kill cs8803
docker rm cs8803 
```

When running antlr4 tool, run the following:
```
antlr4 Tiger.g4 -o src/
javac src/Tiger*.java
```

For testing using, cd into `src/` directory and then you can run any of the following commands:
```
grun Tiger main -tokens ../test.tiger
grun Tiger main -tree ../test.tiger
grun Tiger main -gui ../test.tiger
```
