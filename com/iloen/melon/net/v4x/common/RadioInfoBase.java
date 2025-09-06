package com.iloen.melon.net.v4x.common;

import S7.b;
import java.io.Serializable;

public class RadioInfoBase implements Serializable {
    @b("ARTISTCHYN")
    public String artistchyn;
    @b("ARTISTID")
    public String artistid;
    @b("BTMDSPCHYN")
    public String btmdspchyn;
    @b("CHNLIMGPATH")
    public String chnlimgpath;
    @b("CHNLLSEQ")
    public String chnllseq;
    @b("CHNLLTITLE")
    public String chnlltitle;
    @b("CHNLSEQ")
    public String chnlseq;
    @b("CHNLTITLE")
    public String chnltitle;
    @b("DPORDER")
    public String dporder;
    @b("GNRCHNLMAPCODEBASKET")
    public String gnrChnlMapCodeBasket;
    @b("GNRCODE")
    public String gnrcode;
    @b("RANDYN")
    public String randyn;
    @b("RCMDCHNLYN")
    public String rdmdchclyn;
    private static final long serialVersionUID = 4472984403808302040L;
    @b("SONGCNT")
    public String songcnt;
    @b("SUBTITLE")
    public String subtitle;

    public RadioInfoBase() {
        this.chnllseq = "";
        this.chnlltitle = "";
        this.chnlseq = "";
        this.chnltitle = "";
        this.subtitle = "";
        this.chnlimgpath = "";
        this.artistid = "";
        this.gnrcode = "";
        this.songcnt = "";
        this.randyn = "";
        this.dporder = "";
        this.rdmdchclyn = "";
        this.artistchyn = "";
        this.btmdspchyn = "";
        this.gnrChnlMapCodeBasket = "";
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

