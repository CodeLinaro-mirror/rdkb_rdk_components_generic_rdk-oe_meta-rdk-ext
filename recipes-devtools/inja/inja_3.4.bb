SUMMARY = "Template engine for modern C++, loosely inspired by jinja for python"
HOMEPAGE = "https://github.com/pantor/inja"
SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=07c6570bbc2ba48616882d528c2378f3"

DEPENDS = "nlohmann-json"

SRC_URI = "git://github.com/pantor/inja.git;tag=v3.4.0"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += " -DINJA_USE_EMBEDDED_JSON=OFF -DBUILD_TESTING=OFF -DINJA_BUILD_TESTS=OFF -DBUILD_BENCHMARK=OFF"

# inja is a header only C++ library, so the main package will be empty.
RDEPENDS_${PN}-dev = ""
BBCLASSEXTEND = "native nativesdk"
