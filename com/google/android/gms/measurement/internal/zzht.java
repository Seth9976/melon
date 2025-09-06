package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources;
import com.google.android.gms.common.R.string;

public final class zzht {
    public static String zza(Context context0) {
        try {
            return context0.getResources().getResourcePackageName(string.common_google_play_services_unknown_issue);
        }
        catch(Resources.NotFoundException unused_ex) {
            return "com.iloen.melon";
        }
    }

    public static final String zzb(String s, Resources resources0, String s1) {
        int v = resources0.getIdentifier("google_app_id", "string", s1);
        if(v == 0) {
            return null;
        }
        try {
            return resources0.getString(v);
        }
        catch(Resources.NotFoundException unused_ex) {
            return null;
        }
    }

    public static final Boolean zzc(String s, Resources resources0, String s1) {
        int v = resources0.getIdentifier("google_analytics_force_disable_updates", "bool", s1);
        if(v == 0) {
            return null;
        }
        try {
            return Boolean.valueOf(resources0.getBoolean(v));
        }
        catch(Resources.NotFoundException unused_ex) {
            return null;
        }
    }
}

