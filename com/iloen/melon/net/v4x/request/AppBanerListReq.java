package com.iloen.melon.net.v4x.request;

import android.content.Context;
import android.text.TextUtils;
import com.iloen.melon.net.v4x.response.AppBanerListRes;

public class AppBanerListReq extends BannerBaseReq {
    @Deprecated(since = "use BannerType in BannerUseCase")
    public static enum BannerType {
        MENU("MENU"),
        MM_PROMO_DTL("MM_PROMO_DTL"),
        MM_LAYERPOP_F02("MM_LAYERPOP_F02"),
        MPLAYER("MPLAYER"),
        MPLAYER_V4("MPLAYER_V4"),
        MM_MENU_SVC_GID("MM_MENU_SVC_GID"),
        MM_JUST_SONG("MM_JUST_SONG"),
        MSPTS_HOME_PRO("MSPTS_HOME_PRO"),
        MM_MDJ_TODAY("MM_MDJ_TODAY"),
        MM_PLYLST_PTDJ("MM_PLYLST_PTDJ");

        private final String value;

        private static BannerType[] $values() [...] // Inlined contents

        private BannerType(String s1) {
            this.value = s1;
        }

        public String getValue() {
            return this.value;
        }
    }

    public static class ParamInfo {
        public String bannerType;
        public String contsId;
        public String contsType;
        public String menuCode;
        public String rowsCnt;

        public ParamInfo() {
            this.bannerType = "";
            this.contsType = "";
            this.contsId = "";
            this.menuCode = "";
            this.rowsCnt = "";
        }
    }

    public static final int ACTION_TYPE_PROMOTION;
    private int mActionType;

    public AppBanerListReq(Context context0, ParamInfo appBanerListReq$ParamInfo0, int v) {
        super(context0, 0, AppBanerListRes.class);
        this.mActionType = 0;
        this.addParam("bannerType", appBanerListReq$ParamInfo0.bannerType);
        if(!TextUtils.isEmpty(appBanerListReq$ParamInfo0.contsType)) {
            this.addParam("contsType", appBanerListReq$ParamInfo0.contsType);
        }
        if(!TextUtils.isEmpty(appBanerListReq$ParamInfo0.contsId)) {
            this.addParam("contsId", appBanerListReq$ParamInfo0.contsId);
        }
        if(!TextUtils.isEmpty(appBanerListReq$ParamInfo0.menuCode)) {
            this.addParam("menuCode", appBanerListReq$ParamInfo0.menuCode);
        }
        if(!TextUtils.isEmpty(appBanerListReq$ParamInfo0.rowsCnt)) {
            this.addParam("rowsCnt", appBanerListReq$ParamInfo0.rowsCnt);
        }
        this.addParam("bnrSgmt", "");
        this.addParam("bnrOrd", "2");
        this.mActionType = v;
    }

    public AppBanerListReq(ParamInfo appBanerListReq$ParamInfo0, int v) {
        super(0, AppBanerListRes.class);
        this.mActionType = 0;
        this.addParam("bannerType", appBanerListReq$ParamInfo0.bannerType);
        if(!TextUtils.isEmpty(appBanerListReq$ParamInfo0.contsType)) {
            this.addParam("contsType", appBanerListReq$ParamInfo0.contsType);
        }
        if(!TextUtils.isEmpty(appBanerListReq$ParamInfo0.contsId)) {
            this.addParam("contsId", appBanerListReq$ParamInfo0.contsId);
        }
        if(!TextUtils.isEmpty(appBanerListReq$ParamInfo0.menuCode)) {
            this.addParam("menuCode", appBanerListReq$ParamInfo0.menuCode);
        }
        if(!TextUtils.isEmpty(appBanerListReq$ParamInfo0.rowsCnt)) {
            this.addParam("rowsCnt", appBanerListReq$ParamInfo0.rowsCnt);
        }
        this.addParam("bnrSgmt", "");
        this.addParam("bnrOrd", "3");
        this.mActionType = v;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return this.mActionType == 0 ? "/promotion/appbanerList.json" : "/songplayer/appbanerList.json";
    }
}

