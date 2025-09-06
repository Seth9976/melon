package androidx.startup;

import K4.a;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Trace;
import i.n.i.b.a.s.e.M3;

public class InitializationProvider extends ContentProvider {
    @Override  // android.content.ContentProvider
    public final int delete(Uri uri0, String s, String[] arr_s) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override  // android.content.ContentProvider
    public final String getType(Uri uri0) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override  // android.content.ContentProvider
    public final Uri insert(Uri uri0, ContentValues contentValues0) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override  // android.content.ContentProvider
    public final boolean onCreate() {
        Context context0 = this.getContext();
        if(context0 == null) {
            throw new M3("Context cannot be null");  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
        }
        if(context0.getApplicationContext() != null) {
            a a0 = a.c(context0);
            try {
                Trace.beginSection("Startup");
                ComponentName componentName0 = new ComponentName("com.iloen.melon", "androidx.startup.InitializationProvider");
                a0.a(a0.c.getPackageManager().getProviderInfo(componentName0, 0x80).metaData);
                return true;
            }
            catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                throw new M3(packageManager$NameNotFoundException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V
            }
            finally {
                Trace.endSection();
            }
        }
        return true;
    }

    @Override  // android.content.ContentProvider
    public final Cursor query(Uri uri0, String[] arr_s, String s, String[] arr_s1, String s1) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override  // android.content.ContentProvider
    public final int update(Uri uri0, ContentValues contentValues0, String s, String[] arr_s) {
        throw new IllegalStateException("Not allowed.");
    }
}

