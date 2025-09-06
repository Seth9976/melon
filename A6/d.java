package A6;

import R1.a;
import U4.x;
import Ub.c;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import androidx.media3.exoplayer.H;
import androidx.media3.exoplayer.e;
import androidx.media3.exoplayer.y;
import androidx.media3.session.Q;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.tablayout.ScrollableAlyacFilter;
import com.iloen.melon.fragments.DetailMetaContentBaseFragment;
import com.iloen.melon.playback.PhoneCallReceiver;
import com.iloen.melon.utils.log.LogU;
import com.kakao.emoticon.activity.adapter.EmoticonDownloadAdapter;
import i.n.i.b.a.s.e.Bc;
import i.n.i.b.a.s.e.S3;
import i.n.i.b.a.s.e.t0;
import i.n.i.b.a.s.e.zc;
import java.util.function.IntConsumer;
import kotlin.jvm.internal.q;

public final class d implements Runnable {
    public final int a;
    public final int b;
    public final Object c;

    public d(View view0, int v) {
        this.a = 11;
        super();
        this.b = v;
        this.c = view0;
    }

    public d(H h0, int v, boolean z) {
        this.a = 6;
        super();
        this.c = h0;
        this.b = v;
    }

    public d(Object object0, int v, int v1) {
        this.a = v1;
        this.c = object0;
        this.b = v;
        super();
    }

    @Override
    public final void run() {
        String s;
        int v = 2;
        int v1 = 1;
        int v2 = 0;
        int v3 = this.b;
        Object object0 = this.c;
        switch(this.a) {
            case 0: {
                View view0 = (View)((SideSheetBehavior)object0).r.get();
                if(view0 != null) {
                    ((SideSheetBehavior)object0).z(view0, v3, false);
                }
                return;
            }
            case 1: {
                if(((ScrollableAlyacFilter)object0).b != null) {
                    LinearLayout linearLayout0 = ((ScrollableAlyacFilter)object0).c;
                    if(linearLayout0 != null) {
                        View view1 = linearLayout0.getChildAt(v3);
                        if(view1 != null) {
                            ((ScrollableAlyacFilter)object0).b.scrollTo(view1.getLeft(), 0);
                        }
                    }
                }
                return;
            }
            case 2: {
                ((a)object0).j(v3);
                return;
            }
            case 3: {
                c c0 = (c)object0;
                switch(v3) {
                    case -3: {
                        s = "AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK";
                        break;
                    }
                    case -2: {
                        s = "AUDIOFOCUS_LOSS_TRANSIENT";
                        break;
                    }
                    case -1: {
                        s = "AUDIOFOCUS_LOSS";
                        break;
                    }
                    case 1: {
                        s = "AUDIOFOCUS_GAIN";
                        break;
                    }
                    default: {
                        s = "Unknown";
                    }
                }
                c0.i("focusChange. " + s);
                switch(v3) {
                    case -3: {
                        LogU.debug$default(c0.d, "audioFocusLossTransientCanDuck()", null, false, 6, null);
                        c0.j(3);
                        return;
                    }
                    case -2: {
                        if(c0.o != -1 && (c0.l == null || !c0.l.a)) {
                            LogU.debug$default(c0.d, "audioFocusLossTransient()", null, false, 6, null);
                            if(c0.i == null) {
                                v1 = c0.n;
                            }
                            else if(c0.g() && !c0.n) {
                                v1 = 0;
                            }
                            if(v1 != 0) {
                                c0.i("AUDIOFOCUS_LOSS_TRANSIENT ignored: callState isn\'t IDLE or keepAudioFocus");
                                return;
                            }
                            c0.c();
                            return;
                        }
                        LogU.debug$default(c0.d, "audioFocusLossTransient() ignored: not playing or isRemoteConnected", null, false, 6, null);
                        return;
                    }
                    case -1: {
                        LogU.debug$default(c0.d, "audioFocusLoss()", null, false, 6, null);
                        c0.m = false;
                        if(c0.n) {
                            c0.i("AUDIOFOCUS_LOSS ignored: keepAudioFocus");
                            return;
                        }
                        c0.d(-1);
                        c0.a();
                        LogU.debug$default(c0.d, "releasePhoneCallReceiver()", null, false, 6, null);
                        PhoneCallReceiver phoneCallReceiver0 = c0.i;
                        if(phoneCallReceiver0 != null) {
                            phoneCallReceiver0.release();
                        }
                        c0.i = null;
                        return;
                    }
                    case 1: {
                        c0.b();
                        return;
                    }
                    default: {
                        LogU.warn$default(c0.d, "Unknown focus change type: " + v3, null, false, 6, null);
                        return;
                    }
                }
            }
            case 4: {
                ((IntConsumer)object0).accept(v3);
                return;
            }
            case 5: {
                androidx.media3.exoplayer.d d0 = (androidx.media3.exoplayer.d)((androidx.media3.exoplayer.c)object0).c;
                switch(v3) {
                    case -3: 
                    case -2: {
                        if(v3 != -2 && (d0.d == null || d0.d.a != 1)) {
                            d0.c(4);
                            return;
                        }
                        y y0 = d0.c;
                        if(y0 != null) {
                            boolean z = y0.a.getPlayWhenReady();
                            y0.a.E0(0, 1, z);
                        }
                        d0.c(3);
                        return;
                    }
                    case -1: {
                        y y1 = d0.c;
                        if(y1 != null) {
                            boolean z1 = y1.a.getPlayWhenReady();
                            y1.a.E0(-1, 2, z1);
                        }
                        d0.a();
                        d0.c(1);
                        return;
                    }
                    case 1: {
                        d0.c(2);
                        y y2 = d0.c;
                        if(y2 != null) {
                            boolean z2 = y2.a.getPlayWhenReady();
                            y2.a.E0(1, 1, z2);
                            return;
                        }
                        return;
                    }
                    default: {
                        com.iloen.melon.utils.a.r(v3, "Unknown focus change type: ", "AudioFocusManager");
                        return;
                    }
                }
            }
            case 6: {
                e e0 = ((H)object0).a[v3];
                i3.a a0 = ((H)object0).N.u();
                i3.c c1 = new i3.c(21);
                ((H)object0).N.v(a0, 0x409, c1);
                return;
            }
            case 7: {
                ((Q)object0).j.remove(v3);
                return;
            }
            case 8: {
                return;
            }
            case 9: {
                ToolBar toolBar0 = (ToolBar)object0;
                toolBar0.getClass();
                D d1 = f0.d(toolBar0);
                if(d1 != null) {
                    t t0 = d1.getLifecycle();
                    Context context0 = toolBar0.getContext();
                    if(context0 != null && t0.b() != s.a) {
                        try {
                            String s1 = Integer.toString(v3);
                            String s2 = v3 == 1 ? context0.getString(0x7F130C73, new Object[]{s1}) : context0.getString(0x7F130C72, new Object[]{s1});  // string:talkback_toolbar_show_event_container_title "하단 툴바 영역에 곡 편집 메뉴 표시됨, 총 %1$s 
                                                                                                                                                        // 곡 선택됨"
                            toolBar0.c.announceForAccessibility(s2);
                            return;
                        }
                        catch(Exception exception0) {
                        }
                        LogU.w("ToolBar", "speakToolbarAccessibilityTitle() - " + exception0.getMessage());
                    }
                }
                return;
            }
            case 10: {
                DetailMetaContentBaseFragment.e0(((DetailMetaContentBaseFragment)object0), v3);
                return;
            }
            case 11: {
                if(v3 > 0) {
                    q.d(((View)object0));
                    if(((View)object0).getVisibility() != 0) {
                        ((View)object0).setVisibility(0);
                        v2 = 1;
                    }
                }
                else {
                    q.d(((View)object0));
                    if(((View)object0).getVisibility() == 0) {
                        ((View)object0).setVisibility(8);
                        v2 = 1;
                    }
                }
                if(((View)object0).getVisibility() == 0) {
                    ViewGroup.LayoutParams viewGroup$LayoutParams0 = ((View)object0).getLayoutParams();
                    if(viewGroup$LayoutParams0.height == v3) {
                        v1 = v2;
                    }
                    else {
                        viewGroup$LayoutParams0.height = v3;
                    }
                }
                else {
                    v1 = v2;
                }
                if(v1 != 0) {
                    ((View)object0).requestLayout();
                }
                return;
            }
            case 12: {
                EmoticonDownloadAdapter.a(((EmoticonDownloadAdapter)object0), v3);
                return;
            }
            case 13: {
                t0 t00 = (t0)((androidx.media3.exoplayer.c)object0).c;
                switch(v3) {
                    case -3: 
                    case -2: {
                        if(v3 != -2) {
                            t00.c(3);
                            return;
                        }
                        zc zc0 = t00.c;
                        if(zc0 != null) {
                            Bc bc0 = zc0.a;
                            boolean z3 = bc0.r1();
                            if(z3) {
                                v1 = 2;
                            }
                            bc0.B1(0, v1, z3);
                        }
                        t00.c(2);
                        return;
                    }
                    case -1: {
                        zc zc1 = t00.c;
                        if(zc1 != null) {
                            Bc bc1 = zc1.a;
                            boolean z4 = bc1.r1();
                            if(!z4) {
                                v = 1;
                            }
                            bc1.B1(-1, v, z4);
                        }
                        t00.b();
                        return;
                    }
                    case 1: {
                        t00.c(1);
                        zc zc2 = t00.c;
                        if(zc2 != null) {
                            boolean z5 = zc2.a.r1();
                            zc2.a.B1(1, 1, z5);
                            return;
                        }
                        return;
                    }
                    default: {
                        x.u(v3, "Unknown focus change type: ", "AudioFocusManager");
                        return;
                    }
                }
            }
            case 14: {
                ((S3)((ea.c)object0).c).m(v3);
                return;
            }
            default: {
                MusicBrowserActivity.v(((MusicBrowserActivity)object0), v3);
            }
        }
    }
}

