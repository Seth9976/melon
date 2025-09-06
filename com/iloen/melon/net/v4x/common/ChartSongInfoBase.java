package com.iloen.melon.net.v4x.common;

import S7.b;
import com.melon.net.res.common.SongInfoBase;

public class ChartSongInfoBase extends SongInfoBase {
    @b("CURRANK")
    public String currentRank;
    @b("PASTRANK")
    public String pastRank;
    @b("RANKGAP")
    public String rankGap;
    @b("RANKTYPE")
    public String rankType;
    private static final long serialVersionUID = 0x3330A939C111F23CL;

    @Override  // com.melon.net.res.common.SongInfoBase
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

