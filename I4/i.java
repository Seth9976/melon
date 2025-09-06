package I4;

import android.database.sqlite.SQLiteStatement;

public final class i extends h implements H4.h {
    public final SQLiteStatement b;

    public i(SQLiteStatement sQLiteStatement0) {
        super(sQLiteStatement0);
        this.b = sQLiteStatement0;
    }

    @Override  // H4.h
    public final long D() {
        return this.b.executeInsert();
    }

    @Override  // H4.h
    public final void execute() {
        this.b.execute();
    }

    @Override  // H4.h
    public final int w() {
        return this.b.executeUpdateDelete();
    }
}

