FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append_broadband = " ${@bb.utils.contains('DISTRO_FEATURES', 'kirkstone', '', 'file://CVE-2022-29824_fix.patch', d)} \
                           "

SRC_URI += "file://CVE-2025-32414_2.9.14_fix.patch \
            file://CVE-2025-32415_2.9.14_fix.patch \
           "
