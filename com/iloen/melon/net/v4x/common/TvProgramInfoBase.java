package com.iloen.melon.net.v4x.common;

import S7.b;
import java.io.Serializable;

public class TvProgramInfoBase implements Serializable {
    @b("ESPDYN")
    public String espdYn;
    @b("PROGNAME")
    public String progName;
    @b("PROGSEQ")
    public String progSeq;
    private static final long serialVersionUID = 0xDBFC57C12857A61EL;

}

