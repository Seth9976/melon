package sc;

import Ba.w;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.playback.playlist.smartplaylist.MapperKt;
import com.iloen.melon.utils.system.DeviceIdentifier;
import com.melon.data.service.UpdateTrackListRequest;
import com.melon.net.ApiResult;
import com.melon.net.ApiResultKt;
import ie.H;
import k8.t;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class o2 extends i implements n {
    public String B;
    public String D;
    public int E;
    public final S2 G;
    public final l1 I;
    public final h1 M;
    public final boolean N;
    public w r;
    public String w;

    public o2(S2 s20, l1 l10, h1 h10, boolean z, Continuation continuation0) {
        this.G = s20;
        this.I = l10;
        this.M = h10;
        this.N = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new o2(this.G, this.I, this.M, this.N, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((o2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        String s5;
        w w1;
        String s4;
        String s3;
        a a0 = a.a;
        switch(this.E) {
            case 0: {
                d5.n.D(object0);
                w w0 = this.G.f;
                String s = this.I.b;
                String s1 = this.I.a;
                MelonAppBase.Companion.getClass();
                String s2 = DeviceIdentifier.id(t.a().getDeviceData().a);
                this.r = w0;
                this.w = s;
                this.B = s1;
                this.D = s2;
                this.E = 1;
                object0 = this.G.x(this);
                if(object0 == a0) {
                    return a0;
                }
                s3 = s1;
                s4 = s;
                w1 = w0;
                s5 = s2;
                break;
            }
            case 1: {
                String s6 = this.D;
                String s7 = this.B;
                String s8 = this.w;
                w w2 = this.r;
                d5.n.D(object0);
                w1 = w2;
                s5 = s6;
                s4 = s8;
                s3 = s7;
                break;
            }
            case 2: {
                d5.n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        String s9 = MapperKt.asAddOptionServer(this.M.b).getValue();
        boolean z = MapperKt.asIsDeleteExisting(this.M.d);
        UpdateTrackListRequest updateTrackListRequest0 = new UpdateTrackListRequest(s3, s5, ((Number)object0).longValue(), s9, !this.M.c, z, this.M.a, this.N);
        this.r = null;
        this.w = null;
        this.B = null;
        this.D = null;
        this.E = 2;
        object0 = w1.a(s4, updateTrackListRequest0, this);
        return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
    }
}

