package com.iloen.melon.utils.playlist;

public abstract class PlaylistCacheCreatorBase {
    protected static final String CACHE_KEY_SUB_BASIC_INFORM = "basicInform";
    protected static final String CACHE_KEY_SUB_RECOMMEND_TAG = "recommendList";
    protected static final String CACHE_KEY_SUB_SONG_LIST = "songList";
    protected static final String CACHE_KEY_SUB_UPDATE_INTROD = "updateIntrod";
    protected static final String CACHE_KEY_SUB_UPDATE_TITLE = "updateTitle";

    public abstract String getBasicInformCacheKey(String arg1);

    public abstract String getUpdateIntrodCacheKey(String arg1);

    public abstract String getUpdateTitleCacheKey(String arg1);

    public abstract String recommendTagCacheKey();

    public abstract String songListCacheKey(String arg1, String arg2);
}

