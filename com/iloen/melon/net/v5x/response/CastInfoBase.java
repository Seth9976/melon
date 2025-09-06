package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.io.Serializable;

public class CastInfoBase implements Serializable {
    public static class Creator extends CreatorInfoBase {
        private static final long serialVersionUID = 0x4DDBCF59141F3117L;

    }

    @b("CASTDATE")
    public String castDate;
    @b("CASTDESC")
    public String castDesc;
    @b("CASTIMGURL")
    public String castImgUrl;
    @b("CASTSEQ")
    public String castSeq;
    @b("CASTTITLE")
    public String castTitle;
    @b("CREATOR")
    public Creator creator;
    @b("LIKECNT")
    public String likeCnt;
    private static final long serialVersionUID = 0x4DDBCF58CD313B97L;
    @b("VERTICALIMGURL")
    public String verticalImgUrl;

    public CastInfoBase() {
        this.castSeq = "";
        this.castTitle = "";
        this.castDesc = "";
        this.castImgUrl = "";
        this.verticalImgUrl = "";
        this.castDate = "";
        this.likeCnt = "";
        this.creator = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

