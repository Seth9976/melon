package com.kakao.emoticon.db.model;

import H0.b;
import android.content.ContentValues;
import android.database.Cursor;
import com.kakao.emoticon.db.BaseDAO;
import com.kakao.emoticon.db.DataBaseWrapper;
import com.kakao.emoticon.net.response.Emoticon;
import java.util.ArrayList;
import java.util.List;
import jeb.synthetic.TWR;

public class EmoticonDAO extends BaseDAO {
    private static final String TABLE_NAME = "emoticons";
    private static EmoticonDAO instance;

    public EmoticonDAO() {
        super("emoticons");
    }

    public List getAll() {
        List list0 = new ArrayList();
        try {
            Cursor cursor0 = this.getDAO().getDB().query("emoticons", null, null, null, null, null, "order_index ASC");
            if(cursor0 != null) {
                try {
                    if(cursor0.getCount() != 0) {
                        cursor0.moveToFirst();
                        while(true) {
                            if(cursor0.isAfterLast()) {
                                goto label_13;
                            }
                            ((ArrayList)list0).add(this.populateObject(cursor0));
                            cursor0.moveToNext();
                        }
                    }
                }
                catch(Throwable throwable0) {
                    TWR.safeClose$NT(cursor0, throwable0);
                    throw throwable0;
                }
            }
            if(cursor0 != null) {
            label_13:
                cursor0.close();
                return list0;
            }
        }
        catch(Exception unused_ex) {
        }
        return list0;
    }

    @Override  // com.kakao.emoticon.db.BaseDAO
    public String getPrimaryColumnName() [...] // Inlined contents

    public String getPrimaryCondition(Emoticon emoticon0) {
        return b.j("id", "=\'", emoticon0.getId(), "\'");
    }

    @Override  // com.kakao.emoticon.db.BaseDAO
    public String getPrimaryCondition(Object object0) {
        return this.getPrimaryCondition(((Emoticon)object0));
    }

    public String getPrimarykey(Emoticon emoticon0) {
        return emoticon0.getId();
    }

    @Override  // com.kakao.emoticon.db.BaseDAO
    public String getPrimarykey(Object object0) {
        return this.getPrimarykey(((Emoticon)object0));
    }

    public void insertOrUpdate(Emoticon emoticon0) {
        this.insertOrUpdate(emoticon0, this.toContentValues(emoticon0));
    }

    public void insertOrUpdate(List list0) {
        DataBaseWrapper dataBaseWrapper0 = this.getDAO().getDB();
        dataBaseWrapper0.beginTransaction();
        try {
            for(Object object0: list0) {
                this.insertOrUpdate(((Emoticon)object0), this.toContentValues(((Emoticon)object0)));
            }
            dataBaseWrapper0.setTransactionSuccessful();
        }
        finally {
            dataBaseWrapper0.endTransaction();
        }
    }

    public static EmoticonDAO instance() {
        if(EmoticonDAO.instance == null) {
            Class class0 = EmoticonDAO.class;
            synchronized(class0) {
                if(EmoticonDAO.instance == null) {
                    EmoticonDAO.instance = new EmoticonDAO();
                }
            }
        }
        return EmoticonDAO.instance;
    }

    public Emoticon populateObject(Cursor cursor0) {
        return new Emoticon(cursor0);
    }

    @Override  // com.kakao.emoticon.db.BaseDAO
    public Object populateObject(Cursor cursor0) {
        return this.populateObject(cursor0);
    }

    public boolean remove(String s) {
        return this.getDAO().getDB().delete("emoticons", "id=?", new String[]{s}) >= 1;
    }

    public ContentValues toContentValues(Emoticon emoticon0) {
        ContentValues contentValues0 = new ContentValues();
        contentValues0.put("id", emoticon0.getId());
        contentValues0.put("type", emoticon0.getItemSubType().toString());
        contentValues0.put("version", emoticon0.getVersion());
        contentValues0.put("resource_count", emoticon0.getResourceCount());
        contentValues0.put("order_index", emoticon0.getOrderIndex());
        contentValues0.put("server_order_index", emoticon0.getServerOrderIndex());
        contentValues0.put("title", emoticon0.getTitle());
        contentValues0.put("title_image_url", emoticon0.getTitleImageUrl());
        contentValues0.put("editor_name", emoticon0.getEditorName());
        contentValues0.put("on_image_url", emoticon0.getOnImageUrl());
        contentValues0.put("off_image_url", emoticon0.getOffImageUrl());
        contentValues0.put("expired_at", emoticon0.getExpiredAt());
        contentValues0.put("is_show", ((int)emoticon0.isShow()));
        contentValues0.put("is_event_item", ((int)emoticon0.isEventItem()));
        return contentValues0;
    }

    @Override  // com.kakao.emoticon.db.BaseDAO
    public ContentValues toContentValues(Object object0) {
        return this.toContentValues(((Emoticon)object0));
    }
}

