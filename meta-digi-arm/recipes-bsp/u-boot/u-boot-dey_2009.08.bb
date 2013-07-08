# Copyright (C) 2012 Digi International

DESCRIPTION = "Bootloader for Digi platforms"
require recipes-bsp/u-boot/u-boot.inc
include u-boot-dey-rev.inc

PROVIDES += "u-boot"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4c6cde5df68eff615d36789dc18edd3b"

PR = "r0"

S = "${WORKDIR}/git"

DEPENDS_mxs += "elftosb-native imx-bootlets-dey"

EXTRA_OEMAKE += 'HOSTSTRIP=true'
EXTRA_OEMAKE_append_mxs = ' BOOTLETS_DIR=${STAGING_DIR_TARGET}/boot'

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(ccardimx28js|ccimx51js|ccimx53js|cpx2|wr21)"
