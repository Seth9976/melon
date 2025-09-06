package com.iloen.melon.adapters.common;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import com.iloen.melon.utils.log.LogU;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class k extends RecyclerViewCursorAdapter implements ListMarker, d, h {
    private static final String TAG = "ListMarkerRecyclerViewCursorAdapter";
    protected boolean mEditMode;
    protected LayoutInflater mInflater;
    protected String mKeyName;
    protected int mKeyType;
    protected int mLastMarkedPosition;
    protected int mListContentType;
    private final HashMap mMarkedCache;
    private boolean mMarkedMode;
    private boolean mMarqueeEnabled;
    private String mWeakKey;

    public k(Context context0, Cursor cursor0) {
        super(context0, cursor0);
        this.mMarkedCache = new HashMap();
        this.mEditMode = false;
        this.mMarkedMode = false;
        this.mMarqueeEnabled = true;
        this.mKeyName = null;
        this.mKeyType = -1;
        this.mLastMarkedPosition = -1;
        this.mWeakKey = null;
        this.mListContentType = 0;
        this.mInflater = LayoutInflater.from(context0);
    }

    public String getKey(Cursor cursor0, int v) {
        if(cursor0 == null) {
            return null;
        }
        if(v >= 0 && v < cursor0.getCount()) {
            if(this.mKeyType == -1) {
                return String.valueOf(v);
            }
            if(!TextUtils.isEmpty(this.mKeyName)) {
                int v1 = cursor0.getColumnIndex(this.mKeyName);
                if(v1 != -1) {
                    int v2 = this.mKeyType;
                    if(v2 == 1) {
                        return cursor0.getString(v1);
                    }
                    return v2 == 0 ? String.valueOf(cursor0.getInt(v1)) : null;
                }
            }
        }
        return null;
    }

    public int getLastMarkedPosition() {
        return this.mLastMarkedPosition;
    }

    @Override  // com.iloen.melon.adapters.common.h
    public int getListContentType() {
        return this.mListContentType;
    }

    @Override  // com.iloen.melon.adapters.common.ListMarker
    public int getMarkedCount() {
        return this.mMarkedCache.size();
    }

    @Override  // com.iloen.melon.adapters.common.ListMarker
    public List getMarkedItems() {
        List list0 = new ArrayList();
        Cursor cursor0 = this.getCursor();
        if(cursor0 != null && cursor0.moveToFirst()) {
            while(true) {
                int v = cursor0.getPosition();
                if(this.isMarked(v)) {
                    ((ArrayList)list0).add(v);
                }
                if(!cursor0.moveToNext()) {
                    break;
                }
            }
        }
        return list0;
    }

    @Override  // com.iloen.melon.adapters.common.ListMarker
    public int getWeakMarked() {
        String s = this.mWeakKey;
        if(s == null) {
            return -1;
        }
        if(TextUtils.isEmpty(s)) {
            return -1;
        }
        if(this.mKeyType == -1) {
            return (int)Integer.valueOf(s);
        }
        Cursor cursor0 = this.getCursor();
        if(cursor0 != null && cursor0.moveToFirst()) {
            while(true) {
                int v = cursor0.getPosition();
                if(s.equalsIgnoreCase(this.getKey(cursor0, v))) {
                    LogU.d("ListMarkerRecyclerViewCursorAdapter", "getWeakMarked(" + v + ") key:" + s);
                    return v;
                }
                if(!cursor0.moveToNext()) {
                    break;
                }
            }
        }
        return -1;
    }

    @Override  // com.iloen.melon.adapters.common.d
    public boolean isInEditMode() {
        return this.mEditMode;
    }

    @Override  // com.iloen.melon.adapters.common.ListMarker
    public boolean isMarked(int v) {
        Cursor cursor0 = this.getCursor();
        if(cursor0 == null) {
            LogU.w("ListMarkerRecyclerViewCursorAdapter", "isMarked() invalid cursor");
            return false;
        }
        if(v >= 0 && v < cursor0.getCount()) {
            if(!cursor0.moveToPosition(v)) {
                LogU.w("ListMarkerRecyclerViewCursorAdapter", "isMarked() failed to moveToPosition");
                return false;
            }
            String s = this.getKey(cursor0, v);
            if(TextUtils.isEmpty(s)) {
                LogU.w("ListMarkerRecyclerViewCursorAdapter", "isMarked() invalid key");
                return false;
            }
            synchronized(this.mMarkedCache) {
                return this.mMarkedCache.containsKey(s) ? ((Boolean)this.mMarkedCache.get(s)).booleanValue() : false;
            }
        }
        LogU.w("ListMarkerRecyclerViewCursorAdapter", "isMarked() invalid position");
        return false;
    }

    @Override  // com.iloen.melon.adapters.common.ListMarker
    public boolean isMarkedMode() {
        return this.mMarkedMode;
    }

    public boolean isMarqueeEnabled() {
        return this.mMarqueeEnabled;
    }

    public boolean isMarqueeNeeded(int v) {
        return this.mMarqueeEnabled && v == this.mLastMarkedPosition;
    }

    public void removeWeakMarked() {
        LogU.d("ListMarkerRecyclerViewCursorAdapter", "removeWeakMarked");
        this.mWeakKey = null;
    }

    @Override  // com.iloen.melon.adapters.common.d
    public void setEditMode(boolean z) {
        this.mEditMode = z;
    }

    public void setKeyNameWithType(int v, String s) {
        this.mKeyType = v;
        this.mKeyName = s;
    }

    public void setLastMarkedPosition(int v, boolean z) {
        Cursor cursor0 = this.getCursor();
        if(cursor0 == null) {
            LogU.w("ListMarkerRecyclerViewCursorAdapter", "setLastMarkedPosition() - invalid cursor");
            return;
        }
        if(v >= 0 && v < cursor0.getCount()) {
            if(z) {
                this.mLastMarkedPosition = v;
                return;
            }
            List list0 = this.getMarkedItems();
            int v1 = list0.size();
            if(v1 == 0) {
                this.mLastMarkedPosition = -1;
                return;
            }
            this.mLastMarkedPosition = (int)(((Integer)list0.get(v1 - 1)));
            return;
        }
        LogU.w("ListMarkerRecyclerViewCursorAdapter", "setLastMarkedPosition() - invalid position");
    }

    public void setListContentType(int v) {
        this.mListContentType = v;
    }

    @Override  // com.iloen.melon.adapters.common.ListMarker
    public void setMarked(int v, boolean z) {
        Cursor cursor0 = this.getCursor();
        if(cursor0 == null) {
            LogU.w("ListMarkerRecyclerViewCursorAdapter", "setMarked() invalid cursor");
            return;
        }
        if(v >= 0 && v < cursor0.getCount()) {
            if(!cursor0.moveToPosition(v)) {
                LogU.w("ListMarkerRecyclerViewCursorAdapter", "setMarked() failed to moveToPosition");
                return;
            }
            String s = this.getKey(cursor0, v);
            if(TextUtils.isEmpty(s)) {
                LogU.w("ListMarkerRecyclerViewCursorAdapter", "setMarked() invalid key");
                return;
            }
            if(this.setMarked(cursor0, s, z)) {
                this.setLastMarkedPosition(v, z);
                this.notifyDataSetChanged();
            }
            return;
        }
        LogU.w("ListMarkerRecyclerViewCursorAdapter", "setMarked() invalid position");
    }

    public boolean setMarked(Cursor cursor0, String s, boolean z) {
        if(!this.mMarkedMode) {
            return false;
        }
        synchronized(this.mMarkedCache) {
            if(z) {
                this.mMarkedCache.put(s, Boolean.TRUE);
                return true;
            }
            if(this.mMarkedCache.containsKey(s)) {
                this.mMarkedCache.remove(s);
                return true;
            }
            return false;
        }
    }

    @Override  // com.iloen.melon.adapters.common.ListMarker
    public void setMarkedAll() {
        Cursor cursor0 = this.getCursor();
        if(cursor0 != null && cursor0.moveToFirst()) {
            int v = -1;
            do {
                int v1 = cursor0.getPosition();
                String s = this.getKey(cursor0, v1);
                if(!TextUtils.isEmpty(s) && this.setMarked(cursor0, s, true)) {
                    v = v1;
                }
            }
            while(cursor0.moveToNext());
            if(v >= 0) {
                this.setLastMarkedPosition(v, true);
                this.notifyDataSetChanged();
            }
        }
    }

    @Override  // com.iloen.melon.adapters.common.ListMarker
    public void setMarkedMode(boolean z) {
        this.mMarkedMode = z;
    }

    public void setMarqueeEnabled(boolean z) {
        this.mMarqueeEnabled = z;
    }

    @Override  // com.iloen.melon.adapters.common.ListMarker
    public void setUnmarkedAll() {
        if(this.mMarkedCache.size() > 0) {
            this.mMarkedCache.clear();
            this.mLastMarkedPosition = -1;
            this.notifyDataSetChanged();
        }
    }

    @Override  // com.iloen.melon.adapters.common.ListMarker
    public void setWeakMarked(int v) {
        this.mWeakKey = null;
        Cursor cursor0 = this.getCursor();
        if(cursor0 != null && cursor0.moveToPosition(v)) {
            String s = this.getKey(cursor0, v);
            if(!TextUtils.isEmpty(s)) {
                this.mWeakKey = s;
            }
        }
        LogU.d("ListMarkerRecyclerViewCursorAdapter", "setWeakMarked - key:" + this.mWeakKey + ", pos:" + v);
    }
}

