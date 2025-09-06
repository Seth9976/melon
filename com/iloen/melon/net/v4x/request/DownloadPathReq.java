package com.iloen.melon.net.v4x.request;

import android.content.Context;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.response.DownloadPathRes;
import com.melon.utils.system.DeviceData;

public class DownloadPathReq extends PlayBaseReq {
    public static class ParamInfo {
        public String bitrate;
        public String cType;
        public String cid;
        public String drm;
        public String drmInst;
        public String giftId;
        public String menuId;
        public String product;

    }

    public DownloadPathReq(Context context0, ParamInfo downloadPathReq$ParamInfo0) {
        super(context0, 1, DownloadPathRes.class);
        String s;
        this.addParam("cId", downloadPathReq$ParamInfo0.cid);
        this.addParam("cType", downloadPathReq$ParamInfo0.cType);
        this.addParam("bitrate", downloadPathReq$ParamInfo0.bitrate);
        this.addParam("menuId", downloadPathReq$ParamInfo0.menuId);
        this.addParam("product", downloadPathReq$ParamInfo0.product);
        this.addParam("phoneType", MelonAppBase.instance.getDeviceData().c().a);
        this.addParam("drm", downloadPathReq$ParamInfo0.drm);
        if(TextUtils.isEmpty(downloadPathReq$ParamInfo0.drmInst)) {
            MelonAppBase.instance.getDeviceData().getClass();
            s = DeviceData.d().a;
        }
        else {
            s = downloadPathReq$ParamInfo0.drmInst;
        }
        this.addParam("drmInst", s);
        this.addParam("sktFlag", MelonAppBase.instance.getDeviceData().f().a);
        this.addParam("giftId", downloadPathReq$ParamInfo0.giftId);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/cds/delivery/android/download_path.json";
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public boolean shouldCache() {
        return false;
    }
}

