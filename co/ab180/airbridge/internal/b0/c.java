package co.ab180.airbridge.internal.b0;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.UiModeManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import co.ab180.airbridge.internal.network.model.a;
import co.ab180.airbridge.internal.z.f;
import ie.j;
import java.util.Locale;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0003\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\t\u0010\bJ\u000F\u0010\t\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\t\u0010\u000BJ\u000F\u0010\f\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\f\u0010\u000BJ\u000F\u0010\u000E\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0007\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b\u0007\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u000BJ\u0017\u0010\u0012\u001A\n \u0011*\u0004\u0018\u00010\n0\nH\u0016\u00A2\u0006\u0004\b\u0012\u0010\u000BJ\u0017\u0010\u0013\u001A\n \u0011*\u0004\u0018\u00010\n0\nH\u0016\u00A2\u0006\u0004\b\u0013\u0010\u000BJ\u000F\u0010\u0014\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u0014\u0010\u000BJ\u000F\u0010\u0016\u001A\u00020\u0015H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0018\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u0018\u0010\u000BJ\u0017\u0010\u0019\u001A\n \u0011*\u0004\u0018\u00010\n0\nH\u0016\u00A2\u0006\u0004\b\u0019\u0010\u000BJ\u0017\u0010\u001A\u001A\n \u0011*\u0004\u0018\u00010\n0\nH\u0016\u00A2\u0006\u0004\b\u001A\u0010\u000BJ\u0017\u0010\u001B\u001A\n \u0011*\u0004\u0018\u00010\n0\nH\u0016\u00A2\u0006\u0004\b\u001B\u0010\u000BJ\u000F\u0010\u001C\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u001C\u0010\u000BJ\u000F\u0010\u001D\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u001D\u0010\u000BJ\u000F\u0010\u001E\u001A\u00020\u0006H\u0017\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0011\u0010!\u001A\u0004\u0018\u00010 H\u0017\u00A2\u0006\u0004\b!\u0010\"J\u0011\u0010$\u001A\u0004\u0018\u00010#H\u0017\u00A2\u0006\u0004\b$\u0010%R\u001B\u0010*\u001A\u00020&8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b\t\u0010\'\u001A\u0004\b(\u0010)R\u0014\u0010,\u001A\u00020 8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b\u0007\u0010+\u00A8\u0006-"}, d2 = {"Lco/ab180/airbridge/internal/b0/c;", "Lco/ab180/airbridge/internal/b0/b;", "<init>", "()V", "Landroid/net/ConnectivityManager;", "connectivityManager", "Lco/ab180/airbridge/internal/network/model/a;", "b", "(Landroid/net/ConnectivityManager;)Lco/ab180/airbridge/internal/network/model/a;", "a", "", "()Ljava/lang/String;", "h", "", "t", "()J", "f", "kotlin.jvm.PlatformType", "q", "i", "k", "Lco/ab180/airbridge/internal/b0/b$c;", "m", "()Lco/ab180/airbridge/internal/b0/b$c;", "n", "p", "r", "u", "s", "o", "c", "()Lco/ab180/airbridge/internal/network/model/a;", "", "l", "()Ljava/lang/Boolean;", "Lco/ab180/airbridge/internal/b0/b$b;", "g", "()Lco/ab180/airbridge/internal/b0/b$b;", "Landroid/content/Context;", "Lie/j;", "v", "()Landroid/content/Context;", "context", "Z", "isPc", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class c implements b {
    private final j a;
    private final boolean b;

    public c() {
        this.a = f.b(Context.class);
    }

    private final a a(ConnectivityManager connectivityManager0) {
        try {
            NetworkInfo networkInfo0 = connectivityManager0.getActiveNetworkInfo();
            if(networkInfo0 == null) {
                return a.c;
            }
            switch(networkInfo0.getType()) {
                case 0: {
                    return a.a;
                }
                case 1: {
                    return a.b;
                }
                default: {
                    return a.c;
                }
            }
        }
        catch(SecurityException unused_ex) {
            return a.c;
        }
        catch(Throwable unused_ex) {
            return a.c;
        }
    }

    @Override  // co.ab180.airbridge.internal.b0.b
    @NotNull
    public String a() {
        try {
            return this.v().getPackageManager().getPackageInfo("com.iloen.melon", 0).packageName;
        }
        catch(Throwable unused_ex) {
            co.ab180.airbridge.internal.b.e.b("Failed to get package name", new Object[0]);
            return "";
        }
    }

    @TargetApi(23)
    private final a b(ConnectivityManager connectivityManager0) {
        try {
            Network network0 = connectivityManager0.getActiveNetwork();
            if(network0 != null) {
                NetworkCapabilities networkCapabilities0 = connectivityManager0.getNetworkCapabilities(network0);
                if(networkCapabilities0 != null) {
                    if(networkCapabilities0.hasTransport(0)) {
                        return a.a;
                    }
                    return networkCapabilities0.hasTransport(1) ? a.b : a.c;
                }
            }
        }
        catch(SecurityException unused_ex) {
        }
        catch(Throwable unused_ex) {
        }
        return a.c;
    }

    @Override  // co.ab180.airbridge.internal.b0.b
    public long b() {
        try {
            return this.v().getPackageManager().getPackageInfo("com.iloen.melon", 0).firstInstallTime;
        }
        catch(Throwable unused_ex) {
            co.ab180.airbridge.internal.b.e.b("Failed to get first install time", new Object[0]);
            return 0L;
        }
    }

    @Override  // co.ab180.airbridge.internal.b0.b
    @SuppressLint({"MissingPermission"})
    @NotNull
    public a c() {
        Object object0 = this.v().getSystemService("connectivity");
        if(!(object0 instanceof ConnectivityManager)) {
            object0 = null;
        }
        if(((ConnectivityManager)object0) != null) {
            a a0 = this.b(((ConnectivityManager)object0));
            return a0 == a.c ? this.a(((ConnectivityManager)object0)) : a0;
        }
        return a.c;
    }

    @Override  // co.ab180.airbridge.internal.b0.b
    @NotNull
    public String d() {
        return co.ab180.airbridge.internal.b0.b.a.b(this);
    }

    @Override  // co.ab180.airbridge.internal.b0.b
    @NotNull
    public String e() {
        return co.ab180.airbridge.internal.b0.b.a.a(this);
    }

    @Override  // co.ab180.airbridge.internal.b0.b
    @NotNull
    public String f() {
        return this.i() + '-' + this.q();
    }

    @Override  // co.ab180.airbridge.internal.b0.b
    @SuppressLint({"MissingPermission"})
    @Nullable
    public co.ab180.airbridge.internal.b0.b.b g() {
        if(this.v().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0 && this.v().checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
            return null;
        }
        Object object0 = this.v().getSystemService("location");
        if(object0 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.location.LocationManager");
        }
        Location location0 = ((LocationManager)object0).getLastKnownLocation("gps");
        Location location1 = ((LocationManager)object0).getLastKnownLocation("network");
        if(location0 != null && location1 != null) {
            if(location0.getAccuracy() < location1.getAccuracy()) {
                return location0 == null ? null : new co.ab180.airbridge.internal.b0.b.b(location0.getLatitude(), location0.getLongitude(), location0.getAltitude(), location0.getSpeed());
            }
            return location1 == null ? null : new co.ab180.airbridge.internal.b0.b.b(location1.getLatitude(), location1.getLongitude(), location1.getAltitude(), location1.getSpeed());
        }
        if(location0 == null) {
            location0 = location1;
        }
        return location0 == null ? null : new co.ab180.airbridge.internal.b0.b.b(location0.getLatitude(), location0.getLongitude(), location0.getAltitude(), location0.getSpeed());
    }

    @Override  // co.ab180.airbridge.internal.b0.b
    @NotNull
    public String h() {
        try {
            String s = this.v().getPackageManager().getPackageInfo("com.iloen.melon", 0).versionName;
            return s == null ? "" : s;
        }
        catch(Throwable unused_ex) {
            co.ab180.airbridge.internal.b.e.b("Failed to get app version name", new Object[0]);
            return "";
        }
    }

    @Override  // co.ab180.airbridge.internal.b0.b
    public String i() {
        return Locale.getDefault().getLanguage();
    }

    @Override  // co.ab180.airbridge.internal.b0.b
    @NotNull
    public String j() {
        return co.ab180.airbridge.internal.b0.b.a.c(this);
    }

    // 去混淆评级： 低(40)
    @Override  // co.ab180.airbridge.internal.b0.b
    @NotNull
    public String k() {
        return "Asia/Shanghai";
    }

    @Override  // co.ab180.airbridge.internal.b0.b
    @SuppressLint({"MissingPermission"})
    @Nullable
    public Boolean l() {
        if(this.v().checkCallingOrSelfPermission("android.permission.BLUETOOTH") != 0) {
            return null;
        }
        BluetoothAdapter bluetoothAdapter0 = BluetoothAdapter.getDefaultAdapter();
        return bluetoothAdapter0 == null ? null : Boolean.valueOf(bluetoothAdapter0.isEnabled());
    }

    @Override  // co.ab180.airbridge.internal.b0.b
    @NotNull
    public co.ab180.airbridge.internal.b0.b.c m() {
        int v = this.v().getResources().getConfiguration().orientation;
        Object object0 = this.v().getSystemService("window");
        if(object0 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        DisplayMetrics displayMetrics0 = new DisplayMetrics();
        ((WindowManager)object0).getDefaultDisplay().getRealMetrics(displayMetrics0);
        return new co.ab180.airbridge.internal.b0.b.c(displayMetrics0.widthPixels, displayMetrics0.heightPixels, displayMetrics0.densityDpi, v);
    }

    @Override  // co.ab180.airbridge.internal.b0.b
    @NotNull
    public String n() {
        Object object0 = this.v().getSystemService("uimode");
        if(object0 != null) {
            switch(((UiModeManager)object0).getCurrentModeType()) {
                case 1: {
                    if(this.b) {
                        return "desktop";
                    }
                    return this.v().getResources().getConfiguration().smallestScreenWidthDp >= 600 ? "tablet" : "mobile";
                }
                case 2: {
                    return "desktop";
                }
                case 3: {
                    return "car";
                }
                case 4: {
                    return "tv";
                }
                case 5: {
                    return "appliance";
                }
                case 6: {
                    return "watch";
                }
                case 7: {
                    return "vr";
                }
                default: {
                    return "other";
                }
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.UiModeManager");
    }

    @Override  // co.ab180.airbridge.internal.b0.b
    @NotNull
    public String o() {
        Object object0 = this.v().getSystemService("phone");
        if(!(object0 instanceof TelephonyManager)) {
            object0 = null;
        }
        if(((TelephonyManager)object0) != null) {
            String s = ((TelephonyManager)object0).getSimOperator();
            return s == null ? "" : s;
        }
        return "";
    }

    // 去混淆评级： 低(20)
    @Override  // co.ab180.airbridge.internal.b0.b
    public String p() {
        return this.b ? "GooglePlayGamesOnPC" + '_' + Build.MODEL : Build.MODEL;
    }

    @Override  // co.ab180.airbridge.internal.b0.b
    public String q() {
        return Locale.getDefault().getCountry();
    }

    @Override  // co.ab180.airbridge.internal.b0.b
    public String r() {
        return Build.MANUFACTURER;
    }

    @Override  // co.ab180.airbridge.internal.b0.b
    @NotNull
    public String s() {
        Object object0 = this.v().getSystemService("phone");
        if(!(object0 instanceof TelephonyManager)) {
            object0 = null;
        }
        if(((TelephonyManager)object0) != null) {
            String s = ((TelephonyManager)object0).getSimOperatorName();
            return s == null ? "" : s;
        }
        return "";
    }

    @Override  // co.ab180.airbridge.internal.b0.b
    public long t() {
        PackageInfo packageInfo0;
        try {
            packageInfo0 = this.v().getPackageManager().getPackageInfo("com.iloen.melon", 0);
        }
        catch(Throwable unused_ex) {
            co.ab180.airbridge.internal.b.e.b("Failed to get app version code", new Object[0]);
            return 0L;
        }
        if(Build.VERSION.SDK_INT >= 28) {
            try {
                return packageInfo0.getLongVersionCode();
            }
            catch(Throwable unused_ex) {
            }
        }
        return (long)packageInfo0.versionCode;
    }

    @Override  // co.ab180.airbridge.internal.b0.b
    public String u() {
        return Build.VERSION.RELEASE;
    }

    private final Context v() {
        return (Context)this.a.getValue();
    }
}

