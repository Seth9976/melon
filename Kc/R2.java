package kc;

import androidx.appcompat.app.o;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.PlayableAlbumUriData;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import gd.r5;
import ie.H;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import k9.j;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import oe.c;
import we.a;
import z6.f;

public final class r2 {
    public final String a;
    public final CoroutineDispatcher b;
    public final CoroutineDispatcher c;
    public final a d;
    public final LogU e;
    public final ConcurrentHashMap f;

    public r2(String s, a a0, int v) {
        CoroutineDispatcher coroutineDispatcher0 = Dispatchers.getDefault();
        CoroutineDispatcher coroutineDispatcher1 = Dispatchers.getIO();
        if((v & 8) != 0) {
            a0 = new r5(23);
        }
        q.g(coroutineDispatcher0, "defaultDispatcher");
        q.g(coroutineDispatcher1, "ioDispatcher");
        super();
        this.a = s;
        this.b = coroutineDispatcher0;
        this.c = coroutineDispatcher1;
        this.d = a0;
        this.e = Companion.create$default(LogU.Companion, "PlaylistAlbumUriCache - " + s, false, Category.UI, 2, null);
        this.f = new ConcurrentHashMap();
    }

    public final Object a(List list0, String s, c c0) {
        long v2;
        boolean z;
        h2 h20;
        if(c0 instanceof h2) {
            h20 = (h2)c0;
            int v = h20.I;
            if((v & 0x80000000) == 0) {
                h20 = new h2(this, c0);
            }
            else {
                h20.I = v ^ 0x80000000;
            }
        }
        else {
            h20 = new h2(this, c0);
        }
        Object object0 = h20.E;
        ne.a a0 = ne.a.a;
        switch(h20.I) {
            case 0: {
                n.D(object0);
                long v1 = System.currentTimeMillis();
                z = ((Boolean)this.d.invoke()).booleanValue() && j.a() == 5;
                l2 l20 = new l2(list0, this, null, z);
                h20.r = list0;
                h20.w = s;
                h20.B = v1;
                h20.D = z;
                h20.I = 1;
                if(CoroutineScopeKt.coroutineScope(l20, h20) == a0) {
                    return a0;
                }
                v2 = v1;
                break;
            }
            case 1: {
                boolean z1 = h20.D;
                v2 = h20.B;
                s = h20.w;
                List list1 = h20.r;
                n.D(object0);
                z = z1;
                list0 = list1;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        StringBuilder stringBuilder0 = o.t(list0.size(), this.f.size(), "addPlayableList param list size: ", ", albumUriMap total size: ", ", fromCall: ");
        stringBuilder0.append(s);
        stringBuilder0.append(", useOfflineImage: ");
        stringBuilder0.append(z);
        LogConstantsKt.debug(this.e, stringBuilder0.toString(), v2);
        return H.a;
    }

    public final PlayableAlbumUriData b(Playable playable0) {
        q.g(playable0, "playable");
        ConcurrentHashMap concurrentHashMap0 = this.f;
        if(playable0.isOriginLocal()) {
            Object object0 = concurrentHashMap0.getOrDefault(r2.c(playable0), PlayableAlbumUriData.Companion.getEMPTY());
            q.d(object0);
            return (PlayableAlbumUriData)object0;
        }
        Object object1 = concurrentHashMap0.getOrDefault(playable0.getAlbumid(), PlayableAlbumUriData.Companion.getEMPTY());
        q.f(object1, "getOrDefault(...)");
        return (PlayableAlbumUriData)object1;
    }

    // 去混淆评级： 中等(120)
    public static String c(Playable playable0) {
        q.f("", "getDisplayName(...)");
        String s = f.i("", "", "");
        return s == null ? "" : s;
    }

    public final Object d(List list0, c c0) {
        this.f.clear();
        Object object0 = this.a(list0, this.a + ", resetPlayableList", c0);
        return object0 == ne.a.a ? object0 : H.a;
    }

    public final Object e(List list0, String s, c c0) {
        long v2;
        boolean z;
        m2 m20;
        if(c0 instanceof m2) {
            m20 = (m2)c0;
            int v = m20.I;
            if((v & 0x80000000) == 0) {
                m20 = new m2(this, c0);
            }
            else {
                m20.I = v ^ 0x80000000;
            }
        }
        else {
            m20 = new m2(this, c0);
        }
        Object object0 = m20.E;
        ne.a a0 = ne.a.a;
        switch(m20.I) {
            case 0: {
                n.D(object0);
                long v1 = System.currentTimeMillis();
                z = ((Boolean)this.d.invoke()).booleanValue() && j.a() == 5;
                q2 q20 = new q2(list0, this, null, z);
                m20.r = list0;
                m20.w = s;
                m20.B = v1;
                m20.D = z;
                m20.I = 1;
                if(CoroutineScopeKt.coroutineScope(q20, m20) == a0) {
                    return a0;
                }
                v2 = v1;
                break;
            }
            case 1: {
                boolean z1 = m20.D;
                v2 = m20.B;
                s = m20.w;
                List list1 = m20.r;
                n.D(object0);
                z = z1;
                list0 = list1;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        StringBuilder stringBuilder0 = o.t(list0.size(), this.f.size(), "updateAlbumUri param list size = ", ", albumUriMap total size = ", ", fromCall: ");
        stringBuilder0.append(s);
        stringBuilder0.append(", useOfflineImage: ");
        stringBuilder0.append(z);
        LogConstantsKt.debug(this.e, stringBuilder0.toString(), v2);
        return H.a;
    }
}

