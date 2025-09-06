package androidx.appcompat.widget;

import android.database.DataSetObserver;

public final class q extends DataSetObserver {
    public final int a;
    public final ActivityChooserView b;

    public q(ActivityChooserView activityChooserView0, int v) {
        this.a = v;
        this.b = activityChooserView0;
        super();
    }

    @Override  // android.database.DataSetObserver
    public final void onChanged() {
        if(this.a != 0) {
            super.onChanged();
            ActivityChooserView activityChooserView0 = this.b;
            if(activityChooserView0.a.getCount() > 0) {
                activityChooserView0.e.setEnabled(true);
            }
            else {
                activityChooserView0.e.setEnabled(false);
            }
            int v = activityChooserView0.a.a.d();
            p p0 = activityChooserView0.a.a;
            synchronized(p0.a) {
                p0.a();
            }
            if(v != 1 && (v <= 1 || p0.c.size() <= 0)) {
                activityChooserView0.g.setVisibility(8);
                if(activityChooserView0.g.getVisibility() == 0) {
                    activityChooserView0.c.setBackgroundDrawable(activityChooserView0.d);
                    return;
                }
                activityChooserView0.c.setBackgroundDrawable(null);
                return;
            }
            activityChooserView0.g.setVisibility(0);
            activityChooserView0.a.a.e();
            activityChooserView0.getContext().getPackageManager();
            throw null;
        }
        super.onChanged();
        this.b.a.notifyDataSetChanged();
    }

    @Override  // android.database.DataSetObserver
    public void onInvalidated() {
        if(this.a != 0) {
            super.onInvalidated();
            return;
        }
        super.onInvalidated();
        this.b.a.notifyDataSetInvalidated();
    }
}

