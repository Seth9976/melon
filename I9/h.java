package i9;

import android.net.Uri;
import android.provider.BaseColumns;

public abstract class h implements BaseColumns {
    public static final Uri a;

    static {
        Uri.parse("content://com.iloen.melon.provider.melondcf/internal/audio/albums");
        h.a = Uri.parse("content://com.iloen.melon.provider.melondcf/external/audio/albums");
    }
}

