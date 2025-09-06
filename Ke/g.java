package ke;

import e.k;
import e1.m;
import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractCollection;
import kotlin.jvm.internal.q;

public final class g implements Externalizable {
    public AbstractCollection a;
    public final int b;
    private static final long serialVersionUID;

    public g(AbstractCollection abstractCollection0, int v) {
        this.a = abstractCollection0;
        this.b = v;
    }

    @Override
    public final void readExternal(ObjectInput objectInput0) {
        b b1;
        q.g(objectInput0, "input");
        int v = objectInput0.readByte();
        if((v & -2) != 0) {
            throw new InvalidObjectException("Unsupported flags value: " + v + '.');
        }
        int v1 = 0;
        int v2 = objectInput0.readInt();
        if(v2 < 0) {
            throw new InvalidObjectException("Illegal size value: " + v2 + '.');
        }
        switch(v & 1) {
            case 0: {
                b b0 = new b(v2);
                while(v1 < v2) {
                    b0.add(objectInput0.readObject());
                    ++v1;
                }
                b1 = k.h(b0);
                break;
            }
            case 1: {
                i i0 = new i(new e(v2));
                while(v1 < v2) {
                    i0.add(objectInput0.readObject());
                    ++v1;
                }
                b1 = m.k(i0);
                break;
            }
            default: {
                throw new InvalidObjectException("Unsupported collection type tag: " + (v & 1) + '.');
            }
        }
        this.a = b1;
    }

    private final Object readResolve() {
        return this.a;
    }

    @Override
    public final void writeExternal(ObjectOutput objectOutput0) {
        q.g(objectOutput0, "output");
        objectOutput0.writeByte(this.b);
        objectOutput0.writeInt(this.a.size());
        for(Object object0: this.a) {
            objectOutput0.writeObject(object0);
        }
    }
}

