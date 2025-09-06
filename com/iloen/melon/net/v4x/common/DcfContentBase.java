package com.iloen.melon.net.v4x.common;

import S7.b;

public class DcfContentBase {
    @b("DLCO")
    public int dlco;
    @b("DLLIMITCNT")
    public int dllimitcnt;
    @b("DLLIMITYN")
    public String dllimityn;
    @b("ENDDT")
    public String enddt;
    @b("PRODID")
    public String prodid;
    @b("PRODNAME")
    public String prodname;
    @b("RMDCNT")
    public int rmdcnt;
    @b("STARTDT")
    public String startdt;

    public DcfContentBase() {
        this.prodid = "";
        this.prodname = "";
        this.dllimityn = "";
        this.startdt = "";
        this.enddt = "";
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

