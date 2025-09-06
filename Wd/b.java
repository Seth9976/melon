package wd;

import Ad.i;
import Ad.k;
import F8.m;
import F8.p;
import J8.c;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.iloen.melon.custom.LocalPlaylistCreatingInputBarView;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.V;
import i.n.i.b.a.s.e.M3;
import j3.n;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import td.L;
import we.a;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lwd/b;", "Lcom/melon/ui/C0;", "Lwd/t;", "LJ8/c;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class b extends v {
    public String B;
    public i D;
    public a l;
    public final LogU m;
    public List n;
    public String o;
    public List r;
    public String w;

    public b() {
        LogU logU0 = new LogU("AddToPlaylistDialogFragment");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.m = logU0;
        this.B = "";
    }

    @Override  // com.melon.ui.C0
    public final Q4.a getViewBinding(LayoutInflater layoutInflater0) {
        return c.a(layoutInflater0, null);
    }

    @Override  // com.melon.ui.C0
    public final Class getViewModelClass() {
        return t.class;
    }

    @Override  // com.melon.ui.C0
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.D = new i(new L(1, this, b.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 28), 1);
        t t0 = (t)this.getViewModel();
        t0.d = this.n;
        t t1 = (t)this.getViewModel();
        t1.e = this.o;
        t t2 = (t)this.getViewModel();
        t2.f = this.r;
        t t3 = (t)this.getViewModel();
        t3.c = this.w;
        t t4 = (t)this.getViewModel();
        String s = this.B;
        q.g(s, "<set-?>");
        t4.g = s;
    }

    @Override  // com.melon.ui.C0
    public final View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        c c0 = c.a(layoutInflater0, viewGroup0);
        this.f = c0;
        return c0.a;
    }

    @Override  // com.melon.ui.a0
    public final void onStart() {
        super.onStart();
        Dialog dialog0 = this.getDialog();
        if(dialog0 != null) {
            Window window0 = dialog0.getWindow();
            if(window0 != null) {
                WindowManager.LayoutParams windowManager$LayoutParams0 = window0.getAttributes();
                windowManager$LayoutParams0.windowAnimations = 0x7F140189;  // style:MelonDialogAnimation
                windowManager$LayoutParams0.width = -1;
                windowManager$LayoutParams0.height = -1;
                windowManager$LayoutParams0.flags = 0x400;
                window0.setBackgroundDrawableResource(0x7F06048A);  // color:transparent
            }
        }
    }

    @Override  // com.melon.ui.C0
    public final void onUiEvent(I4 i40) {
        q.g(i40, "event");
        if(i40 instanceof wd.i) {
            if(!((wd.i)i40).equals(wd.i.a)) {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            a a0 = this.l;
            if(a0 != null) {
                a0.invoke();
            }
            this.dismiss();
            return;
        }
        super.onUiEvent(i40);
    }

    @Override  // com.melon.ui.C0
    public final void onViewCreated(View view0, Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        c c0 = (c)this.f;
        if(c0 != null) {
            RecyclerView recyclerView0 = c0.e;
            recyclerView0.setLayoutManager(new LinearLayoutManager(recyclerView0.getContext()));
            recyclerView0.setBackgroundColor(ColorUtils.getColor(recyclerView0.getContext(), 0x7F0604AA));  // color:white000s_support_high_contrast
            i i0 = this.D;
            if(i0 != null) {
                recyclerView0.setAdapter(i0);
                recyclerView0.addOnScrollListener(new k(this, c0, recyclerView0, 2));
                goto label_14;
            }
            q.m("mAdapter");
            throw null;
        }
    label_14:
        c c1 = (c)this.f;
        if(c1 != null) {
            p p0 = new p(1);
            p0.c = new wd.a(this, 0);
            p0.g(new m(2, false));
            ((TitleBar)c1.f.c).a(p0);
            String s = ((t)this.getViewModel()).e;
            ((TitleBar)c1.f.c).setTitle(s);
            ((TitleBar)c1.f.c).f(true);
            LocalPlaylistCreatingInputBarView localPlaylistCreatingInputBarView0 = c1.c;
            localPlaylistCreatingInputBarView0.setDefaultPlayListTitle(null);
            localPlaylistCreatingInputBarView0.setPlaylistType(this.w);
            if(this.w == null || !this.w.equals("M20002")) {
                localPlaylistCreatingInputBarView0.setOnClickListener(new wa.a(this));
            }
            else {
                localPlaylistCreatingInputBarView0.setOnCreateListListener(new n(this, 13));
            }
        }
        this.sendUserEvent(l.a);
    }

    @Override  // com.melon.ui.C0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        String s = "renderUi() uiState: " + Cb.i.o(k40);
        LogU.info$default(this.m, s, null, false, 6, null);
        h h0 = k40 instanceof h ? ((h)k40) : null;
        if(h0 != null) {
            if(h0 instanceof g) {
                i i0 = this.D;
                if(i0 != null) {
                    V.e(i0, ((g)h0).a);
                    return;
                }
                q.m("mAdapter");
                throw null;
            }
            if(!(h0 instanceof f)) {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            c c0 = (c)this.f;
            if(c0 != null) {
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = c0.b.getLayoutParams();
                viewGroup$LayoutParams0.height = ScreenUtils.dipToPixel(c0.b.getContext(), 300.0f);
                c0.b.setLayoutParams(viewGroup$LayoutParams0);
                c0.b.setVisibility(0);
            }
            c c1 = (c)this.f;
            if(c1 != null) {
                c1.e.setVisibility(8);
            }
            if(q.b(this.w, "M20002") || q.b(this.w, "M20001") || q.b(this.w, "M20003")) {
                c c2 = (c)this.f;
                if(c2 != null) {
                    J8.a a0 = J8.a.a(c2.b.getChildAt(0));
                    q.f(a0.f, "emptyLayout");
                    a0.f.setVisibility(0);
                    a0.e.setVisibility(0);
                    String s1 = this.getString(0x7F130819);  // string:playlist_add_popup_empty_text "자주 듣는 곡을\n플레이리스트로 만들어 보세요!"
                    a0.i.setText(s1);
                    a0.i.setVisibility(0);
                    String s2 = this.getString(0x7F130818);  // string:playlist_add_popup_empty_sub_text "나만의 플레이리스트를 관리할 수 있어요."
                    a0.h.setText(s2);
                    a0.h.setVisibility(0);
                    String s3 = this.getString(0x7F130817);  // string:playlist_add "플레이리스트 만들기"
                    a0.b.setText(s3);
                    a0.b.setVisibility(8);
                    wd.a a1 = new wd.a(this, 1);
                    a0.b.setOnClickListener(a1);
                }
            }
        }
    }
}

