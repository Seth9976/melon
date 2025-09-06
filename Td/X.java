package td;

import Ac.l2;
import De.I;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.popup.EqualizerSelectPopup;
import com.iloen.melon.popup.RemoteConnectPopup;
import com.iloen.melon.utils.Navigator;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.track.Event;
import com.melon.ui.playermusic.PlayerViewCalculator;
import ie.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import q8.d;
import q8.h;
import we.a;

public final class x implements a {
    public final int a;
    public final b0 b;

    public x(b0 b00, int v) {
        this.a = v;
        this.b = b00;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                this.b.sendUserEvent(F0.a);
                return H.a;
            }
            case 1: {
                this.b.sendUserEvent(E0.a);
                return H.a;
            }
            case 2: {
                this.b.sendUserEvent(w0.a);
                return H.a;
            }
            case 3: {
                this.b.sendUserEvent(x0.a);
                return H.a;
            }
            case 4: {
                this.b.sendUserEvent(u0.a);
                return H.a;
            }
            case 5: {
                this.b.sendUserEvent(A0.a);
                return H.a;
            }
            case 6: {
                this.b.sendUserEvent(B0.a);
                return H.a;
            }
            case 7: {
                this.b.sendUserEvent(z0.a);
                return H.a;
            }
            case 8: {
                b0 b00 = this.b;
                n0 n00 = b00.p();
                Playable playable0 = (Playable)n00.b.invoke();
                d d0 = new d();  // 初始化器: LQb/h;-><init>()V
                n00.b(d0, ActionKind.ClickContent, playable0);
                ((h)d0.b).a = n00.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                d0.b(new k0(n00, 10));
                d0.e(new f0(13, playable0));
                ((Event)d0.p()).track();
                FragmentActivity fragmentActivity0 = b00.getActivity();
                y y0 = new y(b00, 1);
                if(fragmentActivity0 != null) {
                    b00.dismissRetainedPopup();
                    EqualizerSelectPopup equalizerSelectPopup0 = new EqualizerSelectPopup(fragmentActivity0);
                    equalizerSelectPopup0.setOnDismissListener(new l2(y0, 4));
                    b00.setRetainDialog(equalizerSelectPopup0);
                    equalizerSelectPopup0.show();
                }
                return H.a;
            }
            case 9: {
                n0 n01 = this.b.p();
                Playable playable1 = (Playable)n01.b.invoke();
                d d1 = new d();  // 初始化器: LQb/h;-><init>()V
                n01.b(d1, ActionKind.ClickContent, playable1);
                ((h)d1.b).a = n01.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                d1.b(new k0(n01, 12));
                d1.e(new f0(14, playable1));
                ((Event)d1.p()).track();
                l0 l00 = this.b.getChildFragmentManager();
                q.f(l00, "getChildFragmentManager(...)");
                RemoteConnectPopup remoteConnectPopup0 = RemoteConnectPopup.Companion.newInstance();
                remoteConnectPopup0.setDismissListener(new vd.H(null));
                remoteConnectPopup0.show(l00, "MusicPlayerFragment");
                return H.a;
            }
            case 10: {
                n0 n02 = this.b.p();
                Playable playable2 = (Playable)n02.b.invoke();
                d d2 = new d();  // 初始化器: LQb/h;-><init>()V
                n02.b(d2, ActionKind.ClickContent, playable2);
                ((h)d2.b).a = n02.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                d2.b(new k0(n02, 17));
                d2.e(new f0(19, playable2));
                ((Event)d2.p()).track();
                Navigator.INSTANCE.openNowPlayList();
                return H.a;
            }
            case 11: {
                D d3 = this.b.getViewLifecycleOwner();
                q.f(d3, "getViewLifecycleOwner(...)");
                BuildersKt__Builders_commonKt.launch$default(androidx.lifecycle.f0.f(d3), null, null, new S(this.b, null), 3, null);
                return H.a;
            }
            case 12: {
                this.b.sendUserEvent(t0.a);
                return H.a;
            }
            case 13: {
                I.S(this.b);
                return H.a;
            }
            case 14: {
                this.b.sendUserEvent(r0.a);
                return H.a;
            }
            case 15: {
                this.b.sendUserEvent(v0.a);
                return H.a;
            }
            case 16: {
                Context context0 = this.b.requireContext();
                q.f(context0, "requireContext(...)");
                return new PlayerViewCalculator(context0);
            }
            case 17: {
                b0.o(this.b);
                return H.a;
            }
            default: {
                b0.o(this.b);
                return H.a;
            }
        }
    }
}

