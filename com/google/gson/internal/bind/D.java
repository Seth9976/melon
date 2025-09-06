package com.google.gson.internal.bind;

import T7.i;
import W7.a;
import W7.b;
import com.google.gson.E;
import com.google.gson.F;
import com.google.gson.x;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

public final class d extends E {
    public final c a;
    public final ArrayList b;
    public static final F c;

    static {
        d.c = new DefaultDateTypeAdapter.1();
    }

    public d(c c0, int v, int v1) {
        String s1;
        String s;
        ArrayList arrayList0 = new ArrayList();
        this.b = arrayList0;
        Objects.requireNonNull(c0);
        this.a = c0;
        Locale locale0 = Locale.US;
        arrayList0.add(DateFormat.getDateTimeInstance(v, v1, locale0));
        if(!Locale.getDefault().equals(locale0)) {
            arrayList0.add(DateFormat.getDateTimeInstance(v, v1));
        }
        if(i.a >= 9) {
            StringBuilder stringBuilder0 = new StringBuilder();
            switch(v) {
                case 0: {
                    s = "EEEE, MMMM d, yyyy";
                    break;
                }
                case 1: {
                    s = "MMMM d, yyyy";
                    break;
                }
                case 2: {
                    s = "MMM d, yyyy";
                    break;
                }
                case 3: {
                    s = "M/d/yy";
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unknown DateFormat style: " + v);
                }
            }
            stringBuilder0.append(s);
            stringBuilder0.append(" ");
            switch(v1) {
                case 0: 
                case 1: {
                    s1 = "h:mm:ss a z";
                    break;
                }
                case 2: {
                    s1 = "h:mm:ss a";
                    break;
                }
                case 3: {
                    s1 = "h:mm a";
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unknown DateFormat style: " + v1);
                }
            }
            stringBuilder0.append(s1);
            arrayList0.add(new SimpleDateFormat(stringBuilder0.toString(), locale0));
        }
    }

    @Override  // com.google.gson.E
    public final Object b(a a0) {
        Date date0;
        if(a0.Z() == 9) {
            a0.T();
            return null;
        }
        String s = a0.W();
        synchronized(this.b) {
            for(Object object0: this.b) {
                DateFormat dateFormat0 = (DateFormat)object0;
                TimeZone timeZone0 = dateFormat0.getTimeZone();
                try {
                    date0 = dateFormat0.parse(s);
                }
                catch(ParseException unused_ex) {
                    dateFormat0.setTimeZone(timeZone0);
                    continue;
                }
                finally {
                    dateFormat0.setTimeZone(timeZone0);
                }
                return this.a.b(date0);
            }
        }
        try {
            date0 = U7.a.b(s, new ParsePosition(0));
            return this.a.b(date0);
        }
        catch(ParseException parseException0) {
            StringBuilder stringBuilder0 = com.iloen.melon.utils.a.n("Failed parsing \'", s, "\' as Date; at path ");
            stringBuilder0.append(a0.C());
            throw new x(stringBuilder0.toString(), parseException0);  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
        }
    }

    @Override  // com.google.gson.E
    public final void c(b b0, Object object0) {
        String s;
        if(((Date)object0) == null) {
            b0.B();
            return;
        }
        DateFormat dateFormat0 = (DateFormat)this.b.get(0);
        synchronized(this.b) {
            s = dateFormat0.format(((Date)object0));
        }
        b0.P(s);
    }

    @Override
    public final String toString() {
        DateFormat dateFormat0 = (DateFormat)this.b.get(0);
        return dateFormat0 instanceof SimpleDateFormat ? "DefaultDateTypeAdapter(" + ((SimpleDateFormat)dateFormat0).toPattern() + ')' : "DefaultDateTypeAdapter(" + dateFormat0.getClass().getSimpleName() + ')';
    }
}

