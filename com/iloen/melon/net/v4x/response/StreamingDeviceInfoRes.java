package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class StreamingDeviceInfoRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        static class Device {
            @b("HWKEY")
            public String hwKey;
            @b("MODELNAME")
            public String modelName;
            @b("SOPMDSEQ")
            public int sOpmdSeq;

            private Device() {
                this.sOpmdSeq = -1;
                this.modelName = "";
                this.hwKey = "";
            }

            public Device(int v) {
            }
        }

        public static class Mine extends Device {
            @b("CURRENTDEVICEYN")
            public String currentDeviceYn;
            @b("DPDATE")
            public String dpDate;

            public Mine() {
                super(0);
                this.dpDate = "";
                this.currentDeviceYn = "";
            }
        }

        public static class Others {
            @b("OTHERNAME")
            public String otherName;

            public Others() {
                this.otherName = "";
            }
        }

        @b("DEVICELIST")
        public ArrayList deviceList;
        @b("DEVICEYN")
        public String deviceYn;
        @b("LIMITCNT")
        public int limitCnt;
        @b("MAXCNT")
        public int maxCnt;
        @b("OTHERDEVICELIST")
        public ArrayList otherDeviceList;
        @b("RESULT")
        public String result;

        public RESPONSE() {
            this.result = "";
            this.deviceYn = "";
            this.limitCnt = -1;
            this.maxCnt = 1;
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

