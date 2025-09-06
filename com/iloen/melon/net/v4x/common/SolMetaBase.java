package com.iloen.melon.net.v4x.common;

import S7.b;
import java.io.Serializable;

public class SolMetaBase implements Serializable {
    private static final long serialVersionUID = -7300012324375685300L;
    @b("SOL")
    public String sol;
    @b("SOLFILEUPDTDATE")
    public String solFileUpdtDate;
    @b("SOLTYPECODE")
    public String solTypeCode;

    public SolMetaBase() {
        this.sol = "";
        this.solFileUpdtDate = "";
        this.solTypeCode = "";
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

