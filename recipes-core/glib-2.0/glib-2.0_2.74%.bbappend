FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = "file://CVE-2024-52533_2.74_fix.patch \
                  file://CVE-2025-4056_2.74_fix.patch \
                 "
