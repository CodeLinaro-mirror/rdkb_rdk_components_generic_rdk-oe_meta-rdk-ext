SUMMARY = "Lua scripting language"
DESCRIPTION = "Lua is a powerful, efficient, lightweight, embeddable scripting language."
HOMEPAGE = "https://www.lua.org/"
SECTION = "languages"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://doc/readme.html;md5=7d8caebd34c2ca3e91b336086f047a7a"

SRC_URI = "https://www.lua.org/ftp/lua-5.4.4.tar.gz"
SRC_URI[sha256sum] = "164c7849653b80ae67bec4b7473b884bf5cc8d2dca05653475ec2ed27b9ebf61"

S = "${WORKDIR}/lua-5.4.4"

inherit pkgconfig

EXTRA_OEMAKE = "\
    CC='${CC}' \
    AR='${AR} rcu' \
    RANLIB='${RANLIB}' \
    MYCFLAGS='${CFLAGS} -fPIC' \
    MYLDFLAGS='${LDFLAGS}' \
"

do_compile() {
    oe_runmake clean
    oe_runmake linux
    OBJS=$(ls src/*.o | grep -v 'lua.o' | grep -v 'luac.o')

    ${CC} -shared -fPIC \
        -Wl,-soname,liblua.so.5.4 \
        -o liblua.so.5.4 \
        $OBJS \
        -lm -ldl
}

do_install() {
    oe_runmake INSTALL_TOP=${D}${prefix} install

    install -d ${D}${libdir}
    install -m 0755 liblua.so.5.4 ${D}${libdir}
    ln -sf liblua.so.5.4 ${D}${libdir}/liblua.so
}

FILES_${PN} += "${libdir}/liblua.so.*"
FILES_${PN}-dev += "${includedir} ${libdir}/liblua.so"
