package Fc;

import A6.b;
import B9.g;
import Cb.i;
import Dd.g2;
import De.I;
import J8.D;
import Q4.a;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.w0;
import c2.M;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.K4;
import dagger.hilt.android.internal.managers.ViewComponentManager.FragmentContextWrapper;
import i.n.i.b.a.s.e.M3;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"LFc/t;", "Lcom/melon/ui/J0;", "LFc/D;", "LJ8/D;", "<init>", "()V", "Fc/s", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class t extends F {
    public final LogU d;
    public r e;
    public boolean f;

    public t() {
        LogU logU0 = new LogU("CoverScreenPlaylistFragment");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.d = logU0;
        this.f = true;
    }

    @Override  // com.melon.ui.c0
    public final boolean getShouldIgnoreForegroundEvent() {
        return this.f;
    }

    @Override  // com.melon.ui.J0
    public final a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D01AF, null, false);  // layout:cover_screen_playlist
        int v = 0x7F0A00E5;  // id:back
        View view1 = I.C(view0, 0x7F0A00E5);  // id:back
        if(((ImageView)view1) != null) {
            v = 0x7F0A0425;  // id:empty
            View view2 = I.C(view0, 0x7F0A0425);  // id:empty
            if(((MelonTextView)view2) != null) {
                v = 0x7F0A09D1;  // id:recycler_view
                View view3 = I.C(view0, 0x7F0A09D1);  // id:recycler_view
                if(((RecyclerView)view3) != null) {
                    v = 0x7F0A0B8D;  // id:title
                    View view4 = I.C(view0, 0x7F0A0B8D);  // id:title
                    if(((MelonTextView)view4) != null) {
                        return new D(((ConstraintLayout)view0), ((ImageView)view1), ((MelonTextView)view2), ((RecyclerView)view3), ((MelonTextView)view4));
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return Fc.D.class;
    }

    @Override  // com.melon.ui.J0
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.e = new r(((ViewComponentManager.FragmentContextWrapper)this.getContext()), new g2(1, this, t.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 3));
    }

    @Override  // com.melon.ui.c0
    public final void onPause() {
        super.onPause();
        l0 l00 = this.requireActivity().getSupportFragmentManager();
        l00.getClass();
        androidx.fragment.app.a a0 = new androidx.fragment.app.a(l00);
        a0.f(this);
        a0.k();
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null) {
            fragmentActivity0.finish();
        }
    }

    @Override  // com.melon.ui.J0
    public final void onViewCreated(View view0, Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        D d0 = (D)this.getBinding();
        if(d0 == null) {
            return;
        }
        g g0 = new g(4, d0, this);
        M.n(d0.a, g0);
        d0.a.requestApplyInsets();
        b b0 = new b(this, 5);
        d0.b.setOnClickListener(b0);
        RecyclerView recyclerView0 = d0.d;
        recyclerView0.setHasFixedSize(true);
        recyclerView0.setLayoutManager(new LinearLayoutManager(this.requireActivity()));
        r r0 = this.e;
        if(r0 != null) {
            recyclerView0.setAdapter(r0);
            return;
        }
        q.m("adapter");
        throw null;
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        String s = "renderUi() uiState: " + i.o(k40);
        LogU.debug$default(this.d, s, null, false, 6, null);
        if(k40 instanceof x) {
            if(((x)k40) instanceof v) {
                D d0 = (D)this.getBinding();
                if(d0 != null) {
                    MelonTextView melonTextView0 = d0.c;
                    if(melonTextView0 != null) {
                        melonTextView0.setVisibility(0);
                    }
                }
            }
            else {
                if(!(((x)k40) instanceof w)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                D d1 = (D)this.getBinding();
                if(d1 != null) {
                    q.f(d1.c, "empty");
                    d1.c.setVisibility(8);
                    int v = ((w)k40).b;
                    d1.e.setText(((w)k40).a);
                    r r0 = this.e;
                    if(r0 != null) {
                        q.g(((w)k40).d, "list");
                        r0.clear(false);
                        r0.b = v;
                        r0.c = ((w)k40).c;
                        r0.addAll(((w)k40).d);
                        w0 w00 = d1.d.getLayoutManager();
                        q.e(w00, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                        ((LinearLayoutManager)w00).scrollToPositionWithOffset(v, 0);
                        return;
                    }
                    q.m("adapter");
                    throw null;
                }
            }
        }
    }

    @Override  // com.melon.ui.c0
    public final void setShouldIgnoreForegroundEvent(boolean z) {
        this.f = z;
    }
}

