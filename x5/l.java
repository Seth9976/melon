package X5;

import U4.x;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.appcompat.app.o;
import java.util.Arrays;
import java.util.List;

public final class l extends SQLiteOpenHelper {
    public final int a;
    public boolean b;
    public static final String c;
    public static final int d;
    public static final List e;

    static {
        l.c = "INSERT INTO global_log_event_state VALUES (" + System.currentTimeMillis() + ")";
        l.d = 7;
        l.e = Arrays.asList(new k[]{new k(0), new k(1), new k(2), new k(3), new k(4), new k(5), new k(6)});
    }

    public l(Context context0, String s, int v) {
        super(context0, s, null, v);
        this.b = false;
        this.a = v;
    }

    public static void c(SQLiteDatabase sQLiteDatabase0, int v, int v1) {
        List list0 = l.e;
        if(v1 <= list0.size()) {
            while(v < v1) {
                switch(((k)list0.get(v)).a) {
                    case 0: {
                        x.v(sQLiteDatabase0, "CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)", "CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)", "CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)", "CREATE INDEX events_backend_id on events(context_id)");
                        sQLiteDatabase0.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
                        break;
                    }
                    case 1: {
                        sQLiteDatabase0.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
                        sQLiteDatabase0.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
                        sQLiteDatabase0.execSQL("DROP INDEX contexts_backend_priority");
                        break;
                    }
                    case 2: {
                        sQLiteDatabase0.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
                        break;
                    }
                    case 3: {
                        sQLiteDatabase0.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
                        sQLiteDatabase0.execSQL("DROP TABLE IF EXISTS event_payloads");
                        sQLiteDatabase0.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
                        break;
                    }
                    case 4: {
                        x.v(sQLiteDatabase0, "DROP TABLE IF EXISTS log_event_dropped", "DROP TABLE IF EXISTS global_log_event_state", "CREATE TABLE log_event_dropped (log_source VARCHAR(45) NOT NULL,reason INTEGER NOT NULL,events_dropped_count BIGINT NOT NULL,PRIMARY KEY(log_source, reason))", "CREATE TABLE global_log_event_state (last_metrics_upload_ms BIGINT PRIMARY KEY)");
                        sQLiteDatabase0.execSQL("INSERT INTO global_log_event_state VALUES (1757129015012)");
                        break;
                    }
                    case 5: {
                        sQLiteDatabase0.execSQL("ALTER TABLE events ADD COLUMN product_id INTEGER");
                        break;
                    }
                    default: {
                        sQLiteDatabase0.execSQL("ALTER TABLE events ADD COLUMN pseudonymous_id TEXT");
                        sQLiteDatabase0.execSQL("ALTER TABLE events ADD COLUMN experiment_ids_clear_blob BLOB");
                        sQLiteDatabase0.execSQL("ALTER TABLE events ADD COLUMN experiment_ids_encrypted_blob BLOB");
                    }
                }
                ++v;
            }
            return;
        }
        StringBuilder stringBuilder0 = o.t(v, v1, "Migration from ", " to ", " was requested, but cannot be performed. Only ");
        stringBuilder0.append(list0.size());
        stringBuilder0.append(" migrations are provided");
        throw new IllegalArgumentException(stringBuilder0.toString());
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public final void onConfigure(SQLiteDatabase sQLiteDatabase0) {
        this.b = true;
        sQLiteDatabase0.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase0.setForeignKeyConstraintsEnabled(true);
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase0) {
        if(!this.b) {
            this.onConfigure(sQLiteDatabase0);
        }
        l.c(sQLiteDatabase0, 0, this.a);
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase0, int v, int v1) {
        x.v(sQLiteDatabase0, "DROP TABLE events", "DROP TABLE event_metadata", "DROP TABLE transport_contexts", "DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase0.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase0.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        if(!this.b) {
            this.onConfigure(sQLiteDatabase0);
        }
        l.c(sQLiteDatabase0, 0, v1);
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase0) {
        if(!this.b) {
            this.onConfigure(sQLiteDatabase0);
        }
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase0, int v, int v1) {
        if(!this.b) {
            this.onConfigure(sQLiteDatabase0);
        }
        l.c(sQLiteDatabase0, v, v1);
    }
}

