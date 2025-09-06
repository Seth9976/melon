package com.google.gson.internal.sql;

import W7.a;
import W7.b;
import com.google.gson.E;
import com.google.gson.F;
import com.google.gson.n;
import com.google.gson.reflect.TypeToken;
import com.google.gson.x;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public final class SqlDateTypeAdapter extends E {
    public final SimpleDateFormat a;
    public static final F b;

    static {
        SqlDateTypeAdapter.b = new F() {
            @Override  // com.google.gson.F
            public final E a(n n0, TypeToken typeToken0) {
                return typeToken0.getRawType() == Date.class ? new SqlDateTypeAdapter(0) : null;
            }
        };
    }

    private SqlDateTypeAdapter() {
        this.a = new SimpleDateFormat("MMM d, yyyy");
    }

    public SqlDateTypeAdapter(int v) {
    }

    @Override  // com.google.gson.E
    public final Object b(a a0) {
        Date date0;
        if(a0.Z() == 9) {
            a0.T();
            return null;
        }
        String s = a0.W();
        synchronized(this) {
            TimeZone timeZone0 = this.a.getTimeZone();
            try {
                try {
                    date0 = new Date(this.a.parse(s).getTime());
                }
                catch(ParseException parseException0) {
                    throw new x("Failed parsing \'" + s + "\' as SQL Date; at path " + a0.C(), parseException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
                }
            }
            catch(Throwable throwable0) {
                this.a.setTimeZone(timeZone0);
                throw throwable0;
            }
            this.a.setTimeZone(timeZone0);
            return date0;
        }
    }

    @Override  // com.google.gson.E
    public final void c(b b0, Object object0) {
        String s;
        if(((Date)object0) == null) {
            b0.B();
            return;
        }
        synchronized(this) {
            s = this.a.format(((Date)object0));
        }
        b0.P(s);
    }
}

