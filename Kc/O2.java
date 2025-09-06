package kc;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.PlayableAlbumExtensionsKt;
import ie.H;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class o2 extends i implements n {
    public String B;
    public int D;
    public final Playable E;
    public final r2 G;
    public final boolean I;
    public ConcurrentHashMap r;
    public Serializable w;

    public o2(Playable playable0, r2 r20, boolean z, Continuation continuation0) {
        this.E = playable0;
        this.G = r20;
        this.I = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new o2(this.E, this.G, this.I, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((o2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        String s2;
        Map map0;
        String s1;
        ConcurrentHashMap concurrentHashMap0;
        a a0 = a.a;
        r2 r20 = this.G;
        Playable playable0 = this.E;
        switch(this.D) {
            case 0: {
                d5.n.D(object0);
                if(playable0.isOriginLocal()) {
                    n2 n20 = new n2(r20, playable0, null);
                    this.D = 1;
                    object0 = BuildersKt.withContext(r20.c, n20, this);
                    if(object0 != a0) {
                        goto label_23;
                    }
                }
                else {
                    concurrentHashMap0 = r20.f;
                    String s = playable0.getAlbumid();
                    this.r = concurrentHashMap0;
                    this.w = s;
                    this.D = 3;
                    Object object1 = PlayableAlbumExtensionsKt.getAlbumUri(playable0, this.I, this);
                    if(object1 != a0) {
                        s1 = s;
                        object0 = object1;
                        break;
                    }
                }
                return a0;
            }
            case 1: {
                d5.n.D(object0);
            label_23:
                map0 = r20.f;
                this.r = null;
                this.w = map0;
                this.B = (String)object0;
                this.D = 2;
                Object object2 = PlayableAlbumExtensionsKt.getAlbumUri(playable0, false, this);
                if(object2 != a0) {
                    s2 = (String)object0;
                    object0 = object2;
                    map0.put(s2, object0);
                    return H.a;
                }
                return a0;
            }
            case 2: {
                s2 = this.B;
                map0 = (Map)this.w;
                String s3 = (String)this.r;
                d5.n.D(object0);
                map0.put(s2, object0);
                return H.a;
            }
            case 3: {
                s1 = (String)this.w;
                concurrentHashMap0 = this.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        concurrentHashMap0.put(s1, object0);
        return H.a;
    }
}

