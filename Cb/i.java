package Cb;

import Tf.o;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.view.View.OnClickListener;
import android.view.View;
import android.webkit.MimeTypeMap;
import androidx.fragment.app.I;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.log.LogU;
import java.io.File;
import kotlin.jvm.internal.q;

public abstract class i {
    public static final void a(StringBuilder stringBuilder0, String s) {
        q.g(stringBuilder0, "<this>");
        q.g(s, "value");
        i.m(stringBuilder0);
        stringBuilder0.append(s);
    }

    public static final void b(View view0, View.OnClickListener view$OnClickListener0) {
        if(view0 != null) {
            view0.setOnClickListener(view$OnClickListener0);
        }
    }

    public static final long c(Object object0) {
        q.g(object0, "<this>");
        return System.currentTimeMillis();
    }

    public static final void d(File file0) {
        q.g(file0, "<this>");
        if(file0.exists()) {
            file0.delete();
        }
    }

    public static final int e(Cursor cursor0, String s) {
        int v = cursor0.getColumnIndex(s);
        return v == -1 ? 0 : cursor0.getInt(v);
    }

    public static final long f(Cursor cursor0, String s, long v) {
        int v1 = cursor0.getColumnIndex(s);
        return v1 == -1 ? v : cursor0.getLong(v1);
    }

    public static final String g(String s) {
        q.g(s, "<this>");
        String s1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(o.Y0('.', s, ""));
        return s1 == null ? "" : s1;
    }

    public static final String h(String s) {
        return s == null ? "" : s;
    }

    public static final String i(File file0) {
        q.g(file0, "<this>");
        try {
            String s = file0.getCanonicalPath();
            q.d(s);
            return s;
        }
        catch(Exception unused_ex) {
            String s1 = file0.getAbsolutePath();
            q.d(s1);
            return s1;
        }
    }

    public static final String j(Cursor cursor0, String s) {
        int v = cursor0.getColumnIndex(s);
        if(v != -1) {
            String s1 = cursor0.getString(v);
            return s1 == null ? "" : s1;
        }
        return "";
    }

    public static final String k(I i0, int v) {
        q.g(i0, "<this>");
        Context context0 = i0.getContext();
        if(context0 != null) {
            Resources resources0 = context0.getResources();
            if(resources0 != null) {
                String s = resources0.getString(v);
                return s == null ? "" : s;
            }
        }
        return "";
    }

    public static final boolean l(Object object0) {
        return object0 == null ? 0 : 1;
    }

    public static final void m(StringBuilder stringBuilder0) {
        q.g(stringBuilder0, "<this>");
        stringBuilder0.append("\n");
    }

    public static Cursor n(Context context0, Uri uri0, String[] arr_s, String s, String[] arr_s1, int v) {
        if((v & 2) != 0) {
            arr_s = null;
        }
        if((v & 4) != 0) {
            s = null;
        }
        if((v & 8) != 0) {
            arr_s1 = null;
        }
        q.g(context0, "<this>");
        q.g(uri0, "uri");
        try {
            return context0.getContentResolver().query(uri0, arr_s, s, arr_s1, null);
        }
        catch(Exception exception0) {
            a.v("safetyQuery() error : ", exception0.getMessage(), LogU.Companion, "Context");
            return null;
        }
    }

    public static final String o(Object object0) [...] // 潜在的解密器
}

