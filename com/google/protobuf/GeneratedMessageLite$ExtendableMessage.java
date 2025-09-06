package com.google.protobuf;

import java.io.IOException;
import java.util.List;

public abstract class GeneratedMessageLite.ExtendableMessage extends A1 implements m2 {
    protected o1 extensions;

    public GeneratedMessageLite.ExtendableMessage() {
        this.extensions = o1.c;
    }

    private void eagerlyMergeMessageSetExtension(t t0, y1 y10, g1 g10, int v) {
        this.parseExtension(t0, g10, y10, v << 3 | 2, v);
    }

    public o1 ensureExtensionsAreMutable() {
        o1 o10 = this.extensions;
        if(o10.b) {
            this.extensions = o10.b();
        }
        return this.extensions;
    }

    public boolean extensionsAreInitialized() {
        return this.extensions.i();
    }

    public int extensionsSerializedSize() {
        return this.extensions.h();
    }

    public int extensionsSerializedSizeAsMessageSet() {
        return this.extensions.f();
    }

    @Override  // com.google.protobuf.A1, com.google.protobuf.m2
    public l2 getDefaultInstanceForType() {
        return this.getDefaultInstanceForType();
    }

    public final Object getExtension(d1 d10) {
        y1 y10 = A1.access$100(d10);
        this.verifyExtensionContainingType(y10);
        Object object0 = this.extensions.a.get(y10.d);
        if(object0 == null) {
            return y10.b;
        }
        x1 x10 = y10.d;
        if(x10.c) {
            if(x10.b.a == k3.i) {
                C2 c20 = new C2(C2.d, 0, true);
                c20.d(((List)object0).size());
                for(Object object1: ((List)object0)) {
                    c20.add(y10.a(object1));
                }
                if(c20.a) {
                    c20.a = false;
                }
                return c20;
            }
            return object0;
        }
        return y10.a(object0);
    }

    public final Object getExtension(d1 d10, int v) {
        y1 y10 = A1.access$100(d10);
        this.verifyExtensionContainingType(y10);
        o1 o10 = this.extensions;
        x1 x10 = y10.d;
        o10.getClass();
        if(!x10.c) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object object0 = o10.a.get(x10);
        if(object0 == null) {
            throw new IndexOutOfBoundsException();
        }
        return y10.a(((List)object0).get(v));
    }

    public final int getExtensionCount(d1 d10) {
        y1 y10 = A1.access$100(d10);
        this.verifyExtensionContainingType(y10);
        o1 o10 = this.extensions;
        x1 x10 = y10.d;
        o10.getClass();
        if(!x10.c) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object object0 = o10.a.get(x10);
        return object0 == null ? 0 : ((List)object0).size();
    }

    public final boolean hasExtension(d1 d10) {
        y1 y10 = A1.access$100(d10);
        this.verifyExtensionContainingType(y10);
        o1 o10 = this.extensions;
        x1 x10 = y10.d;
        o10.getClass();
        if(x10.c) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return o10.a.get(x10) != null;
    }

    public final void mergeExtensionFields(GeneratedMessageLite.ExtendableMessage generatedMessageLite$ExtendableMessage0) {
        o1 o10 = this.extensions;
        if(o10.b) {
            this.extensions = o10.b();
        }
        this.extensions.m(generatedMessageLite$ExtendableMessage0.extensions);
    }

    private void mergeMessageSetExtensionFromBytes(o o0, g1 g10, y1 y10) {
        l2 l20 = (l2)this.extensions.a.get(y10.d);
        k2 k20 = l20 == null ? null : l20.toBuilder();
        if(k20 == null) {
            k20 = y10.c.newBuilderForType();
        }
        t1 t10 = (t1)k20;
        t10.getClass();
        try {
            t t0 = o0.i();
            t10.g(t0, g10);
            t0.a(0);
        }
        catch(R1 r10) {
            throw r10;
        }
        catch(IOException iOException0) {
            throw new RuntimeException("Reading " + t10.getClass().getName() + " from a ByteString threw an IOException (should never happen).", iOException0);
        }
        A1 a10 = t10.a();
        o1 o10 = this.ensureExtensionsAreMutable();
        Object object0 = y10.b(a10);
        o10.o(y10.d, object0);
    }

    private void mergeMessageSetExtensionFromCodedStream(l2 l20, t t0, g1 g10) {
        int v = 0;
        n n0 = null;
        y1 y10 = null;
    alab1:
        while(true) {
            int v1 = t0.E();
            switch(v1) {
                case 0: {
                    break alab1;
                }
                case 16: {
                    v = t0.F();
                    if(v == 0) {
                        break;
                    }
                    y10 = g10.a(v, l20);
                    break;
                }
                case 26: {
                    if(v == 0 || y10 == null) {
                        n0 = t0.m();
                    }
                    else {
                        this.eagerlyMergeMessageSetExtension(t0, y10, g10, v);
                        n0 = null;
                    }
                    break;
                }
                default: {
                    if(t0.H(v1)) {
                        break;
                    }
                    break alab1;
                }
            }
        }
        t0.a(12);
        if(n0 != null && v != 0) {
            if(y10 != null) {
                this.mergeMessageSetExtensionFromBytes(n0, g10, y10);
                return;
            }
            this.mergeLengthDelimitedField(v, n0);
        }
    }

    @Override  // com.google.protobuf.A1
    public k2 newBuilderForType() {
        return this.newBuilderForType();
    }

    public w1 newExtensionWriter() {
        return new w1(this);
    }

    public w1 newMessageSetExtensionWriter() {
        return new w1(this);
    }

    private boolean parseExtension(t t0, g1 g10, y1 y10, int v, int v1) {
        A1 a10;
        boolean z1;
        boolean z = false;
        if(y10 == null) {
            z1 = false;
            z = true;
        }
        else {
            x1 x10 = y10.d;
            j3 j30 = x10.b;
            if((v & 7) == j30.b) {
                z1 = false;
            }
            else if(!x10.c || !j30.a() || (v & 7) != 2) {
                z1 = false;
                z = true;
            }
            else {
                z1 = true;
            }
        }
        if(z) {
            return this.parseUnknownField(v, t0);
        }
        this.ensureExtensionsAreMutable();
        k2 k20 = null;
        if(z1) {
            int v2 = t0.k(t0.w());
            x1 x11 = y10.d;
            if(x11.b != j3.g) {
                while(t0.e() > 0) {
                    Object object0 = h.G(t0, x11.b, 1);
                    this.extensions.a(x11, object0);
                }
            }
            else if(t0.e() > 0) {
                t0.o();
                throw null;
            }
            t0.j(v2);
            return true;
        }
        x1 x12 = y10.d;
        switch(x12.b.a.ordinal()) {
            case 7: {
                t0.o();
                throw null;
            }
            case 8: {
                if(!x12.c) {
                    l2 l20 = (l2)this.extensions.a.get(x12);
                    if(l20 != null) {
                        k20 = l20.toBuilder();
                    }
                }
                if(k20 == null) {
                    k20 = y10.c.newBuilderForType();
                }
                if(x12.b == j3.e) {
                    t0.s(x12.a, k20, g10);
                }
                else {
                    t0.v(k20, g10);
                }
                a10 = ((t1)k20).a();
                break;
            }
            default: {
                a10 = h.G(t0, x12.b, 1);
                break;
            }
        }
        if(x12.c) {
            this.extensions.a(x12, y10.b(a10));
            return true;
        }
        this.extensions.o(x12, y10.b(a10));
        return true;
    }

    public boolean parseUnknownField(l2 l20, t t0, g1 g10, int v) {
        return this.parseExtension(t0, g10, g10.a(v >>> 3, l20), v, v >>> 3);
    }

    public boolean parseUnknownFieldAsMessageSet(l2 l20, t t0, g1 g10, int v) {
        if(v == 11) {
            this.mergeMessageSetExtensionFromCodedStream(l20, t0, g10);
            return true;
        }
        return (v & 7) == 2 ? this.parseUnknownField(l20, t0, g10, v) : t0.H(v);
    }

    @Override  // com.google.protobuf.A1
    public k2 toBuilder() {
        return this.toBuilder();
    }

    private void verifyExtensionContainingType(y1 y10) {
        A1 a10 = this.getDefaultInstanceForType();
        if(y10.a != a10) {
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }
    }
}

