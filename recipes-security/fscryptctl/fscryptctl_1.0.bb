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
            file://Makefile.patch "

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
    install -m 0755 fscryptctl ${D}${bindir}
    install -d ${D}${systemd_unitdir}/system ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/firstboot.service ${D}${systemd_unitdir}/system
}

SYSTEMD_SERVICE_${PN}  = "firstboot.service"

FILES_${PN} += "${systemd_unitdir}/system/firstboot.service"
