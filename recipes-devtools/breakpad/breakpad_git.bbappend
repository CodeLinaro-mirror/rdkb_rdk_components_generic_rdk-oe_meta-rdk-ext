FILESEXTRAPATHS_append := "${THISDIR}/files:"

SRC_URI_append = " file://create_stackwalk_common_target.patch "
SRC_URI_append = " file://breakpad_disable_format_macros_check.patch "
SRC_URI_append = " ${@bb.utils.contains('DISTRO_FEATURES', 'mixmode', 'file://breakpad_mixedmode_fpregs_git.patch', '', d)} "
