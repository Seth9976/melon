package androidx.appcompat.widget;

import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.PopupWindow.OnDismissListener;
import androidx.core.view.ActionProvider;
import c2.c;
import java.util.ArrayList;

public final class u implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
    public final ActivityChooserView a;

    public u(ActivityChooserView activityChooserView0) {
        this.a = activityChooserView0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        ActivityChooserView activityChooserView0 = this.a;
        if(view0 == activityChooserView0.g) {
            activityChooserView0.a();
            this.a.a.a.e();
            p p0 = this.a.a.a;
            synchronized(p0.a) {
                p0.a();
                ArrayList arrayList0 = p0.b;
                if(arrayList0.size() <= 0) {
                    return;
                }
                if(arrayList0.get(0) == null) {
                    throw null;
                }
            }
            throw new ClassCastException();
        }
        if(view0 != activityChooserView0.e) {
            throw new IllegalArgumentException();
        }
        activityChooserView0.n = false;
        activityChooserView0.c(activityChooserView0.o);
    }

    @Override  // android.widget.PopupWindow$OnDismissListener
    public final void onDismiss() {
        ActivityChooserView activityChooserView0 = this.a;
        PopupWindow.OnDismissListener popupWindow$OnDismissListener0 = activityChooserView0.m;
        if(popupWindow$OnDismissListener0 != null) {
            popupWindow$OnDismissListener0.onDismiss();
        }
        ActionProvider actionProvider0 = activityChooserView0.i;
        if(actionProvider0 != null) {
            c c0 = actionProvider0.b;
            if(c0 != null) {
                ((ActionMenuPresenter)c0).n(false);
            }
        }
    }

    @Override  // android.widget.AdapterView$OnItemClickListener
    public final void onItemClick(AdapterView adapterView0, View view0, int v, long v1) {
        switch(((t)adapterView0.getAdapter()).getItemViewType(v)) {
            case 0: {
                this.a.a();
                ActivityChooserView activityChooserView0 = this.a;
                if(!activityChooserView0.n || v <= 0) {
                    return;
                }
                p p0 = activityChooserView0.a.a;
                Object object0 = p0.a;
                synchronized(object0) {
                    p0.a();
                    if(p0.b.get(v) == null && p0.b.get(0) == null) {
                        throw null;
                    }
                    throw new ClassCastException();
                }
            }
            case 1: {
                this.a.c(0x7FFFFFFF);
                return;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override  // android.view.View$OnLongClickListener
    public final boolean onLongClick(View view0) {
        ActivityChooserView activityChooserView0 = this.a;
        if(view0 != activityChooserView0.g) {
            throw new IllegalArgumentException();
        }
        if(activityChooserView0.a.getCount() > 0) {
            activityChooserView0.n = true;
            activityChooserView0.c(activityChooserView0.o);
        }
        return true;
    }
}

