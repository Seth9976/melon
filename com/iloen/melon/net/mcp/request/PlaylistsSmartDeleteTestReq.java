package com.iloen.melon.net.mcp.request;

import android.content.Context;
import com.iloen.melon.net.mcp.response.PlaylistsSmartRes;
import e1.u;
import va.e0;
import va.o;

public class PlaylistsSmartDeleteTestReq extends PlaylistsSmartBaseReq {
    public PlaylistsSmartDeleteTestReq(Context context0) {
        super(context0, 3, PlaylistsSmartRes.class);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/playlists/smart/" + u.v(((e0)o.a()).j());
    }
}

