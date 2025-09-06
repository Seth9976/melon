package com.iloen.melon.activity.crop;

public final class k implements Runnable {
    public final long a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final CropImageView f;

    public k(CropImageView cropImageView0, long v, float f, float f1, float f2, float f3) {
        this.f = cropImageView0;
        this.a = v;
        this.b = f;
        this.c = f1;
        this.d = f2;
        this.e = f3;
    }

    @Override
    public final void run() {
        float f = Math.min(300.0f, System.currentTimeMillis() - this.a);
        CropImageView cropImageView0 = this.f;
        cropImageView0.f(this.c * f + this.b, this.d, this.e);
        if(f < 300.0f) {
            cropImageView0.i.post(this);
        }
    }
}

