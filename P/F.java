package p;

import android.os.LocaleList;

public abstract class f {
    public static String a() {
        LocaleList localeList0 = LocaleList.getAdjustedDefault();
        return localeList0.size() <= 0 ? null : localeList0.get(0).toLanguageTag();
    }
}

