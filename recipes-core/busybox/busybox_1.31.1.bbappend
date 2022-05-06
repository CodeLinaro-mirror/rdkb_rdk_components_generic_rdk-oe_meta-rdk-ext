SRC_URI += " \
             file://0001-add-ENABLE_FEATURE_SYSTEMD-and-use-it-in-syslogd.patch \
             ${@bb.utils.contains('DISTRO_FEATURES', 'yocto-3.1.15', '', 'file://CVE-2018-1000500.patch', d)} \
           "
VERSION_PATCHES_append_client = " file://busybox-1.31-udhcp-trigger-milestones.patch"
