package T7;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

public final class j extends Number {
    public final String a;

    public j(String s) {
        this.a = s;
    }

    @Override
    public final double doubleValue() {
        return Double.parseDouble(this.a);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof j ? this.a.equals(((j)object0).a) : false;
    }

    @Override
    public final float floatValue() {
        return Float.parseFloat(this.a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final int intValue() {
        String s;
        try {
            s = this.a;
            return Integer.parseInt(s);
        }
        catch(NumberFormatException unused_ex) {
            try {
                return (int)Long.parseLong(s);
            }
            catch(NumberFormatException unused_ex) {
                return h.j(s).intValue();
            }
        }
    }

    @Override
    public final long longValue() {
        String s;
        try {
            s = this.a;
            return Long.parseLong(s);
        }
        catch(NumberFormatException unused_ex) {
            return h.j(s).longValue();
        }
    }

    private void readObject(ObjectInputStream objectInputStream0) {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    @Override
    public final String toString() {
        return this.a;
    }

    private Object writeReplace() {
        return h.j(this.a);
    }
}

