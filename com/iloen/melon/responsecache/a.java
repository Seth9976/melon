package com.iloen.melon.responsecache;

import T3.e;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.google.gson.n;
import com.google.gson.x;
import com.iloen.melon.userstore.MelonDb;
import com.iloen.melon.utils.log.LogU;
import java.lang.reflect.Type;
import java.util.ArrayList;
import jeb.synthetic.FIN;
import k8.Y;

public abstract class a {
    public static final n a;

    static {
        a.a = new n();
    }

    public static void a(Context context0, Object object0, String s) {
        if(context0 == null) {
            LogU.w("ResponseCacheHelper", "add() invalid context");
            return;
        }
        e e0 = w9.a.a;
        MelonDb melonDb0 = e0.h();
        if(melonDb0 != null) {
            synchronized(a.class) {
                melonDb0.insertResponseCache(s, 0, a.a.k(object0), false, true);
            }
            e0.d();
        }
    }

    public static void b(Context context0, String s, ArrayList arrayList0, boolean z) {
        if(context0 == null) {
            LogU.w("ResponseCacheHelper", "add() invalid context");
            return;
        }
        e e0 = w9.a.a;
        MelonDb melonDb0 = e0.h();
        if(melonDb0 != null) {
            synchronized(a.class) {
                melonDb0.insertResponseCache(s, arrayList0, z);
            }
            e0.d();
        }
    }

    public static int c(Context context0, String s, boolean z) {
        if(context0 == null) {
            LogU.w("ResponseCacheHelper", "delete() invalid context");
            return 0;
        }
        e e0 = w9.a.a;
        MelonDb melonDb0 = e0.h();
        if(melonDb0 != null) {
            int v = melonDb0.deleteResponseCache(s, z);
            e0.d();
            return v;
        }
        return 0;
    }

    public static Object d(Cursor cursor0, Class class0) {
        String s;
        if(cursor0 == null) {
            LogU.w("ResponseCacheHelper", "extractContents() invalid cursor");
            return null;
        }
        Class class1 = a.class;
        __monitor_enter(class1);
        int v = FIN.finallyOpen$NT();
        if(cursor0.getCount() < 1) {
            LogU.w("ResponseCacheHelper", "getContents() invalid cursor");
            FIN.finallyExec$NT(v);
            s = null;
        }
        else if(cursor0.getCount() <= 0 || cursor0.moveToPosition(0)) {
            try {
                s = cursor0.getString(cursor0.getColumnIndex("contents"));
            }
            catch(Exception exception0) {
                LogU.w("ResponseCacheHelper", "getContents() " + exception0);
                s = null;
            }
            if(TextUtils.isEmpty(s)) {
                LogU.w("ResponseCacheHelper", "getContents() invalid contents");
                FIN.finallyExec$NT(v);
                s = null;
            }
            else {
                FIN.finallyCodeBegin$NT(v);
                __monitor_exit(class1);
                FIN.finallyCodeEnd$NT(v);
            }
        }
        else {
            LogU.w("ResponseCacheHelper", "getContents() failed to moveToPosition: 0");
            FIN.finallyExec$NT(v);
            s = null;
        }
        if(!TextUtils.isEmpty(s)) {
            try {
                return a.a.e(s, class0);
            }
            catch(x x0) {
                LogU.w("ResponseCacheHelper", "extractContents() " + x0.toString());
                try {
                    Type type0 = new ResponseCacheHelper.1().getType();
                    return a.a.f(s, type0);
                }
                catch(x x1) {
                    LogU.w("ResponseCacheHelper", "extractContents() " + x1.toString());
                }
            }
        }
        return null;
    }

    public static boolean e(long v, String s, Context context0) {
        boolean z = true;
        if(context0 == null) {
            LogU.w("ResponseCacheHelper", "isExpired() invalid context");
            return true;
        }
        e e0 = w9.a.a;
        MelonDb melonDb0 = e0.h();
        if(melonDb0 != null) {
            long v1 = melonDb0.queryResponseCacheModifiedTime(s);
            StringBuilder stringBuilder0 = Y.o(v1, "isExpired() modifiedTimeMillis:", ", timeout: ");
            stringBuilder0.append(v);
            LogU.v("ResponseCacheHelper", stringBuilder0.toString());
            if(v1 >= 0L && v >= 0L && System.currentTimeMillis() - v1 <= v) {
                z = false;
            }
            e0.d();
        }
        return z;
    }

    public static Cursor f(Context context0, String s) {
        if(context0 == null) {
            LogU.w("ResponseCacheHelper", "query() invalid context");
            return null;
        }
        e e0 = w9.a.a;
        MelonDb melonDb0 = e0.h();
        if(melonDb0 != null) {
            Cursor cursor0 = melonDb0.queryResponseCache(s);
            e0.d();
            return cursor0;
        }
        return null;
    }
}

