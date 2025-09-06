package Vb;

import A8.b;
import F4.a;
import I6.p0;
import android.content.Context;
import android.net.Uri.Builder;
import android.net.Uri;
import android.os.Bundle;
import androidx.media3.common.c;
import b3.A;
import b3.B;
import b3.E;
import b3.G;
import b3.t;
import b3.v;
import b3.w;
import b3.x;
import b3.y;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.constants.CType;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.StorageUtils;
import com.melon.playlist.interfaces.PlayableData;
import d5.f;
import ie.H;
import ie.m;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import k8.Y;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class i0 extends i implements n {
    public final PlayableData r;

    public i0(PlayableData playableData0, Continuation continuation0) {
        this.r = playableData0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new i0(this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((i0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        m m0;
        d5.n.D(object0);
        PlayableData playableData0 = this.r;
        q.g(playableData0, "<this>");
        Uri uri0 = playableData0.n;
        Playable playable0 = playableData0.a;
        boolean z = true;
        if(playable0.isTypeOfLive()) {
            m0 = new m("", 6);
        }
        else {
            m0 = playable0.isTypeOfMv() ? new m("", 6) : new m(playableData0.h, 1);
        }
        String s = (String)m0.a;
        int v = ((Number)m0.b).intValue();
        Uri.Builder uri$Builder0 = new Uri.Builder();
        uri$Builder0.scheme("play");
        uri$Builder0.authority("play.melon.com");
        w w0 = null;
        if(playable0.isTypeOfLive()) {
            if(!b.d() && "".equals("")) {
                throw new IllegalArgumentException("Parameter is empty");
            }
            uri$Builder0.appendQueryParameter("liveSeq", "");
        }
        else {
            if(!playable0.isTypeOfSong() || !StorageUtils.isScopedStorage()) {
                boolean z1 = playable0.isTypeOfMv() && StorageUtils.isScopedStorage();
            }
            if(playable0.isOriginLocal() && false) {
                uri$Builder0.appendQueryParameter("data", "");
            }
        }
        Uri uri1 = uri$Builder0.build();
        q.f(uri1, "build(...)");
        String s1 = uri0.getScheme();
        if(s1 != null) {
            switch(s1.hashCode()) {
                case 0x2FF57C: {
                    if(s1.equals("file")) {
                        Context context0 = Y.a(MelonAppBase.Companion);
                        uri0 = FileUtils.getFileUri(context0, f.V(uri0));
                        context0.grantUriPermission("com.google.android.projection.gearhead", uri0, 1);
                    }
                    break;
                }
                case 951530617: {
                    if(s1.equals("content") && playable0.isTypeOfMv()) {
                        uri0 = Uri.EMPTY;
                    }
                }
            }
        }
        Bundle bundle0 = new Bundle();
        bundle0.putBoolean("targetMusicwave", playable0.getIsMusicWaveSong());
        c c0 = new c();
        c0.c = "";
        c0.d = playableData0.i;
        c0.a = s;
        c0.b = playableData0.i;
        c0.q = Boolean.FALSE;
        c0.r = Boolean.TRUE;
        c0.m = uri0;
        c0.G = v;
        c0.H = bundle0;
        G g0 = new G(c0);
        t t0 = new t();
        a a0 = new a();
        List list0 = Collections.EMPTY_LIST;
        p0 p00 = p0.e;
        x x0 = new x();
        B b0 = B.d;
        CType cType0 = playable0.getCtype() == null ? CType.UNKNOWN : playable0.getCtype();
        q.d(cType0);
        StringBuilder stringBuilder0 = com.iloen.melon.utils.a.n("trackId=", "", "/cType=");
        stringBuilder0.append(cType0.getValue());
        stringBuilder0.append("/contsId=");
        stringBuilder0.append("");
        String s2 = stringBuilder0.toString();
        s2.getClass();
        if(((Uri)a0.e) != null && ((UUID)a0.d) == null) {
            z = false;
        }
        e3.b.j(z);
        if(((UUID)a0.d) != null) {
            w0 = new w(a0);
        }
        A a1 = new A(uri1, null, w0, null, list0, null, p00, 0x8000000000000001L);
        return new E(s2, new v(t0), a1, new y(x0), g0, b0);  // 初始化器: Lb3/u;-><init>(Lb3/t;)V
    }
}

