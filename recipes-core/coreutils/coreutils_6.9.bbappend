FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " file://CVE-2015-4042_6.9_fix.patch \
                 "

