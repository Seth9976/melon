package xd;

import Cb.i;
import J8.Q0;
import Q4.a;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.compose.ui.platform.ComposeView;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.CompatUtils;
import com.melon.ui.G4;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.popup.b;
import i.n.i.b.a.s.e.M3;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import we.k;
import zd.Q;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lxd/c;", "Lzd/h;", "Lxd/r;", "LJ8/Q0;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class c extends s {
    public final LogU n;
    public k o;

    public c() {
        LogU logU0 = new LogU("ArtistMultiPopupDialogFragment");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.n = logU0;
    }

    @Override  // com.melon.ui.w0
    public final a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return Q0.a(layoutInflater0, null);
    }

    @Override  // com.melon.ui.w0
    public final Class getViewModelClass() {
        return r.class;
    }

    @Override  // com.melon.ui.w0
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        Bundle bundle1 = this.getArguments();
        if(bundle1 != null) {
            r r0 = (r)this.getViewModel();
            bundle1.getString("KEY_TITLE");
            r0.getClass();
            r r1 = (r)this.getViewModel();
            r1.c = bundle1.getInt("KEY_TYPE_CONTEXT_MENU");
            r r2 = (r)this.getViewModel();
            r2.d = (Q)CompatUtils.getSerializable(bundle1, "KEY_POPUP_TYPE", Q.class);
        }
        this.setStyle(0, 0x7F140188);  // style:MelonBottomSheetDialog
    }

    @Override  // com.melon.ui.w0
    public final View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        this.setBinding(Q0.a(layoutInflater0, null));
        Q0 q00 = (Q0)this.getBinding();
        return q00 != null ? q00.a : null;
    }

    @Override  // zd.h
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

    @Override  // com.melon.ui.w0
    public final void onUiEvent(I4 i40) {
        q.g(i40, "event");
        if(i40 instanceof m) {
            k k0 = this.o;
            if(k0 != null) {
                k0.invoke(new g(((m)i40).c, ((m)i40).a, ((m)i40).b));
            }
            this.dismiss();
            return;
        }
        if(i40 instanceof G4) {
            b.k(this.getContext(), this.getParentFragmentManager(), 16);
            return;
        }
        super.onUiEvent(i40);
    }

    @Override  // com.melon.ui.w0
    public final void onViewCreated(View view0, Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.sendUserEvent(o.a);
    }

    @Override  // com.melon.ui.w0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        String s = "renderUi() uiState: " + i.o(k40);
        LogU.info$default(this.n, s, null, false, 6, null);
        Q0 q00 = (Q0)this.getBinding();
        if(q00 != null) {
            ComposeView composeView0 = q00.b;
            l l0 = k40 instanceof l ? ((l)k40) : null;
            if(l0 != null) {
                if(l0 instanceof xd.k) {
                    composeView0.setContent(new m0.b(0x4D07A70, new xd.a(this, l0, 0), true));
                    return;
                }
                if(l0 instanceof xd.i) {
                    this.dismiss();
                    return;
                }
                if(!(l0 instanceof j)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                composeView0.setContent(new m0.b(1205403064, new xd.a(this, l0, 1), true));
            }
        }
    }
}

