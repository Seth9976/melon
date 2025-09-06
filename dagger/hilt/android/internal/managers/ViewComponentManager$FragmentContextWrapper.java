package dagger.hilt.android.internal.managers;

import E4.b;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import androidx.fragment.app.I;

public final class ViewComponentManager.FragmentContextWrapper extends ContextWrapper {
    public LayoutInflater a;
    public LayoutInflater b;

    public ViewComponentManager.FragmentContextWrapper(Context context0, I i0) {
        context0.getClass();
        super(context0);
        b b0 = new b(this, 4);
        this.a = null;
        i0.getClass();
        i0.getLifecycle().a(b0);
    }

    public ViewComponentManager.FragmentContextWrapper(LayoutInflater layoutInflater0, I i0) {
        layoutInflater0.getClass();
        Context context0 = layoutInflater0.getContext();
        context0.getClass();
        super(context0);
        b b0 = new b(this, 4);
        this.a = layoutInflater0;
        i0.getClass();
        i0.getLifecycle().a(b0);
    }

    @Override  // android.content.ContextWrapper
    public final Object getSystemService(String s) {
        if(!"layout_inflater".equals(s)) {
            return this.getBaseContext().getSystemService(s);
        }
        if(this.b == null) {
            if(this.a == null) {
                this.a = (LayoutInflater)this.getBaseContext().getSystemService("layout_inflater");
            }
            this.b = this.a.cloneInContext(this);
        }
        return this.b;
    }
}

