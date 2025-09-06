package com.google.android.gms.common.util;

import android.os.Build.VERSION;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Locale;
import kotlin.jvm.internal.q;

@KeepForSdk
public final class PlatformVersion {
    @KeepForSdk
    @Deprecated
    public static boolean isAtLeastHoneycomb() {
        return true;
    }

    @KeepForSdk
    public static boolean isAtLeastHoneycombMR1() {
        return true;
    }

    @KeepForSdk
    public static boolean isAtLeastIceCreamSandwich() [...] // Inlined contents

    @KeepForSdk
    public static boolean isAtLeastIceCreamSandwichMR1() {
        return true;
    }

    @KeepForSdk
    public static boolean isAtLeastJellyBean() [...] // Inlined contents

    @KeepForSdk
    public static boolean isAtLeastJellyBeanMR1() {
        return true;
    }

    @KeepForSdk
    public static boolean isAtLeastJellyBeanMR2() {
        return true;
    }

    @KeepForSdk
    public static boolean isAtLeastKitKat() [...] // Inlined contents

    @KeepForSdk
    public static boolean isAtLeastKitKatWatch() [...] // Inlined contents

    @KeepForSdk
    public static boolean isAtLeastLollipop() [...] // Inlined contents

    @KeepForSdk
    public static boolean isAtLeastLollipopMR1() {
        return true;
    }

    @KeepForSdk
    public static boolean isAtLeastM() [...] // Inlined contents

    @KeepForSdk
    public static boolean isAtLeastN() [...] // Inlined contents

    @KeepForSdk
    public static boolean isAtLeastO() [...] // Inlined contents

    @KeepForSdk
    public static boolean isAtLeastP() [...] // 潜在的解密器

    @KeepForSdk
    public static boolean isAtLeastQ() [...] // 潜在的解密器

    @KeepForSdk
    public static boolean isAtLeastR() [...] // 潜在的解密器

    @KeepForSdk
    public static boolean isAtLeastS() [...] // 潜在的解密器

    @KeepForSdk
    public static boolean isAtLeastSv2() {
        return Build.VERSION.SDK_INT >= 0x20;
    }

    @KeepForSdk
    public static boolean isAtLeastT() [...] // 潜在的解密器

    @KeepForSdk
    public static boolean isAtLeastU() [...] // 潜在的解密器

    @KeepForSdk
    public static boolean isAtLeastV() {
        Integer integer0 = 0;
        int v = Build.VERSION.SDK_INT;
        if(v < 35) {
            if(v >= 34) {
                String s = Build.VERSION.CODENAME;
                q.f(s, "CODENAME");
                if(!"REL".equals(s)) {
                    Locale locale0 = Locale.ROOT;
                    String s1 = s.toUpperCase(locale0);
                    q.f(s1, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                    Integer integer1 = s1.equals("BAKLAVA") ? 0 : null;
                    String s2 = "VanillaIceCream".toUpperCase(locale0);
                    q.f(s2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                    if(!s2.equals("BAKLAVA")) {
                        integer0 = null;
                    }
                    if(integer1 != null && integer0 != null) {
                        return ((int)integer1) >= ((int)integer0);
                    }
                    if(integer1 == null && integer0 == null) {
                        String s3 = s.toUpperCase(locale0);
                        q.f(s3, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                        String s4 = "VanillaIceCream".toUpperCase(locale0);
                        q.f(s4, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                        return s3.compareTo(s4) >= 0;
                    }
                    return integer1 != null;
                }
            }
            return false;
        }
        return true;
    }
}

