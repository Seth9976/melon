package com.iloen.melon.net.v4x.common;

import S7.b;
import java.io.Serializable;

public class GraphInfoBase implements Serializable {
    public static enum YesNo {
        @b(alternate = {"y"}, value = "Y")
        Yes,
        @b(alternate = {"n"}, value = "N")
        No;

        private static YesNo[] $values() [...] // Inlined contents

        public boolean isNo() {
            return this == YesNo.No;
        }

        public boolean isYes() [...] // 潜在的解密器
    }

    @b("FSTTOPTIC")
    public boolean fstTopTic;
    @b("IMMTOPTIC")
    public boolean immTopTic;
    @b("NEWRANKTIC")
    public boolean newRankTic;
    private static final long serialVersionUID = 0x94808E80B33595A2L;
    @b("TOPCNTTIC")
    public int topCntTic;
    @b("TOPCNTYN")
    public YesNo topCntYn;
    @b("VAL")
    public String value;
    @b("X")
    public int xIndex;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

