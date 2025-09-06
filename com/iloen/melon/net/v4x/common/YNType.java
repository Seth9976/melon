package com.iloen.melon.net.v4x.common;

public class YNType {
    public static final String N = "N";
    public static final String Y = "Y";

    // 去混淆评级： 低(20)
    public static final String valueOf(boolean z) {
        return z ? "Y" : "N";
    }
}

