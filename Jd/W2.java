package jd;

import Cb.j;
import Na.f;
import Pc.e;
import androidx.lifecycle.f0;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v6x.response.MusicWaveArtistImageListRes.RESPONSE;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.Meta.Builder;
import com.kakao.tiara.data.Meta;
import com.melon.net.res.common.ResponseBase;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.n0;
import gd.R7;
import hd.h0;
import i.n.i.b.a.s.e.M3;
import kb.D;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import mb.k;
import p8.g;
import p8.s;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Ljd/w2;", "Lcom/melon/ui/n0;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class w2 extends n0 {
    public final D a;
    public final k b;
    public final StringProviderImpl c;
    public boolean d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public static final int j;

    public w2(D d0, k k0, StringProviderImpl stringProviderImpl0) {
        q.g(k0, "loginUseCase");
        super();
        this.a = d0;
        this.b = k0;
        this.c = stringProviderImpl0;
    }

    public static final void b(w2 w20, f f0) {
        w20.getClass();
        switch(f0.getResult().ordinal()) {
            case 0: {
                HttpResponse httpResponse0 = f0.b();
                if(httpResponse0 != null) {
                    j.b(httpResponse0.notification, false, 3);
                    ResponseBase responseBase0 = httpResponse0.getResponse();
                    w20.updateUiState(new R7(18, w20, (responseBase0 instanceof RESPONSE ? ((RESPONSE)responseBase0) : null)));
                }
                return;
            }
            case 1: {
                w20.updateUiState(new h0(20));
                return;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    @Override  // com.melon.ui.n0
    public final void onUserEvent(e e0) {
        q.g(e0, "userEvent");
        String s = null;
        if(e0 instanceof s2) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getDefault(), null, new u2(this, null), 2, null);
            return;
        }
        if(e0 instanceof r2) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getDefault(), null, new v2(this, e0, null), 2, null);
            return;
        }
        if(e0 instanceof t2) {
            s s1 = this.getTiaraProperty();
            StringProviderImpl stringProviderImpl0 = this.c;
            if(s1 == null) {
                this.updateTiaraProperty(stringProviderImpl0.a(0x7F130E54), stringProviderImpl0.a(0x7F130E47), "1000003041");  // string:tiara_common_section_music_wave "뮤직웨이브"
            }
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            s s2 = this.getTiaraProperty();
            g0.b = s2 == null ? null : s2.a;
            s s3 = this.getTiaraProperty();
            g0.c = s3 == null ? null : s3.b;
            s s4 = this.getTiaraProperty();
            if(s4 != null) {
                s = s4.c;
            }
            g0.I = s;
            g0.c0 = new Builder().id(this.g).type(stringProviderImpl0.a(0x7F130E42)).name(this.h).build();  // string:tiara_common_page_meta_type_music_wave "뮤직웨이브"
            ActionKind actionKind0 = ((t2)e0).a;
            if(actionKind0 != null) {
                g0.d = actionKind0;
            }
            String s5 = ((t2)e0).b;
            if(s5 != null) {
                g0.a = s5;
            }
            String s6 = ((t2)e0).c;
            if(s6 != null) {
                g0.y = s6;
            }
            String s7 = ((t2)e0).d;
            if(s7 != null) {
                g0.F = s7;
            }
            Meta meta0 = ((t2)e0).e;
            if(meta0 != null) {
                g0.b0 = meta0;
            }
            g0.a().track();
            return;
        }
        super.onUserEvent(e0);
    }
}

