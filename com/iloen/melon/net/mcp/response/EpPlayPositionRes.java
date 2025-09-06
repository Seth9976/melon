package com.iloen.melon.net.mcp.response;

import S7.b;
import com.iloen.melon.net.mcp.Area;
import com.iloen.melon.net.v4x.common.ToStringUtil;

public class EpPlayPositionRes extends EpPlayBaseRes {
    @b("area")
    public Area area;
    private static final long serialVersionUID = 0x8938BBC11FB73C67L;

    public EpPlayPositionRes() {
        this.area = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

