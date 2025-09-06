package p;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.customtabs.ICustomTabsService;
import android.text.TextUtils;

public abstract class d {
    public final ICustomTabsService a;
    public final ComponentName b;

    public d(ICustomTabsService iCustomTabsService0, ComponentName componentName0) {
        this.a = iCustomTabsService0;
        this.b = componentName0;
    }

    public static boolean a(Context context0, String s, k k0) {
        k0.setApplicationContext(context0.getApplicationContext());
        Intent intent0 = new Intent("android.support.customtabs.action.CustomTabsService");
        if(!TextUtils.isEmpty(s)) {
            intent0.setPackage(s);
        }
        return context0.bindService(intent0, k0, 33);
    }
}

