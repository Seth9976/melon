package w4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;

public final class e {
    public final int a;
    public final int b;
    public final long c;
    public final long d;

    public e(int v, int v1, long v2, long v3) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = v3;
    }

    public static e a(File file0) {
        try(DataInputStream dataInputStream0 = new DataInputStream(new FileInputStream(file0))) {
            return new e(dataInputStream0.readInt(), dataInputStream0.readInt(), dataInputStream0.readLong(), dataInputStream0.readLong());
        }
    }

    public final void b(File file0) {
        file0.delete();
        try(DataOutputStream dataOutputStream0 = new DataOutputStream(new FileOutputStream(file0))) {
            dataOutputStream0.writeInt(this.a);
            dataOutputStream0.writeInt(this.b);
            dataOutputStream0.writeLong(this.c);
            dataOutputStream0.writeLong(this.d);
        }
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 != null && object0 instanceof e && this.b == ((e)object0).b && this.c == ((e)object0).c && this.a == ((e)object0).a && this.d == ((e)object0).d;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(new Object[]{this.b, this.c, this.a, this.d});
    }
}

