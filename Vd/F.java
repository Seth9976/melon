package vd;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.compose.ui.platform.ComposeView;
import cd.V2;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import com.melon.ui.a0;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import m0.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lvd/f;", "Lcom/melon/ui/a0;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class f extends a0 {
    public String e;
    public String f;
    public String g;
    public Object h;
    public final boolean i;

    public f() {
        this.h = w.a;
        this.i = true;
    }

    @Override  // androidx.fragment.app.w
    public final void onCancel(DialogInterface dialogInterface0) {
        q.g(dialogInterface0, "dialog");
        super.onCancel(dialogInterface0);
    }

    @Override  // com.melon.ui.a0
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.setCancelable(this.i);
    }

    @Override  // androidx.fragment.app.I
    public final View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        Context context0 = this.requireContext();
        q.f(context0, "requireContext(...)");
        View view0 = new ComposeView(context0, null, 6, 0);
        ((ComposeView)view0).setContent(new b(555246300, new V2(this, 26), true));
        return view0;
    }

    @Override  // com.melon.ui.a0
    public final void onStart() {
        super.onStart();
        Dialog dialog0 = this.getDialog();
        if(dialog0 != null) {
            Window window0 = dialog0.getWindow();
            if(window0 != null) {
                window0.setBackgroundDrawableResource(0x106000D);
                WindowManager.LayoutParams windowManager$LayoutParams0 = window0.getAttributes();
                windowManager$LayoutParams0.width = ViewUtilsKt.dpToPx(270);
            }
        }
    }
}

