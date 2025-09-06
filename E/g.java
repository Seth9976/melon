package e;

import java.util.ArrayList;

public final class g extends b {
    public final int a;
    public final h b;
    public final String c;
    public final f.b d;

    public g(h h0, String s, f.b b0, int v) {
        this.a = v;
        this.b = h0;
        this.c = s;
        this.d = b0;
        super();
    }

    @Override  // e.b
    public final f.b a() {
        return this.d;
    }

    @Override  // e.b
    public final void b(Object object0) {
        if(this.a != 0) {
            h h0 = this.b;
            ArrayList arrayList0 = h0.d;
            String s = this.c;
            Object object1 = h0.b.get(s);
            f.b b0 = this.d;
            if(object1 != null) {
                int v = ((Number)object1).intValue();
                arrayList0.add(s);
                try {
                    h0.b(v, b0, object0);
                    return;
                }
                catch(Exception exception0) {
                    arrayList0.remove(s);
                    throw exception0;
                }
            }
            throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + b0 + " and input " + object0 + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
        }
        h h1 = this.b;
        ArrayList arrayList1 = h1.d;
        String s1 = this.c;
        Object object2 = h1.b.get(s1);
        f.b b1 = this.d;
        if(object2 != null) {
            int v1 = ((Number)object2).intValue();
            arrayList1.add(s1);
            try {
                h1.b(v1, b1, object0);
                return;
            }
            catch(Exception exception1) {
                arrayList1.remove(s1);
                throw exception1;
            }
        }
        throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + b1 + " and input " + object0 + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
    }

    @Override  // e.b
    public final void c() {
        if(this.a != 0) {
            this.b.f(this.c);
            return;
        }
        this.b.f(this.c);
    }
}

