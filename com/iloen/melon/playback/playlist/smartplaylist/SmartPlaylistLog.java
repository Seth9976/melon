package com.iloen.melon.playback.playlist.smartplaylist;

import Ac.F2;
import I7.k;
import M6.B;
import Ma.m;
import a7.c;
import com.android.volley.NetworkResponse;
import com.android.volley.ServerError;
import com.android.volley.toolbox.RequestFuture;
import com.gaudiolab.sol.android.SolMusicOne.LoudnessType;
import com.google.gson.n;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.constants.AddPosition;
import com.iloen.melon.constants.ListKeepOption;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.mcp.AddOptionServer;
import com.iloen.melon.net.mcp.PlaylistSmartError.Reason;
import com.iloen.melon.net.mcp.PlaylistSmartError;
import com.iloen.melon.net.mcp.request.PlaylistsSmartStatisticsReq.Statistics;
import com.iloen.melon.net.mcp.request.PlaylistsSmartStatisticsReq;
import com.iloen.melon.net.mcp.response.PlaylistsSmartRes;
import com.iloen.melon.player.playlist.drawernew.model.DrawerPlytTab.Companion;
import com.iloen.melon.player.playlist.drawernew.model.DrawerPlytTab;
import com.iloen.melon.userstore.MelonDb;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import ie.p;
import java.nio.charset.Charset;
import java.util.List;
import je.w;
import k8.Y;
import k8.o;
import kc.G2;
import kc.M2;
import kc.d3;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oc.M;
import oc.y0;
import org.jetbrains.annotations.NotNull;
import qc.D0;
import qc.n0;
import sc.P0;
import sc.b;
import sc.g1;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\b\u001A\u00020\u00072\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\n\u001A\u00020\u00072\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\tJ\u0018\u0010\r\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u000BH\u0082@¢\u0006\u0004\b\r\u0010\u000EJ\'\u0010\u0013\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0016\u001A\u00020\u00072\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u00042\u0006\u0010\u0015\u001A\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001D\u001A\u00020\u001A8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001C¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/playback/playlist/smartplaylist/SmartPlaylistLog;", "", "<init>", "()V", "", "from", "memberKey", "Lie/H;", "sendStatisticsWhenUseSmartPlaylist", "(Ljava/lang/String;Ljava/lang/String;)V", "sendStatisticsWhenNotUseSmartPlaylist", "Lcom/iloen/melon/net/mcp/request/PlaylistsSmartStatisticsReq$Statistics;", "statistics", "requestSpStatisticsSync", "(Lcom/iloen/melon/net/mcp/request/PlaylistsSmartStatisticsReq$Statistics;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "e", "", "spOn", "checkFailedByMemberApiFailForDebug", "(Ljava/lang/Throwable;ZLjava/lang/String;)V", "useSmartPlaylist", "sendSpStatisticsAsync", "(Ljava/lang/String;Ljava/lang/String;Z)V", "TAG", "Ljava/lang/String;", "Lkc/s2;", "getPlaylistManager", "()Lkc/s2;", "playlistManager", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SmartPlaylistLog {
    public static final int $stable = 0;
    @NotNull
    public static final SmartPlaylistLog INSTANCE = null;
    @NotNull
    private static final String TAG = "SmartPlaylistLog";

    static {
        SmartPlaylistLog.INSTANCE = new SmartPlaylistLog();
    }

    private final void checkFailedByMemberApiFailForDebug(Throwable throwable0, boolean z, String s) {
        byte[] arr_b;
        try {
            Throwable throwable1 = throwable0.getCause();
            String s1 = null;
            Throwable throwable2 = throwable1 == null ? null : throwable1.getCause();
            ServerError serverError0 = throwable2 instanceof ServerError ? ((ServerError)throwable2) : null;
            if(serverError0 == null) {
                arr_b = null;
            }
            else {
                NetworkResponse networkResponse0 = serverError0.networkResponse;
                arr_b = networkResponse0 == null ? null : networkResponse0.data;
            }
            if(serverError0 != null && arr_b != null) {
                Charset charset0 = Charset.defaultCharset();
                q.f(charset0, "defaultCharset(...)");
                PlaylistsSmartRes playlistsSmartRes0 = (PlaylistsSmartRes)new n().e(new String(arr_b, charset0), PlaylistsSmartRes.class);
                if(playlistsSmartRes0 != null) {
                    PlaylistSmartError playlistSmartError0 = playlistsSmartRes0.error;
                    if(playlistSmartError0 != null) {
                        Reason playlistSmartError$Reason0 = playlistSmartError0.reason;
                        if(playlistSmartError$Reason0 != null) {
                            s1 = playlistSmartError$Reason0.type;
                        }
                    }
                }
                if(q.b(s1, "MemberApiFail")) {
                    DevLog.Companion.get("Account").put("failed by MemberApiFail - spOn: " + z + ", from: " + s);
                    c c0 = c.a();
                    k k0 = new k(c0.a, "failed_sp_statistics_by_memberApiFail_sp_on", Boolean.toString(z), 27);
                    c0.a.o.a.a(k0);
                    k k1 = new k(c0.a, "failed_sp_statistics_by_memberApiFail_from", s, 27);
                    c0.a.o.a.a(k1);
                    c0.c(throwable0);
                }
            }
        }
        catch(Exception unused_ex) {
        }
    }

    private final s2 getPlaylistManager() {
        return (s2)((o)(((m)Y.g(MelonAppBase.Companion, "context", m.class)))).w.get();
    }

    private final Object requestSpStatisticsSync(Statistics playlistsSmartStatisticsReq$Statistics0, Continuation continuation0) {
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        Object object0 = BuildersKt.withContext(Dispatchers.getIO(), new we.n(requestFuture0, null) {
            final RequestFuture $future;
            final PlaylistsSmartStatisticsReq $req;
            int label;

            {
                this.$req = playlistsSmartStatisticsReq0;
                this.$future = requestFuture0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistLog.requestSpStatisticsSync.2(this.$req, this.$future, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistLog.requestSpStatisticsSync.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                HttpResponse httpResponse0 = RequestBuilder.newInstance(this.$req).tag("SmartPlaylistLog").listener(this.$future).errorListener(this.$future).requestSync(this.$future);
                q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.mcp.response.PlaylistsSmartRes");
                return (PlaylistsSmartRes)httpResponse0;
            }
        }, continuation0);
        return object0 == a.a ? object0 : H.a;
    }

    public final void sendSpStatisticsAsync(@NotNull String s, @NotNull String s1, boolean z) {
        q.g(s, "from");
        q.g(s1, "memberKey");
        if(z) {
            this.sendStatisticsWhenUseSmartPlaylist(s, s1);
            return;
        }
        this.sendStatisticsWhenNotUseSmartPlaylist(s, s1);
    }

    private final void sendStatisticsWhenNotUseSmartPlaylist(String s, String s1) {
        LogU.Companion.d("SmartPlaylistLog", "sendStatisticsWhenUseSmartPlaylist - " + s);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new we.n(s, null) {
            final String $from;
            final String $memberKey;
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            private Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            Object L$9;
            boolean Z$0;
            boolean Z$1;
            int label;

            {
                this.$memberKey = s;
                this.$from = s1;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistLog.sendStatisticsWhenNotUseSmartPlaylist.1(this.$memberKey, this.$from, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistLog.sendStatisticsWhenNotUseSmartPlaylist.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                Object object1;
                int v4;
                String s1;
                AddOptionServer addOptionServer0;
                y0 y00;
                String s;
                int v3;
                boolean z1;
                boolean z;
                int v2;
                int v1;
                s2 s23;
                Object object2;
                String s2;
                Object object3;
                int v11;
                boolean z6;
                s2 s24;
                Companion drawerPlytTab$Companion0;
                AddOptionServer addOptionServer2;
                y0 y02;
                int v10;
                boolean z5;
                int v8;
                Object object4;
                s2 s25;
                List list0;
                CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                a a0 = a.a;
                H h0 = H.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        String s5 = this.$memberKey;
                        try {
                            s25 = (d3)SmartPlaylistLog.INSTANCE.getPlaylistManager();
                            G2 g20 = new G2(((d3)s25), null);
                            B b0 = ListenableFutureKt.future$default(s25.b, null, null, g20, 3, null);
                            this.L$0 = null;
                            this.L$1 = s5;
                            this.L$2 = null;
                            this.L$3 = s25;
                            this.I$0 = 0;
                            this.label = 1;
                            object4 = ListenableFutureKt.await(b0, this);
                            if(object4 == a0) {
                                return a0;
                            }
                            s2 = s5;
                            v10 = 0;
                        label_101:
                            s24 = s25;
                            D0 d04 = ((n0)(((qc.a)object4))).H();
                            int v13 = d04.a.size();
                            y02 = d04.e;
                            AddPosition addPosition0 = MelonSettingInfo.getPlayListAddPosition();
                            q.f(addPosition0, "getPlayListAddPosition(...)");
                            addOptionServer2 = MapperKt.asAddOptionServer(addPosition0);
                            boolean z7 = MapperKt.asIsAllowDuplicate(MelonSettingInfo.getUseRemoveDuplicatedPlaylist());
                            ListKeepOption listKeepOption0 = MelonSettingInfo.getCurrentListKeepOption();
                            q.f(listKeepOption0, "getCurrentListKeepOption(...)");
                            boolean z8 = MapperKt.asIsDeleteExisting(listKeepOption0);
                            drawerPlytTab$Companion0 = DrawerPlytTab.Companion;
                            Flow flow0 = DrawerPlaylistPreferencesRepository.INSTANCE.getLastTab();
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = s24;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.L$5 = null;
                            this.L$6 = drawerPlytTab$Companion0;
                            this.L$7 = addOptionServer2;
                            this.L$8 = y02;
                            this.L$9 = s2;
                            this.I$0 = v10;
                            this.Z$0 = z8;
                            this.Z$1 = z7;
                            this.I$1 = 0;
                            this.I$2 = v13;
                            this.label = 2;
                            object3 = FlowKt.firstOrNull(flow0, this);
                            if(object3 == a0) {
                                return a0;
                            }
                            z5 = z8;
                            z6 = z7;
                            v8 = v13;
                            v11 = 0;
                        label_136:
                            String s6 = (String)object3;
                            if(s6 == null) {
                                s6 = "MADE_BY_ME";
                            }
                            String s7 = drawerPlytTab$Companion0.getServerTabName(s6);
                            F2 f20 = ((d3)s24).c();
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = (d3)s24;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.L$5 = null;
                            this.L$6 = s7;
                            this.L$7 = addOptionServer2;
                            this.L$8 = y02;
                            this.L$9 = s2;
                            this.I$0 = v10;
                            this.Z$0 = z5;
                            this.Z$1 = z6;
                            this.I$1 = v11;
                            this.I$2 = v8;
                            this.label = 3;
                            object2 = FlowKt.firstOrNull(f20, this);
                            if(object2 == a0) {
                                return a0;
                            }
                            v1 = v8;
                            s23 = (d3)s24;
                            y00 = y02;
                            z1 = z5;
                            z = z6;
                            v2 = v11;
                            s1 = s7;
                            addOptionServer0 = addOptionServer2;
                            v3 = v10;
                        label_168:
                            s = s2;
                            v4 = ((Boolean)object2) == null ? 0 : ((Boolean)object2).booleanValue();
                            F2 f21 = ((d3)s23).d();
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.L$5 = null;
                            this.L$6 = s1;
                            this.L$7 = addOptionServer0;
                            this.L$8 = y00;
                            this.L$9 = s;
                            this.I$0 = v3;
                            this.Z$0 = z1;
                            this.Z$1 = z;
                            this.I$1 = v2;
                            this.I$2 = v1;
                            this.I$3 = v4;
                            this.label = 4;
                            object1 = FlowKt.firstOrNull(f21, this);
                            if(object1 == a0) {
                                return a0;
                            }
                        label_193:
                            M m0 = (M)object1;
                            if(m0 == null) {
                                m0 = M.a;
                            }
                            boolean z9 = MelonSettingInfo.isEqualizerStatusOn();
                            MelonDb melonDb0 = w9.a.a.h();
                            if(melonDb0 == null) {
                                list0 = w.a;
                            }
                            else {
                                list0 = melonDb0.fetchUserEqualizer();
                                melonDb0.close();
                                if(list0 == null) {
                                    list0 = w.a;
                                }
                            }
                            Statistics playlistsSmartStatisticsReq$Statistics1 = new Statistics(s, v1, v2 != 0, y00, addOptionServer0, z, z1, s1, v4 != 0, m0, z9, "EQ9998", list0.size(), MelonSettingInfo.getAudioLoudnessType() != LoudnessType.kOff.ordinal(), MelonSettingInfo.getAudioTargetLoudness(), MelonSettingInfo.isAudioLoudnessTransparentMode());
                            LogU.Companion.d("SmartPlaylistLog", "sendStatisticsWhenNotUseSmartPlaylist - size: " + playlistsSmartStatisticsReq$Statistics1.trackListSize);
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.L$5 = null;
                            this.L$6 = null;
                            this.L$7 = null;
                            this.L$8 = null;
                            this.L$9 = null;
                            this.I$0 = v3;
                            this.label = 5;
                            if(SmartPlaylistLog.INSTANCE.requestSpStatisticsSync(playlistsSmartStatisticsReq$Statistics1, this) == a0) {
                                return a0;
                            }
                            goto label_224;
                        }
                        catch(Throwable throwable0) {
                            break;
                        }
                    }
                    case 1: {
                        int v12 = this.I$0;
                        s25 = (s2)this.L$3;
                        CoroutineScope coroutineScope5 = (CoroutineScope)this.L$2;
                        String s4 = (String)this.L$1;
                        try {
                            d5.n.D(object0);
                            v10 = v12;
                            s2 = s4;
                            object4 = object0;
                            goto label_101;
                        }
                        catch(Throwable throwable0) {
                            break;
                        }
                    }
                    case 2: {
                        v8 = this.I$2;
                        int v9 = this.I$1;
                        boolean z4 = this.Z$1;
                        z5 = this.Z$0;
                        v10 = this.I$0;
                        s2 = (String)this.L$9;
                        y02 = (y0)this.L$8;
                        addOptionServer2 = (AddOptionServer)this.L$7;
                        drawerPlytTab$Companion0 = (Companion)this.L$6;
                        DrawerPlaylistPreferencesRepository drawerPlaylistPreferencesRepository3 = (DrawerPlaylistPreferencesRepository)this.L$5;
                        D0 d03 = (D0)this.L$4;
                        qc.a a4 = (qc.a)this.L$3;
                        s24 = (s2)this.L$2;
                        CoroutineScope coroutineScope4 = (CoroutineScope)this.L$1;
                        try {
                            d5.n.D(object0);
                            z6 = z4;
                            v11 = v9;
                            object3 = object0;
                            goto label_136;
                        }
                        catch(Throwable throwable0) {
                            break;
                        }
                    }
                    case 3: {
                        int v5 = this.I$2;
                        int v6 = this.I$1;
                        boolean z2 = this.Z$1;
                        boolean z3 = this.Z$0;
                        int v7 = this.I$0;
                        s2 = (String)this.L$9;
                        y0 y01 = (y0)this.L$8;
                        AddOptionServer addOptionServer1 = (AddOptionServer)this.L$7;
                        String s3 = (String)this.L$6;
                        DrawerPlaylistPreferencesRepository drawerPlaylistPreferencesRepository2 = (DrawerPlaylistPreferencesRepository)this.L$5;
                        D0 d02 = (D0)this.L$4;
                        qc.a a3 = (qc.a)this.L$3;
                        s2 s22 = (s2)this.L$2;
                        CoroutineScope coroutineScope3 = (CoroutineScope)this.L$1;
                        try {
                            d5.n.D(object0);
                            object2 = object0;
                            v1 = v5;
                            s23 = s22;
                            y00 = y01;
                            z1 = z3;
                            z = z2;
                            v2 = v6;
                            addOptionServer0 = addOptionServer1;
                            v3 = v7;
                            s1 = s3;
                            goto label_168;
                        }
                        catch(Throwable throwable0) {
                            break;
                        }
                    }
                    case 4: {
                        int v = this.I$3;
                        v1 = this.I$2;
                        v2 = this.I$1;
                        z = this.Z$1;
                        z1 = this.Z$0;
                        v3 = this.I$0;
                        s = (String)this.L$9;
                        y00 = (y0)this.L$8;
                        addOptionServer0 = (AddOptionServer)this.L$7;
                        s1 = (String)this.L$6;
                        DrawerPlaylistPreferencesRepository drawerPlaylistPreferencesRepository1 = (DrawerPlaylistPreferencesRepository)this.L$5;
                        D0 d01 = (D0)this.L$4;
                        qc.a a2 = (qc.a)this.L$3;
                        s2 s21 = (s2)this.L$2;
                        CoroutineScope coroutineScope2 = (CoroutineScope)this.L$1;
                        try {
                            d5.n.D(object0);
                            v4 = v;
                            object1 = object0;
                            goto label_193;
                        }
                        catch(Throwable throwable0) {
                            break;
                        }
                    }
                    case 5: {
                        Statistics playlistsSmartStatisticsReq$Statistics0 = (Statistics)this.L$6;
                        DrawerPlaylistPreferencesRepository drawerPlaylistPreferencesRepository0 = (DrawerPlaylistPreferencesRepository)this.L$5;
                        D0 d00 = (D0)this.L$4;
                        qc.a a1 = (qc.a)this.L$3;
                        s2 s20 = (s2)this.L$2;
                        CoroutineScope coroutineScope1 = (CoroutineScope)this.L$1;
                        try {
                            d5.n.D(object0);
                            goto label_224;
                        }
                        catch(Throwable throwable0) {
                            break;
                        }
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                ie.o o0 = d5.n.t(throwable0);
                goto label_225;
            label_224:
                o0 = h0;
            label_225:
                String s8 = this.$from;
                Throwable throwable1 = p.a(o0);
                if(throwable1 != null) {
                    SmartPlaylistLog.INSTANCE.checkFailedByMemberApiFailForDebug(throwable1, false, s8);
                }
                return h0;
            }
        }, 3, null);
    }

    private final void sendStatisticsWhenUseSmartPlaylist(String s, String s1) {
        LogU.Companion.d("SmartPlaylistLog", "sendStatisticsWhenUseSmartPlaylist - " + s);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new we.n(s, null) {
            final String $from;
            final String $memberKey;
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            private Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            Object L$9;
            boolean Z$0;
            boolean Z$1;
            int label;

            {
                this.$memberKey = s;
                this.$from = s1;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistLog.sendStatisticsWhenUseSmartPlaylist.1(this.$memberKey, this.$from, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistLog.sendStatisticsWhenUseSmartPlaylist.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                Object object1;
                int v4;
                String s1;
                AddOptionServer addOptionServer0;
                y0 y00;
                String s;
                int v3;
                boolean z1;
                boolean z;
                int v2;
                int v1;
                s2 s23;
                Object object2;
                AddOptionServer addOptionServer1;
                int v7;
                Object object3;
                int v10;
                boolean z6;
                s2 s24;
                Companion drawerPlytTab$Companion0;
                y0 y02;
                String s4;
                boolean z5;
                int v8;
                Object object4;
                s2 s25;
                List list0;
                CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                a a0 = a.a;
                H h0 = H.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        String s6 = this.$memberKey;
                        try {
                            s25 = (d3)SmartPlaylistLog.INSTANCE.getPlaylistManager();
                            M2 m20 = new M2(((d3)s25), null);
                            B b4 = ListenableFutureKt.future$default(s25.b, null, null, m20, 3, null);
                            this.L$0 = null;
                            this.L$1 = s6;
                            this.L$2 = null;
                            this.L$3 = s25;
                            this.I$0 = 0;
                            this.label = 1;
                            object4 = ListenableFutureKt.await(b4, this);
                            if(object4 == a0) {
                                return a0;
                            }
                            s4 = s6;
                            v7 = 0;
                        label_100:
                            s24 = s25;
                            g1 g14 = ((P0)(((b)object4))).P();
                            int v12 = g14.a.size();
                            y02 = g14.e;
                            AddPosition addPosition0 = MelonSettingInfo.getPlayListAddPosition();
                            q.f(addPosition0, "getPlayListAddPosition(...)");
                            addOptionServer1 = MapperKt.asAddOptionServer(addPosition0);
                            boolean z7 = MapperKt.asIsAllowDuplicate(MelonSettingInfo.getUseRemoveDuplicatedPlaylist());
                            ListKeepOption listKeepOption0 = MelonSettingInfo.getCurrentListKeepOption();
                            q.f(listKeepOption0, "getCurrentListKeepOption(...)");
                            boolean z8 = MapperKt.asIsDeleteExisting(listKeepOption0);
                            drawerPlytTab$Companion0 = DrawerPlytTab.Companion;
                            Flow flow0 = DrawerPlaylistPreferencesRepository.INSTANCE.getLastTab();
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = s24;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.L$5 = null;
                            this.L$6 = drawerPlytTab$Companion0;
                            this.L$7 = addOptionServer1;
                            this.L$8 = y02;
                            this.L$9 = s4;
                            this.I$0 = v7;
                            this.Z$0 = z8;
                            this.Z$1 = z7;
                            this.I$1 = 1;
                            this.I$2 = v12;
                            this.label = 2;
                            object3 = FlowKt.firstOrNull(flow0, this);
                            if(object3 == a0) {
                                return a0;
                            }
                            z5 = z8;
                            z6 = z7;
                            v8 = v12;
                            v10 = 1;
                        label_135:
                            String s7 = (String)object3;
                            if(s7 == null) {
                                s7 = "MADE_BY_ME";
                            }
                            String s8 = drawerPlytTab$Companion0.getServerTabName(s7);
                            F2 f20 = ((d3)s24).c();
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = (d3)s24;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.L$5 = null;
                            this.L$6 = s8;
                            this.L$7 = addOptionServer1;
                            this.L$8 = y02;
                            this.L$9 = s4;
                            this.I$0 = v7;
                            this.Z$0 = z5;
                            this.Z$1 = z6;
                            this.I$1 = v10;
                            this.I$2 = v8;
                            this.label = 3;
                            object2 = FlowKt.firstOrNull(f20, this);
                            if(object2 == a0) {
                                return a0;
                            }
                            v1 = v8;
                            s23 = (d3)s24;
                            y00 = y02;
                            z1 = z5;
                            z = z6;
                            v2 = v10;
                            s = s4;
                            s1 = s8;
                        label_166:
                            addOptionServer0 = addOptionServer1;
                            v3 = v7;
                            v4 = ((Boolean)object2) == null ? 0 : ((Boolean)object2).booleanValue();
                            F2 f21 = ((d3)s23).d();
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.L$5 = null;
                            this.L$6 = s1;
                            this.L$7 = addOptionServer0;
                            this.L$8 = y00;
                            this.L$9 = s;
                            this.I$0 = v3;
                            this.Z$0 = z1;
                            this.Z$1 = z;
                            this.I$1 = v2;
                            this.I$2 = v1;
                            this.I$3 = v4;
                            this.label = 4;
                            object1 = FlowKt.firstOrNull(f21, this);
                            if(object1 == a0) {
                                return a0;
                            }
                        label_192:
                            M m0 = (M)object1;
                            if(m0 == null) {
                                m0 = M.a;
                            }
                            boolean z9 = MelonSettingInfo.isEqualizerStatusOn();
                            MelonDb melonDb0 = w9.a.a.h();
                            if(melonDb0 == null) {
                                list0 = w.a;
                            }
                            else {
                                list0 = melonDb0.fetchUserEqualizer();
                                melonDb0.close();
                                if(list0 == null) {
                                    list0 = w.a;
                                }
                            }
                            Statistics playlistsSmartStatisticsReq$Statistics1 = new Statistics(s, v1, v2 != 0, y00, addOptionServer0, z, z1, s1, v4 != 0, m0, z9, "EQ9998", list0.size(), MelonSettingInfo.getAudioLoudnessType() != LoudnessType.kOff.ordinal(), MelonSettingInfo.getAudioTargetLoudness(), MelonSettingInfo.isAudioLoudnessTransparentMode());
                            LogU.Companion.d("SmartPlaylistLog", "sendStatisticsWhenUseSmartPlaylist - size: " + playlistsSmartStatisticsReq$Statistics1.trackListSize);
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.L$5 = null;
                            this.L$6 = null;
                            this.L$7 = null;
                            this.L$8 = null;
                            this.L$9 = null;
                            this.I$0 = v3;
                            this.label = 5;
                            if(SmartPlaylistLog.INSTANCE.requestSpStatisticsSync(playlistsSmartStatisticsReq$Statistics1, this) == a0) {
                                return a0;
                            }
                            goto label_223;
                        }
                        catch(Throwable throwable0) {
                            break;
                        }
                    }
                    case 1: {
                        int v11 = this.I$0;
                        s25 = (s2)this.L$3;
                        CoroutineScope coroutineScope5 = (CoroutineScope)this.L$2;
                        String s5 = (String)this.L$1;
                        try {
                            d5.n.D(object0);
                            v7 = v11;
                            s4 = s5;
                            object4 = object0;
                            goto label_100;
                        }
                        catch(Throwable throwable0) {
                            break;
                        }
                    }
                    case 2: {
                        v8 = this.I$2;
                        int v9 = this.I$1;
                        boolean z4 = this.Z$1;
                        z5 = this.Z$0;
                        v7 = this.I$0;
                        s4 = (String)this.L$9;
                        y02 = (y0)this.L$8;
                        addOptionServer1 = (AddOptionServer)this.L$7;
                        drawerPlytTab$Companion0 = (Companion)this.L$6;
                        DrawerPlaylistPreferencesRepository drawerPlaylistPreferencesRepository3 = (DrawerPlaylistPreferencesRepository)this.L$5;
                        g1 g13 = (g1)this.L$4;
                        b b3 = (b)this.L$3;
                        s24 = (s2)this.L$2;
                        CoroutineScope coroutineScope4 = (CoroutineScope)this.L$1;
                        try {
                            d5.n.D(object0);
                            z6 = z4;
                            v10 = v9;
                            object3 = object0;
                            goto label_135;
                        }
                        catch(Throwable throwable0) {
                            break;
                        }
                    }
                    case 3: {
                        int v5 = this.I$2;
                        int v6 = this.I$1;
                        boolean z2 = this.Z$1;
                        boolean z3 = this.Z$0;
                        v7 = this.I$0;
                        String s2 = (String)this.L$9;
                        y0 y01 = (y0)this.L$8;
                        addOptionServer1 = (AddOptionServer)this.L$7;
                        String s3 = (String)this.L$6;
                        DrawerPlaylistPreferencesRepository drawerPlaylistPreferencesRepository2 = (DrawerPlaylistPreferencesRepository)this.L$5;
                        g1 g12 = (g1)this.L$4;
                        b b2 = (b)this.L$3;
                        s2 s22 = (s2)this.L$2;
                        CoroutineScope coroutineScope3 = (CoroutineScope)this.L$1;
                        try {
                            d5.n.D(object0);
                            s = s2;
                            s1 = s3;
                            object2 = object0;
                            v1 = v5;
                            s23 = s22;
                            y00 = y01;
                            z1 = z3;
                            z = z2;
                            v2 = v6;
                            goto label_166;
                        }
                        catch(Throwable throwable0) {
                            break;
                        }
                    }
                    case 4: {
                        int v = this.I$3;
                        v1 = this.I$2;
                        v2 = this.I$1;
                        z = this.Z$1;
                        z1 = this.Z$0;
                        v3 = this.I$0;
                        s = (String)this.L$9;
                        y00 = (y0)this.L$8;
                        addOptionServer0 = (AddOptionServer)this.L$7;
                        s1 = (String)this.L$6;
                        DrawerPlaylistPreferencesRepository drawerPlaylistPreferencesRepository1 = (DrawerPlaylistPreferencesRepository)this.L$5;
                        g1 g11 = (g1)this.L$4;
                        b b1 = (b)this.L$3;
                        s2 s21 = (s2)this.L$2;
                        CoroutineScope coroutineScope2 = (CoroutineScope)this.L$1;
                        try {
                            d5.n.D(object0);
                            v4 = v;
                            object1 = object0;
                            goto label_192;
                        }
                        catch(Throwable throwable0) {
                            break;
                        }
                    }
                    case 5: {
                        Statistics playlistsSmartStatisticsReq$Statistics0 = (Statistics)this.L$6;
                        DrawerPlaylistPreferencesRepository drawerPlaylistPreferencesRepository0 = (DrawerPlaylistPreferencesRepository)this.L$5;
                        g1 g10 = (g1)this.L$4;
                        b b0 = (b)this.L$3;
                        s2 s20 = (s2)this.L$2;
                        CoroutineScope coroutineScope1 = (CoroutineScope)this.L$1;
                        try {
                            d5.n.D(object0);
                            goto label_223;
                        }
                        catch(Throwable throwable0) {
                            break;
                        }
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                ie.o o0 = d5.n.t(throwable0);
                goto label_224;
            label_223:
                o0 = h0;
            label_224:
                String s9 = this.$from;
                Throwable throwable1 = p.a(o0);
                if(throwable1 != null) {
                    SmartPlaylistLog.INSTANCE.checkFailedByMemberApiFailForDebug(throwable1, true, s9);
                }
                return h0;
            }
        }, 3, null);
    }
}

