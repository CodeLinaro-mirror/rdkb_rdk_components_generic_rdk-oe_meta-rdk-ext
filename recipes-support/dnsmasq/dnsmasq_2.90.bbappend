FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}-${PV}:"

SRC_URI_remove = " file://addtruncatedmsgcaching.patch \
                   file://130-fingerprint-dhcp-lease-file.patch \
                 "
SRC_URI_append = " file://client_notify_v2.90.patch \
                   file://130-fingerprint-dhcp-lease-file-V2.90.patch \
                 "

do_install_append() {
    sed -i -- 's/listen-address=127.0.0.1/#listen-address=127.0.0.1/g' ${D}${sysconfdir}/dnsmasq.conf
    sed -i -- 's/bind/#Remove this statement/g' ${D}${sysconfdir}/dnsmasq.conf
}
