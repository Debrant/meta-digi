# Digi Embedded Yocto (DEY) 2.4
## Release 2.4-experimental
This document provides information about Digi Embedded Yocto,
Digi International's professional embedded Yocto development environment.

Digi Embedded Yocto 2.4 is based on the Yocto Project(TM) 2.4 (Rocko) release.

For a full list of supported features and interfaces please refer to the
online documentation.

# Tested OS versions

The current release has been verified and tested with the following
OS versions:

* Ubuntu 16.04

# Supported Platforms

Software for the following hardware platforms is in production support:

## ConnectCore 6UL
* ConnectCore 6UL System-on-Module (SOM)
  * [CC-WMX-JN58-NE](https://www.digi.com/products/models/cc-wmx-jn58-ne)
  * [CC-MX-JN58-Z1](https://www.digi.com/products/models/cc-mx-jn58-z1)
  * CC-WMX-JN7A-NE
* ConnectCore 6UL SBC Express
  * [CC-WMX6UL-START](https://www.digi.com/products/models/cc-wmx6ul-start) ([Get Started](https://www.digi.com/resources/documentation/digidocs/90001548/default.htm#concept/yocto/c_get_started_with_yocto.htm))
  * [CC-SBE-WMX-JN58](https://www.digi.com/products/models/cc-sbe-wmx-jn58)
* ConnectCore 6UL SBC Pro
  * [CC-WMX6UL-KIT](https://www.digi.com/products/models/cc-wmx6ul-kit) ([Get Started](https://www.digi.com/resources/documentation/digidocs/90001547/default.htm#concept/yocto/c_get_started_with_yocto.htm))
  * [CC-SBP-WMX-JN58](https://www.digi.com/products/models/cc-sbp-wmx-jn58)

## ConnectCore 6
* ConnectCore 6 System-on-Module (SOM)
  * [CC-WMX-J97C-TN](https://www.digi.com/products/models/cc-wmx-j97c-tn)
  * [CC-WMX-L96C-TE](https://www.digi.com/products/models/cc-wmx-l96c-te)
  * [CC-WMX-L87C-TE](https://www.digi.com/products/models/cc-wmx-l87c-te)
  * [CC-MX-L76C-Z1](https://www.digi.com/products/models/cc-mx-l76c-z1)
  * [CC-MX-L86C-Z1](https://www.digi.com/products/models/cc-mx-l86c-z1)
  * [CC-MX-L96C-Z1](https://www.digi.com/products/models/cc-mx-l96c-z1)
  * [CC-WMX-L76C-TE](https://www.digi.com/products/models/cc-wmx-l76c-te)
  * CC-WMX-K87C-FJA
  * CC-WMX-K77C-TE
  * CC-WMX-L97D-TN
  * CC-WMX-J98C-FJA
  * CC-WMX-J98C-FJA-1
* ConnectCore 6 SBC
  * [CC-WMX6-KIT](https://www.digi.com/products/models/cc-wmx6-kit) ([Get Started](https://www.digi.com/resources/documentation/digidocs/90001546/default.htm#concept/yocto/c_get_started_with_yocto.htm))
  * [CC-SB-WMX-J97C-1](https://www.digi.com/products/models/cc-sb-wmx-j97c-1)
  * [CC-SB-WMX-L87C-1](https://www.digi.com/products/models/cc-sb-wmx-l87c-1)
  * [CC-SB-WMX-L76C-1](https://www.digi.com/products/models/cc-sb-wmx-l76c-1)

## ConnectCore 6 Plus
* ConnectCore 6 Plus System-on-Module (SOM)
  * CC-WMX-KK8D-TN
* ConnectCore 6 Plus SBC
  * CC-SB-WMX-KK8D

Previous versions of Digi Embedded Yocto include support for additional Digi
hardware.

# Installation

Digi Embedded Yocto is composed of a set of different Yocto layers that work in
parallel. The layers are specified on a [manifest](https://github.com/digi-embedded/dey-manifest/blob/rocko_experimental/default.xml) file.

To install, please follow the instructions at the dey-manifest [README](https://github.com/digi-embedded/dey-manifest)

# Documentation

Documentation is available online on the Digi documentation site:

* [ConnectCore 6UL SBC Express](https://www.digi.com/resources/documentation/digidocs/90001548/default.htm)
* [ConnectCore 6UL SBC Pro](https://www.digi.com/resources/documentation/digidocs/90001547/default.htm)
* [ConnectCore 6 SBC](https://www.digi.com/resources/documentation/digidocs/90001546/default.htm)
* [ConnectCore 6 Plus SBC](https://www.digi.com/resources/documentation/digidocs/90002275/default.htm)


# Release Changelog

## 2.4-experimental

* Release based on [Yocto 2.4 (Rocko)](https://www.yoctoproject.org/downloads/core/rocko24)
