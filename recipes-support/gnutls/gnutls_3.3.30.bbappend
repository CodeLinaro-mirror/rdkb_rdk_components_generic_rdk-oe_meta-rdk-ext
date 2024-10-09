DEPENDS_remove = "libunistring"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " file://CVE-2024-0553_3.3.30_fix.patch \
                   file://CVE-2021-4209_3.3.30_fix.patch "
