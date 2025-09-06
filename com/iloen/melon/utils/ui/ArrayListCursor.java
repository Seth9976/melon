package com.iloen.melon.utils.ui;

import android.database.AbstractCursor;
import android.database.CursorWindow;
import com.iloen.melon.utils.log.LogU;
import java.util.ArrayList;

public class ArrayListCursor extends AbstractCursor {
    public final String[] a;
    public final ArrayList b;

    public ArrayListCursor(String[] arr_s, ArrayList arrayList0) {
        for(int v1 = 0; true; ++v1) {
            boolean z = false;
            if(v1 >= arr_s.length) {
                break;
            }
            if(arr_s[v1].compareToIgnoreCase("_id") == 0) {
                this.a = arr_s;
                z = true;
                break;
            }
        }
        if(!z) {
            String[] arr_s1 = new String[arr_s.length + 1];
            this.a = arr_s1;
            System.arraycopy(arr_s, 0, arr_s1, 0, arr_s.length);
            arr_s1[arr_s.length] = "_id";
        }
        int v2 = arrayList0.size();
        this.b = new ArrayList(v2);
        for(int v = 0; v < v2; ++v) {
            ArrayList arrayList1 = (ArrayList)arrayList0.get(v);
            this.b.add(arrayList1);
            if(!z) {
                arrayList1.add(v);
            }
        }
        LogU.v("ArrayListCursor", "ArrayListCursor() mRows.length: " + this.b.size());
    }

    public boolean deleteRow() {
        return false;
    }

    @Override  // android.database.AbstractCursor
    public void fillWindow(int v, CursorWindow cursorWindow0) {
        if(v >= 0 && v <= this.getCount()) {
            cursorWindow0.acquireReference();
            try {
                int v2 = this.mPos;
                this.mPos = v - 1;
                cursorWindow0.clear();
                cursorWindow0.setStartPosition(v);
                int v3 = this.getColumnCount();
                cursorWindow0.setNumColumns(v3);
            label_9:
                while(this.moveToNext() && cursorWindow0.allocRow()) {
                    int v4 = 0;
                    while(v4 < v3) {
                        Object object0 = ((ArrayList)this.b.get(this.mPos)).get(v4);
                        if(object0 == null) {
                            if(!cursorWindow0.putNull(this.mPos, v4)) {
                                cursorWindow0.freeLastRow();
                                continue label_9;
                            }
                        }
                        else if(!(object0 instanceof byte[])) {
                            if(!cursorWindow0.putString(object0.toString(), this.mPos, v4)) {
                                cursorWindow0.freeLastRow();
                                continue label_9;
                            }
                        }
                        else if(!cursorWindow0.putBlob(((byte[])object0), this.mPos, v4)) {
                            cursorWindow0.freeLastRow();
                            continue label_9;
                        }
                        ++v4;
                    }
                }
                this.mPos = v2;
            }
            catch(IllegalStateException unused_ex) {
                cursorWindow0.releaseReference();
            }
            finally {
                cursorWindow0.releaseReference();
            }
        }
    }

    @Override  // android.database.AbstractCursor
    public byte[] getBlob(int v) {
        return (byte[])((ArrayList)this.b.get(this.mPos)).get(v);
    }

    @Override  // android.database.AbstractCursor
    public String[] getColumnNames() {
        return this.a;
    }

    @Override  // android.database.AbstractCursor
    public int getCount() {
        return this.b.size();
    }

    @Override  // android.database.AbstractCursor
    public double getDouble(int v) {
        return ((Number)((ArrayList)this.b.get(this.mPos)).get(v)).doubleValue();
    }

    @Override  // android.database.AbstractCursor
    public float getFloat(int v) {
        return ((Number)((ArrayList)this.b.get(this.mPos)).get(v)).floatValue();
    }

    @Override  // android.database.AbstractCursor
    public int getInt(int v) {
        return ((Number)((ArrayList)this.b.get(this.mPos)).get(v)).intValue();
    }

    @Override  // android.database.AbstractCursor
    public long getLong(int v) {
        return ((Number)((ArrayList)this.b.get(this.mPos)).get(v)).longValue();
    }

    @Override  // android.database.AbstractCursor
    public short getShort(int v) {
        return ((Number)((ArrayList)this.b.get(this.mPos)).get(v)).shortValue();
    }

    @Override  // android.database.AbstractCursor
    public String getString(int v) {
        ArrayList arrayList0 = this.b;
        if(arrayList0 != null) {
            int v1 = this.mPos;
            if(arrayList0.size() > v1) {
                Object object0 = ((ArrayList)arrayList0.get(v1)).get(v);
                return object0 == null ? null : object0.toString();
            }
        }
        return null;
    }

    @Override  // android.database.AbstractCursor
    public boolean isNull(int v) {
        return ((ArrayList)this.b.get(this.mPos)).get(v) == null;
    }

    public boolean movePosition(int v, int v1) {
        if(v < this.getCount() && v1 < this.getCount() && v != v1) {
            synchronized(this.b) {
                ArrayList arrayList0 = (ArrayList)this.b.remove(v);
                this.b.add(v1, arrayList0);
                return true;
            }
        }
        return false;
    }

    @Override  // android.database.AbstractCursor
    public boolean requery() {
        LogU.d("ArrayListCursor", "requery()");
        return true;
    }
}

