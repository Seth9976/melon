package Dd;

import Ac.M3;
import Cc.y3;
import Cc.z3;
import Pc.e;
import T2.a;
import androidx.lifecycle.f0;
import com.iloen.melon.custom.L0;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.kakao.tiara.data.ActionKind;
import com.melon.ui.K4;
import com.melon.ui.N3;
import com.melon.ui.Q;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.k1;
import com.melon.ui.n4;
import com.melon.ui.s4;
import com.melon.ui.y4;
import com.melon.ui.z4;
import ea.d;
import ie.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import je.p;
import k8.Y;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import mb.k;
import p8.b;
import p8.f;
import p8.g;
import va.e0;

public abstract class h2 extends k1 {
    public final Q a;
    public final n4 b;
    public final StringProviderImpl c;
    public final k d;
    public String e;
    public boolean f;
    public String g;
    public boolean h;
    public boolean i;
    public boolean j;

    public h2(Q q0, n4 n40, StringProviderImpl stringProviderImpl0, k k0) {
        q.g(k0, "loginUseCase");
        super();
        this.a = q0;
        this.b = n40;
        this.c = stringProviderImpl0;
        this.d = k0;
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new S1(this, null), 3, null);
        new LogU("ProfileBaseViewModel").setCategory(Category.UI);
        this.e = "";
        this.g = "";
    }

    public final void c(d d0) {
        q.g(d0, "useCase");
        if(!this.isLoginUser()) {
            this.sendUiEvent(s4.a);
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getIO(), null, new f2(d0, ((g1)this), null), 2, null);
    }

    public static int d(String s) {
        if(s != null) {
            switch(s) {
                case "DJBLUE": {
                    return 0x7F060046;  // color:blue400s_support_high_contrast
                }
                case "DJGREEN": {
                    return 0x7F06017C;  // color:green500s_support_high_contrast
                }
                case "DJORANGE": {
                    return 0x7F060443;  // color:orange500s
                }
                default: {
                    return -1;
                }
            }
        }
        return -1;
    }

    public final s e() {
        O1 o10 = this.h();
        if(o10 != null) {
            List list0 = o10.a;
            if(list0 != null) {
                int v = 0;
                Iterator iterator0 = list0.iterator();
                while(true) {
                    if(!iterator0.hasNext()) {
                        v = -1;
                        break;
                    }
                    Object object0 = iterator0.next();
                    if(((K4)object0) instanceof V1) {
                        break;
                    }
                    ++v;
                }
                if(v < 0) {
                    return null;
                }
                ArrayList arrayList0 = new ArrayList();
                for(Object object1: list0) {
                    if(object1 instanceof V1) {
                        arrayList0.add(object1);
                    }
                }
                return new s(list0, v, ((V1)p.k0(arrayList0)));
            }
        }
        return null;
    }

    public final String f(String s) {
        StringProviderImpl stringProviderImpl0 = this.c;
        if(s.length() == 0) {
            if(this.i) {
                return stringProviderImpl0.a(0x7F130FCA);  // string:tiara_profile_provider_type_power_dj "파워DJ"
            }
            return this.h ? stringProviderImpl0.a(0x7F130FC8) : stringProviderImpl0.a(0x7F130FC9);  // string:tiara_profile_provider_type_dj "DJ"
        }
        if(!s.equals("N10009") && !s.equals("N10080")) {
            if(s.equals("N10016")) {
                return stringProviderImpl0.a(0x7F130FC7);  // string:tiara_profile_provider_type_artist "아티스트"
            }
            return s.equals("N10074") ? stringProviderImpl0.a(0x7F130FCB) : stringProviderImpl0.a(0x7F130FC9);  // string:tiara_profile_provider_type_series "시리즈"
        }
        return stringProviderImpl0.a(0x7F130FC8);  // string:tiara_profile_provider_type_dj "DJ"
    }

    public static int g(String s) {
        if(s.equals("FACEBOOK")) {
            return 0x7F080264;  // drawable:btn_sns_facebook_22
        }
        if(s.equals("INSTAGRAM")) {
            return 0x7F080265;  // drawable:btn_sns_instagram_22
        }
        if(s.equals("KAKAO")) {
            return 0x7F080266;  // drawable:btn_sns_talkch_22
        }
        if(s.equals("TIKTOK")) {
            return 0x7F080267;  // drawable:btn_sns_tiktok_22
        }
        if(s.equals("TWITTER")) {
            return 0x7F080600;  // drawable:ic_x_22
        }
        return s.equals("YOUTUBE") ? 0x7F080268 : -1;  // drawable:btn_sns_youtube_22
    }

    public final O1 h() {
        Object object0 = this.getUiState().getValue();
        return object0 instanceof O1 ? ((O1)object0) : null;
    }

    public final f i() {
        p8.s s0 = this.getTiaraProperty();
        if(s0 != null) {
            f f0 = new g();  // 初始化器: Lp8/f;-><init>()V
            f0.b = s0.a;
            f0.c = s0.b;
            f0.I = s0.c;
            return f0;
        }
        return null;
    }

    public final boolean isLoginUser() {
        return ((e0)this.d).m();
    }

    public final void j(M3 m30) {
        q.g(m30, "data");
        s s0 = this.e();
        if(s0 != null) {
            ArrayList arrayList0 = p.Q0(((Collection)s0.a));
            V1 v10 = V1.a(((V1)s0.c), false, false, m30.a, m30.b, m30.c, 0x1CBFFFFF);
            arrayList0.set(((Number)s0.b).intValue(), v10);
            if(this.h() != null) {
                this.updateUiState(new Q1(this, arrayList0, 0));
            }
        }
    }

    public final void k(boolean z) {
        s s0 = this.e();
        if(s0 != null) {
            ArrayList arrayList0 = p.Q0(((Collection)s0.a));
            V1 v10 = V1.a(((V1)s0.c), false, z, 0, false, false, 0x1FFFBFFF);
            arrayList0.set(((Number)s0.b).intValue(), v10);
            if(this.h() != null) {
                this.updateUiState(new Q1(this, arrayList0, 1));
            }
        }
    }

    @Override  // com.melon.ui.k1
    public void onUserEvent(e e0) {
        q.g(e0, "userEvent");
        StringProviderImpl stringProviderImpl0 = this.c;
        if(e0 instanceof Z1) {
            String s = ((Z1)e0).d;
            String s1 = ((Z1)e0).b;
            if(((Z1)e0).a) {
                Navigator.openDjPlaylistDetail(s1);
            }
            else {
                Navigator.INSTANCE.openPlaylistDetail(s1);
            }
            f f0 = this.i();
            if(f0 == null) {
                return;
            }
            f0.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = stringProviderImpl0.a(0x7F130FC5);  // string:tiara_profile_playlist "플레이리스트"
            f0.c(((Z1)e0).e + 1);
            if(this.f) {
                f0.n = this.f(s);
            }
            else {
                if(!(this instanceof I) || !(this instanceof K1)) {
                    f0.v = this.f("");
                }
                f0.u = this instanceof I ? stringProviderImpl0.a(0x7F130FC6) : this.g;  // string:tiara_profile_provider_melgun "멜군"
            }
            f0.e = s1;
            f0.f = b.a(s);
            f0.g = ((Z1)e0).c;
            f0.a().track();
            return;
        }
        Q q0 = this.a;
        if(e0 instanceof a2) {
            StatsElementsBase statsElementsBase0 = ((a2)e0).e;
            String s2 = ((a2)e0).b;
            String s3 = ((a2)e0).d;
            if(((a2)e0).a) {
                q0.d(new com.melon.ui.k(s2, this.getMenuId(), statsElementsBase0, 0x20), f0.h(this), new Cd.Q(1, this, h2.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 29));
            }
            else {
                this.sendUiEvent(new y4(s2, this.getMenuId(), statsElementsBase0, 12));
            }
            f f1 = this.i();
            if(f1 == null) {
                return;
            }
            f1.a = stringProviderImpl0.a(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
            f1.d = ActionKind.PlayMusic;
            f1.y = stringProviderImpl0.a(0x7F130FC5);  // string:tiara_profile_playlist "플레이리스트"
            f1.c(((a2)e0).f + 1);
            if(this.f) {
                f1.n = this.f(s3);
            }
            else {
                if(!(this instanceof I) || !(this instanceof K1)) {
                    f1.v = this.f("");
                }
                f1.u = this.g;
            }
            f1.e = s2;
            f1.f = b.a(s3);
            f1.g = ((a2)e0).c;
            f1.a().track();
            return;
        }
        if(e0 instanceof y3) {
            String s4 = ((y3)e0).a;
            Navigator.INSTANCE.openCastEpisodeDetail(s4);
            f f2 = this.i();
            if(f2 == null) {
                return;
            }
            f2.a = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f2.d = ActionKind.ClickContent;
            f2.y = stringProviderImpl0.a(0x7F130E1A);  // string:tiara_common_layer1_station "스테이션"
            f2.c(((y3)e0).c + 1);
            if(!this.f) {
                if(!(this instanceof K1)) {
                    f2.v = this.f("");
                }
                f2.u = this.g;
            }
            f2.e = s4;
            f2.f = Y.i(ContsTypeCode.RADIO_CAST, "code(...)");
            f2.g = ((y3)e0).b;
            f2.a().track();
            return;
        }
        if(e0 instanceof z3) {
            String s5 = ((z3)e0).a;
            this.sendUiEvent(new z4(s5, this.getMenuId()));
            f f3 = this.i();
            if(f3 != null) {
                f3.a = stringProviderImpl0.a(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
                f3.d = ActionKind.PlayMusic;
                f3.y = stringProviderImpl0.a(0x7F130E1A);  // string:tiara_common_layer1_station "스테이션"
                f3.c(((z3)e0).c + 1);
                if(!this.f) {
                    if(!(this instanceof K1)) {
                        f3.v = this.f("");
                    }
                    f3.u = this.g;
                }
                f3.e = s5;
                f3.f = Y.i(ContsTypeCode.RADIO_CAST, "code(...)");
                f3.g = ((z3)e0).b;
                f3.a().track();
            }
            return;
        }
        if(e0 instanceof com.melon.ui.q) {
            q0.d(((com.melon.ui.q)e0), f0.h(this), new g2(1, this, h2.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 0));
            return;
        }
        if(e0 instanceof N3) {
            a a0 = f0.h(this);
            boolean z = this.isLoginUser();
            g2 g20 = new g2(1, this, h2.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 1);
            L0 l00 = this.getProgressUpdater();
            this.b.b(((N3)e0), a0, z, g20, l00);
            return;
        }
        super.onUserEvent(e0);
    }
}

