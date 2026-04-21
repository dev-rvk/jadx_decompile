FROM python:3.13-slim

ARG TARGETARCH

ARG JDK_VERSION=21.0.10+7
ARG JDK_VERSION_URL=21.0.10%2B7
ARG JDK_VERSION_FILE=21.0.10_7
ARG JDK_SHA256_AMD64=ea3b9bd464d6dd253e9a7accf59f7ccd2a36e4aa69640b7251e3370caef896a4
ARG JDK_SHA256_ARM64=357fee29fb0d5c079f6730db98b28942df13a6eed426f6c61cd4ad703ab27b9a

ARG JADX_VERSION=1.5.5
ARG JADX_SHA256=38a5766d3c8170c41566b4b13ea0ede2430e3008421af4927235c2880234d51a

RUN apt-get update && apt-get install -y --no-install-recommends \
        wget ca-certificates unzip \
    && rm -rf /var/lib/apt/lists/*

RUN set -eux; \
    case "${TARGETARCH}" in \
        amd64) ADOPTIUM_ARCH=x64;     JDK_SHA256=${JDK_SHA256_AMD64} ;; \
        arm64) ADOPTIUM_ARCH=aarch64; JDK_SHA256=${JDK_SHA256_ARM64} ;; \
        *) echo "Unsupported TARGETARCH: ${TARGETARCH}" >&2; exit 1 ;; \
    esac; \
    JDK_TARBALL="OpenJDK21U-jdk_${ADOPTIUM_ARCH}_linux_hotspot_${JDK_VERSION_FILE}.tar.gz"; \
    JDK_URL="https://github.com/adoptium/temurin21-binaries/releases/download/jdk-${JDK_VERSION_URL}/${JDK_TARBALL}"; \
    mkdir -p /opt/java; \
    wget -qO "/tmp/${JDK_TARBALL}" "${JDK_URL}"; \
    echo "${JDK_SHA256}  /tmp/${JDK_TARBALL}" | sha256sum -c -; \
    tar -xzf "/tmp/${JDK_TARBALL}" -C /opt; \
    ln -s /opt/jdk-21.* /opt/java/openjdk; \
    rm "/tmp/${JDK_TARBALL}"

ENV JAVA_HOME=/opt/java/openjdk
ENV PATH=$JAVA_HOME/bin:$PATH

RUN set -eux; \
    JADX_ZIP="jadx-${JADX_VERSION}.zip"; \
    wget -qO "/tmp/${JADX_ZIP}" "https://github.com/skylot/jadx/releases/download/v${JADX_VERSION}/${JADX_ZIP}"; \
    echo "${JADX_SHA256}  /tmp/${JADX_ZIP}" | sha256sum -c -; \
    unzip -q "/tmp/${JADX_ZIP}" -d /opt/jadx; \
    chmod +x /opt/jadx/bin/jadx /opt/jadx/bin/jadx-gui; \
    ln -s /opt/jadx/bin/jadx /usr/bin/jadx; \
    ln -s /opt/jadx/bin/jadx-gui /usr/bin/jadx-gui; \
    rm "/tmp/${JADX_ZIP}"

WORKDIR /app

COPY script.py .

ENTRYPOINT ["python", "script.py"]
