FROM kscripting/kscript:4.2.3

WORKDIR /app
COPY svg2compose.main.kts  /app

ENV KOTLIN_HOME=/opt/kotlinc
ENV PATH=/opt/kotlinc/bin:$PATH

# Cache dependencies with first running
RUN kscript /app/svg2compose.main.kts || true

ENTRYPOINT [ "kscript", "/app/svg2compose.main.kts"]
