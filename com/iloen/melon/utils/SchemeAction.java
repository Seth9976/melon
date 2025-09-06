package com.iloen.melon.utils;

import M6.B;
import Ma.c;
import Ma.m;
import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.b;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.constants.CType;
import com.iloen.melon.fragments.MelonFragmentManager;
import com.iloen.melon.playback.playlist.add.AddAction.AddPlay;
import com.iloen.melon.playback.playlist.add.AddAction.AddPlayOpenPlayer;
import com.iloen.melon.playback.playlist.add.AddAction.VideoPlayAndOpen;
import com.iloen.melon.playback.playlist.add.AddPlayServiceScheme;
import com.iloen.melon.playback.playlist.add.AddServerContent;
import com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.MV;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Playlist;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import ie.H;
import k8.Y;
import k8.a;
import k8.o;
import k8.t;
import kc.d3;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ob.z;
import org.jetbrains.annotations.NotNull;
import pb.l;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/utils/SchemeAction;", "", "Landroid/net/Uri;", "uri", "Lie/H;", "playback", "(Landroid/net/Uri;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SchemeAction {
    public static final int $stable;
    @NotNull
    public static final SchemeAction INSTANCE;
    public static final LogU a;
    public static final CoroutineScope b;

    static {
        SchemeAction.INSTANCE = new SchemeAction();  // 初始化器: Ljava/lang/Object;-><init>()V
        SchemeAction.a = new LogU("SchemeAction");
        SchemeAction.b = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        SchemeAction.$stable = 8;
    }

    public static a a() {
        MelonAppBase.Companion.getClass();
        return ((o)(((c)b.B(t.a().getContext(), c.class)))).d();
    }

    public static final Object access$playbackInternal(SchemeAction schemeAction0, Uri uri0, Continuation continuation0) {
        String s12;
        String s2;
        String s1;
        Object object1;
        int v2;
        String s4;
        SchemeAction.playbackInternal.1 schemeAction$playbackInternal$10;
        schemeAction0.getClass();
        if(continuation0 instanceof SchemeAction.playbackInternal.1) {
            schemeAction$playbackInternal$10 = (SchemeAction.playbackInternal.1)continuation0;
            int v = schemeAction$playbackInternal$10.I;
            if((v & 0x80000000) == 0) {
                schemeAction$playbackInternal$10 = new SchemeAction.playbackInternal.1(schemeAction0, continuation0);
            }
            else {
                schemeAction$playbackInternal$10.I = v ^ 0x80000000;
            }
        }
        else {
            schemeAction$playbackInternal$10 = new SchemeAction.playbackInternal.1(schemeAction0, continuation0);
        }
        Object object0 = schemeAction$playbackInternal$10.E;
        ne.a a0 = ne.a.a;
        H h0 = H.a;
        String s = "";
        switch(schemeAction$playbackInternal$10.I) {
            case 0: {
                n.D(object0);
                if(TextUtils.equals("Y", uri0.getQueryParameter("releaseRepeat"))) {
                    LogU.warn$default(SchemeAction.a, "playback() RELEASE_SECTION_REPEAT", null, false, 6, null);
                    z z0 = SchemeAction.b();
                    schemeAction$playbackInternal$10.r = uri0;
                    schemeAction$playbackInternal$10.I = 1;
                    if(z0.b(0x7F13090F, schemeAction$playbackInternal$10) != a0) {  // string:section_repeat_mode_release_toast "반복재생이 해제되었습니다.\n반복재생은 재생 목록에서 재설정 가능합니다."
                        break;
                    }
                    return a0;
                }
                break;
            }
            case 1: {
                uri0 = schemeAction$playbackInternal$10.r;
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                SchemeAction.b().u();
                return h0;
            }
            case 3: {
                n.D(object0);
                SchemeAction.b().u();
                return h0;
            }
            case 4: {
                int v1 = schemeAction$playbackInternal$10.D;
                String s3 = schemeAction$playbackInternal$10.B;
                s4 = schemeAction$playbackInternal$10.w;
                n.D(object0);
                v2 = v1;
                s1 = s3;
                object1 = object0;
                goto label_108;
            }
            case 5: {
                s1 = schemeAction$playbackInternal$10.B;
                s2 = schemeAction$playbackInternal$10.w;
                n.D(object0);
                goto label_117;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        String s5 = "1000000543";
        if(TextUtils.isEmpty(uri0.getQueryParameter("cid"))) {
            if(!TextUtils.isEmpty(uri0.getQueryParameter("service"))) {
                String s6 = uri0.getQueryParameter("service");
                if(TextUtils.isEmpty(s6)) {
                    LogU.warn$default(SchemeAction.a, "playback() service param is empty", null, false, 6, null);
                    return h0;
                }
                if("nowplaylist".equals(s6)) {
                    B b0 = ((d3)SchemeAction.c()).b();
                    schemeAction$playbackInternal$10.r = null;
                    schemeAction$playbackInternal$10.I = 2;
                    if(ListenableFutureKt.await(b0, schemeAction$playbackInternal$10) == a0) {
                        return a0;
                    }
                    SchemeAction.b().u();
                    return h0;
                }
                String s7 = uri0.getQueryParameter("menuid");
                if(TextUtils.isEmpty(s7)) {
                    s7 = "1000000543";
                }
                BaseActivity baseActivity0 = MelonFragmentManager.getInstance().getCurrentActivity();
                AddPlay addAction$AddPlay0 = new AddPlay(false);
                String s8 = uri0.toString();
                q.f(s8, "toString(...)");
                AddToPlaylistUIHelperKt.addPlaylistAndReturnAction$default(baseActivity0, new AddPlayServiceScheme((s7 == null ? "1000000543" : s7), null, addAction$AddPlay0, false, SchemeAction.a(), s8), false, 2, null);
                return h0;
            }
            if("Y".equalsIgnoreCase(uri0.getQueryParameter("exclude_adult_content"))) {
                l l0 = new l(SchemeAction.c(), 0);
                a a1 = SchemeAction.a();
                schemeAction$playbackInternal$10.r = null;
                schemeAction$playbackInternal$10.I = 3;
                if(l0.c(a1, schemeAction$playbackInternal$10) != a0) {
                    SchemeAction.b().u();
                    return h0;
                }
                return a0;
            }
            SchemeAction.b().u();
            return h0;
        }
        String s9 = uri0.getQueryParameter("ctype");
        if("son".equals(s9)) {
            s9 = "1";
        }
        CType cType0 = CType.get(s9);
        String s10 = uri0.getQueryParameter("cid");
        String s11 = uri0.getQueryParameter("menuid");
        if(TextUtils.isEmpty(s11)) {
            if(q.b(CType.MV, cType0)) {
                s5 = "1000000550";
            }
            s12 = s5;
        }
        else {
            q.d(s11);
            s12 = s11;
        }
        uri0.getQueryParameter("mkey");
        String s13 = uri0.getQueryParameter("openplayer");
        int v3 = TextUtils.isEmpty(s13) || !"Y".equals(s13) ? 0 : 1;
        if(q.b(CType.MV, cType0)) {
            BaseActivity baseActivity1 = MelonFragmentManager.getInstance().getCurrentActivity();
            VideoPlayAndOpen addAction$VideoPlayAndOpen0 = new VideoPlayAndOpen(true);
            MV playDataForSeverContent$MV0 = new MV((s10 == null ? "" : s10), null, s12, null, 2, null);
            AddToPlaylistUIHelperKt.addPlaylistAndReturnAction$default(baseActivity1, new AddServerContent(addAction$VideoPlayAndOpen0, false, false, SchemeAction.a(), playDataForSeverContent$MV0, 6, null), false, 2, null);
            return h0;
        }
        if(q.b(CType.PLAYLIST, cType0)) {
            LogU.debug$default(SchemeAction.a, "playback()  ", null, false, 6, null);
            z z1 = SchemeAction.b();
            schemeAction$playbackInternal$10.r = null;
            schemeAction$playbackInternal$10.w = s10;
            schemeAction$playbackInternal$10.B = s12;
            schemeAction$playbackInternal$10.D = v3;
            schemeAction$playbackInternal$10.I = 4;
            object1 = z1.o(schemeAction$playbackInternal$10);
            if(object1 != a0) {
                s4 = s10;
                v2 = v3;
                s1 = s12;
            label_108:
                if(!((Boolean)object1).booleanValue()) {
                    goto label_118;
                }
                z z2 = SchemeAction.b();
                schemeAction$playbackInternal$10.r = null;
                schemeAction$playbackInternal$10.w = s4;
                schemeAction$playbackInternal$10.B = s1;
                schemeAction$playbackInternal$10.D = v2;
                schemeAction$playbackInternal$10.I = 5;
                if(z2.b(0x7F13090F, schemeAction$playbackInternal$10) != a0) {  // string:section_repeat_mode_release_toast "반복재생이 해제되었습니다.\n반복재생은 재생 목록에서 재설정 가능합니다."
                    s2 = s4;
                label_117:
                    s4 = s2;
                label_118:
                    BaseActivity baseActivity2 = MelonFragmentManager.getInstance().getCurrentActivity();
                    AddPlay addAction$AddPlay1 = new AddPlay(false);
                    if(s4 != null) {
                        s = s4;
                    }
                    Playlist playDataForSeverContent$Playlist0 = new Playlist(s, s1, null);
                    AddToPlaylistUIHelperKt.addPlaylistAndReturnAction$default(baseActivity2, new AddServerContent(addAction$AddPlay1, false, false, SchemeAction.a(), playDataForSeverContent$Playlist0, 6, null), false, 2, null);
                    return h0;
                }
            }
            return a0;
        }
        AddPlayOpenPlayer addAction$AddPlayOpenPlayer0 = v3 == 0 ? new AddPlay(false) : new AddPlayOpenPlayer(false);
        BaseActivity baseActivity3 = MelonFragmentManager.getInstance().getCurrentActivity();
        q.d(cType0);
        AddToPlaylistUIHelperKt.addPlaylistAndReturnAction$default(baseActivity3, AddServerContent.Companion.with(cType0, (s10 == null ? "" : s10), s12, addAction$AddPlayOpenPlayer0, SchemeAction.a()), false, 2, null);
        return h0;
    }

    public static z b() {
        return ((o)(((Ma.o)Y.g(MelonAppBase.Companion, "context", Ma.o.class)))).k();
    }

    public static s2 c() {
        return (s2)((o)(((m)Y.g(MelonAppBase.Companion, "context", m.class)))).w.get();
    }

    public final void playback(@NotNull Uri uri0) {
        q.g(uri0, "uri");
        if(q.b(Uri.EMPTY, uri0)) {
            LogU.warn$default(SchemeAction.a, "playback() uri is empty", null, false, 6, null);
            return;
        }
        LogU.debug$default(SchemeAction.a, "playback() " + uri0, null, false, 6, null);
        com.iloen.melon.utils.SchemeAction.playback.1 schemeAction$playback$10 = new we.n(null) {
            public int r;
            public final Uri w;

            {
                this.w = uri0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.utils.SchemeAction.playback.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.utils.SchemeAction.playback.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        n.D(object0);
                        this.r = 1;
                        return SchemeAction.access$playbackInternal(SchemeAction.INSTANCE, this.w, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        };
        BuildersKt__Builders_commonKt.launch$default(SchemeAction.b, null, null, schemeAction$playback$10, 3, null);
    }
}

