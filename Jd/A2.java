package jd;

import J8.V0;
import Q4.a;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.compose.ui.platform.ComposeView;
import cd.V2;
import com.melon.ui.K4;
import gd.T7;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import m0.b;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ljd/a2;", "Lcom/melon/ui/C0;", "Ljd/w2;", "LJ8/V0;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class a2 extends n {
    public v l;
    public boolean m;

    public a2() {
        this.m = true;
    }

    @Override  // com.melon.ui.a0
    public final boolean getShouldRetain() {
        return this.m;
    }

    @Override  // com.melon.ui.C0
    public final a getViewBinding(LayoutInflater layoutInflater0) {
        return V0.a(layoutInflater0, null);
    }

    @Override  // com.melon.ui.C0
    public final Class getViewModelClass() {
        return w2.class;
    }

    @Override  // com.melon.ui.C0
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        Bundle bundle1 = this.getArguments();
        if(bundle1 != null) {
            w2 w20 = (w2)this.getViewModel();
            w20.d = bundle1.getBoolean("KEY_IS_ARTIST");
            w2 w21 = (w2)this.getViewModel();
            w21.e = bundle1.getString("KEY_CHANNEL_ID");
            w2 w22 = (w2)this.getViewModel();
            w22.f = bundle1.getString("KEY_CHANNEL_TYPE");
            w2 w23 = (w2)this.getViewModel();
            w23.g = bundle1.getString("KEY_CHANNEL_KEY");
            w2 w24 = (w2)this.getViewModel();
            w24.h = bundle1.getString("KEY_CHANNEL_TITLE");
            w2 w25 = (w2)this.getViewModel();
            w25.i = bundle1.getString("KEY_IMAGE_SEQ");
        }
        this.setStyle(0, 0x7F14000C);  // style:AppPopupThemeFullScreen
    }

    @Override  // com.melon.ui.a0
    public final Dialog onCreateDialog(Bundle bundle0) {
        Dialog dialog0 = super.onCreateDialog(bundle0);
        Window window0 = dialog0.getWindow();
        if(window0 != null) {
            window0.requestFeature(1);
            WindowManager.LayoutParams windowManager$LayoutParams0 = window0.getAttributes();
            q.f(windowManager$LayoutParams0, "getAttributes(...)");
            windowManager$LayoutParams0.flags |= 0x200;
            window0.setAttributes(windowManager$LayoutParams0);
        }
        return dialog0;
    }

    @Override  // com.melon.ui.C0
    public final View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        V0 v00 = V0.a(layoutInflater0, viewGroup0);
        this.f = v00;
        return v00.a;
    }

    @Override  // com.melon.ui.a0
    public final void onStart() {
        super.onStart();
        Dialog dialog0 = this.getDialog();
        if(dialog0 != null) {
            Window window0 = dialog0.getWindow();
            if(window0 != null) {
                WindowManager.LayoutParams windowManager$LayoutParams0 = window0.getAttributes();
                windowManager$LayoutParams0.height = -1;
                windowManager$LayoutParams0.width = -1;
                window0.setBackgroundDrawableResource(0x106000D);
            }
        }
        this.sendUserEvent(s2.a);
    }

    @Override  // com.melon.ui.C0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        V0 v00 = (V0)this.f;
        if(v00 != null) {
            ComposeView composeView0 = v00.b;
            if(k40 instanceof q2) {
                composeView0.setContent(new b(329879073, new T7(19, k40, this), true));
                return;
            }
            if(k40 instanceof p2) {
                composeView0.setContent(new b(-1409150568, new V2(this, 17), true));
            }
        }
    }

    @Override  // com.melon.ui.a0
    public final void setShouldRetain(boolean z) {
        this.m = z;
    }
}

