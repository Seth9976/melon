package com.iloen.melon.net.mcp.request;

import android.content.Context;
import com.google.gson.n;
import com.iloen.melon.net.mcp.Area;
import com.iloen.melon.net.mcp.response.EpPlayBaseRes;

public class EpPlayReReq extends EpPlayBaseReq {
    public static class Body {
        public String accumulatedTime;
        public String action;
        public Area area;
        public String bitrate;
        public String cId;
        public String cType;
        public String cpId;
        public String cpKey;
        public String freeYn;
        public String impressionId;
        public String initDate;
        public String locPl;
        public String loggingToken;
        public String mediaType;
        public String menuId;
        public String metaType;
        public String networkType;
        public String orgMenuId;
        public String parentContsId;
        public String parentContsType;
        public String pinterval;
        public String playToken;
        public String rangeCode;
        public String seedContsId;
        public String seedContsTypeCode;
        public String timestamp;
        public String trackId;
        public String volume;

        public Body() {
            this.area = null;
            this.timestamp = "";
            this.action = "";
            this.trackId = "";
            this.accumulatedTime = "";
            this.playToken = "";
            this.pinterval = "";
            this.cpId = "";
            this.cpKey = "";
            this.cId = "";
            this.cType = "";
            this.menuId = "";
            this.orgMenuId = "";
            this.bitrate = "";
            this.metaType = "";
            this.loggingToken = "";
            this.locPl = "";
            this.initDate = "";
            this.freeYn = "";
            this.networkType = "";
            this.rangeCode = "";
            this.impressionId = "";
            this.parentContsType = "";
            this.parentContsId = "";
            this.seedContsId = "";
            this.seedContsTypeCode = "";
            this.mediaType = "";
            this.volume = "";
        }
    }

    public static class Params {
        public String action;
        public String cId;
        public String cType;
        public String timestamp;

        public Params() {
            this.action = "";
            this.cId = "";
            this.cType = "";
            this.timestamp = "";
        }
    }

    public static final String ACTION_PAUSE = "pause";
    public static final String ACTION_PLAY = "play";
    public static final String ACTION_POLLING = "polling";
    public static final String URL_PO = "/po.json";
    public static final String URL_RE = "/re.json";
    private String url;

    public EpPlayReReq(Context context0, String s, Params epPlayReReq$Params0, Body epPlayReReq$Body0) {
        super(context0, 1, EpPlayBaseRes.class);
        this.url = s;
        this.addParams(epPlayReReq$Params0);
        this.setJsonString(new n().k(epPlayReReq$Body0));
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return this.url;
    }
}

