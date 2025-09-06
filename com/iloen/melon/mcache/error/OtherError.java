package com.iloen.melon.mcache.error;

public class OtherError extends ErrorBase {
    public static final String TAG = "OtherError";

    public OtherError(String s, String s1) {
        super(s, s1);
    }

    @Override  // com.iloen.melon.mcache.error.ErrorBase
    public String getCallerTag() {
        return "OtherError";
    }
}

