#!/bin/bash - 
#===============================================================================
#
#          FILE:  btrace.sh
# 
#         USAGE:  ./btrace.sh 
# 
#   DESCRIPTION:  
# 
#       OPTIONS:  ---
#  REQUIREMENTS:  ---
#          BUGS:  ---
#         NOTES:  ---
#        AUTHOR: YOUR NAME (), 
#       COMPANY: 
#       CREATED: 2011年01月25日 19时15分29秒 CST
#      REVISION:  ---
#===============================================================================

set -o nounset                              # Treat unset variables as an error

export JAVA_HOME=/usr/lib/jvm/java-6-sun

/opt/btrace/bin/btrace -cp /opt/btrace/build 26026 /home/wuzhong/workspace/btrace-demo/src/main/java/com/taobao/wireless/MyTaobao.java
