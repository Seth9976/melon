package i9;

import android.net.Uri;
import android.provider.BaseColumns;

public abstract class l implements BaseColumns {
    public static final Uri a;

    static {
        l.a("internal");
        l.a = l.a("external");
    }

    public static Uri a(String s) {
        return Uri.parse(("content://com.iloen.melon.provider.melondcf/" + s + "/audio/playlists"));
    }
}

