package androidx.mediarouter.app;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.media.MediaDescriptionCompat;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import m4.e;
import m4.g;

public final class z extends AsyncTask {
    public final Bitmap a;
    public final Uri b;
    public int c;
    public final MediaRouteDynamicControllerDialog d;

    public z(MediaRouteDynamicControllerDialog mediaRouteDynamicControllerDialog0) {
        this.d = mediaRouteDynamicControllerDialog0;
        super();
        Uri uri0 = null;
        Bitmap bitmap0 = mediaRouteDynamicControllerDialog0.h0 == null ? null : mediaRouteDynamicControllerDialog0.h0.getIconBitmap();
        if(bitmap0 != null && bitmap0.isRecycled()) {
            Log.w("MediaRouteCtrlDialog", "Can\'t fetch the given art bitmap because it\'s already recycled.");
            bitmap0 = null;
        }
        this.a = bitmap0;
        MediaDescriptionCompat mediaDescriptionCompat0 = mediaRouteDynamicControllerDialog0.h0;
        if(mediaDescriptionCompat0 != null) {
            uri0 = mediaDescriptionCompat0.getIconUri();
        }
        this.b = uri0;
    }

    public final BufferedInputStream a(Uri uri0) {
        InputStream inputStream0;
        String s = uri0.getScheme().toLowerCase();
        if(!"android.resource".equals(s) && !"content".equals(s) && !"file".equals(s)) {
            URLConnection uRLConnection0 = new URL(uri0.toString()).openConnection();
            uRLConnection0.setConnectTimeout(30000);
            uRLConnection0.setReadTimeout(30000);
            inputStream0 = uRLConnection0.getInputStream();
            return inputStream0 == null ? null : new BufferedInputStream(inputStream0);
        }
        inputStream0 = this.d.n.getContentResolver().openInputStream(uri0);
        return inputStream0 == null ? null : new BufferedInputStream(inputStream0);
    }

    @Override  // android.os.AsyncTask
    public final Object doInBackground(Object[] arr_object) {
        BitmapFactory.Options bitmapFactory$Options0;
        BufferedInputStream bufferedInputStream1;
        Void[] arr_void = (Void[])arr_object;
        int v = 0;
        BufferedInputStream bufferedInputStream0 = null;
        Bitmap bitmap0 = this.a;
        if(bitmap0 == null) {
            Uri uri0 = this.b;
            if(uri0 == null) {
            label_49:
                bitmap0 = null;
            }
            else {
                try {
                    bufferedInputStream1 = null;
                    bufferedInputStream1 = this.a(uri0);
                    goto label_12;
                }
                catch(IOException iOException0) {
                    goto label_33;
                }
                catch(Throwable throwable0) {
                }
                goto label_39;
            label_12:
                if(bufferedInputStream1 == null) {
                    try {
                        try {
                            Log.w("MediaRouteCtrlDialog", "Unable to open: " + uri0);
                            return null;
                        label_15:
                            bitmapFactory$Options0 = new BitmapFactory.Options();
                            bitmapFactory$Options0.inJustDecodeBounds = true;
                            BitmapFactory.decodeStream(bufferedInputStream1, null, bitmapFactory$Options0);
                            if(bitmapFactory$Options0.outWidth != 0 && bitmapFactory$Options0.outHeight != 0) {
                                goto label_19;
                            }
                            goto label_46;
                        }
                        catch(IOException iOException0) {
                            goto label_33;
                        }
                        try {
                        label_19:
                            bufferedInputStream1.reset();
                            goto label_26;
                        }
                        catch(IOException unused_ex) {
                            try {
                                bufferedInputStream1.close();
                                bufferedInputStream1 = this.a(uri0);
                                if(bufferedInputStream1 == null) {
                                    Log.w("MediaRouteCtrlDialog", "Unable to open: " + uri0);
                                    return null;
                                }
                            label_26:
                                bitmapFactory$Options0.inJustDecodeBounds = false;
                                int v1 = this.d.n.getResources().getDimensionPixelSize(0x7F070318);  // dimen:mr_cast_meta_art_size
                                bitmapFactory$Options0.inSampleSize = Math.max(1, Integer.highestOneBit(bitmapFactory$Options0.outHeight / v1));
                                if(this.isCancelled()) {
                                    goto label_44;
                                }
                                bitmap0 = BitmapFactory.decodeStream(bufferedInputStream1, null, bitmapFactory$Options0);
                                goto label_42;
                            }
                            catch(IOException iOException0) {
                            }
                        }
                    label_33:
                        Log.w("MediaRouteCtrlDialog", "Unable to open: " + uri0, iOException0);
                        if(bufferedInputStream1 != null) {
                            goto label_35;
                        }
                        goto label_49;
                    }
                    catch(Throwable throwable0) {
                    }
                }
                else {
                    goto label_15;
                    try {
                    label_35:
                        bufferedInputStream1.close();
                    }
                    catch(IOException unused_ex) {
                    }
                    goto label_49;
                }
                bufferedInputStream0 = bufferedInputStream1;
            label_39:
                if(bufferedInputStream0 != null) {
                    try {
                        bufferedInputStream0.close();
                    }
                    catch(IOException unused_ex) {
                    }
                }
                throw throwable0;
                try {
                label_42:
                    bufferedInputStream1.close();
                }
                catch(IOException unused_ex) {
                }
                goto label_50;
                try {
                label_44:
                    bufferedInputStream1.close();
                    return null;
                label_46:
                    bufferedInputStream1.close();
                }
                catch(IOException unused_ex) {
                }
                return null;
            }
        }
    label_50:
        if(bitmap0 != null && bitmap0.isRecycled()) {
            Log.w("MediaRouteCtrlDialog", "Can\'t use recycled bitmap: " + bitmap0);
            return null;
        }
        if(bitmap0 != null && bitmap0.getWidth() < bitmap0.getHeight()) {
            e e0 = new e(bitmap0);
            e0.a = 1;
            List list0 = e0.a().a;
            if(!Collections.unmodifiableList(list0).isEmpty()) {
                v = ((g)Collections.unmodifiableList(list0).get(0)).d;
            }
            this.c = v;
        }
        return bitmap0;
    }

    @Override  // android.os.AsyncTask
    public final void onPostExecute(Object object0) {
        MediaRouteDynamicControllerDialog mediaRouteDynamicControllerDialog0 = this.d;
        mediaRouteDynamicControllerDialog0.i0 = null;
        Bitmap bitmap0 = this.a;
        boolean z = Objects.equals(mediaRouteDynamicControllerDialog0.j0, bitmap0);
        Uri uri0 = this.b;
        if(z && Objects.equals(mediaRouteDynamicControllerDialog0.k0, uri0)) {
            return;
        }
        mediaRouteDynamicControllerDialog0.j0 = bitmap0;
        mediaRouteDynamicControllerDialog0.m0 = (Bitmap)object0;
        mediaRouteDynamicControllerDialog0.k0 = uri0;
        mediaRouteDynamicControllerDialog0.n0 = this.c;
        mediaRouteDynamicControllerDialog0.l0 = true;
        mediaRouteDynamicControllerDialog0.i();
    }

    @Override  // android.os.AsyncTask
    public final void onPreExecute() {
        this.d.l0 = false;
        this.d.m0 = null;
        this.d.n0 = 0;
    }
}

