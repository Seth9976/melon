package com.melon.log.data;

import Eb.i;
import Eb.p;
import Gb.a;
import Hb.c;
import Hb.d;
import Hb.e;
import Hb.f;
import Hb.g;
import Hb.h;
import Hb.n;
import android.content.Context;
import com.melon.log.db.LogDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/melon/log/data/LogRepositoryImpl;", "Lcom/melon/log/data/b;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
final class LogRepositoryImpl implements b {
    public final i a;

    public LogRepositoryImpl(@NotNull Context context0) {
        q.g(context0, "context");
        super();
        this.a = (i)LogDatabase.c.h(context0).a.getValue();
    }

    @Override  // com.melon.log.data.b
    public final void a(List list0) {
        i i0 = this.a;
        i0.a(System.currentTimeMillis() - 43200000L);
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
        for(Object object0: list0) {
            arrayList0.add(new p(((a)object0).a, ((a)object0).b, ((a)object0).c.name(), ((a)object0).d, ((a)object0).e, ((a)object0).f.a));
        }
        i0.b(arrayList0);
    }

    @Override  // com.melon.log.data.b
    public final Integer b(long v, long v1) {
        return new Integer(this.a.d(v, v1));
    }

    @Override  // com.melon.log.data.b
    public final ArrayList c(int v, int v1, long v2, long v3) {
        Hb.i i0;
        Iterable iterable0 = this.a.c(v1, v, v2, v3);
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
        for(Object object0: iterable0) {
            long v4 = ((p)object0).b;
            String s = ((p)object0).c;
            n n0 = n.valueOf(((p)object0).d);
            String s1 = ((p)object0).e;
            String s2 = ((p)object0).f;
            q.g(((p)object0).g, "name");
            Locale locale0 = Locale.ROOT;
            String s3 = ((p)object0).g.toLowerCase(locale0);
            q.f(s3, "toLowerCase(...)");
            String s4 = "UI".toLowerCase(locale0);
            q.f(s4, "toLowerCase(...)");
            if(s3.equals(s4)) {
                i0 = Hb.i.b;
            }
            else {
                String s5 = "Playback".toLowerCase(locale0);
                q.f(s5, "toLowerCase(...)");
                if(s3.equals(s5)) {
                    i0 = h.b;
                }
                else {
                    String s6 = "Analytics".toLowerCase(locale0);
                    q.f(s6, "toLowerCase(...)");
                    if(s3.equals(s6)) {
                        i0 = Hb.b.b;
                    }
                    else {
                        String s7 = "LocalSync".toLowerCase(locale0);
                        q.f(s7, "toLowerCase(...)");
                        if(s3.equals(s7)) {
                            i0 = e.b;
                        }
                        else {
                            String s8 = "Download".toLowerCase(locale0);
                            q.f(s8, "toLowerCase(...)");
                            if(s3.equals(s8)) {
                                i0 = c.b;
                            }
                            else {
                                String s9 = "Login".toLowerCase(locale0);
                                q.f(s9, "toLowerCase(...)");
                                if(s3.equals(s9)) {
                                    i0 = f.b;
                                }
                                else {
                                    String s10 = "Http".toLowerCase(locale0);
                                    q.f(s10, "toLowerCase(...)");
                                    i0 = s3.equals(s10) ? d.b : g.b;
                                }
                            }
                        }
                    }
                }
            }
            arrayList0.add(new a(v4, s, n0, s1, s2, i0));
        }
        return arrayList0;
    }
}

