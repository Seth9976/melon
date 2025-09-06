package y;

import android.util.Log;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;

public final class d implements AutoCloseable {
    public final String[] a;
    public final ArrayDeque b;

    public d(Object object0, String s, ArrayDeque arrayDeque0) {
        this.b = arrayDeque0;
        if(object0 != null) {
            arrayDeque0.addFirst(new c(object0, s));
            if(Log.isLoggable("CarApp.Bun", 2)) {
                StringBuilder stringBuilder0 = new StringBuilder();
                int v = Math.min(arrayDeque0.size(), 11);
                if(this.a == null) {
                    this.a = new String[12];
                }
                String s1 = this.a[v];
                if(s1 == null) {
                    char[] arr_c = new char[v];
                    Arrays.fill(arr_c, ' ');
                    String s2 = new String(arr_c);
                    s1 = v == 11 ? s2 + "..." : s2;
                    this.a[v] = s1;
                }
                stringBuilder0.append(s1);
                stringBuilder0.append(f.i(object0.getClass()) + " " + s);
                Log.v("CarApp.Bun", stringBuilder0.toString());
            }
        }
    }

    @Override
    public final void close() {
        this.b.removeFirst();
    }

    public final String h() {
        StringBuilder stringBuilder0 = new StringBuilder();
        int v = Math.min(this.b.size(), 8);
        Iterator iterator0 = this.b.descendingIterator();
        while(iterator0.hasNext() && v > 0) {
            Object object0 = iterator0.next();
            stringBuilder0.append(((c)object0).a());
            --v;
        }
        if(iterator0.hasNext()) {
            stringBuilder0.append("[...]");
        }
        return stringBuilder0.toString();
    }
}

