package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.Option;

public abstract class DownsampleStrategy {
    static class AtLeast extends DownsampleStrategy {
        @Override  // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int v, int v1, int v2, int v3) {
            return SampleSizeRounding.QUALITY;
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int v, int v1, int v2, int v3) {
            int v4 = Math.min(v1 / v3, v / v2);
            return v4 == 0 ? 1.0f : 1.0f / ((float)Integer.highestOneBit(v4));
        }
    }

    static class AtMost extends DownsampleStrategy {
        @Override  // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int v, int v1, int v2, int v3) {
            return SampleSizeRounding.MEMORY;
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int v, int v1, int v2, int v3) {
            int v4 = (int)Math.ceil(Math.max(((float)v1) / ((float)v3), ((float)v) / ((float)v2)));
            int v5 = 1;
            int v6 = Math.max(1, Integer.highestOneBit(v4));
            if(v6 >= v4) {
                v5 = 0;
            }
            return 1.0f / ((float)(v6 << v5));
        }
    }

    static class CenterInside extends DownsampleStrategy {
        @Override  // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int v, int v1, int v2, int v3) {
            return this.getScaleFactor(v, v1, v2, v3) == 1.0f ? SampleSizeRounding.QUALITY : DownsampleStrategy.FIT_CENTER.getSampleSizeRounding(v, v1, v2, v3);
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int v, int v1, int v2, int v3) {
            return Math.min(1.0f, DownsampleStrategy.FIT_CENTER.getScaleFactor(v, v1, v2, v3));
        }
    }

    static class CenterOutside extends DownsampleStrategy {
        @Override  // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int v, int v1, int v2, int v3) {
            return SampleSizeRounding.QUALITY;
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int v, int v1, int v2, int v3) {
            return Math.max(((float)v2) / ((float)v), ((float)v3) / ((float)v1));
        }
    }

    static class FitCenter extends DownsampleStrategy {
        // 去混淆评级： 低(20)
        @Override  // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int v, int v1, int v2, int v3) {
            return DownsampleStrategy.IS_BITMAP_FACTORY_SCALING_SUPPORTED ? SampleSizeRounding.QUALITY : SampleSizeRounding.MEMORY;
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int v, int v1, int v2, int v3) {
            if(DownsampleStrategy.IS_BITMAP_FACTORY_SCALING_SUPPORTED) {
                return Math.min(((float)v2) / ((float)v), ((float)v3) / ((float)v1));
            }
            int v4 = Math.max(v1 / v3, v / v2);
            return v4 == 0 ? 1.0f : 1.0f / ((float)Integer.highestOneBit(v4));
        }
    }

    static class None extends DownsampleStrategy {
        @Override  // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int v, int v1, int v2, int v3) {
            return SampleSizeRounding.QUALITY;
        }

        @Override  // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int v, int v1, int v2, int v3) {
            return 1.0f;
        }
    }

    public static enum SampleSizeRounding {
        MEMORY,
        QUALITY;

        private static SampleSizeRounding[] $values() [...] // Inlined contents
    }

    public static final DownsampleStrategy AT_LEAST;
    public static final DownsampleStrategy AT_MOST;
    public static final DownsampleStrategy CENTER_INSIDE;
    public static final DownsampleStrategy CENTER_OUTSIDE;
    public static final DownsampleStrategy DEFAULT;
    public static final DownsampleStrategy FIT_CENTER;
    static final boolean IS_BITMAP_FACTORY_SCALING_SUPPORTED;
    public static final DownsampleStrategy NONE;
    public static final Option OPTION;

    static {
        DownsampleStrategy.AT_LEAST = new AtLeast();
        DownsampleStrategy.AT_MOST = new AtMost();
        DownsampleStrategy.FIT_CENTER = new FitCenter();
        DownsampleStrategy.CENTER_INSIDE = new CenterInside();
        CenterOutside downsampleStrategy$CenterOutside0 = new CenterOutside();
        DownsampleStrategy.CENTER_OUTSIDE = downsampleStrategy$CenterOutside0;
        DownsampleStrategy.NONE = new None();
        DownsampleStrategy.DEFAULT = downsampleStrategy$CenterOutside0;
        DownsampleStrategy.OPTION = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", downsampleStrategy$CenterOutside0);
        DownsampleStrategy.IS_BITMAP_FACTORY_SCALING_SUPPORTED = true;
    }

    public abstract SampleSizeRounding getSampleSizeRounding(int arg1, int arg2, int arg3, int arg4);

    public abstract float getScaleFactor(int arg1, int arg2, int arg3, int arg4);
}

