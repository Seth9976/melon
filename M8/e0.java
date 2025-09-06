package m8;

import android.app.Activity;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.l0;
import com.android.volley.VolleyError;
import com.iloen.melon.playback.playlist.add.AddAction.AddPlay;
import com.iloen.melon.playback.playlist.add.AddAction.AddPlayOpenPlayer;
import com.iloen.melon.playback.playlist.add.AddServerContent;
import com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.MixUp;
import com.iloen.melon.utils.log.LogU;
import com.melon.net.exception.MelonNetworkError;
import com.melon.ui.popup.b;
import k8.a;
import k8.o;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import pc.G0;
import pc.I0;
import pc.R0;
import pc.T0;
import pc.X0;
import pc.b1;
import pc.h1;
import pc.p1;
import we.n;

public final class e0 extends i implements n {
    public final Activity B;
    public final boolean D;
    public final c r;
    public final H w;

    public e0(c c0, H h0, Activity activity0, boolean z, Continuation continuation0) {
        this.r = c0;
        this.w = h0;
        this.B = activity0;
        this.D = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new e0(this.r, this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((e0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(ie.H.a);
        return ie.H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        I0 i00;
        b b0 = b.a;
        Activity activity0 = this.B;
        c c0 = this.r;
        ie.H h0 = ie.H.a;
        d5.n.D(object0);
        l0 l00 = null;
        try {
            String s = c0.c1().getQueryParameter("mixuptype");
            if(s == null) {
                LogU.Companion.d("Deeplink-Play", "playMixUp: mixUpType is null");
                return h0;
            }
            H h1 = this.w;
            switch(s) {
                case "album": {
                    String s9 = c0.c1().getQueryParameter("cid");
                    if(s9 != null) {
                        i00 = new G0(14, null, s9, null, null);
                        goto label_51;
                    }
                    return h0;
                }
                case "artist": {
                    String s4 = c0.c1().getQueryParameter("cid");
                    if(s4 != null) {
                        i00 = new I0(s4, null, 6);
                        goto label_51;
                    }
                    return h0;
                }
                case "djplaylist": {
                    String s11 = c0.c1().getQueryParameter("cid");
                    if(s11 != null) {
                        i00 = new R0(s11, null, 6);
                        goto label_51;
                    }
                    return h0;
                }
                case "genre": {
                    String s10 = c0.c1().getQueryParameter("cid");
                    if(s10 != null) {
                        i00 = new T0(s10, null, 6);
                        goto label_51;
                    }
                    return h0;
                }
                case "mixmaker": {
                    String s5 = c0.c1().getQueryParameter("songids");
                    if(s5 != null) {
                        String s6 = c0.c1().getQueryParameter("title");
                        if(s6 != null) {
                            String s7 = c0.c1().getQueryParameter("cid");
                            if(s7 != null) {
                                i00 = new X0(s5, s6, s7, ((String)h1.a));
                                goto label_51;
                            }
                        }
                    }
                    return h0;
                }
                case "mixplaylist": {
                    String s1 = c0.c1().getQueryParameter("cid");
                    if(s1 != null) {
                        String s2 = c0.c1().getQueryParameter("songids");
                        if(s2 != null) {
                            String s3 = c0.c1().getQueryParameter("title");
                            if(s3 != null) {
                                i00 = new b1(s1, s2, s3, ((String)h1.a), null);
                                goto label_51;
                            }
                        }
                    }
                    return h0;
                }
                case "playlist": {
                    String s12 = c0.c1().getQueryParameter("cid");
                    if(s12 != null) {
                        i00 = new h1(s12, "", null);
                    label_51:
                        Context context0 = activity0.getApplicationContext();
                        q.f(context0, "getApplicationContext(...)");
                        a a0 = ((o)(((Ma.c)com.google.firebase.b.B(context0, Ma.c.class)))).d();
                        AddPlayOpenPlayer addAction$AddPlayOpenPlayer0 = this.D ? new AddPlayOpenPlayer(false) : new AddPlay(false);
                        AddToPlaylistUIHelperKt.addPlaylistAndReturnAction$default(activity0, new AddServerContent(addAction$AddPlayOpenPlayer0, false, false, a0, new MixUp(i00, ((String)h1.a), null), 6, null), false, 2, null);
                        return h0;
                    }
                    return h0;
                }
                case "song": {
                    String s8 = c0.c1().getQueryParameter("songids");
                    if(s8 != null) {
                        i00 = new p1(s8, ((String)h1.a), null);
                        goto label_51;
                    }
                    return h0;
                }
                default: {
                    LogU.Companion.d("Deeplink-Play", "playMixUp: mixUpType is null");
                    return h0;
                }
            }
        }
        catch(VolleyError volleyError0) {
        }
        catch(MelonNetworkError melonNetworkError0) {
            goto label_68;
        }
        AppCompatActivity appCompatActivity0 = activity0 instanceof AppCompatActivity ? ((AppCompatActivity)activity0) : null;
        if(appCompatActivity0 != null) {
            l00 = appCompatActivity0.getSupportFragmentManager();
        }
        b.d(b0, l00, "안내", volleyError0.getMessage(), false, false, false, null, null, null, null, null, 2040);
        return h0;
    label_68:
        AppCompatActivity appCompatActivity1 = activity0 instanceof AppCompatActivity ? ((AppCompatActivity)activity0) : null;
        if(appCompatActivity1 != null) {
            l00 = appCompatActivity1.getSupportFragmentManager();
        }
        b.d(b0, l00, "안내", melonNetworkError0.getMessage(), false, false, false, null, null, null, null, null, 2040);
        return h0;
    }
}

