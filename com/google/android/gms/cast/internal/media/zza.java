package com.google.android.gms.cast.internal.media;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.images.WebImage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zza {
    private static final Logger zza;
    private static final String[] zzb;
    private static final String zzc;

    static {
        zza.zza = new Logger("MetadataUtils");
        zza.zzb = new String[]{"Z", "+hh", "+hhmm", "+hh:mm"};
        zza.zzc = "yyyyMMdd\'T\'HHmmssZ";
    }

    public static String zza(Calendar calendar0) {
        String s = "yyyyMMdd\'T\'HHmmssZ";
        if(calendar0 == null) {
            zza.zza.d("Calendar object cannot be null", new Object[0]);
            return null;
        }
        if(calendar0.get(11) == 0 && calendar0.get(12) == 0 && calendar0.get(13) == 0) {
            s = "yyyyMMdd";
        }
        SimpleDateFormat simpleDateFormat0 = new SimpleDateFormat(s);
        simpleDateFormat0.setTimeZone(calendar0.getTimeZone());
        String s1 = simpleDateFormat0.format(calendar0.getTime());
        return s1.endsWith("+0000") ? s1.replace("+0000", "Z") : s1;
    }

    public static Calendar zzb(String s) {
        Date date0;
        String s3;
        if(TextUtils.isEmpty(s)) {
            zza.zza.d("Input string is empty or null", new Object[0]);
            return null;
        }
        String s1 = zza.zze(s);
        if(TextUtils.isEmpty(s1)) {
            zza.zza.d("Invalid date format", new Object[0]);
            return null;
        }
        String s2 = zza.zzf(s);
        if(TextUtils.isEmpty(s2)) {
            s3 = "yyyyMMdd";
        }
        else {
            s1 = s1 + "T" + s2;
            s3 = s2.length() == 6 ? "yyyyMMdd\'T\'HHmmss" : "yyyyMMdd\'T\'HHmmssZ";
        }
        Calendar calendar0 = Calendar.getInstance();
        try {
            date0 = new SimpleDateFormat(s3).parse(s1);
        }
        catch(ParseException parseException0) {
            zza.zza.e(parseException0, "Error parsing string", new Object[0]);
            return null;
        }
        calendar0.setTime(date0);
        return calendar0;
    }

    public static JSONArray zzc(List list0) {
        list0.getClass();
        JSONArray jSONArray0 = new JSONArray();
        for(Object object0: list0) {
            jSONArray0.put(((WebImage)object0).toJson());
        }
        return jSONArray0;
    }

    public static void zzd(List list0, JSONArray jSONArray0) {
        try {
            list0.clear();
            for(int v = 0; v < jSONArray0.length(); ++v) {
                JSONObject jSONObject0 = jSONArray0.getJSONObject(v);
                try {
                    list0.add(new WebImage(jSONObject0));
                }
                catch(IllegalArgumentException unused_ex) {
                }
            }
        }
        catch(JSONException unused_ex) {
        }
    }

    private static String zze(String s) {
        if(!TextUtils.isEmpty(s)) {
            try {
                return s.substring(0, 8);
            }
            catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                zza.zza.e(indexOutOfBoundsException0, "Error extracting the date", new Object[0]);
                return null;
            }
        }
        zza.zza.d("Input string is empty or null", new Object[0]);
        return null;
    }

    private static String zzf(String s) {
        if(TextUtils.isEmpty(s)) {
            zza.zza.d("string is empty or null", new Object[0]);
            return null;
        }
        if(s.indexOf(84) != 8) {
            zza.zza.d("T delimeter is not found", new Object[0]);
            return null;
        }
        String s1 = s.substring(9);
        if(s1.length() == 6) {
            return s1;
        }
        switch(s1.charAt(6)) {
            case 43: 
            case 45: {
                int v = s1.length();
                return v == 9 || v == 11 || v == 12 ? s1.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2") : null;
            }
            case 90: {
                return s1.length() == 7 ? s1.substring(0, s1.length() - 1) + "+0000" : null;
            }
            default: {
                return null;
            }
        }
    }
}

