package com.bumptech.glide.load;

public enum DecodeFormat {
    PREFER_ARGB_8888,
    PREFER_RGB_565;

    public static final DecodeFormat DEFAULT;

    private static DecodeFormat[] $values() [...] // Inlined contents

    static {
        DecodeFormat.DEFAULT = DecodeFormat.PREFER_ARGB_8888;
    }
}

