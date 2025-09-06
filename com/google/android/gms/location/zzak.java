package com.google.android.gms.location;

import V1.a;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.internal.location.zzeo;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class zzak {
    public static final int zza;
    private static final DecimalFormat zzb;
    private static final DecimalFormat zzc;
    private static final StringBuilder zzd;

    static {
        Locale locale0 = Locale.ROOT;
        zzak.zzb = new DecimalFormat(".000000", DecimalFormatSymbols.getInstance(locale0));
        DecimalFormat decimalFormat0 = new DecimalFormat(".##", DecimalFormatSymbols.getInstance(locale0));
        zzak.zzc = decimalFormat0;
        decimalFormat0.setRoundingMode(RoundingMode.DOWN);
        zzak.zzd = new StringBuilder();
    }

    public static StringBuilder zza(Location location0, StringBuilder stringBuilder0) {
        stringBuilder0.ensureCapacity(100);
        String s = null;
        if(location0 == null) {
            stringBuilder0.append(null);
            return stringBuilder0;
        }
        stringBuilder0.append("{");
        stringBuilder0.append(location0.getProvider());
        stringBuilder0.append(", ");
        if((Build.VERSION.SDK_INT < 0x1F ? location0.isFromMockProvider() : a.b(location0))) {
            stringBuilder0.append("mock, ");
        }
        double f = location0.getLatitude();
        stringBuilder0.append(zzak.zzb.format(f));
        stringBuilder0.append(",");
        double f1 = location0.getLongitude();
        stringBuilder0.append(zzak.zzb.format(f1));
        if(location0.hasAccuracy()) {
            stringBuilder0.append("±");
            double f2 = (double)location0.getAccuracy();
            stringBuilder0.append(zzak.zzc.format(f2));
            stringBuilder0.append("m");
        }
        if(location0.hasAltitude()) {
            stringBuilder0.append(", alt=");
            DecimalFormat decimalFormat0 = zzak.zzc;
            stringBuilder0.append(decimalFormat0.format(location0.getAltitude()));
            if(location0.hasVerticalAccuracy()) {
                stringBuilder0.append("±");
                stringBuilder0.append(decimalFormat0.format(((double)location0.getVerticalAccuracyMeters())));
            }
            stringBuilder0.append("m");
        }
        if(location0.hasSpeed()) {
            stringBuilder0.append(", spd=");
            DecimalFormat decimalFormat1 = zzak.zzc;
            stringBuilder0.append(decimalFormat1.format(((double)location0.getSpeed())));
            if(location0.hasSpeedAccuracy()) {
                stringBuilder0.append("±");
                stringBuilder0.append(decimalFormat1.format(((double)location0.getSpeedAccuracyMetersPerSecond())));
            }
            stringBuilder0.append("m/s");
        }
        if(location0.hasBearing()) {
            stringBuilder0.append(", brg=");
            DecimalFormat decimalFormat2 = zzak.zzc;
            stringBuilder0.append(decimalFormat2.format(((double)location0.getBearing())));
            if(location0.hasBearingAccuracy()) {
                stringBuilder0.append("±");
                stringBuilder0.append(decimalFormat2.format(((double)location0.getBearingAccuracyDegrees())));
            }
            stringBuilder0.append("°");
        }
        Bundle bundle0 = location0.getExtras();
        String s1 = bundle0 == null ? null : bundle0.getString("floorLabel");
        if(s1 != null) {
            stringBuilder0.append(", fl=");
            stringBuilder0.append(s1);
        }
        Bundle bundle1 = location0.getExtras();
        if(bundle1 != null) {
            s = bundle1.getString("levelId");
        }
        if(s != null) {
            stringBuilder0.append(", lv=");
            stringBuilder0.append(s);
        }
        long v = SystemClock.elapsedRealtime();
        stringBuilder0.append(", ert=");
        stringBuilder0.append(zzeo.zza(TimeUnit.NANOSECONDS.toMillis(location0.getElapsedRealtimeNanos()) + (System.currentTimeMillis() - v)));
        stringBuilder0.append('}');
        return stringBuilder0;
    }
}

