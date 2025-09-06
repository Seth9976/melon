package com.iloen.melon.net.v4x.common;

import S7.b;
import com.melon.net.res.common.ArtistsInfoBase;
import java.io.Serializable;
import java.util.ArrayList;

public class ContsInfoBase implements Serializable {
    public static class ARTISTLIST extends ArtistsInfoBase {
        private static final long serialVersionUID = 0x593A836496A7E198L;

    }

    public static class LINK extends BannerBase {
        private static final long serialVersionUID = 0x2FB47722A52055BFL;

    }

    @b("ARTISTLIST")
    public ArrayList artistList;
    @b("CONTSCNT")
    public String contsCnt;
    @b("CONTSID")
    public String contsId;
    @b("CONTSIMG")
    public String contsImg;
    @b("CONTSNAME")
    public String contsName;
    @b("CONTSTYPECODE")
    public String contsTypeCode;
    @b("LINK")
    public LINK link;
    private static final long serialVersionUID = 0xB94D90C675F9DF5BL;

    public ContsInfoBase() {
        this.contsTypeCode = "";
        this.contsId = "";
        this.contsName = "";
        this.contsImg = "";
        this.contsCnt = "";
        this.artistList = null;
        this.link = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

