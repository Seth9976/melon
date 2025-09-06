package com.iloen.melon.net.v3x;

import android.content.Context;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.analytics.ClickLog;
import com.iloen.melon.net.HttpRequest;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.system.AppUtils;
import e1.u;
import va.e0;
import va.o;

public class ClickLogReq extends HttpRequest {
    private static final String CLICK_LOG_ADDR;
    private ClickLog mInfo;

    static {
        ClickLogReq.CLICK_LOG_ADDR = "null/?";
    }

    public ClickLogReq(Context context0) {
        this(context0, null);
    }

    public ClickLogReq(Context context0, ClickLog clickLog0) {
        super(context0, 0, HttpResponse.class, false);
        this.mInfo = clickLog0;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String domain() {
        return ClickLogReq.CLICK_LOG_ADDR;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return this.getClickLogUrl(this.mInfo);
    }

    private String getClickLogUrl(ClickLog clickLog0) {
        StringBuilder stringBuilder0 = new StringBuilder();
        if(clickLog0 != null) {
            String s = clickLog0.k;
            String s1 = clickLog0.j;
            String s2 = clickLog0.h;
            String s3 = clickLog0.c;
            String s4 = clickLog0.b;
            String s5 = clickLog0.a;
            stringBuilder0.append(s5);
            stringBuilder0.append("&");
            stringBuilder0.append(u.v(((e0)o.a()).j()));
            stringBuilder0.append("&");
            stringBuilder0.append(MelonAppBase.instance.getMelonCpId());
            stringBuilder0.append("&");
            stringBuilder0.append(AppUtils.getVersionName(MelonAppBase.instance.getContext()));
            stringBuilder0.append("&");
            stringBuilder0.append(MelonAppBase.instance.getMelonCpKey());
            stringBuilder0.append("&");
            if("CL".equals(s5)) {
                stringBuilder0.append(StringUtils.getNotNullString(s4));
                stringBuilder0.append("&");
                stringBuilder0.append(StringUtils.getNotNullString(s3));
                stringBuilder0.append("&");
                stringBuilder0.append(StringUtils.getNotNullString(clickLog0.e));
                stringBuilder0.append("&");
                stringBuilder0.append(StringUtils.getNotNullString(clickLog0.f));
                stringBuilder0.append("&");
                stringBuilder0.append(StringUtils.getNotNullString(clickLog0.g));
                stringBuilder0.append("&");
                stringBuilder0.append("");
                stringBuilder0.append("&");
                stringBuilder0.append("");
                stringBuilder0.append("&");
                stringBuilder0.append(StringUtils.getNotNullString(s2));
                stringBuilder0.append("&");
                stringBuilder0.append(StringUtils.getNotNullString(clickLog0.i));
                stringBuilder0.append("&");
                stringBuilder0.append(StringUtils.getNotNullString(s1));
                stringBuilder0.append("&");
                stringBuilder0.append(StringUtils.getNotNullString(s));
                stringBuilder0.append("&");
                stringBuilder0.append("");
                stringBuilder0.append("&");
                stringBuilder0.append(StringUtils.getNotNullString(clickLog0.l));
                stringBuilder0.append("&");
                stringBuilder0.append("");
                stringBuilder0.append("&");
                stringBuilder0.append("");
                stringBuilder0.append("&");
                stringBuilder0.append("");
                stringBuilder0.append("&");
                stringBuilder0.append(StringUtils.getNotNullString(clickLog0.m));
                stringBuilder0.append("&");
                stringBuilder0.append("");
                stringBuilder0.append("&");
                stringBuilder0.append("");
                stringBuilder0.append("&");
                stringBuilder0.append("");
                stringBuilder0.append("&");
                return stringBuilder0.toString();
            }
            if("5".equals(s5)) {
                stringBuilder0.append(StringUtils.getNotNullString(s4));
                stringBuilder0.append("&");
                stringBuilder0.append("");
                stringBuilder0.append("&");
                stringBuilder0.append("");
                stringBuilder0.append("&");
                stringBuilder0.append("");
                stringBuilder0.append("&");
                stringBuilder0.append("");
                stringBuilder0.append("&");
                stringBuilder0.append(StringUtils.getNotNullString(clickLog0.d));
                stringBuilder0.append("&");
                stringBuilder0.append(StringUtils.getNotNullString(s2));
                stringBuilder0.append("&");
                stringBuilder0.append(StringUtils.getNotNullString(s1));
                stringBuilder0.append("&");
                stringBuilder0.append(StringUtils.getNotNullString(s));
                stringBuilder0.append("&");
                stringBuilder0.append("");
                stringBuilder0.append("&");
                stringBuilder0.append("");
                stringBuilder0.append("&");
                stringBuilder0.append("");
                stringBuilder0.append("&");
                stringBuilder0.append(StringUtils.getNotNullString(clickLog0.n));
                return stringBuilder0.toString();
            }
            if("8".equals(s5)) {
                stringBuilder0.append("");
                stringBuilder0.append("&");
                stringBuilder0.append("");
                stringBuilder0.append("&");
                stringBuilder0.append("");
                stringBuilder0.append("&");
                stringBuilder0.append("");
                stringBuilder0.append("&");
                stringBuilder0.append("");
                stringBuilder0.append("&");
                stringBuilder0.append("");
                stringBuilder0.append("&");
                stringBuilder0.append("");
                stringBuilder0.append("&");
                stringBuilder0.append("");
                stringBuilder0.append("&");
                stringBuilder0.append("");
                stringBuilder0.append("&");
                stringBuilder0.append(StringUtils.getNotNullString(s3));
            }
        }
        return stringBuilder0.toString();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public boolean shouldCache() {
        return false;
    }
}

