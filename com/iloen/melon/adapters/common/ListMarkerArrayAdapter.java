package com.iloen.melon.adapters.common;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import com.iloen.melon.utils.ClassUtils;
import com.iloen.melon.utils.log.LogU;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public abstract class ListMarkerArrayAdapter extends ArrayAdapter implements ListMarker, d, h {
    private static final String TAG = "ListMarkerArrayAdapter";
    protected Context mContext;
    protected boolean mEditMode;
    protected LayoutInflater mInflater;
    protected String mKeyName;
    protected int mKeyType;
    protected int mLastMarkedPosition;
    protected int mListContentType;
    private HashMap mMarkedCache;
    private String mMarkedKey;
    private boolean mMarkedMode;
    private boolean mMarqueeEnabled;

    public ListMarkerArrayAdapter(Context context0) {
        super(context0, -1, new ArrayList());
        this.mMarkedCache = new HashMap();
        this.mEditMode = false;
        this.mMarkedMode = false;
        this.mMarqueeEnabled = true;
        this.mKeyName = null;
        this.mKeyType = -1;
        this.mLastMarkedPosition = -1;
        this.mMarkedKey = null;
        this.mListContentType = 0;
        this.mContext = context0;
        this.mInflater = LayoutInflater.from(context0);
    }

    @Override  // android.widget.ArrayAdapter
    public void addAll(Collection collection0) {
        if(collection0 == null) {
            LogU.e("ListMarkerArrayAdapter", "addAll() - null collection");
            return;
        }
        super.addAll(collection0);
    }

    @Override  // android.widget.ArrayAdapter
    public void addAll(Object[] arr_object) {
        if(arr_object == null) {
            LogU.e("ListMarkerArrayAdapter", "addAll() - null items");
            return;
        }
        super.addAll(arr_object);
    }

    @Override  // android.widget.ArrayAdapter
    public void clear() {
        try {
            super.clear();
        }
        catch(Exception unused_ex) {
        }
    }

    public List findAll(Object object0) {
        List list0 = new ArrayList();
        for(int v = 0; v < this.getCount(); ++v) {
            Object object1 = this.getItem(v);
            if(ClassUtils.equals(object1, object0)) {
                ((ArrayList)list0).add(object1);
            }
        }
        return list0;
    }

    public Object findFirst(Object object0) {
        synchronized(this) {
            for(int v1 = 0; v1 < this.getCount(); ++v1) {
                Object object1 = this.getItem(v1);
                if(ClassUtils.equals(object1, object0)) {
                    return object1;
                }
            }
            return null;
        }
    }

    @Override  // android.widget.ArrayAdapter
    public int getCount() {
        try {
            return super.getCount();
        }
        catch(Exception unused_ex) {
            return 0;
        }
    }

    @Override  // android.widget.ArrayAdapter
    public Object getItem(int v) {
        try {
            return super.getItem(v);
        }
        catch(IndexOutOfBoundsException unused_ex) {
            return null;
        }
    }

    @Override  // android.widget.ArrayAdapter
    public long getItemId(int v) {
        try {
            return super.getItemId(v);
        }
        catch(Exception unused_ex) {
            return -1L;
        }
    }

    public String getKey(int v) {
        if(this.isEmpty()) {
            return null;
        }
        if(v >= 0 && v < this.getCount()) {
            if(this.mKeyType == -1) {
                return String.valueOf(v);
            }
            if(!TextUtils.isEmpty(this.mKeyName)) {
                Object object0 = this.getItem(v);
                if(object0 != null) {
                    try {
                        Field field0 = object0.getClass().getField(this.mKeyName);
                        field0.setAccessible(true);
                        int v1 = this.mKeyType;
                        if(v1 == 1) {
                            return (String)field0.get(object0);
                        }
                        return v1 == 0 ? String.valueOf(field0.getInt(object0)) : null;
                    }
                    catch(NoSuchFieldException noSuchFieldException0) {
                    }
                    catch(IllegalArgumentException illegalArgumentException0) {
                        LogU.w("ListMarkerArrayAdapter", "getKey() IllegalArgumentException:" + illegalArgumentException0.toString());
                        return null;
                    }
                    catch(IllegalAccessException illegalAccessException0) {
                        LogU.w("ListMarkerArrayAdapter", "getKey() IllegalAccessException:" + illegalAccessException0.toString());
                        return null;
                    }
                    LogU.w("ListMarkerArrayAdapter", "getKey() NoSuchFieldException:" + noSuchFieldException0.toString());
                    return null;
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
        int v = this.getCount();
        for(int v1 = 0; v1 < v; ++v1) {
            if(this.isMarked(v1)) {
                ((ArrayList)list0).add(v1);
            }
        }
        return list0;
    }

    @Override  // android.widget.ArrayAdapter
    public int getPosition(Object object0) {
        try {
            return super.getPosition(object0);
        }
        catch(Exception unused_ex) {
            return -1;
        }
    }

    @Override  // com.iloen.melon.adapters.common.ListMarker
    public int getWeakMarked() {
        String s = this.mMarkedKey;
        if(s == null) {
            return -1;
        }
        if(TextUtils.isEmpty(s)) {
            return -1;
        }
        if(this.mKeyType == -1) {
            return (int)Integer.valueOf(s);
        }
        if(!this.isEmpty()) {
            int v = this.getCount();
            for(int v1 = 0; v1 < v; ++v1) {
                if(s.equalsIgnoreCase(this.getKey(v1))) {
                    LogU.d("ListMarkerArrayAdapter", "getWeakMarked(" + v1 + ") key:" + s);
                    return v1;
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
        if(this.isEmpty()) {
            LogU.w("ListMarkerArrayAdapter", "isMarked() invalid objects");
            return false;
        }
        if(v >= 0 && v < this.getCount()) {
            String s = this.getKey(v);
            if(TextUtils.isEmpty(s)) {
                LogU.w("ListMarkerArrayAdapter", "isMarked() invalid key");
                return false;
            }
            synchronized(this.mMarkedCache) {
                return this.mMarkedCache.containsKey(s) ? ((Boolean)this.mMarkedCache.get(s)).booleanValue() : false;
            }
        }
        LogU.w("ListMarkerArrayAdapter", "isMarked() invalid position");
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

    @Override  // android.widget.ArrayAdapter
    public void remove(Object object0) {
        try {
            super.remove(object0);
        }
        catch(Exception unused_ex) {
        }
    }

    public void removeWeakMarked() {
        this.mMarkedKey = null;
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
        if(this.isEmpty()) {
            LogU.w("ListMarkerArrayAdapter", "setLastMarkedPosition() - invalid objects");
            return;
        }
        if(v >= 0 && v < this.getCount()) {
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
        LogU.w("ListMarkerArrayAdapter", "setLastMarkedPosition() - invalid position");
    }

    public void setListContentType(int v) {
        this.mListContentType = v;
    }

    @Override  // com.iloen.melon.adapters.common.ListMarker
    public void setMarked(int v, boolean z) {
        if(this.isEmpty()) {
            LogU.w("ListMarkerArrayAdapter", "setMarked() invalid objects");
            return;
        }
        if(v >= 0 && v < this.getCount()) {
            String s = this.getKey(v);
            if(TextUtils.isEmpty(s)) {
                LogU.w("ListMarkerArrayAdapter", "setMarked() invalid key");
                return;
            }
            if(this.setMarked(v, s, z)) {
                this.setLastMarkedPosition(v, z);
                this.notifyDataSetChanged();
            }
            return;
        }
        LogU.w("ListMarkerArrayAdapter", "setMarked() invalid position");
    }

    public boolean setMarked(int v, String s, boolean z) {
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
        if(!this.isEmpty()) {
            int v = this.getCount();
            int v1 = -1;
            for(int v2 = 0; v2 < v; ++v2) {
                String s = this.getKey(v2);
                if(!TextUtils.isEmpty(s) && this.setMarked(v2, s, true)) {
                    v1 = v2;
                }
            }
            if(v1 >= 0) {
                this.setLastMarkedPosition(v1, true);
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
        this.mMarkedKey = null;
        if(!this.isEmpty()) {
            String s = this.getKey(v);
            if(!TextUtils.isEmpty(s)) {
                this.mMarkedKey = s;
            }
        }
    }
}

