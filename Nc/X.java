package nc;

import Na.d;
import Na.e;
import Na.f;
import com.iloen.melon.custom.L0;
import com.iloen.melon.playback.playlist.add.AddRequestPlayableListInfo;
import com.iloen.melon.playback.playlist.add.EmptyAddRequestPlayableListInfo;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.DrawerPlaylist;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import ie.H;
import ie.o;
import k8.Y;
import k8.b;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oc.t;
import oc.u;
import oe.i;
import we.n;

public final class x extends i implements n {
    public u0 B;
    public int D;
    public int E;
    public int G;
    public int I;
    public int M;
    public Object N;
    public final u0 S;
    public final int T;
    public final int V;
    public L0 r;
    public String w;

    public x(u0 u00, int v, int v1, Continuation continuation0) {
        this.S = u00;
        this.T = v;
        this.V = v1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new x(this.S, this.T, this.V, continuation0);
        continuation1.N = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((x)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Object object7;
        Boolean boolean1;
        L0 l02;
        String s2;
        u0 u03;
        int v18;
        int v17;
        int v16;
        int v15;
        Object object6;
        L0 l01;
        String s1;
        Object object5;
        f f0;
        Boolean boolean0;
        u0 u02;
        int v13;
        int v12;
        int v11;
        Object object3;
        int v8;
        int v7;
        Object object2;
        int v6;
        int v5;
        o o0;
        int v4;
        u0 u01;
        int v3;
        int v2;
        Object object1;
        int v1;
        int v;
        String s;
        L0 l00;
        u0 u00;
        CoroutineScope coroutineScope0 = (CoroutineScope)this.N;
        a a0 = a.a;
        switch(this.M) {
            case 0: {
                d5.n.D(object0);
                u00 = this.S;
                CoroutineDispatcher coroutineDispatcher0 = u00.a;
                l00 = u00.c;
                s = "drawer_moveInternal";
                v = this.T;
                v1 = this.V;
                if(l00 == null) {
                    try {
                        w w0 = new w(u00, v, v1, null);
                        this.N = null;
                        this.r = null;
                        this.w = null;
                        this.B = u00;
                        this.D = v;
                        this.E = v1;
                        this.G = 0;
                        this.I = 0;
                        this.M = 1;
                        object1 = BuildersKt.withContext(coroutineDispatcher0, w0, this);
                    }
                    catch(Throwable throwable0) {
                        v2 = v1;
                        v3 = v;
                        u01 = u00;
                        v4 = 0;
                        o0 = d5.n.t(throwable0);
                        v6 = 0;
                        goto label_78;
                    }
                    if(object1 == a0) {
                        return a0;
                    }
                    try {
                        v2 = v1;
                        v3 = v;
                        u01 = u00;
                        v4 = 0;
                        v5 = 0;
                        o0 = (f)object1;
                    }
                    catch(Throwable throwable0) {
                        goto label_76;
                    }
                    v6 = 0;
                    goto label_78;
                }
                ((b)l00).a("drawer_moveInternal true", true);
                try {
                    w w1 = new w(u00, v, v1, null);
                    this.N = null;
                    this.r = l00;
                    this.w = "drawer_moveInternal";
                    this.B = u00;
                    this.D = v;
                    this.E = v1;
                    this.G = 0;
                    this.I = 0;
                    this.M = 4;
                    object2 = BuildersKt.withContext(coroutineDispatcher0, w1, this);
                }
                catch(Throwable throwable1) {
                    v7 = 0;
                    v8 = 0;
                    goto label_145;
                }
                if(object2 == a0) {
                    return a0;
                }
                v7 = 0;
                v8 = 0;
                f0 = (f)object2;
                goto label_146;
            }
            case 1: {
                try {
                    int v9 = this.I;
                    int v10 = this.G;
                    v2 = this.E;
                    v3 = this.D;
                    u01 = this.B;
                    v5 = v9;
                    v4 = v10;
                    d5.n.D(object0);
                    v5 = v9;
                    v4 = v10;
                    o0 = (f)object0;
                }
                catch(Throwable throwable0) {
                label_76:
                    o0 = d5.n.t(throwable0);
                }
                v6 = v5;
            label_78:
                if(o0 instanceof o) {
                    o0 = null;
                }
                if(((f)o0) instanceof e) {
                    try {
                        DrawerPlaylistInfo drawerPlaylistInfo0 = ((C0)u01.h.getValue()).g;
                        q.d(drawerPlaylistInfo0);
                        DrawerPlaylist playDataForSeverContent$DrawerPlaylist0 = new DrawerPlaylist(drawerPlaylistInfo0, drawerPlaylistInfo0.getMenuId(), null);
                        this.N = null;
                        this.r = null;
                        this.w = null;
                        this.B = u01;
                        this.D = v3;
                        this.E = v2;
                        this.G = v4;
                        this.I = v6;
                        this.M = 2;
                        object3 = playDataForSeverContent$DrawerPlaylist0.getPlayableList(this);
                    }
                    catch(Throwable throwable2) {
                        v11 = v2;
                        v12 = v4;
                        v13 = v3;
                        u02 = u01;
                        boolean0 = d5.n.t(throwable2);
                        goto label_120;
                    }
                    if(object3 == a0) {
                        return a0;
                    }
                    try {
                        v11 = v2;
                        v12 = v4;
                        v13 = v3;
                        u02 = u01;
                        boolean0 = Boolean.valueOf(!q.b(((AddRequestPlayableListInfo)object3), EmptyAddRequestPlayableListInfo.INSTANCE));
                        goto label_120;
                    }
                    catch(Throwable throwable2) {
                        goto label_119;
                    }
                }
                return ((f)o0) instanceof d ? new t("Failed to move(UseCaseResult.Error)") : new t("Failed to move");
            }
            case 2: {
                try {
                    v6 = this.I;
                    v12 = this.G;
                    v11 = this.E;
                    v13 = this.D;
                    u02 = this.B;
                    d5.n.D(object0);
                    boolean0 = Boolean.valueOf(!q.b(((AddRequestPlayableListInfo)object0), EmptyAddRequestPlayableListInfo.INSTANCE));
                }
                catch(Throwable throwable2) {
                label_119:
                    boolean0 = d5.n.t(throwable2);
                }
            label_120:
                if(!(boolean0 instanceof o)) {
                    v v14 = new v(u02, v13, v11, null);
                    this.N = null;
                    this.r = null;
                    this.w = null;
                    this.B = null;
                    this.D = v12;
                    this.E = v6;
                    this.M = 3;
                    Object object4 = u02.U("moveInternal", v14, this);
                    return object4 == a0 ? a0 : new u(((C0)object4));
                }
                return new t("Failed to update dsPlyOrderList");
            }
            case 3: {
                d5.n.D(object0);
                return new u(((C0)object0));
            }
            case 4: {
                try {
                    v7 = this.I;
                    v8 = this.G;
                    v1 = this.E;
                    v = this.D;
                    u00 = this.B;
                    s = this.w;
                    l00 = this.r;
                    d5.n.D(object0);
                    object2 = object0;
                    f0 = (f)object2;
                    goto label_146;
                }
                catch(Throwable throwable1) {
                }
                try {
                label_145:
                    f0 = d5.n.t(throwable1);
                label_146:
                    if(f0 instanceof o) {
                        f0 = null;
                    }
                    if(f0 instanceof e) {
                        goto label_155;
                    }
                    else {
                        object5 = f0 instanceof d ? new t("Failed to move(UseCaseResult.Error)") : new t("Failed to move");
                    }
                    goto label_242;
                }
                catch(Throwable throwable3) {
                    s1 = s;
                    l01 = l00;
                    Y.v(s1, " false", l01, false);
                    throw throwable3;
                }
                try {
                label_155:
                    DrawerPlaylistInfo drawerPlaylistInfo1 = ((C0)u00.h.getValue()).g;
                    q.d(drawerPlaylistInfo1);
                    DrawerPlaylist playDataForSeverContent$DrawerPlaylist1 = new DrawerPlaylist(drawerPlaylistInfo1, drawerPlaylistInfo1.getMenuId(), null);
                    this.N = null;
                    this.r = l00;
                    this.w = s;
                    this.B = u00;
                    this.D = v;
                    this.E = v1;
                    this.G = v8;
                    this.I = v7;
                    this.M = 5;
                    object6 = playDataForSeverContent$DrawerPlaylist1.getPlayableList(this);
                }
                catch(Throwable throwable4) {
                    l01 = l00;
                    v15 = v8;
                    v16 = v;
                    goto label_204;
                }
                if(object6 == a0) {
                    return a0;
                }
                v17 = v7;
                v15 = v8;
                v18 = v1;
                v16 = v;
                u03 = u00;
                s2 = s;
                l02 = l00;
                goto label_192;
            }
            case 5: {
                try {
                    v17 = this.I;
                    v15 = this.G;
                    v18 = this.E;
                    v16 = this.D;
                    u03 = this.B;
                    s2 = this.w;
                    l02 = this.r;
                    d5.n.D(object0);
                    object6 = object0;
                label_192:
                    boolean1 = Boolean.valueOf(!q.b(((AddRequestPlayableListInfo)object6), EmptyAddRequestPlayableListInfo.INSTANCE));
                    v7 = v17;
                    l01 = l02;
                    u00 = u03;
                    v1 = v18;
                    goto label_210;
                }
                catch(Throwable throwable4) {
                    v7 = v17;
                    l01 = l02;
                    u00 = u03;
                    v1 = v18;
                    s = s2;
                }
                try {
                label_204:
                    boolean1 = d5.n.t(throwable4);
                    s2 = s;
                }
                catch(Throwable throwable3) {
                    s1 = s;
                    Y.v(s1, " false", l01, false);
                    throw throwable3;
                }
                try {
                label_210:
                    if(boolean1 instanceof o) {
                        object5 = new t("Failed to update dsPlyOrderList");
                        l00 = l01;
                        s = s2;
                    }
                    else {
                        v v19 = new v(u00, v16, v1, null);
                        this.N = null;
                        this.r = l01;
                        this.w = s2;
                        this.B = null;
                        this.D = v15;
                        this.E = v7;
                        this.M = 6;
                        object7 = u00.U("moveInternal", v19, this);
                        if(object7 == a0) {
                            return a0;
                        }
                        s1 = s2;
                        s = s1;
                        l00 = l01;
                        object5 = new u(((C0)object7));
                    }
                    goto label_242;
                }
                catch(Throwable throwable3) {
                    s1 = s2;
                    Y.v(s1, " false", l01, false);
                    throw throwable3;
                }
            }
            case 6: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            s1 = this.w;
            l01 = this.r;
            d5.n.D(object0);
            object7 = object0;
            s = s1;
            l00 = l01;
            object5 = new u(((C0)object7));
        }
        catch(Throwable throwable3) {
            Y.v(s1, " false", l01, false);
            throw throwable3;
        }
    label_242:
        Y.v(s, " false", l00, false);
        return object5;
    }
}

