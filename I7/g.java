package I7;

import T5.c;
import X5.f;
import X5.h;
import X5.j;
import Y5.b;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.media3.session.O;
import androidx.media3.session.Q;
import androidx.media3.session.m;
import b3.E;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import h7.l0;
import java.util.HashMap;
import y7.a;

public final class g implements h, b, O, Continuation, a {
    public final long a;
    public final Object b;
    public final Object c;

    public g(Object object0, long v, Object object1) {
        this.b = object0;
        this.a = v;
        this.c = object1;
        super();
    }

    public g(Object object0, Object object1, long v) {
        this.b = object0;
        this.c = object1;
        this.a = v;
        super();
    }

    @Override  // X5.h
    public Object apply(Object object0) {
        int v;
        String s;
        s = (String)this.b;
        v = ((c)this.c).a;
        try(Cursor cursor0 = ((SQLiteDatabase)object0).rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{s, Integer.toString(v)})) {
            if(cursor0.getCount() > 0) {
                goto label_10;
            }
            else {
                goto label_12;
            }
        }
        goto label_13;
    label_10:
        boolean z = true;
        goto label_13;
    label_12:
        z = false;
    label_13:
        long v1 = this.a;
        if(!z) {
            ContentValues contentValues0 = new ContentValues();
            contentValues0.put("log_source", s);
            contentValues0.put("reason", v);
            contentValues0.put("events_dropped_count", v1);
            ((SQLiteDatabase)object0).insert("log_event_dropped", null, contentValues0);
            return null;
        }
        ((SQLiteDatabase)object0).execSQL(H0.b.g(v1, "UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + ", " WHERE log_source = ? AND reason = ?"), new String[]{s, Integer.toString(v)});
        return null;
    }

    @Override  // androidx.media3.session.O
    public void d(m m0, int v) {
        Bundle bundle0 = ((E)this.c).d(true);
        m0.y(((Q)this.b).c, v, bundle0, this.a);
    }

    @Override  // Y5.b
    public Object execute() {
        long v = ((W5.h)this.b).g.f();
        j j0 = (j)((W5.h)this.b).c;
        j0.getClass();
        j0.j(new f(v + this.a, ((Q5.j)this.c)));
        return null;
    }

    @Override  // y7.a
    public void g(y7.b b0) {
        ((b7.a)b0.get()).d(((String)this.b), this.a, ((l0)this.c));
    }

    @Override  // com.google.android.gms.tasks.Continuation
    public Object then(Task task0) {
        return ((I7.j)this.b).b(task0, this.a, ((HashMap)this.c));
    }
}

