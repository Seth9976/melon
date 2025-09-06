package androidx.appcompat.app;

import android.os.PowerManager;
import java.util.Locale;

public abstract class t {
    public static boolean a(PowerManager powerManager0) {
        return powerManager0.isPowerSaveMode();
    }

    public static String b(Locale locale0) {
        return locale0.toLanguageTag();
    }
}

