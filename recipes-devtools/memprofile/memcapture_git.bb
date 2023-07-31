SUMMARY = "Memcapture"
LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=41f7ad6513191953eb3e0b1e480a7ddb"

SRC_URI = "git://github.com/TeknoVenus/MemCapture.git;branch=master"
SRC_URI += "file://groups.json"
SRCREV = "9dd5d79e59850b50f5ae54861bf922a493f64f16"

S = "${WORKDIR}/git"
B = "${WORKDIR}/git/build"

DEPENDS = "breakpad breakpad-wrapper"

inherit cmake syslog-ng-config-gen
EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release"

SYSLOG-NG_FILTER = "memcapture"
SYSLOG-NG_SERVICE_memcapture = "memcapture.service"
SYSLOG-NG_DESTINATION_memcapture = "memcapture.log"
SYSLOG-NG_LOGRATE_memcapture = "high"

# Breakpad processname and logfile mapping
BREAKPAD_LOGMAPPER_PROCLIST = "memcapture"
BREAKPAD_LOGMAPPER_LOGLIST = "memcapture.log"

do_install () {
    install -d ${D}${bindir}
    install -d ${D}${sysconfdir}
    install -m 4755 ${B}/MemCapture ${D}${bindir}
    install -m 0600 ${WORKDIR}/groups.json ${D}${sysconfdir}/groups.json
}

FILES_${PN} += "${bindir}/MemCapture \
                ${sysconfdir}/groups.json \
               "
