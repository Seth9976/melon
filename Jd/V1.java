package jd;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.compose.ui.platform.ComposeView;
import cd.V2;
import com.iloen.melon.utils.system.ScreenUtils;
import com.melon.ui.a0;
import ed.w0;
import java.util.ArrayList;
import je.q;
import kotlin.Metadata;
import m0.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ljd/v1;", "Lcom/melon/ui/a0;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class v1 extends a0 {
    public ArrayList e;
    public w0 f;

    @Override  // com.melon.ui.a0
    public final void onCreate(Bundle bundle0) {
        ArrayList arrayList1;
        super.onCreate(bundle0);
        Bundle bundle1 = this.getArguments();
        if(bundle1 != null) {
            ArrayList arrayList0 = bundle1.getStringArrayList("KEY_URI_LIST");
            if(arrayList0 == null) {
                arrayList1 = null;
            }
            else {
                arrayList1 = new ArrayList(q.Q(10, arrayList0));
                for(Object object0: arrayList0) {
                    arrayList1.add(Uri.parse(((String)object0)));
                }
            }
            this.e = arrayList1;
        }
    }

    @Override  // androidx.fragment.app.I
    public final View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        kotlin.jvm.internal.q.g(layoutInflater0, "inflater");
        Context context0 = this.requireContext();
        kotlin.jvm.internal.q.f(context0, "requireContext(...)");
        View view0 = new ComposeView(context0, null, 6, 0);
        ((ComposeView)view0).setContent(new b(-683750764, new V2(this, 15), true));
        return view0;
    }

    @Override  // com.melon.ui.a0
    public final void onStart() {
        super.onStart();
        Dialog dialog0 = this.getDialog();
        if(dialog0 != null) {
            Window window0 = dialog0.getWindow();
            if(window0 != null) {
                WindowManager.LayoutParams windowManager$LayoutParams0 = window0.getAttributes();
                windowManager$LayoutParams0.width = ScreenUtils.dipToPixel(window0.getContext(), 300.0f);
                windowManager$LayoutParams0.height = ScreenUtils.dipToPixel(window0.getContext(), 403.0f);
                window0.setBackgroundDrawableResource(0x106000D);
            }
        }
    }
}

