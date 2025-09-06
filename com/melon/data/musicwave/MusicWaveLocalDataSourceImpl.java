package com.melon.data.musicwave;

import android.content.Context;
import com.iloen.melon.MusicWavePreference;
import com.iloen.melon.utils.datastore.MusicWaveDataStoreKt;
import d5.n;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import ta.b;
import ta.d;
import ta.e;
import ta.f;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/melon/data/musicwave/MusicWaveLocalDataSourceImpl;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicWaveLocalDataSourceImpl {
    public final Context a;

    @Inject
    public MusicWaveLocalDataSourceImpl(@NotNull Context context0) {
        q.g(context0, "context");
        super();
        this.a = context0;
    }

    public final Object a(c c0) {
        b b0;
        if(c0 instanceof b) {
            b0 = (b)c0;
            int v = b0.B;
            if((v & 0x80000000) == 0) {
                b0 = new b(this, c0);
            }
            else {
                b0.B = v ^ 0x80000000;
            }
        }
        else {
            b0 = new b(this, c0);
        }
        Object object0 = b0.r;
        a a0 = a.a;
        switch(b0.B) {
            case 0: {
                n.D(object0);
                Flow flow0 = MusicWaveDataStoreKt.getMusicWaveDataStore(this.a).getData();
                b0.B = 1;
                object0 = FlowKt.firstOrNull(flow0, b0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return ((MusicWavePreference)object0) != null ? "" : null;
    }

    public final Object b(c c0) {
        ta.c c1;
        if(c0 instanceof ta.c) {
            c1 = (ta.c)c0;
            int v = c1.B;
            if((v & 0x80000000) == 0) {
                c1 = new ta.c(this, c0);
            }
            else {
                c1.B = v ^ 0x80000000;
            }
        }
        else {
            c1 = new ta.c(this, c0);
        }
        Object object0 = c1.r;
        a a0 = a.a;
        switch(c1.B) {
            case 0: {
                n.D(object0);
                Flow flow0 = MusicWaveDataStoreKt.getMusicWaveDataStore(this.a).getData();
                c1.B = 1;
                object0 = FlowKt.firstOrNull(flow0, c1);
                if(object0 == a0) {
                    return a0;
                }
                return ((MusicWavePreference)object0) == null ? new Long(0L) : new Long(((MusicWavePreference)object0).getLastSentChatTime());
            }
            case 1: {
                n.D(object0);
                return ((MusicWavePreference)object0) == null ? new Long(0L) : new Long(((MusicWavePreference)object0).getLastSentChatTime());
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object c(c c0) {
        d d0;
        if(c0 instanceof d) {
            d0 = (d)c0;
            int v = d0.B;
            if((v & 0x80000000) == 0) {
                d0 = new d(this, c0);
            }
            else {
                d0.B = v ^ 0x80000000;
            }
        }
        else {
            d0 = new d(this, c0);
        }
        Object object0 = d0.r;
        a a0 = a.a;
        switch(d0.B) {
            case 0: {
                n.D(object0);
                Flow flow0 = MusicWaveDataStoreKt.getMusicWaveDataStore(this.a).getData();
                d0.B = 1;
                object0 = FlowKt.firstOrNull(flow0, d0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return ((MusicWavePreference)object0) != null ? ((MusicWavePreference)object0).getTempChannel() : null;
    }

    public final Object d(c c0) {
        e e0;
        if(c0 instanceof e) {
            e0 = (e)c0;
            int v = e0.B;
            if((v & 0x80000000) == 0) {
                e0 = new e(this, c0);
            }
            else {
                e0.B = v ^ 0x80000000;
            }
        }
        else {
            e0 = new e(this, c0);
        }
        Object object0 = e0.r;
        a a0 = a.a;
        switch(e0.B) {
            case 0: {
                n.D(object0);
                Flow flow0 = MusicWaveDataStoreKt.getMusicWaveDataStore(this.a).getData();
                e0.B = 1;
                object0 = FlowKt.firstOrNull(flow0, e0);
                if(object0 == a0) {
                    return a0;
                }
                return ((MusicWavePreference)object0) == null ? false : Boolean.valueOf(((MusicWavePreference)object0).getIsNotFirstChat());
            }
            case 1: {
                n.D(object0);
                return ((MusicWavePreference)object0) == null ? false : Boolean.valueOf(((MusicWavePreference)object0).getIsNotFirstChat());
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object e(String s, c c0) {
        f f0;
        if(c0 instanceof f) {
            f0 = (f)c0;
            int v = f0.D;
            if((v & 0x80000000) == 0) {
                f0 = new f(this, c0);
            }
            else {
                f0.D = v ^ 0x80000000;
            }
        }
        else {
            f0 = new f(this, c0);
        }
        Object object0 = f0.w;
        a a0 = a.a;
        switch(f0.D) {
            case 0: {
                n.D(object0);
                Flow flow0 = MusicWaveDataStoreKt.getMusicWaveDataStore(this.a).getData();
                f0.r = s;
                f0.D = 1;
                object0 = FlowKt.firstOrNull(flow0, f0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                s = f0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((MusicWavePreference)object0) != null) {
            List list0 = ((MusicWavePreference)object0).getShownEventsList();
            return list0 == null ? false : Boolean.valueOf(list0.contains(s));
        }
        return false;
    }
}

