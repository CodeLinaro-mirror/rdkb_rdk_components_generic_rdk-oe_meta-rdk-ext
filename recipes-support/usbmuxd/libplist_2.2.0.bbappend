DEPENDS = "libxml2 glib-2.0 python3"

# Source revision points to 2.1.0 version
SRCREV = "3df02d4d0e9008771e8622fdc10de8333b3f0d85"

FILES_${PN} = "${libdir}/libplist${SOLIBS}"
FILES_${PN}++ = "${libdir}/libplist++${SOLIBS}"

