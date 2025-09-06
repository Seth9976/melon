package androidx.car.app.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public abstract class i {
    public static DateTimeWithZone a(ZonedDateTime zonedDateTime0) {
        Objects.requireNonNull(zonedDateTime0);
        LocalDateTime localDateTime0 = zonedDateTime0.toLocalDateTime();
        ZoneId zoneId0 = zonedDateTime0.getZone();
        ZoneOffset zoneOffset0 = zoneId0.getRules().getOffset(localDateTime0);
        return DateTimeWithZone.create(TimeUnit.SECONDS.toMillis(localDateTime0.toEpochSecond(zoneOffset0)), zoneOffset0.getTotalSeconds(), zoneId0.getDisplayName(TextStyle.SHORT, Locale.getDefault()));
    }
}

