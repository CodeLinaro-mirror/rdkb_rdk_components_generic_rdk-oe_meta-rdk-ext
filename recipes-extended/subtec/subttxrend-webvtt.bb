##############################################################################
# Copyright © 2018 Liberty Global B.V. and its Licensors.
# All rights reserved.
# Licensed by RDK Management, LLC under the terms of the RDK license.
# ============================================================================
# Liberty Global B.V. CONFIDENTIAL AND PROPRIETARY
# ============================================================================
# This file (and its contents) are the intellectual property of Liberty Global B.V.
# It may not be used, copied, distributed or otherwise disclosed in whole or in
# part without the express written permission of Liberty Global B.V.
# The RDK License agreement constitutes express written consent by Liberty Global.
# ============================================================================
# This software is the confidential and proprietary information of Liberty Global B.V.
# ("Confidential Information"). You shall not disclose this source code or
# such Confidential Information and shall use it only in accordance with the
# terms of the license agreement you entered into.
#
# LIBERTY GLOBAL B.V. MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE
# SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT
# LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
# PARTICULAR PURPOSE, OR NON-INFRINGEMENT. LIBERTY GLOBAL B.V. SHALL NOT BE LIABLE FOR
# ANY DAMAGES SUFFERED BY LICENSEE NOR SHALL THEY BE RESPONSIBLE AS A RESULT
# OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
##############################################################################
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://../LICENSES.TXT;md5=6cbc1dc640d083a921a4f858b5ca3c18"
DEPENDS = "subttxrend-common subttxrend-gfx"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRCREV = "${AUTOREV}"
SRC_URI = "${CMF_GIT_ROOT}/components/generic/subtec-app;protocol=${RDK_GIT_PROTOCOL};branch=${CMF_GIT_MASTER_BRANCH} \
            "
            
S = "${WORKDIR}/git/subttxrend-webvtt"

#
# pkgconfig         - pkgconfig used in cmake (adds dependency)
# cmake             - cmake build system used
#

inherit pkgconfig cmake coverity