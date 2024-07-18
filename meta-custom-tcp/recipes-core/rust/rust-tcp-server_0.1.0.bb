# Auto-Generated by cargo-bitbake 0.3.16
#
inherit cargo

# If this is git based prefer versioned ones if they exist
# DEFAULT_PREFERENCE = "-1"

# how to get rust-tcp-server could be as easy as but default to a git checkout:
# SRC_URI += "crate://crates.io/rust-tcp-server/0.1.0"
SRC_URI += "git://github.com/lampaBiurkowa/yocto-rust-tcp-server.git;protocol=https;nobranch=1"
SRCREV = "95040a093516a7015ff5c508bb3735449dafb766"
S = "${WORKDIR}/git"
CARGO_SRC_DIR = ""
PV:append = ".AUTOINC+95040a0935"

# please note if you have entries that do not begin with crate://
# you must change them to how that package can be fetched
SRC_URI += " \
    crate://crates.io/ahash/0.8.11 \
    crate://crates.io/bitflags/2.6.0 \
    crate://crates.io/cfg-if/1.0.0 \
    crate://crates.io/fallible-iterator/0.3.0 \
    crate://crates.io/fallible-streaming-iterator/0.1.9 \
    crate://crates.io/hashbrown/0.14.5 \
    crate://crates.io/hashlink/0.9.1 \
    crate://crates.io/libsqlite3-sys/0.28.0 \
    crate://crates.io/once_cell/1.19.0 \
    crate://crates.io/pkg-config/0.3.30 \
    crate://crates.io/proc-macro2/1.0.86 \
    crate://crates.io/quote/1.0.36 \
    crate://crates.io/rusqlite/0.31.0 \
    crate://crates.io/smallvec/1.13.2 \
    crate://crates.io/syn/2.0.71 \
    crate://crates.io/unicode-ident/1.0.12 \
    crate://crates.io/vcpkg/0.2.15 \
    crate://crates.io/version_check/0.9.4 \
    crate://crates.io/zerocopy-derive/0.7.35 \
    crate://crates.io/zerocopy/0.7.35 \
"



# FIXME: update generateme with the real MD5 of the license file
LIC_FILES_CHKSUM = " \
    "

SUMMARY = "based on Yocto Project Virtual Summit 2020 demo"
HOMEPAGE = "https://github.com/lampaBiurkowa/yocto-rust-tcp-server.git"
LICENSE = "CLOSED"

# includes this file if it exists but does not fail
# this is useful for anything you may want to override from
# what cargo-bitbake generates.
include rust-tcp-server-${PV}.inc
include rust-tcp-server.inc
