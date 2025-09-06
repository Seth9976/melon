package com.iloen.melon.net.mcp.response;

import S7.b;
import com.iloen.melon.net.mcp.PlaylistSmartError;
import com.iloen.melon.net.v6x.response.ResponseV6Res;

public class PlaylistsSmartRes extends ResponseV6Res {
    @b("error")
    public PlaylistSmartError error;
    private static final long serialVersionUID = -889630569133190802L;
    @b("success")
    public boolean success;

    public PlaylistsSmartRes() {
        this.success = false;
        this.error = null;
    }
}

