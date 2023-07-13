DESCRIPTION = "Bluetooth LE Application to advertise on boot-up"
LICENSE = "CLOSED"

SRCREV = "${AUTOREV}"

SRC_URI += "file://bleadvhci.service"
SRC_URI += "file://bleadvhci.path"

do_install_append() {
    install -d ${D}${systemd_unitdir}/system

    install -m 0644 ${WORKDIR}/bleadvhci.service       ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/bleadvhci.path          ${D}${systemd_unitdir}/system/
}

SYSTEMD_SERVICE_${PN}_remove = " bleadvhci.service"
SYSTEMD_SERVICE_${PN} += " bleadvhci.path"

FILES_${PN} = "${sysconfdir}/* \
               ${systemd_unitdir}/system/* \
              "
inherit systemd
