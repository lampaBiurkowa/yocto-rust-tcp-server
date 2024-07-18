LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
SRC_URI = "file://configure-ip.sh file://configure-ip.service"

RDEPENDS:${PN} = "bash"

do_install() {
    echo "haha"
    echo ${bindir}
    echo ${D}${systemd_unitdir}/system/configure-ip.service
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/configure-ip.sh ${D}${bindir}/configure-ip.sh

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/configure-ip.service ${D}${systemd_unitdir}/system/configure-ip.service
    echo "sraka"
}

FILES:${PN} += "${systemd_unitdir}/system/configure-ip.service"

SYSTEMD_SERVICE_${PN} = "configure-ip.service"
SYSTEMD_AUTO_ENABLE = "enable"