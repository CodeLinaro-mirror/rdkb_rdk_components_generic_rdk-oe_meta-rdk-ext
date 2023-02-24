SUMMARY = "low-level tool handling Linux filesystem encryption"
DESCIPTION = "fscryptctl is a low-level tool written in C that handles raw keys and manages \
policies for Linux filesystem encryption (https://lwn.net/Articles/639427). \
For a tool that presents a higher level interface and manages metadata, key \
generation, key wrapping, PAM integration, and passphrase hashing, see \
fscrypt (https://github.com/google/fscrypt)."
HOMEPAGE = "https://github.com/google/fscryptctl"
SECTION = "base"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRCREV = "${AUTOREV}" 
SRC_URI = "git://github.com/google/fscryptctl.git"

S = "${WORKDIR}/git"

SRC_URI += "file://firstboot.service \
            file://Makefile.patch \
            file://fscryptctl_so_creation.patch \
            file://ss_fscryptctl.patch \
            file://fscrypt.conf "

PACKAGES = "${PN} ${PN}-dev ${PN}-dbg ${PN}-staticdev"

RDEPENDS_${PN}-staticdev = ""
RDEPENDS_${PN}-dev = ""
RDEPENDS_${PN}-dbg = ""

TARGET_CFLAGS += " -fpic"

inherit systemd

RRECOMMENDS_${PN} += "\
    keyutils \
    kernel-module-cbc \
    kernel-module-cts \
    kernel-module-ecb \
    kernel-module-xts \
"
do_install_append () {
    install -d ${D}${bindir}
    install -d ${D}${libdir}
    install -d ${D}${includedir}
    install -m 0755 fscryptctl ${D}${bindir}
    install -m 0755 libfscryptctl.so  ${D}${libdir}/
    install -m 0644 ss_fscryptctl.h ${D}${includedir}/
    install -d ${D}${systemd_unitdir}/system ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/firstboot.service ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/fscrypt.conf ${D}${sysconfdir}
}

SYSTEMD_SERVICE_${PN}  = "firstboot.service"

FILES_${PN} += "${systemd_unitdir}/system/firstboot.service"
FILES_${PN} += "${libdir}/libfscryptctl.so"
FILES_${PN} += "${sysconfdir}/fscrypt.conf"
FILES_${PN} += "${includedir}/ss_fscryptctl.h"

INSANE_SKIP_${PN} = "ldflags"

