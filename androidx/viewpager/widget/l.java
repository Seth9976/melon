package androidx.viewpager.widget;

import android.database.DataSetObserver;

public final class l extends DataSetObserver {
    public final ViewPager a;

    public l(ViewPager viewPager0) {
        this.a = viewPager0;
        super();
    }

    @Override  // android.database.DataSetObserver
    public final void onChanged() {
        this.a.dataSetChanged();
    }

    @Override  // android.database.DataSetObserver
    public final void onInvalidated() {
        this.a.dataSetChanged();
    }
}

