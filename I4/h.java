package I4;

import H4.f;
import android.database.sqlite.SQLiteProgram;
import kotlin.jvm.internal.q;

public class h implements f {
    public final SQLiteProgram a;

    public h(SQLiteProgram sQLiteProgram0) {
        q.g(sQLiteProgram0, "delegate");
        super();
        this.a = sQLiteProgram0;
    }

    @Override  // H4.f
    public final void O(int v, byte[] arr_b) {
        this.a.bindBlob(v, arr_b);
    }

    @Override  // H4.f
    public final void U(double f, int v) {
        this.a.bindDouble(v, f);
    }

    @Override  // H4.f
    public final void a(int v, long v1) {
        this.a.bindLong(v, v1);
    }

    @Override  // H4.f
    public final void b(int v) {
        this.a.bindNull(v);
    }

    @Override
    public final void close() {
        this.a.close();
    }

    @Override  // H4.f
    public final void k(int v, String s) {
        q.g(s, "value");
        this.a.bindString(v, s);
    }
}

