package y0;

import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import kotlin.jvm.internal.q;

public final class e {
    public final Bitmap a;

    public e(Bitmap bitmap0) {
        this.a = bitmap0;
    }

    public final int a() {
        Bitmap.Config bitmap$Config0 = this.a.getConfig();
        q.d(bitmap$Config0);
        if(bitmap$Config0 == Bitmap.Config.ALPHA_8) {
            return 1;
        }
        if(bitmap$Config0 == Bitmap.Config.RGB_565) {
            return 2;
        }
        if(bitmap$Config0 != Bitmap.Config.ARGB_4444) {
            if(bitmap$Config0 == Bitmap.Config.RGBA_F16) {
                return 3;
            }
            return bitmap$Config0 == Bitmap.Config.HARDWARE ? 4 : 0;
        }
        return 0;
    }
}

