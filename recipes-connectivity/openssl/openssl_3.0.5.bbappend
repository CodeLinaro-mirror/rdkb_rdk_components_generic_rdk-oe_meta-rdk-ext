FILESEXTRAPATHS_prepend:="${THISDIR}/${PN}:"

SRC_URI_append = " file://CVE-2022-4304_openssl_3.0.5_fix.patch \
                   file://CVE-2023-0464_openssl_3.0.5_fix.patch \
                   file://CVE-2023-0465_openssl_3.0.5_fix.patch \
                   file://CVE-2023-0466_openssl_3.0.5_fix.patch \
                 "
SRC_URI_append_broadband = " file://CVE-2023-1255_openssl_3.0.5_fix.patch \
                             file://CVE-2023-2650_openssl_3.0.5_fix.patch \
                             file://CVE-2023-2975_openssl_3.0.5_fix.patch \
                             file://CVE-2023-3817_openssl_3.0.5_fix.patch \
                             file://CVE-2023-4807_openssl_3.0.5_fix.patch \
                           "
