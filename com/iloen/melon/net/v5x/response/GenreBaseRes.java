package com.iloen.melon.net.v5x.response;

import S7.b;
import java.io.Serializable;

public class GenreBaseRes implements Serializable {
    @b("BGCOLOR")
    public String bgColor;
    @b("BGIMGURL")
    public String bgImgUrl;
    @b("FONTCOLOR")
    public String fontColor;
    @b("GNRCODE")
    public String gnrCode;
    @b("GNRMENUSEQ")
    public String gnrMenuSeq;
    @b("GNRNAME")
    public String gnrName;
    @b("GNRNAMEFULL")
    public String gnrNameFull;
    @b("GNRNAMESIMPLE")
    public String gnrNameSimple;
    private static final long serialVersionUID = 0x784BEDF2CA2AA90BL;

    public GenreBaseRes() {
        this.gnrMenuSeq = "";
        this.gnrCode = "";
        this.gnrName = "";
        this.gnrNameFull = "";
        this.gnrNameSimple = "";
        this.bgImgUrl = "";
        this.bgColor = "";
        this.fontColor = "";
    }
}

