package com.iloen.melon.net.v4x.common;

import S7.b;
import java.io.Serializable;

public class TvProgramBase implements Serializable {
    @b("CONTSTYPECODE")
    public String contsTypeCode;
    @b("ESPDYN")
    public String espdYn;
    @b("HOTYN")
    public String hotYN;
    @b("NEWYN")
    public String newYN;
    @b("PROGDESC")
    public String progDesc;
    @b("PROGNAME")
    public String progName;
    @b("PROGSEQ")
    public String progSeq;
    @b("PROGSIMPLDESC")
    public String progSimplDesc;
    @b("PROGTHUMBIMAGEURL")
    public String progThumbImageUrl;
    private static final long serialVersionUID = 0x76A36A344C291830L;

    public TvProgramBase() {
        this.progSeq = "";
        this.progName = "";
        this.progDesc = "";
        this.progSimplDesc = "";
        this.progThumbImageUrl = "";
        this.espdYn = "";
        this.hotYN = "";
        this.newYN = "";
        this.contsTypeCode = "";
    }
}

