package com.iloen.melon.net.mcp;

import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.io.Serializable;

public class TrackBase implements Serializable {
    public int addOrder;
    public String id;
    public String menuId;
    public String orgMenuId;
    public long registeredDate;
    private static final long serialVersionUID = 0x559969B9F626E8FBL;
    public String songId;

    public TrackBase(String s) {
        this.id = "";
        this.addOrder = 0;
        this.menuId = "";
        this.orgMenuId = "";
        this.registeredDate = 0L;
        this.songId = s;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

