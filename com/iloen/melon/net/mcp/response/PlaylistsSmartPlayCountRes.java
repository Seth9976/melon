package com.iloen.melon.net.mcp.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.util.Map;

public class PlaylistsSmartPlayCountRes extends PlaylistsSmartRes {
    @b("result")
    public Map result;
    private static final long serialVersionUID = 0x2A4C2AECA6309F19L;

    public PlaylistsSmartPlayCountRes() {
        this.result = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

