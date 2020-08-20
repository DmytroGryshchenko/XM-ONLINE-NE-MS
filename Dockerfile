FROM adoptopenjdk:11-jre-hotspot

ENTRYPOINT ["/entrypoint.sh"]
#ENTRYPOINT java ${JAVA_OPTS} -Xmx$XMX -XX:+ExitOnOutOfMemoryError -Djava.security.egd=file:/dev/./urandom -jar "app.war" "$@"

ADD /src/main/docker/entrypoint.sh /
RUN rm -rf /var/lib/apt/lists/*

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JHIPSTER_SLEEP=0 \
    XMX=256m \
		TZ=Europe/Kiev \
		LANG=en_US.UTF-8 \
		LANGUAGE=en_US:en \
		TERM=xterm \
    JAVA_OPTS="-Xms64m -Dcom.sun.management.jmxremote=true -Dcom.sun.management.jmxremote.ssl=false \
               -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.local.only=false \
               -Dcom.sun.management.jmxremote.rmi.port=19999 -Dcom.sun.management.jmxremote.port=19999 \
               --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.lang.invoke=ALL-UNNAMED"
# --add-opens fix issues with illegal reflective access operation in groovy lib, will be fixed in next groovy releases
# add directly the war
ADD build/libs/*.war /app.war


EXPOSE 8701
