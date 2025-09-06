package com.iloen.melon.net.mcp.request;

import U4.x;
import android.content.Context;
import com.iloen.melon.net.mcp.response.PlaylistsSmartTracksMenuIdC2Res;

public class PlaylistsSmartTracksMenuIdC2Req extends PlaylistsSmartBaseReq {
    private String smartMemberKey;

    public PlaylistsSmartTracksMenuIdC2Req(Context context0, String s) {
        super(context0, 0, PlaylistsSmartTracksMenuIdC2Res.class);
        this.smartMemberKey = s;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return x.m(new StringBuilder("/playlists/smart/"), this.smartMemberKey, "/tracks/menu-id-c2");
    }
}

