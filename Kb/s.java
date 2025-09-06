package kb;

import Na.d;
import Na.e;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v6x.response.MusicWaveArtistCommentListRes;
import com.iloen.melon.net.v6x.response.MusicWaveChannelEventPopupRes;
import com.iloen.melon.net.v6x.response.MusicWaveChannelRes;
import com.iloen.melon.net.v6x.response.MusicWaveChatResponse;
import com.iloen.melon.net.v6x.response.MusicWaveCheerCountRes;
import com.iloen.melon.net.v6x.response.MusicWaveColorListRes;
import com.iloen.melon.net.v6x.response.MusicWaveIsPaidMemberRes.RESPONSE;
import com.iloen.melon.net.v6x.response.MusicWaveIsPaidMemberRes;
import com.iloen.melon.net.v6x.response.MusicWaveNoticeInfoRes;
import com.iloen.melon.net.v6x.response.MusicWavePvLogRes;
import com.iloen.melon.net.v6x.response.MusicWaveSongListRes;
import com.iloen.melon.net.v6x.response.MusicWaveStaticsRes;
import com.iloen.melon.net.v6x.response.MusicWaveUploadImagesRes;
import com.iloen.melon.utils.MenuIdQueue;
import com.iloen.melon.utils.datastore.MusicWaveDataStoreKt;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.AppUtils;
import com.melon.data.musicwave.MusicWaveLocalDataSourceImpl;
import com.melon.data.service.MusicWaveChatRequest;
import com.melon.net.res.common.ResponseBase;
import d5.c;
import d5.n;
import e1.u;
import ie.H;
import java.io.File;
import java.util.List;
import java.util.regex.Pattern;
import k8.t;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.DelayKt;
import mb.k;
import ne.a;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;
import ta.L;
import va.e0;

public final class s {
    public final L a;
    public final k b;
    public final c c;
    public final LogU d;

    public s(L l0, k k0, c c0) {
        q.g(k0, "loginUseCase");
        super();
        this.a = l0;
        this.b = k0;
        this.c = c0;
        LogU logU0 = new LogU("MusicWaveChannelDetailUseCase");
        logU0.setCategory(Category.None);
        logU0.setUseThreadInfo(true);
        this.d = logU0;
    }

    public static final Object a(s s0, String s1, String s2, File file0, String s3, oe.c c0) {
        p p0;
        s0.getClass();
        if(c0 instanceof p) {
            p0 = (p)c0;
            int v = p0.B;
            if((v & 0x80000000) == 0) {
                p0 = new p(s0, c0);
            }
            else {
                p0.B = v ^ 0x80000000;
            }
        }
        else {
            p0 = new p(s0, c0);
        }
        Object object0 = p0.r;
        a a0 = a.a;
        switch(p0.B) {
            case 0: {
                n.D(object0);
                try {
                    MediaType mediaType0 = s3 == null ? null : MediaType.Companion.parse(s3);
                    RequestBody requestBody0 = RequestBody.Companion.create(file0, mediaType0);
                    String s4 = file0.getName();
                    Part multipartBody$Part0 = Part.Companion.createFormData("imgFile", s4, requestBody0);
                    p0.B = 1;
                    object0 = s0.a.y(s1, s2, multipartBody$Part0, p0);
                    if(object0 == a0) {
                        return a0;
                    label_23:
                        n.D(object0);
                    }
                    return ((MusicWaveUploadImagesRes)object0).getImageUrl();
                }
                catch(Exception unused_ex) {
                    break;
                }
            }
            case 1: {
                goto label_23;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return null;
    }

    public final Object b(int v, oe.c c0) {
        kb.a a0;
        if(c0 instanceof kb.a) {
            a0 = (kb.a)c0;
            int v1 = a0.B;
            if((v1 & 0x80000000) == 0) {
                a0 = new kb.a(this, c0);
            }
            else {
                a0.B = v1 ^ 0x80000000;
            }
        }
        else {
            a0 = new kb.a(this, c0);
        }
        Object object0 = a0.r;
        a a1 = a.a;
        switch(a0.B) {
            case 0: {
                n.D(object0);
                try {
                    a0.B = 1;
                    object0 = this.a.a(v, a0);
                    if(object0 == a1) {
                        return a1;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((HttpResponse)object0));
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

    public final Object c(int v, int v1, String s, String s1, oe.c c0) {
        b b0;
        if(c0 instanceof b) {
            b0 = (b)c0;
            int v2 = b0.B;
            if((v2 & 0x80000000) == 0) {
                b0 = new b(this, c0);
            }
            else {
                b0.B = v2 ^ 0x80000000;
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
                try {
                    b0.B = 1;
                    object0 = this.a.e(v, v1, s, s1, b0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((MusicWaveArtistCommentListRes)object0));
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

    public final Object d(String s, String s1, oe.c c0) {
        kb.c c1;
        if(c0 instanceof kb.c) {
            c1 = (kb.c)c0;
            int v = c1.B;
            if((v & 0x80000000) == 0) {
                c1 = new kb.c(this, c0);
            }
            else {
                c1.B = v ^ 0x80000000;
            }
        }
        else {
            c1 = new kb.c(this, c0);
        }
        Object object0 = c1.r;
        a a0 = a.a;
        switch(c1.B) {
            case 0: {
                n.D(object0);
                try {
                    c1.B = 1;
                    object0 = this.a.g(s, s1, c1);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((MusicWaveNoticeInfoRes)object0));
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

    public final Object e(String s, String s1, oe.c c0) {
        kb.d d0;
        if(c0 instanceof kb.d) {
            d0 = (kb.d)c0;
            int v = d0.B;
            if((v & 0x80000000) == 0) {
                d0 = new kb.d(this, c0);
            }
            else {
                d0.B = v ^ 0x80000000;
            }
        }
        else {
            d0 = new kb.d(this, c0);
        }
        Object object0 = d0.r;
        a a0 = a.a;
        switch(d0.B) {
            case 0: {
                n.D(object0);
                try {
                    d0.B = 1;
                    object0 = this.a.h(s, s1, d0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((MusicWaveChannelEventPopupRes)object0));
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

    public final Object f(String s, oe.c c0) {
        kb.e e0;
        if(c0 instanceof kb.e) {
            e0 = (kb.e)c0;
            int v = e0.B;
            if((v & 0x80000000) == 0) {
                e0 = new kb.e(this, c0);
            }
            else {
                e0.B = v ^ 0x80000000;
            }
        }
        else {
            e0 = new kb.e(this, c0);
        }
        Object object0 = e0.r;
        a a0 = a.a;
        switch(e0.B) {
            case 0: {
                n.D(object0);
                try {
                    e0.B = 1;
                    object0 = this.a.j(s, e0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((MusicWaveColorListRes)object0));
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

    public final Enum g(oe.c c0) {
        k k0;
        Enum enum0;
        Object object0;
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
        try {
            object0 = f0.r;
            enum0 = a.a;
            k0 = this.b;
            switch(f0.B) {
                case 0: {
                    goto label_14;
                }
                case 1: {
                    goto label_19;
                }
                case 2: {
                    goto label_27;
                }
            }
        }
        catch(Exception unused_ex) {
            return jd.q.c;
        }
        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
    label_14:
        n.D(object0);
        try {
            f0.B = 1;
            object0 = ((e0)k0).o(f0);
            if(object0 == enum0) {
                return enum0;
            }
            goto label_20;
        label_19:
            n.D(object0);
        label_20:
            if(!((Boolean)object0).booleanValue()) {
                return jd.q.c;
            }
            String s = u.v(((e0)k0).j());
            f0.B = 2;
            object0 = this.a.t(s, f0);
            if(object0 == enum0) {
                return enum0;
            label_27:
                n.D(object0);
            }
            RESPONSE musicWaveIsPaidMemberRes$RESPONSE0 = ((MusicWaveIsPaidMemberRes)object0).getResponse();
            return (musicWaveIsPaidMemberRes$RESPONSE0 == null ? false : q.b(musicWaveIsPaidMemberRes$RESPONSE0.isPaidMember(), Boolean.TRUE)) ? jd.q.b : jd.q.a;
        }
        catch(Exception unused_ex) {
            return jd.q.c;
        }
    }

    public final Object h(String s, String s1, String s2, oe.c c0) {
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
        a a0 = a.a;
        switch(g0.B) {
            case 0: {
                n.D(object0);
                try {
                    g0.B = 1;
                    object0 = this.a.l(s, s1, s2, g0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((MusicWaveStaticsRes)object0));
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

    public final Object i(oe.c c0) {
        h h0;
        if(c0 instanceof h) {
            h0 = (h)c0;
            int v = h0.B;
            if((v & 0x80000000) == 0) {
                h0 = new h(this, c0);
            }
            else {
                h0.B = v ^ 0x80000000;
            }
        }
        else {
            h0 = new h(this, c0);
        }
        Object object0 = h0.r;
        a a0 = a.a;
        switch(h0.B) {
            case 0: {
                n.D(object0);
                try {
                    h0.B = 1;
                    object0 = this.a.n(h0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((MusicWaveChannelRes)object0));
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

    public final Object j(String s, String s1, oe.c c0) {
        a a0;
        Object object0;
        i i0;
        if(c0 instanceof i) {
            i0 = (i)c0;
            int v = i0.V;
            if((v & 0x80000000) == 0) {
                i0 = new i(this, c0);
            }
            else {
                i0.V = v ^ 0x80000000;
            }
        }
        else {
            i0 = new i(this, c0);
        }
        try {
            object0 = i0.S;
            a0 = a.a;
            switch(i0.V) {
                case 0: {
                    goto label_13;
                }
                case 1: {
                    goto label_31;
                }
                case 2: {
                    goto label_45;
                }
                case 3: {
                    goto label_60;
                }
            }
        }
        catch(Exception exception0) {
            return new d(exception0);
        }
        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
    label_13:
        n.D(object0);
        try {
            i0.r = s;
            i0.w = s1;
            i0.B = this;
            int v1 = 0;
            i0.E = 0;
            i0.G = 0;
            i0.I = 0;
            i0.M = 10;
            i0.V = 1;
            object0 = this.a.p(s, s1, null, i0);
            if(object0 == a0) {
                return a0;
            }
            String s2 = s;
            s s3 = this;
            int v2 = 0;
            int v3 = 10;
            int v4 = 0;
            goto label_73;
        label_31:
            v3 = i0.M;
            int v5 = i0.I;
            int v6 = i0.G;
            int v7 = i0.E;
            s s4 = i0.B;
            String s5 = i0.w;
            s2 = i0.r;
            n.D(object0);
            v1 = v5;
            s1 = s5;
            s3 = s4;
            v2 = v7;
            v4 = v6;
            goto label_73;
        label_45:
            long v8 = i0.N;
            v3 = i0.M;
            int v9 = i0.I;
            int v10 = i0.G;
            v2 = i0.E;
            String s6 = i0.D;
            s s7 = i0.B;
            String s8 = i0.w;
            String s9 = i0.r;
            n.D(object0);
            String s10 = s6;
            s3 = s7;
            long v11 = v8;
            String s11 = s8;
            goto label_93;
        label_60:
            v3 = i0.M;
            int v12 = i0.I;
            int v13 = i0.G;
            v2 = i0.E;
            s3 = i0.B;
            String s12 = i0.w;
            String s13 = i0.r;
            n.D(object0);
            int v14 = v13;
            v1 = v12;
            s1 = s12;
            for(s2 = s13; true; s2 = s9) {
                v4 = v14;
            label_73:
                com.iloen.melon.net.v6x.response.MusicWaveSongListRes.RESPONSE musicWaveSongListRes$RESPONSE0 = ((MusicWaveSongListRes)object0).getResponse();
                if(!q.b((musicWaveSongListRes$RESPONSE0 == null ? null : musicWaveSongListRes$RESPONSE0.getStatus()), "retry") || v1 >= v3) {
                    return new e(((MusicWaveSongListRes)object0));
                }
                v11 = 500L;
                s10 = "3514260040";
                i0.r = s2;
                i0.w = s1;
                i0.B = s3;
                i0.D = "3514260040";
                i0.E = v2;
                i0.G = v4;
                i0.I = v1 + 1;
                i0.M = v3;
                i0.N = 500L;
                i0.V = 2;
                if(DelayKt.delay(500L, i0) == a0) {
                    return a0;
                }
                else {
                    s11 = s1;
                    v9 = v1 + 1;
                    v10 = v4;
                    s9 = s2;
                label_93:
                    i0.r = s9;
                    i0.w = s11;
                    i0.B = s3;
                    i0.D = null;
                    i0.E = v2;
                    i0.G = v10;
                    i0.I = v9;
                    i0.M = v3;
                    i0.N = v11;
                    i0.V = 3;
                    object0 = s3.a.p(s9, s11, s10, i0);
                    if(object0 == a0) {
                        return a0;
                    }
                }
                v14 = v10;
                v1 = v9;
                s1 = s11;
            }
        }
        catch(Exception exception0) {
            return new d(exception0);
        }
    }

    public final Object k(String s, String s1, String s2, oe.c c0) {
        j j0;
        if(c0 instanceof j) {
            j0 = (j)c0;
            int v = j0.B;
            if((v & 0x80000000) == 0) {
                j0 = new j(this, c0);
            }
            else {
                j0.B = v ^ 0x80000000;
            }
        }
        else {
            j0 = new j(this, c0);
        }
        Object object0 = j0.r;
        a a0 = a.a;
        switch(j0.B) {
            case 0: {
                n.D(object0);
                try {
                    MelonAppBase.Companion.getClass();
                    MusicWaveChatRequest musicWaveChatRequest0 = new MusicWaveChatRequest(t.a().getMelonCpId(), s2, s1, s, null);
                    j0.B = 1;
                    object0 = this.a.r(musicWaveChatRequest0, j0);
                    if(object0 == a0) {
                        return a0;
                    label_20:
                        n.D(object0);
                    }
                    return new e(((MusicWaveChatResponse)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_20;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public final Object l(String s, oe.c c0) {
        kb.k k0;
        MusicWaveLocalDataSourceImpl musicWaveLocalDataSourceImpl0 = this.a.b;
        if(c0 instanceof kb.k) {
            k0 = (kb.k)c0;
            int v = k0.D;
            if((v & 0x80000000) == 0) {
                k0 = new kb.k(this, c0);
            }
            else {
                k0.D = v ^ 0x80000000;
            }
        }
        else {
            k0 = new kb.k(this, c0);
        }
        Object object0 = k0.w;
        a a0 = a.a;
        switch(k0.D) {
            case 0: {
                n.D(object0);
                k0.r = s;
                k0.D = 1;
                object0 = musicWaveLocalDataSourceImpl0.a(k0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                s = k0.r;
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return true;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(s != null && s.length() != 0 && !q.b(((String)object0), s)) {
            k0.r = null;
            k0.D = 2;
            H h0 = MusicWaveDataStoreKt.getMusicWaveDataStore(musicWaveLocalDataSourceImpl0.a).a(new ta.g(s, null), k0);
            H h1 = H.a;
            if(h0 != a0) {
                h0 = h1;
            }
            if(h0 == a0) {
                h1 = h0;
            }
            return h1 == a0 ? a0 : true;
        }
        return false;
    }

    public static String m(String s, String s1, k k0) {
        MelonAppBase.Companion.getClass();
        MelonAppBase melonAppBase0 = t.a();
        Pattern pattern0 = Pattern.compile("\\@CR1\\@");
        q.f(pattern0, "compile(...)");
        q.g(s, "input");
        String s2 = pattern0.matcher(s).replaceFirst(s1);
        q.f(s2, "replaceFirst(...)");
        Pattern pattern1 = Pattern.compile("\\@CR2\\@");
        q.f(pattern1, "compile(...)");
        String s3 = u.w(((e0)k0).j());
        if(s3 == null) {
            s3 = "";
        }
        String s4 = pattern1.matcher(s2).replaceFirst(s3);
        q.f(s4, "replaceFirst(...)");
        Pattern pattern2 = Pattern.compile("\\@CR3\\@");
        q.f(pattern2, "compile(...)");
        String s5 = melonAppBase0.getMelonCpId();
        q.g(s5, "replacement");
        String s6 = pattern2.matcher(s4).replaceFirst(s5);
        q.f(s6, "replaceFirst(...)");
        Pattern pattern3 = Pattern.compile("\\@CR4\\@");
        q.f(pattern3, "compile(...)");
        String s7 = AppUtils.getVersionName(melonAppBase0.getContext());
        q.g(s7, "replacement");
        String s8 = pattern3.matcher(s6).replaceFirst(s7);
        q.f(s8, "replaceFirst(...)");
        Pattern pattern4 = Pattern.compile("\\@CR5\\@");
        q.f(pattern4, "compile(...)");
        String s9 = pattern4.matcher(s8).replaceFirst("");
        q.f(s9, "replaceFirst(...)");
        return s9;
    }

    public final Object n(String s, String s1, oe.c c0) {
        a a0;
        Object object0;
        l l0;
        if(c0 instanceof l) {
            l0 = (l)c0;
            int v = l0.B;
            if((v & 0x80000000) == 0) {
                l0 = new l(this, c0);
            }
            else {
                l0.B = v ^ 0x80000000;
            }
        }
        else {
            l0 = new l(this, c0);
        }
        try {
            object0 = l0.r;
            a0 = a.a;
            switch(l0.B) {
                case 0: {
                    goto label_15;
                }
                case 1: {
                    goto label_20;
                }
                case 2: {
                    goto label_13;
                }
            }
        }
        catch(Exception exception0) {
            LogU.warn$default(this.d, "requestPVLog() error: " + exception0.getMessage(), null, false, 6, null);
            return H.a;
        }
        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        try {
        label_13:
            n.D(object0);
        }
        catch(Exception exception0) {
            LogU.warn$default(this.d, "requestPVLog() error: " + exception0.getMessage(), null, false, 6, null);
        }
        return H.a;
    label_15:
        n.D(object0);
        try {
            l0.B = 1;
            object0 = this.a.u(s1, s, l0);
            if(object0 == a0) {
                return a0;
            label_20:
                n.D(object0);
            }
            String s2 = ((MusicWavePvLogRes)object0).logging;
            if(!TextUtils.isEmpty(s2)) {
                String s3 = MenuIdQueue.getInstance().peek();
                q.d(s3);
                String s4 = s.m(s2, s3, this.b);
                ResponseBase responseBase0 = ((MusicWavePvLogRes)object0).getResponse();
                if(responseBase0 != null) {
                    eb.q q0 = new eb.q(responseBase0, s4, s3);
                    l0.B = 2;
                    if(this.c.g(q0, l0) == a0) {
                        return a0;
                    }
                }
            }
        }
        catch(Exception exception0) {
            LogU.warn$default(this.d, "requestPVLog() error: " + exception0.getMessage(), null, false, 6, null);
        }
        return H.a;
    }

    public final Object o(String s, String s1, List list0, oe.c c0) {
        m m0;
        if(c0 instanceof m) {
            m0 = (m)c0;
            int v = m0.B;
            if((v & 0x80000000) == 0) {
                m0 = new m(this, c0);
            }
            else {
                m0.B = v ^ 0x80000000;
            }
        }
        else {
            m0 = new m(this, c0);
        }
        Object object0 = m0.r;
        a a0 = a.a;
        switch(m0.B) {
            case 0: {
                n.D(object0);
                try {
                    MelonAppBase.Companion.getClass();
                    MusicWaveChatRequest musicWaveChatRequest0 = new MusicWaveChatRequest(t.a().getMelonCpId(), s1, s, "", list0);
                    m0.B = 1;
                    object0 = this.a.r(musicWaveChatRequest0, m0);
                    if(object0 == a0) {
                        return a0;
                    label_20:
                        n.D(object0);
                    }
                    return new e(((MusicWaveChatResponse)object0));
                }
                catch(Exception exception0) {
                    break;
                }
            }
            case 1: {
                goto label_20;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return new d(exception0);
    }

    public final Object p(String s, String s1, String s2, oe.c c0) {
        kb.n n0;
        if(c0 instanceof kb.n) {
            n0 = (kb.n)c0;
            int v = n0.B;
            if((v & 0x80000000) == 0) {
                n0 = new kb.n(this, c0);
            }
            else {
                n0.B = v ^ 0x80000000;
            }
        }
        else {
            n0 = new kb.n(this, c0);
        }
        Object object0 = n0.r;
        a a0 = a.a;
        switch(n0.B) {
            case 0: {
                n.D(object0);
                try {
                    n0.B = 1;
                    object0 = this.a.w(s, s1, s2, n0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((MusicWaveCheerCountRes)object0));
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

    public final Object q(String s, String s1, oe.c c0) {
        o o0;
        if(c0 instanceof o) {
            o0 = (o)c0;
            int v = o0.B;
            if((v & 0x80000000) == 0) {
                o0 = new o(this, c0);
            }
            else {
                o0.B = v ^ 0x80000000;
            }
        }
        else {
            o0 = new o(this, c0);
        }
        Object object0 = o0.r;
        a a0 = a.a;
        switch(o0.B) {
            case 0: {
                n.D(object0);
                try {
                    o0.B = 1;
                    object0 = this.a.x(s, s1, o0);
                    if(object0 == a0) {
                        return a0;
                    label_18:
                        n.D(object0);
                    }
                    return new e(((HttpResponse)object0));
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

