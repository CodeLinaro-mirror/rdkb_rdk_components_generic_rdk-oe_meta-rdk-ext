#this is to run the video with the resident app and youtube disabled. To run with youtube use the commented lines at the bottom
PIPEWIRE_RUNTIME_DIR=/tmp/pipewire/ gst-play-1.0 backupAudioConvert.wav --audiosink=pipewiresink 2>&1 1>/dev/null 0>/dev/null &
gst-launch-1.0 playbin uri=file:///home/root/backupAudioConvert.m4v video-sink="westerossink zorder=1.0" &
sleep 5
PIPEWIRE_RUNTIME_DIR="/tmp/pipewire/" pw-link gst-play-1.0 alsa_output.platform-bcm2835_audio.2.stereo-fallback
sleep 3
PIPEWIRE_RUNTIME_DIR="/tmp/pipewire/" pw-link bluez_input.30_82_16_9D_DC_E3.0 alsa_output.platform-bcm2835_audio.2.stereo-fallback
PIPEWIRE_RUNTIME_DIR="/tmp/pipewire/" pw-link -d gst-play-1.0 bluez_output.30_82_16_9D_DC_E3.0
sleep 1

#PIPEWIRE_RUNTIME_DIR="/tmp/pipewire/" pw-link WPEProcess alsa_output.platform-bcm2835_audio.2.stereo-fallback
# sleep 3
# PIPEWIRE_RUNTIME_DIR="/tmp/pipewire/" pw-link bluez_input.30_82_16_9D_DC_E3.0 alsa_output.platform-bcm2835_audio.2.stereo-fallback
# PIPEWIRE_RUNTIME_DIR="/tmp/pipewire/" pw-link -d WPEProcess bluez_output.30_82_16_9D_DC_E3.0