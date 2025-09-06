package com.iloen.melon.net.v6x.common;

import S7.b;
import com.melon.net.res.common.DjPlayListInfoBase;

public class DjPlayListRankingInfo extends DjPlayListInfoBase {
    @b("CURRANK")
    public String currentRank;
    @b("PASTRANK")
    public String pastRank;
    @b("RANKGAP")
    public String rankGap;
    @b("RANKTYPE")
    public String rankType;
    private static final long serialVersionUID = -6638629525689300629L;

}

