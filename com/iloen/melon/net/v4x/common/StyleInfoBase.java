package com.iloen.melon.net.v4x.common;

import S7.b;
import java.io.Serializable;

public class StyleInfoBase implements Serializable {
    private static final long serialVersionUID = 0x4EA7C9B929D694BL;
    @b("STYLECODE")
    public String styleCode;
    @b("STYLENAME")
    public String styleName;

    public StyleInfoBase() {
        this.styleCode = "";
        this.styleName = "";
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

