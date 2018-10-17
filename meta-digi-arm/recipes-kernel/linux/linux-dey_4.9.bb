# Copyright (C) 2017, 2018 Digi International

SRC_URI = "https://github.com/Debrant/linux.git"

SRCBRANCH = "v4.9/dey-2.4/maint"

SRCREV = "${AUTOREV}"

require recipes-kernel/linux/linux-dey.inc

COMPATIBLE_MACHINE = "(ccimx6|ccimx6ul|ccimx8x)"
