package pc;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.playback.playlist.add.AddRequestPlayableListInfo;
import com.iloen.melon.playback.playlist.add.DefaultMixUpRequestInfo;
import com.iloen.melon.playback.playlist.add.DjMalrangRequestInfo;
import com.iloen.melon.playback.playlist.add.MixUpAddRequestPlayableListInfo;
import com.iloen.melon.playback.playlist.add.MixUpRequestInfo;
import com.iloen.melon.utils.log.LogU;
import com.melon.playlist.mixup.DjMalrangInfo;
import e1.F;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import je.p;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.NonCancellable;
import oc.V;
import oc.W;
import oe.i;
import we.n;

public final class s extends i implements n {
    public final Z B;
    public int r;
    public final V w;

    public s(V v0, Z z0, Continuation continuation0) {
        this.w = v0;
        this.B = z0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new s(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((s)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        List list0;
        b b1;
        a a1;
        ne.a a0 = ne.a.a;
        Z z0 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                V v0 = this.w;
                AddRequestPlayableListInfo addRequestPlayableListInfo0 = v0.c;
                if(!(addRequestPlayableListInfo0 instanceof MixUpAddRequestPlayableListInfo)) {
                    return new W(PlaylistId.MIX_UP, "Invalid AddRequest");
                }
                if(((MixUpAddRequestPlayableListInfo)addRequestPlayableListInfo0).getUserRequestedPlaylist().isEmpty()) {
                    return new W(PlaylistId.MIX_UP, "Empty List");
                }
                LogU.debug$default(z0.d, "add() - " + v0, null, false, 6, null);
                this.r = 1;
                int v1 = z0.j;
                MixUpRequestInfo mixUpRequestInfo0 = ((MixUpAddRequestPlayableListInfo)addRequestPlayableListInfo0).getMixUpRequestInfo();
                c c0 = z0.m().c;
                if(mixUpRequestInfo0 instanceof DefaultMixUpRequestInfo) {
                    a1 = new a(((DefaultMixUpRequestInfo)mixUpRequestInfo0).getMainTitle(), ((DefaultMixUpRequestInfo)mixUpRequestInfo0).getSubTitle(), ((DefaultMixUpRequestInfo)mixUpRequestInfo0).getContsIdForLogging(), ((DefaultMixUpRequestInfo)mixUpRequestInfo0).getMixUpTypeForLogging());
                }
                else {
                    if(!(mixUpRequestInfo0 instanceof DjMalrangRequestInfo)) {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                    if(((DjMalrangRequestInfo)mixUpRequestInfo0).getRequestColorType() != null) {
                        b b0 = ((DjMalrangRequestInfo)mixUpRequestInfo0).getRequestColorType();
                        b.a.getClass();
                        q.g(b0, "currentType");
                        b1 = (b)b.c.get((b0.ordinal() + 1) % b.c.size());
                    }
                    else if(c0 instanceof DjMalrangInfo) {
                        b.a.getClass();
                        q.g(((DjMalrangInfo)c0).i, "currentType");
                        b1 = (b)b.c.get((((DjMalrangInfo)c0).i.ordinal() + 1) % b.c.size());
                    }
                    else {
                        b1 = F.r(b.a);
                    }
                    a1 = new DjMalrangInfo(((DjMalrangRequestInfo)mixUpRequestInfo0).getMainTitle(), ((DjMalrangRequestInfo)mixUpRequestInfo0).getArtistName(), ((DjMalrangRequestInfo)mixUpRequestInfo0).getArtistImg(), ((DjMalrangRequestInfo)mixUpRequestInfo0).getSongTitle(), ((DjMalrangRequestInfo)mixUpRequestInfo0).getPlaylistId(), ((DjMalrangRequestInfo)mixUpRequestInfo0).getPoolId(), ((DjMalrangRequestInfo)mixUpRequestInfo0).getPlaylistType(), ((DjMalrangRequestInfo)mixUpRequestInfo0).getTitleKey(), b1);
                }
                if(v0.b) {
                    HashSet hashSet0 = new HashSet();
                    ArrayList arrayList0 = new ArrayList();
                    for(Object object1: ((MixUpAddRequestPlayableListInfo)addRequestPlayableListInfo0).getUserRequestedPlaylist()) {
                        if(hashSet0.add(new Integer(((Playable)object1).getSongid()))) {
                            arrayList0.add(object1);
                        }
                    }
                    list0 = p.L0(v1, arrayList0);
                }
                else {
                    list0 = p.L0(v1, ((MixUpAddRequestPlayableListInfo)addRequestPlayableListInfo0).getUserRequestedPlaylist());
                }
                M m0 = new M(z0, list0, ((MixUpAddRequestPlayableListInfo)addRequestPlayableListInfo0), a1, null);
                H h0 = BuildersKt.withContext(NonCancellable.INSTANCE, m0, this);
                if(h0 != ne.a.a) {
                    h0 = H.a;
                }
                if(h0 == a0) {
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
        Object object2 = z0.f.getValue();
        ArrayList arrayList1 = e1.b.B(((z0)object2));
        return new oc.Z(PlaylistId.MIX_UP, arrayList1, true, ((z0)object2), z0.g);
    }
}

