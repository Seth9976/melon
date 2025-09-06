package com.iloen.melon.utils;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.BannerBase;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.log.LogU;
import java.util.HashMap;
import v9.f;
import v9.g;

public final class FamilyAppHelper {
    static abstract class AbsFamilyApp implements FamilyApp {
        public void openActivity(String s) {
            if(TextUtils.isEmpty(s)) {
                throw new Exception("urlScheme is null");
            }
            Intent intent0 = new Intent("android.intent.action.VIEW");
            intent0.setFlags(0x10000000);
            intent0.setData(Uri.parse(s));
            MelonAppBase.instance.getContext().startActivity(intent0);
        }

        @Override  // com.iloen.melon.utils.FamilyApp
        public void openApp(BannerBase bannerBase0) {
            this.openApp(bannerBase0, g.a);
        }

        @Override  // com.iloen.melon.utils.FamilyApp
        public void openApp(BannerBase bannerBase0, g g0) {
            if(bannerBase0 == null) {
                LogU.w("FamilyAppHelper", "openApp() invalid banner");
                return;
            }
            this.openLinkApp(bannerBase0.scheme, bannerBase0.linkurl, bannerBase0.linktype);
        }

        @Override  // com.iloen.melon.utils.FamilyApp
        public void openApp(MelonLinkInfo melonLinkInfo0) {
            this.openApp(melonLinkInfo0, g.a);
        }

        @Override  // com.iloen.melon.utils.FamilyApp
        public void openApp(MelonLinkInfo melonLinkInfo0, g g0) {
            if(melonLinkInfo0 == null) {
                LogU.w("FamilyAppHelper", "openApp() invalid linkInfo");
                return;
            }
            if(TextUtils.isEmpty(melonLinkInfo0.b)) {
                this.openApp(melonLinkInfo0.c, g0);
                return;
            }
            this.openLinkApp(melonLinkInfo0.c, melonLinkInfo0.b, melonLinkInfo0.a);
        }

        public void openLinkApp(String s, String s1, String s2) {
            try {
                this.openActivity(s);
            }
            catch(Exception exception0) {
                LogU.w("FamilyAppHelper", "openLinkApp() " + exception0.toString());
                MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
                melonLinkInfo0.a = s2;
                melonLinkInfo0.b = s1;
                MelonLinkExecutor.open(melonLinkInfo0);
            }
        }
    }

    static final class Ticket extends AbsFamilyApp {
        @Override  // com.iloen.melon.utils.FamilyApp
        public void openApp() {
            this.openApp(g.a);
        }

        @Override  // com.iloen.melon.utils.FamilyApp
        public void openApp(String s) {
            this.openApp(s, g.a);
        }

        @Override  // com.iloen.melon.utils.FamilyApp
        public void openApp(String s, g g0) {
            try {
                this.openActivity(s);
            }
            catch(Exception exception0) {
                LogU.w("FamilyAppHelper", "openApp(Ticket) " + exception0.toString());
                g0.getClass();
                Navigator.openMarket("com.iloen.melonticket");
            }
        }

        @Override  // com.iloen.melon.utils.FamilyApp
        public void openApp(g g0) {
            this.openApp("melonticket://", g0);
        }
    }

    public static final String TICKET_APP_LAUNCH_SCHEME = "melonticket://";
    public static final String TICKET_PKG_NAME = "com.iloen.melonticket";
    public static final HashMap a;

    static {
        HashMap hashMap0 = new HashMap();
        FamilyAppHelper.a = hashMap0;
        Ticket familyAppHelper$Ticket0 = new Ticket();  // 初始化器: Ljava/lang/Object;-><init>()V
        hashMap0.put(f.a, familyAppHelper$Ticket0);
    }

    public static final FamilyApp getFamilyApp(f f0) {
        HashMap hashMap0 = FamilyAppHelper.a;
        if(!hashMap0.containsKey(f0)) {
            throw new IllegalArgumentException("unknown kind : " + f0);
        }
        return (FamilyApp)hashMap0.get(f0);
    }
}

