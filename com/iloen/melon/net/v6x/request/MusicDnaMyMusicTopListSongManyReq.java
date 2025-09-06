package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.request.RequestV4Req;
import com.iloen.melon.net.v6x.response.MusicDnaMyMusicTopListSongManyRes;
import e1.u;
import va.e0;
import va.o;

public class MusicDnaMyMusicTopListSongManyReq extends RequestV4Req {
    public MusicDnaMyMusicTopListSongManyReq(Context context0) {
        super(context0, 0, MusicDnaMyMusicTopListSongManyRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.TRUE);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/musicdna/mymusic/top/listSongMany.json";
    }
}

