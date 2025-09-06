package com.kakao.emoticon.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.text.TextUtils;
import java.util.Collection;
import va.e;

public abstract class BaseDAO {
    protected String tableName;

    public BaseDAO(String s) {
        this.tableName = s;
    }

    public int destroy(long v) {
        return this.getDAO().getDB().delete(this.tableName, this.getPrimaryColumnName() + "=" + v, null);
    }

    public int destroyIn(Collection collection0) {
        return collection0 == null || collection0.size() <= 0 ? 0 : this.getDAO().getDB().delete(this.tableName, this.getPrimaryColumnName() + " IN (" + TextUtils.join(",", collection0) + ")", null);
    }

    public Object get(String s) {
        Object object0;
        Cursor cursor0 = this.getDAO().getDB().query(this.tableName, null, e.h(this.getPrimaryColumnName(), "=?"), new String[]{s}, null, null, null);
        if(cursor0 != null) {
            try {
                if(cursor0.getCount() != 0) {
                    cursor0.moveToFirst();
                    try {
                        object0 = this.populateObject(cursor0);
                        goto label_13;
                    }
                    catch(Exception unused_ex) {
                    }
                    goto label_6;
                }
                goto label_16;
            }
            catch(Throwable throwable0) {
                goto label_10;
            }
        label_6:
            if(!cursor0.isClosed()) {
                cursor0.close();
            }
            return null;
        label_10:
            if(!cursor0.isClosed()) {
                cursor0.close();
            }
            throw throwable0;
        label_13:
            if(!cursor0.isClosed()) {
                cursor0.close();
            }
            return object0;
        }
    label_16:
        if(cursor0 != null && !cursor0.isClosed()) {
            cursor0.close();
        }
        return null;
    }

    public BaseDatabaseAdapter getDAO() {
        return DatabaseAdapter.getInstance();
    }

    public abstract String getPrimaryColumnName();

    public abstract String getPrimaryCondition(Object arg1);

    public abstract String getPrimarykey(Object arg1);

    public long insertOrThrow(ContentValues contentValues0) {
        return this.getDAO().getDB().insertOrThrow(this.tableName, null, contentValues0);
    }

    public void insertOrUpdate(Object object0, ContentValues contentValues0) {
        try {
            this.insertOrThrow(contentValues0);
        }
        catch(SQLiteConstraintException unused_ex) {
            this.update(object0, contentValues0);
        }
    }

    public abstract Object populateObject(Cursor arg1);

    public long replace(ContentValues contentValues0) {
        return this.getDAO().replace(this.tableName, contentValues0);
    }

    public abstract ContentValues toContentValues(Object arg1);

    public int update(long v, ContentValues contentValues0) {
        return this.getDAO().getDB().update(this.tableName, contentValues0, this.getPrimaryColumnName() + "=" + v, null);
    }

    public int update(Object object0, ContentValues contentValues0) {
        return this.getDAO().getDB().update(this.tableName, contentValues0, this.getPrimaryCondition(object0), null);
    }

    public void updateOrCreate(Object object0, ContentValues contentValues0) {
        if(this.update(object0, contentValues0) == 0) {
            try {
                this.insertOrThrow(contentValues0);
            }
            catch(Exception unused_ex) {
            }
        }
    }
}

