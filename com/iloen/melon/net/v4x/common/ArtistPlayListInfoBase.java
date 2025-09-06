package com.iloen.melon.net.v4x.common;

import S7.b;
import com.melon.net.res.common.DjPlayListInfoBase;

public class ArtistPlayListInfoBase extends DjPlayListInfoBase {
    @b(alternate = {"artistId"}, value = "ARTISTID")
    public String artistId;
    @b("DSPLYORDER")
    public String dsplyorder;
    @b("ISARTIST")
    public String isartist;
    @b("OPENYN")
    public String openyn;
    private static final long serialVersionUID = 0x2844E0B873825265L;

    public ArtistPlayListInfoBase() {
        this.openyn = "Y";
    }

    @Override  // com.melon.net.res.common.DjPlayListInfoBase
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

