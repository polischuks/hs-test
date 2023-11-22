FROM gradle:7.3-jdk17-slim

COPY --chown=gradle . hs-test
WORKDIR /home/gradle/hs-test
RUN gradle resolveDependencies
