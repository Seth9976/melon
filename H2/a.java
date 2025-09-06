package h2;

import D6.f;
import Q0.p1;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.appcompat.widget.Y0;

public abstract class a extends BaseAdapter implements Filterable {
    public boolean a;
    public boolean b;
    public Cursor c;
    public int d;
    public p1 e;
    public f f;
    public b g;

    public abstract void a(View arg1, Cursor arg2);

    public void b(Cursor cursor0) {
        Cursor cursor1 = this.c;
        if(cursor0 == cursor1) {
            cursor1 = null;
        }
        else {
            if(cursor1 != null) {
                p1 p10 = this.e;
                if(p10 != null) {
                    cursor1.unregisterContentObserver(p10);
                }
                f f0 = this.f;
                if(f0 != null) {
                    cursor1.unregisterDataSetObserver(f0);
                }
            }
            this.c = cursor0;
            if(cursor0 == null) {
                this.d = -1;
                this.a = false;
                this.notifyDataSetInvalidated();
            }
            else {
                p1 p11 = this.e;
                if(p11 != null) {
                    cursor0.registerContentObserver(p11);
                }
                f f1 = this.f;
                if(f1 != null) {
                    cursor0.registerDataSetObserver(f1);
                }
                this.d = cursor0.getColumnIndexOrThrow("_id");
                this.a = true;
                this.notifyDataSetChanged();
            }
        }
        if(cursor1 != null) {
            cursor1.close();
        }
    }

    public abstract String c(Cursor arg1);

    public abstract View d(ViewGroup arg1);

    @Override  // android.widget.Adapter
    public final int getCount() {
        if(this.a) {
            return this.c == null ? 0 : this.c.getCount();
        }
        return 0;
    }

    @Override  // android.widget.BaseAdapter
    public View getDropDownView(int v, View view0, ViewGroup viewGroup0) {
        if(this.a) {
            this.c.moveToPosition(v);
            if(view0 == null) {
                view0 = ((Y0)this).j.inflate(((Y0)this).i, viewGroup0, false);
            }
            this.a(view0, this.c);
            return view0;
        }
        return null;
    }

    @Override  // android.widget.Filterable
    public final Filter getFilter() {
        if(this.g == null) {
            b b0 = new b();  // 初始化器: Landroid/widget/Filter;-><init>()V
            b0.a = this;
            this.g = b0;
        }
        return this.g;
    }

    @Override  // android.widget.Adapter
    public final Object getItem(int v) {
        if(this.a) {
            Cursor cursor0 = this.c;
            if(cursor0 != null) {
                cursor0.moveToPosition(v);
                return this.c;
            }
        }
        return null;
    }

    // 去混淆评级： 低(20)
    @Override  // android.widget.Adapter
    public final long getItemId(int v) {
        return !this.a || (this.c == null || !this.c.moveToPosition(v)) ? 0L : this.c.getLong(this.d);
    }

    @Override  // android.widget.Adapter
    public View getView(int v, View view0, ViewGroup viewGroup0) {
        if(!this.a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if(!this.c.moveToPosition(v)) {
            throw new IllegalStateException("couldn\'t move cursor to position " + v);
        }
        if(view0 == null) {
            view0 = this.d(viewGroup0);
        }
        this.a(view0, this.c);
        return view0;
    }
}

