package jd;

import Na.d;
import Na.e;
import Na.f;
import android.os.Bundle;
import com.iloen.melon.net.v6x.response.MusicWaveChannelRes.RESPONSE.CHANNELINFO;
import com.iloen.melon.net.v6x.response.MusicWaveChannelRes.RESPONSE;
import com.iloen.melon.net.v6x.response.MusicWaveChannelRes;
import com.iloen.melon.utils.Navigator;
import d5.w;
import i.n.i.b.a.s.e.M3;
import ie.H;
import k8.Y;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class k3 extends i implements n {
    public int r;
    public final l3 w;

    public k3(l3 l30, Continuation continuation0) {
        this.w = l30;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new k3(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((k3)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                object0 = this.w.b.i(this);
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
            RESPONSE musicWaveChannelRes$RESPONSE0 = ((MusicWaveChannelRes)((e)(((f)object0))).a).getResponse();
            if(musicWaveChannelRes$RESPONSE0 == null) {
                return H.a;
            }
            CHANNELINFO musicWaveChannelRes$RESPONSE$CHANNELINFO0 = musicWaveChannelRes$RESPONSE0.getChannel();
            if(musicWaveChannelRes$RESPONSE$CHANNELINFO0 == null) {
                return H.a;
            }
            Navigator navigator0 = Navigator.INSTANCE;
            String s = musicWaveChannelRes$RESPONSE$CHANNELINFO0.getType();
            String s1 = "";
            if(s == null) {
                s = "";
            }
            String s2 = musicWaveChannelRes$RESPONSE$CHANNELINFO0.getId();
            if(s2 != null) {
                s1 = s2;
            }
            w.d = false;
            X0 x00 = new X0();
            Bundle bundle0 = Y.c("musicWaveType", s, "musicWaveId", s1);
            bundle0.putString("argOriginMenuId", "1000003041");
            x00.setArguments(bundle0);
            navigator0.open(x00);
            return H.a;
        }
        if(!(((f)object0) instanceof d)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return H.a;
    }
}

