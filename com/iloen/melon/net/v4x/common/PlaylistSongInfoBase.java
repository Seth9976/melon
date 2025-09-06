package com.iloen.melon.net.v4x.common;

import S7.b;
import com.melon.net.res.common.MetaInfoBase;
import com.melon.net.res.common.SongInfoBase;

public class PlaylistSongInfoBase extends SongInfoBase {
    @b("CONTSTYPECODE")
    public String contsTypeCode;
    @b("DSPLYORDER")
    public String dsplyOrder;
    @b("RECMYN")
    public String recmYn;
    private static final long serialVersionUID = 0xC09A09F0C1602C4BL;

    public PlaylistSongInfoBase() {
        this.dsplyOrder = "";
        this.recmYn = "";
        this.contsTypeCode = "";
    }

    public static boolean copyValueOf(MetaInfoBase metaInfoBase0, MetaInfoBase metaInfoBase1) {
        if(metaInfoBase0 != null && metaInfoBase0 instanceof PlaylistSongInfoBase && metaInfoBase1 != null && metaInfoBase1 instanceof PlaylistSongInfoBase) {
            ((PlaylistSongInfoBase)metaInfoBase1).dsplyOrder = ((PlaylistSongInfoBase)metaInfoBase0).dsplyOrder;
            ((PlaylistSongInfoBase)metaInfoBase1).recmYn = ((PlaylistSongInfoBase)metaInfoBase0).recmYn;
            ((PlaylistSongInfoBase)metaInfoBase1).contsTypeCode = ((PlaylistSongInfoBase)metaInfoBase0).contsTypeCode;
            return true;
        }
        return false;
    }

    @Override  // com.melon.net.res.common.SongInfoBase
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

