#!/bin/sh

#There shouldn't be a file here - if there is already a regular file here, it needs to be deleted
if [ "$SOC" = "AMLOGIC" ] ; then
    if [ -f /opt/lib/bluetooth]; then
        rm /opt/lib/bluetooth;
    fi
fi

/bin/mkdir -p /var/lib/bluetooth
/bin/mkdir -p /opt/lib/bluetooth

if [ -d /opt/secure/lib/bluetooth ]; then
    cp -r /opt/secure/lib/bluetooth /opt/lib/
    rm -r /opt/secure/lib/bluetooth
fi
