package P1;

import N1.e;
import N1.z;
import R1.g;
import R1.h;
import R1.j;
import V4.u;
import Y1.d;
import Y1.f;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import jeb.synthetic.FIN;

public abstract class c {
    private static final String DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION_SUFFIX = ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
    public static final int RECEIVER_EXPORTED = 2;
    public static final int RECEIVER_NOT_EXPORTED = 4;
    public static final int RECEIVER_VISIBLE_TO_INSTANT_APPS = 1;
    private static final String TAG = "ContextCompat";
    private static final Object sSync;

    static {
        c.sSync = new Object();
    }

    public static int checkSelfPermission(Context context0, String s) {
        if(s == null) {
            throw new NullPointerException("permission must be non-null");
        }
        if(Build.VERSION.SDK_INT < 33 && TextUtils.equals("android.permission.POST_NOTIFICATIONS", s)) {
            return new z(context0).b.areNotificationsEnabled() ? 0 : -1;
        }
        return context0.checkPermission(s, Process.myPid(), Process.myUid());
    }

    public static Context createAttributionContext(Context context0, String s) {
        return Build.VERSION.SDK_INT < 30 ? context0 : b.a(context0, s);
    }

    public static Context createDeviceProtectedStorageContext(Context context0) {
        return context0.createDeviceProtectedStorageContext();
    }

    public static String getAttributionTag(Context context0) {
        return Build.VERSION.SDK_INT < 30 ? null : b.c(context0);
    }

    public static File getCodeCacheDir(Context context0) {
        return context0.getCodeCacheDir();
    }

    public static int getColor(Context context0, int v) {
        return context0.getColor(v);
    }

    public static ColorStateList getColorStateList(Context context0, int v) {
        ColorStateList colorStateList1;
        Resources resources0 = context0.getResources();
        Resources.Theme resources$Theme0 = context0.getTheme();
        h h0 = new h(resources0, resources$Theme0);
        Object object0 = j.c;
        __monitor_enter(object0);
        int v1 = FIN.finallyOpen$NT();
        SparseArray sparseArray0 = (SparseArray)j.b.get(h0);
        ColorStateList colorStateList0 = null;
        if(sparseArray0 == null || sparseArray0.size() <= 0) {
        label_17:
            FIN.finallyCodeBegin$NT(v1);
            __monitor_exit(object0);
            FIN.finallyCodeEnd$NT(v1);
            colorStateList1 = null;
        }
        else {
            g g0 = (g)sparseArray0.get(v);
            if(g0 == null) {
                goto label_17;
            }
            else {
                Configuration configuration0 = resources0.getConfiguration();
                if(!g0.b.equals(configuration0) || (resources$Theme0 != null || g0.c != 0) && (resources$Theme0 == null || g0.c != resources$Theme0.hashCode())) {
                    sparseArray0.remove(v);
                    goto label_17;
                }
                else {
                    colorStateList1 = g0.a;
                    FIN.finallyExec$NT(v1);
                }
            }
        }
        if(colorStateList1 != null) {
            return colorStateList1;
        }
        ThreadLocal threadLocal0 = j.a;
        TypedValue typedValue0 = (TypedValue)threadLocal0.get();
        if(typedValue0 == null) {
            typedValue0 = new TypedValue();
            threadLocal0.set(typedValue0);
        }
        resources0.getValue(v, typedValue0, true);
        if(typedValue0.type < 28 || typedValue0.type > 0x1F) {
            XmlResourceParser xmlResourceParser0 = resources0.getXml(v);
            try {
                colorStateList0 = R1.b.a(resources0, xmlResourceParser0, resources$Theme0);
            }
            catch(Exception exception0) {
                Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", exception0);
            }
        }
        if(colorStateList0 != null) {
            synchronized(j.c) {
                WeakHashMap weakHashMap0 = j.b;
                SparseArray sparseArray1 = (SparseArray)weakHashMap0.get(h0);
                if(sparseArray1 == null) {
                    sparseArray1 = new SparseArray();
                    weakHashMap0.put(h0, sparseArray1);
                }
                sparseArray1.append(v, new g(colorStateList0, h0.a.getConfiguration(), resources$Theme0));
                return colorStateList0;
            }
        }
        return resources0.getColorStateList(v, resources$Theme0);
    }

    public static Context getContextForLanguage(Context context0) {
        f f0;
        int v = Build.VERSION.SDK_INT;
        if(v >= 33) {
            Object object0 = context0.getSystemService("locale");
            f0 = object0 == null ? f.b : new f(new Y1.g(N1.j.a(object0)));
        }
        else {
            f0 = f.a(e.e(context0));
        }
        if(v <= 0x20 && !f0.a.a.isEmpty()) {
            Configuration configuration0 = new Configuration(context0.getResources().getConfiguration());
            configuration0.setLocales(f0.a.a);
            return context0.createConfigurationContext(configuration0);
        }
        return context0;
    }

    public static File getDataDir(Context context0) {
        return context0.getDataDir();
    }

    public static Display getDisplayOrDefault(Context context0) {
        return Build.VERSION.SDK_INT < 30 ? ((WindowManager)context0.getSystemService("window")).getDefaultDisplay() : b.d(context0);
    }

    public static Drawable getDrawable(Context context0, int v) {
        return context0.getDrawable(v);
    }

    @Deprecated
    public static File[] getExternalCacheDirs(Context context0) {
        return context0.getExternalCacheDirs();
    }

    @Deprecated
    public static File[] getExternalFilesDirs(Context context0, String s) {
        return context0.getExternalFilesDirs(s);
    }

    public static Executor getMainExecutor(Context context0) {
        return Build.VERSION.SDK_INT >= 28 ? a.e(context0) : new d(new Handler(context0.getMainLooper()), 0);
    }

    public static File getNoBackupFilesDir(Context context0) {
        return context0.getNoBackupFilesDir();
    }

    @Deprecated
    public static File[] getObbDirs(Context context0) {
        return context0.getObbDirs();
    }

    public static String getString(Context context0, int v) {
        return c.getContextForLanguage(context0).getString(v);
    }

    public static Object getSystemService(Context context0, Class class0) {
        return context0.getSystemService(class0);
    }

    public static String getSystemServiceName(Context context0, Class class0) {
        return context0.getSystemServiceName(class0);
    }

    public static boolean isDeviceProtectedStorage(Context context0) {
        return context0.isDeviceProtectedStorage();
    }

    public static String obtainAndCheckReceiverPermission(Context context0) {
        String s = "com.iloen.melon.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
        if(u.l(context0, "com.iloen.melon.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION") != 0) {
            if(Build.VERSION.SDK_INT >= 29) {
                s = context0.getOpPackageName() + ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
                if(u.l(context0, s) == 0) {
                    return s;
                }
            }
            throw new RuntimeException("Permission " + s + " is required by your application to receive broadcasts, please add it to your manifest");
        }
        return "com.iloen.melon.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
    }

    public static Intent registerReceiver(Context context0, BroadcastReceiver broadcastReceiver0, IntentFilter intentFilter0, int v) {
        return c.registerReceiver(context0, broadcastReceiver0, intentFilter0, null, null, v);
    }

    public static Intent registerReceiver(Context context0, BroadcastReceiver broadcastReceiver0, IntentFilter intentFilter0, String s, Handler handler0, int v) {
        if((v & 1) != 0 && (v & 4) != 0) {
            throw new IllegalArgumentException("Cannot specify both RECEIVER_VISIBLE_TO_INSTANT_APPS and RECEIVER_NOT_EXPORTED");
        }
        if((v & 1) != 0) {
            v |= 2;
        }
        if((v & 2) == 0 && (v & 4) == 0) {
            throw new IllegalArgumentException("One of either RECEIVER_EXPORTED or RECEIVER_NOT_EXPORTED is required");
        }
        if((v & 2) != 0 && (v & 4) != 0) {
            throw new IllegalArgumentException("Cannot specify both RECEIVER_EXPORTED and RECEIVER_NOT_EXPORTED");
        }
        if(Build.VERSION.SDK_INT >= 33) {
            return context0.registerReceiver(broadcastReceiver0, intentFilter0, s, handler0, v);
        }
        return (v & 4) == 0 || s != null ? context0.registerReceiver(broadcastReceiver0, intentFilter0, s, handler0, v & 1) : context0.registerReceiver(broadcastReceiver0, intentFilter0, c.obtainAndCheckReceiverPermission(context0), handler0);
    }

    public static boolean startActivities(Context context0, Intent[] arr_intent) {
        return c.startActivities(context0, arr_intent, null);
    }

    public static boolean startActivities(Context context0, Intent[] arr_intent, Bundle bundle0) {
        context0.startActivities(arr_intent, bundle0);
        return true;
    }

    @Deprecated
    public static void startActivity(Context context0, Intent intent0, Bundle bundle0) {
        context0.startActivity(intent0, bundle0);
    }

    public static void startForegroundService(Context context0, Intent intent0) {
        context0.startForegroundService(intent0);
    }
}

