package b9;

import U4.F;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.I;
import androidx.fragment.app.l0;
import b3.z;
import c2.M;
import com.kakao.emoticon.ui.PopupEmoticonFragment;
import kotlin.jvm.internal.q;

public final class c extends F {
    @Override  // U4.F
    public final void P(l0 l00, I i0, View view0) {
        q.g(i0, "f");
        q.g(view0, "v");
        PopupEmoticonFragment popupEmoticonFragment0 = i0 instanceof PopupEmoticonFragment ? ((PopupEmoticonFragment)i0) : null;
        if(popupEmoticonFragment0 != null) {
            Dialog dialog0 = popupEmoticonFragment0.getDialog();
            if(dialog0 != null) {
                Window window0 = dialog0.getWindow();
                if(window0 != null) {
                    View view1 = window0.getDecorView();
                    if(view1 != null) {
                        M.n(view1, new z(9));
                        view1.requestApplyInsets();
                        l00.p0(this);
                    }
                }
            }
        }
    }
}

