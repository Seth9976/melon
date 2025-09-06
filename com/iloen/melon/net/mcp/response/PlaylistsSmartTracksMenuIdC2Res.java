package com.iloen.melon.net.mcp.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.util.ArrayList;

public class PlaylistsSmartTracksMenuIdC2Res extends PlaylistsSmartRes {
    @b("result")
    public ArrayList result;
    private static final long serialVersionUID = 0xC4EAC279DA2A8C5EL;

    public PlaylistsSmartTracksMenuIdC2Res() {
        this.result = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

