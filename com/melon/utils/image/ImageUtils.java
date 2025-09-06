package com.melon.utils.image;

import A8.b;
import Od.a;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import androidx.appcompat.app.o;
import coil.request.ImageRequest.Builder;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import d8.d;
import i5.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Inject;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import oe.c;
import org.jetbrains.annotations.NotNull;
import t5.j;
import t5.k;
import t5.s;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/melon/utils/image/ImageUtils;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ImageUtils {
    public final Context a;

    @Inject
    public ImageUtils(@NotNull Context context0) {
        q.g(context0, "context");
        super();
        this.a = context0;
    }

    public final Object a(Context context0, Uri uri0, c c0) {
        a a0;
        if(c0 instanceof a) {
            a0 = (a)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new a(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new a(this, c0);
        }
        Object object0 = a0.r;
        ne.a a1 = ne.a.a;
        switch(a0.B) {
            case 0: {
                n.D(object0);
                ImageRequest.Builder imageRequest$Builder0 = new ImageRequest.Builder(context0);
                imageRequest$Builder0.c = uri0;
                imageRequest$Builder0.n = Boolean.FALSE;
                j j0 = imageRequest$Builder0.a();
                e e0 = i5.a.a(context0);
                a0.B = 1;
                object0 = ((i5.n)e0).c(j0, a0);
                if(object0 == a1) {
                    return a1;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        s s0 = ((k)object0) instanceof s ? ((s)(((k)object0))) : null;
        Drawable drawable0 = s0 == null ? null : s0.a;
        BitmapDrawable bitmapDrawable0 = drawable0 instanceof BitmapDrawable ? ((BitmapDrawable)drawable0) : null;
        return bitmapDrawable0 != null ? bitmapDrawable0.getBitmap() : null;
    }

    public static Bitmap b(Bitmap bitmap0, int v, int v1, Matrix matrix0) {
        int v2 = Math.min(v, 4000);
        int v3 = Math.min(v1, 4000);
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap0, 0, 0, v2, v3, matrix0, true);
        q.f(bitmap1, "createBitmap(...)");
        if(!bitmap1.equals(bitmap0)) {
            bitmap0.recycle();
        }
        StringBuilder stringBuilder0 = o.t(v2, v3, "getCropImage() targetWidth : ", ", targetHeight : ", ", matrix : ");
        stringBuilder0.append(matrix0);
        LogU.Companion.d("ImageUtils", stringBuilder0.toString());
        return bitmap1;
    }

    public static Bitmap c(Bitmap bitmap0, int v, int v1, Matrix matrix0) {
        float f = Math.min(4000.0f / ((float)v), 4000.0f / ((float)v1));
        int v2 = (int)(((float)v) * f);
        int v3 = (int)(((float)v1) * f);
        Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap0, v2, v3, false);
        q.f(bitmap1, "createScaledBitmap(...)");
        if(!bitmap1.equals(bitmap0)) {
            bitmap0.recycle();
        }
        Bitmap bitmap2 = Bitmap.createBitmap(bitmap1, 0, 0, v2, v3, matrix0, true);
        q.f(bitmap2, "createBitmap(...)");
        bitmap0.recycle();
        StringBuilder stringBuilder0 = o.t(v2, v3, "getResizeImage() newWidth : ", ", newHeight : ", ", matrix : ");
        stringBuilder0.append(matrix0);
        LogU.Companion.d("ImageUtils", stringBuilder0.toString());
        return bitmap2;
    }

    public final byte[] d(Uri uri0) {
        Bitmap bitmap1;
        int v;
        ExifInterface exifInterface0;
        q.g(uri0, "uri");
        Context context0 = this.a;
        OutputStream outputStream0 = null;
        try {
            exifInterface0 = new ExifInterface(context0.getContentResolver().openInputStream(uri0));
        }
        catch(IOException iOException0) {
            LogU.e("ImageManager", "cannot read exif", iOException0);
            exifInterface0 = null;
        }
        if(exifInterface0 == null) {
            v = 0;
        }
        else {
            switch(exifInterface0.getAttributeInt("Orientation", -1)) {
                case 3: {
                    v = 180;
                    break;
                }
                case 6: {
                    v = 90;
                    break;
                }
                case 8: {
                    v = 270;
                    break;
                }
                default: {
                    v = 0;
                }
            }
        }
        Companion logU$Companion0 = LogU.Companion;
        logU$Companion0.d("ImageUtils", "degree : " + v);
        Matrix matrix0 = new Matrix();
        matrix0.postRotate(((float)v));
        BitmapFactory.Options bitmapFactory$Options0 = new BitmapFactory.Options();
        boolean z = true;
        bitmapFactory$Options0.inJustDecodeBounds = true;
        InputStream inputStream0 = context0.getContentResolver().openInputStream(uri0);
        if(inputStream0 != null) {
            try {
                BitmapFactory.decodeStream(inputStream0, null, bitmapFactory$Options0);
            }
            catch(Throwable throwable0) {
                d.l(inputStream0, throwable0);
                throw throwable0;
            }
            inputStream0.close();
        }
        int v1 = bitmapFactory$Options0.outWidth;
        int v2 = bitmapFactory$Options0.outHeight;
        double f = ((double)v1) / ((double)v2);
        if(f > 5.0 || f < 0.2 || v1 <= 4000 && v2 <= 4000) {
            z = false;
        }
        StringBuilder stringBuilder0 = o.t(v1, v2, "originalWidth : ", ", originalHeight : ", ", needResize : ");
        stringBuilder0.append(z);
        logU$Companion0.d("ImageUtils", stringBuilder0.toString());
        InputStream inputStream1 = context0.getContentResolver().openInputStream(uri0);
        if(inputStream1 == null) {
            bitmap1 = null;
        }
        else {
            try {
                Bitmap bitmap0 = BitmapFactory.decodeStream(inputStream1);
                if(z) {
                    q.d(bitmap0);
                    bitmap1 = ImageUtils.c(bitmap0, v1, v2, matrix0);
                }
                else {
                    q.d(bitmap0);
                    bitmap1 = ImageUtils.b(bitmap0, v1, v2, matrix0);
                }
                goto label_57;
            }
            catch(Throwable throwable1) {
            }
            try {
                throw throwable1;
            }
            catch(Throwable throwable2) {
                d.l(inputStream1, throwable1);
                throw throwable2;
            }
        label_57:
            inputStream1.close();
        }
        if(bitmap1 == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
        int v3 = 100;
        bitmap1.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream0);
        int v4 = byteArrayOutputStream0.toByteArray().length;
        Y.t("original size : ", v4, logU$Companion0, "ImageUtils");
        while(((long)v4) > 0x7D000L && v3 > 0) {
            byteArrayOutputStream0.reset();
            v3 -= 15;
            v3 = v3 >= 0 ? v3 - 15 : 0;
            bitmap1.compress(Bitmap.CompressFormat.JPEG, v3, byteArrayOutputStream0);
            v4 = byteArrayOutputStream0.toByteArray().length;
            LogU.Companion.d("ImageUtils", "compressed size : " + v4 + " / quality : " + v3);
        }
        byte[] arr_b = byteArrayOutputStream0.toByteArray();
        q.f(arr_b, "toByteArray(...)");
        bitmap1.recycle();
        if(b.a().equalsIgnoreCase("DEBUG") || b.a().equalsIgnoreCase("QA")) {
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            ContentResolver contentResolver0 = context0.getContentResolver();
            if(contentResolver0 != null) {
                ContentValues contentValues0 = new ContentValues();
                contentValues0.put("_display_name", "resizeOcr_20250906_113731.png");
                contentValues0.put("mime_type", "image/png");
                contentValues0.put("relative_path", Environment.DIRECTORY_PICTURES);
                Uri uri1 = contentResolver0.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues0);
                if(uri1 != null) {
                    outputStream0 = contentResolver0.openOutputStream(uri1);
                }
            }
            if(outputStream0 != null) {
                outputStream0.write(arr_b);
            }
            if(outputStream0 != null) {
                outputStream0.close();
            }
        }
        return arr_b;
    }
}

