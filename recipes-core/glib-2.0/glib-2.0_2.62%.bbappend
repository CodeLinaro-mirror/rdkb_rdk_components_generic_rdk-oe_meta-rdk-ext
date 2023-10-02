FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " file://fix_pollfd_dispatch.patch \
                   file://CVE-2021-3800_fix.patch \
                 "
