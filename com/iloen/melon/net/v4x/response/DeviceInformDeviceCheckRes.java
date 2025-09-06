package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class DeviceInformDeviceCheckRes extends ResponseV4Res {
    public static final class Response extends ResponseBase {
        @b("DEVICEYN")
        public String deviceYn;

        public Response() {
            this.deviceYn = "";
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public Response response;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

