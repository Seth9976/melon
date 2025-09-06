package com.iloen.melon.net.mcp.response;

import S7.b;
import com.iloen.melon.net.mcp.UpdateInfoBase;

public class PlaylistsSmartUpdatedInfoRes extends PlaylistsSmartRes {
    @b("result")
    public UpdateInfoBase result;
    private static final long serialVersionUID = 0xD67C7FBD10240DBEL;

    public PlaylistsSmartUpdatedInfoRes() {
        this.result = null;
    }
}

