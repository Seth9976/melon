package com.iloen.melon.utils.playlist;

import android.net.Uri;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.utils.log.LogU;

public class NormalPlaylistCacheCreator extends PlaylistCacheCreatorBase {
    public static final String TAG = "DjPlaylistCacheCreator";

    @Override  // com.iloen.melon.utils.playlist.PlaylistCacheCreatorBase
    public String getBasicInformCacheKey(String s) {
        return Uri.withAppendedPath(MelonContentUris.J0, "basicInform_PlylstSeq=" + s).toString();
    }

    @Override  // com.iloen.melon.utils.playlist.PlaylistCacheCreatorBase
    public String getUpdateIntrodCacheKey(String s) {
        return Uri.withAppendedPath(MelonContentUris.J0, "updateIntrod_PlylstSeq=" + s).toString();
    }

    @Override  // com.iloen.melon.utils.playlist.PlaylistCacheCreatorBase
    public String getUpdateTitleCacheKey(String s) {
        return Uri.withAppendedPath(MelonContentUris.J0, "updateTitle_PlylstSeq=" + s).toString();
    }

    @Override  // com.iloen.melon.utils.playlist.PlaylistCacheCreatorBase
    public String recommendTagCacheKey() {
        LogU.w("DjPlaylistCacheCreator", "Normal Playlist do not support recommendTagCacheKey().");
        return null;
    }

    @Override  // com.iloen.melon.utils.playlist.PlaylistCacheCreatorBase
    public String songListCacheKey(String s, String s1) {
        return Uri.withAppendedPath(MelonContentUris.J0, "songList_PlylstSeq=" + s + "_StartIndex=" + s1).toString();
    }
}

