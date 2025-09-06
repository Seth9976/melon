package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MusicMessageInsertMusicMsgRes;

public class MusicMessageInsertMusicMsgReq extends MusicMessageInsertMusicMsgBaseReq {
    public MusicMessageInsertMusicMsgReq(Context context0, Params musicMessageInsertMusicMsgBaseReq$Params0) {
        super(context0, 1, MusicMessageInsertMusicMsgRes.class);
        this.addMemberKey();
        this.addParams(musicMessageInsertMusicMsgBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/message/insertMusicMsg.json";
    }
}

