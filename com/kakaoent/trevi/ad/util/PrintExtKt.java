package com.kakaoent.trevi.ad.util;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0010\u000E\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u0015\u0010\u0002\u001A\u00020\u0001*\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001A\u001B\u0010\u0006\u001A\u0004\u0018\u00010\u00052\b\u0010\u0004\u001A\u0004\u0018\u00010\u0000H\u0003¢\u0006\u0004\b\u0006\u0010\u0007\"\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n\"\u0014\u0010\f\u001A\u00020\u000B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r\"\u0014\u0010\u000E\u001A\u00020\u000B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000E\u0010\r¨\u0006\u000F"}, d2 = {"", "", "toMilliseconds", "(Ljava/lang/String;)J", "date", "Ljava/time/ZonedDateTime;", "getDateFromServerString26", "(Ljava/lang/String;)Ljava/time/ZonedDateTime;", "Ljava/util/TimeZone;", "timeZoneUTC", "Ljava/util/TimeZone;", "Ljava/text/SimpleDateFormat;", "serverDateFormat", "Ljava/text/SimpleDateFormat;", "cashFriendsServerDateFormat", "trevi-ad-android-sdk_release"}, k = 2, mv = {1, 9, 0}, xi = 0x30)
public abstract class PrintExtKt {
    @NotNull
    private static final SimpleDateFormat cashFriendsServerDateFormat;
    @NotNull
    private static final SimpleDateFormat serverDateFormat;
    @NotNull
    private static final TimeZone timeZoneUTC;

    static {
        TimeZone timeZone0 = TimeZone.getTimeZone("GMT+00:00");
        q.f(timeZone0, "getTimeZone(...)");
        PrintExtKt.timeZoneUTC = timeZone0;
        Locale locale0 = Locale.US;
        SimpleDateFormat simpleDateFormat0 = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss\'Z\'", locale0);
        simpleDateFormat0.setTimeZone(timeZone0);
        PrintExtKt.serverDateFormat = simpleDateFormat0;
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'", locale0);
        simpleDateFormat1.setTimeZone(timeZone0);
        PrintExtKt.cashFriendsServerDateFormat = simpleDateFormat1;
    }

    private static final ZonedDateTime getDateFromServerString26(String s) {
        return s == null ? null : ZonedDateTime.parse(s).withZoneSameInstant(ZoneId.of("Asia/Seoul"));
    }

    public static final long toMilliseconds(@Nullable String s) {
        if(s == null) {
            return 0L;
        }
        ZonedDateTime zonedDateTime0 = PrintExtKt.getDateFromServerString26(s);
        if(zonedDateTime0 == null) {
            return 0L;
        }
        long v = zonedDateTime0.getLong(ChronoField.INSTANT_SECONDS);
        return zonedDateTime0.getLong(ChronoField.MILLI_OF_SECOND) + v * 1000L;
    }
}

