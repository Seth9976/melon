package com.kakao.digitalitem.image.lib;

import java.util.concurrent.ConcurrentHashMap;

public final class AnimatedItemImage {
    public static enum Type {
        NONE(""),
        GIF("gif"),
        WEBP("webp");

        private final String type;

        private static Type[] $values() [...] // Inlined contents

        private Type(String s1) {
            this.type = s1;
        }

        public String getType() {
            return this.type;
        }

        public static Type toType(String s) {
            Type animatedItemImage$Type0 = Type.GIF;
            if("gif".equals(s)) {
                return animatedItemImage$Type0;
            }
            return "webp".equals(s) ? Type.WEBP : Type.NONE;
        }
    }

    private static final int FRAME_NO_CACHE_IMAGE_SIZE = 360;
    private ImageDecode decode;
    private int density;
    private ConcurrentHashMap frames;

    public void clearFrames() {
        if(this.frames != null && !this.frames.isEmpty()) {
            this.frames.clear();
        }
    }

    public int getBackgroundColor() {
        return this.decode.getBackgroundColor();
    }

    public int getDensity() {
        return this.density;
    }

    public ImageFrame getFrame(int v) {
        ImageFrame imageFrame1;
        if(this.frames == null) {
            this.frames = new ConcurrentHashMap(this.getFrameCount());
        }
        Integer integer0 = v;
        ImageFrame imageFrame0 = (ImageFrame)this.frames.get(integer0);
        if(imageFrame0 == null) {
            try {
                imageFrame1 = this.decode.getFrame(v);
            }
            catch(FrameDecodeException imageDecode$FrameDecodeException0) {
                this.clearFrames();
                throw imageDecode$FrameDecodeException0;
            }
            if((v == 0 || !this.isNoCacheSize()) && imageFrame1 != null) {
                this.frames.putIfAbsent(integer0, imageFrame1);
            }
            return imageFrame1;
        }
        return imageFrame0;
    }

    public int getFrameCount() {
        return this.decode.getFrameCount();
    }

    public int getHeight() {
        return this.decode.getHeight();
    }

    public int getLoopCount() {
        return this.decode.getLoopCount();
    }

    public Type getType() {
        return this.decode.getType();
    }

    public int getWidth() {
        return this.decode.getWidth();
    }

    public boolean hasAlpha() {
        return this.decode.hasAlpha();
    }

    public boolean hasAnimation() {
        return this.decode.hasAnimation();
    }

    public boolean isAllFrameDecodeSucceed() {
        return !this.decode.isDecodeFailed();
    }

    public boolean isNoCacheSize() {
        return this.decode.getWidth() > 360 || this.decode.getHeight() > 360;
    }

    public static AnimatedItemImage newAnimatedItemImageFrom(ImageDecode imageDecode0) {
        AnimatedItemImage animatedItemImage0 = new AnimatedItemImage();
        animatedItemImage0.decode = imageDecode0;
        return animatedItemImage0;
    }

    public void setDensity(int v) {
        this.density = v;
    }
}

