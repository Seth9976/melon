package com.samsung.android.sdk;

import android.os.Build;

public class SsdkVendorCheck {
    private static String strBrand;
    private static String strManufacturer;

    static {
        SsdkVendorCheck.strBrand = Build.BRAND;
        SsdkVendorCheck.strManufacturer = Build.MANUFACTURER;
    }

    public static boolean isSamsungDevice() [...] // 潜在的解密器
}

