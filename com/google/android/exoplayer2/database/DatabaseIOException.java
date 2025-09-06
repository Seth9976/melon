package com.google.android.exoplayer2.database;

import android.database.SQLException;
import java.io.IOException;

public final class DatabaseIOException extends IOException {
    public DatabaseIOException(SQLException sQLException0) {
        super(sQLException0);
    }

    public DatabaseIOException(SQLException sQLException0, String s) {
        super(s, sQLException0);
    }
}

