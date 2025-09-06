package i9;

import android.net.Uri;
import android.provider.BaseColumns;

public abstract class k implements BaseColumns {
    public static final Uri a;

    static {
        k.a("internal");
        k.a = k.a("external");
    }

    public static Uri a(String s) {
        return Uri.parse(("content://com.iloen.melon.provider.melondcf/" + s + "/audio/media"));
    }
}

