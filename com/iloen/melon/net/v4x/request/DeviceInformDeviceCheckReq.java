package com.iloen.melon.net.v4x.request;

import U4.x;
import android.content.Context;
import com.iloen.melon.net.v4x.response.DeviceInformDeviceCheckRes;
import java.io.Serializable;

public class DeviceInformDeviceCheckReq extends RequestV4Req {
    public static final class CallerType implements Serializable {
        public static final CallerType DCF = null;
        public static final CallerType DL = null;
        public static final CallerType GDL = null;
        public static final CallerType MIF = null;
        public static final CallerType PDCF = null;
        public static final CallerType RDL = null;
        public static final CallerType SET = null;
        private final String mType;
        private static final long serialVersionUID = 0x5CB7542DFEFED720L;

        static {
            CallerType.DCF = new CallerType("DCF");
            CallerType.DL = new CallerType("DL");
            CallerType.SET = new CallerType("SET");
            CallerType.PDCF = new CallerType("PDCF");
            CallerType.RDL = new CallerType("RDL");
            CallerType.GDL = new CallerType("GDL");
            CallerType.MIF = new CallerType("MIF");
        }

        private CallerType(String s) {
            this.mType = s;
        }

        @Override
        public boolean equals(Object object0) {
            if(object0 == this) {
                return true;
            }
            if(!(object0 instanceof CallerType)) {
                return false;
            }
            String s = ((CallerType)object0).mType;
            return s != null && s.equals(this.mType);
        }

        @Override
        public int hashCode() {
            return this.mType == null ? 0x20F : this.mType.hashCode() + 0x20F;
        }

        @Override
        public String toString() {
            return x.m(new StringBuilder("CallerType ["), this.mType, "]");
        }

        public String type() {
            return this.mType;
        }
    }

    public DeviceInformDeviceCheckReq(Context context0, CallerType deviceInformDeviceCheckReq$CallerType0) {
        super(context0, 0, DeviceInformDeviceCheckRes.class);
        this.addMemberKey();
        this.addParam("rType", deviceInformDeviceCheckReq$CallerType0.type());
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/registerdevice/informDeviceCheck.json";
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public boolean shouldCache() {
        return false;
    }
}

