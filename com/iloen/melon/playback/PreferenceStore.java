package com.iloen.melon.playback;

import android.net.Uri;
import android.provider.BaseColumns;

public class PreferenceStore {
    public static final class PrefColumns implements BaseColumns {
        public static final String KEY = "key";
        public static final String PRIMITIVE_TYPE = "prim_type";
        public static final String VALUE = "value";

    }

    public static final class PrefKey {
        public static final String PLAYED_TIME = "playedtime";
        public static final String PLAYLIST_ID = "playlist_id";
        public static final String POSITION = "position";
        public static final String REPEAT_MODE = "repeatmode";
        public static final String SHUFFLE = "shuffle";
        public static final String SORT = "sort";

    }

    public static final String AUTHORITY = "com.iloen.melon.preference.provider";
    private static final String BASE_PATH = "preferences";
    public static final String CONTENT_TYPE_MELON = "vnd.android.cursor.dir/vnd.com.iloen.melon.preference.provider/preferences_melon";
    public static final String CONTENT_TYPE_PLAYLIST = "vnd.android.cursor.dir/vnd.com.iloen.melon.preference.provider/preferences_playlist";
    public static final Uri CONTENT_URI_MELON = null;
    public static final Uri CONTENT_URI_PLAYLIST = null;
    public static final String MELON_PATH = "preferences_melon";
    public static final String PLAYLIST_PATH = "preferences_playlist";

    static {
        PreferenceStore.CONTENT_URI_MELON = Uri.parse("content://com.iloen.melon.preference.provider/preferences_melon");
        PreferenceStore.CONTENT_URI_PLAYLIST = Uri.parse("content://com.iloen.melon.preference.provider/preferences_playlist");
    }
}

