FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI += " file://CVE-2022-48174_1.35_fix.patch \
             file://CVE-2025-46394_1.35_fix.patch \
           "

