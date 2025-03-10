PIPEWIRE_RUNTIME_DIR=/tmp/pipewire pw-play --channels=6 --target=0 AAC\ 5.1.wav &
sleep 1
PIPEWIRE_RUNTIME_DIR=/tmp/pipewire pw-link pw-play:output_FL alsa_output.platform-bcm2835_audio.stereo-fallback:playback_FL
PIPEWIRE_RUNTIME_DIR=/tmp/pipewire pw-link pw-play:output_FR alsa_output.platform-bcm2835_audio.stereo-fallback:playback_FR
PIPEWIRE_RUNTIME_DIR=/tmp/pipewire pw-link pw-play:output_FC alsa_output.platform-bcm2835_audio.2.stereo-fallback:playback_FL
PIPEWIRE_RUNTIME_DIR=/tmp/pipewire pw-link pw-play:output_LFE alsa_output.platform-bcm2835_audio.2.stereo-fallback:playback_FR
#change following lines to match your bluetooth device (Can find the ports in 'pw-link -o')
PIPEWIRE_RUNTIME_DIR=/tmp/pipewire pw-link pw-play:output_SL bluez_output.28_FA_19_D2_2B_31.1:playback_FL
PIPEWIRE_RUNTIME_DIR=/tmp/pipewire pw-link pw-play:output_SR bluez_output.28_FA_19_D2_2B_31.1:playback_FR
