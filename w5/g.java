package W5;

import Q5.j;
import T5.c;
import Y5.b;
import Z6.d;
import Z6.e;
import Z6.f;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class g implements b, f {
    public final int a;
    public final long b;
    public final Object c;
    public final Object d;
    public final Object e;

    public g(h h0, Iterable iterable0, j j0, long v) {
        this.a = 0;
        super();
        this.c = h0;
        this.d = iterable0;
        this.e = j0;
        this.b = v;
    }

    public g(e e0, Object object0, long v, TimeUnit timeUnit0, int v1) {
        this.a = v1;
        this.c = e0;
        this.d = object0;
        this.b = v;
        this.e = timeUnit0;
        super();
    }

    @Override  // Z6.f
    public ScheduledFuture a(Ua.h h0) {
        if(this.a != 1) {
            V4.e e0 = new V4.e(((e)this.c), ((Callable)this.d), h0, 1);
            return ((e)this.c).b.schedule(e0, this.b, ((TimeUnit)this.e));
        }
        d d0 = new d(((e)this.c), ((Runnable)this.d), h0, 1);
        return ((e)this.c).b.schedule(d0, this.b, ((TimeUnit)this.e));
    }

    @Override  // Y5.b
    public Object execute() {
        h h0 = (h)this.c;
        Iterable iterable0 = (Iterable)this.d;
        j j0 = (j)this.e;
        X5.j j1 = (X5.j)h0.c;
        j1.getClass();
        if(iterable0.iterator().hasNext()) {
            String s = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + X5.j.o(iterable0);
            SQLiteDatabase sQLiteDatabase0 = j1.h();
            sQLiteDatabase0.beginTransaction();
            try {
                sQLiteDatabase0.compileStatement(s).execute();
                Cursor cursor0 = sQLiteDatabase0.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name", null);
                while(true) {
                    try {
                        if(!cursor0.moveToNext()) {
                            break;
                        }
                        int v1 = cursor0.getInt(0);
                        String s1 = cursor0.getString(1);
                        j1.m(((long)v1), c.f, s1);
                    }
                    catch(Throwable throwable0) {
                        cursor0.close();
                        throw throwable0;
                    }
                }
                cursor0.close();
                sQLiteDatabase0.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
                sQLiteDatabase0.setTransactionSuccessful();
            }
            finally {
                sQLiteDatabase0.endTransaction();
            }
        }
        j1.j(new X5.f(h0.g.f() + this.b, j0));
        return null;
    }
}

