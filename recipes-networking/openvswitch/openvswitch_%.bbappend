FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_kirkstone = " file://CVE-2022-4337_2.35_fix.patch"
SRC_URI_append_dunfell = "file://CVE-2022-4337_fix.patch"

SRC_URI_append_broadband = " ${@bb.utils.contains('DISTRO_FEATURES', 'kirkstone', '', 'file://CVE-2021-3905_fix.patch \
                                                                             file://CVE-2021-36980_fix.patch', d)} \
				"
