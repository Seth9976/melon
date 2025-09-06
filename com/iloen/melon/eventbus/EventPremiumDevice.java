package com.iloen.melon.eventbus;

import com.iloen.melon.net.v4x.response.StreamingDeviceInfoRes.RESPONSE;
import java.util.Collection;
import java.util.List;

public class EventPremiumDevice {
    public static class ConsentOfUserDownload extends EventPremiumDevice {
        public ConsentOfUserDownload(List list0, int v) {
            this.list = list0;
            this.realSize = v;
        }
    }

    public static class GetDevices extends EventPremiumDevice {
        public GetDevices(RESPONSE streamingDeviceInfoRes$RESPONSE0) {
            this.response = streamingDeviceInfoRes$RESPONSE0;
        }
    }

    public static class NoUseLteForDownload extends EventPremiumDevice {
        public Collection downloadList;

        public NoUseLteForDownload(Collection collection0) {
            this.downloadList = collection0;
        }
    }

    public static EventPremiumDevice COMPLETE_REGISTER_DEVICE;
    public static EventPremiumDevice FIXED_STORAGE;
    public static EventPremiumDevice STOP_REGISTER_DEVICE;
    public static EventPremiumDevice STOP_SCENARIO;
    public List list;
    public int realSize;
    public Object response;

    static {
        EventPremiumDevice.FIXED_STORAGE = new EventPremiumDevice();
        EventPremiumDevice.STOP_SCENARIO = new EventPremiumDevice();
        EventPremiumDevice.STOP_REGISTER_DEVICE = new EventPremiumDevice();
        EventPremiumDevice.COMPLETE_REGISTER_DEVICE = new EventPremiumDevice();
    }
}

