SUMMARY = "WebP is an image format designed for the Web"
DESCRIPTION = "WebP is a method of lossy and lossless compression that can be \
               used on a large variety of photographic, translucent and \
               graphical images found on the web."

HOMEPAGE = "https://developers.google.com/speed/webp/"
SECTION = "libs"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=6e8dee932c26f2dab503abf70c96d8bb \
                    file://PATENTS;md5=c6926d0cb07d296f886ab6e0cc5a85b7"

SRC_URI = "http://downloads.webmproject.org/releases/webp/${BP}.tar.gz"
SRC_URI[sha256sum] = "7bf5a8a28cc69bcfa8cb214f2c3095703c6b73ac5fba4d5480c205331d9494df"

UPSTREAM_CHECK_URI = "http://downloads.webmproject.org/releases/webp/index.html"

EXTRA_OECONF = " \
    --disable-wic \
    --enable-libwebpmux \
    --enable-libwebpdemux \
    --enable-threading \
"

# Do not trust configure to determine if neon is available.
EXTRA_OECONF_ARM = " \
    ${@bb.utils.contains('TUNE_FEATURES','neon','--enable-neon','--disable-neon',d)} \
"

EXTRA_OECONF_append_arm = " ${EXTRA_OECONF_ARM}"
EXTRA_OECONF_append_armeb = " ${EXTRA_OECONF_ARM}"

inherit autotools lib_package

PACKAGECONFIG ??= ""

PACKAGECONFIG[decoder] = "--enable-libwebpdecoder,--disable-libwebpdecoder"

PACKAGECONFIG[gif] = "--enable-gif,--disable-gif,giflib"
PACKAGECONFIG[jpeg] = "--enable-jpeg,--disable-jpeg,jpeg"
PACKAGECONFIG[png] = "--enable-png,--disable-png,,libpng"
PACKAGECONFIG[tiff] = "--enable-tiff,--disable-tiff,tiff"

PACKAGECONFIG[gl] = "--enable-gl,--disable-gl,mesa-glut"

PACKAGES += "${PN}-gif2webp"

DESCRIPTION_${PN}-gif2webp = "Simple tool to convert animated GIFs to WebP"
FILES_${PN}-gif2webp = "${bindir}/gif2webp"

BBCLASSEXTEND += "native nativesdk"
