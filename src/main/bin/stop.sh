#!/usr/bin/env bash
readonly BIN_HOME=$(cd `dirname $0`; pwd)
source "$BIN_HOME/run-manage.sh" stop
exit 0