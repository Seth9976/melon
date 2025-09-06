package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Option;

public final class GifOptions {
    public static final Option DECODE_FORMAT;
    public static final Option DISABLE_ANIMATION;

    static {
        GifOptions.DECODE_FORMAT = Option.memory("com.bumptech.glide.load.resource.gif.GifOptions.DecodeFormat", DecodeFormat.DEFAULT);
        GifOptions.DISABLE_ANIMATION = Option.memory("com.bumptech.glide.load.resource.gif.GifOptions.DisableAnimation", Boolean.FALSE);
    }
}

