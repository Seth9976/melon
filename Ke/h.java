package ke;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map.Entry;
import kotlin.jvm.internal.q;

public final class h implements Externalizable {
    public e a;
    private static final long serialVersionUID;

    @Override
    public final void readExternal(ObjectInput objectInput0) {
        q.g(objectInput0, "input");
        int v = objectInput0.readByte();
        if(v != 0) {
            throw new InvalidObjectException("Unsupported flags value: " + v);
        }
        int v1 = objectInput0.readInt();
        if(v1 < 0) {
            throw new InvalidObjectException("Illegal size value: " + v1 + '.');
        }
        e e0 = new e(v1);
        for(int v2 = 0; v2 < v1; ++v2) {
            e0.put(objectInput0.readObject(), objectInput0.readObject());
        }
        this.a = e0.b();
    }

    private final Object readResolve() {
        return this.a;
    }

    @Override
    public final void writeExternal(ObjectOutput objectOutput0) {
        q.g(objectOutput0, "output");
        objectOutput0.writeByte(0);
        objectOutput0.writeInt(this.a.i);
        for(Object object0: ((f)this.a.entrySet())) {
            objectOutput0.writeObject(((Map.Entry)object0).getKey());
            objectOutput0.writeObject(((Map.Entry)object0).getValue());
        }
    }
}

