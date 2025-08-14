FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI_append = " file://logrotate-update-service-files.patch \
                   file://logrotate_memory_issues.patch \
                   file://logrotate-update-log-files.patch \
		   file://fix_fd_leak.patch \
                 "
