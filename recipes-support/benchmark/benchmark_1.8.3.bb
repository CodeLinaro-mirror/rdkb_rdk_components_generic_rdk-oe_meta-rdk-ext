SUMMARY = "A library to benchmark code snippets, similar to unit tests."
HOMEPAGE = "https://github.com/google/benchmark"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

PV = "1.8.3"

# matches with tag 1.8.3
SRCREV = "344117638c8ff7e239044fd0fa7085839fc03021"
SRC_URI = "git://github.com/google/benchmark;branch=main;protocol=https"

S = "${WORKDIR}/git"

DEPENDS += "googletest"

#GOOGLETEST_SRC="${BASE_WORKDIR}/${TARGET_SYS}/googletest/1.15.2-r0/git"
GOOGLETEST_SRC="${BASE_WORKDIR}/${MULTIMACH_TARGET_SYS}/googletest/1.15.2-r0/git"
EXTRA_OECMAKE += "-DGOOGLETEST_PATH=${GOOGLETEST_SRC}"

# Needs gtest
EXTRA_OECMAKE += "-DBENCHMARK_ENABLE_GTEST_TESTS=ON -DBENCHMARK_ENABLE_TESTING=ON"

# Build shared libraries
EXTRA_OECMAKE += "-DBUILD_SHARED_LIBS=ON"

inherit cmake

FILES_${PN} += "${libdir}/*"
