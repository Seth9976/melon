package com.iloen.melon.net.mcp;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.io.Serializable;

public class UpdateInfoBase implements Serializable {
    @b("lastUpdatePcId")
    public String lastUpdatePcId;
    @b("replaceThreshold")
    public int replaceThreshold;
    private static final long serialVersionUID = 0xE8EC24F2869CEAB8L;
    @b("updatedDate")
    public long updatedDate;

    public UpdateInfoBase() {
        this.lastUpdatePcId = "";
        this.updatedDate = 0L;
        this.replaceThreshold = 0;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

