package com.iloen.melon.utils.time;

import android.util.Log;
import d5.n;
import ie.o;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import va.e;
import we.a;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001J\u001D\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\n\u0010\u000BJ\u0015\u0010\f\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\f\u0010\u000BJ-\u0010\u0011\u001A\u00020\u00022\u0006\u0010\r\u001A\u00020\b2\b\b\u0002\u0010\u000E\u001A\u00020\b2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00020\u000F¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001A\u00020\u00022\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/utils/time/TimeUtils;", "", "", "start", "end", "", "isBetween", "(Ljava/lang/String;Ljava/lang/String;)Z", "", "timeInMillis", "isTimeInMillisInToday", "(J)Z", "isTimeInMillisInWeek", "endTime", "curTime", "Lkotlin/Function0;", "default", "getRemainedTimeTextOrDefault", "(JJLwe/a;)Ljava/lang/String;", "timestamp", "timestamp2Long", "(Ljava/lang/String;)J", "long2Timestamp", "(J)Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TimeUtils {
    public static final int $stable;
    @NotNull
    public static final TimeUtils INSTANCE;

    static {
        TimeUtils.INSTANCE = new TimeUtils();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @NotNull
    public final String getRemainedTimeTextOrDefault(long v, long v1, @NotNull a a0) {
        q.g(a0, "default");
        if(v <= v1) {
            return (String)a0.invoke();
        }
        long v2 = v - v1;
        long v3 = v2 / Duration.ofDays(1L).toMillis();
        SimpleDateFormat simpleDateFormat0 = v3 <= 0L ? new SimpleDateFormat("HH:mm:ss") : new SimpleDateFormat(v3 + "일 HH:mm:ss");
        simpleDateFormat0.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        String s = simpleDateFormat0.format(v2);
        q.f(s, "format(...)");
        return s;
    }

    public static String getRemainedTimeTextOrDefault$default(TimeUtils timeUtils0, long v, long v1, a a0, int v2, Object object0) {
        if((v2 & 2) != 0) {
            v1 = System.currentTimeMillis();
        }
        return timeUtils0.getRemainedTimeTextOrDefault(v, v1, a0);
    }

    public final boolean isBetween(@NotNull String s, @NotNull String s1) {
        q.g(s, "start");
        q.g(s1, "end");
        String s2 = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(System.currentTimeMillis());
        q.d(s2);
        return s2.compareTo(s) >= 0 && s2.compareTo(s1) <= 0;
    }

    public final boolean isTimeInMillisInToday(long v) {
        Calendar calendar0 = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTimeInMillis(v);
        Log.d("TimeUtils", "now date : " + calendar0.get(5));
        Log.d("TimeUtils", "target date : " + calendar1.get(5));
        return calendar0.get(5) == calendar1.get(5);
    }

    public final boolean isTimeInMillisInWeek(long v) {
        Date date0 = new Date(v);
        Calendar calendar0 = Calendar.getInstance();
        int v1 = calendar0.get(3);
        int v2 = calendar0.get(1);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date0);
        int v3 = calendar1.get(3);
        int v4 = calendar0.get(1);
        Log.d("TimeUtils", "week : " + v1);
        Log.d("TimeUtils", "year : " + v2);
        Log.d("TimeUtils", "targetWeek : " + v3);
        e.f(v4, "targetYear : ", "TimeUtils");
        return v1 == v3 && v2 == v4;
    }

    @NotNull
    public final String long2Timestamp(long v) {
        String s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(v));
        q.d(s);
        return s;
    }

    public final long timestamp2Long(@NotNull String s) {
        Long long0;
        q.g(s, "timestamp");
        SimpleDateFormat simpleDateFormat0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        try {
            Date date0 = simpleDateFormat0.parse(s);
            long0 = (long)(date0 == null ? 0L : date0.getTime());
            return long0 instanceof o ? 0L : long0.longValue();
        }
        catch(Throwable throwable0) {
        }
        long0 = n.t(throwable0);
        return long0 instanceof o ? 0L : long0.longValue();
    }
}

