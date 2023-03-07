# This file can be included by any module that wish to enable AddressSanitizer
# By default all bbappend files are disabled with BBMASK (DISTRO_FEATURE enable_asan)
# inside layer.conf
DEPENDS_append_class-target = " gcc-sanitizers"
TUNE_CCARGS_append = " -fno-omit-frame-pointer -fno-optimize-sibling-calls -fstack-protector -pthread -fsanitize=address"
TUNE_LDARGS_append = " -fsanitize=address -lasan -lubsan -lpthread"
