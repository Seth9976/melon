package com.iloen.melon.player.playlist.tiara;

import Pc.d;
import com.iloen.melon.playback.Playable;
import com.kakao.tiara.data.ContentList;
import com.kakao.tiara.data.ViewImpContent;
import com.melon.ui.interfaces.StringProviderImpl;
import d3.g;
import e1.n;
import i.n.i.b.a.s.e.M3;
import ie.r;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import m9.m;
import m9.p;
import od.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.s;
import we.k;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001B2\u00020\u0001:\u0001\u001BBw\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u000E\u0010\u0006\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0016\u0010\n\u001A\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007\u0012\u0016\u0010\u000B\u001A\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007\u0012\u000E\u0010\f\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004\u0012\u0016\u0010\r\u001A\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007¢\u0006\u0004\b\u000E\u0010\u000FJ/\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\t2\b\u0010\u0014\u001A\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001A\u00020\b¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001A\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001A¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/player/playlist/tiara/MixUpPlaylistViewImpLogHelper;", "", "LPc/d;", "stringProvider", "Lkotlin/Function0;", "Lp8/s;", "getTiaraProperty", "Lkotlin/Function1;", "Lcom/iloen/melon/playback/Playable;", "", "getImpressionId", "getImpressionProvider", "getRecmdKey", "getRecmdOfferTimestamp", "<init>", "(LPc/d;Lwe/a;Lwe/k;Lwe/k;Lwe/a;Lwe/k;)V", "", "viewStartTime", "ordNum", "Lod/a;", "area", "playable", "Lie/H;", "putImpLog", "(JLjava/lang/String;Lod/a;Lcom/iloen/melon/playback/Playable;)V", "flush", "()V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MixUpPlaylistViewImpLogHelper {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/player/playlist/tiara/MixUpPlaylistViewImpLogHelper$Companion;", "", "", "THRESHOLD", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[a.values().length];
            try {
                arr_v[0] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[1] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final d a;
    public final we.a b;
    public final k c;
    public final k d;
    public final we.a e;
    public final k f;
    public final ArrayList g;
    public final ArrayList h;
    public final r i;

    static {
        MixUpPlaylistViewImpLogHelper.Companion = new Companion(null);
        MixUpPlaylistViewImpLogHelper.$stable = 8;
    }

    public MixUpPlaylistViewImpLogHelper(@NotNull d d0, @NotNull we.a a0, @NotNull k k0, @NotNull k k1, @NotNull we.a a1, @NotNull k k2) {
        q.g(d0, "stringProvider");
        q.g(a0, "getTiaraProperty");
        q.g(k0, "getImpressionId");
        q.g(k1, "getImpressionProvider");
        q.g(a1, "getRecmdKey");
        q.g(k2, "getRecmdOfferTimestamp");
        super();
        this.a = d0;
        this.b = a0;
        this.c = k0;
        this.d = k1;
        this.e = a1;
        this.f = k2;
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = g.Q(new m9.d(25));
    }

    public final void a() {
        s s0 = (s)this.b.invoke();
        synchronized(this.g) {
            if(!this.g.isEmpty()) {
                ContentList contentList0 = new ContentList();
                for(Object object0: this.g) {
                    contentList0.addContent(((ViewImpContent)object0));
                }
                this.g.clear();
                n.D(new m(this, s0, contentList0, 1)).track();
            }
        }
    }

    public final void b() {
        s s0 = (s)this.b.invoke();
        synchronized(this.h) {
            if(!this.h.isEmpty()) {
                ContentList contentList0 = new ContentList();
                for(Object object0: this.h) {
                    contentList0.addContent(((ViewImpContent)object0));
                }
                this.h.clear();
                n.D(new m(this, s0, contentList0, 0)).track();
            }
        }
    }

    public final String c(int v) {
        return ((StringProviderImpl)this.a).a(v);
    }

    public final void flush() {
        this.a();
        this.b();
    }

    public final void putImpLog(long v, @NotNull String s, @Nullable a a0, @NotNull Playable playable0) {
        q.g(s, "ordNum");
        q.g(playable0, "playable");
        switch((a0 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[a0.ordinal()])) {
            case -1: {
                return;
            }
            case 1: {
                ViewImpContent viewImpContent0 = n.F(new p(this, playable0, v, a0, s, 0));
                synchronized(this.g) {
                    this.g.add(viewImpContent0);
                    if(this.g.size() >= 20) {
                        this.a();
                    }
                }
                return;
            }
            case 2: {
                ViewImpContent viewImpContent1 = n.F(new p(this, playable0, v, a0, s, 1));
                synchronized(this.h) {
                    this.h.add(viewImpContent1);
                    if(this.h.size() >= 20) {
                        this.b();
                    }
                }
                return;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }
}

