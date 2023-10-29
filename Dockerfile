# 使用基础镜像，例如 OpenJDK
FROM openjdk:17

# 设置工作目录
WORKDIR /app

# 复制项目的构建产物（例如 JAR 文件）到镜像中
COPY core/target/core-assembly/core .

# 运行项目
CMD ["java", "-jar", "./lib/core.jar"]
