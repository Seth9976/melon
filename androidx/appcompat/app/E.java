package androidx.appcompat.app;

import android.widget.ArrayAdapter;

public final class e extends ArrayAdapter {
    @Override  // android.widget.ArrayAdapter
    public final long getItemId(int v) {
        return (long)v;
    }

    @Override  // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}

