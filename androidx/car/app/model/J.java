package androidx.car.app.model;

import java.time.Duration;
import java.util.Objects;

public abstract class j {
    public static DurationSpan a(Duration duration0) {
        Objects.requireNonNull(duration0);
        return new DurationSpan(duration0.getSeconds());
    }
}

