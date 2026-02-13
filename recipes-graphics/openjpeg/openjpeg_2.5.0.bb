DESCRIPTION = "OpenJPEG library is an open-source JPEG 2000 codec"
HOMEPAGE = "https://www.openjpeg.org"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c648878b4840d7babaade1303e7f108c"

DEPENDS = "zlib"

SRC_URI = "git://github.com/uclouvain/openjpeg.git;branch=master;protocol=https"
SRCREV = "v2.5.0"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

EXTRA_OECMAKE += "\
    -DBUILD_SHARED_LIBS=ON \
    -DBUILD_CODEC=OFF \
    -DBUILD_TESTING=OFF \
"

# Prevent CMake config exports from interfering with OpenCV detection
do_install_append() {
    rm -rf ${D}${libdir}/cmake
}

BBCLASSEXTEND += "native nativesdk"
