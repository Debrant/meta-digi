# Copyright (C) 2012 Digi International

require recipes-kernel/linux/linux-dey.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

SRCBRANCH_external = ""
SRCBRANCH_external_mxs = "v3.10/dey-1.4/maint"
SRCBRANCH_external_mx6 = "v3.10/dey-1.6/maint"
SRCBRANCH_internal = ""
SRCBRANCH_internal_mxs = "v3.10/dey-1.4/maint"
SRCBRANCH_internal_mx6 = "v3.10/dey-1.6/maint"
SRCBRANCH = "${@base_conditional('DIGI_INTERNAL_GIT', '1' , '${SRCBRANCH_internal}', '${SRCBRANCH_external}', d)}"

SRCREV_external = ""
SRCREV_external_mxs = "57fcf89273ec603e169643a287630dc24153853c"
SRCREV_external_mx6 = "5d19f63261aa9b48f3dc9cc61867ad427b5fe967"
SRCREV_internal = ""
SRCREV_internal_mxs = "0b170bbc32090acf0fe92e8e3ee7e67b257dc95f"
SRCREV_internal_mx6 = "c6a8c426e4ec74c6cb7f67de40fc624f72b2fe60"
SRCREV = "${@base_conditional('DIGI_INTERNAL_GIT', '1' , '${SRCREV_internal}', '${SRCREV_external}', d)}"

# Kernel configuration fragments
KERNEL_CFG_FRAGS ?= ""
KERNEL_CFG_FRAGS_append = " ${@base_conditional('HAVE_EXAMPLE', '1' , 'file://config-spidev.cfg', '', d)}"

config_dts() {
	for DTB in ${KERNEL_DEVICETREE}; do
		if [ "${1}" = "enable" ]; then
			sed  -i -e "/${2}/{s,^///include,/include,g}" ${S}/arch/arm/boot/dts/${DTB%b}s
		elif [ "${1}" = "disable" ]; then
			sed  -i -e "/${2}/{s,^/include,///include,g}" ${S}/arch/arm/boot/dts/${DTB%b}s
		fi
	done
}

do_update_dts() {
	:
}

do_update_dts_mxs() {
	if [ -n "${HAVE_WIFI}" ]; then
		config_dts enable  '_ssp2_mmc_wifi.dtsi'
	else
		config_dts disable '_ssp2_mmc_wifi.dtsi'
	fi
	if [ -n "${HAVE_EXT_ETH}" ]; then
		config_dts enable  '_ethernet1.dtsi'
	else
		config_dts disable '_ethernet1.dtsi'
	fi
	if [ -n "${HAVE_BT}" ]; then
		config_dts enable  '_auart0_bluetooth.dtsi'
	else
		config_dts disable '_auart0_bluetooth.dtsi'
	fi
	if [ -n "${HAVE_1WIRE}" ]; then
		config_dts enable  '_onewire_i2c1.dtsi'
		config_dts disable '_auart2_4wires.dtsi'
	else
		config_dts disable '_onewire_i2c1.dtsi'
	fi
	if [ -n "${HAVE_GUI}" ]; then
		# Enable LCD
		config_dts enable  '_display_'
		config_dts disable '_auart1_'
		# Enable touch
		config_dts enable  '_lradc_touchscreen'
		config_dts disable '_ssp1_'
		config_dts disable '_auart1_4wires'
		config_dts disable '_ethernet0_leds'
	else
		# spidev conflicts with touchscreen, thus enable it only
		# when touch is disabled
		if [ -n "${HAVE_EXAMPLE}" ]; then
			config_dts enable 'ssp1_spi_gpio.dtsi'
			config_dts enable 'ssp1_spi_gpio_spidev.dtsi'
		fi
	fi
}
addtask update_dts before do_install after do_sizecheck

COMPATIBLE_MACHINE = "(mxs|mx6)"
