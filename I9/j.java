package i9;

import android.net.Uri;
import android.provider.BaseColumns;

public abstract class j implements BaseColumns {
    public static final Uri a;

    static {
        j.a("internal");
        j.a = j.a("external");
    }

    public static Uri a(String s) {
        return Uri.parse(("content://com.iloen.melon.provider.melondcf/" + s + "/audio/genres"));
    }
}

