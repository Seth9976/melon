package com.melon.ui.playback;

import B.a;
import Bc.e;
import Bc.h;
import Ma.n;
import Ub.q;
import Ub.s;
import Ub.u;
import Ub.v;
import android.content.Context;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import com.iloen.melon.custom.RepeatingImageButton;
import com.iloen.melon.playback.StateView;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.HashMap;
import k8.Y;
import k8.o;
import kc.s2;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ob.z;
import org.jetbrains.annotations.NotNull;
import pd.i;
import pd.j;
import pd.k;
import pd.p;
import pd.t;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0006\u0007B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/melon/ui/playback/VideoControllerHelper;", "Landroid/view/View$OnClickListener;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "pd/j", "pd/i", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoControllerHelper implements View.OnClickListener {
    public final Context a;
    public final LogU b;
    public final s2 c;
    public final q d;
    public final h e;
    public final z f;
    public final s g;
    public final u h;
    public CoroutineScope i;
    public Job j;
    public i k;
    public final HashMap l;
    public StateView m;
    public final MutableStateFlow n;
    public final pd.h o;
    public final pd.h r;

    public VideoControllerHelper(@NotNull Context context0) {
        kotlin.jvm.internal.q.g(context0, "context");
        super();
        this.a = context0;
        this.b = Companion.create$default(LogU.Companion, "VideoControllerHelper", false, Category.Playback, 2, null);
        this.c = a.G(context0);
        this.d = (q)((o)a.F(context0)).u.get();
        this.e = ((o)(((n)Y.e(context0, n.class)))).j();
        this.f = ((o)(((Ma.o)Y.e(context0, Ma.o.class)))).k();
        this.g = (s)((o)a.F(context0)).z.get();
        this.h = P4.a.t(context0);
        this.l = new HashMap();
        this.n = StateFlowKt.MutableStateFlow(new pd.a(false, false, "", "", "", 0L, 0L, 0x8000000000000001L, false, false, null));
        this.o = new pd.h(this, 0);
        this.r = new pd.h(this, 1);
    }

    public final void a(int v, StateView stateView0) {
        kotlin.jvm.internal.q.g(stateView0, "stateView");
        stateView0.setId(v);
        if(stateView0.getView() != null) {
            stateView0.getView().setTag(0x7F1310F6, stateView0);  // string:view_player_controller "view player controller"
            if(j.a.contains(v)) {
                ViewUtils.setOnClickListener(stateView0.getView(), this);
            }
            else if(!j.b.contains(v)) {
                ViewUtils.setOnClickListener(stateView0.getView(), this);
            }
        }
        View view0 = null;
        switch(v) {
            case 0: {
                View view3 = stateView0.getView();
                kotlin.jvm.internal.q.f(view3, "getView(...)");
                if(view3 instanceof RepeatingImageButton) {
                    view0 = view3;
                }
                if(((RepeatingImageButton)view0) != null) {
                    ((RepeatingImageButton)view0).setContentDescription("이전");
                    ((RepeatingImageButton)view0).f = this.r;
                    ((RepeatingImageButton)view0).g = 0xFAL;
                }
                break;
            }
            case 1: {
                View view2 = stateView0.getView();
                kotlin.jvm.internal.q.f(view2, "getView(...)");
                if(view2 instanceof RepeatingImageButton) {
                    view0 = view2;
                }
                if(((RepeatingImageButton)view0) != null) {
                    ((RepeatingImageButton)view0).setContentDescription("다음");
                    ((RepeatingImageButton)view0).f = this.o;
                    ((RepeatingImageButton)view0).g = 0xFAL;
                }
                break;
            }
            case 2: 
            case 3: {
                this.m = stateView0;
                break;
            }
            case 13: {
                View view1 = stateView0.getView();
                kotlin.jvm.internal.q.f(view1, "getView(...)");
                if(view1 instanceof SeekBar) {
                    view0 = view1;
                }
                if(((SeekBar)view0) != null) {
                    ((SeekBar)view0).setOnSeekBarChangeListener(new pd.u(this));
                    hd.i i0 = new hd.i(this, 21);
                    this.e.getClass();
                    ((SeekBar)view0).setOnKeyListener(new e(i0, ((SeekBar)view0)));
                }
            }
        }
        this.l.put(v, stateView0);
    }

    public final StateView b(int v) {
        return (StateView)this.l.get(v);
    }

    public final void c() {
        TextView textView1;
        TextView textView0;
        SeekBar seekBar0;
        LogU.info$default(this.b, "onUiStart()", null, false, 6, null);
        CoroutineScope coroutineScope0 = this.i;
        if(coroutineScope0 != null) {
            CoroutineScopeKt.cancel$default(coroutineScope0, "cancelCollectControllerState() Cancel", null, 2, null);
        }
        this.i = null;
        CoroutineScope coroutineScope1 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        Job job0 = this.j;
        if(job0 != null) {
            JobKt__JobKt.cancel$default(job0, "cancelPlaybackState() Cancel", null, 2, null);
        }
        this.j = BuildersKt__Builders_commonKt.launch$default(coroutineScope1, null, null, new pd.n(this, coroutineScope1, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope1, null, null, new k(this, null), 3, null);
        StateView stateView0 = this.b(13);
        if(stateView0 == null) {
            seekBar0 = null;
        }
        else {
            View view0 = stateView0.getView();
            if(view0 == null) {
                seekBar0 = null;
            }
            else {
                if(!(view0 instanceof SeekBar)) {
                    view0 = null;
                }
                seekBar0 = (SeekBar)view0;
            }
        }
        if(seekBar0 != null) {
            StateView stateView1 = this.b(11);
            if(stateView1 == null) {
                textView0 = null;
            }
            else {
                View view1 = stateView1.getView();
                if(view1 == null) {
                    textView0 = null;
                }
                else {
                    if(!(view1 instanceof TextView)) {
                        view1 = null;
                    }
                    textView0 = (TextView)view1;
                }
            }
            StateView stateView2 = this.b(12);
            if(stateView2 == null) {
                textView1 = null;
            }
            else {
                View view2 = stateView2.getView();
                if(view2 == null) {
                    textView1 = null;
                }
                else {
                    if(!(view2 instanceof TextView)) {
                        view2 = null;
                    }
                    textView1 = (TextView)view2;
                }
            }
            BuildersKt__Builders_commonKt.launch$default(coroutineScope1, null, null, new t(seekBar0, textView0, textView1, this, null), 3, null);
        }
        StateView stateView3 = this.b(21);
        if(stateView3 != null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope1, null, null, new p(this, stateView3, null), 3, null);
        }
        this.i = coroutineScope1;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        boolean z = false;
        kotlin.jvm.internal.q.g(view0, "view");
        Object object0 = view0.getTag(0x7F1310F6);  // string:view_player_controller "view player controller"
        LogU.debug$default(this.b, "onClick() tag: " + object0, null, false, 6, null);
        StateView stateView0 = object0 instanceof StateView ? ((StateView)object0) : null;
        if(stateView0 != null && !(this.k == null ? false : this.k.onViewPreClick(stateView0))) {
            z z1 = this.f;
            switch(stateView0.getId()) {
                case 0: {
                    z1.e.t(false);
                    break;
                }
                case 1: {
                    z1.e.q();
                    break;
                }
                case 2: 
                case 3: {
                    Qb.z z3 = z1.e;
                    if(z1.c.a().b) {
                        z3.r();
                    }
                    else {
                        z3.s();
                    }
                    break;
                }
                case 20: {
                    boolean z2 = ((v)this.h).a();
                    ((v)this.h).c(!z2);
                    if(z2) {
                        ToastManager.show(0x7F1310EC);  // string:vdo_recommend_video_option_toast_off "자동재생이 종료됩니다."
                    }
                    else {
                        ToastManager.show(0x7F1310ED);  // string:vdo_recommend_video_option_toast_on "자동재생을 시작합니다. 추천 비디오가 자동 재생됩니다."
                    }
                    do {
                        Object object1 = this.n.getValue();
                        kotlin.jvm.internal.q.g(((pd.a)object1), "it");
                        pd.a a0 = pd.a.a(((pd.a)object1), false, false, null, null, null, 0L, 0L, 0L, false, !z2, null, 0x5FF);
                    }
                    while(!this.n.compareAndSet(object1, a0));
                    z = true;
                    break;
                }
                default: {
                    z = true;
                }
            }
            if(z) {
                i i0 = this.k;
                if(i0 != null) {
                    i0.onViewPostClick(stateView0);
                }
            }
        }
    }
}

