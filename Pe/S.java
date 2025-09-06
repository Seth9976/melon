package Pe;

import Hf.T;
import Hf.x;
import Me.k;
import Me.o;
import Me.t;
import Me.u;
import Me.y;
import Ne.h;
import bf.f;
import java.util.LinkedHashMap;
import java.util.List;
import je.w;
import qf.e;

public final class s implements t {
    public w B;
    public h D;
    public boolean E;
    public final LinkedHashMap G;
    public Boolean I;
    public boolean M;
    public final Pe.t N;
    public T a;
    public k b;
    public y c;
    public o d;
    public u e;
    public int f;
    public List g;
    public final List h;
    public Pe.u i;
    public Pe.u j;
    public x k;
    public e l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean r;
    public boolean w;

    public s(Pe.t t0, T t1, k k0, y y0, o o0, int v, List list0, List list1, Pe.u u0, x x0) {
        if(t1 != null) {
            if(k0 != null) {
                if(y0 != null) {
                    if(o0 != null) {
                        if(v != 0) {
                            if(list0 != null) {
                                if(list1 != null) {
                                    if(x0 != null) {
                                        super();
                                        this.N = t0;
                                        this.e = null;
                                        this.j = t0.j;
                                        this.m = true;
                                        this.n = false;
                                        this.o = false;
                                        this.r = false;
                                        this.w = t0.D;
                                        this.B = null;
                                        this.D = null;
                                        this.E = t0.E;
                                        this.G = new LinkedHashMap();
                                        this.I = null;
                                        this.M = false;
                                        this.a = t1;
                                        this.b = k0;
                                        this.c = y0;
                                        this.d = o0;
                                        this.f = v;
                                        this.g = list0;
                                        this.h = list1;
                                        this.i = u0;
                                        this.k = x0;
                                        this.l = null;
                                        return;
                                    }
                                    s.i(7);
                                    throw null;
                                }
                                s.i(6);
                                throw null;
                            }
                            s.i(5);
                            throw null;
                        }
                        s.i(4);
                        throw null;
                    }
                    s.i(3);
                    throw null;
                }
                s.i(2);
                throw null;
            }
            s.i(1);
            throw null;
        }
        s.i(0);
        throw null;
    }

    @Override  // Me.t
    public final t a(List list0) {
        this.g = list0;
        return this;
    }

    @Override  // Me.t
    public final t b(k k0) {
        if(k0 != null) {
            this.b = k0;
            return this;
        }
        s.i(8);
        throw null;
    }

    @Override  // Me.t
    public final u build() {
        return this.N.w1(this);
    }

    @Override  // Me.t
    public final t c(int v) {
        if(v != 0) {
            this.f = v;
            return this;
        }
        s.i(14);
        throw null;
    }

    @Override  // Me.t
    public final t d() {
        this.E = true;
        return this;
    }

    @Override  // Me.t
    public final t e(h h0) {
        if(h0 != null) {
            this.D = h0;
            return this;
        }
        s.i(35);
        throw null;
    }

    @Override  // Me.t
    public final t f() {
        this.m = false;
        return this;
    }

    @Override  // Me.t
    public final t g() {
        this.B = w.a;
        return this;
    }

    @Override  // Me.t
    public final t h() {
        this.w = true;
        return this;
    }

    public static void i(int v) {
        IllegalArgumentException illegalArgumentException0;
        int v1;
        String s;
        switch(v) {
            case 9: 
            case 11: 
            case 13: 
            case 15: 
            case 16: 
            case 18: 
            case 20: 
            case 22: 
            case 24: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: 
            case 0x1F: 
            case 0x20: 
            case 33: 
            case 34: 
            case 36: 
            case 38: 
            case 40: 
            case 41: 
            case 42: {
                s = "@NotNull method %s.%s must not return null";
                break;
            }
            default: {
                s = "Argument for @NotNull parameter \'%s\' of %s.%s must not be null";
            }
        }
        switch(v) {
            case 9: 
            case 11: 
            case 13: 
            case 15: 
            case 16: 
            case 18: 
            case 20: 
            case 22: 
            case 24: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: 
            case 0x1F: 
            case 0x20: 
            case 33: 
            case 34: 
            case 36: 
            case 38: 
            case 40: 
            case 41: 
            case 42: {
                v1 = 2;
                break;
            }
            default: {
                v1 = 3;
            }
        }
        Object[] arr_object = new Object[v1];
        switch(v) {
            case 1: {
                arr_object[0] = "newOwner";
                break;
            }
            case 2: {
                arr_object[0] = "newModality";
                break;
            }
            case 3: {
                arr_object[0] = "newVisibility";
                break;
            }
            case 5: {
                arr_object[0] = "newValueParameterDescriptors";
                break;
            }
            case 6: {
                arr_object[0] = "newContextReceiverParameters";
                break;
            }
            case 7: {
                arr_object[0] = "newReturnType";
                break;
            }
            case 8: {
                arr_object[0] = "owner";
                break;
            }
            case 10: {
                arr_object[0] = "modality";
                break;
            }
            case 12: {
                arr_object[0] = "visibility";
                break;
            }
            case 4: 
            case 14: {
                arr_object[0] = "kind";
                break;
            }
            case 17: {
                arr_object[0] = "name";
                break;
            }
            case 19: 
            case 21: {
                arr_object[0] = "parameters";
                break;
            }
            case 23: {
                arr_object[0] = "type";
                break;
            }
            case 25: {
                arr_object[0] = "contextReceiverParameters";
                break;
            }
            case 35: {
                arr_object[0] = "additionalAnnotations";
                break;
            }
            case 39: {
                arr_object[0] = "userDataKey";
                break;
            }
            case 9: 
            case 11: 
            case 13: 
            case 15: 
            case 16: 
            case 18: 
            case 20: 
            case 22: 
            case 24: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: 
            case 0x1F: 
            case 0x20: 
            case 33: 
            case 34: 
            case 36: 
            case 38: 
            case 40: 
            case 41: 
            case 42: {
                arr_object[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                break;
            }
            default: {
                arr_object[0] = "substitution";
            }
        }
        switch(v) {
            case 9: {
                arr_object[1] = "setOwner";
                break;
            }
            case 11: {
                arr_object[1] = "setModality";
                break;
            }
            case 13: {
                arr_object[1] = "setVisibility";
                break;
            }
            case 15: {
                arr_object[1] = "setKind";
                break;
            }
            case 16: {
                arr_object[1] = "setCopyOverrides";
                break;
            }
            case 18: {
                arr_object[1] = "setName";
                break;
            }
            case 20: {
                arr_object[1] = "setValueParameters";
                break;
            }
            case 22: {
                arr_object[1] = "setTypeParameters";
                break;
            }
            case 24: {
                arr_object[1] = "setReturnType";
                break;
            }
            case 26: {
                arr_object[1] = "setContextReceiverParameters";
                break;
            }
            case 27: {
                arr_object[1] = "setExtensionReceiverParameter";
                break;
            }
            case 28: {
                arr_object[1] = "setDispatchReceiverParameter";
                break;
            }
            case 29: {
                arr_object[1] = "setOriginal";
                break;
            }
            case 30: {
                arr_object[1] = "setSignatureChange";
                break;
            }
            case 0x1F: {
                arr_object[1] = "setPreserveSourceElement";
                break;
            }
            case 0x20: {
                arr_object[1] = "setDropOriginalInContainingParts";
                break;
            }
            case 33: {
                arr_object[1] = "setHiddenToOvercomeSignatureClash";
                break;
            }
            case 34: {
                arr_object[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                break;
            }
            case 36: {
                arr_object[1] = "setAdditionalAnnotations";
                break;
            }
            case 38: {
                arr_object[1] = "setSubstitution";
                break;
            }
            case 40: {
                arr_object[1] = "putUserData";
                break;
            }
            case 41: {
                arr_object[1] = "getSubstitution";
                break;
            }
            case 42: {
                arr_object[1] = "setJustForTypeSubstitution";
                break;
            }
            default: {
                arr_object[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
            }
        }
        switch(v) {
            case 8: {
                arr_object[2] = "setOwner";
                break;
            }
            case 10: {
                arr_object[2] = "setModality";
                break;
            }
            case 12: {
                arr_object[2] = "setVisibility";
                break;
            }
            case 14: {
                arr_object[2] = "setKind";
                break;
            }
            case 17: {
                arr_object[2] = "setName";
                break;
            }
            case 19: {
                arr_object[2] = "setValueParameters";
                break;
            }
            case 21: {
                arr_object[2] = "setTypeParameters";
                break;
            }
            case 23: {
                arr_object[2] = "setReturnType";
                break;
            }
            case 25: {
                arr_object[2] = "setContextReceiverParameters";
                break;
            }
            case 35: {
                arr_object[2] = "setAdditionalAnnotations";
                break;
            }
            case 37: {
                arr_object[2] = "setSubstitution";
                break;
            }
            case 39: {
                arr_object[2] = "putUserData";
                break;
            }
            case 9: 
            case 11: 
            case 13: 
            case 15: 
            case 16: 
            case 18: 
            case 20: 
            case 22: 
            case 24: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: 
            case 0x1F: 
            case 0x20: 
            case 33: 
            case 34: 
            case 36: 
            case 38: 
            case 40: 
            case 41: 
            case 42: {
                break;
            }
            default: {
                arr_object[2] = "<init>";
            }
        }
        String s1 = String.format(s, arr_object);
        switch(v) {
            case 9: 
            case 11: 
            case 13: 
            case 15: 
            case 16: 
            case 18: 
            case 20: 
            case 22: 
            case 24: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: 
            case 0x1F: 
            case 0x20: 
            case 33: 
            case 34: 
            case 36: 
            case 38: 
            case 40: 
            case 41: 
            case 42: {
                illegalArgumentException0 = new IllegalStateException(s1);
                break;
            }
            default: {
                illegalArgumentException0 = new IllegalArgumentException(s1);
            }
        }
        throw illegalArgumentException0;
    }

    @Override  // Me.t
    public final t k(o o0) {
        if(o0 != null) {
            this.d = o0;
            return this;
        }
        s.i(12);
        throw null;
    }

    @Override  // Me.t
    public final t l() {
        this.o = true;
        return this;
    }

    @Override  // Me.t
    public final t m(y y0) {
        if(y0 != null) {
            this.c = y0;
            return this;
        }
        s.i(10);
        throw null;
    }

    @Override  // Me.t
    public final t n(Pe.u u0) {
        this.j = u0;
        return this;
    }

    @Override  // Me.t
    public final t o(e e0) {
        if(e0 != null) {
            this.l = e0;
            return this;
        }
        s.i(17);
        throw null;
    }

    @Override  // Me.t
    public final t p() {
        this.G.put(f.c0, Boolean.TRUE);
        return this;
    }

    @Override  // Me.t
    public final t r(x x0) {
        if(x0 != null) {
            this.k = x0;
            return this;
        }
        s.i(23);
        throw null;
    }

    @Override  // Me.t
    public final t t() {
        this.n = true;
        return this;
    }
}

