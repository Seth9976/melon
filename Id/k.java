package id;

import De.I;
import F8.m;
import F8.p;
import J8.A2;
import J8.b;
import L4.e;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.f0;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.ProgressImageView;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.K4;
import com.melon.utils.system.SystemSettingUtils;
import d3.g;
import i.n.i.b.a.s.e.Ga;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import ob.z;
import x9.c;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lid/k;", "Lcom/melon/ui/o1;", "Lid/A;", "LJ8/A2;", "<init>", "()V", "id/i", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class k extends a {
    public final AccelerateInterpolator B;
    public final DecelerateInterpolator D;
    public final LogU d;
    public z e;
    public SystemSettingUtils f;
    public ProgressImageView g;
    public final int h;
    public final int i;
    public i j;
    public ScaleAnimation k;
    public j l;
    public e m;
    public boolean n;
    public boolean o;
    public f r;
    public final Ga w;

    public k() {
        LogU logU0 = new LogU("MusicSearchFragment");
        logU0.setCategory(Category.UI);
        this.d = logU0;
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null) {
            this.h = ColorUtils.getColor(fragmentActivity0, 0x7F060019);  // color:accent_green
            this.i = ColorUtils.getColor(fragmentActivity0, 0x7F06048A);  // color:transparent
        }
        this.w = new Ga(this, 13);
        this.B = new AccelerateInterpolator();
        this.D = new DecelerateInterpolator();
    }

    @Override  // com.melon.ui.o1
    public final String getPvDummyLogAction() {
        return "searchMusicResult";
    }

    @Override  // com.melon.ui.J0
    public final Q4.a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D0551, null, false);  // layout:music_search
        int v = 0x7F0A013C;  // id:btn_add_home
        View view1 = I.C(view0, 0x7F0A013C);  // id:btn_add_home
        if(((LinearLayout)view1) != null) {
            v = 0x7F0A01A6;  // id:btn_search
            View view2 = I.C(view0, 0x7F0A01A6);  // id:btn_search
            if(((ImageView)view2) != null) {
                v = 0x7F0A05EE;  // id:iv_amplitude
                View view3 = I.C(view0, 0x7F0A05EE);  // id:iv_amplitude
                if(((ImageView)view3) != null && ((LinearLayout)I.C(view0, 0x7F0A09C9)) != null) {  // id:record
                    v = 0x7F0A0A47;  // id:search_progress
                    View view4 = I.C(view0, 0x7F0A0A47);  // id:search_progress
                    if(((ProgressImageView)view4) != null) {
                        v = 0x7F0A0BAD;  // id:titlebar
                        View view5 = I.C(view0, 0x7F0A0BAD);  // id:titlebar
                        if(view5 != null) {
                            b b0 = new b(((TitleBar)view5), ((TitleBar)view5), 12);
                            v = 0x7F0A0D01;  // id:tv_search_main
                            View view6 = I.C(view0, 0x7F0A0D01);  // id:tv_search_main
                            if(((MelonTextView)view6) != null && ((MelonTextView)I.C(view0, 0x7F0A0D02)) != null) {  // id:tv_search_sub
                                return new A2(((RelativeLayout)view0), ((LinearLayout)view1), ((ImageView)view2), ((ImageView)view3), ((ProgressImageView)view4), b0, ((MelonTextView)view6));
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return A.class;
    }

    @Override  // com.melon.ui.c0
    public final boolean isShowTabAndMiniPlayer() {
        return false;
    }

    public final void n() {
        A a0 = (A)this.getViewModel();
        f f0 = this.r;
        hd.i i0 = new hd.i(this, 6);
        a0.getClass();
        a0.c = true;
        BuildersKt__Builders_commonKt.launch$default(f0.h(a0), null, null, new x(a0, i0, f0, null), 3, null);
    }

    public final void o(String s) {
        LogU.debug$default(this.d, "startSearchMusic : " + s, null, false, 6, null);
        this.n = false;
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null) {
            if(!Td.b.e(fragmentActivity0, "android.permission.RECORD_AUDIO")) {
                Td.b.b(this.getActivity(), 2, new c(11, this, fragmentActivity0));
                return;
            }
            this.n();
        }
    }

    @Override  // com.melon.ui.o1
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        A a0 = (A)this.getViewModel();
        z z0 = this.e;
        if(z0 != null) {
            f f0 = new f(a0, z0);
            f0.i = this.w;
            this.r = f0;
            this.o = true;
            return;
        }
        q.m("playerUseCase");
        throw null;
    }

    @Override  // com.melon.ui.c0
    public final void onDestroy() {
        f f0 = this.r;
        if(f0 != null) {
            f0.i = null;
            LogU.Companion.d("MusicSearchController", "destroy()");
            f0.a();
            f0.j.removeCallbacksAndMessages(null);
            f0.l.removeCallbacksAndMessages(null);
            f0.k.quitSafely();
        }
        this.r = null;
        g.d0("X1", ((A)this.getViewModel()).getMenuId(), "");
        super.onDestroy();
    }

    @Override  // com.melon.ui.c0
    public final void onPause() {
        this.p();
        super.onPause();
    }

    @Override  // com.melon.ui.c0
    public final void onResume() {
        super.onResume();
        if(this.o) {
            this.o = false;
            this.o("onResume");
        }
    }

    @Override  // com.melon.ui.J0
    public final void onViewCreated(View view0, Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        A2 a20 = (A2)this.getBinding();
        if(a20 == null) {
            return;
        }
        p p0 = new p(1);
        String s = this.getString(0x7F130B36);  // string:talkback_gnb_musicsearch_close "음악검색 닫기"
        q.f(s, "getString(...)");
        p0.d = s;
        m m0 = new m(2, false);
        F8.x x0 = new F8.x(6);
        String s1 = this.getString(0x7F130B37);  // string:talkback_gnb_musicsearch_history "검색 기록 열기"
        q.f(s1, "getString(...)");
        x0.d = s1;
        x0.c = new Gd.f(17);
        p0.g(m0);
        p0.g(x0);
        ((TitleBar)a20.f.c).a(p0);
        String s2 = this.getString(0x7F130718);  // string:music_search_title "음악 검색"
        ((TitleBar)a20.f.c).setTitle(s2);
        ((TitleBar)a20.f.c).f(true);
        Ud.j j0 = new Ud.j();
        id.g g0 = new id.g(this, 0);
        Ud.j.a(j0, ((TitleBar)a20.f.c), g0);
        a20.e.setPointerColor(this.i);
        this.g = a20.e;
        ProgressImageView progressImageView0 = this.g;
        if(progressImageView0 != null) {
            this.j = new i(this, progressImageView0);
            this.q(this.o);
            h h0 = new h(this, 0);
            a20.c.setOnClickListener(h0);
            h h1 = new h(this, 1);
            a20.b.setOnClickListener(h1);
            this.l = new j(this, a20);
            this.m = new e(this, 2);
            return;
        }
        q.m("progressBar");
        throw null;
    }

    public final void p() {
        f f0 = this.r;
        if(f0 != null && (f0.f != null && f0.f.g != 0L && f0 != null)) {
            Companion logU$Companion0 = LogU.Companion;
            logU$Companion0.d("MusicSearchController", "stopSearchMusic()");
            F f1 = f0.f;
            if(f1 != null) {
                f1.cancel();
            }
            logU$Companion0.d("MusicSearchController", "abortSendingFile()");
            f0.b(null, 2004, -1, 0L);
        }
    }

    public final void q(boolean z) {
        A2 a20 = (A2)this.getBinding();
        if(a20 != null) {
            MelonTextView melonTextView0 = a20.g;
            ImageView imageView0 = a20.c;
            if(z) {
                imageView0.setBackgroundResource(0x7F08025A);  // drawable:btn_search_stop
                imageView0.setContentDescription(this.getString(0x7F130C39));  // string:talkback_search_stop "검색 중지"
                melonTextView0.setText(this.getString(0x7F130905));  // string:search_sound_run_info_large "음악을 찾고 있습니다."
            }
            else {
                imageView0.setBackgroundResource(0x7F080258);  // drawable:btn_search_music
                imageView0.setContentDescription(this.getString(0x7F130C38));  // string:talkback_search_start "검색 시작"
                melonTextView0.setText(this.getString(0x7F130907));  // string:search_sound_start_info_large "버튼을 누른 후 음악을 들려주세요."
            }
            if(!z) {
                goto label_23;
            }
            ProgressImageView progressImageView0 = this.g;
            if(progressImageView0 == null) {
                q.m("progressBar");
                throw null;
            }
            progressImageView0.setPointerColor(this.h);
            if(this.j != null && !this.j.hasMessages(1) == 1) {
                i i0 = this.j;
                if(i0 != null) {
                    i0.sendEmptyMessage(1);
                    return;
                label_23:
                    if(this.j != null && this.j.hasMessages(1)) {
                        i i1 = this.j;
                        if(i1 != null) {
                            i1.removeMessages(1);
                        }
                    }
                    ProgressImageView progressImageView1 = this.g;
                    if(progressImageView1 != null) {
                        progressImageView1.setProgress(0);
                        progressImageView1.setPointerColor(this.i);
                        return;
                    }
                    q.m("progressBar");
                    throw null;
                }
            }
        }
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
    }
}

