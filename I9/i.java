package i9;

import android.net.Uri;
import android.provider.BaseColumns;

public abstract class i implements BaseColumns {
    public static final Uri a(long v) {
        return Uri.parse(("content://com.iloen.melon.provider.melondcf/external/audio/genres/" + v + "/members"));
    }

    public static final Uri b(long v) {
        return Uri.parse(("content://com.iloen.melon.provider.melondcf/external/audio/playlists/" + v + "/members"));
    }
}

