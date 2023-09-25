
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += " \
            file://0001-libexecdir-location.patch \
            file://CVE-2020-27153.patch \
            file://0004-bluetooth_avdtp_a2dp_abort.patch \
            file://0005-clear_old_cache_list.patch \
            file://0007-bluez-stream-free-crash-fix.patch \
            file://0009-unpairing_issue_on_disconnection.patch \
           "
SRC_URI_append_hybrid += "file://0002-bluetooth_autoenable_policy_main_conf.patch"
SRC_URI_append_client += "file://0002-bluetooth_autoenable_policy_main_conf.patch"
