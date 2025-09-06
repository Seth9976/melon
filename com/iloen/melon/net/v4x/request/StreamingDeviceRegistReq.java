package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.StreamingDeviceRegistRes;

public class StreamingDeviceRegistReq extends PlayBaseReq {
    public static class Param {
        public int delSOpmdSeq;

    }

    public StreamingDeviceRegistReq() {
        super(1, StreamingDeviceRegistRes.class);
    }

    public StreamingDeviceRegistReq(Context context0) {
        super(context0, 1, StreamingDeviceRegistRes.class);
    }

    public StreamingDeviceRegistReq(Context context0, Param streamingDeviceRegistReq$Param0) {
        super(context0, 1, StreamingDeviceRegistRes.class);
        this.addParams(streamingDeviceRegistReq$Param0);
    }

    public StreamingDeviceRegistReq(Param streamingDeviceRegistReq$Param0) {
        super(1, StreamingDeviceRegistRes.class);
        this.addParams(streamingDeviceRegistReq$Param0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cds/streamingdevice/regist.json";
    }
}

