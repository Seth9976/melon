package com.iloen.melon.net.mcp.request;

import android.content.Context;
import com.iloen.melon.net.mcp.response.PlaylistsSmartPlayCountRes;
import e1.u;
import va.e0;
import va.o;

public class PlaylistsSmartPlayCountReq extends PlaylistsSmartBaseReq {
    public PlaylistsSmartPlayCountReq(Context context0) {
        super(context0, 0, PlaylistsSmartPlayCountRes.class);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/playlists/smart/" + u.v(((e0)o.a()).j()) + "/play-count";
    }
}

