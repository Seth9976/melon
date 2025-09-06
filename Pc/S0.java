package pc;

import com.iloen.melon.MixUpPreference.MixUpInfo;
import com.iloen.melon.MixUpPreference;
import com.iloen.melon.b;
import com.melon.playlist.mixup.DjMalrangInfo;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class s0 extends i implements n {
    public Object r;
    public final c w;

    public s0(c c0, Continuation continuation0) {
        this.w = c0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new s0(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((s0)this.create(((MixUpPreference)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        MixUpInfo mixUpPreference$MixUpInfo0;
        MixUpPreference mixUpPreference0 = (MixUpPreference)this.r;
        d5.n.D(object0);
        c c0 = this.w;
        if(c0 instanceof a) {
            b b0 = (b)MixUpPreference.getDefaultInstance().getMixup().toBuilder();
            b0.d();
            ((MixUpInfo)b0.b).setMainTitle(((a)c0).a);
            b0.d();
            ((MixUpInfo)b0.b).setSubTitle(((a)c0).b);
            b0.d();
            ((MixUpInfo)b0.b).setMixType(((a)c0).d);
            b0.d();
            ((MixUpInfo)b0.b).setContsId(((a)c0).c);
            mixUpPreference$MixUpInfo0 = (MixUpInfo)b0.a();
        }
        else if(c0 instanceof DjMalrangInfo) {
            b b1 = (b)MixUpPreference.getDefaultInstance().getMixup().toBuilder();
            b1.d();
            ((MixUpInfo)b1.b).setMainTitle(((DjMalrangInfo)c0).a);
            b1.d();
            ((MixUpInfo)b1.b).setArtistName(((DjMalrangInfo)c0).b);
            b1.d();
            ((MixUpInfo)b1.b).setArtistImg(((DjMalrangInfo)c0).c);
            b1.d();
            ((MixUpInfo)b1.b).setSongTitle(((DjMalrangInfo)c0).d);
            b1.d();
            ((MixUpInfo)b1.b).setColorTypeInt(((DjMalrangInfo)c0).i.ordinal());
            b1.d();
            ((MixUpInfo)b1.b).setPlaylistId(((DjMalrangInfo)c0).e);
            b1.d();
            ((MixUpInfo)b1.b).setPoolId(((DjMalrangInfo)c0).f);
            b1.d();
            ((MixUpInfo)b1.b).setPlaylistType(((DjMalrangInfo)c0).g);
            b1.d();
            ((MixUpInfo)b1.b).setTitleKey(((DjMalrangInfo)c0).h);
            mixUpPreference$MixUpInfo0 = (MixUpInfo)b1.a();
        }
        else {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        com.iloen.melon.a a0 = (com.iloen.melon.a)mixUpPreference0.toBuilder();
        a0.d();
        ((MixUpPreference)a0.b).setMixup(mixUpPreference$MixUpInfo0);
        return a0.a();
    }
}

