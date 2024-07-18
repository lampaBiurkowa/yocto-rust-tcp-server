FILESEXTRAPATHS:prepend := "${THISDIR}:"
SRC_URI += "file://rust.cfg"

KERNEL_MODULE_AUTOLOAD:append = "g_ether"