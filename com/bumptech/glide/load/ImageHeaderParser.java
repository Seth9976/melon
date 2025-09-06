package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.InputStream;
import java.nio.ByteBuffer;

public interface ImageHeaderParser {
    public static enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        ANIMATED_WEBP(true),
        AVIF(true),
        ANIMATED_AVIF(true),
        UNKNOWN(false);

        private final boolean hasAlpha;

        private static ImageType[] $values() [...] // Inlined contents

        private ImageType(boolean z) {
            this.hasAlpha = z;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }

        public boolean isWebp() {
            switch(com.bumptech.glide.load.ImageHeaderParser.1.$SwitchMap$com$bumptech$glide$load$ImageHeaderParser$ImageType[this.ordinal()]) {
                case 1: 
                case 2: 
                case 3: {
                    return true;
                }
                default: {
                    return false;
                }
            }
        }
    }

    public static final int UNKNOWN_ORIENTATION = -1;

    int getOrientation(InputStream arg1, ArrayPool arg2);

    int getOrientation(ByteBuffer arg1, ArrayPool arg2);

    ImageType getType(InputStream arg1);

    ImageType getType(ByteBuffer arg1);

    class com.bumptech.glide.load.ImageHeaderParser.1 {
        static final int[] $SwitchMap$com$bumptech$glide$load$ImageHeaderParser$ImageType;

        static {
            int[] arr_v = new int[ImageType.values().length];
            com.bumptech.glide.load.ImageHeaderParser.1.$SwitchMap$com$bumptech$glide$load$ImageHeaderParser$ImageType = arr_v;
            try {
                arr_v[ImageType.WEBP.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                com.bumptech.glide.load.ImageHeaderParser.1.$SwitchMap$com$bumptech$glide$load$ImageHeaderParser$ImageType[ImageType.WEBP_A.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                com.bumptech.glide.load.ImageHeaderParser.1.$SwitchMap$com$bumptech$glide$load$ImageHeaderParser$ImageType[ImageType.ANIMATED_WEBP.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

}

