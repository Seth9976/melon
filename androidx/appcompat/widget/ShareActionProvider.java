package androidx.appcompat.widget;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import androidx.core.view.ActionProvider;
import d5.w;
import k.C;

public class ShareActionProvider extends ActionProvider {
    public final int d;
    public final Context e;
    public final String f;

    public ShareActionProvider(Context context0) {
        super(context0);
        this.d = 4;
        this.f = "share_history.xml";
        this.e = context0;
    }

    @Override  // androidx.core.view.ActionProvider
    public final View c() {
        Context context0 = this.e;
        View view0 = new ActivityChooserView(context0);
        if(!view0.isInEditMode()) {
            ((ActivityChooserView)view0).setActivityChooserModel(p.b(context0, this.f));
        }
        TypedValue typedValue0 = new TypedValue();
        context0.getTheme().resolveAttribute(0x7F040026, typedValue0, true);  // attr:actionModeShareDrawable
        ((ActivityChooserView)view0).setExpandActivityOverflowButtonDrawable(w.B(context0, typedValue0.resourceId));
        ((ActivityChooserView)view0).setProvider(this);
        ((ActivityChooserView)view0).setExpandActivityOverflowButtonContentDescription(0x7F130018);  // string:abc_shareactionprovider_share_with "Share with"
        return view0;
    }

    @Override  // androidx.core.view.ActionProvider
    public final void f(C c0) {
        c0.clear();
        p p0 = p.b(this.e, this.f);
        this.e.getPackageManager();
        int v = p0.d();
        int v1 = Math.min(v, this.d);
        if(v1 <= 0) {
            if(v1 < v) {
                c0.addSubMenu(0, v1, v1, "See all");
                if(v > 0) {
                    p0.c(0);
                    throw null;
                }
            }
            return;
        }
        p0.c(0);
        throw null;
    }
}

