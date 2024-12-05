SUMMARY = "Libav-based GStreamer 1.x plugin"
SECTION = "multimedia"
LICENSE = "GPL-2.0-or-later & LGPL-2.0-or-later & ( (GPL-2.0-or-later & LGPL-2.1-or-later) | (GPL-3.0-or-later & LGPL-3.0-or-later) )"
LICENSE_FLAGS = "commercial"
HOMEPAGE = "http://www.gstreamer.net/"
DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base zlib bzip2"

inherit autotools pkgconfig

# CAUTION: Using the system libav is not recommended. Since the libav API is changing all the time,
# compilation errors (and other, more subtle bugs) can happen. It is usually better to rely on the
# libav copy included in the gst-libav package.
PACKAGECONFIG ??= " orc "
PACKAGECONFIG[libav] = "--with-system-libav,,libav"
PACKAGECONFIG[lgpl]  = "--enable-lgpl,,"
PACKAGECONFIG[orc]  = "--enable-orc,--disable-orc,orc"


GSTREAMER_1_0_DEBUG ?= "--disable-debug"

LIBAV_EXTRA_CONFIGURE = "--with-libav-extra-configure"
LIBAV_EXTRA_CONFIGURE_COMMON = \
'${LIBAV_EXTRA_CONFIGURE}="${LIBAV_EXTRA_CONFIGURE_COMMON_ARG}"'

EXTRA_OECONF = "${LIBAV_EXTRA_CONFIGURE_COMMON}"

FILES_${PN} += "${libdir}/gstreamer-1.0/*.so"
FILES_${PN}-dbg += "${libdir}/gstreamer-1.0/.debug"
FILES_${PN}-dev += "${libdir}/gstreamer-1.0/*.la"
FILES_${PN}-staticdev += "${libdir}/gstreamer-1.0/*.a"

