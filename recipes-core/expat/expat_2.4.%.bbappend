FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " file://CVE-2022-43680_fix.patch \
                   file://CVE-2024-45492_fix.patch \
                   file://CVE-2023-52426_fix.patch \
                   file://CVE-2024-45491_fix.patch \
                   file://CVE-2024-45490_fix.patch \
                 "
