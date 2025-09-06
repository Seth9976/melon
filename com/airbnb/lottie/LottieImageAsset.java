package com.airbnb.lottie;

import android.graphics.Bitmap;

public class LottieImageAsset {
    private Bitmap bitmap;
    private final String dirName;
    private final String fileName;
    private final int height;
    private final String id;
    private final int width;

    public LottieImageAsset(int v, int v1, String s, String s1, String s2) {
        this.width = v;
        this.height = v1;
        this.id = s;
        this.fileName = s1;
        this.dirName = s2;
    }

    public LottieImageAsset copyWithScale(float f) {
        LottieImageAsset lottieImageAsset0 = new LottieImageAsset(((int)(((float)this.width) * f)), ((int)(((float)this.height) * f)), this.id, this.fileName, this.dirName);
        Bitmap bitmap0 = this.bitmap;
        if(bitmap0 != null) {
            lottieImageAsset0.setBitmap(Bitmap.createScaledBitmap(bitmap0, lottieImageAsset0.width, lottieImageAsset0.height, true));
        }
        return lottieImageAsset0;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public String getDirName() {
        return this.dirName;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getHeight() {
        return this.height;
    }

    public String getId() {
        return this.id;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean hasBitmap() {
        return this.bitmap != null || this.fileName.startsWith("data:") && this.fileName.indexOf("base64,") > 0;
    }

    public void setBitmap(Bitmap bitmap0) {
        this.bitmap = bitmap0;
    }
}

