package com.iloen.melon.utils.playlist;

import b3.Z;
import com.iloen.melon.constants.MelonContentUris;

public class DjPlaylistCacheCreator extends PlaylistCacheCreatorBase {
    public static final String TAG = "DjPlaylistCacheCreator";

    @Override  // com.iloen.melon.utils.playlist.PlaylistCacheCreatorBase
    public String getBasicInformCacheKey(String s) {
        String s1 = MelonContentUris.O0.buildUpon().appendPath("basicInform").appendPath(s).build().toString();
        Z.w("getBasicInformCacheKey() >> cacheKey: ", s1, "DjPlaylistCacheCreator");
        return s1;
    }

    @Override  // com.iloen.melon.utils.playlist.PlaylistCacheCreatorBase
    public String getUpdateIntrodCacheKey(String s) {
        String s1 = MelonContentUris.O0.buildUpon().appendPath("updateIntrod").appendPath(s).build().toString();
        Z.w("getUpdateIntrodCacheKey() >> cacheKey: ", s1, "DjPlaylistCacheCreator");
        return s1;
    }

    @Override  // com.iloen.melon.utils.playlist.PlaylistCacheCreatorBase
    public String getUpdateTitleCacheKey(String s) {
        String s1 = MelonContentUris.O0.buildUpon().appendPath("updateTitle").appendPath(s).build().toString();
        Z.w("getUpdateTitleCacheKey() >> cacheKey: ", s1, "DjPlaylistCacheCreator");
        return s1;
    }

    @Override  // com.iloen.melon.utils.playlist.PlaylistCacheCreatorBase
    public String recommendTagCacheKey() {
        String s = MelonContentUris.J0.buildUpon().appendPath("songList").build().toString();
        Z.w("recommendTagCacheKey() >> cacheKey: ", s, "DjPlaylistCacheCreator");
        return s;
    }

    @Override  // com.iloen.melon.utils.playlist.PlaylistCacheCreatorBase
    public String songListCacheKey(String s, String s1) {
        String s2 = MelonContentUris.O0.buildUpon().appendPath("songList").appendPath(s).appendQueryParameter("startIndex", s1).build().toString();
        Z.w("songListCacheKey() >> cacheKey: ", s2, "DjPlaylistCacheCreator");
        return s2;
    }
}

