package com.airbnb.lottie.manager;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable.Callback;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class ImageAssetManager {
    private static final Object bitmapHashLock;
    private final Context context;
    private ImageAssetDelegate delegate;
    private final Map imageAssets;
    private final String imagesFolder;

    static {
        ImageAssetManager.bitmapHashLock = new Object();
    }

    public ImageAssetManager(Drawable.Callback drawable$Callback0, String s, ImageAssetDelegate imageAssetDelegate0, Map map0) {
        this.imagesFolder = TextUtils.isEmpty(s) || s.charAt(s.length() - 1) == 0x2F ? s : s + "/";
        this.imageAssets = map0;
        this.setDelegate(imageAssetDelegate0);
        if(!(drawable$Callback0 instanceof View)) {
            this.context = null;
            return;
        }
        this.context = ((View)drawable$Callback0).getContext().getApplicationContext();
    }

    public Bitmap bitmapForId(String s) {
        Bitmap bitmap3;
        InputStream inputStream0;
        Bitmap bitmap2;
        byte[] arr_b;
        LottieImageAsset lottieImageAsset0 = (LottieImageAsset)this.imageAssets.get(s);
        if(lottieImageAsset0 == null) {
            return null;
        }
        Bitmap bitmap0 = lottieImageAsset0.getBitmap();
        if(bitmap0 != null) {
            return bitmap0;
        }
        ImageAssetDelegate imageAssetDelegate0 = this.delegate;
        if(imageAssetDelegate0 != null) {
            Bitmap bitmap1 = imageAssetDelegate0.fetchBitmap(lottieImageAsset0);
            if(bitmap1 != null) {
                this.putBitmap(s, bitmap1);
            }
            return bitmap1;
        }
        Context context0 = this.context;
        if(context0 == null) {
            return null;
        }
        String s1 = lottieImageAsset0.getFileName();
        BitmapFactory.Options bitmapFactory$Options0 = new BitmapFactory.Options();
        bitmapFactory$Options0.inScaled = true;
        bitmapFactory$Options0.inDensity = 0xA0;
        if(s1.startsWith("data:") && s1.indexOf("base64,") > 0) {
            try {
                arr_b = Base64.decode(s1.substring(s1.indexOf(44) + 1), 0);
            }
            catch(IllegalArgumentException illegalArgumentException0) {
                Logger.warning("data URL did not have correct base64 format.", illegalArgumentException0);
                return null;
            }
            try {
                bitmap2 = BitmapFactory.decodeByteArray(arr_b, 0, arr_b.length, bitmapFactory$Options0);
            }
            catch(IllegalArgumentException illegalArgumentException1) {
                Logger.warning(("Unable to decode image `" + s + "`."), illegalArgumentException1);
                return null;
            }
            if(bitmap2 == null) {
                Logger.warning(("Decoded image `" + s + "` is null."));
                return null;
            }
            return this.putBitmap(s, Utils.resizeBitmapIfNeeded(bitmap2, lottieImageAsset0.getWidth(), lottieImageAsset0.getHeight()));
        }
        try {
            if(TextUtils.isEmpty(this.imagesFolder)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            inputStream0 = context0.getAssets().open(this.imagesFolder + s1);
        }
        catch(IOException iOException0) {
            Logger.warning("Unable to open asset.", iOException0);
            return null;
        }
        try {
            bitmap3 = BitmapFactory.decodeStream(inputStream0, null, bitmapFactory$Options0);
        }
        catch(IllegalArgumentException illegalArgumentException2) {
            Logger.warning(("Unable to decode image `" + s + "`."), illegalArgumentException2);
            return null;
        }
        if(bitmap3 == null) {
            Logger.warning(("Decoded image `" + s + "` is null."));
            return null;
        }
        return this.putBitmap(s, Utils.resizeBitmapIfNeeded(bitmap3, lottieImageAsset0.getWidth(), lottieImageAsset0.getHeight()));
    }

    public LottieImageAsset getImageAssetById(String s) {
        return (LottieImageAsset)this.imageAssets.get(s);
    }

    public boolean hasSameContext(Context context0) {
        if(context0 == null) {
            return this.context == null;
        }
        if(this.context instanceof Application) {
            context0 = context0.getApplicationContext();
        }
        return context0 == this.context;
    }

    private Bitmap putBitmap(String s, Bitmap bitmap0) {
        synchronized(ImageAssetManager.bitmapHashLock) {
            ((LottieImageAsset)this.imageAssets.get(s)).setBitmap(bitmap0);
            return bitmap0;
        }
    }

    public void setDelegate(ImageAssetDelegate imageAssetDelegate0) {
        this.delegate = imageAssetDelegate0;
    }

    public Bitmap updateBitmap(String s, Bitmap bitmap0) {
        if(bitmap0 == null) {
            LottieImageAsset lottieImageAsset0 = (LottieImageAsset)this.imageAssets.get(s);
            lottieImageAsset0.setBitmap(null);
            return lottieImageAsset0.getBitmap();
        }
        Bitmap bitmap1 = ((LottieImageAsset)this.imageAssets.get(s)).getBitmap();
        this.putBitmap(s, bitmap0);
        return bitmap1;
    }
}

