FILESEXTRAPATHS_append := "${THISDIR}/${BPN}-${PV}:"

def get_64_bit_sed_patch(d):
    if d.getVar('MACHINE_IMAGE_NAME', True) in [ 'CGM601TCOM', 'SG417DBCT', 'SCER11BEL', 'CVA601ZCOM' ]:
        return "file://sed-4.1.2-fix-warnings-and-signal-11-in-64bit.patch"
    else:
        return " "

SRC_URI += "${@get_64_bit_sed_patch(d)}"
