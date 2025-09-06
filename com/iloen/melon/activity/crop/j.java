package com.iloen.melon.activity.crop;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import com.google.firebase.b;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.log.LogU;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public abstract class j {
    public static final Uri a;

    static {
        j.a = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    }

    public static Uri a(ContentResolver contentResolver0, String s, String s1, String s2, Bitmap bitmap0, int[] arr_v) {
        FileOutputStream fileOutputStream0;
        OutputStream outputStream0;
        String s3;
        try {
            s3 = s1 + "/" + s2;
            outputStream0 = null;
            File file0 = new File(s1);
            if(!file0.exists()) {
                file0.mkdirs();
            }
            fileOutputStream0 = new FileOutputStream(new File(s1, s2));
        }
        catch(FileNotFoundException fileNotFoundException0) {
            fileOutputStream0 = null;
            goto label_28;
        }
        catch(IOException iOException0) {
            fileOutputStream0 = null;
            goto label_31;
        }
        catch(Throwable throwable0) {
            b.s(outputStream0);
            throw throwable0;
        }
        if(bitmap0 == null) {
            goto label_19;
        label_29:
            b.s(fileOutputStream0);
            return null;
            try {
            label_31:
                LogU.e("ImageManager", iOException0.getMessage());
            }
            catch(Throwable throwable0) {
                outputStream0 = fileOutputStream0;
                b.s(outputStream0);
                throw throwable0;
            }
            b.s(fileOutputStream0);
            return null;
        }
        else {
            try {
                try {
                    bitmap0.compress(Bitmap.CompressFormat.JPEG, 75, fileOutputStream0);
                    arr_v[0] = 0;
                    goto label_36;
                label_19:
                    fileOutputStream0.write(null);
                    arr_v[0] = j.c(s3);
                    goto label_36;
                }
                catch(FileNotFoundException fileNotFoundException0) {
                }
                catch(IOException iOException0) {
                    goto label_31;
                }
            label_28:
                LogU.e("ImageManager", fileNotFoundException0.getMessage());
                goto label_29;
            }
            catch(Throwable throwable0) {
                outputStream0 = fileOutputStream0;
                b.s(outputStream0);
                throw throwable0;
            }
        }
    label_36:
        b.s(fileOutputStream0);
        ContentValues contentValues0 = new ContentValues(7);
        contentValues0.put("title", s);
        contentValues0.put("_display_name", s2);
        contentValues0.put("datetaken", 0L);
        contentValues0.put("mime_type", "image/jpeg");
        contentValues0.put("orientation", ((int)arr_v[0]));
        contentValues0.put("_data", s3);
        return contentResolver0.insert(j.a, contentValues0);
    }

    public static boolean b() {
        String s = StorageUtils.isScopedStorage() ? FileUtils.getSafetyPath(MelonAppBase.instance.getContext().getExternalCacheDir()) : Environment.getExternalStorageDirectory().toString() + "/DCIM";
        File file0 = new File(s);
        if(!file0.isDirectory() && !file0.mkdirs()) {
            return false;
        }
        File file1 = new File(s, ".probe");
        try {
            if(file1.exists()) {
                file1.delete();
            }
            if(!file1.createNewFile()) {
                return false;
            }
            file1.delete();
            return true;
        }
        catch(IOException unused_ex) {
            return false;
        }
    }

    public static int c(String s) {
        ExifInterface exifInterface0;
        try {
            exifInterface0 = new ExifInterface(s);
        }
        catch(IOException iOException0) {
            LogU.e("ImageManager", "cannot read exif", iOException0);
            exifInterface0 = null;
        }
        if(exifInterface0 != null) {
            switch(exifInterface0.getAttributeInt("Orientation", -1)) {
                case 3: {
                    return 180;
                }
                case 6: {
                    return 90;
                }
                case 8: {
                    return 270;
                }
                default: {
                    return 0;
                }
            }
        }
        return 0;
    }
}

