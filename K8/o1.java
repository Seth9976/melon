package k8;

import Tc.g;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.utils.tab.MainTabConstants.MainBottomTabIconVisibleMode;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.NonCancellable;
import ne.a;
import oe.i;
import we.n;

public final class o1 extends i implements n {
    public int B;
    public int D;
    public int E;
    public int G;
    public int I;
    public final MusicBrowserActivity M;
    public final Z N;
    public Z r;
    public MusicBrowserActivity w;

    public o1(MusicBrowserActivity musicBrowserActivity0, Z z0, Continuation continuation0) {
        this.M = musicBrowserActivity0;
        this.N = z0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new o1(this.M, this.N, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((o1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        int v4;
        int v3;
        Z z1;
        int v2;
        int v1;
        MusicBrowserActivity musicBrowserActivity1;
        a a0 = a.a;
    alab1:
        switch(this.I) {
            case 0: {
                d5.n.D(object0);
                MusicBrowserActivity musicBrowserActivity0 = this.M;
                g g0 = musicBrowserActivity0.getMainBottomTabViewModel();
                Z z0 = this.N;
                Boolean boolean0 = (Boolean)g0.g.get(z0.a);
                if(!(boolean0 == null ? false : boolean0.booleanValue())) {
                    int v = MainBottomTabIconVisibleMode.Companion.getRepeatCount(z0.b);
                    if(v >= 1) {
                        musicBrowserActivity1 = musicBrowserActivity0;
                        v1 = v;
                        v2 = 0;
                        z1 = z0;
                        goto label_43;
                    }
                }
                break;
            }
            case 1: {
                v3 = this.G;
                v4 = this.E;
                v2 = this.D;
                v1 = this.B;
                musicBrowserActivity1 = this.w;
                z1 = this.r;
                d5.n.D(object0);
                goto label_54;
            }
            case 2: {
                v3 = this.G;
                v4 = this.E;
                v2 = this.D;
                v1 = this.B;
                musicBrowserActivity1 = this.w;
                z1 = this.r;
                d5.n.D(object0);
                goto label_65;
            }
            case 3: {
                int v5 = this.D;
                int v6 = this.B;
                MusicBrowserActivity musicBrowserActivity2 = this.w;
                Z z2 = this.r;
                d5.n.D(object0);
                musicBrowserActivity1 = musicBrowserActivity2;
                while(true) {
                    z1 = z2;
                    v1 = v6;
                    if(v1 == 1) {
                        musicBrowserActivity1.getMainBottomTabViewModel().g.put(z1.a, Boolean.TRUE);
                    }
                    v2 = v5 + 1;
                label_43:
                    if(v2 >= v1) {
                        break alab1;
                    }
                    this.r = z1;
                    this.w = musicBrowserActivity1;
                    this.B = v1;
                    this.D = v2;
                    this.E = v2;
                    this.G = 0;
                    this.I = 1;
                    if(DelayKt.delay(5000L, this) != a0) {
                        v3 = 0;
                        v4 = v2;
                    label_54:
                        z1.e.setRotationY(0.0f);
                        z1.f.setRotationY(90.0f);
                        this.r = z1;
                        this.w = musicBrowserActivity1;
                        this.B = v1;
                        this.D = v2;
                        this.E = v4;
                        this.G = v3;
                        this.I = 2;
                        if(Nd.a.a(z1.e, 0.0f, 90.0f, this) == a0) {
                            return a0;
                        }
                    label_65:
                        v5 = v2;
                        v6 = v1;
                        z2 = z1;
                        n1 n10 = new n1(musicBrowserActivity1, z2, null);
                        this.r = z2;
                        this.w = musicBrowserActivity1;
                        this.B = v6;
                        this.D = v5;
                        this.E = v4;
                        this.G = v3;
                        this.I = 3;
                        if(BuildersKt.withContext(NonCancellable.INSTANCE, n10, this) != a0) {
                            continue;
                        }
                    }
                    return a0;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }
}

