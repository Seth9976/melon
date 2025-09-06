package com.google.android.exoplayer2.offline;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.database.VersionTable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;

public final class DefaultDownloadIndex implements WritableDownloadIndex {
    static final class DownloadCursorImpl implements DownloadCursor {
        private final Cursor cursor;

        private DownloadCursorImpl(Cursor cursor0) {
            this.cursor = cursor0;
        }

        public DownloadCursorImpl(Cursor cursor0, com.google.android.exoplayer2.offline.DefaultDownloadIndex.1 defaultDownloadIndex$10) {
            this(cursor0);
        }

        @Override  // com.google.android.exoplayer2.offline.DownloadCursor
        public void close() {
            this.cursor.close();
        }

        @Override  // com.google.android.exoplayer2.offline.DownloadCursor
        public int getCount() {
            return this.cursor.getCount();
        }

        @Override  // com.google.android.exoplayer2.offline.DownloadCursor
        public Download getDownload() {
            return DefaultDownloadIndex.getDownloadForCurrentRow(this.cursor);
        }

        @Override  // com.google.android.exoplayer2.offline.DownloadCursor
        public int getPosition() {
            return this.cursor.getPosition();
        }

        @Override  // com.google.android.exoplayer2.offline.DownloadCursor
        public boolean isClosed() {
            return this.cursor.isClosed();
        }

        @Override  // com.google.android.exoplayer2.offline.DownloadCursor
        public boolean moveToPosition(int v) {
            return this.cursor.moveToPosition(v);
        }
    }

    private static final String[] COLUMNS = null;
    private static final String COLUMN_BYTES_DOWNLOADED = "bytes_downloaded";
    private static final String COLUMN_CONTENT_LENGTH = "content_length";
    private static final String COLUMN_CUSTOM_CACHE_KEY = "custom_cache_key";
    private static final String COLUMN_DATA = "data";
    private static final String COLUMN_FAILURE_REASON = "failure_reason";
    private static final String COLUMN_ID = "id";
    private static final int COLUMN_INDEX_BYTES_DOWNLOADED = 13;
    private static final int COLUMN_INDEX_CONTENT_LENGTH = 9;
    private static final int COLUMN_INDEX_CUSTOM_CACHE_KEY = 4;
    private static final int COLUMN_INDEX_DATA = 5;
    private static final int COLUMN_INDEX_FAILURE_REASON = 11;
    private static final int COLUMN_INDEX_ID = 0;
    private static final int COLUMN_INDEX_PERCENT_DOWNLOADED = 12;
    private static final int COLUMN_INDEX_START_TIME_MS = 7;
    private static final int COLUMN_INDEX_STATE = 6;
    private static final int COLUMN_INDEX_STOP_REASON = 10;
    private static final int COLUMN_INDEX_STREAM_KEYS = 3;
    private static final int COLUMN_INDEX_TYPE = 1;
    private static final int COLUMN_INDEX_UPDATE_TIME_MS = 8;
    private static final int COLUMN_INDEX_URI = 2;
    private static final String COLUMN_PERCENT_DOWNLOADED = "percent_downloaded";
    private static final String COLUMN_START_TIME_MS = "start_time_ms";
    private static final String COLUMN_STATE = "state";
    private static final String COLUMN_STOP_REASON = "stop_reason";
    private static final String COLUMN_STREAM_KEYS = "stream_keys";
    private static final String COLUMN_TYPE = "title";
    private static final String COLUMN_UPDATE_TIME_MS = "update_time_ms";
    private static final String COLUMN_URI = "uri";
    private static final String TABLE_PREFIX = "ExoPlayerDownloads";
    private static final String TABLE_SCHEMA = "(id TEXT PRIMARY KEY NOT NULL,title TEXT NOT NULL,uri TEXT NOT NULL,stream_keys TEXT NOT NULL,custom_cache_key TEXT,data BLOB NOT NULL,state INTEGER NOT NULL,start_time_ms INTEGER NOT NULL,update_time_ms INTEGER NOT NULL,content_length INTEGER NOT NULL,stop_reason INTEGER NOT NULL,failure_reason INTEGER NOT NULL,percent_downloaded REAL NOT NULL,bytes_downloaded INTEGER NOT NULL)";
    static final int TABLE_VERSION = 2;
    private static final String TRUE = "1";
    private static final String WHERE_ID_EQUALS = "id = ?";
    private static final String WHERE_STATE_IS_DOWNLOADING = "state = 2";
    private static final String WHERE_STATE_IS_TERMINAL;
    private final DatabaseProvider databaseProvider;
    private boolean initialized;
    private final String name;
    private final String tableName;

    static {
        DefaultDownloadIndex.WHERE_STATE_IS_TERMINAL = "state IN (3,4)";
        DefaultDownloadIndex.COLUMNS = new String[]{"id", "title", "uri", "stream_keys", "custom_cache_key", "data", "state", "start_time_ms", "update_time_ms", "content_length", "stop_reason", "failure_reason", "percent_downloaded", "bytes_downloaded"};
    }

    public DefaultDownloadIndex(DatabaseProvider databaseProvider0) {
        this(databaseProvider0, "");
    }

    public DefaultDownloadIndex(DatabaseProvider databaseProvider0, String s) {
        this.name = s;
        this.databaseProvider = databaseProvider0;
        String s1 = String.valueOf(s);
        this.tableName = s1.length() == 0 ? new String("ExoPlayerDownloads") : "ExoPlayerDownloads" + s1;
    }

    private static List decodeStreamKeys(String s) {
        List list0 = new ArrayList();
        if(!s.isEmpty()) {
            String[] arr_s = Util.split(s, ",");
            for(int v = 0; v < arr_s.length; ++v) {
                String[] arr_s1 = Util.split(arr_s[v], "\\.");
                Assertions.checkState(arr_s1.length == 3);
                ((ArrayList)list0).add(new StreamKey(Integer.parseInt(arr_s1[0]), Integer.parseInt(arr_s1[1]), Integer.parseInt(arr_s1[2])));
            }
        }
        return list0;
    }

    private static String encodeStreamKeys(List list0) {
        StringBuilder stringBuilder0 = new StringBuilder();
        for(int v = 0; v < list0.size(); ++v) {
            StreamKey streamKey0 = (StreamKey)list0.get(v);
            stringBuilder0.append(streamKey0.periodIndex);
            stringBuilder0.append('.');
            stringBuilder0.append(streamKey0.groupIndex);
            stringBuilder0.append('.');
            stringBuilder0.append(streamKey0.trackIndex);
            stringBuilder0.append(',');
        }
        if(stringBuilder0.length() > 0) {
            stringBuilder0.setLength(stringBuilder0.length() - 1);
        }
        return stringBuilder0.toString();
    }

    private void ensureInitialized() {
        if(this.initialized) {
            return;
        }
        try {
            if(VersionTable.getVersion(this.databaseProvider.getReadableDatabase(), 0, this.name) != 2) {
                SQLiteDatabase sQLiteDatabase0 = this.databaseProvider.getWritableDatabase();
                sQLiteDatabase0.beginTransactionNonExclusive();
                try {
                    VersionTable.setVersion(sQLiteDatabase0, 0, this.name, 2);
                    String s = String.valueOf(this.tableName);
                    sQLiteDatabase0.execSQL((s.length() == 0 ? new String("DROP TABLE IF EXISTS ") : "DROP TABLE IF EXISTS " + s));
                    sQLiteDatabase0.execSQL("CREATE TABLE " + this.tableName + " (id TEXT PRIMARY KEY NOT NULL,title TEXT NOT NULL,uri TEXT NOT NULL,stream_keys TEXT NOT NULL,custom_cache_key TEXT,data BLOB NOT NULL,state INTEGER NOT NULL,start_time_ms INTEGER NOT NULL,update_time_ms INTEGER NOT NULL,content_length INTEGER NOT NULL,stop_reason INTEGER NOT NULL,failure_reason INTEGER NOT NULL,percent_downloaded REAL NOT NULL,bytes_downloaded INTEGER NOT NULL)");
                    sQLiteDatabase0.setTransactionSuccessful();
                }
                finally {
                    sQLiteDatabase0.endTransaction();
                }
            }
            this.initialized = true;
            return;
        }
        catch(SQLException sQLException0) {
        }
        throw new DatabaseIOException(sQLException0);
    }

    private Cursor getCursor(String s, String[] arr_s) {
        try {
            return this.databaseProvider.getReadableDatabase().query(this.tableName, DefaultDownloadIndex.COLUMNS, s, arr_s, null, null, "start_time_ms ASC");
        }
        catch(SQLiteException sQLiteException0) {
            throw new DatabaseIOException(sQLiteException0);
        }
    }

    @Override  // com.google.android.exoplayer2.offline.DownloadIndex
    public Download getDownload(String s) {
        this.ensureInitialized();
        try(Cursor cursor0 = this.getCursor("id = ?", new String[]{s})) {
            if(cursor0.getCount() == 0) {
                return null;
            }
            cursor0.moveToNext();
            return DefaultDownloadIndex.getDownloadForCurrentRow(cursor0);
        }
        catch(SQLiteException sQLiteException0) {
            throw new DatabaseIOException(sQLiteException0);
        }
    }

    private static Download getDownloadForCurrentRow(Cursor cursor0) {
        int v = 0;
        DownloadRequest downloadRequest0 = new DownloadRequest(cursor0.getString(0), cursor0.getString(1), Uri.parse(cursor0.getString(2)), DefaultDownloadIndex.decodeStreamKeys(cursor0.getString(3)), cursor0.getString(4), cursor0.getBlob(5));
        DownloadProgress downloadProgress0 = new DownloadProgress();
        downloadProgress0.bytesDownloaded = cursor0.getLong(13);
        downloadProgress0.percentDownloaded = cursor0.getFloat(12);
        int v1 = cursor0.getInt(6);
        if(v1 == 4) {
            v = cursor0.getInt(11);
        }
        return new Download(downloadRequest0, v1, cursor0.getLong(7), cursor0.getLong(8), cursor0.getLong(9), cursor0.getInt(10), v, downloadProgress0);
    }

    @Override  // com.google.android.exoplayer2.offline.DownloadIndex
    public DownloadCursor getDownloads(int[] arr_v) {
        this.ensureInitialized();
        return new DownloadCursorImpl(this.getCursor(DefaultDownloadIndex.getStateQuery(arr_v), null), null);
    }

    private static String getStateQuery(int[] arr_v) {
        if(arr_v.length == 0) {
            return "1";
        }
        StringBuilder stringBuilder0 = new StringBuilder("state IN (");
        for(int v = 0; v < arr_v.length; ++v) {
            if(v > 0) {
                stringBuilder0.append(',');
            }
            stringBuilder0.append(arr_v[v]);
        }
        stringBuilder0.append(')');
        return stringBuilder0.toString();
    }

    @Override  // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void putDownload(Download download0) {
        this.ensureInitialized();
        ContentValues contentValues0 = new ContentValues();
        contentValues0.put("id", download0.request.id);
        contentValues0.put("title", download0.request.type);
        contentValues0.put("uri", download0.request.uri.toString());
        contentValues0.put("stream_keys", DefaultDownloadIndex.encodeStreamKeys(download0.request.streamKeys));
        contentValues0.put("custom_cache_key", download0.request.customCacheKey);
        contentValues0.put("data", download0.request.data);
        contentValues0.put("state", download0.state);
        contentValues0.put("start_time_ms", download0.startTimeMs);
        contentValues0.put("update_time_ms", download0.updateTimeMs);
        contentValues0.put("content_length", download0.contentLength);
        contentValues0.put("stop_reason", download0.stopReason);
        contentValues0.put("failure_reason", download0.failureReason);
        contentValues0.put("percent_downloaded", download0.getPercentDownloaded());
        contentValues0.put("bytes_downloaded", download0.getBytesDownloaded());
        try {
            this.databaseProvider.getWritableDatabase().replaceOrThrow(this.tableName, null, contentValues0);
        }
        catch(SQLiteException sQLiteException0) {
            throw new DatabaseIOException(sQLiteException0);
        }
    }

    @Override  // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void removeDownload(String s) {
        this.ensureInitialized();
        try {
            this.databaseProvider.getWritableDatabase().delete(this.tableName, "id = ?", new String[]{s});
        }
        catch(SQLiteException sQLiteException0) {
            throw new DatabaseIOException(sQLiteException0);
        }
    }

    @Override  // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void setDownloadingStatesToQueued() {
        this.ensureInitialized();
        try {
            ContentValues contentValues0 = new ContentValues();
            contentValues0.put("state", 0);
            this.databaseProvider.getWritableDatabase().update(this.tableName, contentValues0, "state = 2", null);
        }
        catch(SQLException sQLException0) {
            throw new DatabaseIOException(sQLException0);
        }
    }

    @Override  // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void setStatesToRemoving() {
        this.ensureInitialized();
        try {
            ContentValues contentValues0 = new ContentValues();
            contentValues0.put("state", 5);
            contentValues0.put("failure_reason", 0);
            this.databaseProvider.getWritableDatabase().update(this.tableName, contentValues0, null, null);
        }
        catch(SQLException sQLException0) {
            throw new DatabaseIOException(sQLException0);
        }
    }

    @Override  // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void setStopReason(int v) {
        this.ensureInitialized();
        try {
            ContentValues contentValues0 = new ContentValues();
            contentValues0.put("stop_reason", v);
            this.databaseProvider.getWritableDatabase().update(this.tableName, contentValues0, "state IN (3,4)", null);
        }
        catch(SQLException sQLException0) {
            throw new DatabaseIOException(sQLException0);
        }
    }

    @Override  // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void setStopReason(String s, int v) {
        this.ensureInitialized();
        try {
            ContentValues contentValues0 = new ContentValues();
            contentValues0.put("stop_reason", v);
            this.databaseProvider.getWritableDatabase().update(this.tableName, contentValues0, "state IN (3,4) AND id = ?", new String[]{s});
        }
        catch(SQLException sQLException0) {
            throw new DatabaseIOException(sQLException0);
        }
    }

    class com.google.android.exoplayer2.offline.DefaultDownloadIndex.1 {
    }

}

