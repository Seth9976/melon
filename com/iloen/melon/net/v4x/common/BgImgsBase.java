package com.iloen.melon.net.v4x.common;

import S7.b;
import java.io.Serializable;

public class BgImgsBase implements Serializable {
    @b("BGIMGPATH")
    public String bgImgPath;
    @b("DPORDER")
    public String dpOrder;
    private static final long serialVersionUID = 0x3599A6376E9FEF0BL;

    public BgImgsBase() {
        this.dpOrder = "";
        this.bgImgPath = "";
    }
}

