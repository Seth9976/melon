package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;

public class LivePollingRes extends ResponseV6Res {
    public static class CountBase implements Serializable {
        @b("COUNT")
        public long count;

        public CountBase() {
            this.count = 0L;
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    public static class Response extends ResponseBase {
        @b("CHEER")
        public CountBase cheer;
        @b("ISCPLANMODE")
        public boolean isCplanMode;
        @b("PLAY")
        public CountBase play;
        @b("POLLINGPERIOD")
        public long pollingPeriod;

        public Response() {
            this.isCplanMode = false;
            this.pollingPeriod = 10L;
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

