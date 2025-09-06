package v;

import androidx.car.app.model.CarIconSpan;
import androidx.car.app.model.CarText.SpanWrapper;
import androidx.car.app.model.ClickableSpan;
import androidx.car.app.model.DistanceSpan;
import androidx.car.app.model.DurationSpan;
import androidx.car.app.model.ForegroundCarColorSpan;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public final class c {
    public final HashSet a;
    public static final c b;

    static {
        new c(Collections.EMPTY_LIST);
        new c(Arrays.asList(new Class[]{CarIconSpan.class, ClickableSpan.class, DistanceSpan.class, DurationSpan.class, ForegroundCarColorSpan.class}));
        new c(Arrays.asList(new Class[]{ClickableSpan.class, DistanceSpan.class, DurationSpan.class}));
        new c(Arrays.asList(new Class[]{ForegroundCarColorSpan.class}));
        c.b = new c(Arrays.asList(new Class[]{DistanceSpan.class, DurationSpan.class}));
        new c(Arrays.asList(new Class[]{DistanceSpan.class, DurationSpan.class, CarIconSpan.class}));
        new c(Arrays.asList(new Class[]{DistanceSpan.class, DurationSpan.class, ForegroundCarColorSpan.class}));
        new c(Arrays.asList(new Class[]{DistanceSpan.class, DurationSpan.class, ForegroundCarColorSpan.class, CarIconSpan.class}));
    }

    public c(List list0) {
        this.a = new HashSet(list0);
    }

    public final void a(List list0) {
        for(Object object0: list0) {
            Class class0 = ((SpanWrapper)object0).getCarSpan().getClass();
            if(!this.a.contains(class0)) {
                throw new IllegalArgumentException("CarSpan type is not allowed: " + class0.getSimpleName());
            }
            if(false) {
                break;
            }
        }
    }
}

