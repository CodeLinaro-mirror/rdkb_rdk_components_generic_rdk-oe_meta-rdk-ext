#to run this, please disable the YouTube and ResidentApp apps using the thunder controller at <ip>:9998
gst-play-1.0 MLvideoonly2.m4v --videosink=westerossink 2>&1 1>/dev/null 0>/dev/null &
PIPEWIRE_RUNTIME_DIR=/tmp/pipewire/ pw-play multilanguageEnglish.wav &
PIPEWIRE_RUNTIME_DIR=/tmp/pipewire/ pw-play multilanguagevideoGerman.wav &
PIPEWIRE_RUNTIME_DIR=/tmp/pipewire/ pw-play multilanguagefrench.wav &
sleep 1
output=$(PIPEWIRE_RUNTIME_DIR=/tmp/pipewire/ pw-link -lI)
echo $output
echo "$output" | while read -r line; do
if [[ $line == *"pw-play:output"* ]]; then
  id=$(echo "$line" | awk '{print $1}')
  echo Running: pw-link -d "$id"
  PIPEWIRE_RUNTIME_DIR=/tmp/pipewire pw-link -d "$id"
fi
done
sleep 1
output=$(PIPEWIRE_RUNTIME_DIR=/tmp/pipewire/ pw-link -oI)
id_list=()

while IFS= read -r line; do
  if [[ $line == *"pw-play:output_"* ]]; then
    id=$(echo $line | awk '{print $1}')
    id_list+=("$id")
  fi
done <<< "$output"

# Print the list of IDs
echo "IDs: ${id_list[@]}"

PIPEWIRE_RUNTIME_DIR=/tmp/pipewire pw-link ${id_list[0]} alsa_output.platform-bcm2835_audio.2.stereo-fallback:playback_FL
PIPEWIRE_RUNTIME_DIR=/tmp/pipewire pw-link ${id_list[1]} alsa_output.platform-bcm2835_audio.2.stereo-fallback:playback_FR
PIPEWIRE_RUNTIME_DIR=/tmp/pipewire pw-link ${id_list[2]} alsa_output.platform-bcm2835_audio.stereo-fallback:playback_FL
PIPEWIRE_RUNTIME_DIR=/tmp/pipewire pw-link ${id_list[3]} alsa_output.platform-bcm2835_audio.stereo-fallback:playback_FR
#change following lines to match your bluetooth device (Can find the ports in 'pw-link -o')
PIPEWIRE_RUNTIME_DIR=/tmp/pipewire pw-link ${id_list[4]} bluez_output.30_82_16_9D_DC_E3.1:playback_FL
PIPEWIRE_RUNTIME_DIR=/tmp/pipewire pw-link ${id_list[5]} bluez_output.30_82_16_9D_DC_E3.1:playback_FR

