package com.iloen.melon.net.mcp.response;

import S7.b;
import com.iloen.melon.net.mcp.UpdateInfoBase;

public class PlaylistsSmartEditRes extends PlaylistsSmartRes {
    @b("result")
    public UpdateInfoBase result;
    private static final long serialVersionUID = 0x3FD7FCD761E4C4E8L;

    public PlaylistsSmartEditRes() {
        this.result = null;
    }
}

