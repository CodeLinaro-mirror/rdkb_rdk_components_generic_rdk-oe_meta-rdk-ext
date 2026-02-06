FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " file://CVE-2025-24912-1_2.1_fix.patch \
                   file://CVE-2025-24912-2_2.1_fix.patch \
                 " 
