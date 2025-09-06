package com.iloen.melon.net.v4x.common;

import S7.b;
import com.melon.net.res.common.MvInfoBase;
import java.util.List;

public class ContentListInfo extends MvInfoBase {
    public class Tag {
        @b("TAGNAME")
        public String tagName;
        @b("TAGSEQ")
        public String tagSeq;

        public Tag() {
            this.tagSeq = "";
            this.tagName = "";
        }
    }

    @b("ALBUMIMG1")
    public String albumimg1;
    @b("ALBUMIMG2")
    public String albumimg2;
    @b("ALBUMIMG3")
    public String albumimg3;
    @b("ALBUMIMG4")
    public String albumimg4;
    @b("CONTSTYPECODE")
    public String contstypecode;
    @b("DIMYN")
    public String dimYn;
    @b("IMGID")
    public String imgid;
    @b("IMGURL")
    public String imgurl;
    @b("ISDJ")
    public boolean isdj;
    @b("OPENYN")
    public String openyn;
    @b("OWNERMEMBERKEY")
    public String ownermemberkey;
    @b("OWNERNICKNAME")
    public String ownernickname;
    @b("PLYLSTIMG")
    public String plylstimg;
    @b("PLYLSTSEQ")
    public String plylstseq;
    @b("PLYLSTTITLE")
    public String plylsttitle;
    @b("PLYLSTTITLEORG")
    public String plylsttitleorg;
    @b("REPNTIMG")
    public String repntimg;
    private static final long serialVersionUID = 0x5D4E14FE0A0D17E9L;
    @b("TAGLIST")
    public List tagList;
    @b("THUMBIMG")
    public String thumbimg;

    public ContentListInfo() {
        this.contstypecode = "";
        this.plylstimg = "";
        this.plylsttitle = "";
        this.plylstseq = "";
        this.ownermemberkey = "";
        this.ownernickname = "";
        this.isdj = false;
        this.openyn = "";
        this.imgurl = "";
        this.imgid = "";
        this.repntimg = "";
        this.thumbimg = "";
        this.albumimg1 = "";
        this.albumimg2 = "";
        this.albumimg3 = "";
        this.albumimg4 = "";
    }

    @Override  // com.melon.net.res.common.MvInfoBase
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

