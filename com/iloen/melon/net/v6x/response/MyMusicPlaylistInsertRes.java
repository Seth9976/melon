package com.iloen.melon.net.v6x.response;

import com.iloen.melon.net.v4x.common.ToStringUtil;

public class MyMusicPlaylistInsertRes extends PlaylistInsertBaseRes {
    private static final long serialVersionUID = 0x489ABD08F51507FBL;

    @Override  // com.iloen.melon.net.v6x.response.PlaylistInsertBaseRes
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

