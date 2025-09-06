package com.iloen.melon.net.mcp.request;

import android.content.Context;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.mcp.response.EpPlayPositionRes;
import com.iloen.melon.utils.system.DeviceIdentifier;

public class EpPlayPositionReq extends EpPlayBaseReq {
    public EpPlayPositionReq(Context context0, String s) {
        super(context0, 0, EpPlayPositionRes.class);
        this.addHeader("Melon-UserAgent", MelonAppBase.instance.getMelonProtocolUserAgent());
        this.addHeader("Melon-Pcid", DeviceIdentifier.id(MelonAppBase.instance.getDeviceData().a));
        this.addMemberKey(s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/position.json";
    }
}

