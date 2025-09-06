package androidx.appcompat.app;

import android.app.LocaleManager;
import android.os.LocaleList;

public abstract class l {
    public static LocaleList a(Object object0) {
        return ((LocaleManager)object0).getApplicationLocales();
    }

    public static void b(Object object0, LocaleList localeList0) {
        ((LocaleManager)object0).setApplicationLocales(localeList0);
    }
}

