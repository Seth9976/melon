package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class StreamingDeviceRegistRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("DEVICELIST")
        public ArrayList deviceList;
        @b("RESULT")
        public String result;

        public RESPONSE() {
            this.result = "";
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

