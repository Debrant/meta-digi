# Copyright (C) 2013 Digi International.

SUMMARY = "Atheros's wireless driver"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/ISC;md5=f3b90e78ea0cffb20bf5cca7947a896d"

inherit module

PR = "r1"

# 'modprobe' from kmod package is needed to load atheros driver. The one
# from busybox does not support '--ignore-install' option.
RDEPENDS_${PN} = "kmod"

SRCREV_external = "621b43aef3f4611500c461ef8940fa7990d55d9e"
SRCREV_internal = "fdb797adf47514f5c94921fb20e64b4ecadb7a52"
SRCREV = "${@base_conditional('DIGI_INTERNAL_GIT', '1' , '${SRCREV_internal}', '${SRCREV_external}', d)}"

SRC_URI_external = "${DIGI_GITHUB_GIT}/atheros.git;protocol=git;nobranch=1"
SRC_URI_internal = "${DIGI_GIT}linux-modules/atheros.git;protocol=git;nobranch=1"
SRC_URI  = "${@base_conditional('DIGI_INTERNAL_GIT', '1' , '${SRC_URI_internal}', '${SRC_URI_external}', d)}"
SRC_URI += " \
    file://atheros \
    file://Makefile \
    ${@base_conditional('IS_KERNEL_2X', '1' , '', 'file://0001-atheros-convert-NLA_PUT-macros.patch', d)} \
    ${@base_conditional('IS_KERNEL_2X', '1' , '', 'file://0002-atheros-update-renamed-struct-members.patch', d)} \
"

# MX6 wireless calibration file
SRC_URI_append_mx6 = " file://Digi_6203-6233-US.bin"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "DEL_PLATFORM=${MACHINE} KLIB_BUILD=${STAGING_KERNEL_DIR}"

do_configure_prepend() {
	cp ${WORKDIR}/Makefile ${S}/
}

do_configure_prepend_mx6() {
	cp ${WORKDIR}/Digi_6203-6233-US.bin ${S}/Firmware_Package/target/AR6003/hw2.1.1/
}

do_install_append() {
	install -d ${D}${sysconfdir}/network/if-pre-up.d
	install -m 0755 ${WORKDIR}/atheros ${D}${sysconfdir}/network/if-pre-up.d/
	install -d ${D}${sysconfdir}/modprobe.d
	cat >> ${D}${sysconfdir}/modprobe.d/atheros.conf <<-_EOF_
		install ath6kl_sdio true
		options ath6kl_sdio ath6kl_p2p=1 softmac_enable=1
	_EOF_
}

FILES_${PN} += " \
    ${base_libdir}/firmware/ \
    ${sysconfdir}/modprobe.d/ \
    ${sysconfdir}/network/ \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mxs|mx6)"
