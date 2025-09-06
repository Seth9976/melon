package com.iloen.melon.net.v5x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class DjBrandBannerRes extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        @b("BANNERLIST")
        public ArrayList bannerList;
        private static final long serialVersionUID = 0xB751964276DA1D6DL;

        public RESPONSE() {
            this.bannerList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x1698F142E0FDF7CBL;

    public DjBrandBannerRes() {
        this.response = null;
    }
}

