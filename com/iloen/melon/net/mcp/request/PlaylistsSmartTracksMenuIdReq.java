package com.iloen.melon.net.mcp.request;

import android.content.Context;
import com.google.gson.n;
import com.iloen.melon.net.mcp.response.PlaylistsSmartRes;

public class PlaylistsSmartTracksMenuIdReq extends PlaylistsSmartBaseReq {
    static class Data {
        String memberKey;
        String trackId;

        public Data(String s, String s1) {
            this.memberKey = s;
            this.trackId = s1;
        }
    }

    public PlaylistsSmartTracksMenuIdReq(Context context0, String s, String s1) {
        super(context0, 2, PlaylistsSmartRes.class);
        Data playlistsSmartTracksMenuIdReq$Data0 = new Data(s, s1);
        this.setJsonString(new n().k(playlistsSmartTracksMenuIdReq$Data0));
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/playlists/smart/tracks/menu-id";
    }
}

