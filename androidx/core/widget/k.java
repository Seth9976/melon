package androidx.core.widget;

import A6.i;
import Bd.s;
import P1.a;
import U4.x;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.util.Base64;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService.RemoteViewsFactory;
import kotlin.jvm.internal.q;

public final class k implements RemoteViewsService.RemoteViewsFactory {
    public final RemoteViewsCompatService a;
    public final int b;
    public final int c;
    public i d;
    public static final i e;

    static {
        k.e = new i(new long[0], new RemoteViews[0]);
    }

    public k(RemoteViewsCompatService remoteViewsCompatService0, int v, int v1) {
        this.a = remoteViewsCompatService0;
        this.b = v;
        this.c = v1;
        this.d = k.e;
    }

    public final void a() {
        i i1;
        s s1;
        Long long0;
        PackageInfo packageInfo0;
        RemoteViewsCompatService remoteViewsCompatService0 = this.a;
        SharedPreferences sharedPreferences0 = remoteViewsCompatService0.getSharedPreferences("androidx.core.widget.prefs.RemoteViewsCompat", 0);
        q.f(sharedPreferences0, "context.getSharedPrefere…S_FILENAME, MODE_PRIVATE)");
        int v = this.b;
        i i0 = null;
        String s = sharedPreferences0.getString(v + ':' + this.c, null);
        if(s == null) {
            x.u(v, "No collection items were stored for widget ", "RemoteViewsCompatServic");
        }
        else {
            byte[] arr_b = Base64.decode(s, 0);
            q.f(arr_b, "decode(hexString, Base64.DEFAULT)");
            Parcel parcel0 = Parcel.obtain();
            q.f(parcel0, "obtain()");
            try {
                parcel0.unmarshall(arr_b, 0, arr_b.length);
                parcel0.setDataPosition(0);
                s1 = new s(parcel0);
            }
            finally {
                parcel0.recycle();
            }
            if(q.b(Build.VERSION.INCREMENTAL, ((String)s1.c))) {
                PackageManager packageManager0 = remoteViewsCompatService0.getPackageManager();
                try {
                    packageInfo0 = packageManager0.getPackageInfo("com.iloen.melon", 0);
                }
                catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                    Log.e("RemoteViewsCompatServic", "Couldn\'t retrieve version code for " + remoteViewsCompatService0.getPackageManager(), packageManager$NameNotFoundException0);
                    long0 = null;
                    goto label_31;
                }
                long0 = (long)(Build.VERSION.SDK_INT < 28 ? ((long)packageInfo0.versionCode) : a.d(packageInfo0));
            label_31:
                if(long0 == null) {
                    x.u(v, "Couldn\'t get version code, not using stored collection items for widget ", "RemoteViewsCompatServic");
                }
                else if(((long)long0) == s1.a) {
                    try {
                        byte[] arr_b1 = (byte[])s1.b;
                        q.g(arr_b1, "bytes");
                        Parcel parcel1 = Parcel.obtain();
                        q.f(parcel1, "obtain()");
                        try {
                            parcel1.unmarshall(arr_b1, 0, arr_b1.length);
                            parcel1.setDataPosition(0);
                            i1 = new i(parcel1);
                        }
                        finally {
                            parcel1.recycle();
                        }
                        i0 = i1;
                    }
                    catch(Throwable throwable0) {
                        Log.e("RemoteViewsCompatServic", "Unable to deserialize stored collection items for widget " + v, throwable0);
                    }
                }
                else {
                    x.u(v, "App version code has changed, not using stored collection items for widget ", "RemoteViewsCompatServic");
                }
            }
            else {
                x.u(v, "Android version code has changed, not using stored collection items for widget ", "RemoteViewsCompatServic");
            }
        }
        if(i0 == null) {
            i0 = k.e;
        }
        this.d = i0;
    }

    @Override  // android.widget.RemoteViewsService$RemoteViewsFactory
    public final int getCount() {
        return ((long[])this.d.d).length;
    }

    @Override  // android.widget.RemoteViewsService$RemoteViewsFactory
    public final long getItemId(int v) {
        try {
            return ((long[])this.d.d)[v];
        }
        catch(ArrayIndexOutOfBoundsException unused_ex) {
            return -1L;
        }
    }

    @Override  // android.widget.RemoteViewsService$RemoteViewsFactory
    public final RemoteViews getLoadingView() {
        return null;
    }

    @Override  // android.widget.RemoteViewsService$RemoteViewsFactory
    public final RemoteViews getViewAt(int v) {
        try {
            return ((RemoteViews[])this.d.e)[v];
        }
        catch(ArrayIndexOutOfBoundsException unused_ex) {
            return new RemoteViews("com.iloen.melon", 0x7F0D042C);  // layout:invalid_list_item
        }
    }

    @Override  // android.widget.RemoteViewsService$RemoteViewsFactory
    public final int getViewTypeCount() {
        return this.d.c;
    }

    @Override  // android.widget.RemoteViewsService$RemoteViewsFactory
    public final boolean hasStableIds() {
        return this.d.b;
    }

    @Override  // android.widget.RemoteViewsService$RemoteViewsFactory
    public final void onCreate() {
        this.a();
    }

    @Override  // android.widget.RemoteViewsService$RemoteViewsFactory
    public final void onDataSetChanged() {
        this.a();
    }

    @Override  // android.widget.RemoteViewsService$RemoteViewsFactory
    public final void onDestroy() {
    }
}

