package co.ab180.airbridge.internal.c0.e;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0019\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\'\u0010\u000F\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\'\u0010\u0011\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0010¨\u0006\u0014"}, d2 = {"Lco/ab180/airbridge/internal/c0/e/a;", "Landroid/database/sqlite/SQLiteOpenHelper;", "Landroid/content/Context;", "context", "", "version", "<init>", "(Landroid/content/Context;I)V", "Landroid/database/sqlite/SQLiteDatabase;", "db", "Lie/H;", "onCreate", "(Landroid/database/sqlite/SQLiteDatabase;)V", "oldVersion", "newVersion", "onUpgrade", "(Landroid/database/sqlite/SQLiteDatabase;II)V", "onDowngrade", "g", "a", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class a extends SQLiteOpenHelper {
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001A\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001A\u00020\u00058\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001A\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001A\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001A\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000B\u001A\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000B\u0010\u0004¨\u0006\u000E"}, d2 = {"co/ab180/airbridge/internal/c0/e/a$a", "", "", "DATABASE_NAME", "Ljava/lang/String;", "", "DATABASE_VERSION", "I", "SQL_CREATE_EVENTS", "SQL_CREATE_LOGS", "SQL_DELETE_EVENTS", "SQL_DELETE_LOGS", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
    public static final class co.ab180.airbridge.internal.c0.e.a.a {
        private co.ab180.airbridge.internal.c0.e.a.a() {
        }

        public co.ab180.airbridge.internal.c0.e.a.a(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int a = 6;
    @NotNull
    public static final String b = "airbridge.db";
    private static final String c = "CREATE TABLE IF NOT EXISTS event (uuid TEXT PRIMARY KEY,created_at INTEGER,type INTEGER,body TEXT,size INTEGER,secret_id TEXT, signature TEXT)";
    private static final String d = "DROP TABLE IF EXISTS event";
    private static final String e = "CREATE TABLE IF NOT EXISTS log (uuid TEXT PRIMARY KEY,level INTEGER,data TEXT)";
    private static final String f = "DROP TABLE IF EXISTS log";
    @NotNull
    public static final co.ab180.airbridge.internal.c0.e.a.a g;

    static {
        a.g = new co.ab180.airbridge.internal.c0.e.a.a(null);
    }

    public a(@NotNull Context context0, int v) {
        super(context0, "airbridge.db", null, v);
        this.setWriteAheadLoggingEnabled(true);
    }

    public a(Context context0, int v, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 2) != 0) {
            v = 6;
        }
        this(context0, v);
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(@NotNull SQLiteDatabase sQLiteDatabase0) {
        sQLiteDatabase0.execSQL("CREATE TABLE IF NOT EXISTS event (uuid TEXT PRIMARY KEY,created_at INTEGER,type INTEGER,body TEXT,size INTEGER,secret_id TEXT, signature TEXT)");
        sQLiteDatabase0.execSQL("CREATE TABLE IF NOT EXISTS log (uuid TEXT PRIMARY KEY,level INTEGER,data TEXT)");
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(@NotNull SQLiteDatabase sQLiteDatabase0, int v, int v1) {
        sQLiteDatabase0.execSQL("DROP TABLE IF EXISTS event");
        sQLiteDatabase0.execSQL("DROP TABLE IF EXISTS log");
        this.onCreate(sQLiteDatabase0);
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(@NotNull SQLiteDatabase sQLiteDatabase0, int v, int v1) {
        if(v < 3) {
            sQLiteDatabase0.execSQL("ALTER TABLE event ADD COLUMN created_at INTEGER DEFAULT 0");
        }
        if(v < 4) {
            sQLiteDatabase0.execSQL("DROP TABLE IF EXISTS category_record");
            sQLiteDatabase0.execSQL("ALTER TABLE event ADD COLUMN size INTEGER DEFAULT 0");
        }
        if(v < 5) {
            sQLiteDatabase0.execSQL("ALTER TABLE event ADD COLUMN signature TEXT DEFAULT NULL");
        }
        if(v < 6) {
            sQLiteDatabase0.execSQL("ALTER TABLE event ADD COLUMN secret_id TEXT DEFAULT NULL");
        }
    }
}

