# Use Bluez 5.48 for ControlMgr and BLE Voice support.
PREFERRED_VERSION_bluez5 = "${@bb.utils.contains('DISTRO_FEATURES', 'enable-rdkv-bt-voice', '5.48', '', d)}"
#BBMASK .= "${@bb.utils.contains('DISTRO_FEATURES', 'enable-rdkv-bt-voice', '', '|meta-rdk-ext/recipes-connectivity/bluez/bluez5_5.48.bb', d)}"
PREFERRED_VERSION_binutils = "2.27"
PREFERRED_VERSION_sdbus-c++ = "${@bb.utils.contains('enable-sdbus-btsdk', '1', '2.1.0', '', d)}"
BBMASK .= "${@bb.utils.contains('DISTRO_FEATURES', 'enable-sdbus-btsdk', '', '|meta-rdk-ext/recipes-core/sdbus-c\\+\\+/sdbus-c\\+\\+_2\\.1\\.0\\.bb', d)}"
