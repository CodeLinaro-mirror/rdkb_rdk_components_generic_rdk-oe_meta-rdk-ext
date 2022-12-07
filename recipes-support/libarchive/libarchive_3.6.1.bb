SUMMARY = "libarchive"
DESCRIPTION = "A C library for reading and writing streaming archives"
SECTION = "libs"
HOMEPAGE = "https://github.com/libarchive/libarchive"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=d499814247adaee08d88080841cb5665"

PR="r0"

# openssl will provide libcrypto
DEPENDS = "zlib bzip2 openssl expat"

LIBARCHIVE_TAG="v3.6.1"

SRC_URI = "git://github.com/libarchive/libarchive.git;protocol=https;tag=${LIBARCHIVE_TAG}"

S = "${WORKDIR}/git"

inherit pkgconfig cmake
