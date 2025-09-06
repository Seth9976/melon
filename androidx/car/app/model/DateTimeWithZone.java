package androidx.car.app.model;

import U4.x;
import android.annotation.SuppressLint;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public final class DateTimeWithZone {
    private static final long MAX_ZONE_OFFSET_SECONDS;
    private final long mTimeSinceEpochMillis;
    private final int mZoneOffsetSeconds;
    private final String mZoneShortName;

    static {
        DateTimeWithZone.MAX_ZONE_OFFSET_SECONDS = TimeUnit.HOURS.toSeconds(1L) * 18L;
    }

    private DateTimeWithZone() {
        this.mTimeSinceEpochMillis = 0L;
        this.mZoneOffsetSeconds = 0;
        this.mZoneShortName = null;
    }

    private DateTimeWithZone(long v, int v1, String s) {
        this.mTimeSinceEpochMillis = v;
        this.mZoneOffsetSeconds = v1;
        this.mZoneShortName = s;
    }

    public static DateTimeWithZone create(long v, int v1, String s) {
        if(v < 0L) {
            throw new IllegalArgumentException("Time since epoch must be greater than or equal to zero");
        }
        if(((long)Math.abs(v1)) > DateTimeWithZone.MAX_ZONE_OFFSET_SECONDS) {
            throw new IllegalArgumentException("Zone offset not in valid range: -18:00 to +18:00");
        }
        Objects.requireNonNull(s);
        if(s.isEmpty()) {
            throw new IllegalArgumentException("The time zone short name can not be null or empty");
        }
        return new DateTimeWithZone(v, v1, s);
    }

    public static DateTimeWithZone create(long v, TimeZone timeZone0) {
        if(v < 0L) {
            throw new IllegalArgumentException("timeSinceEpochMillis must be greater than or equal to zero");
        }
        TimeUnit timeUnit0 = TimeUnit.MILLISECONDS;
        Objects.requireNonNull(timeZone0);
        return DateTimeWithZone.create(v, ((int)timeUnit0.toSeconds(((long)timeZone0.getOffset(v)))), timeZone0.getDisplayName(false, 0));
    }

    public static DateTimeWithZone create(ZonedDateTime zonedDateTime0) {
        return i.a(zonedDateTime0);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof DateTimeWithZone ? this.mTimeSinceEpochMillis == ((DateTimeWithZone)object0).mTimeSinceEpochMillis && this.mZoneOffsetSeconds == ((DateTimeWithZone)object0).mZoneOffsetSeconds && Objects.equals(this.mZoneShortName, ((DateTimeWithZone)object0).mZoneShortName) : false;
    }

    public long getTimeSinceEpochMillis() {
        return this.mTimeSinceEpochMillis;
    }

    @SuppressLint({"MethodNameUnits"})
    public int getZoneOffsetSeconds() {
        return this.mZoneOffsetSeconds;
    }

    public String getZoneShortName() {
        return this.mZoneShortName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mTimeSinceEpochMillis, this.mZoneOffsetSeconds, this.mZoneShortName});
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("[time since epoch (ms): ");
        stringBuilder0.append(this.mTimeSinceEpochMillis);
        stringBuilder0.append("( ");
        stringBuilder0.append(new Date(this.mTimeSinceEpochMillis));
        stringBuilder0.append(")  zone offset (s): ");
        stringBuilder0.append(this.mZoneOffsetSeconds);
        stringBuilder0.append(", zone: ");
        return x.m(stringBuilder0, this.mZoneShortName, "]");
    }
}

