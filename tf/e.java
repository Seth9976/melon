package tf;

import Hf.M;
import Hf.x;
import Me.E;
import Me.I;
import Me.O;
import Me.b;
import Me.f;
import Me.h;
import Me.k;
import Me.l;
import Me.n;
import Me.p;
import Me.y;
import Me.z;
import Pe.C;
import Pe.K;
import Pe.w;
import java.util.Collection;
import java.util.LinkedHashSet;
import qf.c;
import qf.d;
import qf.g;

public abstract class e {
    public static final int a;

    static {
        new c("kotlin.jvm.JvmName");
    }

    public static void a(int v) {
        IllegalArgumentException illegalArgumentException0;
        int v1;
        String s;
        switch(v) {
            case 4: 
            case 7: 
            case 9: 
            case 10: 
            case 12: 
            case 22: 
            case 40: 
            case 42: 
            case 43: 
            case 0x2F: 
            case 49: 
            case 50: 
            case 51: 
            case 52: 
            case 53: 
            case 59: 
            case 61: 
            case 62: 
            case 0x40: 
            case 71: 
            case 75: 
            case 82: 
            case 83: 
            case 85: 
            case 88: 
            case 93: 
            case 0x5F: {
                s = "@NotNull method %s.%s must not return null";
                break;
            }
            default: {
                s = "Argument for @NotNull parameter \'%s\' of %s.%s must not be null";
            }
        }
        switch(v) {
            case 4: 
            case 7: 
            case 9: 
            case 10: 
            case 12: 
            case 22: 
            case 40: 
            case 42: 
            case 43: 
            case 0x2F: 
            case 49: 
            case 50: 
            case 51: 
            case 52: 
            case 53: 
            case 59: 
            case 61: 
            case 62: 
            case 0x40: 
            case 71: 
            case 75: 
            case 82: 
            case 83: 
            case 85: 
            case 88: 
            case 93: 
            case 0x5F: {
                v1 = 2;
                break;
            }
            default: {
                v1 = 3;
            }
        }
        Object[] arr_object = new Object[v1];
        switch(v) {
            case 16: {
                arr_object[0] = "first";
                break;
            }
            case 17: {
                arr_object[0] = "second";
                break;
            }
            case 18: 
            case 19: {
                arr_object[0] = "aClass";
                break;
            }
            case 20: {
                arr_object[0] = "kotlinType";
                break;
            }
            case 25: {
                arr_object[0] = "declarationDescriptor";
                break;
            }
            case 26: 
            case 28: {
                arr_object[0] = "subClass";
                break;
            }
            case 0x1F: {
                arr_object[0] = "other";
                break;
            }
            case 27: 
            case 29: 
            case 33: {
                arr_object[0] = "superClass";
                break;
            }
            case 37: {
                arr_object[0] = "classKind";
                break;
            }
            case 46: {
                arr_object[0] = "typeConstructor";
                break;
            }
            case 55: {
                arr_object[0] = "innerClassName";
                break;
            }
            case 56: {
                arr_object[0] = "location";
                break;
            }
            case 65: {
                arr_object[0] = "variable";
                break;
            }
            case 30: 
            case 0x20: 
            case 45: 
            case 66: {
                arr_object[0] = "type";
                break;
            }
            case 70: {
                arr_object[0] = "f";
                break;
            }
            case 72: {
                arr_object[0] = "current";
                break;
            }
            case 73: {
                arr_object[0] = "result";
                break;
            }
            case 74: {
                arr_object[0] = "memberDescriptor";
                break;
            }
            case 38: 
            case 39: 
            case 41: 
            case 44: 
            case 0x30: 
            case 54: 
            case 67: 
            case 68: 
            case 69: 
            case 76: 
            case 77: {
                arr_object[0] = "classDescriptor";
                break;
            }
            case 78: 
            case 0x4F: 
            case 80: {
                arr_object[0] = "annotated";
                break;
            }
            case 84: 
            case 86: 
            case 89: 
            case 91: {
                arr_object[0] = "scope";
                break;
            }
            case 87: 
            case 90: 
            case 92: {
                arr_object[0] = "name";
                break;
            }
            case 1: 
            case 2: 
            case 3: 
            case 5: 
            case 6: 
            case 8: 
            case 11: 
            case 13: 
            case 14: 
            case 15: 
            case 21: 
            case 23: 
            case 24: 
            case 34: 
            case 35: 
            case 36: 
            case 57: 
            case 58: 
            case 60: 
            case 0x3F: 
            case 81: 
            case 94: {
                arr_object[0] = "descriptor";
                break;
            }
            case 4: 
            case 7: 
            case 9: 
            case 10: 
            case 12: 
            case 22: 
            case 40: 
            case 42: 
            case 43: 
            case 0x2F: 
            case 49: 
            case 50: 
            case 51: 
            case 52: 
            case 53: 
            case 59: 
            case 61: 
            case 62: 
            case 0x40: 
            case 71: 
            case 75: 
            case 82: 
            case 83: 
            case 85: 
            case 88: 
            case 93: 
            case 0x5F: {
                arr_object[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
            }
            default: {
                arr_object[0] = "containingDeclaration";
            }
        }
        switch(v) {
            case 4: {
                arr_object[1] = "getFqNameSafe";
                break;
            }
            case 7: {
                arr_object[1] = "getFqNameUnsafe";
                break;
            }
            case 9: 
            case 10: {
                arr_object[1] = "getFqNameFromTopLevelClass";
                break;
            }
            case 12: {
                arr_object[1] = "getClassIdForNonLocalClass";
                break;
            }
            case 22: {
                arr_object[1] = "getContainingModule";
                break;
            }
            case 40: {
                arr_object[1] = "getSuperclassDescriptors";
                break;
            }
            case 42: 
            case 43: {
                arr_object[1] = "getSuperClassType";
                break;
            }
            case 0x2F: {
                arr_object[1] = "getClassDescriptorForTypeConstructor";
                break;
            }
            case 49: 
            case 50: 
            case 51: 
            case 52: 
            case 53: {
                arr_object[1] = "getDefaultConstructorVisibility";
                break;
            }
            case 59: {
                arr_object[1] = "unwrapFakeOverride";
                break;
            }
            case 61: 
            case 62: {
                arr_object[1] = "unwrapSubstitutionOverride";
                break;
            }
            case 0x40: {
                arr_object[1] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            }
            case 71: {
                arr_object[1] = "getAllOverriddenDescriptors";
                break;
            }
            case 75: {
                arr_object[1] = "getAllOverriddenDeclarations";
                break;
            }
            case 82: 
            case 83: {
                arr_object[1] = "getContainingSourceFile";
                break;
            }
            case 85: {
                arr_object[1] = "getAllDescriptors";
                break;
            }
            case 88: {
                arr_object[1] = "getFunctionByName";
                break;
            }
            case 93: {
                arr_object[1] = "getPropertyByName";
                break;
            }
            case 0x5F: {
                arr_object[1] = "getDirectMember";
                break;
            }
            default: {
                arr_object[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
            }
        }
        switch(v) {
            case 1: {
                arr_object[2] = "isLocal";
                break;
            }
            case 2: {
                arr_object[2] = "getFqName";
                break;
            }
            case 3: {
                arr_object[2] = "getFqNameSafe";
                break;
            }
            case 5: {
                arr_object[2] = "getFqNameSafeIfPossible";
                break;
            }
            case 6: {
                arr_object[2] = "getFqNameUnsafe";
                break;
            }
            case 8: {
                arr_object[2] = "getFqNameFromTopLevelClass";
                break;
            }
            case 11: {
                arr_object[2] = "getClassIdForNonLocalClass";
                break;
            }
            case 13: {
                arr_object[2] = "isExtension";
                break;
            }
            case 14: {
                arr_object[2] = "isOverride";
                break;
            }
            case 15: {
                arr_object[2] = "isStaticDeclaration";
                break;
            }
            case 16: 
            case 17: {
                arr_object[2] = "areInSameModule";
                break;
            }
            case 18: 
            case 19: {
                arr_object[2] = "getParentOfType";
                break;
            }
            case 21: {
                arr_object[2] = "getContainingModule";
                break;
            }
            case 20: 
            case 23: {
                arr_object[2] = "getContainingModuleOrNull";
                break;
            }
            case 24: {
                arr_object[2] = "getContainingClass";
                break;
            }
            case 25: {
                arr_object[2] = "isAncestor";
                break;
            }
            case 26: 
            case 27: {
                arr_object[2] = "isDirectSubclass";
                break;
            }
            case 28: 
            case 29: {
                arr_object[2] = "isSubclass";
                break;
            }
            case 30: 
            case 0x1F: {
                arr_object[2] = "isSameClass";
                break;
            }
            case 0x20: 
            case 33: {
                arr_object[2] = "isSubtypeOfClass";
                break;
            }
            case 34: {
                arr_object[2] = "isAnonymousObject";
                break;
            }
            case 35: {
                arr_object[2] = "isAnonymousFunction";
                break;
            }
            case 36: {
                arr_object[2] = "isEnumEntry";
                break;
            }
            case 37: {
                arr_object[2] = "isKindOf";
                break;
            }
            case 38: {
                arr_object[2] = "hasAbstractMembers";
                break;
            }
            case 39: {
                arr_object[2] = "getSuperclassDescriptors";
                break;
            }
            case 41: {
                arr_object[2] = "getSuperClassType";
                break;
            }
            case 44: {
                arr_object[2] = "getSuperClassDescriptor";
                break;
            }
            case 45: {
                arr_object[2] = "getClassDescriptorForType";
                break;
            }
            case 46: {
                arr_object[2] = "getClassDescriptorForTypeConstructor";
                break;
            }
            case 0x30: {
                arr_object[2] = "getDefaultConstructorVisibility";
                break;
            }
            case 54: 
            case 55: 
            case 56: {
                arr_object[2] = "getInnerClassByName";
                break;
            }
            case 57: {
                arr_object[2] = "isStaticNestedClass";
                break;
            }
            case 58: {
                arr_object[2] = "unwrapFakeOverride";
                break;
            }
            case 60: {
                arr_object[2] = "unwrapSubstitutionOverride";
                break;
            }
            case 0x3F: {
                arr_object[2] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            }
            case 65: 
            case 66: {
                arr_object[2] = "shouldRecordInitializerForProperty";
                break;
            }
            case 67: {
                arr_object[2] = "classCanHaveAbstractFakeOverride";
                break;
            }
            case 68: {
                arr_object[2] = "classCanHaveAbstractDeclaration";
                break;
            }
            case 69: {
                arr_object[2] = "classCanHaveOpenMembers";
                break;
            }
            case 70: {
                arr_object[2] = "getAllOverriddenDescriptors";
                break;
            }
            case 72: 
            case 73: {
                arr_object[2] = "collectAllOverriddenDescriptors";
                break;
            }
            case 74: {
                arr_object[2] = "getAllOverriddenDeclarations";
                break;
            }
            case 76: {
                arr_object[2] = "isSingletonOrAnonymousObject";
                break;
            }
            case 77: {
                arr_object[2] = "canHaveDeclaredConstructors";
                break;
            }
            case 78: {
                arr_object[2] = "getJvmName";
                break;
            }
            case 0x4F: {
                arr_object[2] = "findJvmNameAnnotation";
                break;
            }
            case 80: {
                arr_object[2] = "hasJvmNameAnnotation";
                break;
            }
            case 81: {
                arr_object[2] = "getContainingSourceFile";
                break;
            }
            case 84: {
                arr_object[2] = "getAllDescriptors";
                break;
            }
            case 86: 
            case 87: {
                arr_object[2] = "getFunctionByName";
                break;
            }
            case 89: 
            case 90: {
                arr_object[2] = "getFunctionByNameOrNull";
                break;
            }
            case 91: 
            case 92: {
                arr_object[2] = "getPropertyByName";
                break;
            }
            case 94: {
                arr_object[2] = "getDirectMember";
                break;
            }
            case 4: 
            case 7: 
            case 9: 
            case 10: 
            case 12: 
            case 22: 
            case 40: 
            case 42: 
            case 43: 
            case 0x2F: 
            case 49: 
            case 50: 
            case 51: 
            case 52: 
            case 53: 
            case 59: 
            case 61: 
            case 62: 
            case 0x40: 
            case 71: 
            case 75: 
            case 82: 
            case 83: 
            case 85: 
            case 88: 
            case 93: 
            case 0x5F: {
                break;
            }
            default: {
                arr_object[2] = "getDispatchReceiverParameterIfNeeded";
            }
        }
        String s1 = String.format(s, arr_object);
        switch(v) {
            case 4: 
            case 7: 
            case 9: 
            case 10: 
            case 12: 
            case 22: 
            case 40: 
            case 42: 
            case 43: 
            case 0x2F: 
            case 49: 
            case 50: 
            case 51: 
            case 52: 
            case 53: 
            case 59: 
            case 61: 
            case 62: 
            case 0x40: 
            case 71: 
            case 75: 
            case 82: 
            case 83: 
            case 85: 
            case 88: 
            case 93: 
            case 0x5F: {
                illegalArgumentException0 = new IllegalStateException(s1);
                break;
            }
            default: {
                illegalArgumentException0 = new IllegalArgumentException(s1);
            }
        }
        throw illegalArgumentException0;
    }

    public static void b(b b0, LinkedHashSet linkedHashSet0) {
        if(b0 != null) {
            if(!linkedHashSet0.contains(b0)) {
                for(Object object0: b0.a().f()) {
                    b b1 = ((b)object0).a();
                    e.b(b1, linkedHashSet0);
                    linkedHashSet0.add(b1);
                }
            }
            return;
        }
        e.a(72);
        throw null;
    }

    public static Me.e c(x x0) {
        if(x0 != null) {
            M m0 = x0.w();
            if(m0 != null) {
                Me.e e0 = (Me.e)m0.e();
                if(e0 != null) {
                    return e0;
                }
                e.a(0x2F);
                throw null;
            }
            e.a(46);
            throw null;
        }
        e.a(45);
        throw null;
    }

    public static z d(k k0) {
        if(k0 != null) {
            z z0 = e.e(k0);
            if(z0 != null) {
                return z0;
            }
            e.a(22);
            throw null;
        }
        e.a(21);
        throw null;
    }

    public static z e(k k0) {
        if(k0 != null) {
            while(k0 != null) {
                if(k0 instanceof z) {
                    return (z)k0;
                }
                if(k0 instanceof I) {
                    return ((w)(((I)k0))).c;
                }
                k0 = k0.e();
            }
            return null;
        }
        e.a(23);
        throw null;
    }

    public static O f(k k0) {
        O o0 = () -> switch(this.a) {
            case 2: {
                throw new IllegalStateException("This method should not be called");
            }
            case 3: {
                throw new IllegalStateException("This method should not be called");
            }
            default: {
                throw new IllegalStateException("This method should not be called");
            }
        };
        if(k0 != null) {
            if(k0 instanceof K) {
                k0 = ((K)k0).t1();
            }
            if(k0 instanceof l) {
                ((l)k0).getSource().getClass();
            }
            return o0;
        }
        e.a(81);
        throw null;
    }

    public static d g(k k0) {
        if(k0 != null) {
            c c0 = e.h(k0);
            return c0 == null ? e.g(k0.e()).a(k0.getName()) : c0.a;
        }
        e.a(2);
        throw null;
    }

    public static c h(k k0) {
        if(k0 != null) {
            if(!(k0 instanceof z) && !Jf.l.f(k0)) {
                if(k0 instanceof I) {
                    return ((w)(((I)k0))).d;
                }
                return k0 instanceof E ? ((C)(((E)k0))).e : null;
            }
            return c.c;
        }
        e.a(5);
        throw null;
    }

    public static k i(k k0, Class class0, boolean z) {
        if(k0 != null) {
            if(z) {
                k0 = k0.e();
            }
            while(k0 != null) {
                if(class0.isInstance(k0)) {
                    return k0;
                }
                k0 = k0.e();
            }
        }
        return null;
    }

    public static Me.e j(Me.e e0) {
        if(e0 != null) {
            for(Object object0: e0.q().f()) {
                Me.e e1 = e.c(((x)object0));
                if(e1.getKind() != f.b) {
                    return e1;
                }
                if(false) {
                    break;
                }
            }
            return null;
        }
        e.a(44);
        throw null;
    }

    // 去混淆评级： 低(20)
    public static boolean k(k k0) {
        return e.m(k0, f.a) && k0.getName().equals(g.a);
    }

    // 去混淆评级： 低(20)
    public static boolean l(k k0) {
        return e.m(k0, f.f) && ((Me.e)k0).g0();
    }

    public static boolean m(k k0, f f0) {
        return k0 instanceof Me.e && ((Me.e)k0).getKind() == f0;
    }

    public static boolean n(k k0) {
        if(k0 != null) {
            while(k0 != null) {
                if(!e.k(k0) && (!(k0 instanceof n) || ((n)k0).getVisibility() != p.f)) {
                    k0 = k0.e();
                    continue;
                }
                return true;
            }
            return false;
        }
        e.a(1);
        throw null;
    }

    public static boolean o(x x0, k k0) {
        if(x0 != null) {
            if(k0 != null) {
                h h0 = x0.w().e();
                if(h0 != null) {
                    k k1 = h0.a();
                    return k1 instanceof h && k0 instanceof h && ((h)k0).q().equals(((h)k1).q());
                }
                return false;
            }
            e.a(0x1F);
            throw null;
        }
        e.a(30);
        throw null;
    }

    // 去混淆评级： 低(20)
    public static boolean p(k k0) {
        return (e.m(k0, f.a) || e.m(k0, f.b)) && ((Me.e)k0).i() == y.c;
    }

    public static boolean q(x x0, k k0) {
        if(x0 != null) {
            if(k0 != null) {
                if(!e.o(x0, k0)) {
                    for(Object object0: x0.w().f()) {
                        if(!e.q(((x)object0), k0)) {
                            continue;
                        }
                        return true;
                    }
                    return false;
                }
                return true;
            }
            e.a(33);
            throw null;
        }
        e.a(0x20);
        throw null;
    }

    public static boolean r(k k0) {
        return k0 != null && k0.e() instanceof E;
    }

    public static Me.c s(Me.c c0) {
        if(c0 != null) {
            while(c0.getKind() == 2) {
                Collection collection0 = c0.f();
                if(collection0.isEmpty()) {
                    throw new IllegalStateException("Fake override should have at least one overridden descriptor: " + c0);
                }
                Object object0 = collection0.iterator().next();
                c0 = (Me.c)object0;
            }
            return c0;
        }
        e.a(58);
        throw null;
    }
}

