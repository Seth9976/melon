package com.kakao.emoticon.db;

import android.database.Cursor;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONColumnMapper {
    private String columnName;
    private JSONObject jv;
    private String v;

    public JSONColumnMapper(String s) {
        this.columnName = s;
    }

    public JSONColumnMapper(JSONObject jSONObject0) {
        this.jv = jSONObject0;
    }

    public String getColumnName() {
        return this.columnName;
    }

    private JSONObject getJV() {
        JSONObject jSONObject0 = this.jv;
        if(jSONObject0 != null) {
            return jSONObject0;
        }
        synchronized(this) {
            this.populateJSON();
            return this.jv;
        }
    }

    public String getV() {
        return this.getJV().toString();
    }

    public boolean getVBooleanValue(String s, boolean z) {
        if(this.getJV().has(s)) {
            try {
                return this.getJV().getBoolean(s);
            }
            catch(JSONException unused_ex) {
            }
        }
        return z;
    }

    public int getVIntValue(String s) {
        return this.getVIntValue(s, 0);
    }

    public int getVIntValue(String s, int v) {
        if(this.getJV().has(s)) {
            try {
                return this.getJV().getInt(s);
            }
            catch(JSONException unused_ex) {
            }
        }
        return v;
    }

    public long getVLongValue(String s) {
        return this.getVLongValue(s, 0L);
    }

    public long getVLongValue(String s, long v) {
        if(this.getJV().has(s)) {
            try {
                return this.getJV().getLong(s);
            }
            catch(JSONException unused_ex) {
            }
        }
        return v;
    }

    public Object getVObject(String s) {
        if(this.getJV().has(s)) {
            try {
                return this.getJV().get(s);
            }
            catch(JSONException unused_ex) {
            }
        }
        return null;
    }

    public String getVValue(String s) {
        if(this.getJV().has(s)) {
            try {
                return this.getJV().getString(s);
            }
            catch(JSONException unused_ex) {
            }
        }
        return null;
    }

    public Iterator getVkeys() {
        return this.getJV().keys();
    }

    public boolean has(String s) {
        return this.getJV().has(s);
    }

    public void mergeV(String s) {
        JSONColumnMapper jSONColumnMapper0 = new JSONColumnMapper("");
        jSONColumnMapper0.setV(s);
        Iterator iterator0 = jSONColumnMapper0.getVkeys();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            this.setVObject(((String)object0), jSONColumnMapper0.getVObject(((String)object0)));
        }
    }

    private void populateJSON() {
        if(this.v != null && !TextUtils.isEmpty(this.v)) {
            try {
                this.jv = new JSONObject(this.v);
            }
            catch(JSONException unused_ex) {
                this.jv = new JSONObject();
            }
            return;
        }
        this.jv = new JSONObject();
    }

    public void removeVValue(String s) {
        this.getJV().remove(s);
    }

    public void setV(Cursor cursor0) {
        this.setV(cursor0.getString(cursor0.getColumnIndex(this.columnName)));
    }

    public void setV(String s) {
        synchronized(this) {
            this.v = s;
            this.jv = null;
        }
    }

    public void setVObject(String s, Object object0) {
        try {
            this.getJV().put(s, object0);
        }
        catch(JSONException unused_ex) {
        }
    }

    public void setVValue(String s, int v) {
        try {
            this.getJV().put(s, v);
        }
        catch(JSONException unused_ex) {
        }
    }

    public void setVValue(String s, long v) {
        try {
            this.getJV().put(s, v);
        }
        catch(JSONException unused_ex) {
        }
    }

    public void setVValue(String s, String s1) {
        try {
            this.getJV().put(s, s1);
        }
        catch(JSONException unused_ex) {
        }
    }

    public void setVValue(String s, boolean z) {
        try {
            this.getJV().put(s, z);
        }
        catch(JSONException unused_ex) {
        }
    }
}

