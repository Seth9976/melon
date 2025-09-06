package Vb;

import android.net.Uri;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import java.io.File;
import kotlin.jvm.internal.q;

public abstract class q0 {
    public static final LogU a;

    static {
        q0.a = Companion.create$default(LogU.Companion, "MelonPlay", false, Category.Playback, 2, null);
    }

    public static Uri a(Uri uri0) {
        String s = uri0.getQueryParameter("data");
        if(s == null) {
            s = "";
        }
        if(s.length() == 0) {
            Uri uri1 = Uri.EMPTY;
            q.f(uri1, "EMPTY");
            return uri1;
        }
        File file0 = new File(s);
        Uri uri2 = file0.exists() ? Uri.fromFile(file0) : Uri.parse(s);
        LogConstantsKt.debugOnlyDebugMode(q0.a, "getDataUri() Uri: " + uri2);
        q.f(uri2, "also(...)");
        return uri2;
    }
}

