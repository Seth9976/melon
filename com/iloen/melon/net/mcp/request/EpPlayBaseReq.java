package com.iloen.melon.net.mcp.request;

import A8.M;
import android.content.Context;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.HttpRequest;
import com.iloen.melon.utils.system.DeviceIdentifier;
import e1.u;
import va.e0;
import va.o;

public abstract class EpPlayBaseReq extends HttpRequest {
    public static final String HEADER_MELON_MKEY = "Melon-MKey";
    public static final String HEADER_MELON_PCID = "Melon-Pcid";
    public static final String HEADER_MELON_USER_AGENT = "Melon-UserAgent";

    public EpPlayBaseReq(Context context0, int v, Class class0) {
        this(context0, v, class0, true);
    }

    public EpPlayBaseReq(Context context0, int v, Class class0, boolean z) {
        super(context0, v, class0, z);
        this.init();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String domain() {
        return M.q;
    }

    private void init() {
        this.addHeader("Melon-UserAgent", MelonAppBase.instance.getMelonProtocolUserAgent());
        this.addHeader("Melon-Pcid", DeviceIdentifier.id(MelonAppBase.instance.getDeviceData().a));
        this.addHeader("Melon-MKey", u.v(((e0)o.a()).j()));
    }
}

