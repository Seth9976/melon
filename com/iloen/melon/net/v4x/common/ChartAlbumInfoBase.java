package com.iloen.melon.net.v4x.common;

import S7.b;
import com.melon.net.res.common.AlbumInfoBase;

public class ChartAlbumInfoBase extends AlbumInfoBase {
    @b("CURRANK")
    public String currentRank;
    @b("PASTRANK")
    public String pastRank;
    @b("RANKGAP")
    public String rankGap;
    @b("RANKTYPE")
    public String rankType;
    private static final long serialVersionUID = 0x3330A939C111F23CL;

    @Override  // com.melon.net.res.common.AlbumInfoBase
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

