FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append_broadband = " file://CVE-2023-26257_fix.patch \
                           "
