SUMMARY = "Vulkan Benchmark"
DESCRIPTION = "vkmark is an extensible Vulkan benchmarking suite with targeted, configurable scenes."
AUTHOR = "Collabora"
HOMEPAGE = "https://github.com/vkmark/vkmark"
BUGTRACKER = "https://github.com/vkmark/vkmark/issues"
SECTION = "graphics"
CVE_PRODUCT = ""
LICENSE = "LGPL2.1"
LIC_FILES_CHKSUM = "file://COPYING-LGPL2.1;md5=4fbd65380cdd255951079008b364516c"

DEPENDS += "assimp glm vulkan-headers vulkan-loader" 

REQUIRED_DISTRO_FEATURES = "vulkan vulkan-devtools"

SRC_URI = "git://github.com/vkmark/vkmark.git;protocol=https;branch=master \
           file://0001_new_format_change.patch \
          "
SRCREV = "36e7d9b2ecf723e876add65534e95f55ec1bc79d"

S = "${WORKDIR}/git"

inherit meson pkgconfig features_check

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'wayland xcb kms', d)}"

PACKAGECONFIG[kms] = "-Dkms=true,-Dkms=false,drm virtual/libgbm"
PACKAGECONFIG[wayland] = "-Dwayland=true,-Dwayland=false,wayland wayland-native wayland-protocols"
PACKAGECONFIG[xcb] = "-Dxcb=true,-Dxcb=false,virtual/libx11 libxcb"

EXTRA_OEMESON += "--prefix ${STAGING_DIR_TARGET}/usr"

do_install() {
    install -d ${D}${bindir}
    cp ${WORKDIR}/build/src/vkmark ${D}${bindir}

    install -d ${D}${libdir}/vkmark
    cp ${WORKDIR}/build/src/headless.so ${D}${libdir}/vkmark
    cp ${WORKDIR}/build/src/display.so ${D}${libdir}/vkmark

    if [ "${@bb.utils.contains('PACKAGECONFIG', 'wayland', 'true', 'false', d)}" = "true" ]; then
        cp ${WORKDIR}/build/src/wayland.so ${D}${libdir}/vkmark
    fi

    if [ "${@bb.utils.contains('PACKAGECONFIG', 'kms', 'true', 'false', d)}" = "true" ]; then
        cp ${WORKDIR}/build/src/kms.so ${D}${libdir}/vkmark
    fi

    install -d ${D}${datadir}/vkmark/models
    cp -r ${S}/data/models/* ${D}${datadir}/vkmark/models

    install -d ${D}${datadir}/vkmark/shaders
    cp -r ${S}/data/shaders/* ${D}${datadir}/vkmark/shaders

    install -d ${D}${datadir}/vkmark/textures
    cp -r ${S}/data/textures/* ${D}${datadir}/vkmark/textures

    rm -rf ${D}${datadir}/man
}

do_install:append () {
   rm -rf ${D}${datadir}/man
}

FILES:${PN} += "\
    ${bindir} \
    ${libdir} \
    ${datadir} \
    "

FILES:${PN}-dev = ""

BBCLASSEXTEND = ""

do_write_config:append(){
   sed -i "/\[properties\]/asys_root=\'${STAGING_DIR_TARGET}\'" ${WORKDIR}/meson.cross
}

