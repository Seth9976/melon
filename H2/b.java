package h2;

import android.database.Cursor;
import android.util.Log;
import android.widget.Filter.FilterResults;
import android.widget.Filter;
import androidx.appcompat.widget.Y0;

public final class b extends Filter {
    public a a;

    @Override  // android.widget.Filter
    public final CharSequence convertResultToString(Object object0) {
        return ((Y0)this.a).c(((Cursor)object0));
    }

    @Override  // android.widget.Filter
    public final Filter.FilterResults performFiltering(CharSequence charSequence0) {
        Cursor cursor0;
        Y0 y00 = (Y0)this.a;
        String s = charSequence0 == null ? "" : charSequence0.toString();
        if(y00.k.getVisibility() == 0 && y00.k.getWindowVisibility() == 0) {
            try {
                cursor0 = y00.g(y00.l, s);
                if(cursor0 == null) {
                    cursor0 = null;
                }
                else {
                    cursor0.getCount();
                }
            }
            catch(RuntimeException runtimeException0) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", runtimeException0);
                cursor0 = null;
            }
        }
        else {
            cursor0 = null;
        }
        Filter.FilterResults filter$FilterResults0 = new Filter.FilterResults();
        if(cursor0 != null) {
            filter$FilterResults0.count = cursor0.getCount();
            filter$FilterResults0.values = cursor0;
            return filter$FilterResults0;
        }
        filter$FilterResults0.count = 0;
        filter$FilterResults0.values = null;
        return filter$FilterResults0;
    }

    @Override  // android.widget.Filter
    public final void publishResults(CharSequence charSequence0, Filter.FilterResults filter$FilterResults0) {
        a a0 = this.a;
        Object object0 = filter$FilterResults0.values;
        if(object0 != null && object0 != a0.c) {
            ((Y0)a0).b(((Cursor)object0));
        }
    }
}

