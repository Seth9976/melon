package t9;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.view.View;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.log.LogU;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.jvm.internal.q;

public final class z {
    public final int a;
    public final String b;
    public final String c;
    public final Sharable d;

    public z(int v, String s, String s1, Sharable sharable0) {
        this.a = v;
        this.b = s;
        this.c = s1;
        this.d = sharable0;
    }

    public static final Bitmap a(z z0, View view0) {
        view0.measure(0, 0);
        view0.layout(0, 0, view0.getMeasuredWidth(), view0.getMeasuredHeight());
        Bitmap bitmap0 = Bitmap.createBitmap(view0.getMeasuredWidth(), view0.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        q.f(bitmap0, "createBitmap(...)");
        view0.draw(new Canvas(bitmap0));
        return bitmap0;
    }

    public static final String b(z z0, Context context0, Bitmap bitmap0, String s) {
        try {
            File file0 = FileUtils.INSTANCE.getShareCacheDir(context0);
            if(!file0.exists()) {
                file0.mkdirs();
            }
            String s1 = file0.getCanonicalPath() + "/" + s;
            q.f(s1, "toString(...)");
            File file1 = new File(s1);
            file1.createNewFile();
            String s2 = file1.getCanonicalPath();
            FileOutputStream fileOutputStream0 = new FileOutputStream(s2);
            bitmap0.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream0);
            fileOutputStream0.close();
            q.d(s2);
            return s2;
        }
        catch(Exception exception0) {
        }
        LogU.Companion.w("InstagramSender", "saveBitmapToPngFile() >> Err: " + exception0);
        try {
            File file2 = FileUtils.INSTANCE.getShareCacheDir(context0);
            if(file2.exists()) {
                FileUtils.deleteSubFiles(file2.getCanonicalPath(), true);
            }
        }
        catch(Exception exception1) {
            LogU.Companion.w("InstagramSender", "clearFile() - Err: " + exception1);
        }
        throw exception0;
    }

    public static final void c(z z0, Context context0, String s, String s1) {
        Uri uri0 = FileUtils.getFileUri(context0, new File(s));
        Uri uri1 = FileUtils.getFileUri(context0, new File(s1));
        Intent intent0 = new Intent("com.instagram.share.ADD_TO_STORY");
        intent0.setFlags(1);
        intent0.addFlags(0x10000000);
        intent0.setDataAndType(uri0, "image/png");
        intent0.putExtra("interactive_asset_uri", uri1);
        context0.grantUriPermission("com.instagram.android", uri0, 1);
        context0.grantUriPermission("com.instagram.android", uri1, 1);
        context0.startActivity(intent0);
    }
}

