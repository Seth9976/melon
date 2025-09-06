package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.io.Serializable;
import java.util.List;

public class ProgramBase implements Serializable {
    public static class Cast extends CastInfoBase {
        private static final long serialVersionUID = 0x6AD037248033CD8L;

    }

    public static class Creator extends CreatorInfoBase {
        private static final long serialVersionUID = 0x42C222A059CD1F58L;

    }

    @b("CASTLIST")
    public List castList;
    @b("CREATOR")
    public Creator creator;
    @b("PROGDESC")
    public String progDesc;
    @b("PROGIMGURL")
    public String progImgUrl;
    @b("PROGSEQ")
    public String progSeq;
    @b("PROGTITLE")
    public String progTitle;
    @b("REGDATE")
    public String regDate;
    private static final long serialVersionUID = 0x42C222A059F3BA28L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

