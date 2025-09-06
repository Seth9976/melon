package W5;

import B9.g;
import Q5.j;
import Y5.b;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public final class f implements b {
    public final int a;
    public final h b;
    public final j c;

    public f(h h0, j j0, int v) {
        this.a = v;
        this.b = h0;
        this.c = j0;
        super();
    }

    @Override  // Y5.b
    public final Object execute() {
        Boolean boolean1;
        Boolean boolean0;
        if(this.a != 0) {
            ((X5.j)this.b.c).getClass();
            g g0 = new g(16, ((X5.j)this.b.c), this.c);
            return (Iterable)((X5.j)this.b.c).j(g0);
        }
        X5.j j0 = (X5.j)this.b.c;
        SQLiteDatabase sQLiteDatabase0 = j0.h();
        sQLiteDatabase0.beginTransaction();
        try {
            Long long0 = X5.j.i(sQLiteDatabase0, this.c);
            if(long0 == null) {
                boolean0 = Boolean.FALSE;
            }
            else {
                Cursor cursor0 = j0.h().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{long0.toString()});
                try {
                    boolean1 = Boolean.valueOf(cursor0.moveToNext());
                }
                catch(Throwable throwable0) {
                    cursor0.close();
                    throw throwable0;
                }
                cursor0.close();
                boolean0 = boolean1;
            }
            sQLiteDatabase0.setTransactionSuccessful();
            return boolean0;
        }
        finally {
            sQLiteDatabase0.endTransaction();
        }
    }
}

