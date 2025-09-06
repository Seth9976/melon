package com.iloen.melon.net.v4x.common;

import S7.b;
import java.io.Serializable;

public class KidsThemeInfoBase implements Serializable {
    @b("CONTSCNT")
    public String contsCnt;
    @b("CONTSTYPECODE")
    public String contsTypeCode;
    @b("IMGURL")
    public String imgUrl;
    private static final long serialVersionUID = 0x94808E80B33595A2L;
    @b("THEMESEQ")
    public String themeSeq;
    @b("THEMETYPECODE")
    public String themeTypeCode;
    @b("TITLE")
    public String title;
    @b("TITLE1")
    public String title1;
    @b("TITLE2")
    public String title2;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

