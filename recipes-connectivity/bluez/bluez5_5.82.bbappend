FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://bluez5p80-resolve-compilation.patch"

SRC_URI += " \
            file://bt_original_path_setup.sh \
            file://0002-bluez-5.6xx-bluetooth_autoenable_policy_main_conf.patch \
            file://0001-libexecdir-location-5.7xx.patch \
            file://0005-clear_old_cache_list.patch \
            file://0003-force-gatt-discovery-op-to-complete.patch \
            file://0004-enable_auto_connect_on_all_disconnects.patch \
            file://0005-enable-auto-connect.patch \
            file://0006-Fix-input-hog-connection-with-slow-pairing-devices.patch \
            file://0007-create_storage_directory_before_starting_service.patch \
            file://0008-bluez-crash-fixes.patch \
            file://0009-delete-autoconnect-on-remove.patch \
            file://0010-ensure-bluez-connects-on-bredr-to-audio-devices.patch \
            file://0011-disable-avc-passthrough-uinput.patch \
            file://0012-change_cache_clear_timeout.patch \
            file://0013-disable-irk-storage-for-sky-devices.patch \
            file://0014-bluetooth_configuration_hardening.patch \
            file://0015-improve_firmware_upload_ruwido.patch \
            file://0016-main_configuration_hardening.patch \
            file://0017-enable_bdaddr.patch \
            file://0018-bluez-stream-free-and-a2dp_ref_negative-crash-fixes.patch \
            file://0019-make-storage-dir-runtime-configurable.patch \
            file://0020-add-configurable-delayed-gatt-connection.patch \
            file://0021-add-hog-service-for-skyq-rcus.patch \
            file://0022-restore-pairing-info-after-kernel-crash.patch \
            file://0023-ble-xbox-privacy-device.patch \
            file://0024-bluez-from-5.48-disable_sigpipe_signal.patch \
            file://0025-Gen4-Crash-avoid.patch \
            file://0026-bt_uuid_to_uuid128-crash.patch \
            file://0027-set-ad-flags-and-update-cache-timeout.patch \
            file://0028-set-le-hid-auto-connect-flags.patch \
            file://0029-RDK-56281-BT-SIG-PTS-disable-gatt-server-opcodes.patch \
            file://0030-gatt-db-service-crash.patch \
            file://0031-prevent-scan-stuck-and-stop-scan-when-adapter-busy.patch \
            file://0032-breakpad.patch \
           "
