package Rc;

import Mc.H;
import android.content.Context;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.melon.net.res.MusicDnaMainMonthlyLogRes.RESPONSE.ARTISTTOPINFO;
import com.melon.net.res.MusicDnaMainMonthlyLogRes.RESPONSE.SONGTOP3INFO;
import com.melon.net.res.common.SongInfoBase;
import com.melon.ui.K4;
import d9.h;
import java.io.Serializable;
import java.util.List;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import r0.q;
import w8.A;
import w8.m;
import we.a;
import we.k;
import we.n;

public final class w implements n {
    public final int a;
    public final boolean b;
    public final Object c;
    public final Object d;
    public final Object e;

    public w(K4 k40, MutableStateFlow mutableStateFlow0, x x0, boolean z) {
        this.a = 0;
        super();
        this.c = k40;
        this.d = mutableStateFlow0;
        this.e = x0;
        this.b = z;
    }

    public w(Serializable serializable0, Context context0, boolean z, k k0, int v) {
        this.a = v;
        this.c = serializable0;
        this.d = context0;
        this.b = z;
        this.e = k0;
        super();
    }

    public w(Object object0, Object object1, Object object2, boolean z, int v, int v1) {
        this.a = v1;
        this.c = object0;
        this.d = object1;
        this.e = object2;
        this.b = z;
        super();
    }

    public w(List list0, boolean z, n n0, a a0, int v) {
        this.a = 3;
        super();
        this.c = list0;
        this.b = z;
        this.d = n0;
        this.e = a0;
    }

    public w(q q0, h h0, boolean z, k k0, int v) {
        this.a = 6;
        super();
        this.c = q0;
        this.d = h0;
        this.b = z;
        this.e = k0;
    }

    public w(boolean z, String s, String s1, a a0, int v) {
        this.a = 2;
        super();
        this.b = z;
        this.c = s;
        this.d = s1;
        this.e = a0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        String s;
        switch(this.a) {
            case 0: {
                K4 k40 = (K4)this.c;
                MutableStateFlow mutableStateFlow0 = (MutableStateFlow)this.d;
                x x0 = (x)this.e;
                int v = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                    boolean z = ((p)(((l)object0))).i(x0);
                    H h0 = ((p)(((l)object0))).N();
                    if(z || h0 == androidx.compose.runtime.k.a) {
                        h0 = new H(1, x0, x.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 21);
                        ((p)(((l)object0))).l0(h0);
                    }
                    Rc.a.d(((O)k40), mutableStateFlow0, h0, this.b, ((p)(((l)object0))), 0);
                    return ie.H.a;
                }
                ((p)(((l)object0))).T();
                return ie.H.a;
            }
            case 1: {
                ((Integer)object1).getClass();
                Rc.a.d(((O)this.c), ((StateFlow)this.d), ((k)this.e), this.b, ((l)object0), 1);
                return ie.H.a;
            }
            case 2: {
                ((Integer)object1).getClass();
                U8.p.g(this.b, ((String)this.c), ((String)this.d), ((a)this.e), ((l)object0), 0xC01);
                return ie.H.a;
            }
            case 3: {
                ((Integer)object1).getClass();
                U8.p.a(((List)this.c), this.b, ((n)this.d), ((a)this.e), ((l)object0), 1);
                return ie.H.a;
            }
            case 4: {
                SONGTOP3INFO musicDnaMainMonthlyLogRes$RESPONSE$SONGTOP3INFO0 = (SONGTOP3INFO)this.c;
                Context context0 = (Context)this.d;
                k k0 = (k)this.e;
                int v1 = (int)(((Integer)object1));
                boolean z1 = false;
                if(((p)(((l)object0))).Q(v1 & 1, (v1 & 3) != 2)) {
                    SongInfoBase songInfoBase0 = musicDnaMainMonthlyLogRes$RESPONSE$SONGTOP3INFO0.contents;
                    if(songInfoBase0 == null) {
                        s = "";
                    }
                    else {
                        s = songInfoBase0.albumId;
                        if(s == null) {
                            s = "";
                        }
                    }
                    String s1 = musicDnaMainMonthlyLogRes$RESPONSE$SONGTOP3INFO0.title;
                    kotlin.jvm.internal.q.f(s1, "title");
                    String s2 = "";
                    String s3 = musicDnaMainMonthlyLogRes$RESPONSE$SONGTOP3INFO0.bgImg;
                    kotlin.jvm.internal.q.f(s3, "bgImg");
                    String s4 = musicDnaMainMonthlyLogRes$RESPONSE$SONGTOP3INFO0.contents.songName == null ? "" : musicDnaMainMonthlyLogRes$RESPONSE$SONGTOP3INFO0.contents.songName;
                    String s5 = musicDnaMainMonthlyLogRes$RESPONSE$SONGTOP3INFO0.contents.albumImg;
                    if(s5 != null) {
                        s2 = s5;
                    }
                    String s6 = musicDnaMainMonthlyLogRes$RESPONSE$SONGTOP3INFO0.stCnt;
                    kotlin.jvm.internal.q.f(s6, "stCnt");
                    SongInfoBase songInfoBase1 = musicDnaMainMonthlyLogRes$RESPONSE$SONGTOP3INFO0.contents;
                    if(songInfoBase1 != null) {
                        z1 = songInfoBase1.isAdult;
                    }
                    kotlin.jvm.internal.q.f("최다감상곡", "getString(...)");
                    hd.H.u(s, s1, s3, s4, s2, s6, true, z1, true, this.b, 0, "최다감상곡", false, k0, null, ((p)(((l)object0))), 0x6180000, 0x6186, 0);
                    return ie.H.a;
                }
                ((p)(((l)object0))).T();
                return ie.H.a;
            }
            case 5: {
                ARTISTTOPINFO musicDnaMainMonthlyLogRes$RESPONSE$ARTISTTOPINFO0 = (ARTISTTOPINFO)this.c;
                Context context1 = (Context)this.d;
                k k1 = (k)this.e;
                int v2 = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(v2 & 1, (v2 & 3) != 2)) {
                    String s7 = musicDnaMainMonthlyLogRes$RESPONSE$ARTISTTOPINFO0.artistId;
                    String s8 = "";
                    if(s7 == null) {
                        s7 = "";
                    }
                    String s9 = musicDnaMainMonthlyLogRes$RESPONSE$ARTISTTOPINFO0.title == null ? "" : musicDnaMainMonthlyLogRes$RESPONSE$ARTISTTOPINFO0.title;
                    String s10 = musicDnaMainMonthlyLogRes$RESPONSE$ARTISTTOPINFO0.bgImg == null ? "" : musicDnaMainMonthlyLogRes$RESPONSE$ARTISTTOPINFO0.bgImg;
                    String s11 = musicDnaMainMonthlyLogRes$RESPONSE$ARTISTTOPINFO0.artistName == null ? "" : musicDnaMainMonthlyLogRes$RESPONSE$ARTISTTOPINFO0.artistName;
                    String s12 = musicDnaMainMonthlyLogRes$RESPONSE$ARTISTTOPINFO0.artistImg == null ? "" : musicDnaMainMonthlyLogRes$RESPONSE$ARTISTTOPINFO0.artistImg;
                    String s13 = musicDnaMainMonthlyLogRes$RESPONSE$ARTISTTOPINFO0.listenCnt;
                    if(s13 != null) {
                        s8 = s13;
                    }
                    kotlin.jvm.internal.q.f("최다감상아티스트", "getString(...)");
                    hd.H.u(s7, s9, s10, s11, s12, s8, false, false, true, this.b, 0, "최다감상아티스트", false, k1, null, ((p)(((l)object0))), 0x6180000, 0x6186, 0x80);
                    return ie.H.a;
                }
                ((p)(((l)object0))).T();
                return ie.H.a;
            }
            case 6: {
                ((Integer)object1).getClass();
                qd.h.a(((q)this.c), ((h)this.d), this.b, ((k)this.e), ((l)object0), 1);
                return ie.H.a;
            }
            case 7: {
                ((Integer)object1).getClass();
                ((m)this.c).w(((B2.n)this.d), ((String)this.e), this.b, ((l)object0), 1);
                return ie.H.a;
            }
            default: {
                ((Integer)object1).getClass();
                ((A)this.c).w(((B2.n)this.d), ((String)this.e), this.b, ((l)object0), 1);
                return ie.H.a;
            }
        }
    }
}

