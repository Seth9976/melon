package com.iloen.melon.activity.crop;

import F8.m;
import F8.o;
import F8.p;
import U4.x;
import android.app.ProgressDialog;
import android.app.WallpaperManager;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path.Direction;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.util.Log;
import android.view.Window;
import com.google.firebase.b;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.system.ToastManager;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class CropImage extends MonitoredActivity {
    public static final int PIC_REQUEST_CODE = 99;
    private static final String TAG = "CropImage";
    private int mAspectX;
    private int mAspectY;
    private Bitmap mBitmap;
    private boolean mCircleCrop;
    private ContentResolver mContentResolver;
    h mCrop;
    private boolean mDoFaceDetection;
    private final Handler mHandler;
    private boolean mHighlightViewFitToScreen;
    private boolean mHighlightViewResize;
    private i mImage;
    private CropImageView mImageView;
    private Bitmap.CompressFormat mOutputFormat;
    private int mOutputX;
    private int mOutputY;
    Runnable mRunFaceDetection;
    private Uri mSaveUri;
    boolean mSaving;
    private boolean mScale;
    private boolean mScaleUp;
    private boolean mSetWallpaper;
    boolean mWaitingToPick;

    public CropImage() {
        this.mOutputFormat = Bitmap.CompressFormat.JPEG;
        this.mSaveUri = null;
        this.mSetWallpaper = false;
        this.mDoFaceDetection = true;
        this.mCircleCrop = false;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mHighlightViewFitToScreen = false;
        this.mHighlightViewResize = true;
        this.mScaleUp = true;
        this.mRunFaceDetection = new g(this);
    }

    @Override  // com.iloen.melon.activity.crop.MonitoredActivity
    public void onCreate(Bundle bundle0) {
        int v1;
        boolean z1;
        super.onCreate(bundle0);
        Window window0 = this.getWindow();
        if(window0 != null) {
            b.A(window0);
        }
        this.mContentResolver = this.getContentResolver();
        boolean z = true;
        this.requestWindowFeature(1);
        this.setContentView(0x7F0D01DB);  // layout:cropimage
        this.mImageView = (CropImageView)this.findViewById(0x7F0A0366);  // id:crop_image
        TitleBar titleBar0 = (TitleBar)this.findViewById(0x7F0A0BAD);  // id:titlebar
        m m0 = new m(2, false);
        p p0 = new p(1);
        p0.c = new c(this, 1);
        o[] arr_o = {m0, p0};
        String s = null;
        o o0 = null;
        for(int v = 0; v < 2; ++v) {
            o o1 = arr_o[v];
            if(o0 == null) {
                o0 = o1;
            }
            else {
                o0.g(o1);
            }
        }
        titleBar0.a(o0);
        titleBar0.setTitle("이미지 편집");
        try {
            if(StorageUtils.isScopedStorage()) {
                z1 = j.b();
            }
            else {
                z1 = "mounted".equals(Environment.getExternalStorageState()) ? j.b() : false;
            }
            if(z1) {
                StatFs statFs0 = new StatFs((StorageUtils.isScopedStorage() ? FileUtils.getSafetyPath(MelonAppBase.instance.getContext().getExternalCacheDir()) : Environment.getExternalStorageDirectory().toString()));
                v1 = (int)(((float)statFs0.getAvailableBlocksLong()) * ((float)statFs0.getBlockSizeLong()) / 400000.0f);
            }
            else {
                v1 = -1;
            }
        }
        catch(Exception unused_ex) {
            v1 = -2;
        }
        if(v1 == -1) {
            s = (StorageUtils.isScopedStorage() ? FileUtils.getSafetyPath(this.getApplication().getExternalCacheDir()) : Environment.getExternalStorageState()) == "checking" ? "저장소에 연결 준비중입니다…" : "저장소가 비어 있습니다. 연결 후 사용해 주세요.";
        }
        else if(v1 < 1) {
            s = "저장 공간이 부족합니다.";
        }
        if(s != null) {
            ToastManager.showShort(s);
        }
        Intent intent0 = this.getIntent();
        Bundle bundle1 = intent0.getExtras();
        if(bundle1 != null) {
            if(bundle1.getString("circleCrop") != null) {
                this.mCircleCrop = true;
                this.mAspectX = 1;
                this.mAspectY = 1;
            }
            Uri uri0 = (Uri)bundle1.getParcelable("output");
            this.mSaveUri = uri0;
            if(uri0 == null) {
                this.mSetWallpaper = bundle1.getBoolean("setWallpaper");
            }
            else {
                String s1 = bundle1.getString("outputFormat");
                if(s1 != null) {
                    this.mOutputFormat = Bitmap.CompressFormat.valueOf(s1);
                }
            }
            this.mBitmap = (Bitmap)bundle1.getParcelable("data");
            this.mAspectX = bundle1.getInt("aspectX");
            this.mAspectY = bundle1.getInt("aspectY");
            this.mOutputX = bundle1.getInt("outputX");
            this.mOutputY = bundle1.getInt("outputY");
            this.mHighlightViewFitToScreen = bundle1.getBoolean("highlightViewFitToScreen", false);
            this.mHighlightViewResize = bundle1.getBoolean("highlightViewResize", true);
            this.mScale = bundle1.getBoolean("scale", true);
            this.mScaleUp = bundle1.getBoolean("scaleUpIfNeeded", true);
            if(bundle1.containsKey("noFaceDetection") && bundle1.getBoolean("noFaceDetection")) {
                z = false;
            }
            this.mDoFaceDetection = z;
        }
        if(this.mBitmap == null) {
            Uri uri1 = intent0.getData();
            n n0 = new n(this.mContentResolver, uri1);
            this.mImage = n0;
            this.mBitmap = n0.a(320, 0x30000);
        }
        if(this.mBitmap == null) {
            this.finish();
            return;
        }
        this.getWindow().addFlags(0x400);
        this.findViewById(0x7F0A0368).setOnClickListener(new c(this, 2));  // id:crop_save
        this.findViewById(0x7F0A0367).setOnClickListener(new c(this, 0));  // id:crop_rotate
        this.startFaceDetection();
    }

    @Override  // com.iloen.melon.activity.crop.MonitoredActivity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public void onPause() {
        super.onPause();
    }

    private void onSaveClicked() {
        Bitmap bitmap0;
        Matrix matrix1;
        h h0 = this.mCrop;
        if(h0 == null || this.mSaving) {
            return;
        }
        this.mSaving = true;
        int v = this.mOutputX;
        if(v == 0) {
        label_20:
            Rect rect2 = h0.b();
            int v4 = rect2.width();
            int v5 = rect2.height();
            Bitmap bitmap1 = Bitmap.createBitmap(v4, v5, (this.mCircleCrop ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565));
            Canvas canvas1 = new Canvas(bitmap1);
            Rect rect3 = new Rect(0, 0, v4, v5);
            canvas1.drawBitmap(this.mBitmap, rect2, rect3, null);
            this.mImageView.k(null);
            this.mBitmap.recycle();
            if(this.mCircleCrop) {
                Canvas canvas2 = new Canvas(bitmap1);
                Path path0 = new Path();
                float f = ((float)v4) / 2.0f;
                path0.addCircle(f, ((float)v5) / 2.0f, f, Path.Direction.CW);
                canvas2.clipPath(path0, Region.Op.DIFFERENCE);
                canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
            }
            if(this.mOutputX == 0 || this.mOutputY == 0 || !this.mScale) {
                bitmap0 = bitmap1;
            }
            else {
                Matrix matrix0 = new Matrix();
                int v6 = this.mOutputX;
                int v7 = this.mOutputY;
                boolean z = this.mScaleUp;
                int v8 = bitmap1.getWidth() - v6;
                int v9 = bitmap1.getHeight() - v7;
                if(z || v8 >= 0 && v9 >= 0) {
                    float f1 = (float)bitmap1.getWidth();
                    float f2 = (float)bitmap1.getHeight();
                    if(Float.compare(f1 / f2, ((float)v6) / ((float)v7)) > 0) {
                        float f3 = ((float)v7) / f2;
                        if(f3 < 0.9f || f3 > 1.0f) {
                            matrix0.setScale(f3, f3);
                        }
                        else {
                            matrix0 = null;
                        }
                        matrix1 = matrix0;
                    }
                    else {
                        float f4 = ((float)v6) / f1;
                        if(f4 < 0.9f || f4 > 1.0f) {
                            matrix0.setScale(f4, f4);
                            matrix1 = matrix0;
                        }
                        else {
                            matrix1 = null;
                        }
                    }
                    Bitmap bitmap2 = matrix1 == null ? bitmap1 : Bitmap.createBitmap(bitmap1, 0, 0, bitmap1.getWidth(), bitmap1.getHeight(), matrix1, true);
                    if(bitmap2 != bitmap1) {
                        bitmap1.recycle();
                    }
                    Bitmap bitmap3 = Bitmap.createBitmap(bitmap2, Math.max(0, bitmap2.getWidth() - v6) / 2, Math.max(0, bitmap2.getHeight() - v7) / 2, v6, v7);
                    if(bitmap3 != bitmap2) {
                        bitmap2.recycle();
                    }
                    bitmap0 = bitmap3;
                }
                else {
                    bitmap0 = Bitmap.createBitmap(v6, v7, Bitmap.Config.ARGB_8888);
                    Canvas canvas3 = new Canvas(bitmap0);
                    int v10 = Math.max(0, v8 / 2);
                    int v11 = Math.max(0, v9 / 2);
                    Rect rect4 = new Rect(v10, v11, Math.min(v6, bitmap1.getWidth()) + v10, Math.min(v7, bitmap1.getHeight()) + v11);
                    int v12 = (v6 - rect4.width()) / 2;
                    int v13 = (v7 - rect4.height()) / 2;
                    canvas3.drawBitmap(bitmap1, rect4, new Rect(v12, v13, v6 - v12, v7 - v13), null);
                    bitmap1.recycle();
                }
            }
        }
        else {
            int v1 = this.mOutputY;
            if(v1 != 0 && !this.mScale) {
                bitmap0 = Bitmap.createBitmap(v, v1, Bitmap.Config.RGB_565);
                Canvas canvas0 = new Canvas(bitmap0);
                Rect rect0 = this.mCrop.b();
                Rect rect1 = new Rect(0, 0, this.mOutputX, this.mOutputY);
                int v2 = (rect0.width() - rect1.width()) / 2;
                int v3 = (rect0.height() - rect1.height()) / 2;
                rect0.inset(Math.max(0, v2), Math.max(0, v3));
                rect1.inset(Math.max(0, -v2), Math.max(0, -v3));
                canvas0.drawBitmap(this.mBitmap, rect0, rect1, null);
                this.mImageView.k(null);
                this.mBitmap.recycle();
                goto label_79;
            }
            goto label_20;
        }
    label_79:
        this.mImageView.k(bitmap0);
        this.mImageView.a();
        this.mImageView.k.clear();
        Bundle bundle0 = this.getIntent().getExtras();
        if(bundle0 != null && (bundle0.getParcelable("data") != null || bundle0.getBoolean("return-data"))) {
            Bundle bundle1 = new Bundle();
            bundle1.putParcelable("data", bitmap0);
            this.setResult(-1, new Intent().setAction("inline-data").putExtras(bundle1));
            this.finish();
            return;
        }
        int v14 = this.mSetWallpaper ? 0x7F1310FA : 0x7F1308D5;  // string:wallpaper "배경화면으로 설정 중입니다. 잠시만 기다려주세요…"
        String s = this.getResources().getString(v14);
        new Thread(new com.iloen.melon.activity.crop.o(this, new f(this, bitmap0, 0), ProgressDialog.show(this, null, s, true, false), this.mHandler)).start();
    }

    private void saveOutput(Bitmap bitmap0) {
        OutputStream outputStream0;
        int v = 0;
        Uri uri0 = this.mSaveUri;
        if(uri0 != null) {
            try {
                outputStream0 = null;
                outputStream0 = this.mContentResolver.openOutputStream(uri0);
                if(outputStream0 != null) {
                    bitmap0.compress(this.mOutputFormat, 75, outputStream0);
                }
            }
            catch(IOException iOException0) {
                Log.e("CropImage", "Cannot open file: " + this.mSaveUri, iOException0);
            }
            finally {
                b.s(outputStream0);
            }
            Bundle bundle0 = new Bundle();
            this.setResult(-1, new Intent(this.mSaveUri.toString()).putExtras(bundle0));
        }
        else if(this.mSetWallpaper) {
            try {
                WallpaperManager.getInstance(this).setBitmap(bitmap0);
                this.setResult(-1);
            }
            catch(IOException iOException1) {
                Log.e("CropImage", "Failed to set wallpaper.", iOException1);
                this.setResult(0);
            }
        }
        else {
            Bundle bundle1 = new Bundle();
            bundle1.putString("rect", this.mCrop.b().toString());
            File file0 = new File(((n)this.mImage).a.getPath());
            File file1 = new File(file0.getParent());
            String s = file0.getName();
            String s1 = s.substring(0, s.lastIndexOf("."));
            do {
                ++v;
                StringBuilder stringBuilder0 = new StringBuilder();
                stringBuilder0.append(file1.toString());
                stringBuilder0.append("/");
                stringBuilder0.append(s1);
                stringBuilder0.append("-");
            }
            while(new File(x.g(v, ".jpg", stringBuilder0)).exists());
            try {
                ContentResolver contentResolver0 = this.mContentResolver;
                String s2 = ((n)this.mImage).a.toString();
                this.mImage.getClass();
                Uri uri1 = j.a(contentResolver0, s2, file1.toString(), s1 + "-" + v + ".jpg", bitmap0, new int[1]);
                this.setResult(-1, new Intent().setAction(uri1.toString()).putExtras(bundle1));
            }
            catch(Exception exception0) {
                Log.e("CropImage", "store image fail, continue anyway", exception0);
            }
        }
        f f0 = new f(this, bitmap0, 1);
        this.mHandler.post(f0);
        this.finish();
    }

    private void startFaceDetection() {
        if(this.isFinishing()) {
            return;
        }
        this.mImageView.k(this.mBitmap);
        new Thread(new com.iloen.melon.activity.crop.o(this, new e(this, 0), ProgressDialog.show(this, null, "잠시만 기다려주세요…", true, false), this.mHandler)).start();
    }
}

