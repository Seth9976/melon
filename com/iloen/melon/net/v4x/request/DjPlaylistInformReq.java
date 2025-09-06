package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.DjPlaylistInformRes;

public class DjPlaylistInformReq extends PlaylistInformBaseReq {
    public static final String MODE_INFORM = "INFORM";

    public DjPlaylistInformReq(Context context0, Params playlistInformBaseReq$Params0) {
        super(context0, DjPlaylistInformRes.class);
        this.addMemberKeyAlwaysDeliver();
        this.addParams(playlistInformBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.v4x.request.PlaylistInformBaseReq
    public String getApiPath() {
        return "/dj/playlist/inform.json";
    }
}

