SUMMARY = "Vulkan ValidationLayers"
DESCRIPTION = "This project provides Vulkan validation layers that \
can be enabled to assist development by enabling developers to verify \
their applications correct use of the Vulkan API."
HOMEPAGE = "https://www.khronos.org/vulkan/"
BUGTRACKER = "https://github.com/KhronosGroup/Vulkan-ValidationLayers"
SECTION = "libs"

LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=7dbefed23242760aa3475ee42801c5ac"

SRC_URI += "git://github.com/KhronosGroup/Vulkan-ValidationLayers.git;branch=sdk-1.2.170;protocol=https \
           file://0001_header_change.patch"

SRCREV = "4fdcd0eebfed3505732720fc6fd98293e847d697"

S = "${WORKDIR}/git"

inherit cmake features_check 

ANY_OF_DISTRO_FEATURES = "x11 wayland"

DEPENDS += "vulkan-headers glslang spirv-tools spirv-headers"

EXTRA_OECMAKE = " \
    -DGLSLANG_INSTALL_DIR=${STAGING_DIR_HOST}/usr \
    -DSPIRV_HEADERS_INSTALL_DIR=${STAGING_DIR_HOST}/usr \
    -DSPIRV_TOOLS_INSTALL_DIR=${STAGING_DIR_HOST}/usr \
    "

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'wayland x11', d)}"

PACKAGECONFIG[x11] = "-DBUILD_WSI_XLIB_SUPPORT=ON -DBUILD_WSI_XCB_SUPPORT=ON -DDEMOS_WSI_SELECTION=XCB, -DBUILD_WSI_XLIB_SUPPORT=OFF -DBUILD_WSI_XCB_SUPPORT=OFF -DDEMOS_WSI_SELECTION=WAYLAND, libxcb libx11 libxrandr"
PACKAGECONFIG[wayland] = "-DBUILD_WSI_WAYLAND_SUPPORT=ON, -DBUILD_WSI_WAYLAND_SUPPORT=OFF, wayland"

# The output library is unversioned
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

UPSTREAM_CHECK_GITTAGREGEX = "sdk-(?P<pver>\d+(\.\d+)+)"

FILES_${PN} += "/usr/share"
FILES_${PN} += "/usr/share/vulkan"
FILES_${PN} += "/usr/share/vulkan/explicit_layer.d"
FILES_${PN} += "/usr/share/vulkan/explicit_layer.d/VkLayer_khronos_validation.json"

