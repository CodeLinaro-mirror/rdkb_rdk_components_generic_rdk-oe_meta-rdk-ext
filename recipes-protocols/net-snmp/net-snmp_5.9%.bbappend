EXTRAPATHS_prepend := "${THISDIR}/${BP}:"

SRC_URI:append = " file://0001-Fix-safe-handling-of-malloc-realloc-failures.patch"
