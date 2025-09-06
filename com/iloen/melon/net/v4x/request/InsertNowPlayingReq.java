package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.HttpResponse;

public class InsertNowPlayingReq extends RequestV4Req {
    public static class ParamInfo {
        public String artistId;
        public String introCont;
        public String memberKey;
        public String selLyricsFirst;
        public String selLyricsSecond;
        public String songId;

    }

    public InsertNowPlayingReq(Context context0, ParamInfo insertNowPlayingReq$ParamInfo0) {
        super(context0, 1, HttpResponse.class);
        this.addMemberKey(insertNowPlayingReq$ParamInfo0.memberKey);
        this.addParam("artistId", insertNowPlayingReq$ParamInfo0.artistId);
        this.addParam("songId", insertNowPlayingReq$ParamInfo0.songId);
        this.addParam("introCont", insertNowPlayingReq$ParamInfo0.introCont);
        this.addParam("selLyricsFirst", insertNowPlayingReq$ParamInfo0.selLyricsFirst);
        this.addParam("selLyricsSecond", insertNowPlayingReq$ParamInfo0.selLyricsSecond);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/nowplaying/nowplaying/insertNowPlaying.json";
    }
}

