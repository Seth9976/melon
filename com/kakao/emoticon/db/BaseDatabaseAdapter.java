package com.kakao.emoticon.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.appcompat.app.o;
import com.kakao.emoticon.KakaoEmoticon;
import com.kakao.emoticon.R.raw;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import jeb.synthetic.TWR;

public abstract class BaseDatabaseAdapter extends SQLiteOpenHelper {
    private static final String SCHEMA_MIGRATIONS = "schema_migrations";
    private Context context;
    private String databaseName;
    private int databaseVersion;
    private DataBaseWrapper dbWrapper;
    private String sql;

    public BaseDatabaseAdapter(Context context0, String s, int v) {
        super(context0, s, null, v);
        this.context = context0;
        this.databaseVersion = v;
        this.databaseName = s;
        this.sql = BaseDatabaseAdapter.readRawTextFile(KakaoEmoticon.getApplication().getApplicationContext(), raw.emoticon_database).replaceAll("\\r|\\n", " ");
        this.dbWrapper = new DataBaseWrapper(this.getWritableDatabase(), this.getSqliteVersion(this.getWritableDatabase()));
        this.chekckAndCreateTable(this.getWritableDatabase());
    }

    private void chekckAndCreateTable(SQLiteDatabase sQLiteDatabase0) {
        stringBuilder0.toString();
        try {
            for(Object object0: this.readSqlStatements()) {
                stringBuilder1.toString();
                sQLiteDatabase0.execSQL(((String)object0));
            }
            this.updateMigrationVersion(sQLiteDatabase0, this.databaseVersion);
        }
        catch(SQLException unused_ex) {
            stringBuilder2.toString();
        }
    }

    public int delete(String s) {
        return this.getDB().delete(s, "1", null);
    }

    public void dispose() {
        DataBaseWrapper dataBaseWrapper0 = this.dbWrapper;
        if(dataBaseWrapper0 != null) {
            try {
                dataBaseWrapper0.close();
                this.dbWrapper = null;
            }
            catch(Exception unused_ex) {
            }
        }
    }

    private void doUpgrade(SQLiteDatabase sQLiteDatabase0, int v, int v1) {
        stringBuilder0.toString();
        sQLiteDatabase0.execSQL("CREATE TABLE IF NOT EXISTS schema_migrations (\'version\' TEXT NOT NULL)");
        int v2 = this.getMigrationVersion(sQLiteDatabase0);
        o.t(v2, v, "oldMigrationVersion ", "    oldVersion ", "    newVersion ").append(v1);
        if(v2 >= this.getDatabaseVersion()) {
            return;
        }
        this.doUpgrade(sQLiteDatabase0, v2);
        stringBuilder1.toString();
    }

    public abstract void doUpgrade(SQLiteDatabase arg1, int arg2);

    public Cursor get(String s, String[] arr_s) {
        return this.getDB().query(s, arr_s, null, null, null, null, null);
    }

    public static List getColumnNames(DataBaseWrapper dataBaseWrapper0, String s, String s1) {
        Cursor cursor0 = dataBaseWrapper0.rawQuery("SELECT * FROM " + s + "." + s1 + " LIMIT 0", null);
        String[] arr_s = cursor0.getColumnNames();
        cursor0.close();
        return new ArrayList(Arrays.asList(arr_s));
    }

    public Context getContext() {
        return this.context;
    }

    public DataBaseWrapper getDB() {
        return this.dbWrapper;
    }

    private File getDatabaseFile() {
        return this.context.getDatabasePath(this.databaseName);
    }

    public File getDatabasePath() {
        return this.context.getDatabasePath(this.databaseName);
    }

    public int getDatabaseVersion() {
        return this.databaseVersion;
    }

    public int getMigrationVersion(SQLiteDatabase sQLiteDatabase0) {
        try(Cursor cursor0 = sQLiteDatabase0.query("schema_migrations", null, null, null, null, null, null, "1")) {
            return cursor0.moveToFirst() ? cursor0.getInt(cursor0.getColumnIndex("version")) : -1;
        }
    }

    private String getSqliteVersion(SQLiteDatabase sQLiteDatabase0) {
        String s1;
        Cursor cursor0;
        String s = null;
        try {
            cursor0 = sQLiteDatabase0.rawQuery("SELECT sqlite_version() AS sqlite_version", null);
        }
        catch(Exception unused_ex) {
            s1 = null;
            goto label_13;
        }
        if(cursor0 == null) {
            return null;
        }
        while(true) {
            try {
                if(!cursor0.moveToNext()) {
                    break;
                }
                s = cursor0.getString(0);
            }
            catch(Exception unused_ex) {
                String s2 = s;
                s = cursor0;
                s1 = s2;
            label_13:
                if(s != null) {
                    ((Cursor)s).close();
                }
                return s1;
            }
            catch(Throwable throwable0) {
                TWR.safeClose$NT(cursor0, throwable0);
                throw throwable0;
            }
        }
        cursor0.close();
        return s;
    }

    public long insert(String s, ContentValues contentValues0) {
        return this.getDB().insert(s, null, contentValues0);
    }

    public long insertOrThrow(String s, ContentValues contentValues0) {
        return this.getDB().insertOrThrow(s, null, contentValues0);
    }

    public static boolean isTableExists(DataBaseWrapper dataBaseWrapper0, String s, String s1) {
        Cursor cursor0 = dataBaseWrapper0.rawQuery("SELECT 1 FROM " + s + " WHERE tbl_name = \'" + s1 + "\' AND type = \'table\'", null);
        boolean z = cursor0.getCount() > 0;
        cursor0.close();
        return z;
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase0) {
        this.chekckAndCreateTable(sQLiteDatabase0);
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase0, int v, int v1) {
        sQLiteDatabase0.beginTransaction();
        try {
            this.doUpgrade(sQLiteDatabase0, v, v1);
            this.updateMigrationVersion(sQLiteDatabase0, this.databaseVersion);
            sQLiteDatabase0.setTransactionSuccessful();
        }
        finally {
            sQLiteDatabase0.endTransaction();
        }
    }

    public static List parseStatements(String s) {
        List list0 = new LinkedList();
        for(int v = s.indexOf("CREATE "); v >= 0; v = v1) {
            int v1 = s.indexOf("CREATE ", v + 7);
            String s1 = s.substring(v, (v1 == -1 ? s.length() : v1)).trim();
            if(!s1.equals("")) {
                ((LinkedList)list0).add(s1);
            }
        }
        return list0;
    }

    public static String readRawTextFile(Context context0, int v) {
        InputStream inputStream0 = context0.getResources().openRawResource(v);
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
        try {
            for(int v1 = inputStream0.read(); v1 != -1; v1 = inputStream0.read()) {
                byteArrayOutputStream0.write(v1);
            }
            inputStream0.close();
            return byteArrayOutputStream0.toString();
        }
        catch(IOException unused_ex) {
            return null;
        }
    }

    public static String readRawTextFileByLine(Context context0, int v) {
        BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(context0.getResources().openRawResource(v)));
        StringBuilder stringBuilder0 = new StringBuilder();
        try {
            String s;
            while((s = bufferedReader0.readLine()) != null) {
                stringBuilder0.append(s);
                stringBuilder0.append('\n');
            }
            return stringBuilder0.toString();
        }
        catch(IOException unused_ex) {
            return null;
        }
    }

    public List readSqlStatements() {
        return BaseDatabaseAdapter.parseStatements(this.sql);
    }

    public void removeDatabaseFile() {
        this.context.deleteDatabase(this.databaseName);
    }

    public long replace(String s, ContentValues contentValues0) {
        return this.getDB().replace(s, null, contentValues0);
    }

    public static String replaceCreateToCreateIfNotExist(String s) {
        return s.replaceAll("CREATE TABLE ", "CREATE TABLE IF NOT EXISTS ").replaceAll("INDEX ", "INDEX IF NOT EXISTS ");
    }

    public void updateMigrationVersion(SQLiteDatabase sQLiteDatabase0, int v) {
        sQLiteDatabase0.delete("schema_migrations", null, null);
        ContentValues contentValues0 = new ContentValues(1);
        contentValues0.put("version", v);
        sQLiteDatabase0.insert("schema_migrations", null, contentValues0);
        stringBuilder0.toString();
    }
}

