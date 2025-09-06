package com.iloen.melon.adapters.common;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.utils.log.LogU;

public abstract class RecyclerViewCursorAdapter extends j0 implements i {
    public interface OnContentChangedListener {
        void onContentChanged();
    }

    private static final String FOOTER = "footer";
    private static final String HEADER = "header";
    private static final String TAG = "RecyclerViewCursorAdapter";
    protected OnContentChangedListener mContentChangedListener;
    private final Context mContext;
    private Cursor mCursor;
    private DataSetObserver mDataSetObserver;
    private boolean mDataValid;
    private int mRowIdColumn;

    public RecyclerViewCursorAdapter(Context context0, Cursor cursor0) {
        this.mContext = context0;
        this.mCursor = cursor0;
        this.mDataValid = cursor0 != null;
        this.mRowIdColumn = cursor0 == null ? cursor0.getColumnIndex("_id") : -1;
        z z0 = new z(this);
        this.mDataSetObserver = z0;
        Cursor cursor1 = this.mCursor;
        if(cursor1 != null) {
            cursor1.registerDataSetObserver(z0);
        }
    }

    public void changeCursor(Cursor cursor0) {
        Cursor cursor1 = this.swapCursor(cursor0);
        if(cursor1 != null) {
            cursor1.close();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    @Override  // com.iloen.melon.adapters.common.i
    public int getCount() {
        return this.mCursor == null || this.mCursor.isClosed() ? 0 : this.mCursor.getCount();
    }

    public Cursor getCursor() {
        return this.mCursor;
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
        if(this.mDataValid && v >= v1 && v < v3 - v2 && this.mCursor.moveToPosition(this.getItemPositionFromList(v))) {
            return this.mCursor.getLong(this.mRowIdColumn);
        }
        if(v < v1) {
            return (long)(v - 1221270899);
        }
        return v < v3 - v2 ? -1L : ((long)(v - 0x4BA14A65));
    }

    public int getItemPositionFromList(int v) {
        return v - this.getHeaderViewCount();
    }

    public int getListPositionFromItem(int v) {
        return this.getHeaderViewCount() + v;
    }

    public OnContentChangedListener getOnContentChangedListener() {
        return this.mContentChangedListener;
    }

    public boolean isEmpty() {
        return this.getCount() == 0;
    }

    @Override  // androidx.recyclerview.widget.j0
    public void onBindViewHolder(O0 o00, int v) {
        if(!this.mDataValid) {
            LogU.w("RecyclerViewCursorAdapter", "onBindViewHolder() invalid cursor");
            return;
        }
        int v1 = this.getItemCount();
        int v2 = this.getItemPositionFromList(v);
        if(v >= this.getHeaderViewCount() && v < v1 - this.getFooterViewCount() && !this.mCursor.moveToPosition(v2)) {
            throw new IllegalStateException("couldn\'t move cursor to position " + v);
        }
        this.onBindViewHolder(o00, this.mCursor, v, v2);
    }

    public abstract void onBindViewHolder(O0 arg1, Cursor arg2, int arg3, int arg4);

    @Override  // androidx.recyclerview.widget.j0
    public void setHasStableIds(boolean z) {
        super.setHasStableIds(true);
    }

    public void setOnContentChangedListener(OnContentChangedListener recyclerViewCursorAdapter$OnContentChangedListener0) {
        this.mContentChangedListener = recyclerViewCursorAdapter$OnContentChangedListener0;
    }

    public Cursor swapCursor(Cursor cursor0) {
        Cursor cursor1 = this.mCursor;
        if(cursor0 == cursor1) {
            return null;
        }
        if(cursor1 != null) {
            DataSetObserver dataSetObserver0 = this.mDataSetObserver;
            if(dataSetObserver0 != null) {
                cursor1.unregisterDataSetObserver(dataSetObserver0);
            }
        }
        this.mCursor = cursor0;
        if(cursor0 != null) {
            DataSetObserver dataSetObserver1 = this.mDataSetObserver;
            if(dataSetObserver1 != null) {
                cursor0.registerDataSetObserver(dataSetObserver1);
            }
            this.mRowIdColumn = cursor0.getColumnIndexOrThrow("_id");
            this.mDataValid = true;
            this.notifyDataSetChanged();
            return cursor1;
        }
        this.mRowIdColumn = -1;
        this.mDataValid = false;
        this.notifyDataSetChanged();
        return cursor1;
    }
}

