package k8;

import Yb.h;
import Yb.j;
import Yb.k;
import Yb.l;
import Yb.m;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.playback.melon.drm.c;
import com.melon.playback.melon.drm.d;
import com.melon.playback.melon.drm.e;
import com.melon.playback.melon.drm.f;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class p1 extends i implements n {
    public final h B;
    public int r;
    public final MusicBrowserActivity w;

    public p1(MusicBrowserActivity musicBrowserActivity0, h h0, Continuation continuation0) {
        this.w = musicBrowserActivity0;
        this.B = h0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new p1(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((p1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        MusicBrowserActivity musicBrowserActivity0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                c c0 = musicBrowserActivity0.getDrmContentsHelper();
                this.r = 1;
                object0 = c0.a(this.B.d, true, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((f)object0) instanceof e) {
            musicBrowserActivity0.getPlayerUseCase().u();
            return H.a;
        }
        if(!(((f)object0) instanceof d)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        m m0 = ((d)(((f)object0))).a;
        if(m0 instanceof l) {
            ToastManager.show("DCF 파일의 재생 기간을 연장하지 못하였습니다.");
            return H.a;
        }
        if(!(m0 instanceof h) && !(m0 instanceof Yb.i) && !(m0 instanceof j) && !(m0 instanceof k)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return H.a;
    }
}

