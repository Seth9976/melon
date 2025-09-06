package com.iloen.melon.fragments.artistchannel.viewholder;

import android.view.View;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.fragments.shortform.TrendMusicWaveExclusiveFragment;
import com.iloen.melon.fragments.shortform.TrendMusicWavePopularFragment;
import com.iloen.melon.lyric.LyricsInfo;
import com.iloen.melon.net.v6x.response.ArtistHomeBasicInfoRes.RESPONSE.FANLOUNGELINKINFO;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.player.playlist.PlaylistMainComposablesKt;
import d3.g;
import d5.w;
import d8.d;
import d9.h;
import df.v;
import e1.m;
import e1.x;
import ed.Z.a;
import ed.g0;
import ed.h0;
import gd.E2;
import gd.F5;
import gd.K4;
import gd.M3;
import gd.W5;
import gd.b2;
import gd.c0;
import gd.c2;
import gd.e5;
import gd.f1;
import gd.g8;
import gd.j3;
import gd.j5;
import gd.l8;
import gd.p3;
import gd.r2;
import gd.y0;
import gd.z1;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import pc.b;
import r0.q;
import we.k;
import we.n;

public final class e implements n {
    public final int a;
    public final Object b;
    public final Object c;

    public e(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    public e(Object object0, Object object1, int v, int v1) {
        this.a = v1;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        String s;
        switch(this.a) {
            case 0: {
                return ArtistFanLoungeHolder.onBindView$lambda$3(((ArtistFanLoungeHolder)this.b), ((FANLOUNGELINKINFO)this.c), ((l)object0), ((int)(((Integer)object1))));
            }
            case 1: {
                return ArtistHiRisingHolder.onBindView$lambda$3(((AdapterInViewHolder.Row)this.b), ((ArtistHiRisingHolder)this.c), ((l)object0), ((int)(((Integer)object1))));
            }
            case 2: {
                return ArtistSpotlightHolder.onBindView$lambda$3(((AdapterInViewHolder.Row)this.b), ((ArtistSpotlightHolder)this.c), ((l)object0), ((int)(((Integer)object1))));
            }
            case 3: {
                return TrendMusicWaveExclusiveFragment.q(((View)this.b), ((SLOTLIST)this.c), ((l)object0), ((int)(((Integer)object1))));
            }
            case 4: {
                return TrendMusicWavePopularFragment.n(((SLOTLIST)this.b), ((TrendMusicWavePopularFragment)this.c), ((l)object0), ((int)(((Integer)object1))));
            }
            case 5: {
                ((Integer)object1).getClass();
                PlaylistMainComposablesKt.b(((q)this.b), ((b)this.c), ((l)object0), 7);
                return H.a;
            }
            case 6: {
                h h0 = (h)this.c;
                boolean z = ((Boolean)object1).booleanValue();
                kotlin.jvm.internal.q.g(((List)object0), "lyricsInfoList");
                if(kotlin.jvm.internal.q.b(((Playable)this.b), h0.m)) {
                    h0.j = z;
                    Job job0 = h0.g;
                    if(job0 != null) {
                        DefaultImpls.cancel$default(job0, null, 1, null);
                        h0.c();
                    }
                    if(((List)object0).isEmpty()) {
                        h0.i = false;
                        if(h0.m == null || !h0.m.getIsMusicWaveSong()) {
                            MelonAppBase.Companion.getClass();
                            s = "등록된 가사가 없습니다";
                            kotlin.jvm.internal.q.d("등록된 가사가 없습니다");
                        }
                        else {
                            s = "";
                        }
                        ((List)object0).add(new LyricsInfo(0L, s));
                    }
                    else {
                        h0.i = true;
                    }
                    h0.l = (List)object0;
                    h0.d();
                    h0.k.postValue(((List)object0));
                }
                return H.a;
            }
            case 7: {
                ((Integer)object1).getClass();
                ((a)this.b).o(((g0)this.c), ((l)object0), 1);
                return H.a;
            }
            case 8: {
                ((Integer)object1).getClass();
                ((a)this.b).v(((h0)this.c), ((l)object0), 1);
                return H.a;
            }
            case 9: {
                ((Integer)object1).getClass();
                ((a)this.b).q(((ed.b)this.c), ((l)object0), 1);
                return H.a;
            }
            case 10: {
                ((Integer)object1).getClass();
                ((a)this.b).r(((ArrayList)this.c), ((l)object0), 1);
                return H.a;
            }
            case 11: {
                ((Integer)object1).getClass();
                d5.n.d(((gd.H)this.b), ((k)this.c), ((l)object0), 1);
                return H.a;
            }
            case 12: {
                ((Integer)object1).getClass();
                d.c(((c0)this.b), ((k)this.c), ((l)object0), 1);
                return H.a;
            }
            case 13: {
                ((Integer)object1).getClass();
                v.e(((y0)this.b), ((k)this.c), ((l)object0), 1);
                return H.a;
            }
            case 14: {
                ((Integer)object1).getClass();
                x.i(((f1)this.b), ((k)this.c), ((l)object0), 1);
                return H.a;
            }
            case 15: {
                ((Integer)object1).getClass();
                g.m(((z1)this.b), ((k)this.c), ((l)object0), 1);
                return H.a;
            }
            case 16: {
                ((Integer)object1).getClass();
                w.c(((b2)this.b), ((k)this.c), ((l)object0), 1);
                return H.a;
            }
            case 17: {
                ((Integer)object1).getClass();
                w.d(((c2)this.b), ((k)this.c), ((l)object0), 1);
                return H.a;
            }
            case 18: {
                ((Integer)object1).getClass();
                df.d.b(((r2)this.b), ((k)this.c), ((l)object0), 1);
                return H.a;
            }
            case 19: {
                ((Integer)object1).getClass();
                e1.b.c(((E2)this.b), ((k)this.c), ((l)object0), 1);
                return H.a;
            }
            case 20: {
                ((Integer)object1).getClass();
                x.l(((p3)this.b), ((k)this.c), ((l)object0), 1);
                return H.a;
            }
            case 21: {
                ((Integer)object1).getClass();
                d5.n.g(((M3)this.b), ((k)this.c), ((l)object0), 1);
                return H.a;
            }
            case 22: {
                ((Integer)object1).getClass();
                v.g(((ArrayList)this.b), ((k)this.c), ((l)object0), 1);
                return H.a;
            }
            case 23: {
                ((Integer)object1).getClass();
                m.g(((K4)this.b), ((k)this.c), ((l)object0), 1);
                return H.a;
            }
            case 24: {
                com.melon.ui.K4 k40 = (com.melon.ui.K4)this.b;
                e5 e50 = (e5)this.c;
                int v = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                    boolean z1 = ((p)(((l)object0))).i(e50);
                    j3 j30 = ((p)(((l)object0))).N();
                    if(z1 || j30 == androidx.compose.runtime.k.a) {
                        j3 j31 = new j3(1, e50, e5.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 28);
                        ((p)(((l)object0))).l0(j31);
                        j30 = j31;
                    }
                    x.o(((j5)k40), j30, ((p)(((l)object0))), 0);
                    return H.a;
                }
                ((p)(((l)object0))).T();
                return H.a;
            }
            case 25: {
                ((Integer)object1).getClass();
                x.o(((j5)this.b), ((k)this.c), ((l)object0), 1);
                return H.a;
            }
            case 26: {
                ((Integer)object1).getClass();
                g.o(((F5)this.b), ((k)this.c), ((l)object0), 1);
                return H.a;
            }
            case 27: {
                ((Integer)object1).getClass();
                df.d.f(((W5)this.b), ((k)this.c), ((l)object0), 1);
                return H.a;
            }
            case 28: {
                ((Integer)object1).getClass();
                e2.a.l(((l8)this.b), ((k)this.c), ((l)object0), 1);
                return H.a;
            }
            default: {
                ((Integer)object1).getClass();
                e2.a.j(((g8)this.b), ((k)this.c), ((l)object0), 1);
                return H.a;
            }
        }
    }
}

