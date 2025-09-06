package gd;

import Pc.e;
import android.content.Context;
import androidx.lifecycle.f0;
import com.google.firebase.b;
import com.iloen.melon.custom.L0;
import com.iloen.melon.custom.S0;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.utils.Navigator;
import com.kakao.tiara.data.ActionKind;
import com.melon.ui.g1;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.k1;
import ie.H;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import p8.f;
import p8.g;
import p8.s;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lgd/n2;", "Lcom/melon/ui/k1;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class n2 extends k1 {
    public final S0 a;
    public final StringProviderImpl b;
    public String c;
    public String d;
    public Context e;
    public static final int f;

    public n2(S0 s00, StringProviderImpl stringProviderImpl0) {
        this.a = s00;
        this.b = stringProviderImpl0;
    }

    public final f c() {
        String s = null;
        if(this.getTiaraProperty() == null) {
            return null;
        }
        f f0 = new g();  // 初始化器: Lp8/f;-><init>()V
        s s1 = this.getTiaraProperty();
        f0.b = s1 == null ? null : s1.a;
        s s2 = this.getTiaraProperty();
        f0.c = s2 == null ? null : s2.b;
        s s3 = this.getTiaraProperty();
        if(s3 != null) {
            s = s3.c;
        }
        f0.I = s;
        return f0;
    }

    @Override  // com.melon.ui.k1
    public final Object onFetchStart(g1 g10, Continuation continuation0) {
        L0 l00 = this.getProgressUpdater();
        if(l00 == null) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getDefault(), null, new m2(this, null), 2, null);
            return H.a;
        }
        l00.a("FetchViewModel true", true);
        try {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getDefault(), null, new m2(this, null), 2, null);
            return H.a;
        }
        finally {
            l00.a("FetchViewModel false", false);
        }
    }

    @Override  // com.melon.ui.k1
    public final void onUserEvent(e e0) {
        q.g(e0, "userEvent");
        StringProviderImpl stringProviderImpl0 = this.b;
        if(e0 instanceof i2) {
            b2 b20 = ((i2)e0).a;
            Navigator.INSTANCE.openCastEpisodeDetail(b20.a);
            f f0 = this.c();
            if(f0 == null) {
                return;
            }
            Context context0 = this.e;
            if(context0 != null) {
                String s = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                String s1 = stringProviderImpl0.a(0x7F130FB5);  // string:tiara_profile_layer1_each_program "프로그램별"
                String s2 = Y.i(ContsTypeCode.RADIO_CAST, "code(...)");
                b.O(f0, context0, s, s1, ActionKind.ClickContent, null, 0, b20.a, s2, b20.b, null, null, false, 0, 0x1E30);
                return;
            }
            q.m("context");
            throw null;
        }
        if(e0 instanceof k2) {
            Navigator navigator0 = Navigator.INSTANCE;
            b2 b21 = ((k2)e0).a;
            String s3 = b21.a;
            String s4 = this.getMenuId();
            if(s4.length() == 0) {
                s4 = "1000002296";
            }
            navigator0.openStationListen(s3, s4);
            f f1 = this.c();
            if(f1 == null) {
                return;
            }
            Context context1 = this.e;
            if(context1 != null) {
                String s5 = stringProviderImpl0.a(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
                String s6 = stringProviderImpl0.a(0x7F130FB5);  // string:tiara_profile_layer1_each_program "프로그램별"
                String s7 = Y.i(ContsTypeCode.RADIO_CAST, "code(...)");
                b.O(f1, context1, s5, s6, ActionKind.PlayMusic, null, 0, b21.a, s7, b21.b, null, null, false, 0, 0x1E30);
                return;
            }
            q.m("context");
            throw null;
        }
        if(e0 instanceof j2) {
            c2 c20 = ((j2)e0).a;
            Navigator.INSTANCE.openStationProgram(c20.a);
            f f2 = this.c();
            if(f2 != null) {
                Context context2 = this.e;
                if(context2 != null) {
                    String s8 = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    String s9 = stringProviderImpl0.a(0x7F130FB5);  // string:tiara_profile_layer1_each_program "프로그램별"
                    String s10 = stringProviderImpl0.a(0x7F130DB1);  // string:tiara_click_copy_view_all "전체보기"
                    String s11 = Y.i(ContsTypeCode.RADIO_PROGRAM, "code(...)");
                    b.O(f2, context2, s8, s9, ActionKind.ClickContent, s10, 0, c20.a, s11, c20.b, null, null, false, 0, 0x1E20);
                    return;
                }
                q.m("context");
                throw null;
            }
            return;
        }
        super.onUserEvent(e0);
    }
}

