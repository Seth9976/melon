package com.kakao.digitalitem.image.lib;

import U4.x;
import android.text.TextUtils;
import java.io.File;

final class ImageDecode {
    public static final class FrameDecodeException extends Exception {
        public FrameDecodeException(String s, String s1) {
            StringBuilder stringBuilder0 = x.p(s, " decode failed.");
            stringBuilder0.append((TextUtils.isEmpty(s1) ? "" : ", reason : " + s1));
            super(stringBuilder0.toString());
        }
    }

    private static final int META_DECODE_ONLY = -1;
    private int backgroundColor;
    private ImageFrame currentFrame;
    private String decodeFailReason;
    private boolean decodeFailed;
    private static final Object decodeLock;
    private boolean encrypted;
    private String filePath;
    private int frameCount;
    private boolean hasAlpha;
    private boolean hasAnimation;
    private int height;
    private int loopCount;
    private Type type;
    private int viewHeight;
    private int viewWidth;
    private int width;

    static {
        ImageDecode.decodeLock = new Object();
    }

    private ImageDecode(Type animatedItemImage$Type0, boolean z) {
        this(animatedItemImage$Type0, z, 0, 0);
    }

    private ImageDecode(Type animatedItemImage$Type0, boolean z, int v, int v1) {
        this.type = animatedItemImage$Type0;
        this.encrypted = z;
        this.viewWidth = v;
        this.viewHeight = v1;
    }

    private void decode(String s) {
        synchronized(this) {
            this.filePath = s;
            Object object0 = ImageDecode.decodeLock;
            __monitor_enter(object0);
            try {
                this.decodeFailed = false;
                switch(com.kakao.digitalitem.image.lib.ImageDecode.1.$SwitchMap$com$kakao$digitalitem$image$lib$AnimatedItemImage$Type[this.type.ordinal()]) {
                    case 1: {
                        this.nativeWebpImageResizeDecode(s, -1, this.encrypted, this.viewWidth, this.viewHeight);
                        goto label_15;
                    }
                    case 2: {
                        break;
                    }
                    default: {
                        goto label_15;
                    }
                }
            }
            catch(OutOfMemoryError unused_ex) {
                goto label_18;
            }
            catch(Throwable throwable0) {
                goto label_22;
            }
            try {
                this.nativeGifImageDecode(s, -1, this.encrypted);
                goto label_15;
            }
            catch(OutOfMemoryError unused_ex) {
                goto label_18;
            }
            catch(Throwable throwable1) {
            }
            Throwable throwable2 = throwable1;
            goto label_23;
            try {
                try {
                label_15:
                    if(this.decodeFailed) {
                        this.deleteBrokenFile();
                        throw new FrameDecodeException(s, this.decodeFailReason);
                    }
                }
                catch(OutOfMemoryError unused_ex) {
                label_18:
                    SystemUtil.gc();
                }
                __monitor_exit(object0);
                return;
            label_22:
                throwable2 = throwable0;
            label_23:
                __monitor_exit(object0);
            }
            catch(Throwable throwable0) {
                goto label_22;
            }
            throw throwable2;
        }
    }

    public static AnimatedItemImage decodeImageFromPath(String s, Type animatedItemImage$Type0, boolean z, int v, int v1) {
        ImageDecode imageDecode0 = new ImageDecode(animatedItemImage$Type0, z, v, v1);
        imageDecode0.decode(s);
        return AnimatedItemImage.newAnimatedItemImageFrom(imageDecode0);
    }

    private void deleteBrokenFile() {
        if(!TextUtils.isEmpty(this.filePath)) {
            File file0 = new File(this.filePath);
            if(file0.exists()) {
                file0.delete();
            }
        }
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public ImageFrame getFrame(int v) {
        if(TextUtils.isEmpty(this.filePath)) {
            return null;
        }
        Object object0 = ImageDecode.decodeLock;
        __monitor_enter(object0);
        try {
            this.decodeFailed = false;
            switch(com.kakao.digitalitem.image.lib.ImageDecode.1.$SwitchMap$com$kakao$digitalitem$image$lib$AnimatedItemImage$Type[this.type.ordinal()]) {
                case 1: {
                    this.nativeWebpImageResizeDecode(this.filePath, v, this.encrypted, this.viewWidth, this.viewHeight);
                    goto label_14;
                }
                case 2: {
                    break;
                }
                default: {
                    goto label_14;
                }
            }
        }
        catch(OutOfMemoryError unused_ex) {
            goto label_18;
        }
        catch(Throwable throwable0) {
            goto label_23;
        }
        try {
            this.nativeGifImageDecode(this.filePath, v, this.encrypted);
            goto label_14;
        }
        catch(OutOfMemoryError unused_ex) {
            goto label_18;
        }
        catch(Throwable throwable1) {
        }
        Throwable throwable2 = throwable1;
        goto label_24;
        try {
            try {
            label_14:
                if(this.decodeFailed) {
                    this.currentFrame = null;
                    this.deleteBrokenFile();
                    throw new FrameDecodeException(this.filePath, this.decodeFailReason);
                }
            }
            catch(OutOfMemoryError unused_ex) {
            label_18:
                this.currentFrame = null;
                SystemUtil.gc();
            }
            __monitor_exit(object0);
            return this.currentFrame;
        label_23:
            throwable2 = throwable0;
        label_24:
            __monitor_exit(object0);
        }
        catch(Throwable throwable0) {
            goto label_23;
        }
        throw throwable2;
    }

    public int getFrameCount() {
        return this.frameCount;
    }

    public int getHeight() {
        return this.height;
    }

    public int getLoopCount() {
        return this.loopCount;
    }

    public Type getType() {
        return this.type;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean hasAlpha() {
        return this.hasAlpha;
    }

    public boolean hasAnimation() {
        return this.hasAnimation;
    }

    public boolean isDecodeFailed() {
        return this.decodeFailed;
    }

    private native void nativeGifImageDecode(String arg1, int arg2, boolean arg3) {
    }

    private native void nativeWebpImageDecode(String arg1, int arg2, boolean arg3) {
    }

    private native void nativeWebpImageResizeDecode(String arg1, int arg2, boolean arg3, int arg4, int arg5) {
    }

    private void onDecodeFailed(String s) {
        this.decodeFailed = true;
        this.decodeFailReason = s;
    }

    private void onFrame(int[] arr_v, int v, int v1, int v2, int v3, int v4, int v5, int v6, int v7) {
        this.currentFrame = new Builder().setFrame(arr_v).setFrameIndex(v).setX(v1).setY(v2).setWidth(v3).setHeight(v4).setDuration(v5).setDispose(v6).setBlend(v7).build();
    }

    private void onFrameInfo(int v, int v1, int v2) {
        this.loopCount = v;
        this.frameCount = v1;
        this.backgroundColor = v2;
    }

    private void onImageInfo(int v, int v1, boolean z, boolean z1) {
        this.width = v;
        this.height = v1;
        this.hasAlpha = z;
        this.hasAnimation = z1;
    }
}

