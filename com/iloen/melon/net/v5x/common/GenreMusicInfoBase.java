package com.iloen.melon.net.v5x.common;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.io.Serializable;

public class GenreMusicInfoBase implements Serializable {
    @b("GNRCODE")
    public String gnrCode;
    @b("GNRIMG")
    public String gnrImg;
    @b("GNRNAME")
    public String gnrName;
    @b("GUITYPE")
    public String guiType;
    @b("ISDTLGNR")
    public boolean isDtlGnr;
    @b("MENUCODE")
    public String menuCode;
    private static final long serialVersionUID = 0x5118876E425D48E2L;

    @Override
    public boolean equals(Object object0) {
        if(object0 != null && object0 instanceof GenreMusicInfoBase) {
            String s = ((GenreMusicInfoBase)object0).gnrCode;
            return s != null && s.equals(this.gnrCode);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.gnrCode == null ? 0x1F : this.gnrCode.hashCode() + 0x1F;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

