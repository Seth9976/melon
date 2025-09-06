package Me;

import Bf.d;
import Bf.e;
import Hf.x;
import Pe.C;
import kotlin.jvm.internal.q;

public final class o {
    public final g0 a;
    public final int b;

    public o(g0 g00, int v) {
        this.b = v;
        q.g(g00, "delegate");
        super();
        this.a = g00;
    }

    public final boolean a(e e0, n n0, k k0) {
        switch(this.b) {
            case 0: {
                if(k0 == null) {
                    throw new IllegalArgumentException("Argument for @NotNull parameter \'from\' of kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$1.isVisible must not be null");
                }
                if(tf.e.r(n0) && tf.e.f(k0) != () -> switch(this.a) {
                    case 2: {
                        throw new IllegalStateException("This method should not be called");
                    }
                    case 3: {
                        throw new IllegalStateException("This method should not be called");
                    }
                    default: {
                        throw new IllegalStateException("This method should not be called");
                    }
                }) {
                    return p.d(n0, k0);
                }
                if(n0 instanceof j) {
                    ((j)n0).e();
                }
                while(n0 != null) {
                    n0 = n0.e();
                    if(n0 instanceof Me.e && !tf.e.l(n0) || n0 instanceof E) {
                        break;
                    }
                }
                if(n0 != null) {
                    while(k0 != null) {
                        if(n0 != k0) {
                            if(k0 instanceof E) {
                                return n0 instanceof E && ((C)(((E)n0))).e.equals(((C)(((E)k0))).e) && tf.e.d(k0).equals(tf.e.d(n0));
                            }
                            k0 = k0.e();
                            continue;
                        }
                        return true;
                    }
                }
                return false;
            }
            case 1: {
                if(k0 == null) {
                    throw new IllegalArgumentException("Argument for @NotNull parameter \'from\' of kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$2.isVisible must not be null");
                }
                if(p.a.a(e0, n0, k0)) {
                    if(e0 == p.n) {
                        return true;
                    }
                    if(e0 != p.m) {
                        k k1 = tf.e.i(n0, Me.e.class, true);
                        return k1 == null || !(e0 instanceof d) ? false : ((d)e0).a.a().equals(k1.a());
                    }
                }
                return false;
            }
            case 2: {
                if(k0 == null) {
                    throw new IllegalArgumentException("Argument for @NotNull parameter \'from\' of kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$3.isVisible must not be null");
                }
                Class class0 = Me.e.class;
                Me.e e1 = (Me.e)tf.e.i(n0, class0, true);
                Me.e e2 = (Me.e)tf.e.i(k0, class0, false);
                if(e2 != null) {
                    if(e1 != null && tf.e.l(e1)) {
                        Me.e e3 = (Me.e)tf.e.i(e1, class0, true);
                        if(e3 == null || !tf.e.q(e2.g(), e3.a())) {
                            goto label_39;
                        }
                        return true;
                    }
                label_39:
                    n n1 = n0 instanceof c ? tf.e.s(((c)n0)) : n0;
                    Me.e e4 = (Me.e)tf.e.i(n1, class0, true);
                    if(e4 != null) {
                        if(tf.e.q(e2.g(), e4.a()) && e0 != p.o) {
                            if(!(n1 instanceof c) || n1 instanceof j || e0 == p.n) {
                                return true;
                            }
                            if(e0 != p.m && e0 != null) {
                                x x0 = e0.getType();
                                if(!tf.e.q(x0, e2)) {
                                    x0.I();
                                    return this.a(e0, n0, e2.e());
                                }
                                return true;
                            }
                        }
                        return this.a(e0, n0, e2.e());
                    }
                }
                return false;
            }
            case 3: {
                if(k0 == null) {
                    throw new IllegalArgumentException("Argument for @NotNull parameter \'from\' of kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$4.isVisible must not be null");
                }
                z z0 = tf.e.d(n0);
                if(!tf.e.d(k0).N(z0)) {
                    return false;
                }
                p.p.getClass();
                return true;
            }
            case 4: {
                if(k0 == null) {
                    throw new IllegalArgumentException("Argument for @NotNull parameter \'from\' of kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$5.isVisible must not be null");
                }
                return true;
            }
            case 5: {
                if(k0 != null) {
                    throw new IllegalStateException("This method shouldn\'t be invoked for LOCAL visibility");
                }
                throw new IllegalArgumentException("Argument for @NotNull parameter \'from\' of kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$6.isVisible must not be null");
            }
            case 6: {
                if(k0 != null) {
                    throw new IllegalStateException("Visibility is unknown yet");
                }
                throw new IllegalArgumentException("Argument for @NotNull parameter \'from\' of kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$7.isVisible must not be null");
            }
            case 7: {
                if(k0 == null) {
                    throw new IllegalArgumentException("Argument for @NotNull parameter \'from\' of kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$8.isVisible must not be null");
                }
                return false;
            }
            case 8: {
                if(k0 == null) {
                    throw new IllegalArgumentException("Argument for @NotNull parameter \'from\' of kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$9.isVisible must not be null");
                }
                return false;
            }
            case 9: {
                if(k0 == null) {
                    throw new IllegalArgumentException("Argument for @NotNull parameter \'from\' of kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$1.isVisible must not be null");
                }
                return Ze.o.c(n0, k0);
            }
            case 10: {
                if(k0 == null) {
                    throw new IllegalArgumentException("Argument for @NotNull parameter \'from\' of kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$2.isVisible must not be null");
                }
                return Ze.o.b(e0, n0, k0);
            }
            default: {
                if(k0 == null) {
                    throw new IllegalArgumentException("Argument for @NotNull parameter \'from\' of kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$3.isVisible must not be null");
                }
                return Ze.o.b(e0, n0, k0);
            }
        }
    }

    @Override
    public final String toString() {
        return this.a.b();
    }
}

