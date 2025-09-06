package k8;

import A8.M;
import Ac.h0;
import Ba.B;
import Ba.C;
import Ba.E;
import Ba.G;
import Ba.H;
import Ba.J;
import Ba.K;
import Ba.N;
import Ba.O;
import Ba.S;
import Ba.e;
import Ba.h;
import Ba.j;
import Ba.p;
import Ba.q;
import Ba.r;
import Ba.s;
import Ba.x;
import Cc.x2;
import E9.w;
import Qb.z;
import Ub.u;
import Ub.v;
import Vb.t0;
import Vb.u0;
import android.accounts.AccountManager;
import androidx.room.A;
import com.iloen.melon.playback.playlist.db.MixUpPlaylistDao;
import com.iloen.melon.playback.playlist.db.MixUpWaitingBackDao;
import com.iloen.melon.playback.playlist.db.MusicPlaylistDao;
import com.iloen.melon.playback.playlist.db.PlaylistDao;
import com.iloen.melon.playback.playlist.db.PlaylistDatabase;
import com.iloen.melon.playback.playlist.db.SmartPlaylistDao;
import com.iloen.melon.playback.playlist.music.MusicPlaylistDBDataSource;
import com.iloen.melon.playback.playlist.musicwave.MusicWavePlaylistRemoteDataSource;
import com.iloen.melon.playback.playlist.musicwave.MusicWavePlaylistRepositoryImpl;
import com.iloen.melon.playback.playlist.smartplaylist.SmartPlaylistDBDataSource;
import com.iloen.melon.userstore.VolatileDatabase;
import com.iloen.melon.utils.datastore.CommonPlytSettingPreferencesSerializerKt;
import com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository;
import com.iloen.melon.utils.datastore.EachPlytSettingPreferencesSerializerKt;
import com.iloen.melon.utils.datastore.LoginUserDataStoreKt;
import com.iloen.melon.utils.datastore.MixUpPlaylistPreferenceSerializerKt;
import com.iloen.melon.utils.datastore.SmartPlaylistUseSettingPreferencesRepository;
import com.iloen.melon.utils.log.LogU;
import com.melon.data.database.MelonDatabase;
import com.melon.data.location.AndroidLocationDataSourceImpl;
import com.melon.data.location.GmsLocationDataSourceImpl;
import com.melon.data.newlogin.BlockStoreAccountRepository;
import com.melon.data.newlogin.KakaoUserIdLocalDataSourceImpl;
import com.melon.data.service.SearchApi;
import com.melon.net.ApiClient;
import com.melon.net.ResultCallAdapterFactory;
import com.melon.net.Timeout;
import com.melon.playback.manager.CastHelper;
import com.melon.playback.manager.DlnaHelper;
import com.melon.utils.image.ImageUtils;
import com.melon.utils.lifecycle.AppVisibilityManagerImpl;
import com.melon.utils.preference.PreferenceHelper;
import com.melon.utils.system.DeviceData;
import com.melon.utils.system.SystemSettingUtils;
import d5.t;
import ge.b;
import i.n.i.b.a.s.e.Ga;
import j9.d;
import kb.D;
import kc.A1;
import kc.H1;
import kc.L1;
import kc.W1;
import kc.d3;
import kc.i;
import kc.s2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import ma.g;
import mb.f;
import mb.k;
import mb.l;
import nc.B0;
import pc.E0;
import pc.y0;
import qc.C0;
import sc.S2;
import sc.f1;
import tg.T;
import tg.U;
import va.I0;
import va.J0;
import va.e0;
import va.j1;
import va.t1;
import va.u1;
import x9.c;
import z9.P;

public final class n implements b {
    public final o a;
    public final int b;

    public n(o o0, int v) {
        this.a = o0;
        this.b = v;
    }

    @Override  // javax.inject.Provider
    public final Object get() {
        int v = this.b;
        o o0 = this.a;
        c c0 = null;
        switch(v / 100) {
            case 0: {
                Class class0 = q.class;
                switch(v) {
                    case 0: {
                        return new d3(((i)o0.v.get()));
                    }
                    case 1: {
                        t.e(o0.a.a);
                        Object object0 = o0.o.get();
                        l2.i i0 = (l2.i)o0.p.get();
                        kotlin.jvm.internal.q.g(i0, "dataStore");
                        x9.b b0 = new x9.b();  // 初始化器: Ljava/lang/Object;-><init>()V
                        b0.a = i0;
                        b0.b = new LogU("MelonPlaylistManageRepositoryImpl");
                        Object object1 = o0.r.get();
                        Object object2 = o0.s.get();
                        kc.c c1 = new kc.c();  // 初始化器: Ljava/lang/Object;-><init>()V
                        Object object3 = o0.m.get();
                        Object object4 = o0.t.get();
                        Object object5 = o0.u.get();
                        Object object6 = o0.l.get();
                        Object object7 = o0.n.get();
                        return new com.melon.playlist.b(o0.a.a, ((W1)object0), b0, ((H1)object1), ((SmartPlaylistUseSettingPreferencesRepository)object2), c1, ((k)object3), ((z)object4), ((Ub.q)object5), ((a)object6), ((d)object7));
                    }
                    case 2: {
                        t.e(o0.a.a);
                        k k0 = (k)o0.m.get();
                        d d0 = (d)o0.n.get();
                        return new W1(o0.a.a, k0, d0);
                    }
                    case 3: {
                        t.e(o0.a.a);
                        Object object8 = o0.j.get();
                        f f0 = o0.f();
                        mb.o o1 = o0.m();
                        BlockStoreAccountRepository blockStoreAccountRepository0 = (BlockStoreAccountRepository)o0.k.get();
                        kotlin.jvm.internal.q.g(blockStoreAccountRepository0, "blockStoreAccountRepository");
                        D d1 = new D(blockStoreAccountRepository0, 14);
                        DeviceData deviceData0 = o0.e();
                        Object object9 = o0.l.get();
                        CoroutineDispatcher coroutineDispatcher0 = h0.B();
                        kotlin.jvm.internal.q.g(((l)object8), "melonLoginRepository");
                        kotlin.jvm.internal.q.g(((a)object9), "blockingProgressDialogManage");
                        return new e0(o0.a.a, ((l)object8), f0, o1, d1, deviceData0, ((a)object9), coroutineDispatcher0);
                    }
                    case 4: {
                        J0 j00 = (J0)o0.g.get();
                        I0 i00 = (I0)o0.i.get();
                        DeviceData deviceData1 = o0.e();
                        kotlin.jvm.internal.q.g(j00, "remoteDataSource");
                        kotlin.jvm.internal.q.g(i00, "loginUserLocalDataSource");
                        return new j1(j00, i00, deviceData1);
                    }
                    case 5: {
                        q q0 = (q)o0.d.get();
                        q q1 = (q)o0.f.get();
                        kotlin.jvm.internal.q.g(q0, "loginUserApi");
                        kotlin.jvm.internal.q.g(q1, "informMyProfileApi");
                        return new J0(q0, q1);
                    }
                    case 6: {
                        return (q)com.iloen.melon.utils.a.j(((U)o0.c.get()), "retrofit", class0, "create(...)");
                    }
                    case 7: {
                        T t0 = new T();
                        t0.a(M.j);
                        ug.a a0 = ug.a.c();
                        t0.c.add(a0);
                        t0.c(new ApiClient(null, null, 3, null).getClient());
                        ResultCallAdapterFactory resultCallAdapterFactory0 = new ResultCallAdapterFactory();
                        t0.d.add(resultCallAdapterFactory0);
                        return t0.b();
                    }
                    case 8: {
                        return (q)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", class0, "create(...)");
                    }
                    case 9: {
                        T t1 = new T();
                        t1.a(M.a);
                        ug.a a1 = ug.a.c();
                        t1.c.add(a1);
                        t1.c(new ApiClient(null, null, 3, null).getClient());
                        ResultCallAdapterFactory resultCallAdapterFactory1 = new ResultCallAdapterFactory();
                        t1.d.add(resultCallAdapterFactory1);
                        return t1.b();
                    }
                    case 10: {
                        l2.i i1 = (l2.i)o0.h.get();
                        kotlin.jvm.internal.q.g(i1, "dataStore");
                        return new I0(i1);
                    }
                    case 11: {
                        t.e(o0.a.a);
                        l2.i i2 = LoginUserDataStoreKt.getLoginUserDataStore(o0.a.a);
                        t.e(i2);
                        return i2;
                    }
                    case 12: {
                        t.e(o0.a.a);
                        return new BlockStoreAccountRepository(o0.a.a);
                    }
                    case 13: {
                        return new k8.b();
                    }
                    case 14: {
                        t.e(o0.a.a);
                        CoroutineDispatcher coroutineDispatcher1 = h0.A();
                        CoroutineScope coroutineScope0 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(coroutineDispatcher1));
                        t.e(coroutineScope0);
                        return new d(o0.a.a, coroutineScope0);
                    }
                    case 15: {
                        t.e(o0.a.a);
                        l2.i i3 = CommonPlytSettingPreferencesSerializerKt.getCommonPlaylistSettingPrefDataStore(o0.a.a);
                        t.e(i3);
                        return i3;
                    }
                    case 16: {
                        return new L1(o0.r(), o0.n());
                    }
                    case 17: {
                        return (C)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", C.class, "create(...)");
                    }
                    case 18: {
                        t.e(SmartPlaylistUseSettingPreferencesRepository.INSTANCE);
                        return SmartPlaylistUseSettingPreferencesRepository.INSTANCE;
                    }
                    case 19: {
                        t.e(o0.a.a);
                        return new z(o0.a.a, "PlayerController");
                    }
                    case 20: {
                        return new Ub.q();
                    }
                    case 21: {
                        return new Ub.t(o0.k(), ((CastHelper)o0.x.get()), ((DlnaHelper)o0.y.get()));
                    }
                    case 22: {
                        t.e(o0.a.a);
                        return new CastHelper(o0.a.a);
                    }
                    case 23: {
                        t.e(o0.a.a);
                        return new DlnaHelper(o0.a.a);
                    }
                    case 24: {
                        t.e(o0.a.a);
                        AppVisibilityManagerImpl appVisibilityManagerImpl0 = new AppVisibilityManagerImpl(o0.a.a);
                        z z0 = (z)o0.t.get();
                        return appVisibilityManagerImpl0;
                    }
                    case 25: {
                        t.e(o0.a.a);
                        A a2 = w.o(o0.a.a, MelonDatabase.class, "melon.db");
                        a2.d.add(MelonDatabase.a);
                        a2.a(new B4.a[]{da.c.a, da.c.b, da.c.c, da.c.d});
                        a2.i = true;
                        return (MelonDatabase)a2.b();
                    }
                    case 26: {
                        return (x)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", x.class, "create(...)");
                    }
                    case 27: {
                        T t2 = new T();
                        t2.a(M.g);
                        ug.a a3 = ug.a.c();
                        t2.c.add(a3);
                        t2.c(new ApiClient(null, null, 3, null).getClient());
                        ResultCallAdapterFactory resultCallAdapterFactory2 = new ResultCallAdapterFactory();
                        t2.d.add(resultCallAdapterFactory2);
                        return t2.b();
                    }
                    case 28: {
                        return (B)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", B.class, "create(...)");
                    }
                    case 29: {
                        t.e(o0.a.a);
                        KakaoUserIdLocalDataSourceImpl kakaoUserIdLocalDataSourceImpl0 = (KakaoUserIdLocalDataSourceImpl)o0.F.get();
                        kotlin.jvm.internal.q.g(kakaoUserIdLocalDataSourceImpl0, "kakaoUserIdDataSource");
                        return new va.n(o0.a.a, kakaoUserIdLocalDataSourceImpl0);
                    }
                    case 30: {
                        t.e(o0.a.a);
                        return new KakaoUserIdLocalDataSourceImpl(o0.a.a);
                    }
                    case 0x1F: {
                        t1 t10 = (t1)o0.H.get();
                        kotlin.jvm.internal.q.g(t10, "accountDataSource");
                        return new u1(t10);
                    }
                    case 0x20: {
                        t.e(o0.a.a);
                        AccountManager accountManager0 = AccountManager.get(o0.a.a);
                        kotlin.jvm.internal.q.f(accountManager0, "get(...)");
                        return new t1(Dispatchers.getIO(), accountManager0);
                    }
                    case 33: {
                        t.e(o0.a.a);
                        return (l2.i)l.b.getValue(o0.a.a, l.a[0]);
                    }
                    case 34: {
                        return (j)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", j.class, "create(...)");
                    }
                    case 35: {
                        T t3 = new T();
                        t3.a(M.p);
                        ug.a a4 = ug.a.c();
                        t3.c.add(a4);
                        t3.c(new ApiClient(null, null, 3, null).getClient());
                        ResultCallAdapterFactory resultCallAdapterFactory3 = new ResultCallAdapterFactory();
                        t3.d.add(resultCallAdapterFactory3);
                        return t3.b();
                    }
                    case 36: {
                        return (Ba.a)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", Ba.a.class, "create(...)");
                    }
                    case 37: {
                        return (e)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", e.class, "create(...)");
                    }
                    case 38: {
                        return (Ba.d)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", Ba.d.class, "create(...)");
                    }
                    case 39: {
                        return (Ba.o)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", Ba.o.class, "create(...)");
                    }
                    case 40: {
                        return (Ba.b)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", Ba.b.class, "create(...)");
                    }
                    case 41: {
                        T t4 = new T();
                        t4.a(M.f);
                        ApiClient apiClient0 = new ApiClient(Timeout.copy$default(Timeout.Companion.getDefault(), 0L, 0L, 0L, 0L, 7, null), new Ma.k(0));
                        ug.a a5 = ug.a.c();
                        t4.c.add(a5);
                        ResultCallAdapterFactory resultCallAdapterFactory4 = new ResultCallAdapterFactory();
                        t4.d.add(resultCallAdapterFactory4);
                        t4.c(apiClient0.getClient());
                        return t4.b();
                    }
                    case 42: {
                        return (S)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", S.class, "create(...)");
                    }
                    case 43: {
                        T t5 = new T();
                        t5.a(M.p);
                        ug.a a6 = ug.a.c();
                        t5.c.add(a6);
                        t5.c(new ApiClient(null, null, 3, null).getClient());
                        ResultCallAdapterFactory resultCallAdapterFactory5 = new ResultCallAdapterFactory();
                        t5.d.add(resultCallAdapterFactory5);
                        return t5.b();
                    }
                    case 44: {
                        return new v();
                    }
                    case 45: {
                        t.e(o0.a.a);
                        Ba.v v1 = (Ba.v)o0.V.get();
                        kotlin.jvm.internal.q.g(v1, "api");
                        oa.l l0 = new oa.l(v1);
                        t.e(o0.a.a);
                        GmsLocationDataSourceImpl gmsLocationDataSourceImpl0 = new GmsLocationDataSourceImpl(o0.a.a);
                        t.e(o0.a.a);
                        AndroidLocationDataSourceImpl androidLocationDataSourceImpl0 = new AndroidLocationDataSourceImpl(o0.a.a);
                        return new g(o0.a.a, l0, gmsLocationDataSourceImpl0, androidLocationDataSourceImpl0);
                    }
                    case 46: {
                        return (Ba.v)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", Ba.v.class, "create(...)");
                    }
                    case 0x2F: {
                        return new k8.k(this);
                    }
                    case 0x30: {
                        t.e(o0.a.a);
                        MusicPlaylistDBDataSource musicPlaylistDBDataSource0 = (MusicPlaylistDBDataSource)o0.Z.get();
                        kotlin.jvm.internal.q.g(musicPlaylistDBDataSource0, "musicPlaylistDbDataSource");
                        return new C0(musicPlaylistDBDataSource0, new EachPlytSettingPreferencesRepository(EachPlytSettingPreferencesSerializerKt.getMusicPlytPrefDataStore(o0.a.a)));
                    }
                    case 49: {
                        MusicPlaylistDao musicPlaylistDao0 = (MusicPlaylistDao)o0.Y.get();
                        kotlin.jvm.internal.q.g(musicPlaylistDao0, "musicPlaylistDao");
                        return new MusicPlaylistDBDataSource(musicPlaylistDao0);
                    }
                    case 50: {
                        PlaylistDao playlistDao0 = (PlaylistDao)o0.X.get();
                        kotlin.jvm.internal.q.g(playlistDao0, "playlistDao");
                        return playlistDao0;
                    }
                    case 51: {
                        PlaylistDao playlistDao1 = PlaylistDatabase.Companion.getInstance().playlistDao();
                        t.e(playlistDao1);
                        return playlistDao1;
                    }
                    case 52: {
                        Jb.b b1 = (Jb.b)o0.c0.get();
                        Jb.a a7 = (Jb.a)o0.d0.get();
                        kotlin.jvm.internal.q.g(b1, "offlineRemoteDataSource");
                        kotlin.jvm.internal.q.g(a7, "offlineLocalDataSource");
                        return new Jb.e(b1, a7);
                    }
                    case 53: {
                        E e0 = (E)o0.b0.get();
                        kotlin.jvm.internal.q.g(e0, "api");
                        return new Jb.b(e0);
                    }
                    case 54: {
                        return (E)com.iloen.melon.utils.a.j(((U)o0.R.get()), "retrofit", E.class, "create(...)");
                    }
                    case 55: {
                        return new Jb.a();  // 初始化器: Ljava/lang/Object;-><init>()V
                    }
                    case 56: {
                        return new k8.l(this);
                    }
                    case 57: {
                        t.e(o0.a.a);
                        return new B0(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), new EachPlytSettingPreferencesRepository(EachPlytSettingPreferencesSerializerKt.getDrawerPlytPrefDataStore(o0.a.a)));
                    }
                    case 58: {
                        return (Ba.l)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", Ba.l.class, "create(...)");
                    }
                    case 59: {
                        VolatileDatabase volatileDatabase0 = P.a;
                        if(volatileDatabase0 != null) {
                            c0 = volatileDatabase0.d();
                        }
                        return new ha.a(c0);
                    }
                    case 60: {
                        tc.E e1 = (tc.E)o0.k0.get();
                        kotlin.jvm.internal.q.g(e1, "stationPlaylistRepository");
                        return new tc.x(e1);
                    }
                    case 61: {
                        t.e(o0.a.a);
                        return new tc.E(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), new EachPlytSettingPreferencesRepository(EachPlytSettingPreferencesSerializerKt.getStationPlytPrefDataStore(o0.a.a)));
                    }
                    case 62: {
                        t.e(o0.a.a);
                        Object object10 = o0.m0.get();
                        Object object11 = o0.o0.get();
                        Object object12 = o0.q0.get();
                        db.g g0 = o0.o();
                        kotlin.jvm.internal.q.g(((E0)object10), "mixUpServerDataSource");
                        kotlin.jvm.internal.q.g(((pc.q)object11), "mixUpDbDataSource");
                        kotlin.jvm.internal.q.g(((pc.C0)object12), "mixupWaitingDbDataSource");
                        return new y0(((E0)object10), ((pc.q)object11), ((pc.C0)object12), new EachPlytSettingPreferencesRepository(EachPlytSettingPreferencesSerializerKt.getCommonMixUpPrefDataStore(o0.a.a)), MixUpPlaylistPreferenceSerializerKt.getMixUpPlaylistPreferenceDataStore(o0.a.a), g0);
                    }
                    case 0x3F: {
                        return new E0();  // 初始化器: Ljava/lang/Object;-><init>()V
                    }
                    case 0x40: {
                        MixUpPlaylistDao mixUpPlaylistDao0 = (MixUpPlaylistDao)o0.n0.get();
                        kotlin.jvm.internal.q.g(mixUpPlaylistDao0, "mixUpPlaylistDao");
                        return new pc.q(mixUpPlaylistDao0);
                    }
                    case 65: {
                        PlaylistDao playlistDao2 = (PlaylistDao)o0.X.get();
                        kotlin.jvm.internal.q.g(playlistDao2, "playlistDao");
                        return playlistDao2;
                    }
                    case 66: {
                        MixUpWaitingBackDao mixUpWaitingBackDao0 = (MixUpWaitingBackDao)o0.p0.get();
                        kotlin.jvm.internal.q.g(mixUpWaitingBackDao0, "mixUpWaitingBackDao");
                        return new pc.C0(mixUpWaitingBackDao0);
                    }
                    case 67: {
                        PlaylistDao playlistDao3 = (PlaylistDao)o0.X.get();
                        kotlin.jvm.internal.q.g(playlistDao3, "playlistDao");
                        return playlistDao3;
                    }
                    case 68: {
                        return new m(this);
                    }
                    case 69: {
                        t.e(o0.a.a);
                        SmartPlaylistDBDataSource smartPlaylistDBDataSource0 = (SmartPlaylistDBDataSource)o0.t0.get();
                        kotlin.jvm.internal.q.g(smartPlaylistDBDataSource0, "smartPlaylistDbSource");
                        return new f1(smartPlaylistDBDataSource0, new EachPlytSettingPreferencesRepository(EachPlytSettingPreferencesSerializerKt.getSmartPlaylistPrefDataStore(o0.a.a)));
                    }
                    case 70: {
                        SmartPlaylistDao smartPlaylistDao0 = (SmartPlaylistDao)o0.s0.get();
                        kotlin.jvm.internal.q.g(smartPlaylistDao0, "smartPlaylistDao");
                        return new SmartPlaylistDBDataSource(smartPlaylistDao0);
                    }
                    case 71: {
                        PlaylistDao playlistDao4 = (PlaylistDao)o0.X.get();
                        kotlin.jvm.internal.q.g(playlistDao4, "playlistDao");
                        return playlistDao4;
                    }
                    case 72: {
                        return new S2();
                    }
                    case 73: {
                        ea.b b2 = new ea.b(((u)o0.U.get()));
                        Pd.i i4 = (Pd.i)o0.A.get();
                        kotlin.jvm.internal.q.g(i4, "appVisibilityManager");
                        return new uc.A(b2, i4);
                    }
                    case 74: {
                        Pd.i i5 = (Pd.i)o0.A.get();
                        kotlin.jvm.internal.q.g(i5, "appVisibilityManager");
                        return new uc.j(i5);
                    }
                    case 75: {
                        return new rc.m(new MusicWavePlaylistRepositoryImpl(new MusicWavePlaylistRemoteDataSource(((B)o0.E.get()))));
                    }
                    case 76: {
                        return new t0(((Pd.i)o0.A.get()), ((Ub.q)o0.u.get()));
                    }
                    case 77: {
                        t.e(o0.a.a);
                        Pd.i i6 = (Pd.i)o0.A.get();
                        return new com.melon.playback.melon.drm.c(o0.a.a, i6);
                    }
                    case 78: {
                        return (Ba.M)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", Ba.M.class, "create(...)");
                    }
                    case 0x4F: {
                        t.e(o0.a.a);
                        return new PreferenceHelper(o0.a.a);
                    }
                    case 80: {
                        t.e(o0.a.a);
                        t.e(o0.a.a);
                        ImageUtils imageUtils0 = new ImageUtils(o0.a.a);
                        return new x2(o0.a.a, imageUtils0);
                    }
                    case 81: {
                        t.e(o0.a.a);
                        return new SystemSettingUtils(o0.a.a);
                    }
                    case 82: {
                        return (J)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", J.class, "create(...)");
                    }
                    case 83: {
                        return (Ba.i)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", Ba.i.class, "create(...)");
                    }
                    case 84: {
                        return (Ca.a)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", Ca.a.class, "create(...)");
                    }
                    case 85: {
                        return (H)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", H.class, "create(...)");
                    }
                    case 86: {
                        return new eb.a();  // 初始化器: Ljava/lang/Object;-><init>()V
                    }
                    case 87: {
                        k k1 = (k)o0.m.get();
                        kotlin.jvm.internal.q.g(k1, "loginUseCase");
                        return new eb.d(k1);
                    }
                    case 88: {
                        return new eb.b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    }
                    case 89: {
                        return (p)com.iloen.melon.utils.a.j(((U)o0.N0.get()), "retrofit", p.class, "create(...)");
                    }
                    case 90: {
                        T t6 = new T();
                        t6.a(M.l);
                        ug.a a8 = ug.a.c();
                        t6.c.add(a8);
                        t6.c(new ApiClient(null, null, 3, null).getClient());
                        ResultCallAdapterFactory resultCallAdapterFactory6 = new ResultCallAdapterFactory();
                        t6.d.add(resultCallAdapterFactory6);
                        return t6.b();
                    }
                    case 91: {
                        return (Ba.c)com.iloen.melon.utils.a.j(((U)o0.P0.get()), "retrofit", Ba.c.class, "create(...)");
                    }
                    case 92: {
                        T t7 = new T();
                        t7.a(M.e);
                        ug.a a9 = ug.a.c();
                        t7.c.add(a9);
                        t7.c(new ApiClient(null, null, 3, null).getClient());
                        ResultCallAdapterFactory resultCallAdapterFactory7 = new ResultCallAdapterFactory();
                        t7.d.add(resultCallAdapterFactory7);
                        return t7.b();
                    }
                    case 93: {
                        return (O)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", O.class, "create(...)");
                    }
                    case 94: {
                        return (Ba.P)com.iloen.melon.utils.a.j(((U)o0.S0.get()), "retrofit", Ba.P.class, "create(...)");
                    }
                    case 0x5F: {
                        T t8 = new T();
                        t8.a(M.c);
                        ug.a a10 = ug.a.c();
                        t8.c.add(a10);
                        t8.c(new ApiClient(null, null, 3, null).getClient());
                        ResultCallAdapterFactory resultCallAdapterFactory8 = new ResultCallAdapterFactory();
                        t8.d.add(resultCallAdapterFactory8);
                        return t8.b();
                    }
                    case 0x60: {
                        return (N)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", N.class, "create(...)");
                    }
                    case 97: {
                        return (h)com.iloen.melon.utils.a.j(((U)o0.V0.get()), "retrofit", h.class, "create(...)");
                    }
                    case 98: {
                        T t9 = new T();
                        t9.a(M.m);
                        ug.a a11 = ug.a.c();
                        t9.c.add(a11);
                        t9.c(new ApiClient(null, null, 3, null).getClient());
                        ResultCallAdapterFactory resultCallAdapterFactory9 = new ResultCallAdapterFactory();
                        t9.d.add(resultCallAdapterFactory9);
                        return t9.b();
                    }
                    case 99: {
                        return (Ba.g)com.iloen.melon.utils.a.j(((U)o0.V0.get()), "retrofit", Ba.g.class, "create(...)");
                    }
                    default: {
                        throw new AssertionError(v);
                    }
                }
            }
            case 1: {
                switch(v) {
                    case 100: {
                        return (s)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", s.class, "create(...)");
                    }
                    case 101: {
                        return (r)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", r.class, "create(...)");
                    }
                    case 102: {
                        return (Ba.m)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", Ba.m.class, "create(...)");
                    }
                    case 103: {
                        return (Ba.n)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", Ba.n.class, "create(...)");
                    }
                    case 104: {
                        T t10_1 = new T();
                        t10_1.a(M.a);
                        Timeout timeout0 = Timeout.copy$default(Timeout.Companion.getDefault(), 0L, 30000L, 0L, 0L, 13, null);
                        ug.a a12 = ug.a.c();
                        t10_1.c.add(a12);
                        t10_1.c(new ApiClient(timeout0, null, 2, null).getClient());
                        ResultCallAdapterFactory resultCallAdapterFactory10 = new ResultCallAdapterFactory();
                        t10_1.d.add(resultCallAdapterFactory10);
                        return t10_1.b();
                    }
                    case 105: {
                        return (Ba.z)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", Ba.z.class, "create(...)");
                    }
                    case 106: {
                        return (Ba.A)com.iloen.melon.utils.a.j(((U)o0.e1.get()), "retrofit", Ba.A.class, "create(...)");
                    }
                    case 107: {
                        T t11 = new T();
                        t11.a(M.d);
                        ug.a a13 = ug.a.c();
                        t11.c.add(a13);
                        t11.c(new ApiClient(null, null, 3, null).getClient());
                        ResultCallAdapterFactory resultCallAdapterFactory11 = new ResultCallAdapterFactory();
                        t11.d.add(resultCallAdapterFactory11);
                        return t11.b();
                    }
                    case 108: {
                        return (Ba.D)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", Ba.D.class, "create(...)");
                    }
                    case 109: {
                        return (Ca.b)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", Ca.b.class, "create(...)");
                    }
                    case 110: {
                        return (Ba.f)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", Ba.f.class, "create(...)");
                    }
                    case 0x6F: {
                        return (K)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", K.class, "create(...)");
                    }
                    case 0x70: {
                        return (G)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", G.class, "create(...)");
                    }
                    case 0x71: {
                        return (SearchApi)com.iloen.melon.utils.a.j(((U)o0.e1.get()), "retrofit", SearchApi.class, "create(...)");
                    }
                    case 0x72: {
                        return (Ca.c)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", Ca.c.class, "create(...)");
                    }
                    case 0x73: {
                        return (Ba.t)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", Ba.t.class, "create(...)");
                    }
                    case 0x74: {
                        return (Ba.u)com.iloen.melon.utils.a.j(((U)o0.e.get()), "retrofit", Ba.u.class, "create(...)");
                    }
                    case 0x75: {
                        t.e(o0.a.a);
                        A1 a10_1 = (A1)o0.p1.get();
                        return new Wb.b(o0.a.a, a10_1);
                    }
                    case 0x76: {
                        i i7 = (i)o0.v.get();
                        kotlin.jvm.internal.q.g(i7, "melonInternalPlaylistManager");
                        return new A1(i7, CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null))));
                    }
                    case 0x77: {
                        t.e(o0.a.a);
                        t.e(o0.a.a);
                        Ba.o o2 = (Ba.o)o0.P.get();
                        kotlin.jvm.internal.q.g(o2, "api");
                        Ga ga0 = new Ga(o2, 29);
                        Ub.q q2 = (Ub.q)o0.u.get();
                        cc.c c2 = new cc.c(o0.a.a, ga0, q2);
                        Object object13 = o0.r1.get();
                        Ba.k k2 = (Ba.k)o0.s1.get();
                        kotlin.jvm.internal.q.g(k2, "api");
                        fa.b b3 = new fa.b(k2);
                        Object object14 = o0.u.get();
                        Object object15 = o0.A0.get();
                        Object object16 = o0.p1.get();
                        u0 u00 = o0.p();
                        return new bc.c(o0.a.a, c2, ((bc.e)object13), b3, ((Ub.q)object14), ((t0)object15), ((A1)object16), u00);
                    }
                    case 120: {
                        bc.e e2 = new bc.e();  // 初始化器: Ljava/lang/Object;-><init>()V
                        e2.a = (s2)o0.w.get();
                        return e2;
                    }
                    case 0x79: {
                        return (Ba.k)com.iloen.melon.utils.a.j(((U)o0.R.get()), "retrofit", Ba.k.class, "create(...)");
                    }
                    case 0x7A: {
                        return new ec.c(((i)o0.v.get()));
                    }
                    default: {
                        throw new AssertionError(v);
                    }
                }
            }
            default: {
                throw new AssertionError(v);
            }
        }
    }
}

