package Y6;

import D7.a;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import com.google.firebase.e;
import y7.b;

public final class g implements b {
    public final int a;
    public final Object b;
    public final Object c;

    public g(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // y7.b
    public final Object get() {
        switch(this.a) {
            case 0: {
                u u0 = new u(((c)this.c), ((h)this.b));
                return ((c)this.c).f.c(u0);
            }
            case 1: {
                String s = ((e)this.b).d();
                v7.b b0 = (v7.b)((e)this.b).d.get(v7.b.class);
                a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                Context context0 = P1.c.createDeviceProtectedStorageContext(((Context)this.c));
                SharedPreferences sharedPreferences0 = context0.getSharedPreferences("com.google.firebase.common.prefs:" + s, 0);
                boolean z = true;
                if(sharedPreferences0.contains("firebase_data_collection_default_enabled")) {
                    z = sharedPreferences0.getBoolean("firebase_data_collection_default_enabled", true);
                }
                else {
                    try {
                        PackageManager packageManager0 = context0.getPackageManager();
                        if(packageManager0 != null) {
                            ApplicationInfo applicationInfo0 = packageManager0.getApplicationInfo("com.iloen.melon", 0x80);
                            if(applicationInfo0 != null && (applicationInfo0.metaData != null && applicationInfo0.metaData.containsKey("firebase_data_collection_default_enabled"))) {
                                z = applicationInfo0.metaData.getBoolean("firebase_data_collection_default_enabled");
                            }
                        }
                        a0.a = z;
                        return a0;
                    }
                    catch(PackageManager.NameNotFoundException unused_ex) {
                    }
                }
                a0.a = z;
                return a0;
            }
            default: {
                return new w7.g(((Context)this.b), ((String)this.c));
            }
        }
    }
}

