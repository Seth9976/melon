package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.HttpResponse;

public class UpdateNowPlayingReq extends RequestV4Req {
    public static class ParamInfo {
        public String artistId;
        public String introCont;
        public String memberKey;
        public String nowPlaySeq;
        public String selLyricsFirst;
        public String selLyricsSecond;
        public String songId;
        public String songIdModYn;

    }

    public UpdateNowPlayingReq(Context context0, ParamInfo updateNowPlayingReq$ParamInfo0) {
        super(context0, 1, HttpResponse.class);
        this.addMemberKey(updateNowPlayingReq$ParamInfo0.memberKey);
        this.addParam("artistId", updateNowPlayingReq$ParamInfo0.artistId);
        this.addParam("nowPlaySeq", updateNowPlayingReq$ParamInfo0.nowPlaySeq);
        this.addParam("songId", updateNowPlayingReq$ParamInfo0.songId);
        this.addParam("songIdModYn", updateNowPlayingReq$ParamInfo0.songIdModYn);
        this.addParam("introCont", updateNowPlayingReq$ParamInfo0.introCont);
        this.addParam("selLyricsFirst", updateNowPlayingReq$ParamInfo0.selLyricsFirst);
        this.addParam("selLyricsSecond", updateNowPlayingReq$ParamInfo0.selLyricsSecond);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/nowplaying/nowplaying/updateNowPlaying.json";
    }
}

