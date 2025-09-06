package com.iloen.melon.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils {
    public static final String TAG = "DateUtils";

    public static String convertDateFormat(long v) {
        return new SimpleDateFormat("yyyy년 MM월 dd일 kk:mm:ss", Locale.KOREA).format(v);
    }

    public static String convertDateFormat(long v, String s) {
        return new SimpleDateFormat(s, Locale.KOREA).format(v);
    }

    public static String convertLongToString(long v, String s) {
        SimpleDateFormat simpleDateFormat0 = new SimpleDateFormat(s);
        simpleDateFormat0.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat0.format(v);
    }

    public static long convertString2Long(String s) {
        if(TextUtils.isEmpty(s)) {
            return 0L;
        }
        Date date0 = new SimpleDateFormat("yyyyMMddHHmmss").parse(s, new ParsePosition(0));
        return date0 == null ? 0L : date0.getTime();
    }

    public static String getCurrentDateFromYyyymmdd() [...] // 潜在的解密器

    public static String getCurrentTimeyyyyMMddhhmmss() [...] // 潜在的解密器

    public static String getDayOfWeek(Context context0, long v) {
        if(context0 != null && v >= 0L) {
            String[] arr_s = context0.getResources().getStringArray(0x7F03000C);  // array:day_of_week
            Calendar calendar0 = Calendar.getInstance();
            calendar0.setTimeInMillis(v);
            return arr_s[calendar0.get(7) - 1];
        }
        return "";
    }

    @SuppressLint({"DefaultLocale"})
    public static String getZonedTimeHhmm(String s) {
        try {
            ZonedDateTime zonedDateTime0 = ZonedDateTime.parse(s);
            return String.format("%02d:%02d", zonedDateTime0.getHour(), zonedDateTime0.getMinute());
        }
        catch(DateTimeParseException unused_ex) {
            return "";
        }
    }
}

