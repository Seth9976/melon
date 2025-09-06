package com.iloen.melon.activity.crop;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.FaceDetector.Face;
import android.media.FaceDetector;

public final class g implements Runnable {
    public float a;
    public Matrix b;
    public final FaceDetector.Face[] c;
    public int d;
    public final CropImage e;

    public g(CropImage cropImage0) {
        this.e = cropImage0;
        this.a = 1.0f;
        this.c = new FaceDetector.Face[3];
    }

    @Override
    public final void run() {
        Bitmap bitmap0;
        CropImage cropImage0 = this.e;
        this.b = cropImage0.mImageView.getImageMatrix();
        if(cropImage0.mBitmap == null) {
            bitmap0 = null;
        }
        else {
            if(cropImage0.mBitmap.getWidth() > 0x100) {
                this.a = 256.0f / ((float)cropImage0.mBitmap.getWidth());
            }
            Matrix matrix0 = new Matrix();
            matrix0.setScale(this.a, this.a);
            bitmap0 = Bitmap.createBitmap(cropImage0.mBitmap, 0, 0, cropImage0.mBitmap.getWidth(), cropImage0.mBitmap.getHeight(), matrix0, true);
        }
        this.a = 1.0f / this.a;
        if(bitmap0 != null && cropImage0.mDoFaceDetection) {
            this.d = new FaceDetector(bitmap0.getWidth(), bitmap0.getHeight(), this.c.length).findFaces(bitmap0, this.c);
        }
        if(bitmap0 != null && bitmap0 != cropImage0.mBitmap) {
            bitmap0.recycle();
        }
        cropImage0.mHandler.post(new e(this, 1));
    }
}

