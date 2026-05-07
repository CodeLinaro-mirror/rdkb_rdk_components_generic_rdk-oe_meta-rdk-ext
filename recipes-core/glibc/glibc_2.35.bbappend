FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

FULL_OPTIMIZATION_remove = "-Os"
FULL_OPTIMIZATION_append = "-O2"

SRC_URI_append = " file://CVE-2023-0687_2.35_fix.patch \
                   file://CVE-2023-4813_2.35_fix.patch \
                   file://CVE-2023-4911_2.35_fix.patch \
                   file://CVE-2024-33599_2.35_fix.patch \
                   file://CVE-2025-4802_2.35_fix.patch \
                   file://CVE-2025-15281_2.35_fix.patch \
                   file://CVE-2024-33601_2.35_fix.patch \
                   file://CVE-2026-0915_2.35_fix.patch \
                 "
