package com.google.android.gms.common.util;

import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.regex.Pattern;

@KeepForSdk
public class Strings {
    private static final Pattern zza;

    static {
        Strings.zza = Pattern.compile("\\$\\{(.*?)\\}");
    }

    // 去混淆评级： 低(20)
    @KeepForSdk
    public static String emptyToNull(String s) {
        return TextUtils.isEmpty(s) ? null : s;
    }

    @KeepForSdk
    public static boolean isEmptyOrWhitespace(String s) {
        return s == null || s.trim().isEmpty();
    }
}

