package com.facebook.gamingservices.cloudgaming.internal;

public enum SDKShareIntentEnum {
    INVITE("INVITE"),
    REQUEST("REQUEST"),
    CHALLENGE("CHALLENGE"),
    SHARE("SHARE");

    private final String mStringValue;

    private SDKShareIntentEnum(String s1) {
        this.mStringValue = s1;
    }

    public static SDKShareIntentEnum fromString(String s) {
        SDKShareIntentEnum[] arr_sDKShareIntentEnum = SDKShareIntentEnum.values();
        for(int v = 0; v < arr_sDKShareIntentEnum.length; ++v) {
            SDKShareIntentEnum sDKShareIntentEnum0 = arr_sDKShareIntentEnum[v];
            if(sDKShareIntentEnum0.toString().equals(s)) {
                return sDKShareIntentEnum0;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.mStringValue;
    }

    public static String validate(String s) {
        SDKShareIntentEnum[] arr_sDKShareIntentEnum = SDKShareIntentEnum.values();
        for(int v = 0; v < arr_sDKShareIntentEnum.length; ++v) {
            if(arr_sDKShareIntentEnum[v].toString().equals(s)) {
                return s;
            }
        }
        return null;
    }
}

