package G8;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.iloen.melon.drm.AbsDcfController;
import com.iloen.melon.drm.downloadable.DownloadableDcfController;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class m extends i implements n {
    public final long B;
    public final String D;
    public final Context r;
    public final String w;

    public m(Context context0, String s, long v, String s1, Continuation continuation0) {
        this.r = context0;
        this.w = s;
        this.B = v;
        this.D = s1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new m(this.r, this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((m)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Bitmap.Config bitmap$Config0;
        Bitmap bitmap0;
        byte[] arr_b1;
        byte[] arr_b;
        d5.n.D(object0);
        o o0 = f.a;
        Context context0 = this.r;
        String s = this.w;
        String s1 = this.D;
        Uri uri0 = null;
        if(Long.compare(this.B, 0L) > 0) {
            MediaMetadataRetriever mediaMetadataRetriever0 = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever0.setDataSource(context0, Uri.parse(s));
                arr_b = mediaMetadataRetriever0.getEmbeddedPicture();
            }
            catch(Exception exception0) {
                LogU.Companion.e("LocalThumbnailManager", "getImageFromMediaMetadataRetriever() error: " + exception0);
                arr_b = null;
            }
            finally {
                mediaMetadataRetriever0.release();
            }
        }
        else {
            synchronized(o0) {
                AbsDcfController absDcfController0 = R8.m.a(context0, R8.m.a);
                try {
                    if(!(absDcfController0 instanceof DownloadableDcfController) || Tf.o.H0(s)) {
                        goto label_36;
                    }
                    else {
                        arr_b1 = ((DownloadableDcfController)absDcfController0).i(s);
                        goto label_30;
                    }
                    goto label_39;
                }
                catch(Throwable throwable0) {
                    R8.m.b(context0);
                    throw throwable0;
                }
            label_30:
                R8.m.b(context0);
                arr_b = arr_b1;
                goto label_39;
            label_36:
                R8.m.b(context0);
            }
            arr_b = null;
        }
    label_39:
        if(arr_b == null) {
            LogU.Companion.w("LocalThumbnailManager", "makeThumbInternal() thumb image buffer is null");
            return null;
        }
        try {
            boolean z = true;
            BitmapFactory.Options bitmapFactory$Options0 = new BitmapFactory.Options();
            bitmapFactory$Options0.inJustDecodeBounds = true;
            bitmapFactory$Options0.inSampleSize = 1;
            BitmapFactory.decodeByteArray(arr_b, 0, arr_b.length, bitmapFactory$Options0);
            if(bitmapFactory$Options0.inSampleSize == 1) {
                bitmap0 = null;
                z = false;
            }
            else {
                bitmapFactory$Options0.inJustDecodeBounds = false;
                bitmap$Config0 = Bitmap.Config.RGB_565;
                bitmapFactory$Options0.inPreferredConfig = bitmap$Config0;
                bitmap0 = BitmapFactory.decodeByteArray(arr_b, 0, arr_b.length, bitmapFactory$Options0);
                goto label_59;
            }
            goto label_68;
        }
        catch(Exception exception1) {
            bitmap0 = null;
            goto label_67;
        }
    label_59:
        if(bitmap0 != null) {
            try {
                if(bitmap0.getConfig() == null) {
                    Bitmap bitmap1 = bitmap0.copy(bitmap$Config0, false);
                    if(bitmap1 != null && !bitmap1.equals(bitmap0)) {
                        bitmap0.recycle();
                        bitmap0 = bitmap1;
                    }
                }
                goto label_68;
            }
            catch(Exception exception1) {
            }
        label_67:
            LogU.Companion.e("LocalThumbnailManager", "makeThumbInternal() error on create bitmap from bytearray: " + exception1);
        }
    label_68:
        if(!z || bitmap0 != null) {
            File file0 = FileUtils.getDiskCacheDir(context0, "albumThumbs");
            if(!file0.exists()) {
                file0.mkdirs();
            }
            File file1 = new File(file0, s1);
            if(file1.exists()) {
                return Uri.fromFile(file1);
            }
            file1.createNewFile();
            try {
                try {
                    FileOutputStream fileOutputStream0 = new FileOutputStream(file1);
                    if(!z) {
                        fileOutputStream0.write(arr_b);
                    }
                    else if(bitmap0 != null) {
                        bitmap0.compress(Bitmap.CompressFormat.JPEG, 75, fileOutputStream0);
                    }
                    fileOutputStream0.close();
                    uri0 = Uri.fromFile(file1);
                    goto label_94;
                }
                catch(Exception exception2) {
                }
                LogU.Companion.e("LocalThumbnailManager", "makeThumbInternal() error creating file: " + exception2);
                if(bitmap0 == null) {
                    return null;
                }
                goto label_95;
            }
            catch(Throwable throwable1) {
                goto label_91;
            }
            return null;
        label_91:
            if(bitmap0 != null) {
                bitmap0.recycle();
            }
            throw throwable1;
        label_94:
            if(bitmap0 != null) {
            label_95:
                bitmap0.recycle();
                return uri0;
            }
        }
        return uri0;
    }
}

