FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PACKAGECONFIG[mysql] = "--with-libmysql,--with-libmysql=no,mysql5,"
PACKAGECONFIG[gcrypt] = "--with-libgcrypt=${STAGING_BINDIR_CROSS}/libgcrypt-config,--with-libgcrypt=no,libgcrypt,"
PACKAGECONFIG[yajl] = "--with-libyajl,--with-libyajl=no,yajl,"
PACKAGECONFIG[dns] = "--with-libpcap,--with-libpcap=no,libpcap,"
#PACKAGECONFIG[curl] = "--with-libcurl,--with-libcurl=no,curl,"
#PACKAGECONFIG[debug] = "--enable-debug,--disable-debug,,"

DEPENDS_remove = "rrdtool"

EXTRA_OECONF := " \
                ${FPLAYOUT} \
                --disable-perl --with-libperl=no --with-perl-bindings=no \
                --disable-notify_desktop \
"

EXTRA_OECONF += " \
		--enable-mqtt \
"
