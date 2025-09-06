package com.kakao.emoticon.db.model;

import H0.b;
import android.content.ContentValues;
import android.database.Cursor;
import com.kakao.emoticon.db.BaseDAO;
import java.util.ArrayList;
import java.util.List;
import jeb.synthetic.TWR;

public class EmoticonLogDAO extends BaseDAO {
    private static final String TABLE_NAME = "emoticon_logs";
    private static EmoticonLogDAO instance;

    private EmoticonLogDAO() {
        super("emoticon_logs");
    }

    public List getAll() {
        List list0 = new ArrayList();
        Cursor cursor0 = null;
        try {
            cursor0 = this.getDAO().getDB().query("emoticon_logs", null, null, null, null, null, "_id ASC");
            if(cursor0 == null || cursor0.getCount() == 0) {
                goto label_17;
            }
            cursor0.moveToFirst();
            while(!cursor0.isAfterLast()) {
                ((ArrayList)list0).add(this.populateObject(cursor0));
                cursor0.moveToNext();
            }
        }
        catch(Exception unused_ex) {
            if(cursor0 != null) {
                cursor0.close();
                return list0;
            }
            return list0;
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(cursor0, throwable0);
            throw throwable0;
        }
        cursor0.close();
        return list0;
    label_17:
        if(cursor0 != null) {
            cursor0.close();
            return list0;
        }
        return list0;
    }

    @Override  // com.kakao.emoticon.db.BaseDAO
    public String getPrimaryColumnName() [...] // Inlined contents

    public String getPrimaryCondition(EmoticonLog emoticonLog0) {
        return b.j("_id", "=\'", emoticonLog0.getId(), "\'");
    }

    @Override  // com.kakao.emoticon.db.BaseDAO
    public String getPrimaryCondition(Object object0) {
        return this.getPrimaryCondition(((EmoticonLog)object0));
    }

    public String getPrimarykey(EmoticonLog emoticonLog0) {
        return emoticonLog0.getId();
    }

    @Override  // com.kakao.emoticon.db.BaseDAO
    public String getPrimarykey(Object object0) {
        return this.getPrimarykey(((EmoticonLog)object0));
    }

    public int getRowCount() {
        Cursor cursor0;
        int v = 0;
        try {
            cursor0 = null;
            cursor0 = this.getDAO().getDB().query("emoticon_logs", null, null, null, null, null, "_id ASC");
            if(cursor0 != null) {
                v = cursor0.getCount();
            }
        }
        catch(Exception unused_ex) {
            if(cursor0 != null) {
                cursor0.close();
            }
            return 0;
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(cursor0, throwable0);
            throw throwable0;
        }
        if(cursor0 != null) {
            cursor0.close();
        }
        return v;
    }

    public void insertOrUpdate(EmoticonLog emoticonLog0) {
        this.insertOrUpdate(emoticonLog0, this.toContentValues(emoticonLog0));
    }

    public static EmoticonLogDAO instance() {
        if(EmoticonLogDAO.instance == null) {
            Class class0 = EmoticonLogDAO.class;
            synchronized(class0) {
                if(EmoticonLogDAO.instance == null) {
                    EmoticonLogDAO.instance = new EmoticonLogDAO();
                }
            }
        }
        return EmoticonLogDAO.instance;
    }

    public EmoticonLog populateObject(Cursor cursor0) {
        return new EmoticonLog(cursor0);
    }

    @Override  // com.kakao.emoticon.db.BaseDAO
    public Object populateObject(Cursor cursor0) {
        return this.populateObject(cursor0);
    }

    public boolean remove(String s) {
        return this.getDAO().getDB().delete("emoticon_logs", "_id =?", new String[]{s}) >= 1;
    }

    public boolean removeRange(String s, String s1) {
        return this.getDAO().getDB().delete("emoticon_logs", "_id >=? AND _id <=?", new String[]{s, s1}) >= 1;
    }

    public ContentValues toContentValues(EmoticonLog emoticonLog0) {
        ContentValues contentValues0 = new ContentValues();
        contentValues0.put("log", emoticonLog0.getLog());
        return contentValues0;
    }

    @Override  // com.kakao.emoticon.db.BaseDAO
    public ContentValues toContentValues(Object object0) {
        return this.toContentValues(((EmoticonLog)object0));
    }
}

