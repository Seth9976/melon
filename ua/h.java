package Ua;

import Bd.F;
import D4.r;
import G.p;
import G.q;
import G.z0;
import Gf.l;
import Na.d;
import Na.e;
import U4.x;
import W9.a;
import W9.b;
import W9.f;
import Wa.g;
import Wa.s;
import Wa.t;
import Y.Q;
import a1.T;
import androidx.compose.foundation.lazy.layout.K;
import androidx.compose.foundation.lazy.layout.L;
import androidx.compose.foundation.lazy.layout.M;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.w;
import androidx.core.widget.NestedScrollView;
import b3.Z;
import c2.i;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.S0;
import com.iloen.melon.net.v4x.response.AlbumSetGradeRes;
import com.iloen.melon.net.v5x.response.CastCmtExistRes;
import com.iloen.melon.net.v5x.response.CastDetailRes;
import com.iloen.melon.net.v5x.response.CastProgramDetailRes;
import com.iloen.melon.net.v5x.response.CastProgramEpsdRes;
import com.iloen.melon.net.v5x.response.GenreDetailGuiType2Res;
import com.iloen.melon.net.v5x.response.GenreDetailGuiType3Res;
import com.iloen.melon.net.v5x.response.GenreDetailGuiType4Res;
import com.iloen.melon.net.v5x.response.GenreDetailGuiType5Res;
import com.iloen.melon.net.v5x.response.GenreDetailRes;
import com.iloen.melon.net.v5x.response.GenreMenuDtlGnrsRes;
import com.iloen.melon.net.v6x.response.AlbumContentsListRes;
import com.iloen.melon.net.v6x.response.AlbumInfoRes;
import com.iloen.melon.net.v6x.response.AlbumSongListRes;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistInformRes;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistListSongRes;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistPlayListSongRes;
import com.iloen.melon.playback.OnCallStateChangedListener;
import com.iloen.melon.utils.log.LogU;
import com.melon.data.database.MelonDatabase_Impl;
import com.melon.net.ApiResult;
import com.melon.net.ApiResultKt;
import com.melon.net.res.MelonSimplePreviewRes;
import com.melon.playback.manager.CastHelper;
import d5.n;
import e1.u;
import i.n.i.b.a.s.e.Ga;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import k8.Y;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import oe.c;
import va.e0;
import va.o;
import we.k;

public final class h implements i, SessionManagerListener, OnCallStateChangedListener {
    public Object a;

    public h(int v) {
        if(v != 27) {
            super();
            this.a = w.s(Boolean.FALSE);
            return;
        }
        super();
        q q0 = new q(0.0f);
        this.a = new p(z0.a, 0.0f, q0, 0x8000000000000000L, 0x8000000000000000L, false);
    }

    public h(Object object0) {
        this.a = object0;
        super();
    }

    public Object A(c c0) {
        a a0;
        if(c0 instanceof a) {
            a0 = (a)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new a(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new a(this, c0);
        }
        Object object0 = a0.r;
        ne.a a1 = ne.a.a;
        switch(a0.B) {
            case 0: {
                n.D(object0);
                a0.B = 1;
                object0 = ((Ba.c)((h)this.a).a).b(u.w(((e0)o.a()).j()), a0);
                return object0 == a1 ? a1 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object B(c c0) {
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
        ne.a a0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                n.D(object0);
                b0.B = 1;
                object0 = ((Ba.c)((h)this.a).a).e(u.w(((e0)o.a()).j()), b0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object C(c c0) {
        Z9.b b0;
        if(c0 instanceof Z9.b) {
            b0 = (Z9.b)c0;
            int v = b0.B;
            if((v & 0x80000000) == 0) {
                b0 = new Z9.b(this, c0);
            }
            else {
                b0.B = v ^ 0x80000000;
            }
        }
        else {
            b0 = new Z9.b(this, c0);
        }
        Object object0 = b0.r;
        ne.a a0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                n.D(object0);
                b0.B = 1;
                object0 = ((Ba.n)((h)this.a).a).b(String.valueOf(Calendar.getInstance().get(12)), b0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object D(String s, c c0) {
        g g0;
        if(c0 instanceof g) {
            g0 = (g)c0;
            int v = g0.B;
            if((v & 0x80000000) == 0) {
                g0 = new g(this, c0);
            }
            else {
                g0.B = v ^ 0x80000000;
            }
        }
        else {
            g0 = new g(this, c0);
        }
        Object object0 = g0.r;
        ne.a a0 = ne.a.a;
        switch(g0.B) {
            case 0: {
                n.D(object0);
                try {
                    g0.B = 1;
                    object0 = ((S0)this.a).X(s, g0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((MyMusicPlaylistInformRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public Object E(int v, int v1, String s, c c0) {
        Wa.h h0;
        if(c0 instanceof Wa.h) {
            h0 = (Wa.h)c0;
            int v2 = h0.B;
            if((v2 & 0x80000000) == 0) {
                h0 = new Wa.h(this, c0);
            }
            else {
                h0.B = v2 ^ 0x80000000;
            }
        }
        else {
            h0 = new Wa.h(this, c0);
        }
        Object object0 = h0.r;
        ne.a a0 = ne.a.a;
        switch(h0.B) {
            case 0: {
                n.D(object0);
                try {
                    h0.B = 1;
                    object0 = ((S0)this.a).Y(v, v1, s, h0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((MyMusicPlaylistListSongRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public Object F(String s, c c0) {
        Wa.i i0;
        if(c0 instanceof Wa.i) {
            i0 = (Wa.i)c0;
            int v = i0.B;
            if((v & 0x80000000) == 0) {
                i0 = new Wa.i(this, c0);
            }
            else {
                i0.B = v ^ 0x80000000;
            }
        }
        else {
            i0 = new Wa.i(this, c0);
        }
        Object object0 = i0.r;
        ne.a a0 = ne.a.a;
        switch(i0.B) {
            case 0: {
                n.D(object0);
                try {
                    i0.B = 1;
                    object0 = ((S0)this.a).Z(s, i0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((MyMusicPlaylistPlayListSongRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public Object G(c c0) {
        Y9.b b0;
        if(c0 instanceof Y9.b) {
            b0 = (Y9.b)c0;
            int v = b0.B;
            if((v & 0x80000000) == 0) {
                b0 = new Y9.b(this, c0);
            }
            else {
                b0.B = v ^ 0x80000000;
            }
        }
        else {
            b0 = new Y9.b(this, c0);
        }
        Object object0 = b0.r;
        ne.a a0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                n.D(object0);
                b0.B = 1;
                object0 = ((Ba.d)((h)this.a).a).a("1", "30", b0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object H(String s, String s1, String s2, String s3, String s4, String s5, String s6, c c0) {
        W9.c c1;
        if(c0 instanceof W9.c) {
            c1 = (W9.c)c0;
            int v = c1.B;
            if((v & 0x80000000) == 0) {
                c1 = new W9.c(this, c0);
            }
            else {
                c1.B = v ^ 0x80000000;
            }
        }
        else {
            c1 = new W9.c(this, c0);
        }
        Object object0 = c1.r;
        ne.a a0 = ne.a.a;
        switch(c1.B) {
            case 0: {
                n.D(object0);
                c1.B = 1;
                object0 = ((Ba.c)((h)this.a).a).f(s, s1, s2, s3, s4, s5, s6, c1);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object I(String s, String s1, c c0) {
        W9.d d0;
        if(c0 instanceof W9.d) {
            d0 = (W9.d)c0;
            int v = d0.B;
            if((v & 0x80000000) == 0) {
                d0 = new W9.d(this, c0);
            }
            else {
                d0.B = v ^ 0x80000000;
            }
        }
        else {
            d0 = new W9.d(this, c0);
        }
        Object object0 = d0.r;
        ne.a a0 = ne.a.a;
        switch(d0.B) {
            case 0: {
                n.D(object0);
                d0.B = 1;
                object0 = ((Ba.c)((h)this.a).a).g(s, s1, u.w(((e0)o.a()).j()), d0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object J(c c0) {
        W9.e e0;
        if(c0 instanceof W9.e) {
            e0 = (W9.e)c0;
            int v = e0.B;
            if((v & 0x80000000) == 0) {
                e0 = new W9.e(this, c0);
            }
            else {
                e0.B = v ^ 0x80000000;
            }
        }
        else {
            e0 = new W9.e(this, c0);
        }
        Object object0 = e0.r;
        ne.a a0 = ne.a.a;
        switch(e0.B) {
            case 0: {
                n.D(object0);
                e0.B = 1;
                object0 = ((Ba.c)((h)this.a).a).c(u.w(((e0)o.a()).j()), e0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object K(c c0) {
        f f0;
        if(c0 instanceof f) {
            f0 = (f)c0;
            int v = f0.B;
            if((v & 0x80000000) == 0) {
                f0 = new f(this, c0);
            }
            else {
                f0.B = v ^ 0x80000000;
            }
        }
        else {
            f0 = new f(this, c0);
        }
        Object object0 = f0.r;
        ne.a a0 = ne.a.a;
        switch(f0.B) {
            case 0: {
                n.D(object0);
                f0.B = 1;
                object0 = ((Ba.c)((h)this.a).a).d(u.w(((e0)o.a()).j()), f0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object L(int v, String s, int v1, boolean z, c c0) {
        Ua.g g0;
        if(c0 instanceof Ua.g) {
            g0 = (Ua.g)c0;
            int v2 = g0.B;
            if((v2 & 0x80000000) == 0) {
                g0 = new Ua.g(this, c0);
            }
            else {
                g0.B = v2 ^ 0x80000000;
            }
        }
        else {
            g0 = new Ua.g(this, c0);
        }
        Object object0 = g0.r;
        ne.a a0 = ne.a.a;
        switch(g0.B) {
            case 0: {
                n.D(object0);
                g0.B = 1;
                object0 = ((Ba.h)((androidx.lifecycle.b)this.a).b).f(v, s, v1, !z, Z.l(MelonAppBase.Companion), "m.app", g0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public void M() {
    }

    public static l N(I4.b b0) {
        HashMap hashMap0 = new HashMap(2);
        hashMap0.put("work_spec_id", new D4.o(1, "work_spec_id", "TEXT", null, true, 1));
        HashSet hashSet0 = x.q(hashMap0, "prerequisite_id", new D4.o(2, "prerequisite_id", "TEXT", null, true, 1), 2);
        hashSet0.add(new D4.p("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
        hashSet0.add(new D4.p("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"prerequisite_id"}), Arrays.asList(new String[]{"id"})));
        HashSet hashSet1 = new HashSet(2);
        hashSet1.add(new D4.q("index_Dependency_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"ASC"})));
        hashSet1.add(new D4.q("index_Dependency_prerequisite_id", false, Arrays.asList(new String[]{"prerequisite_id"}), Arrays.asList(new String[]{"ASC"})));
        r r0 = new r("Dependency", hashMap0, hashSet0, hashSet1);
        r r1 = r.a(b0, "Dependency");
        if(!r0.equals(r1)) {
            return new l(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + r0 + "\n Found:\n" + r1);
        }
        HashMap hashMap1 = new HashMap(0x20);
        hashMap1.put("id", new D4.o(1, "id", "TEXT", null, true, 1));
        hashMap1.put("state", new D4.o(0, "state", "INTEGER", null, true, 1));
        hashMap1.put("worker_class_name", new D4.o(0, "worker_class_name", "TEXT", null, true, 1));
        hashMap1.put("input_merger_class_name", new D4.o(0, "input_merger_class_name", "TEXT", null, true, 1));
        hashMap1.put("input", new D4.o(0, "input", "BLOB", null, true, 1));
        hashMap1.put("output", new D4.o(0, "output", "BLOB", null, true, 1));
        hashMap1.put("initial_delay", new D4.o(0, "initial_delay", "INTEGER", null, true, 1));
        hashMap1.put("interval_duration", new D4.o(0, "interval_duration", "INTEGER", null, true, 1));
        hashMap1.put("flex_duration", new D4.o(0, "flex_duration", "INTEGER", null, true, 1));
        hashMap1.put("run_attempt_count", new D4.o(0, "run_attempt_count", "INTEGER", null, true, 1));
        hashMap1.put("backoff_policy", new D4.o(0, "backoff_policy", "INTEGER", null, true, 1));
        hashMap1.put("backoff_delay_duration", new D4.o(0, "backoff_delay_duration", "INTEGER", null, true, 1));
        hashMap1.put("last_enqueue_time", new D4.o(0, "last_enqueue_time", "INTEGER", "-1", true, 1));
        hashMap1.put("minimum_retention_duration", new D4.o(0, "minimum_retention_duration", "INTEGER", null, true, 1));
        hashMap1.put("schedule_requested_at", new D4.o(0, "schedule_requested_at", "INTEGER", null, true, 1));
        hashMap1.put("run_in_foreground", new D4.o(0, "run_in_foreground", "INTEGER", null, true, 1));
        hashMap1.put("out_of_quota_policy", new D4.o(0, "out_of_quota_policy", "INTEGER", null, true, 1));
        hashMap1.put("period_count", new D4.o(0, "period_count", "INTEGER", "0", true, 1));
        hashMap1.put("generation", new D4.o(0, "generation", "INTEGER", "0", true, 1));
        hashMap1.put("next_schedule_time_override", new D4.o(0, "next_schedule_time_override", "INTEGER", "9223372036854775807", true, 1));
        hashMap1.put("next_schedule_time_override_generation", new D4.o(0, "next_schedule_time_override_generation", "INTEGER", "0", true, 1));
        hashMap1.put("stop_reason", new D4.o(0, "stop_reason", "INTEGER", "-256", true, 1));
        hashMap1.put("trace_tag", new D4.o(0, "trace_tag", "TEXT", null, false, 1));
        hashMap1.put("required_network_type", new D4.o(0, "required_network_type", "INTEGER", null, true, 1));
        hashMap1.put("required_network_request", new D4.o(0, "required_network_request", "BLOB", "x\'\'", true, 1));
        hashMap1.put("requires_charging", new D4.o(0, "requires_charging", "INTEGER", null, true, 1));
        hashMap1.put("requires_device_idle", new D4.o(0, "requires_device_idle", "INTEGER", null, true, 1));
        hashMap1.put("requires_battery_not_low", new D4.o(0, "requires_battery_not_low", "INTEGER", null, true, 1));
        hashMap1.put("requires_storage_not_low", new D4.o(0, "requires_storage_not_low", "INTEGER", null, true, 1));
        hashMap1.put("trigger_content_update_delay", new D4.o(0, "trigger_content_update_delay", "INTEGER", null, true, 1));
        hashMap1.put("trigger_max_content_delay", new D4.o(0, "trigger_max_content_delay", "INTEGER", null, true, 1));
        HashSet hashSet2 = x.q(hashMap1, "content_uri_triggers", new D4.o(0, "content_uri_triggers", "BLOB", null, true, 1), 0);
        HashSet hashSet3 = new HashSet(2);
        hashSet3.add(new D4.q("index_WorkSpec_schedule_requested_at", false, Arrays.asList(new String[]{"schedule_requested_at"}), Arrays.asList(new String[]{"ASC"})));
        hashSet3.add(new D4.q("index_WorkSpec_last_enqueue_time", false, Arrays.asList(new String[]{"last_enqueue_time"}), Arrays.asList(new String[]{"ASC"})));
        r r2 = new r("WorkSpec", hashMap1, hashSet2, hashSet3);
        r r3 = r.a(b0, "WorkSpec");
        if(!r2.equals(r3)) {
            return new l(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + r2 + "\n Found:\n" + r3);
        }
        HashMap hashMap2 = new HashMap(2);
        hashMap2.put("tag", new D4.o(1, "tag", "TEXT", null, true, 1));
        HashSet hashSet4 = x.q(hashMap2, "work_spec_id", new D4.o(2, "work_spec_id", "TEXT", null, true, 1), 1);
        hashSet4.add(new D4.p("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
        HashSet hashSet5 = new HashSet(1);
        hashSet5.add(new D4.q("index_WorkTag_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"ASC"})));
        r r4 = new r("WorkTag", hashMap2, hashSet4, hashSet5);
        r r5 = r.a(b0, "WorkTag");
        if(!r4.equals(r5)) {
            return new l(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + r4 + "\n Found:\n" + r5);
        }
        HashMap hashMap3 = new HashMap(3);
        hashMap3.put("work_spec_id", new D4.o(1, "work_spec_id", "TEXT", null, true, 1));
        hashMap3.put("generation", new D4.o(2, "generation", "INTEGER", "0", true, 1));
        HashSet hashSet6 = x.q(hashMap3, "system_id", new D4.o(0, "system_id", "INTEGER", null, true, 1), 1);
        hashSet6.add(new D4.p("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
        r r6 = new r("SystemIdInfo", hashMap3, hashSet6, new HashSet(0));
        r r7 = r.a(b0, "SystemIdInfo");
        if(!r6.equals(r7)) {
            return new l(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + r6 + "\n Found:\n" + r7);
        }
        HashMap hashMap4 = new HashMap(2);
        hashMap4.put("name", new D4.o(1, "name", "TEXT", null, true, 1));
        HashSet hashSet7 = x.q(hashMap4, "work_spec_id", new D4.o(2, "work_spec_id", "TEXT", null, true, 1), 1);
        hashSet7.add(new D4.p("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
        HashSet hashSet8 = new HashSet(1);
        hashSet8.add(new D4.q("index_WorkName_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"ASC"})));
        r r8 = new r("WorkName", hashMap4, hashSet7, hashSet8);
        r r9 = r.a(b0, "WorkName");
        if(!r8.equals(r9)) {
            return new l(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + r8 + "\n Found:\n" + r9);
        }
        HashMap hashMap5 = new HashMap(2);
        hashMap5.put("work_spec_id", new D4.o(1, "work_spec_id", "TEXT", null, true, 1));
        HashSet hashSet9 = x.q(hashMap5, "progress", new D4.o(0, "progress", "BLOB", null, true, 1), 1);
        hashSet9.add(new D4.p("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
        r r10 = new r("WorkProgress", hashMap5, hashSet9, new HashSet(0));
        r r11 = r.a(b0, "WorkProgress");
        if(!r10.equals(r11)) {
            return new l(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + r10 + "\n Found:\n" + r11);
        }
        HashMap hashMap6 = new HashMap(2);
        hashMap6.put("key", new D4.o(1, "key", "TEXT", null, true, 1));
        r r12 = new r("Preference", hashMap6, x.q(hashMap6, "long_value", new D4.o(0, "long_value", "INTEGER", null, false, 1), 0), new HashSet(0));
        r r13 = r.a(b0, "Preference");
        return r12.equals(r13) ? new l(true, null) : new l(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + r12 + "\n Found:\n" + r13);
    }

    public Object O(String s, float f, c c0) {
        Wa.d d0;
        if(c0 instanceof Wa.d) {
            d0 = (Wa.d)c0;
            int v = d0.B;
            if((v & 0x80000000) == 0) {
                d0 = new Wa.d(this, c0);
            }
            else {
                d0.B = v ^ 0x80000000;
            }
        }
        else {
            d0 = new Wa.d(this, c0);
        }
        Object object0 = d0.r;
        ne.a a0 = ne.a.a;
        switch(d0.B) {
            case 0: {
                n.D(object0);
                try {
                    d0.B = 1;
                    object0 = ((S0)this.a).i0(s, f, d0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((AlbumSetGradeRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public void P(f1.x x0, long v, boolean z, T7.b b0) {
        Q q0 = (Q)this.a;
        q0.q((T.b(Q.c(q0, x0, v, z, false, b0, false)) ? U.T.c : U.T.b));
    }

    public void Q(float f, r1.c c0, CoroutineScope coroutineScope0) {
        if(f <= c0.Y(M.a)) {
            return;
        }
        p0.h h0 = p0.q.d();
        k k0 = h0 == null ? null : h0.e();
        p0.h h1 = p0.q.e(h0);
        try {
            float f1 = ((Number)((O0)((p)this.a).b).getValue()).floatValue();
            p p0 = (p)this.a;
            if(p0.f) {
                this.a = G.f.k(p0, f1 - f, 0.0f, 30);
                BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new K(this, null), 3, null);
            }
            else {
                this.a = new p(z0.a, ((float)(-f)), null, 60);
                BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new L(this, null), 3, null);
            }
        }
        finally {
            p0.q.g(h0, h1, k0);
        }
    }

    @Override  // c2.i
    public boolean a(float f) {
        if(f == 0.0f) {
            return false;
        }
        this.c();
        ((NestedScrollView)this.a).e(((int)f));
        return true;
    }

    @Override  // c2.i
    public float b() {
        return -((NestedScrollView)this.a).getVerticalScrollFactorCompat();
    }

    @Override  // c2.i
    public void c() {
        ((NestedScrollView)this.a).d.abortAnimation();
    }

    public Object d(int v, String s, int v1, boolean z, c c0) {
        Ua.b b0;
        if(c0 instanceof Ua.b) {
            b0 = (Ua.b)c0;
            int v2 = b0.B;
            if((v2 & 0x80000000) == 0) {
                b0 = new Ua.b(this, c0);
            }
            else {
                b0.B = v2 ^ 0x80000000;
            }
        }
        else {
            b0 = new Ua.b(this, c0);
        }
        Object object0 = b0.r;
        ne.a a0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                n.D(object0);
                b0.B = 1;
                object0 = ((Ba.h)((androidx.lifecycle.b)this.a).b).c(v, s, v1, !z, Z.l(MelonAppBase.Companion), "m.app", b0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public static void e(I4.b b0) {
        b0.u("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        b0.u("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
        b0.u("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
        b0.u("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT NOT NULL, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `last_enqueue_time` INTEGER NOT NULL DEFAULT -1, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `period_count` INTEGER NOT NULL DEFAULT 0, `generation` INTEGER NOT NULL DEFAULT 0, `next_schedule_time_override` INTEGER NOT NULL DEFAULT 9223372036854775807, `next_schedule_time_override_generation` INTEGER NOT NULL DEFAULT 0, `stop_reason` INTEGER NOT NULL DEFAULT -256, `trace_tag` TEXT, `required_network_type` INTEGER NOT NULL, `required_network_request` BLOB NOT NULL DEFAULT x\'\', `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB NOT NULL, PRIMARY KEY(`id`))");
        b0.u("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
        b0.u("CREATE INDEX IF NOT EXISTS `index_WorkSpec_last_enqueue_time` ON `WorkSpec` (`last_enqueue_time`)");
        b0.u("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        b0.u("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
        b0.u("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `generation` INTEGER NOT NULL DEFAULT 0, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`, `generation`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        b0.u("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        b0.u("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
        b0.u("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        b0.u("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
        b0.u("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        b0.u("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \'86254750241babac4b8d52996a675549\')");
    }

    public Integer f(String s, String s1, List list0) {
        ea.a a0 = (ea.a)((h)this.a).a;
        StringBuilder stringBuilder0 = Y.p("delete from banner_popup where member_key = ? AND popup_type = ? AND id in ( ");
        a.a.k(list0.size(), stringBuilder0);
        stringBuilder0.append(" )");
        F f0 = new F(stringBuilder0.toString(), s, s1, list0, 12);
        return new Integer(((int)(((Integer)E9.w.N(((MelonDatabase_Impl)a0.a), false, true, f0)))));
    }

    public Object g(int v, int v1, String s, c c0) {
        Ua.c c1;
        if(c0 instanceof Ua.c) {
            c1 = (Ua.c)c0;
            int v2 = c1.B;
            if((v2 & 0x80000000) == 0) {
                c1 = new Ua.c(this, c0);
            }
            else {
                c1.B = v2 ^ 0x80000000;
            }
        }
        else {
            c1 = new Ua.c(this, c0);
        }
        Object object0 = c1.r;
        ne.a a0 = ne.a.a;
        switch(c1.B) {
            case 0: {
                n.D(object0);
                c1.B = 1;
                object0 = ((Ba.h)((androidx.lifecycle.b)this.a).b).e(v, s, v1, Z.l(MelonAppBase.Companion), "m.app", c1);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object h(String s, c c0) {
        Wa.a a0;
        if(c0 instanceof Wa.a) {
            a0 = (Wa.a)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new Wa.a(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new Wa.a(this, c0);
        }
        Object object0 = a0.r;
        ne.a a1 = ne.a.a;
        switch(a0.B) {
            case 0: {
                n.D(object0);
                try {
                    a0.B = 1;
                    object0 = ((S0)this.a).G(s, a0);
                    if(object0 == a1) {
                        return a1;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((AlbumContentsListRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public Object i(String s, c c0) {
        Wa.b b0;
        if(c0 instanceof Wa.b) {
            b0 = (Wa.b)c0;
            int v = b0.B;
            if((v & 0x80000000) == 0) {
                b0 = new Wa.b(this, c0);
            }
            else {
                b0.B = v ^ 0x80000000;
            }
        }
        else {
            b0 = new Wa.b(this, c0);
        }
        Object object0 = b0.r;
        ne.a a0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                n.D(object0);
                try {
                    b0.B = 1;
                    object0 = ((S0)this.a).H(s, b0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((AlbumInfoRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public Object j(String s, c c0) {
        Wa.c c1;
        if(c0 instanceof Wa.c) {
            c1 = (Wa.c)c0;
            int v = c1.B;
            if((v & 0x80000000) == 0) {
                c1 = new Wa.c(this, c0);
            }
            else {
                c1.B = v ^ 0x80000000;
            }
        }
        else {
            c1 = new Wa.c(this, c0);
        }
        Object object0 = c1.r;
        ne.a a0 = ne.a.a;
        switch(c1.B) {
            case 0: {
                n.D(object0);
                try {
                    c1.B = 1;
                    object0 = ((S0)this.a).I(s, c1);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((AlbumSongListRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public Object k(String s, c c0) {
        Y9.a a0;
        if(c0 instanceof Y9.a) {
            a0 = (Y9.a)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new Y9.a(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new Y9.a(this, c0);
        }
        Object object0 = a0.r;
        ne.a a1 = ne.a.a;
        switch(a0.B) {
            case 0: {
                n.D(object0);
                a0.B = 1;
                object0 = ((Ba.d)((h)this.a).a).c(s, a0);
                return object0 == a1 ? a1 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object l(String s, c c0) {
        Wa.q q0;
        if(c0 instanceof Wa.q) {
            q0 = (Wa.q)c0;
            int v = q0.B;
            if((v & 0x80000000) == 0) {
                q0 = new Wa.q(this, c0);
            }
            else {
                q0.B = v ^ 0x80000000;
            }
        }
        else {
            q0 = new Wa.q(this, c0);
        }
        Object object0 = q0.r;
        ne.a a0 = ne.a.a;
        switch(q0.B) {
            case 0: {
                n.D(object0);
                try {
                    q0.B = 1;
                    object0 = ((E9.g)this.a).k(s, q0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((CastCmtExistRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public Object m(String s, c c0) {
        Wa.r r0;
        if(c0 instanceof Wa.r) {
            r0 = (Wa.r)c0;
            int v = r0.B;
            if((v & 0x80000000) == 0) {
                r0 = new Wa.r(this, c0);
            }
            else {
                r0.B = v ^ 0x80000000;
            }
        }
        else {
            r0 = new Wa.r(this, c0);
        }
        Object object0 = r0.r;
        ne.a a0 = ne.a.a;
        switch(r0.B) {
            case 0: {
                n.D(object0);
                try {
                    r0.B = 1;
                    object0 = ((E9.g)this.a).l(s, r0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((CastDetailRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public Object n(String s, c c0) {
        s s1;
        if(c0 instanceof s) {
            s1 = (s)c0;
            int v = s1.B;
            if((v & 0x80000000) == 0) {
                s1 = new s(this, c0);
            }
            else {
                s1.B = v ^ 0x80000000;
            }
        }
        else {
            s1 = new s(this, c0);
        }
        Object object0 = s1.r;
        ne.a a0 = ne.a.a;
        switch(s1.B) {
            case 0: {
                n.D(object0);
                try {
                    s1.B = 1;
                    object0 = ((E9.g)this.a).m(s, s1);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((CastProgramDetailRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public Object o(int v, int v1, String s, c c0) {
        t t0;
        if(c0 instanceof t) {
            t0 = (t)c0;
            int v2 = t0.B;
            if((v2 & 0x80000000) == 0) {
                t0 = new t(this, c0);
            }
            else {
                t0.B = v2 ^ 0x80000000;
            }
        }
        else {
            t0 = new t(this, c0);
        }
        Object object0 = t0.r;
        ne.a a0 = ne.a.a;
        switch(t0.B) {
            case 0: {
                n.D(object0);
                try {
                    t0.B = 1;
                    object0 = ((E9.g)this.a).n(v, v1, s, t0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((CastProgramEpsdRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    @Override  // com.iloen.melon.playback.OnCallStateChangedListener
    public void onIncomingCallEnded() {
        Ub.c c0 = (Ub.c)this.a;
        LogU.debug$default(c0.d, "OnCallStateChangedListener()#onIncomingCallEnded()", null, false, 6, null);
        if(c0.n && c0.j == 0 && c0.m) {
            c0.b();
        }
    }

    @Override  // com.iloen.melon.playback.OnCallStateChangedListener
    public void onIncomingCallMissed() {
        Ub.c c0 = (Ub.c)this.a;
        LogU.debug$default(c0.d, "OnCallStateChangedListener()#onIncomingCallMissed()", null, false, 6, null);
        if(c0.m) {
            c0.b();
        }
    }

    @Override  // com.iloen.melon.playback.OnCallStateChangedListener
    public void onIncomingCallRinging() {
        Ub.c c0 = (Ub.c)this.a;
        boolean z = c0.h();
        c0.i("OnCallStateChangedListener()#onIncomingCallRinging() isInDoNotDisturb:" + z);
        if(!z) {
            c0.c();
        }
    }

    @Override  // com.iloen.melon.playback.OnCallStateChangedListener
    public void onIncomingCallStarted() {
        Ub.c c0 = (Ub.c)this.a;
        LogU.debug$default(c0.d, "OnCallStateChangedListener()#onIncomingCallStarted()", null, false, 6, null);
        c0.c();
    }

    @Override  // com.iloen.melon.playback.OnCallStateChangedListener
    public void onOutgoingCallEnded() {
        Ub.c c0 = (Ub.c)this.a;
        LogU.debug$default(c0.d, "OnCallStateChangedListener()#onOutgoingCallEnded()", null, false, 6, null);
        if(c0.n && c0.j == 0 && c0.m) {
            c0.b();
        }
    }

    @Override  // com.iloen.melon.playback.OnCallStateChangedListener
    public void onOutgoingCallStarted() {
        Ub.c c0 = (Ub.c)this.a;
        LogU.debug$default(c0.d, "OnCallStateChangedListener()#onOutgoingCallStarted()", null, false, 6, null);
        c0.c();
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionEnded(Session session0, int v) {
        kotlin.jvm.internal.q.g(((CastSession)session0), "session");
        CastHelper castHelper0 = (CastHelper)this.a;
        String s = com.google.firebase.b.r(v);
        LogU.debug$default(castHelper0.b, "onSessionEnded session: " + ((CastSession)session0) + ", error: " + s, null, false, 6, null);
        if(2250 <= v && v < 2300) {
            CastHelper.h(castHelper0, "onSessionEnded", "session ended error: " + com.google.firebase.b.r(v), null, null, 12);
            CastHelper.d(castHelper0, "onSessionEnded");
        }
        castHelper0.o = null;
        Ub.t t0 = castHelper0.p;
        if(t0 != null) {
            hc.g g0 = new hc.g("onSessionEnding");
            t0.i(new hc.i(hc.t.a, g0, hc.c.a));
            we.a a0 = (we.a)castHelper0.g.getAndSet(null);
            if(a0 != null) {
                a0.invoke();
            }
            return;
        }
        kotlin.jvm.internal.q.m("connectionListener");
        throw null;
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionEnding(Session session0) {
        kotlin.jvm.internal.q.g(((CastSession)session0), "session");
        CastHelper castHelper0 = (CastHelper)this.a;
        LogU.debug$default(castHelper0.b, "onSessionEnding session: " + ((CastSession)session0), null, false, 6, null);
        CastHelper.h(castHelper0, "onSessionEnding", "session ending", null, null, 12);
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionResumeFailed(Session session0, int v) {
        kotlin.jvm.internal.q.g(((CastSession)session0), "session");
        CastHelper castHelper0 = (CastHelper)this.a;
        String s = com.google.firebase.b.r(v);
        LogU.debug$default(castHelper0.b, "onSessionStartFailed session: " + ((CastSession)session0) + ", error: " + s, null, false, 6, null);
        CastHelper.h(castHelper0, "onSessionResumeFailed", "session error: " + com.google.firebase.b.r(v), "session failed due to network changed or timeout", null, 8);
        CastHelper.d(castHelper0, "onSessionResumeFailed");
        castHelper0.o = null;
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionResumed(Session session0, boolean z) {
        kotlin.jvm.internal.q.g(((CastSession)session0), "session");
        CastHelper castHelper0 = (CastHelper)this.a;
        LogU.debug$default(castHelper0.b, "onSessionResumed session: " + ((CastSession)session0) + ", wasSuspended: " + z, null, false, 6, null);
        castHelper0.o = new WeakReference(((CastSession)session0));
        CastHelper.h(castHelper0, "onSessionResumed", "session wasSuspended: " + z, null, null, 12);
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionResuming(Session session0, String s) {
        kotlin.jvm.internal.q.g(((CastSession)session0), "session");
        kotlin.jvm.internal.q.g(s, "sessionId");
        CastHelper castHelper0 = (CastHelper)this.a;
        LogU.debug$default(castHelper0.b, "onSessionResuming session: " + ((CastSession)session0) + ", sessionId: " + s, null, false, 6, null);
        CastHelper.h(castHelper0, "onSessionResuming", s, null, null, 12);
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionStartFailed(Session session0, int v) {
        kotlin.jvm.internal.q.g(((CastSession)session0), "session");
        CastHelper castHelper0 = (CastHelper)this.a;
        String s = com.google.firebase.b.r(v);
        LogU.debug$default(castHelper0.b, "onSessionStartFailed session: " + ((CastSession)session0) + ", error: " + s, null, false, 6, null);
        CastHelper.h(castHelper0, "onSessionStartFailed", "session error: " + com.google.firebase.b.r(v), "session failed while connecting or user action", null, 8);
        CastHelper.d(castHelper0, "onSessionStartFailed");
        castHelper0.o = null;
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionStarted(Session session0, String s) {
        kotlin.jvm.internal.q.g(((CastSession)session0), "session");
        kotlin.jvm.internal.q.g(s, "sessionId");
        CastHelper castHelper0 = (CastHelper)this.a;
        LogU.debug$default(castHelper0.b, "onSessionStarted session: " + ((CastSession)session0) + ", sessionId: " + s, null, false, 6, null);
        CastHelper.h(castHelper0, "onSessionStarted", s, null, ((CastSession)session0), 4);
        castHelper0.o = new WeakReference(((CastSession)session0));
        Ub.t t0 = castHelper0.p;
        if(t0 != null) {
            t0.i(new hc.i(hc.t.a, hc.e.a, hc.b.a));
            return;
        }
        kotlin.jvm.internal.q.m("connectionListener");
        throw null;
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionStarting(Session session0) {
        kotlin.jvm.internal.q.g(((CastSession)session0), "session");
        CastHelper castHelper0 = (CastHelper)this.a;
        LogU.debug$default(castHelper0.b, "onSessionStarting session: " + ((CastSession)session0), null, false, 6, null);
        castHelper0.f = "";
        CastHelper.h(castHelper0, "onSessionStarting", "session not yet", null, null, 12);
        Ub.t t0 = castHelper0.p;
        if(t0 != null) {
            t0.i(new hc.i(hc.t.a, hc.f.a, hc.a.a));
            return;
        }
        kotlin.jvm.internal.q.m("connectionListener");
        throw null;
    }

    @Override  // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionSuspended(Session session0, int v) {
        kotlin.jvm.internal.q.g(((CastSession)session0), "session");
        CastHelper castHelper0 = (CastHelper)this.a;
        LogU.debug$default(castHelper0.b, "onSessionSuspended session: " + ((CastSession)session0) + ", reason: " + v, null, false, 6, null);
        castHelper0.g("onSessionSuspended", "session reason: " + v, "connected network changed or instability..", ((CastSession)session0));
    }

    public Object p(int v, String s, Integer integer0, c c0) {
        Ua.d d0;
        if(c0 instanceof Ua.d) {
            d0 = (Ua.d)c0;
            int v1 = d0.B;
            if((v1 & 0x80000000) == 0) {
                d0 = new Ua.d(this, c0);
            }
            else {
                d0.B = v1 ^ 0x80000000;
            }
        }
        else {
            d0 = new Ua.d(this, c0);
        }
        Object object0 = d0.r;
        ne.a a0 = ne.a.a;
        switch(d0.B) {
            case 0: {
                n.D(object0);
                d0.B = 1;
                object0 = ((Ba.h)((androidx.lifecycle.b)this.a).b).d(v, s, a.a.A(integer0), Z.l(MelonAppBase.Companion), "m.app", d0);
                return object0 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object q(int v, String s, Integer integer0, Integer integer1, Integer integer2, Integer integer3, Integer integer4, c c0) {
        Ua.e e0;
        if(c0 instanceof Ua.e) {
            e0 = (Ua.e)c0;
            int v1 = e0.B;
            if((v1 & 0x80000000) == 0) {
                e0 = new Ua.e(this, c0);
            }
            else {
                e0.B = v1 ^ 0x80000000;
            }
        }
        else {
            e0 = new Ua.e(this, c0);
        }
        Object object0 = e0.r;
        ne.a a0 = ne.a.a;
        switch(e0.B) {
            case 0: {
                n.D(object0);
                e0.B = 1;
                Object object1 = ((Ba.h)((androidx.lifecycle.b)this.a).b).b(v, s, null, null, a.a.A(integer0), a.a.A(integer1), a.a.A(integer2), null, a.a.A(integer3), a.a.A(integer4), null, null, 0, Z.l(MelonAppBase.Companion), "m.app", e0);
                return object1 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object1));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object r(int v, String s, c c0, boolean z) {
        Ua.f f0;
        if(c0 instanceof Ua.f) {
            f0 = (Ua.f)c0;
            int v1 = f0.B;
            if((v1 & 0x80000000) == 0) {
                f0 = new Ua.f(this, c0);
            }
            else {
                f0.B = v1 ^ 0x80000000;
            }
        }
        else {
            f0 = new Ua.f(this, c0);
        }
        Object object0 = f0.r;
        ne.a a0 = ne.a.a;
        switch(f0.B) {
            case 0: {
                n.D(object0);
                f0.B = 1;
                Object object1 = ((Ba.h)((androidx.lifecycle.b)this.a).b).a(v, s, null, null, null, null, null, z, null, 0, Z.l(MelonAppBase.Companion), "m.app", f0);
                return object1 == a0 ? a0 : ApiResultKt.getOrThrow(((ApiResult)object1));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object s(String s, c c0) {
        ab.a a0;
        if(c0 instanceof ab.a) {
            a0 = (ab.a)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new ab.a(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new ab.a(this, c0);
        }
        Serializable serializable0 = a0.r;
        ne.a a1 = ne.a.a;
        switch(a0.B) {
            case 0: {
                n.D(serializable0);
                try {
                    a0.B = 1;
                    serializable0 = ((ja.g)this.a).a(s, a0);
                    if(serializable0 == a1) {
                        return a1;
                    label_18:
                        n.D(serializable0);
                    }
                    return new e(((GenreDetailRes)serializable0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public Object t(int v, int v1, String s, String s1, c c0) {
        ab.b b0;
        if(c0 instanceof ab.b) {
            b0 = (ab.b)c0;
            int v2 = b0.B;
            if((v2 & 0x80000000) == 0) {
                b0 = new ab.b(this, c0);
            }
            else {
                b0.B = v2 ^ 0x80000000;
            }
        }
        else {
            b0 = new ab.b(this, c0);
        }
        Serializable serializable0 = b0.r;
        ne.a a0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                n.D(serializable0);
                try {
                    b0.B = 1;
                    serializable0 = ((ja.g)this.a).b(v, v1, s, s1, b0);
                    if(serializable0 == a0) {
                        return a0;
                    label_18:
                        n.D(serializable0);
                    }
                    return new e(((GenreDetailGuiType2Res)serializable0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public Object u(int v, int v1, String s, c c0) {
        ab.c c1;
        if(c0 instanceof ab.c) {
            c1 = (ab.c)c0;
            int v2 = c1.B;
            if((v2 & 0x80000000) == 0) {
                c1 = new ab.c(this, c0);
            }
            else {
                c1.B = v2 ^ 0x80000000;
            }
        }
        else {
            c1 = new ab.c(this, c0);
        }
        Serializable serializable0 = c1.r;
        ne.a a0 = ne.a.a;
        switch(c1.B) {
            case 0: {
                n.D(serializable0);
                try {
                    c1.B = 1;
                    serializable0 = ((ja.g)this.a).c(v, v1, s, c1);
                    if(serializable0 == a0) {
                        return a0;
                    label_18:
                        n.D(serializable0);
                    }
                    return new e(((GenreDetailGuiType3Res)serializable0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public Object v(int v, int v1, String s, String s1, c c0) {
        ab.d d0;
        if(c0 instanceof ab.d) {
            d0 = (ab.d)c0;
            int v2 = d0.B;
            if((v2 & 0x80000000) == 0) {
                d0 = new ab.d(this, c0);
            }
            else {
                d0.B = v2 ^ 0x80000000;
            }
        }
        else {
            d0 = new ab.d(this, c0);
        }
        Serializable serializable0 = d0.r;
        ne.a a0 = ne.a.a;
        switch(d0.B) {
            case 0: {
                n.D(serializable0);
                try {
                    d0.B = 1;
                    serializable0 = ((ja.g)this.a).d(v, v1, s, s1, d0);
                    if(serializable0 == a0) {
                        return a0;
                    label_18:
                        n.D(serializable0);
                    }
                    return new e(((GenreDetailGuiType4Res)serializable0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public Object w(String s, c c0) {
        ab.e e0;
        if(c0 instanceof ab.e) {
            e0 = (ab.e)c0;
            int v = e0.B;
            if((v & 0x80000000) == 0) {
                e0 = new ab.e(this, c0);
            }
            else {
                e0.B = v ^ 0x80000000;
            }
        }
        else {
            e0 = new ab.e(this, c0);
        }
        Serializable serializable0 = e0.r;
        ne.a a0 = ne.a.a;
        switch(e0.B) {
            case 0: {
                n.D(serializable0);
                try {
                    e0.B = 1;
                    serializable0 = ((ja.g)this.a).e(s, e0);
                    if(serializable0 == a0) {
                        return a0;
                    label_18:
                        n.D(serializable0);
                    }
                    return new e(((GenreDetailGuiType5Res)serializable0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public Object x(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, c c0) {
        Xa.a a0;
        if(c0 instanceof Xa.a) {
            a0 = (Xa.a)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new Xa.a(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new Xa.a(this, c0);
        }
        Object object0 = a0.r;
        ne.a a1 = ne.a.a;
        switch(a0.B) {
            case 0: {
                n.D(object0);
                try {
                    a0.B = 1;
                    object0 = ((Ga)this.a).e(s, s1, s2, s3, s4, s5, s6, s7, a0);
                    if(object0 == a1) {
                        return a1;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((MelonSimplePreviewRes)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public Object y(c c0) {
        Z9.a a0;
        if(c0 instanceof Z9.a) {
            a0 = (Z9.a)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new Z9.a(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new Z9.a(this, c0);
        }
        Object object0 = a0.r;
        ne.a a1 = ne.a.a;
        switch(a0.B) {
            case 0: {
                n.D(object0);
                a0.B = 1;
                object0 = ((Ba.n)((h)this.a).a).a(String.valueOf(Calendar.getInstance().get(12)), a0);
                return object0 == a1 ? a1 : ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            case 1: {
                n.D(object0);
                return ApiResultKt.getOrThrow(((ApiResult)object0));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public Object z(String s, String s1, c c0) {
        ab.f f0;
        if(c0 instanceof ab.f) {
            f0 = (ab.f)c0;
            int v = f0.B;
            if((v & 0x80000000) == 0) {
                f0 = new ab.f(this, c0);
            }
            else {
                f0.B = v ^ 0x80000000;
            }
        }
        else {
            f0 = new ab.f(this, c0);
        }
        Serializable serializable0 = f0.r;
        ne.a a0 = ne.a.a;
        switch(f0.B) {
            case 0: {
                n.D(serializable0);
                try {
                    f0.B = 1;
                    serializable0 = ((ja.g)this.a).f(s, s1, f0);
                    if(serializable0 == a0) {
                        return a0;
                    label_18:
                        n.D(serializable0);
                    }
                    return new e(((GenreMenuDtlGnrsRes)serializable0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }
}

