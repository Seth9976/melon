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

public final class j2 extends i implements n {
    public String B;
    public int D;
    public final Playable E;
    public final r2 G;
    public final boolean I;
    public ConcurrentHashMap r;
    public Serializable w;

    public j2(Playable playable0, r2 r20, boolean z, Continuation continuation0) {
        this.E = playable0;
        this.G = r20;
        this.I = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new j2(this.E, this.G, this.I, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((j2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        String s;
        r2 r20 = this.G;
        Map map0 = r20.f;
        a a0 = a.a;
        Playable playable0 = this.E;
        switch(this.D) {
            case 0: {
                d5.n.D(object0);
                if(playable0.isOriginLocal()) {
                    i2 i20 = new i2(r20, playable0, null);
                    this.D = 1;
                    object0 = BuildersKt.withContext(r20.c, i20, this);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_22;
                }
                else if(!((ConcurrentHashMap)map0).containsKey("")) {
                    this.r = map0;
                    this.w = "";
                    this.D = 3;
                    object0 = PlayableAlbumExtensionsKt.getAlbumUri(playable0, this.I, this);
                    if(object0 == a0) {
                        return a0;
                    }
                    map0.put("", object0);
                    return H.a;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
            label_22:
                s = (String)object0;
                if(!((ConcurrentHashMap)map0).containsKey(s)) {
                    this.r = null;
                    this.w = map0;
                    this.B = s;
                    this.D = 2;
                    object0 = PlayableAlbumExtensionsKt.getAlbumUri(playable0, false, this);
                    if(object0 == a0) {
                        return a0;
                    }
                    map0.put(s, object0);
                    return H.a;
                }
                break;
            }
            case 2: {
                s = this.B;
                map0 = (Map)this.w;
                String s1 = (String)this.r;
                d5.n.D(object0);
                map0.put(s, object0);
                return H.a;
            }
            case 3: {
                String s2 = (String)this.w;
                map0 = this.r;
                d5.n.D(object0);
                map0.put(s2, object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }
}

