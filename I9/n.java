package i9;

import android.net.Uri;

public abstract class n {
    public static final Uri a;
    public static final Uri b;

    static {
        Uri uri0 = Uri.parse("content://com.iloen.melon.provider.melondcf");
        n.a = uri0;
        n.b = Uri.withAppendedPath(uri0, "/external/audio/albumart");
    }
}

