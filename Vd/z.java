package vd;

import J8.B;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.iloen.melon.fragments.detail.viewholder.p;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import td.L;
import we.k;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lvd/z;", "Lcom/melon/ui/a0;", "<init>", "()V", "vd/x", "vd/y", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class z extends F {
    public List j;
    public String k;
    public boolean l;
    public int m;
    public k n;
    public B o;
    public x r;

    public z() {
        LogU logU0 = new LogU("CommonTextListPopupDialogFragment");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
    }

    @Override  // com.melon.ui.a0
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        List list0 = this.j;
        if(list0 == null) {
            return;
        }
        this.r = new x(list0, this.l, this.m, new L(1, this, z.class, "sendEvent", "sendEvent(Lcom/melon/ui/popup/CommonTextListPopupClickEvent;)V", 0, 21));
    }

    @Override  // androidx.fragment.app.I
    public final View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        B b0 = B.a(layoutInflater0);
        this.o = b0;
        return b0.a;
    }

    @Override  // com.melon.ui.a0
    public final void onStart() {
        super.onStart();
        Dialog dialog0 = this.getDialog();
        if(dialog0 != null) {
            Window window0 = dialog0.getWindow();
            if(window0 != null) {
                WindowManager.LayoutParams windowManager$LayoutParams0 = window0.getAttributes();
                windowManager$LayoutParams0.gravity = 80;
                window0.getAttributes().width = -1;
                windowManager$LayoutParams0.windowAnimations = 0x7F140189;  // style:MelonDialogAnimation
                window0.setBackgroundDrawableResource(0x7F06048A);  // color:transparent
            }
        }
    }

    @Override  // com.melon.ui.a0
    public final void onViewCreated(View view0, Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        Dialog dialog0 = this.getDialog();
        if(dialog0 != null) {
            Window window0 = dialog0.getWindow();
            if(window0 != null) {
                window0.setBackgroundDrawable(new ColorDrawable(0));
            }
        }
        B b0 = this.o;
        if(b0 != null) {
            b0.e.setText(this.k);
        }
        B b1 = this.o;
        if(b1 != null) {
            RecyclerView recyclerView0 = b1.d;
            recyclerView0.setHasFixedSize(true);
            recyclerView0.setLayoutManager(new LinearLayoutManager(recyclerView0.getContext()));
            x x0 = this.r;
            if(x0 != null) {
                recyclerView0.setAdapter(x0);
                recyclerView0.addOnScrollListener(new Ad.k(this, b1, recyclerView0, 1));
                goto label_22;
            }
            q.m("mAdapter");
            throw null;
        }
    label_22:
        B b2 = this.o;
        if(b2 == null) {
            return;
        }
        p p0 = new p(this, 18);
        b2.c.setOnClickListener(p0);
    }
}

