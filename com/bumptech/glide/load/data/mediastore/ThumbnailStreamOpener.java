package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import jeb.synthetic.TWR;

class ThumbnailStreamOpener {
    private static final FileService DEFAULT_SERVICE = null;
    private static final String TAG = "ThumbStreamOpener";
    private final ArrayPool byteArrayPool;
    private final ContentResolver contentResolver;
    private final List parsers;
    private final ThumbnailQuery query;
    private final FileService service;

    static {
        ThumbnailStreamOpener.DEFAULT_SERVICE = new FileService();
    }

    public ThumbnailStreamOpener(List list0, FileService fileService0, ThumbnailQuery thumbnailQuery0, ArrayPool arrayPool0, ContentResolver contentResolver0) {
        this.service = fileService0;
        this.query = thumbnailQuery0;
        this.byteArrayPool = arrayPool0;
        this.contentResolver = contentResolver0;
        this.parsers = list0;
    }

    public ThumbnailStreamOpener(List list0, ThumbnailQuery thumbnailQuery0, ArrayPool arrayPool0, ContentResolver contentResolver0) {
        this(list0, ThumbnailStreamOpener.DEFAULT_SERVICE, thumbnailQuery0, arrayPool0, contentResolver0);
    }

    public int getOrientation(Uri uri0) {
        int v;
        InputStream inputStream0;
        try {
            try {
                inputStream0 = null;
                inputStream0 = this.contentResolver.openInputStream(uri0);
                v = ImageHeaderParserUtils.getOrientation(this.parsers, inputStream0, this.byteArrayPool);
                goto label_14;
            }
            catch(IOException | NullPointerException iOException0) {
            }
            if(Log.isLoggable("ThumbStreamOpener", 3)) {
                Log.d("ThumbStreamOpener", "Failed to open uri: " + uri0, iOException0);
            }
        }
        catch(Throwable throwable0) {
            goto label_11;
        }
        if(inputStream0 != null) {
            try {
                inputStream0.close();
            }
            catch(IOException unused_ex) {
            }
        }
        return -1;
    label_11:
        if(inputStream0 != null) {
            try {
                inputStream0.close();
            }
            catch(IOException unused_ex) {
            }
        }
        throw throwable0;
    label_14:
        if(inputStream0 != null) {
            try {
                inputStream0.close();
            }
            catch(IOException unused_ex) {
            }
        }
        return v;
    }

    private String getPath(Uri uri0) {
        String s;
        Cursor cursor0 = null;
        try {
            cursor0 = this.query.query(uri0);
            goto label_6;
        }
        catch(SecurityException securityException0) {
            goto label_11;
        }
        catch(Throwable throwable0) {
        }
        TWR.safeClose$NT(null, throwable0);
        throw throwable0;
    label_6:
        if(cursor0 != null) {
            try {
                try {
                    if(cursor0.moveToFirst()) {
                        s = cursor0.getString(0);
                        goto label_19;
                    }
                    goto label_21;
                }
                catch(SecurityException securityException0) {
                }
            label_11:
                if(Log.isLoggable("ThumbStreamOpener", 3)) {
                    Log.d("ThumbStreamOpener", "Failed to query for thumbnail for Uri: " + uri0, securityException0);
                }
            }
            catch(Throwable throwable0) {
                goto label_17;
            }
            if(cursor0 != null) {
                cursor0.close();
            }
            return null;
        label_17:
            TWR.safeClose$NT(cursor0, throwable0);
            throw throwable0;
        label_19:
            cursor0.close();
            return s;
        }
    label_21:
        if(cursor0 != null) {
            cursor0.close();
        }
        return null;
    }

    private boolean isValid(File file0) {
        return this.service.exists(file0) && 0L < this.service.length(file0);
    }

    public InputStream open(Uri uri0) {
        String s = this.getPath(uri0);
        if(TextUtils.isEmpty(s)) {
            return null;
        }
        File file0 = this.service.get(s);
        if(!this.isValid(file0)) {
            return null;
        }
        Uri uri1 = Uri.fromFile(file0);
        try {
            return this.contentResolver.openInputStream(uri1);
        }
        catch(NullPointerException nullPointerException0) {
            throw (FileNotFoundException)new FileNotFoundException("NPE opening uri: " + uri0 + " -> " + uri1).initCause(nullPointerException0);
        }
    }
}

