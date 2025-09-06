package com.iloen.melon.activity.crop;

import android.app.ProgressDialog;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.FaceDetector.Face;
import com.iloen.melon.utils.system.ToastManager;
import java.util.concurrent.CountDownLatch;

public final class e implements Runnable {
    public final int a;
    public final Object b;

    public e(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override
    public final void run() {
        int v5;
        switch(this.a) {
            case 0: {
                CountDownLatch countDownLatch0 = new CountDownLatch(1);
                CropImage cropImage0 = (CropImage)this.b;
                cropImage0.mHandler.post(new d(this, (cropImage0.mImage == null ? cropImage0.mBitmap : ((n)cropImage0.mImage).a(-1, 0x100000)), countDownLatch0));
                try {
                    countDownLatch0.await();
                }
                catch(InterruptedException interruptedException0) {
                    throw new RuntimeException(interruptedException0);
                }
                cropImage0.mRunFaceDetection.run();
                return;
            }
            case 1: {
                g g0 = (g)this.b;
                CropImage cropImage1 = g0.e;
                cropImage1.mWaitingToPick = g0.d > 1;
                if(g0.d > 0) {
                    for(int v = 0; v < g0.d; ++v) {
                        FaceDetector.Face faceDetector$Face0 = g0.c[v];
                        PointF pointF0 = new PointF();
                        int v1 = ((int)(faceDetector$Face0.eyesDistance() * g0.a)) * 2;
                        faceDetector$Face0.getMidPoint(pointF0);
                        float f = pointF0.x * g0.a;
                        pointF0.x = f;
                        float f1 = pointF0.y * g0.a;
                        pointF0.y = f1;
                        h h0 = new h(cropImage1.mImageView);
                        h0.d = cropImage1.mHighlightViewResize;
                        Rect rect0 = new Rect(0, 0, cropImage1.mBitmap.getWidth(), cropImage1.mBitmap.getHeight());
                        float f2 = (float)(((int)f));
                        float f3 = (float)(((int)f1));
                        RectF rectF0 = new RectF(f2, f3, f2, f3);
                        float f4 = (float)(-v1);
                        rectF0.inset(f4, f4);
                        float f5 = rectF0.left;
                        if(f5 < 0.0f) {
                            rectF0.inset(-f5, -f5);
                        }
                        float f6 = rectF0.top;
                        if(f6 < 0.0f) {
                            rectF0.inset(-f6, -f6);
                        }
                        float f7 = rectF0.right;
                        float f8 = (float)rect0.right;
                        if(f7 > f8) {
                            rectF0.inset(f7 - f8, f7 - f8);
                        }
                        float f9 = rectF0.bottom;
                        float f10 = (float)rect0.bottom;
                        if(f9 > f10) {
                            rectF0.inset(f9 - f10, f9 - f10);
                        }
                        h0.d(g0.b, rect0, rectF0, cropImage1.mCircleCrop, cropImage1.mAspectX != 0 && cropImage1.mAspectY != 0);
                        CropImageView cropImageView0 = cropImage1.mImageView;
                        cropImageView0.k.add(h0);
                        cropImageView0.invalidate();
                    }
                }
                else {
                    h h1 = new h(cropImage1.mImageView);
                    h1.d = cropImage1.mHighlightViewResize;
                    int v2 = cropImage1.mBitmap.getWidth();
                    int v3 = cropImage1.mBitmap.getHeight();
                    Rect rect1 = new Rect(0, 0, v2, v3);
                    int v4 = cropImage1.mHighlightViewFitToScreen ? v2 : Math.min(v2, v3) * 4 / 5;
                    if(cropImage1.mAspectX == 0 || cropImage1.mAspectY == 0) {
                        v5 = v4;
                    }
                    else if(cropImage1.mAspectX > cropImage1.mAspectY) {
                        v5 = cropImage1.mAspectY * v4 / cropImage1.mAspectX;
                    }
                    else {
                        v5 = v4;
                        v4 = cropImage1.mAspectX * v4 / cropImage1.mAspectY;
                    }
                    int v6 = (v2 - v4) / 2;
                    int v7 = (v3 - v5) / 2;
                    RectF rectF1 = new RectF(((float)v6), ((float)v7), ((float)(v6 + v4)), ((float)(v7 + v5)));
                    h1.d(g0.b, rect1, rectF1, cropImage1.mCircleCrop, cropImage1.mAspectX != 0 && cropImage1.mAspectY != 0);
                    CropImageView cropImageView1 = cropImage1.mImageView;
                    cropImageView1.k.add(h1);
                    cropImageView1.invalidate();
                }
                cropImage1.mImageView.invalidate();
                if(cropImage1.mImageView.k.size() == 1) {
                    cropImage1.mCrop = (h)cropImage1.mImageView.k.get(0);
                    cropImage1.mCrop.b = true;
                }
                if(g0.d > 1) {
                    ToastManager.showShort(0x7F130714);  // string:multiface_crop_help "탭하면 시작합니다."
                }
                return;
            }
            default: {
                ((o)this.b).a.removeLifeCycleListener(((o)this.b));
                ProgressDialog progressDialog0 = ((o)this.b).b;
                if(progressDialog0.getWindow() != null) {
                    progressDialog0.dismiss();
                }
            }
        }
    }
}

