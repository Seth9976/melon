package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.StreamingDeviceInfoRes;

public class StreamingDeviceInfoReq extends PlayBaseReq {
    public StreamingDeviceInfoReq() {
        super(0, StreamingDeviceInfoRes.class);
    }

    public StreamingDeviceInfoReq(Context context0) {
        super(context0, 0, StreamingDeviceInfoRes.class);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cds/streamingdevice/info.json";
    }
}

