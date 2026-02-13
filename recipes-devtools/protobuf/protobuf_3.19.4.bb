SUMMARY = "Protocol Buffers - structured data serialisation mechanism"
HOMEPAGE = "https://github.com/protocolbuffers/protobuf"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=37b5762e07f0af8c74ce80a8bda4266b"

DEPENDS = "zlib"
DEPENDS_append_class-target = " protobuf-native"

SRC_URI = "git://github.com/protocolbuffers/protobuf.git;branch=3.19.x;protocol=https"
SRCREV = "v3.19.4"

S = "${WORKDIR}/git/cmake"

inherit cmake pkgconfig

EXTRA_OECMAKE += "\
    -Dprotobuf_BUILD_TESTS=OFF \
    -Dprotobuf_BUILD_SHARED_LIBS=ON \
    -Dprotobuf_BUILD_EXAMPLES=OFF \
"

BBCLASSEXTEND = "native nativesdk"
