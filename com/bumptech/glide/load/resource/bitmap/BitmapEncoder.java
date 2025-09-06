package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.BufferedOutputStream;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BitmapEncoder implements ResourceEncoder {
    public static final Option COMPRESSION_FORMAT = null;
    public static final Option COMPRESSION_QUALITY = null;
    private static final String TAG = "BitmapEncoder";
    private final ArrayPool arrayPool;

    static {
        BitmapEncoder.COMPRESSION_QUALITY = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
        BitmapEncoder.COMPRESSION_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    }

    @Deprecated
    public BitmapEncoder() {
        this.arrayPool = null;
    }

    public BitmapEncoder(ArrayPool arrayPool0) {
        this.arrayPool = arrayPool0;
    }

    public boolean encode(Resource resource0, File file0, Options options0) {
        boolean z;
        FileOutputStream fileOutputStream1;
        Bitmap bitmap0 = (Bitmap)resource0.get();
        Bitmap.CompressFormat bitmap$CompressFormat0 = this.getFormat(bitmap0, options0);
        bitmap0.getWidth();
        bitmap0.getHeight();
        long v = LogTime.getLogTime();
        int v1 = (int)(((Integer)options0.get(BitmapEncoder.COMPRESSION_QUALITY)));
        FileOutputStream fileOutputStream0 = null;
        try {
            fileOutputStream1 = new FileOutputStream(file0);
        }
        catch(IOException iOException0) {
            goto label_23;
        }
        catch(Throwable throwable0) {
            goto label_30;
        }
        try {
            fileOutputStream0 = this.arrayPool == null ? fileOutputStream1 : new BufferedOutputStream(fileOutputStream1, this.arrayPool);
        }
        catch(IOException iOException0) {
            fileOutputStream0 = fileOutputStream1;
            goto label_23;
        }
        catch(Throwable throwable0) {
            fileOutputStream0 = fileOutputStream1;
            goto label_30;
        }
        try {
            bitmap0.compress(bitmap$CompressFormat0, v1, fileOutputStream0);
            fileOutputStream0.close();
            goto label_33;
        }
        catch(IOException iOException0) {
            try {
            label_23:
                if(Log.isLoggable("BitmapEncoder", 3)) {
                    Log.d("BitmapEncoder", "Failed to encode Bitmap", iOException0);
                }
            }
            catch(Throwable throwable0) {
                goto label_30;
            }
            if(fileOutputStream0 != null) {
                try {
                    fileOutputStream0.close();
                }
                catch(IOException unused_ex) {
                }
            }
            z = false;
            goto label_35;
        }
        catch(Throwable throwable0) {
        }
    label_30:
        if(fileOutputStream0 != null) {
            try {
                fileOutputStream0.close();
            }
            catch(IOException unused_ex) {
            }
        }
        throw throwable0;
        try {
        label_33:
            fileOutputStream0.close();
            z = true;
        }
        catch(IOException unused_ex) {
        }
    label_35:
        if(Log.isLoggable("BitmapEncoder", 2)) {
            Log.v("BitmapEncoder", "Compressed with type: " + bitmap$CompressFormat0 + " of size " + Util.getBitmapByteSize(bitmap0) + " in " + LogTime.getElapsedMillis(v) + ", options format: " + options0.get(BitmapEncoder.COMPRESSION_FORMAT) + ", hasAlpha: " + bitmap0.hasAlpha());
        }
        return z;
    }

    @Override  // com.bumptech.glide.load.Encoder
    public boolean encode(Object object0, File file0, Options options0) {
        return this.encode(((Resource)object0), file0, options0);
    }

    @Override  // com.bumptech.glide.load.ResourceEncoder
    public EncodeStrategy getEncodeStrategy(Options options0) {
        return EncodeStrategy.TRANSFORMED;
    }

    private Bitmap.CompressFormat getFormat(Bitmap bitmap0, Options options0) {
        Bitmap.CompressFormat bitmap$CompressFormat0 = (Bitmap.CompressFormat)options0.get(BitmapEncoder.COMPRESSION_FORMAT);
        if(bitmap$CompressFormat0 != null) {
            return bitmap$CompressFormat0;
        }
        return bitmap0.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }
}

