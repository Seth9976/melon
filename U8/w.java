package U8;

import Bd.m;
import Ma.k;
import Mc.y;
import com.gaudiolab.sol.android.SolMusicOne.SpatialUpmixGenre;
import com.iloen.melon.userstore.MelonDb;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.ui.n0;
import e1.b;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import w9.a;
import y8.f;
import y8.g;
import y8.h;
import y8.l;
import y8.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"LU8/w;", "Lcom/melon/ui/n0;", "<init>", "()V", "Ad/C", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class w extends n0 {
    public final MutableStateFlow a;
    public final MutableStateFlow b;
    public static final int c;

    @Inject
    public w() {
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.a = mutableStateFlow0;
        this.b = mutableStateFlow0;
        this.c();
    }

    public final void b(K k0) {
        q.g(k0, "unit");
        MelonDb melonDb0 = a.a.h();
        if(melonDb0 != null) {
            if(melonDb0.deleteUserEqualizer(k0.b) > 0) {
                ToastManager.show(0x7F13039E);  // string:eq_delete_ok "설정된 EQ가 삭제되었습니다."
            }
            melonDb0.close();
        }
        this.c();
    }

    public final void c() {
        this.updateUiState(new y(26, this, b.F()));
    }

    public final void d() {
        MelonSettingInfo.setGaudioGmasterEnable(false);
        MelonSettingInfo.setGaudioSpatialAudioEnable(false);
        f.h(SpatialUpmixGenre.kOff);
        f.i();
        this.updateUiState(new k(15));
    }

    public static void e(w w0, int v, int v1, int v2) {
        if((v2 & 2) != 0) {
            v1 = -1;
        }
        w0.getClass();
        l.a.f(v, v1, null);
    }

    public final void f() {
        l l0 = l.a;
        y8.k k0 = b.F();
        switch(k0.b) {
            case 6: {
                q.g(k0.e, "values");
                g g0 = f.b();
                g0.c.equalizerBandGainDb = k0.e;
                f.i();
                this.updateUiState(new Mc.q(k0.e, 21));
                break;
            }
            case 7: {
                l.k(l.b().f);
                break;
            }
            case 11: 
            case 12: {
                l.k(p.d);
                h.a(l0, 7, 106, 4);
                break;
            }
            default: {
                l.k(p.d);
                h.a(l0, 7, 106, 4);
            }
        }
        f.i();
        this.updateUiState(new k(13));
    }

    public final void g(boolean z) {
        this.a.setValue(Boolean.valueOf(z));
        this.updateUiState(new s(this, (b.F().b == 6 ? 6 : 7), z));
        if(z) {
            l.g(true);
            this.d();
            this.updateUiState(new m(1, 3));
            return;
        }
        l.d.set(false);
    }

    public final void trackTiaraEventLog(we.k k0) {
        p8.g g0;
        p8.s s0 = this.getTiaraProperty();
        if(s0 == null) {
            g0 = null;
        }
        else {
            g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            g0.b = s0.a;
            g0.c = s0.b;
            g0.I = s0.c;
        }
        if(g0 != null) {
            ((p8.f)k0.invoke(g0)).a().track();
        }
    }
}

