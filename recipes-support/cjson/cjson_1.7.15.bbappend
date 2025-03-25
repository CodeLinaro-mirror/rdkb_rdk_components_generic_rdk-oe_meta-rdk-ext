FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " \
           file://CVE-2024-31755_1.7.15_fix.patch \
           "
