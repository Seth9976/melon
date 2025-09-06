package co.ab180.airbridge.internal.c0;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import co.ab180.airbridge.internal.c0.e.a;
import co.ab180.airbridge.internal.e0.b0;
import co.ab180.airbridge.internal.network.body.LogData;
import co.ab180.airbridge.internal.parser.e.y;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.J;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJC\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\n2\b\u0010\u0011\u001A\u0004\u0018\u00010\n2\b\u0010\u0012\u001A\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0017J\u000F\u0010\u0018\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u0014\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0014\u0010\u0019J!\u0010\u001D\u001A\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001C0\u001B0\u001AH\u0016¢\u0006\u0004\b\u001D\u0010\u001EJ\u001F\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u001F\u001A\u00020\f2\u0006\u0010!\u001A\u00020 H\u0016¢\u0006\u0004\b\u0014\u0010\"J\u000F\u0010#\u001A\u00020\u0013H\u0016¢\u0006\u0004\b#\u0010$R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010%¨\u0006&"}, d2 = {"Lco/ab180/airbridge/internal/c0/d;", "Lco/ab180/airbridge/internal/c0/c;", "Lco/ab180/airbridge/internal/c0/e/a;", "databaseHelper", "<init>", "(Lco/ab180/airbridge/internal/c0/e/a;)V", "", "Lco/ab180/airbridge/internal/c0/a;", "e", "()Ljava/util/List;", "", "uuid", "", "type", "", "createdAt", "bodyJsonString", "secretId", "signature", "Lie/H;", "a", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "eventUUID", "(Ljava/lang/String;)V", "d", "()J", "", "", "Lco/ab180/airbridge/internal/c0/b;", "c", "()Ljava/util/Map;", "priority", "Lco/ab180/airbridge/internal/network/body/LogData;", "log", "(ILco/ab180/airbridge/internal/network/body/LogData;)V", "b", "()V", "Lco/ab180/airbridge/internal/c0/e/a;", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class d implements c {
    private final a a;

    public d(@NotNull a a0) {
        this.a = a0;
    }

    @Override  // co.ab180.airbridge.internal.c0.c
    public long a() {
        long v;
        Cursor cursor0 = this.a.getReadableDatabase().rawQuery("SELECT SUM(size) FROM event", null);
        try {
            v = cursor0.moveToFirst() ? cursor0.getLong(0) : 0L;
        }
        catch(Throwable throwable0) {
            d8.d.l(cursor0, throwable0);
            throw throwable0;
        }
        cursor0.close();
        return v;
    }

    @Override  // co.ab180.airbridge.internal.c0.c
    public void a(int v, @NotNull LogData logData0) {
        String s;
        SQLiteDatabase sQLiteDatabase0 = this.a.getWritableDatabase();
        co.ab180.airbridge.internal.parser.c c0 = co.ab180.airbridge.internal.parser.c.b;
        J j0 = I.a;
        De.d d0 = j0.b(LogData.class);
        if(d0.equals(j0.b(Map.class))) {
            s = b0.a(((Map)logData0)).toString();
        }
        else {
            s = d0.equals(j0.b(List.class)) ? b0.a(((List)logData0)).toString() : c0.b(logData0).toString();
        }
        ContentValues contentValues0 = new ContentValues();
        contentValues0.put("uuid", logData0.getUuid());
        contentValues0.put("level", v);
        contentValues0.put("data", s);
        sQLiteDatabase0.insert("log", null, contentValues0);
    }

    @Override  // co.ab180.airbridge.internal.c0.c
    public void a(@NotNull String s) {
        this.a.getWritableDatabase().delete("event", "uuid=?", new String[]{s});
    }

    @Override  // co.ab180.airbridge.internal.c0.c
    public void a(@NotNull String s, int v, long v1, @NotNull String s1, @Nullable String s2, @Nullable String s3) {
        SQLiteDatabase sQLiteDatabase0 = this.a.getWritableDatabase();
        ContentValues contentValues0 = new ContentValues();
        contentValues0.put("uuid", s);
        contentValues0.put("created_at", v1);
        contentValues0.put("type", v);
        contentValues0.put("body", s1);
        contentValues0.put("size", s1.length());
        if(s2 != null) {
            contentValues0.put("secret_id", s2);
        }
        if(s3 != null) {
            contentValues0.put("signature", s3);
        }
        sQLiteDatabase0.insert("event", null, contentValues0);
    }

    @Override  // co.ab180.airbridge.internal.c0.c
    public void b() {
        this.a.getWritableDatabase().execSQL("DELETE FROM log");
    }

    @Override  // co.ab180.airbridge.internal.c0.c
    @NotNull
    public Map c() {
        LogData logData0;
        Object object0;
        Class class0 = LogData.class;
        Cursor cursor0 = this.a.getWritableDatabase().rawQuery("SELECT * FROM log", null);
        Map map0 = new LinkedHashMap();
        try {
            while(true) {
                if(!cursor0.moveToNext()) {
                    goto label_46;
                }
                String s = cursor0.getString(cursor0.getColumnIndexOrThrow("uuid"));
                int v = cursor0.getInt(cursor0.getColumnIndexOrThrow("level"));
                String s1 = cursor0.getString(cursor0.getColumnIndexOrThrow("data"));
                if(!map0.containsKey(v)) {
                    map0.put(v, new ArrayList());
                }
                List list0 = (List)((LinkedHashMap)map0).get(v);
                if(list0 != null) {
                    co.ab180.airbridge.internal.parser.c c0 = co.ab180.airbridge.internal.parser.c.b;
                    J j0 = I.a;
                    De.d d0 = j0.b(class0);
                    if(d0.equals(j0.b(Map.class))) {
                        Map map1 = b0.a(new JSONObject(s1));
                        if(map1 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type co.ab180.airbridge.internal.network.body.LogData");
                        }
                        logData0 = (LogData)map1;
                    }
                    else if(!d0.equals(j0.b(List.class))) {
                        JSONObject jSONObject0 = new JSONObject(s1);
                        co.ab180.airbridge.internal.parser.a a0 = co.ab180.airbridge.internal.parser.c.a(c0, class0);
                        if(a0 == null) {
                            object0 = null;
                        }
                        else {
                            y y0 = a0.b();
                            if(y0 != null) {
                                object0 = y0.a(jSONObject0);
                            }
                        }
                        if(!(object0 instanceof LogData)) {
                            object0 = null;
                        }
                        logData0 = (LogData)object0;
                        if(logData0 == null) {
                            throw new IllegalAccessException();
                        }
                    }
                    else {
                        List list1 = b0.a(new JSONArray(s1));
                        if(!(list1 instanceof LogData)) {
                            list1 = null;
                        }
                        logData0 = (LogData)list1;
                        if(logData0 == null) {
                            throw new IllegalAccessException();
                        }
                    }
                    list0.add(new b(s, v, logData0));
                }
            }
        }
        catch(Throwable throwable0) {
        }
        try {
            throw throwable0;
        }
        catch(Throwable throwable1) {
            d8.d.l(cursor0, throwable0);
            throw throwable1;
        }
    label_46:
        cursor0.close();
        return map0;
    }

    @Override  // co.ab180.airbridge.internal.c0.c
    public long d() {
        return DatabaseUtils.queryNumEntries(this.a.getReadableDatabase(), "event");
    }

    @Override  // co.ab180.airbridge.internal.c0.c
    @NotNull
    public List e() {
        Cursor cursor0 = this.a.getWritableDatabase().rawQuery("SELECT * FROM event ORDER BY created_at LIMIT 100", null);
        List list0 = new ArrayList();
        while(true) {
            try {
                if(!cursor0.moveToNext()) {
                    break;
                }
                ((ArrayList)list0).add(new co.ab180.airbridge.internal.c0.a(cursor0.getString(cursor0.getColumnIndex("uuid")), cursor0.getInt(cursor0.getColumnIndex("type")), cursor0.getLong(cursor0.getColumnIndex("created_at")), cursor0.getString(cursor0.getColumnIndex("body")), cursor0.getString(cursor0.getColumnIndex("secret_id")), cursor0.getString(cursor0.getColumnIndex("signature"))));
            }
            catch(Throwable throwable0) {
                d8.d.l(cursor0, throwable0);
                throw throwable0;
            }
        }
        cursor0.close();
        return list0;
    }
}

