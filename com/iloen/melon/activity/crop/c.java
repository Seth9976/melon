package com.iloen.melon.activity.crop;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.View.OnClickListener;
import android.view.View;
import java.util.ArrayList;

public final class c implements View.OnClickListener {
    public final int a;
    public final CropImage b;

    public c(CropImage cropImage0, int v) {
        this.a = v;
        this.b = cropImage0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        Bitmap bitmap2;
        switch(this.a) {
            case 0: {
                CropImage cropImage0 = this.b;
                Bitmap bitmap0 = cropImage0.mBitmap;
                if(bitmap0 != null) {
                    try {
                        __monitor_enter(bitmap0);
                    }
                    catch(OutOfMemoryError unused_ex) {
                        goto label_28;
                    }
                    try {
                        if(bitmap0.isRecycled()) {
                            bitmap2 = bitmap0;
                        }
                        else {
                            Matrix matrix0 = new Matrix();
                            matrix0.setRotate(90.0f, ((float)bitmap0.getWidth()) / 2.0f, ((float)bitmap0.getHeight()) / 2.0f);
                            Bitmap bitmap1 = Bitmap.createBitmap(bitmap0, 0, 0, bitmap0.getWidth(), bitmap0.getHeight(), matrix0, true);
                            if(bitmap0 == bitmap1) {
                                bitmap2 = bitmap0;
                            }
                            else {
                                bitmap0.recycle();
                                bitmap2 = bitmap1;
                            }
                        }
                    }
                    catch(Throwable throwable0) {
                        bitmap2 = bitmap0;
                        goto label_26;
                    }
                    try {
                        __monitor_exit(bitmap0);
                        bitmap0 = bitmap2;
                        goto label_28;
                    label_26:
                        __monitor_exit(bitmap0);
                    }
                    catch(Throwable throwable0) {
                        goto label_26;
                    }
                    try {
                        throw throwable0;
                    }
                    catch(OutOfMemoryError unused_ex) {
                        bitmap0 = bitmap2;
                    }
                }
            label_28:
                cropImage0.mBitmap = bitmap0;
                this.b.mImageView.k(this.b.mBitmap);
                this.b.mImageView.a();
                ArrayList arrayList0 = this.b.mImageView.k;
                if(arrayList0 != null) {
                    arrayList0.clear();
                }
                this.b.mRunFaceDetection.run();
                return;
            }
            case 1: {
                this.b.setResult(99);
                this.b.finish();
                return;
            }
            default: {
                this.b.onSaveClicked();
            }
        }
    }
}

