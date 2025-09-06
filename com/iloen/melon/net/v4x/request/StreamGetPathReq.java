package com.iloen.melon.net.v4x.request;

import android.content.Context;
import android.text.TextUtils;
import com.iloen.melon.net.v4x.response.StreamGetPathRes;
import com.iloen.melon.playback.PlayerKind;
import com.iloen.melon.playback.PlayerPOCHelper.POCValue;

public class StreamGetPathReq extends PlayBaseReq {
    public static class ParamInfo {
        public String bitrate;
        public String cType;
        public String changeST;
        public String cid;
        public String deviceVersion;
        public String flacMetaType;
        public String hlsYn;
        public String metaType;
        public String modelName;
        public String mwYn;
        public String preYn;
        public int rt;
        public String spatialMetaType;
        public String userType;

    }

    public static final String USERTYPE_CUSTOM = "C";
    public static final String USERTYPE_PRODUCER = "P";
    private final PlayerKind mPlayerKind;

    public StreamGetPathReq(Context context0, POCValue playerPOCHelper$POCValue0, PlayerKind playerKind0, ParamInfo streamGetPathReq$ParamInfo0) {
        super(context0, playerPOCHelper$POCValue0.cpId, playerPOCHelper$POCValue0.cpKey, 0, StreamGetPathRes.class);
        this.mPlayerKind = playerKind0;
        this.setup(streamGetPathReq$ParamInfo0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        if(PlayerKind.GoogleCastPlayer.equals(this.mPlayerKind)) {
            return "/cds/delivery/chromecast/streaming_path.json";
        }
        return PlayerKind.DlnaPlayer.equals(this.mPlayerKind) ? "/cds/delivery/dlna/streaming_path.json" : "/cds/delivery/android/streaming_path.json";
    }

    private void setup(ParamInfo streamGetPathReq$ParamInfo0) {
        this.addParam("cType", streamGetPathReq$ParamInfo0.cType);
        this.addParam("cId", streamGetPathReq$ParamInfo0.cid);
        this.addParam("metaType", streamGetPathReq$ParamInfo0.metaType);
        this.addParam("sessionId", "");
        if(!TextUtils.isEmpty(streamGetPathReq$ParamInfo0.changeST) && "Y".equals(streamGetPathReq$ParamInfo0.changeST)) {
            this.addParam("changeSt", streamGetPathReq$ParamInfo0.changeST);
        }
        this.addParam("bitrate", streamGetPathReq$ParamInfo0.bitrate);
        if(!TextUtils.isEmpty(streamGetPathReq$ParamInfo0.flacMetaType)) {
            this.addParam("flacMetaType", streamGetPathReq$ParamInfo0.flacMetaType);
        }
        if(!TextUtils.isEmpty(streamGetPathReq$ParamInfo0.modelName)) {
            this.addParam("modelName", streamGetPathReq$ParamInfo0.modelName);
        }
        if(!TextUtils.isEmpty(streamGetPathReq$ParamInfo0.deviceVersion)) {
            this.addParam("deviceVersion", streamGetPathReq$ParamInfo0.deviceVersion);
        }
        int v = streamGetPathReq$ParamInfo0.rt;
        if(v > 0) {
            this.addParam("rt", String.valueOf(v));
        }
        if("Y".equals(streamGetPathReq$ParamInfo0.hlsYn)) {
            this.addParam("hlsYn", "Y");
        }
        this.addParam("networkType", "wifi");
        if(!TextUtils.isEmpty(streamGetPathReq$ParamInfo0.userType)) {
            this.addParam("userType", streamGetPathReq$ParamInfo0.userType);
        }
        if(!TextUtils.isEmpty(streamGetPathReq$ParamInfo0.preYn)) {
            this.addParam("preYn", streamGetPathReq$ParamInfo0.preYn);
        }
        if(!TextUtils.isEmpty(streamGetPathReq$ParamInfo0.spatialMetaType)) {
            this.addParam("spatialMetaType", streamGetPathReq$ParamInfo0.spatialMetaType);
        }
        if(!TextUtils.isEmpty(streamGetPathReq$ParamInfo0.mwYn)) {
            this.addParam("mwYn", streamGetPathReq$ParamInfo0.mwYn);
        }
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public boolean shouldCache() {
        return false;
    }
}

