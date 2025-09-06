package X5;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.media3.session.o1;
import b3.h0;
import e3.e;

public final class g implements h, h0, e {
    public final long a;

    public g(long v) {
        this.a = v;
        super();
    }

    @Override  // e3.e
    public void accept(Object object0) {
        ((o1)object0).seekTo(this.a);
    }

    @Override  // X5.h
    public Object apply(Object object0) {
        try(Cursor cursor0 = ((SQLiteDatabase)object0).rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0])) {
            cursor0.moveToNext();
            return new T5.g(cursor0.getLong(0), this.a);
        }
    }

    @Override  // b3.h0
    public long get() {
        return this.a;
    }
}

