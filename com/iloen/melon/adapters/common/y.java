package com.iloen.melon.adapters.common;

import android.content.Context;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.j0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class y extends j0 implements i {
    private static final String FOOTER = "footer";
    private static final String HEADER = "header";
    private final Context mContext;
    private final Object mLock;
    private List mObjects;

    public y(Context context0, List list0) {
        this.mLock = new Object();
        this.mContext = context0;
        if(list0 == null) {
            list0 = new ArrayList();
        }
        this.mObjects = list0;
    }

    public void add(int v, Object object0) {
        this.add(v, object0, true);
    }

    public void add(int v, Object object0, boolean z) {
        synchronized(this.mLock) {
            this.mObjects.add(v, object0);
        }
        if(z) {
            this.notifyDataSetChanged();
        }
    }

    public void add(Object object0) {
        this.add(object0, true);
    }

    public void add(Object object0, boolean z) {
        synchronized(this.mLock) {
            this.mObjects.add(object0);
        }
        if(z) {
            this.notifyDataSetChanged();
        }
    }

    public void addAll(int v, Collection collection0) {
        synchronized(this.mLock) {
            this.mObjects.addAll(v, collection0);
        }
        this.notifyDataSetChanged();
    }

    public void addAll(int v, Collection collection0, boolean z) {
        synchronized(this.mLock) {
            this.mObjects.addAll(v, collection0);
        }
        if(z) {
            this.notifyDataSetChanged();
        }
    }

    public void addAll(Collection collection0) {
        synchronized(this.mLock) {
            this.mObjects.addAll(collection0);
        }
        this.notifyDataSetChanged();
    }

    public void addAll(Collection collection0, boolean z) {
        synchronized(this.mLock) {
            this.mObjects.addAll(collection0);
        }
        if(z) {
            this.notifyDataSetChanged();
        }
    }

    public void addAll(Object[] arr_object) {
        synchronized(this.mLock) {
            Collections.addAll(this.mObjects, arr_object);
        }
        this.notifyDataSetChanged();
    }

    public void clear() {
        this.clear(true);
    }

    public void clear(boolean z) {
        int v = this.getCount();
        synchronized(this.mLock) {
            this.mObjects.clear();
        }
        if(v > 0 && z) {
            this.notifyDataSetChanged();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    @Override  // com.iloen.melon.adapters.common.i
    public int getCount() {
        return this.mObjects == null ? 0 : this.mObjects.size();
    }

    public int getFooterCount() {
        return this.getFooterViewCount();
    }

    public int getFooterViewCount() {
        return 0;
    }

    @Override  // com.iloen.melon.adapters.common.i
    public int getHeaderCount() {
        return this.getHeaderViewCount();
    }

    public int getHeaderViewCount() {
        return 0;
    }

    public Object getItem(int v) {
        return this.mObjects.get(v);
    }

    @Override  // androidx.recyclerview.widget.j0
    public int getItemCount() {
        int v = this.getCount();
        return this.getFooterViewCount() + (this.getHeaderViewCount() + v);
    }

    @Override  // androidx.recyclerview.widget.j0
    public long getItemId(int v) {
        int v1 = this.getHeaderViewCount();
        int v2 = this.getFooterViewCount();
        int v3 = this.getItemCount();
        List list0 = this.mObjects;
        if(list0 != null && v >= v1 && v < v3 - v2) {
            return (long)list0.hashCode();
        }
        if(v < v1) {
            return (long)(v - 1221270899);
        }
        return v < v3 - v2 ? -1L : ((long)(v - 0x4BA14A65));
    }

    public int getItemPositionFromList(int v) {
        return v - this.getHeaderViewCount();
    }

    public List getList() {
        return this.mObjects == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(this.mObjects);
    }

    public int getListPositionFromItem(int v) {
        return this.getHeaderViewCount() + v;
    }

    public int getPosition(Object object0) {
        return this.mObjects.indexOf(object0);
    }

    public void insert(Object object0, int v) {
        this.insert(object0, v, true);
    }

    public void insert(Object object0, int v, boolean z) {
        synchronized(this.mLock) {
            this.mObjects.add(v, object0);
        }
        if(z) {
            this.notifyDataSetChanged();
        }
    }

    public boolean isEmpty() {
        return this.getCount() == 0;
    }

    @Override  // androidx.recyclerview.widget.j0
    public void onBindViewHolder(O0 o00, int v) {
        this.onBindViewHolder(o00, v, this.getItemPositionFromList(v));
    }

    public abstract void onBindViewHolder(O0 arg1, int arg2, int arg3);

    public void remove(int v) {
        this.remove(v, true);
    }

    public void remove(int v, boolean z) {
        synchronized(this.mLock) {
            this.mObjects.remove(v);
        }
        if(z) {
            this.notifyDataSetChanged();
        }
    }

    public void remove(Object object0) {
        this.remove(object0, true);
    }

    public void remove(Object object0, boolean z) {
        synchronized(this.mLock) {
            this.mObjects.remove(object0);
        }
        if(z) {
            this.notifyDataSetChanged();
        }
    }

    @Override  // androidx.recyclerview.widget.j0
    public void setHasStableIds(boolean z) {
        super.setHasStableIds(true);
    }

    public void sort(Comparator comparator0) {
        this.sort(comparator0, true);
    }

    public void sort(Comparator comparator0, boolean z) {
        synchronized(this.mLock) {
            Collections.sort(this.mObjects, comparator0);
        }
        if(z) {
            this.notifyDataSetChanged();
        }
    }
}

