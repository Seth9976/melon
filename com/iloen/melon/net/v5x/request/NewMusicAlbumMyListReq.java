package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.NewAlbumListRes;

public class NewMusicAlbumMyListReq extends RequestV5Req {
    public NewMusicAlbumMyListReq(Context context0) {
        super(context0, 0, NewAlbumListRes.class);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/newmusic/album/myList.json";
    }
}

