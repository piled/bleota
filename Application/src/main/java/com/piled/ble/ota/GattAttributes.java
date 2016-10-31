package com.piled.ble.ota;

import java.util.HashMap;

public class GattAttributes {
    private static HashMap<String, String> attributes = new HashMap();
    public static String GENERIC = "00001800-0000-1000-8000-00805f9b34fb";
    public static String BATTERY = "0000180f-0000-1000-8000-00805f9b34fb";
    public static String DEVICE_INFO = "0000180a-0000-1000-8000-00805f9b34fb";
    public static String CL_SERVICE = "37c7bbf1-b06a-11e3-8000-b70f3ab862a4";

    public static String DEVICE_NAME = "00002a00-0000-1000-8000-00805f9b34fb";
    public static String DEVICE_APPERANCE = "00002a01-0000-1000-8000-00805f9b34fb";
    public static String BATTERY_LEVEL = "00002a19-0000-1000-8000-00805f9b34fb";
    public static String MODEL = "00002a24-0000-1000-8000-00805f9b34fb";
    public static String FIRMWARE_REVISION = "00002a26-0000-1000-8000-00805f9b34fb";
    public static String HARDWARE_REVISION = "00002a27-0000-1000-8000-00805f9b34fb";
    public static String SOFTWARE_REVISION = "00002a28-0000-1000-8000-00805f9b34fb";
    public static String Manufacturer = "00002a29-0000-1000-8000-00805f9b34fb";
    //public static String DEVICE_NAME = "00002a00-0000-1000-8000-00805f9b34fb";
    //public static String DEVICE_NAME = "00002a00-0000-1000-8000-00805f9b34fb";
    public static String HEART_RATE_MEASUREMENT = "00002a37-0000-1000-8000-00805f9b34fb";
    public static String CLIENT_CHARACTERISTIC_CONFIG = "00002902-0000-1000-8000-00805f9b34fb";
    public static String OTA_FLASH_IN_CHARACTERISTIC = "37c7bbf1-b06a-11e3-8000-b70f3ab862a4";
    public static String OTA_FLASH_OUT_CHARACTERISTIC = "37c7bbf2-b06a-11e3-8000-b70f3ab862a4";
    public static String OTA_FLASH_COMPLETE_CHARACTERISTIC = "37c7bbf3-b06a-11e3-8000-b70f3ab862a4";

    static {
        // Sample Services.
        attributes.put(DEVICE_INFO, "Device Info");
        attributes.put(BATTERY, "Battery");
        attributes.put("0000180d-0000-1000-8000-00805f9b34fb", "Heart Rate Service");
        attributes.put("0000180a-0000-1000-8000-00805f9b34fb", "Device Information Service");
        // Sample Characteristics.
        attributes.put(DEVICE_NAME, "Device Name");
        attributes.put(DEVICE_APPERANCE, "Device Apperance");
        attributes.put(BATTERY_LEVEL, "Battery level");
        attributes.put(MODEL, "Model");
        attributes.put(FIRMWARE_REVISION, "Firmware revision");
        attributes.put(HARDWARE_REVISION, "Hardware revision");
        attributes.put(SOFTWARE_REVISION, "Software revision");
        attributes.put(Manufacturer, "Manufacturer Name");
        attributes.put(HEART_RATE_MEASUREMENT, "Heart Rate Measurement");
        attributes.put(OTA_FLASH_IN_CHARACTERISTIC, "OTA Flash In");
        attributes.put(OTA_FLASH_OUT_CHARACTERISTIC, "OTA Flash Out");
        attributes.put(OTA_FLASH_COMPLETE_CHARACTERISTIC, "OTA Flash Complete");
    }

    public static String lookup(String uuid, String defaultName) {
        String name = attributes.get(uuid);
        return name == null ? defaultName : name;
    }
}
