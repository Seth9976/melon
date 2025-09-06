package com.google.gson.internal.sql;

import W7.a;
import W7.b;
import com.google.gson.E;
import com.google.gson.F;
import com.google.gson.n;
import com.google.gson.reflect.TypeToken;
import com.google.gson.x;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public final class SqlTimeTypeAdapter extends E {
    public final SimpleDateFormat a;
    public static final F b;

    static {
        SqlTimeTypeAdapter.b = new F() {
            @Override  // com.google.gson.F
            public final E a(n n0, TypeToken typeToken0) {
                return typeToken0.getRawType() == Time.class ? new SqlTimeTypeAdapter(0) : null;
            }
        };
    }

    private SqlTimeTypeAdapter() {
        this.a = new SimpleDateFormat("hh:mm:ss a");
    }

    public SqlTimeTypeAdapter(int v) {
    }

    @Override  // com.google.gson.E
    public final Object b(a a0) {
        Time time0;
        if(a0.Z() == 9) {
            a0.T();
            return null;
        }
        String s = a0.W();
        synchronized(this) {
            TimeZone timeZone0 = this.a.getTimeZone();
            try {
                try {
                    time0 = new Time(this.a.parse(s).getTime());
                }
                catch(ParseException parseException0) {
                    throw new x("Failed parsing \'" + s + "\' as SQL Time; at path " + a0.C(), parseException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
                }
            }
            catch(Throwable throwable0) {
                this.a.setTimeZone(timeZone0);
                throw throwable0;
            }
            this.a.setTimeZone(timeZone0);
            return time0;
        }
    }

    @Override  // com.google.gson.E
    public final void c(b b0, Object object0) {
        String s;
        if(((Time)object0) == null) {
            b0.B();
            return;
        }
        synchronized(this) {
            s = this.a.format(((Time)object0));
        }
        b0.P(s);
    }
}

