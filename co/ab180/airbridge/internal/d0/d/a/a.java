package co.ab180.airbridge.internal.d0.d.a;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000BJ\u001D\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001D\u0010\t\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\t\u0010\b¨\u0006\f"}, d2 = {"Lco/ab180/airbridge/internal/d0/d/a/a;", "", "Landroid/content/Context;", "context", "", "minApkVersion", "", "b", "(Landroid/content/Context;J)Z", "a", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class a {
    @NotNull
    public static final a a;

    static {
        a.a = new a();
    }

    public final boolean a(@NotNull Context context0, long v) {
        PackageManager packageManager0 = context0.getPackageManager();
        try {
            packageManager0.getPackageInfo("com.android.vending", 0);
            return Build.VERSION.SDK_INT < 28 ? ((long)packageManager0.getPackageInfo("com.google.android.gms", 0x80).versionCode) >= v : packageManager0.getPackageInfo("com.google.android.gms", 0x80).getLongVersionCode() >= v;
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
        }
        return false;
    }

    public final boolean b(@NotNull Context context0, long v) {
        PackageManager packageManager0 = context0.getPackageManager();
        try {
            return Build.VERSION.SDK_INT < 28 ? ((long)packageManager0.getPackageInfo("com.android.vending", 0x80).versionCode) >= v : packageManager0.getPackageInfo("com.android.vending", 0x80).getLongVersionCode() >= v;
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
        }
        return false;
    }
}

