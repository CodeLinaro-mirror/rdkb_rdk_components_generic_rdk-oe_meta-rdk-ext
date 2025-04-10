RDEPENDS_packagegroup-cpc-mediaclient_remove_dunfell = " ${@bb.utils.contains('DISTRO_FEATURES','rdm','bind-dl',' ',d)}"
RDEPENDS_packagegroup-cpc-mediaclient_remove_kirkstone = " ${@bb.utils.contains('DISTRO_FEATURES','rdm','bind-dl',' ',d)}"
