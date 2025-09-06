package com.iloen.melon.net.v4x.common;

import S7.b;
import java.io.Serializable;

public class BgVideoBase implements Serializable {
    @b("BGVIDEOIMGPATH")
    public String bgVideoImgPath;
    @b("BGVIDEOPATH")
    public String bgVideoPath;
    private static final long serialVersionUID = 0x72DDA3BFA30D4962L;

    public BgVideoBase() {
        this.bgVideoPath = "";
        this.bgVideoImgPath = "";
    }
}

