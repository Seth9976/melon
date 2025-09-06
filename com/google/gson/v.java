package com.google.gson;

import T7.h;
import T7.j;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

public final class v extends q {
    public final Serializable a;

    public v(Boolean boolean0) {
        Objects.requireNonNull(boolean0);
        this.a = boolean0;
    }

    public v(Number number0) {
        Objects.requireNonNull(number0);
        this.a = number0;
    }

    public v(String s) {
        Objects.requireNonNull(s);
        this.a = s;
    }

    @Override  // com.google.gson.q
    public final String b() {
        Serializable serializable0 = this.a;
        if(serializable0 instanceof String) {
            return (String)serializable0;
        }
        if(serializable0 instanceof Number) {
            return this.g().toString();
        }
        if(!(serializable0 instanceof Boolean)) {
            throw new AssertionError("Unexpected value type: " + serializable0.getClass());
        }
        return ((Boolean)serializable0).toString();
    }

    public final BigInteger d() {
        Serializable serializable0 = this.a;
        if(serializable0 instanceof BigInteger) {
            return (BigInteger)serializable0;
        }
        if(v.i(this)) {
            return BigInteger.valueOf(this.g().longValue());
        }
        String s = this.b();
        h.d(s);
        return new BigInteger(s);
    }

    // 去混淆评级： 低(20)
    public final boolean e() {
        return this.a instanceof Boolean ? ((Boolean)this.a).booleanValue() : Boolean.parseBoolean(this.b());
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 != null) {
                Class class0 = object0.getClass();
                if(v.class == class0) {
                    Serializable serializable0 = ((v)object0).a;
                    Serializable serializable1 = this.a;
                    if(serializable1 == null) {
                        return serializable0 == null;
                    }
                    if(v.i(this) && v.i(((v)object0))) {
                        return serializable1 instanceof BigInteger || serializable0 instanceof BigInteger ? this.d().equals(((v)object0).d()) : this.g().longValue() == ((v)object0).g().longValue();
                    }
                    if(serializable1 instanceof Number && serializable0 instanceof Number) {
                        if(serializable1 instanceof BigDecimal && serializable0 instanceof BigDecimal) {
                            return (serializable1 instanceof BigDecimal ? ((BigDecimal)serializable1) : h.j(this.b())).compareTo((serializable0 instanceof BigDecimal ? ((BigDecimal)serializable0) : h.j(((v)object0).b()))) == 0;
                        }
                        double f = this.f();
                        double f1 = ((v)object0).f();
                        return f == f1 || Double.isNaN(f) && Double.isNaN(f1);
                    }
                    return serializable1.equals(serializable0);
                }
            }
            return false;
        }
        return true;
    }

    // 去混淆评级： 低(20)
    public final double f() {
        return this.a instanceof Number ? this.g().doubleValue() : Double.parseDouble(this.b());
    }

    public final Number g() {
        Serializable serializable0 = this.a;
        if(serializable0 instanceof Number) {
            return (Number)serializable0;
        }
        if(!(serializable0 instanceof String)) {
            throw new UnsupportedOperationException("Primitive is neither a number nor a string");
        }
        return new j(((String)serializable0));
    }

    @Override
    public final int hashCode() {
        long v;
        Serializable serializable0 = this.a;
        if(serializable0 == null) {
            return 0x1F;
        }
        if(v.i(this)) {
            v = this.g().longValue();
            return (int)(v ^ v >>> 0x20);
        }
        if(serializable0 instanceof Number) {
            v = Double.doubleToLongBits(this.g().doubleValue());
            return (int)(v ^ v >>> 0x20);
        }
        return serializable0.hashCode();
    }

    // 去混淆评级： 中等(60)
    public static boolean i(v v0) {
        return v0.a instanceof Number && (((Number)v0.a) instanceof BigInteger || ((Number)v0.a) instanceof Long || ((Number)v0.a) instanceof Integer || ((Number)v0.a) instanceof Short || ((Number)v0.a) instanceof Byte);
    }
}

