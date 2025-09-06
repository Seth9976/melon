package com.kakao.emoticon.db.model;

import U4.x;
import android.database.Cursor;
import java.util.Objects;

public class EmoticonLog {
    private final long id;
    private final String log;

    public EmoticonLog(Cursor cursor0) {
        this.id = cursor0.getLong(0);
        this.log = cursor0.getString(cursor0.getColumnIndex("log"));
    }

    public EmoticonLog(String s) {
        this.log = s;
        this.id = -1L;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof EmoticonLog)) {
            return false;
        }
        return this.id == ((EmoticonLog)object0).id ? Objects.equals(this.log, ((EmoticonLog)object0).log) : false;
    }

    public String getId() {
        return String.valueOf(this.id);
    }

    public String getLog() {
        return this.log;
    }

    @Override
    public int hashCode() {
        int v = ((int)(this.id ^ this.id >>> 0x20)) * 0x1F;
        return this.log == null ? v : v + this.log.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("EmoticonLog{id=");
        stringBuilder0.append(this.id);
        stringBuilder0.append(", log=\'");
        return x.m(stringBuilder0, this.log, "\'}");
    }
}

