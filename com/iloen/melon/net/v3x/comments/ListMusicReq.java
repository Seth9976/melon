package com.iloen.melon.net.v3x.comments;

import android.content.Context;

public class ListMusicReq extends CmtBaseReq {
    public static class MusicType {
        public static String ALBUM = "album";
        public static String ARTIST = "artist";
        public static String SONG = "song";
        public static String VIDEO = "video";

    }

    public static class Params implements com.iloen.melon.net.v3x.comments.CmtBaseReq.Params {
        public String musicType;
        public int pageGroupSize;
        public int pageNo;
        public int pageSize;
        public int sortType;
        public String srchWord;

        public Params() {
            this.srchWord = "";
            this.pageNo = -1;
            this.pageSize = -1;
            this.sortType = -1;
            this.musicType = "";
            this.pageGroupSize = -1;
        }
    }

    public static class SortType {
        public static int ACCURACY = 0;
        public static int ALPHABETICAL = 3;
        public static int POPULARITY = 1;
        public static int RECENTLY = 2;

    }

    public ListMusicReq(Context context0, Params listMusicReq$Params0) {
        super(context0, 1, ListMusicRes.class, listMusicReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cmt/api/api_listMusic.json";
    }
}

