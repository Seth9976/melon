package com.iloen.melon.activity.crop;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.firebase.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import y2.g;

public final class n implements i {
    public final Uri a;
    public final ContentResolver b;

    public n(ContentResolver contentResolver0, Uri uri0) {
        this.b = contentResolver0;
        this.a = uri0;
    }

    public final Bitmap a(int v, int v1) {
        ParcelFileDescriptor parcelFileDescriptor0;
        try {
            Uri uri0 = this.a;
            try {
                parcelFileDescriptor0 = uri0.getScheme().equals("file") ? ParcelFileDescriptor.open(new File(uri0.getPath()), 0x10000000) : this.b.openFileDescriptor(uri0, "r");
            }
            catch(FileNotFoundException unused_ex) {
                parcelFileDescriptor0 = null;
            }
            Bitmap bitmap0 = b.K(v, parcelFileDescriptor0, v1);
            try {
                int v2 = new g(this.b()).l();
                Matrix matrix0 = new Matrix();
                matrix0.postRotate(((float)v2));
                return Bitmap.createBitmap(bitmap0, 0, 0, bitmap0.getWidth(), bitmap0.getHeight(), matrix0, true);
            }
            catch(IOException iOException0) {
                Log.e("UriImage", "unable to read EXIF metadata", iOException0);
                return bitmap0;
            }
        }
        catch(Exception exception0) {
            Log.e("UriImage", "got exception decoding bitmap ", exception0);
            return null;
        }
    }

    public final InputStream b() {
        try {
            Uri uri0 = this.a;
            return uri0.getScheme().equals("file") ? new FileInputStream(uri0.getPath()) : this.b.openInputStream(uri0);
        }
        catch(FileNotFoundException unused_ex) {
            return null;
        }
    }
}

