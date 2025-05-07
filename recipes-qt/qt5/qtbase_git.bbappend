FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://CVE-2023-34410_5.15.7_fix.patch \
            file://CVE-2023-32762_5.15.7_fix.patch \
            file://CVE-2024-39936_5.15.7_fix.patch \
            file://CVE-2023-37369_5.15.7_fix.patch \
            file://CVE-2023-38197_5.15.7_fix.patch \
            file://CVE-2023-24607_5.15.7_fix.patch \
            file://CVE-2023-32763_5.15.7_fix.patch \
            file://CVE-2022-25634_5.15.7_fix.patch \
            file://CVE-2023-51714_5.15.7_fix.patch \
           "
