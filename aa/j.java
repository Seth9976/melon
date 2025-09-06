package Aa;

import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v6x.request.SearchNextTagListReq.ArtistParams;
import com.iloen.melon.net.v6x.request.SearchNextTagListReq.DjTagParams;
import com.iloen.melon.net.v6x.request.SearchNextTagListReq.GenreParams;
import com.iloen.melon.net.v6x.request.SearchNextTagListReq.Menu;
import com.iloen.melon.net.v6x.request.SearchNextTagListReq.Params;
import com.iloen.melon.net.v6x.request.SearchNextTagListReq.PromotionParams;
import com.iloen.melon.net.v6x.response.SearchAutoCompleteContentResponse;
import com.iloen.melon.net.v6x.response.SearchHotKeywordAndMenuListRes;
import com.iloen.melon.net.v6x.response.SearchNextTagListRes;
import com.iloen.melon.net.v6x.response.SearchRecentKeywordGetResponse;
import com.iloen.melon.net.v6x.response.SearchTagListRes;
import com.iloen.melon.utils.system.DeviceIdentifier;
import com.melon.data.service.SearchApi.RecentKeywordBody;
import com.melon.data.service.SearchApi;
import com.melon.net.ApiResult.Failure;
import com.melon.net.ApiResult.Success;
import com.melon.net.ApiResult;
import com.melon.net.res.SearchMainContentRes;
import d5.n;
import e1.u;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.io.Serializable;
import k8.t;
import oe.c;
import va.e0;
import va.o;

public final class j {
    public final a a;

    public j(a a0) {
        this.a = a0;
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
        ne.a a0 = ne.a.a;
        switch(b0.B) {
            case 0: {
                n.D(object0);
                b0.B = 1;
                MelonAppBase.Companion.getClass();
                String s = DeviceIdentifier.id(t.a().getContext());
                String s1 = u.v(((e0)o.a()).j());
                object0 = this.a.a.h(s, s1, b0);
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
        if(((ApiResult)object0) instanceof Success) {
            return H.a;
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }

    public final Serializable b(String s, c c0) {
        Aa.c c1;
        if(c0 instanceof Aa.c) {
            c1 = (Aa.c)c0;
            int v = c1.B;
            if((v & 0x80000000) == 0) {
                c1 = new Aa.c(this, c0);
            }
            else {
                c1.B = v ^ 0x80000000;
            }
        }
        else {
            c1 = new Aa.c(this, c0);
        }
        Object object0 = c1.r;
        Serializable serializable0 = ne.a.a;
        switch(c1.B) {
            case 0: {
                n.D(object0);
                c1.B = 1;
                object0 = this.a.a.i(s, c1);
                if(object0 == serializable0) {
                    return serializable0;
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
        if(((ApiResult)object0) instanceof Success) {
            return (SearchAutoCompleteContentResponse)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
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
        ne.a a0 = ne.a.a;
        switch(d0.B) {
            case 0: {
                n.D(object0);
                d0.B = 1;
                object0 = this.a.a.f(d0);
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
        if(((ApiResult)object0) instanceof Success) {
            return (SearchMainContentRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }

    public final Serializable d(c c0) {
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
        Serializable serializable0 = ne.a.a;
        switch(e0.B) {
            case 0: {
                n.D(object0);
                e0.B = 1;
                object0 = this.a.a.b(e0);
                if(object0 == serializable0) {
                    return serializable0;
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
        if(((ApiResult)object0) instanceof Success) {
            return (SearchHotKeywordAndMenuListRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }

    public final Serializable e(Params searchNextTagListReq$Params0, c c0) {
        Object object1;
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
        Serializable serializable0 = ne.a.a;
        switch(f0.B) {
            case 0: {
                n.D(object0);
                f0.B = 1;
                SearchApi searchApi0 = this.a.a;
                if(searchNextTagListReq$Params0 instanceof ArtistParams) {
                    object1 = searchApi0.g(u.w(((e0)o.a()).j()), ((ArtistParams)searchNextTagListReq$Params0).tagType, ((ArtistParams)searchNextTagListReq$Params0).artistId, ((ArtistParams)searchNextTagListReq$Params0).displayKeyword, f0);
                }
                else if(searchNextTagListReq$Params0 instanceof GenreParams) {
                    object1 = searchApi0.l(u.w(((e0)o.a()).j()), ((GenreParams)searchNextTagListReq$Params0).tagType, ((GenreParams)searchNextTagListReq$Params0).genreTypeGroupName, ((GenreParams)searchNextTagListReq$Params0).genreType, ((GenreParams)searchNextTagListReq$Params0).displayKeyword, f0);
                }
                else if(searchNextTagListReq$Params0 instanceof DjTagParams) {
                    object1 = searchApi0.a(u.w(((e0)o.a()).j()), ((DjTagParams)searchNextTagListReq$Params0).tagType, ((DjTagParams)searchNextTagListReq$Params0).displayKeyword, ((DjTagParams)searchNextTagListReq$Params0).tagSeq, f0);
                }
                else if(searchNextTagListReq$Params0 instanceof PromotionParams) {
                    object1 = searchApi0.k(u.w(((e0)o.a()).j()), ((PromotionParams)searchNextTagListReq$Params0).tagType, ((PromotionParams)searchNextTagListReq$Params0).promotionSeq, f0);
                }
                else {
                    object1 = searchNextTagListReq$Params0 instanceof Menu ? searchApi0.d(u.w(((e0)o.a()).j()), ((Menu)searchNextTagListReq$Params0).tagType, ((Menu)searchNextTagListReq$Params0).displayKeyword, f0) : null;
                }
                object0 = object1;
                if(object0 == serializable0) {
                    return serializable0;
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
        if(((ApiResult)object0) instanceof Success) {
            return (SearchNextTagListRes)((Success)(((ApiResult)object0))).getData();
        }
        if(((ApiResult)object0) instanceof Failure) {
            throw ((Failure)(((ApiResult)object0))).throwCommonException();
        }
        throw new Exception("Unknown error");
    }

    public final Serializable f(c c0) {
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
        Serializable serializable0 = ne.a.a;
        switch(g0.B) {
            case 0: {
                n.D(object0);
                g0.B = 1;
                MelonAppBase.Companion.getClass();
                String s = DeviceIdentifier.id(t.a().getContext());
                String s1 = u.v(((e0)o.a()).j());
                object0 = this.a.a.j(s, s1, g0);
                if(object0 == serializable0) {
                    return serializable0;
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
        if(((ApiResult)object0) instanceof Success) {
            return (SearchRecentKeywordGetResponse)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }

    public final Serializable g(c c0) {
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
        Serializable serializable0 = ne.a.a;
        switch(h0.B) {
            case 0: {
                n.D(object0);
                h0.B = 1;
                String s = u.w(((e0)o.a()).j());
                object0 = this.a.a.e(s, h0);
                if(object0 == serializable0) {
                    return serializable0;
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
        if(((ApiResult)object0) instanceof Success) {
            return (SearchTagListRes)((Success)(((ApiResult)object0))).getData();
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }

    public final Object h(RecentKeywordBody searchApi$RecentKeywordBody0, c c0) {
        i i0;
        if(c0 instanceof i) {
            i0 = (i)c0;
            int v = i0.B;
            if((v & 0x80000000) == 0) {
                i0 = new i(this, c0);
            }
            else {
                i0.B = v ^ 0x80000000;
            }
        }
        else {
            i0 = new i(this, c0);
        }
        Object object0 = i0.r;
        ne.a a0 = ne.a.a;
        switch(i0.B) {
            case 0: {
                n.D(object0);
                i0.B = 1;
                MelonAppBase.Companion.getClass();
                String s = DeviceIdentifier.id(t.a().getContext());
                String s1 = u.v(((e0)o.a()).j());
                object0 = this.a.a.c(s, s1, searchApi$RecentKeywordBody0, i0);
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
        if(((ApiResult)object0) instanceof Success) {
            return H.a;
        }
        if(!(((ApiResult)object0) instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        throw ((Failure)(((ApiResult)object0))).throwCommonException();
    }
}

