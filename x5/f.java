package X5;

import I6.V;
import N5.d;
import Q5.j;
import a6.a;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import androidx.media3.session.O;
import androidx.media3.session.Q;
import androidx.media3.session.e1;
import androidx.media3.session.m;
import androidx.media3.session.n0;
import androidx.media3.session.w0;
import b3.E;

public final class f implements h, O, e1 {
    public final long a;
    public final Object b;

    public f(long v, j j0) {
        this.a = v;
        this.b = j0;
    }

    public f(Object object0, long v) {
        this.b = object0;
        this.a = v;
        super();
    }

    @Override  // X5.h
    public Object apply(Object object0) {
        ContentValues contentValues0 = new ContentValues();
        contentValues0.put("next_request_ms", this.a);
        String s = ((j)this.b).a;
        d d0 = ((j)this.b).c;
        if(((SQLiteDatabase)object0).update("transport_contexts", contentValues0, "backend_name = ? and priority = ?", new String[]{s, String.valueOf(a.a(d0))}) < 1) {
            contentValues0.put("backend_name", s);
            contentValues0.put("priority", a.a(d0));
            ((SQLiteDatabase)object0).insert("transport_contexts", null, contentValues0);
        }
        return null;
    }

    @Override  // androidx.media3.session.O
    public void d(m m0, int v) {
        m0.C(((Q)this.b).c, v, this.a);
    }

    @Override  // androidx.media3.session.e1
    public Object e(n0 n00, w0 w00, int v) {
        return n00.A(w00, V.t(((E)this.b)), 0, this.a);
    }
}

