do_install_append() {
    install -d ${D}${includedir}/sanitizer/
    install -m 0644 ${D}/${libdir}/gcc/${TARGET_SYS}/${BINV}/include/sanitizer/*.h ${D}${includedir}/sanitizer/
}

FILES_${PN} += " ${includedir}/sanitizer/*.h"
