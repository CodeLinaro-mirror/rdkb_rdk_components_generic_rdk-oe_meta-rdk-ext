cp /home/root/bluetoothhfponly.conf /usr/share/wireplumber/wireplumber.conf.d/bluetooth.conf
systemctl daemon-reload
systemctl restart pipewire wireplumber
sleep 1
cd /tmp/pipewire/
chmod 777 *
echo Karaoke setup done
