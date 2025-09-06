package com.iloen.melon.net.v4x.common;

import S7.b;
import com.melon.net.res.common.MetaInfoBase;
import com.melon.net.res.common.SongInfoBase;

public class RecmdSongInfoBase extends SongInfoBase {
    @b("RECMDCODE")
    public String recmCode;
    @b("RECMDMSG")
    public String recmMsg;
    private static final long serialVersionUID = 0x94808E80B33595A2L;

    public static boolean copyValueOf(MetaInfoBase metaInfoBase0, MetaInfoBase metaInfoBase1) {
        if(metaInfoBase0 != null && metaInfoBase0 instanceof RecmdSongInfoBase && metaInfoBase1 != null && metaInfoBase1 instanceof RecmdSongInfoBase) {
            ((RecmdSongInfoBase)metaInfoBase1).recmCode = ((RecmdSongInfoBase)metaInfoBase0).recmCode;
            ((RecmdSongInfoBase)metaInfoBase1).recmMsg = ((RecmdSongInfoBase)metaInfoBase0).recmMsg;
            return true;
        }
        return false;
    }

    @Override  // com.melon.net.res.common.SongInfoBase
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

