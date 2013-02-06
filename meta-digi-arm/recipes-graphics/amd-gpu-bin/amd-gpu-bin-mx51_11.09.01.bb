# Copyright (C) 2011, 2012 Freescale
# Copyright (C) 2012 Digi International
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "GPU driver and apps on mx5x"
LICENSE = "Proprietary"
SECTION = "libs"
PR = "r11"

#todo: Replace for correct AMD license
LIC_FILES_CHKSUM = "file://usr/include/VG/openvg.h;endline=30;md5=b0109611dd76961057d4c45ae6519802"

DEPENDS = "libz160"
PROVIDES = "virtual/egl virtual/libgles1 virtual/libgles2"
RDEPENDS = "libz160"

SRC_URI = "${DIGI_LOG_MIRROR}/amd-gpu-bin-mx51-${PV}.tar.gz"
SRC_URI[md5sum] = "15ede91135590fc12cc29a2bba46c12c"
SRC_URI[sha256sum] = "c87ad4e0c721a10e9faed9e096e180b326162e342d41cdfc14c5119110bde0f4"

# FIXME: All binaries lack GNU_HASH in elf binary but as we don't have
# the source we cannot fix it. Disable the insane check for now.
python populate_packages_prepend() {
    for p in d.getVar('PACKAGES', True).split():
        d.setVar("INSANE_SKIP_%s" % p, "ldflags")
}

do_install () {
    install -d ${D}${libdir}
    install -d ${D}${bindir}
    install -d ${D}${includedir}

    cp -axr ${S}/usr/bin/* ${D}${bindir}
    cp -axf ${S}/usr/lib/* ${D}${libdir}
    cp -axr ${S}/usr/include/* ${D}${includedir}

    find ${D}${bindir} -type f -exec chmod 755 {} \;
    find ${D}${libdir} -type f -exec chmod 644 {} \;
    find ${D}${includedir} -type f -exec chmod 644 {} \;

    # FIXME: Fix sonames of broken libraries
    mv ${D}${libdir}/lib2dz160.so ${D}${libdir}/lib2dz160.so.0
    mv ${D}${libdir}/lib2dz430.so ${D}${libdir}/lib2dz430.so.0

    # FIXME: Remove unkown files
    rm -r ${D}${libdir}/libcsi.a \
          ${D}${libdir}/libres.a
}

PACKAGES =+ "libgsl-fsl-mx51 libgsl-fsl-mx51-dev libgsl-fsl-mx51-dbg \
             libegl-mx51 libegl-mx51-dev libegl-mx51-dbg \
             libgles-mx51 libgles-mx51-dev libgles-mx51-dbg \
             libgles2-mx51 libgles2-mx51-dev libgles2-mx51-dbg \
             libopenvg-mx51 libopenvg-mx51-dev libopenvg-mx51-dbg \
             lib2dz160-mx51 lib2dz160-mx51-dbg \
             lib2dz430-mx51 lib2dz430-mx51-dbg"

FILES_${PN}-dbg = "${bindir}/.debug/*"

FILES_libgsl-fsl-mx51 = "${libdir}/libgsl-fsl${SOLIBS}"
FILES_libgsl-fsl-mx51-dev = "${libdir}/libgsl-fsl${SOLIBSDEV}"
FILES_libgsl-fsl-mx51-dbg = "${libdir}/.debug/libgsl-fsl${SOLIBS}"

FILES_libegl-mx51 = "${libdir}/libEGL${SOLIBS}"
FILES_libegl-mx51-dev = "${includedir}/EGL ${includedir}/KHR ${libdir}/libEGL${SOLIBSDEV}"
FILES_libegl-mx51-dbg = "${libdir}/.debug/libEGL${SOLIBS}"

FILES_libgles-mx51 = "${libdir}/libGLESv1*${SOLIBS}"
FILES_libgles-mx51-dev = "${includedir}/GLES ${libdir}/libGLESv1*${SOLIBSDEV}"
FILES_libgles-mx51-dbg = "${libdir}/.debug/libGLESv1*${SOLIBS}"

FILES_libgles2-mx51 = "${libdir}/libGLESv2${SOLIBS}"
FILES_libgles2-mx51-dev = "${includedir}/GLES2 ${libdir}/libGLESv2${SOLIBSDEV}"
FILES_libgles2-mx51-dbg = "${libdir}/.debug/libGLESv2${SOLIBS}"

FILES_libopenvg-mx51 = "${libdir}/libOpenVG${SOLIBS}"
FILES_libopenvg-mx51-dev = "${includedir}/VG ${libdir}/libOpenVG${SOLIBSDEV}"
FILES_libopenvg-mx51-dbg = "${libdir}/.debug/libOpenVG${SOLIBS}"

FILES_lib2dz160-mx51 = "${libdir}/lib2dz160${SOLIBS}"
FILES_lib2dz160-mx51-dbg = "${libdir}/.debug/lib2dz160${SOLIBS}"

FILES_lib2dz430-mx51 = "${libdir}/lib2dz430${SOLIBS}"
FILES_lib2dz430-mx51-dbg = "${libdir}/.debug/lib2dz430${SOLIBS}"

COMPATIBLE_MACHINE = "(mx5)"
PACKAGE_ARCH = "${MACHINE_ARCH}"
