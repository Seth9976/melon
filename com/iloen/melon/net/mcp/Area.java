package com.iloen.melon.net.mcp;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.io.Serializable;

public class Area implements Serializable {
    public static final String LIST_TYPE_CREATED = "created";
    public static final String LIST_TYPE_DJ = "dj";
    public static final String LIST_TYPE_LIKE = "like";
    public static final String LIST_TYPE_RECENT = "recent";
    public static final String SMART_LIST_TYPE_PLAYLIST = "playlist";
    public static final String SMART_LIST_TYPE_SONG = "song";
    @b("cId")
    public String cId;
    @b("cType")
    public String cType;
    @b("contsId")
    public String contsId;
    @b("contsTypeCode")
    public String contsTypeCode;
    @b("listType")
    public String listType;
    @b("pcId")
    public String pcId;
    @b("position")
    public String position;
    @b("seedContsId")
    public String seedContsId;
    @b("seedContsTypeCode")
    public String seedContsTypeCode;
    private static final long serialVersionUID = 0x5FB7E09B86F80589L;
    @b("smartListType")
    public String smartListType;
    @b("trackId")
    public String trackId;

    public Area() {
        this.smartListType = "";
        this.listType = "";
        this.contsTypeCode = "";
        this.contsId = "";
        this.trackId = "";
        this.position = "";
        this.seedContsId = "";
        this.seedContsTypeCode = "";
        this.cId = "";
        this.cType = "";
        this.pcId = "";
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

