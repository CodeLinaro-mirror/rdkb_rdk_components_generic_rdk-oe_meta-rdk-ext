FILESEXTRAPATHS_prepend:="${THISDIR}/${PN}:"

SRC_URI_append = " file://CVE-2022-36227_fix.patch \
                   file://CVE-2023-30571_3.6.1_fix.patch \
                   file://CVE-2024-48957_fix.patch \
                   file://CVE-2024-48958_fix.patch \
                   file://CVE-2024-26256_3.6.1_fix.patch \
                 "
