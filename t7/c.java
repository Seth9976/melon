package t7;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import r7.f;
import r7.g;

public final class c implements f {
    public static final SimpleDateFormat a;

    static {
        SimpleDateFormat simpleDateFormat0 = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'", Locale.US);
        c.a = simpleDateFormat0;
        simpleDateFormat0.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @Override  // r7.a
    public final void a(Object object0, Object object1) {
        ((g)object1).c(c.a.format(((Date)object0)));
    }
}

