package Nb;

import Ac.U;
import Gd.F;
import Hd.D;
import Qb.z;
import android.content.Context;
import android.content.Intent;
import com.google.firebase.b;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.playback.Actor;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MusicAlarmPrefsHelper;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.FloatingLyricHelper;
import com.kakao.tiara.track.Event;
import com.melon.playback.MelonIntentService;
import com.melon.playlist.interfaces.SetRepeatResult;
import com.melon.playlist.interfaces.SetShuffleResult.Failure.SelectRepeatOn;
import com.melon.playlist.interfaces.SetShuffleResult.Success;
import com.melon.playlist.interfaces.SetShuffleResult;
import d5.t;
import e.k;
import e1.m;
import ie.H;
import java.util.EnumSet;
import k8.Y;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.i;
import pc.l1;
import q8.d;
import qd.W;
import we.n;
import y8.s;

public final class o extends i implements n {
    public final MelonIntentService B;
    public final Actor D;
    public final String E;
    public final U G;
    public final Intent I;
    public final C M;
    public W r;
    public int w;

    public o(MelonIntentService melonIntentService0, Actor actor0, String s, U u0, Intent intent0, C c0, Continuation continuation0) {
        this.B = melonIntentService0;
        this.D = actor0;
        this.E = s;
        this.G = u0;
        this.I = intent0;
        this.M = c0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new o(this.B, this.D, this.E, this.G, this.I, this.M, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((o)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        W w3;
        Object object3;
        W w1;
        Object object2;
        a a0 = a.a;
        H h0 = H.a;
        U u0 = this.G;
        Actor actor0 = this.D;
        C c0 = this.M;
        String s = this.E;
        MelonIntentService melonIntentService0 = this.B;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                LogConstantsKt.infoOnlyDebugMode(melonIntentService0.d, "processIntent() - actor:" + actor0 + ", action:" + s);
                if(EnumSet.of(Actor.Widget, new Actor[]{Actor.Widget_2x1, Actor.Widget_2x2, Actor.Widget_4x1, Actor.Widget_4x2, Actor.Widget_cover, Actor.EdgeSingle, Actor.EdgeSinglePlus}).contains(actor0)) {
                    if(Y.z(MelonAppBase.Companion)) {
                        ToastManager.show(0x7F130391);  // string:end_pip "PIP 모드를 종료하고 이용해주세요."
                        u0.invoke();
                        return h0;
                    }
                    s s1 = melonIntentService0.i;
                    if(s1 == null) {
                        q.m("playerUseCase");
                        throw null;
                    }
                    this.w = 1;
                    if(s1.y(this) == a0) {
                        return a0;
                    }
                }
                goto label_24;
            }
            case 1: {
                d5.n.D(object0);
            label_24:
                boolean z = "com.iloen.melon.intent.action.playservice.playpause".equals(s);
                Intent intent0 = this.I;
                if(z) {
                    s s2 = melonIntentService0.i;
                    if(s2 != null) {
                        boolean z1 = s2.n();
                        s s3 = melonIntentService0.i;
                        if(s3 != null) {
                            z z2 = (z)s3.a;
                            if(z1) {
                                z2.r();
                                s3.v();
                            }
                            else {
                                z2.s();
                            }
                            if(k.A(new Actor[]{Actor.Widget_2x1, Actor.Widget_2x2, Actor.Widget_4x1, Actor.Widget_4x2}).contains(actor0)) {
                                d d0 = new d();  // 初始化器: LQb/h;-><init>()V
                                new h(melonIntentService0, z1, 3).invoke(((q8.h)d0.b));
                                d0.c(new h(z1, melonIntentService0, 4));
                                d0.b(new F(melonIntentService0, actor0, z1, 1));
                                d0.d(new Ma.k(2));
                                ((Event)d0.p()).track();
                            }
                            else if(actor0 == Actor.Widget_cover) {
                                String s4 = String.valueOf(intent0.getIntExtra("com.iloen.melon.intent.extra.widget.page_meta_id", -1));
                                String s5 = intent0.getStringExtra("com.iloen.melon.intent.extra.widget.page_meta_name");
                                if(s5 == null) {
                                    s5 = "";
                                }
                                m.F(new D(melonIntentService0, z1, s4, s5)).track();
                            }
                            c0.a = true;
                            break;
                        }
                        q.m("playerUseCase");
                        throw null;
                    }
                    q.m("playerUseCase");
                    throw null;
                }
                else if("com.iloen.melon.intent.action.playservice.play".equals(s)) {
                    int v = intent0.getIntExtra("playlistId", -1);
                    int v1 = intent0.getIntExtra("position", -1);
                    Object object1 = U4.F.w(intent0, "playerActionIntent", Intent.class);
                    s s6 = melonIntentService0.i;
                    if(s6 != null) {
                        if(s6.n()) {
                            ((z)s6.a).r();
                            s6.v();
                        }
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new Nb.k(v, melonIntentService0, intent0, v1, ((Intent)object1), null), 3, null);
                        c0.a = true;
                        break;
                    }
                    q.m("playerUseCase");
                    throw null;
                }
                else if("com.iloen.melon.intent.action.playservice.autoplay".equals(s)) {
                    MusicAlarmPrefsHelper musicAlarmPrefsHelper0 = MusicAlarmPrefsHelper.INSTANCE;
                    if(!musicAlarmPrefsHelper0.isSendMusicAlarmListLog()) {
                        musicAlarmPrefsHelper0.sendMusicAlarmListLog();
                    }
                    s s7 = melonIntentService0.i;
                    if(s7 != null) {
                        if(!s7.n()) {
                            DevLog.Companion.get("AutoPlay").put("MelonIntentService.play()");
                            s s8 = melonIntentService0.i;
                            if(s8 != null) {
                                ((z)s8.a).s();
                                t.n();
                                c0.a = true;
                                break;
                            }
                            q.m("playerUseCase");
                            throw null;
                        }
                        t.n();
                        c0.a = true;
                        break;
                    }
                    q.m("playerUseCase");
                    throw null;
                }
                else if("com.iloen.melon.intent.action.playservice.autoplay.mixup".equals(s)) {
                    MusicAlarmPrefsHelper musicAlarmPrefsHelper1 = MusicAlarmPrefsHelper.INSTANCE;
                    if(!musicAlarmPrefsHelper1.isSendMusicAlarmListLog()) {
                        musicAlarmPrefsHelper1.sendMusicAlarmListLog();
                    }
                    String s9 = intent0.getStringExtra("songId");
                    String s10 = intent0.getStringExtra("songName");
                    String s11 = intent0.getStringExtra("artistIds");
                    if(s9 != null && s9.length() != 0 && s10 != null && s10.length() != 0 && s11 != null && s11.length() != 0) {
                        s s12 = melonIntentService0.i;
                        if(s12 == null) {
                            q.m("playerUseCase");
                            throw null;
                        }
                        else if(!s12.n()) {
                            l1 l10 = new l1(s9, s10, s11, null);
                            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new l(melonIntentService0, l10, null), 3, null);
                        }
                    }
                    t.n();
                    c0.a = true;
                }
                else if("com.iloen.melon.intent.action.playservice.prev".equals(s) || "com.iloen.melon.intent.action.playservice.forcedprev".equals(s)) {
                    boolean z5 = "com.iloen.melon.intent.action.playservice.forcedprev".equals(s);
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new Nb.m(melonIntentService0, z5, null), 3, null);
                    c0.a = true;
                }
                else if("com.iloen.melon.intent.action.playservice.next".equals(s)) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new Nb.n(melonIntentService0, null), 3, null);
                    c0.a = true;
                }
                else if("com.iloen.melon.intent.action.playservice.pause".equals(s)) {
                    intent0.getBooleanExtra("shutdown", false);
                    s s13 = melonIntentService0.i;
                    if(s13 != null) {
                        if(s13.n()) {
                            ((z)s13.a).r();
                        }
                        s13.v();
                        c0.a = true;
                        break;
                    }
                    q.m("playerUseCase");
                    throw null;
                }
                else if("com.iloen.melon.intent.action.playservice.floatingLyric".equals(s)) {
                    FloatingLyricHelper.requestStopFloatingLyric();
                    c0.a = true;
                }
                else if("com.iloen.melon.intent.action.playservice.replay".equals(s)) {
                    s s14 = melonIntentService0.i;
                    if(s14 != null) {
                        z z3 = (z)s14.a;
                        LogU.info$default(z3.h, "replay()", null, false, 6, null);
                        z3.f(new Qb.q(z3, null));
                        c0.a = true;
                        break;
                    }
                    q.m("playerUseCase");
                    throw null;
                }
                else {
                    boolean z4 = "com.iloen.melon.save_shuffle_mode".equals(s);
                    Class class0 = Ma.n.class;
                    if(z4) {
                        Context context0 = melonIntentService0.getApplicationContext();
                        q.d(context0);
                        W w0 = ((k8.o)(((Ma.n)b.B(context0, class0)))).s();
                        s s15 = melonIntentService0.i;
                        if(s15 != null) {
                            this.r = w0;
                            this.w = 2;
                            object2 = s15.x(this);
                            if(object2 == a0) {
                                return a0;
                            }
                            w1 = w0;
                            goto label_178;
                        }
                        q.m("playerUseCase");
                        throw null;
                    }
                    else if("com.iloen.melon.save_repeat_mode".equals(s)) {
                        Context context1 = melonIntentService0.getApplicationContext();
                        q.d(context1);
                        W w2 = ((k8.o)(((Ma.n)b.B(context1, class0)))).s();
                        s s16 = melonIntentService0.i;
                        if(s16 != null) {
                            this.r = w2;
                            this.w = 3;
                            object3 = s16.w(this);
                            if(object3 == a0) {
                                return a0;
                            }
                            w3 = w2;
                            goto label_188;
                        }
                        q.m("playerUseCase");
                        throw null;
                    }
                }
                break;
            }
            case 2: {
                w1 = this.r;
                d5.n.D(object0);
                object2 = object0;
            label_178:
                if(((SetShuffleResult)object2) instanceof Success) {
                    w1.d(((Success)(((SetShuffleResult)object2))));
                }
                else if(((SetShuffleResult)object2) instanceof SelectRepeatOn) {
                    w1.b(melonIntentService0);
                }
                c0.a = true;
                break;
            }
            case 3: {
                w3 = this.r;
                d5.n.D(object0);
                object3 = object0;
            label_188:
                if(((SetRepeatResult)object3) instanceof com.melon.playlist.interfaces.SetRepeatResult.Success) {
                    w3.c(((com.melon.playlist.interfaces.SetRepeatResult.Success)(((SetRepeatResult)object3))));
                }
                else if(((SetRepeatResult)object3) instanceof com.melon.playlist.interfaces.SetRepeatResult.Failure.SelectRepeatOn) {
                    w3.a(melonIntentService0);
                }
                c0.a = true;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(c0.a) {
            u0.invoke();
        }
        return h0;
    }
}

