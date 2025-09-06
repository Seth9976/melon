package com.iloen.melon.adapters.common;

import android.database.DataSetObserver;

public final class z extends DataSetObserver {
    public final RecyclerViewCursorAdapter a;

    public z(RecyclerViewCursorAdapter recyclerViewCursorAdapter0) {
        this.a = recyclerViewCursorAdapter0;
        super();
    }

    @Override  // android.database.DataSetObserver
    public final void onChanged() {
        super.onChanged();
        RecyclerViewCursorAdapter recyclerViewCursorAdapter0 = this.a;
        recyclerViewCursorAdapter0.mDataValid = true;
        OnContentChangedListener recyclerViewCursorAdapter$OnContentChangedListener0 = recyclerViewCursorAdapter0.mContentChangedListener;
        if(recyclerViewCursorAdapter$OnContentChangedListener0 != null) {
            recyclerViewCursorAdapter$OnContentChangedListener0.onContentChanged();
        }
        recyclerViewCursorAdapter0.notifyDataSetChanged();
    }

    @Override  // android.database.DataSetObserver
    public final void onInvalidated() {
        super.onInvalidated();
        this.a.mDataValid = false;
        this.a.notifyDataSetChanged();
    }
}

