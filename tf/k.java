package tf;

import Ac.G;
import Hf.L;
import Hf.a0;
import Hf.d;
import Hf.x;
import If.c;
import If.g;
import Me.b;
import Me.e;
import Me.o;
import Me.y;
import Pe.I;
import Pe.K;
import Pe.S;
import Pe.t;
import Pe.u;
import Qf.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.ServiceLoader;
import je.p;
import kotlin.jvm.internal.q;

public final class k {
    public final c a;
    public static final List b;
    public static final k c;
    public static final tf.c d;

    static {
        k.b = p.P0(ServiceLoader.load(f.class, f.class.getClassLoader()));
        tf.c c0 = new tf.c();  // 初始化器: Ljava/lang/Object;-><init>()V
        k.d = c0;
        k.c = new k(c0);
    }

    public k(c c0) {
        if(c0 != null) {
            super();
            this.a = c0;
            return;
        }
        k.a(5);
        throw null;
    }

    public static void a(int v) {
        IllegalStateException illegalStateException0;
        int v1;
        String s;
        switch(v) {
            case 11: 
            case 12: 
            case 16: 
            case 21: 
            case 42: 
            case 43: 
            case 93: 
            case 0x60: 
            case 101: {
                s = "@NotNull method %s.%s must not return null";
                break;
            }
            default: {
                if(v == 24 || v == 25 || v == 26 || v == 27) {
                    s = "@NotNull method %s.%s must not return null";
                    break;
                }
                else {
                    switch(v) {
                        case 30: 
                        case 0x1F: 
                        case 0x20: 
                        case 33: 
                        case 34: 
                        case 35: 
                        case 36: 
                        case 37: {
                            s = "@NotNull method %s.%s must not return null";
                            break;
                        }
                        default: {
                            s = v == 78 || v == 0x4F || v == 80 || v == 81 || v == 82 || (v == 88 || v == 89 || v == 90) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter \'%s\' of %s.%s must not be null";
                        }
                    }
                }
            }
        }
        switch(v) {
            case 11: 
            case 12: 
            case 16: 
            case 21: 
            case 42: 
            case 43: 
            case 93: 
            case 0x60: 
            case 101: {
                v1 = 2;
                break;
            }
            default: {
                if(v == 24 || v == 25 || v == 26 || v == 27) {
                    v1 = 2;
                    break;
                }
                else {
                    switch(v) {
                        case 30: 
                        case 0x1F: 
                        case 0x20: 
                        case 33: 
                        case 34: 
                        case 35: 
                        case 36: 
                        case 37: {
                            v1 = 2;
                            break;
                        }
                        default: {
                            v1 = v == 78 || v == 0x4F || v == 80 || v == 81 || v == 82 || (v == 88 || v == 89 || v == 90) ? 2 : 3;
                        }
                    }
                }
            }
        }
        Object[] arr_object = new Object[v1];
        switch(v) {
            case 2: {
                arr_object[0] = "customSubtype";
                break;
            }
            case 4: {
                arr_object[0] = "equalityAxioms";
                break;
            }
            case 5: {
                arr_object[0] = "axioms";
                break;
            }
            case 1: 
            case 7: {
                arr_object[0] = "kotlinTypePreparator";
                break;
            }
            case 8: 
            case 9: {
                arr_object[0] = "candidateSet";
                break;
            }
            case 10: {
                arr_object[0] = "transformFirst";
                break;
            }
            case 13: {
                arr_object[0] = "f";
                break;
            }
            case 14: {
                arr_object[0] = "g";
                break;
            }
            case 15: 
            case 17: {
                arr_object[0] = "descriptor";
                break;
            }
            case 18: {
                arr_object[0] = "result";
                break;
            }
            case 19: 
            case 22: 
            case 28: 
            case 38: {
                arr_object[0] = "superDescriptor";
                break;
            }
            case 20: 
            case 23: 
            case 29: 
            case 39: {
                arr_object[0] = "subDescriptor";
                break;
            }
            case 40: {
                arr_object[0] = "firstParameters";
                break;
            }
            case 41: {
                arr_object[0] = "secondParameters";
                break;
            }
            case 44: {
                arr_object[0] = "typeInSuper";
                break;
            }
            case 45: {
                arr_object[0] = "typeInSub";
                break;
            }
            case 0x2F: {
                arr_object[0] = "superTypeParameter";
                break;
            }
            case 0x30: {
                arr_object[0] = "subTypeParameter";
                break;
            }
            case 50: {
                arr_object[0] = "name";
                break;
            }
            case 51: {
                arr_object[0] = "membersFromSupertypes";
                break;
            }
            case 52: {
                arr_object[0] = "membersFromCurrent";
                break;
            }
            case 55: {
                arr_object[0] = "overriding";
                break;
            }
            case 56: {
                arr_object[0] = "fromSuper";
                break;
            }
            case 57: {
                arr_object[0] = "fromCurrent";
                break;
            }
            case 58: {
                arr_object[0] = "descriptorsFromSuper";
                break;
            }
            case 61: 
            case 0x3F: {
                arr_object[0] = "notOverridden";
                break;
            }
            case 69: {
                arr_object[0] = "candidate";
                break;
            }
            case 65: 
            case 67: 
            case 71: {
                arr_object[0] = "a";
                break;
            }
            case 72: {
                arr_object[0] = "aReturnType";
                break;
            }
            case 66: 
            case 68: 
            case 73: {
                arr_object[0] = "b";
                break;
            }
            case 74: {
                arr_object[0] = "bReturnType";
                break;
            }
            case 46: 
            case 49: 
            case 75: {
                arr_object[0] = "typeCheckerState";
                break;
            }
            case 76: 
            case 83: {
                arr_object[0] = "overridables";
                break;
            }
            case 92: {
                arr_object[0] = "classModality";
                break;
            }
            case 53: 
            case 59: 
            case 62: 
            case 84: 
            case 87: 
            case 94: {
                arr_object[0] = "current";
                break;
            }
            case 0x5F: {
                arr_object[0] = "toFilter";
                break;
            }
            case 77: 
            case 99: {
                arr_object[0] = "descriptorByHandle";
                break;
            }
            case 100: {
                arr_object[0] = "onConflict";
                break;
            }
            case 11: 
            case 12: 
            case 16: 
            case 21: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 30: 
            case 0x1F: 
            case 0x20: 
            case 33: 
            case 34: 
            case 35: 
            case 36: 
            case 37: 
            case 42: 
            case 43: 
            case 78: 
            case 0x4F: 
            case 80: 
            case 81: 
            case 82: 
            case 88: 
            case 89: 
            case 90: 
            case 93: 
            case 0x60: 
            case 101: {
                arr_object[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                break;
            }
            case 97: 
            case 102: {
                arr_object[0] = "overrider";
                break;
            }
            case 98: 
            case 103: {
                arr_object[0] = "extractFrom";
                break;
            }
            case 54: 
            case 60: 
            case 0x40: 
            case 85: 
            case 104: {
                arr_object[0] = "strategy";
                break;
            }
            case 105: 
            case 106: {
                arr_object[0] = "memberDescriptor";
                break;
            }
            case 70: 
            case 86: 
            case 91: 
            case 107: {
                arr_object[0] = "descriptors";
                break;
            }
            default: {
                arr_object[0] = "kotlinTypeRefiner";
            }
        }
        switch(v) {
            case 11: 
            case 12: {
                arr_object[1] = "filterOverrides";
                break;
            }
            case 16: {
                arr_object[1] = "getOverriddenDeclarations";
                break;
            }
            case 21: {
                arr_object[1] = "isOverridableBy";
                break;
            }
            case 42: 
            case 43: {
                arr_object[1] = "createTypeCheckerState";
                break;
            }
            case 93: {
                arr_object[1] = "getMinimalModality";
                break;
            }
            case 0x60: {
                arr_object[1] = "filterVisibleFakeOverrides";
                break;
            }
            case 101: {
                arr_object[1] = "extractMembersOverridableInBothWays";
                break;
            }
            default: {
                if(v == 24 || v == 25 || v == 26 || v == 27) {
                    arr_object[1] = "isOverridableBy";
                }
                else {
                    switch(v) {
                        case 30: 
                        case 0x1F: 
                        case 0x20: 
                        case 33: 
                        case 34: 
                        case 35: 
                        case 36: 
                        case 37: {
                            arr_object[1] = "isOverridableByWithoutExternalConditions";
                            break;
                        }
                        default: {
                            if(v == 78 || v == 0x4F || v == 80 || v == 81 || v == 82) {
                                arr_object[1] = "selectMostSpecificMember";
                            }
                            else if(v != 88 && v != 89 && v != 90) {
                                arr_object[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                            }
                            else {
                                arr_object[1] = "determineModalityForFakeOverride";
                            }
                        }
                    }
                }
            }
        }
        switch(v) {
            case 1: 
            case 2: {
                arr_object[2] = "createWithTypePreparatorAndCustomSubtype";
                break;
            }
            case 3: 
            case 4: {
                arr_object[2] = "create";
                break;
            }
            case 5: 
            case 6: 
            case 7: {
                arr_object[2] = "<init>";
                break;
            }
            case 8: {
                arr_object[2] = "filterOutOverridden";
                break;
            }
            case 9: 
            case 10: {
                arr_object[2] = "filterOverrides";
                break;
            }
            case 13: 
            case 14: {
                arr_object[2] = "overrides";
                break;
            }
            case 15: {
                arr_object[2] = "getOverriddenDeclarations";
                break;
            }
            case 17: 
            case 18: {
                arr_object[2] = "collectOverriddenDeclarations";
                break;
            }
            case 19: 
            case 20: 
            case 22: 
            case 23: {
                arr_object[2] = "isOverridableBy";
                break;
            }
            case 28: 
            case 29: {
                arr_object[2] = "isOverridableByWithoutExternalConditions";
                break;
            }
            case 38: 
            case 39: {
                arr_object[2] = "getBasicOverridabilityProblem";
                break;
            }
            case 40: 
            case 41: {
                arr_object[2] = "createTypeCheckerState";
                break;
            }
            case 44: 
            case 45: 
            case 46: {
                arr_object[2] = "areTypesEquivalent";
                break;
            }
            case 0x2F: 
            case 0x30: 
            case 49: {
                arr_object[2] = "areTypeParametersEquivalent";
                break;
            }
            case 50: 
            case 51: 
            case 52: 
            case 53: 
            case 54: {
                arr_object[2] = "generateOverridesInFunctionGroup";
                break;
            }
            case 55: 
            case 56: {
                arr_object[2] = "isVisibleForOverride";
                break;
            }
            case 57: 
            case 58: 
            case 59: 
            case 60: {
                arr_object[2] = "extractAndBindOverridesForMember";
                break;
            }
            case 61: {
                arr_object[2] = "allHasSameContainingDeclaration";
                break;
            }
            case 62: 
            case 0x3F: 
            case 0x40: {
                arr_object[2] = "createAndBindFakeOverrides";
                break;
            }
            case 65: 
            case 66: {
                arr_object[2] = "isMoreSpecific";
                break;
            }
            case 67: 
            case 68: {
                arr_object[2] = "isVisibilityMoreSpecific";
                break;
            }
            case 69: 
            case 70: {
                arr_object[2] = "isMoreSpecificThenAllOf";
                break;
            }
            case 71: 
            case 72: 
            case 73: 
            case 74: 
            case 75: {
                arr_object[2] = "isReturnTypeMoreSpecific";
                break;
            }
            case 76: 
            case 77: {
                arr_object[2] = "selectMostSpecificMember";
                break;
            }
            case 83: 
            case 84: 
            case 85: {
                arr_object[2] = "createAndBindFakeOverride";
                break;
            }
            case 86: 
            case 87: {
                arr_object[2] = "determineModalityForFakeOverride";
                break;
            }
            case 91: 
            case 92: {
                arr_object[2] = "getMinimalModality";
                break;
            }
            case 94: 
            case 0x5F: {
                arr_object[2] = "filterVisibleFakeOverrides";
                break;
            }
            case 11: 
            case 12: 
            case 16: 
            case 21: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 30: 
            case 0x1F: 
            case 0x20: 
            case 33: 
            case 34: 
            case 35: 
            case 36: 
            case 37: 
            case 42: 
            case 43: 
            case 78: 
            case 0x4F: 
            case 80: 
            case 81: 
            case 82: 
            case 88: 
            case 89: 
            case 90: 
            case 93: 
            case 0x60: 
            case 101: {
                break;
            }
            case 97: 
            case 98: 
            case 99: 
            case 100: 
            case 102: 
            case 103: 
            case 104: {
                arr_object[2] = "extractMembersOverridableInBothWays";
                break;
            }
            case 105: {
                arr_object[2] = "resolveUnknownVisibilityForMember";
                break;
            }
            case 106: {
                arr_object[2] = "computeVisibilityToInherit";
                break;
            }
            case 107: {
                arr_object[2] = "findMaxVisibility";
                break;
            }
            default: {
                arr_object[2] = "createWithTypeRefiner";
            }
        }
        String s1 = String.format(s, arr_object);
        switch(v) {
            case 11: 
            case 12: 
            case 16: 
            case 21: 
            case 42: 
            case 43: 
            case 93: 
            case 0x60: 
            case 101: {
                illegalStateException0 = new IllegalStateException(s1);
                break;
            }
            default: {
                if(v == 24 || v == 25 || v == 26 || v == 27) {
                    illegalStateException0 = new IllegalStateException(s1);
                    break;
                }
                else {
                    switch(v) {
                        case 30: 
                        case 0x1F: 
                        case 0x20: 
                        case 33: 
                        case 34: 
                        case 35: 
                        case 36: 
                        case 37: {
                            illegalStateException0 = new IllegalStateException(s1);
                            break;
                        }
                        default: {
                            illegalStateException0 = v == 78 || v == 0x4F || v == 80 || v == 81 || v == 82 || (v == 88 || v == 89 || v == 90) ? new IllegalStateException(s1) : new IllegalArgumentException(s1);
                        }
                    }
                }
            }
        }
        throw illegalStateException0;
    }

    public static boolean b(x x0, x x1, L l0) {
        if(x0 != null) {
            if(x1 != null) {
                return !Hf.c.k(x0) || !Hf.c.k(x1) ? d.h(l0, x0.I(), x1.I()) : true;
            }
            k.a(45);
            throw null;
        }
        k.a(44);
        throw null;
    }

    public static void c(Me.c c0, LinkedHashSet linkedHashSet0) {
        if(c0 != null) {
            if(c0.getKind() != 2) {
                linkedHashSet0.add(c0);
                return;
            }
            if(c0.f().isEmpty()) {
                throw new IllegalStateException("No overridden descriptors found for (fake override) " + c0);
            }
            for(Object object0: c0.f()) {
                k.c(((Me.c)object0), linkedHashSet0);
            }
            return;
        }
        k.a(17);
        throw null;
    }

    public static ArrayList d(b b0) {
        u u0 = b0.Q();
        ArrayList arrayList0 = new ArrayList();
        if(u0 != null) {
            arrayList0.add(u0.getType());
        }
        for(Object object0: b0.F()) {
            arrayList0.add(((S)object0).getType());
        }
        return arrayList0;
    }

    public static void e(Collection collection0, e e0, m m0) {
        y y0;
        boolean z1;
        if(collection0 != null) {
            if(e0 != null) {
                ArrayList arrayList0 = new ArrayList();
                Iterator iterator0 = collection0.iterator();
                while(true) {
                    boolean z = true;
                    z1 = false;
                    if(!iterator0.hasNext()) {
                        break;
                    }
                    Object object0 = iterator0.next();
                    Me.c c0 = (Me.c)object0;
                    if(Me.p.e(c0.getVisibility())) {
                        z = false;
                    }
                    else if(e0 == null) {
                        Me.p.a(3);
                        throw null;
                    }
                    else if(Me.p.c(Me.p.n, c0, e0) == null) {
                    }
                    if(z) {
                        arrayList0.add(object0);
                    }
                }
                boolean z2 = arrayList0.isEmpty();
                if(!z2) {
                    collection0 = arrayList0;
                }
                boolean z3 = false;
                boolean z4 = false;
                for(Object object1: collection0) {
                    Me.c c1 = (Me.c)object1;
                    switch(c1.i().ordinal()) {
                        case 0: {
                            y0 = y.b;
                            goto label_96;
                        }
                        case 1: {
                            throw new IllegalStateException("Member cannot have SEALED modality: " + c1);
                        }
                        case 2: {
                            z3 = true;
                            break;
                        }
                        case 3: {
                            z4 = true;
                        }
                    }
                }
                if(e0.r0() && e0.i() != y.e && e0.i() != y.c) {
                    z1 = true;
                }
                if(z3 && !z4) {
                    y0 = y.d;
                    goto label_96;
                }
                if(!z3 && z4) {
                    y y1 = z1 ? e0.i() : y.e;
                    if(y1 != null) {
                        y0 = y1;
                        goto label_96;
                    }
                    k.a(90);
                    throw null;
                }
                HashSet hashSet0 = new HashSet();
                for(Object object2: collection0) {
                    if(((Me.c)object2) != null) {
                        LinkedHashSet linkedHashSet0 = new LinkedHashSet();
                        k.c(((Me.c)object2), linkedHashSet0);
                        hashSet0.addAll(linkedHashSet0);
                        continue;
                    }
                    k.a(15);
                    throw null;
                }
                if(!hashSet0.isEmpty()) {
                    Object object3 = hashSet0.iterator().next();
                    if(xf.d.j(((Me.k)object3)).L0(g.a) != null) {
                        throw new ClassCastException();
                    }
                }
                if(hashSet0.size() > 1) {
                    LinkedHashSet linkedHashSet1 = new LinkedHashSet();
                    Iterator iterator3 = hashSet0.iterator();
                label_69:
                    while(iterator3.hasNext()) {
                        Object object4 = iterator3.next();
                        Iterator iterator4 = linkedHashSet1.iterator();
                        while(iterator4.hasNext()) {
                            Object object5 = iterator4.next();
                            b b0 = (b)object5;
                            if(k.q(((b)object4), b0)) {
                                iterator4.remove();
                            }
                            else {
                                if(k.q(b0, ((b)object4))) {
                                    continue label_69;
                                }
                                if(false) {
                                    break;
                                }
                            }
                        }
                        linkedHashSet1.add(object4);
                    }
                    hashSet0 = linkedHashSet1;
                }
                y y2 = e0.i();
                if(y2 != null) {
                    y y3 = y.e;
                    for(Object object6: hashSet0) {
                        Me.c c2 = (Me.c)object6;
                        y y4 = !z1 || c2.i() != y.e ? c2.i() : y2;
                        if(y4.compareTo(y3) < 0) {
                            y3 = y4;
                        }
                    }
                    if(y3 != null) {
                        y0 = y3;
                    label_96:
                        Me.c c3 = ((Me.c)k.s(collection0, new i(0))).v(e0, y0, (z2 ? Me.p.h : Me.p.g));
                        m0.p(c3, collection0);
                        m0.b(c3);
                        return;
                    }
                    k.a(93);
                    throw null;
                }
                k.a(92);
                throw null;
            }
            k.a(84);
            throw null;
        }
        k.a(83);
        throw null;
    }

    public final L f(List list0, List list1) {
        if(list0 != null) {
            if(list1 != null) {
                c c0 = this.a;
                if(list0.isEmpty()) {
                    return new l(null, c0).p0();
                }
                HashMap hashMap0 = new HashMap();
                for(int v = 0; v < list0.size(); ++v) {
                    hashMap0.put(((Me.S)list0.get(v)).q(), ((Me.S)list1.get(v)).q());
                }
                return new l(hashMap0, c0).p0();
            }
            k.a(41);
            throw null;
        }
        k.a(40);
        throw null;
    }

    public static ArrayList g(Object object0, LinkedList linkedList0, we.k k0, we.k k1) {
        if(object0 != null) {
            ArrayList arrayList0 = new ArrayList();
            arrayList0.add(object0);
            b b0 = (b)k0.invoke(object0);
            Iterator iterator0 = linkedList0.iterator();
            while(iterator0.hasNext()) {
                Object object1 = iterator0.next();
                b b1 = (b)k0.invoke(object1);
                if(object0 == object1) {
                    iterator0.remove();
                }
                else {
                    int v = k.j(b0, b1);
                    if(v == 1) {
                        arrayList0.add(object1);
                        iterator0.remove();
                    }
                    else if(v == 3) {
                        k1.invoke(object1);
                        iterator0.remove();
                    }
                }
            }
            return arrayList0;
        }
        k.a(97);
        throw null;
    }

    public final void h(qf.e e0, Collection collection0, Collection collection1, e e1, m m0) {
        if(e0 != null) {
            if(collection0 != null) {
                if(collection1 != null) {
                    if(e1 != null) {
                        LinkedHashSet linkedHashSet0 = new LinkedHashSet(collection0);
                        for(Object object0: collection1) {
                            Me.c c0 = (Me.c)object0;
                            if(c0 != null) {
                                ArrayList arrayList0 = new ArrayList(collection0.size());
                                h h0 = Qf.k.e();
                                for(Object object1: collection0) {
                                    Me.c c1 = (Me.c)object1;
                                    int v = this.l(c1, c0, e1).b();
                                    boolean z = !Me.p.e(c1.getVisibility()) && Me.p.c(Me.p.n, c1, c0) == null;
                                    switch(e0.b.b(v)) {
                                        case 0: {
                                            if(z) {
                                                h0.add(c1);
                                            }
                                            arrayList0.add(c1);
                                            continue;
                                        }
                                        case 2: {
                                            if(z) {
                                                m0.d(c1, c0);
                                            }
                                            break;
                                        }
                                        default: {
                                            continue;
                                        }
                                    }
                                    arrayList0.add(c1);
                                }
                                m0.p(c0, h0);
                                linkedHashSet0.removeAll(arrayList0);
                                continue;
                            }
                            k.a(57);
                            throw null;
                        }
                        if(linkedHashSet0.size() >= 2) {
                            Object object2 = linkedHashSet0.iterator().next();
                            Me.k k0 = ((Me.c)object2).e();
                            if(!linkedHashSet0.isEmpty()) {
                                for(Object object3: linkedHashSet0) {
                                    if(((Me.c)object3).e() == k0) {
                                        continue;
                                    }
                                    LinkedList linkedList0 = new LinkedList(linkedHashSet0);
                                    while(!linkedList0.isEmpty()) {
                                        Me.c c2 = null;
                                        for(Object object4: linkedList0) {
                                            Me.c c3 = (Me.c)object4;
                                            if(c2 == null) {
                                                c2 = c3;
                                            }
                                            else {
                                                Integer integer0 = Me.p.b(c2.getVisibility(), c3.getVisibility());
                                                if(integer0 != null && ((int)integer0) < 0) {
                                                    c2 = c3;
                                                }
                                            }
                                        }
                                        q.d(c2);
                                        k.e(k.g(c2, linkedList0, new i(1), new G(10, m0, c2)), e1, m0);
                                    }
                                    return;
                                }
                            }
                        }
                        for(Object object5: linkedHashSet0) {
                            k.e(Collections.singleton(((Me.c)object5)), e1, m0);
                        }
                        return;
                    }
                    k.a(53);
                    throw null;
                }
                k.a(52);
                throw null;
            }
            k.a(51);
            throw null;
        }
        k.a(50);
        throw null;
    }

    public static j i(b b0, b b1) {
        j j0;
        int v = 0;
        if(b0 != null) {
            if(b1 != null) {
                if(b0 instanceof Me.u && !(b1 instanceof Me.u) || b0 instanceof Me.L && !(b1 instanceof Me.L)) {
                    return j.c("Member kind mismatch");
                }
                if(!(b0 instanceof Me.u) && !(b0 instanceof Me.L)) {
                    throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + b0);
                }
                if(!b0.getName().equals(b1.getName())) {
                    return j.c("Name mismatch");
                }
                int v1 = b0.Q() == null ? 1 : 0;
                if(b1.Q() == null) {
                    v = 1;
                }
                if(v1 != v) {
                    j0 = j.c("Receiver presence mismatch");
                    return j0 == null ? null : j0;
                }
                j0 = b0.F().size() == b1.F().size() ? null : j.c("Value parameter number mismatch");
                return j0 == null ? null : j0;
            }
            k.a(39);
            throw null;
        }
        k.a(38);
        throw null;
    }

    public static int j(b b0, b b1) {
        int v = k.c.l(b1, b0, null).b();
        int v1 = k.c.m(b0, b1, null, false).b();
        if(v == 1 && v1 == 1) {
            return 1;
        }
        return v == 3 || v1 == 3 ? 3 : 2;
    }

    public static boolean k(b b0, b b1) {
        if(b0 != null) {
            if(b1 != null) {
                x x0 = b0.getReturnType();
                x x1 = b1.getReturnType();
                if(k.p(b0, b1)) {
                    List list0 = b0.getTypeParameters();
                    List list1 = b1.getTypeParameters();
                    L l0 = k.c.f(list0, list1);
                    if(b0 instanceof Me.u) {
                        return k.o(b0, x0, b1, x1, l0);
                    }
                    if(!(b0 instanceof Me.L)) {
                        throw new IllegalArgumentException("Unexpected callable: " + b0.getClass());
                    }
                    K k0 = ((Me.L)b0).b();
                    K k1 = ((Me.L)b1).b();
                    if((k0 == null || k1 == null ? true : k.p(k0, k1))) {
                        return !((Me.L)b0).P() || !((Me.L)b1).P() ? (((Me.L)b0).P() || !((Me.L)b1).P()) && k.o(b0, x0, b1, x1, l0) : d.h(l0, x0.I(), x1.I());
                    }
                }
                return false;
            }
            k.a(66);
            throw null;
        }
        k.a(65);
        throw null;
    }

    public final j l(b b0, b b1, e e0) {
        if(b0 != null) {
            if(b1 != null) {
                return this.m(b0, b1, e0, false);
            }
            k.a(20);
            throw null;
        }
        k.a(19);
        throw null;
    }

    public final j m(b b0, b b1, e e0, boolean z) {
        if(b0 != null) {
            if(b1 != null) {
                j j0 = this.n(b0, b1, z);
                boolean z1 = j0.b() == 1;
                List list0 = k.b;
                for(Object object0: list0) {
                    f f0 = (f)object0;
                    if(f0.b() != 1 && (!z1 || f0.b() != 2)) {
                        switch(e0.b.b(f0.a(b0, b1, e0))) {
                            case 0: {
                                z1 = true;
                                break;
                            }
                            case 1: {
                                return j.c("External condition");
                            }
                        }
                    }
                }
                if(!z1) {
                    return j0;
                }
                for(Object object1: list0) {
                    f f1 = (f)object1;
                    if(f1.b() != 1) {
                        continue;
                    }
                    switch(e0.b.b(f1.a(b0, b1, e0))) {
                        case 0: {
                            throw new IllegalStateException("Contract violation in " + f1.getClass().getName() + " condition. It\'s not supposed to end with success");
                        }
                        case 1: {
                            break;
                        }
                        default: {
                            continue;
                        }
                    }
                    return j.c("External condition");
                }
                j j1 = j.c;
                if(j1 != null) {
                    return j1;
                }
                j.a(0);
                throw null;
            }
            k.a(23);
            throw null;
        }
        k.a(22);
        throw null;
    }

    public final j n(b b0, b b1, boolean z) {
        if(b0 != null) {
            if(b1 != null) {
                j j0 = k.i(b0, b1);
                if(j0 != null) {
                    return j0;
                }
                ArrayList arrayList0 = k.d(b0);
                ArrayList arrayList1 = k.d(b1);
                List list0 = b0.getTypeParameters();
                List list1 = b1.getTypeParameters();
                if(list0.size() != list1.size()) {
                    for(int v = 0; v < arrayList0.size(); ++v) {
                        x x0 = (x)arrayList0.get(v);
                        x x1 = (x)arrayList1.get(v);
                        if(!If.d.a.a(x0, x1)) {
                            return j.c("Type parameter number mismatch");
                        }
                    }
                    return new j(3, "Type parameter number mismatch");
                }
                L l0 = this.f(list0, list1);
                int v1 = 0;
                while(v1 < list0.size()) {
                    Me.S s0 = (Me.S)list0.get(v1);
                    Me.S s1 = (Me.S)list1.get(v1);
                    if(s0 != null) {
                        if(s1 != null) {
                            List list2 = s0.getUpperBounds();
                            ArrayList arrayList2 = new ArrayList(s1.getUpperBounds());
                            if(list2.size() == arrayList2.size()) {
                                Iterator iterator0 = list2.iterator();
                            label_30:
                                while(iterator0.hasNext()) {
                                    Object object0 = iterator0.next();
                                    ListIterator listIterator0 = arrayList2.listIterator();
                                    while(true) {
                                        if(!listIterator0.hasNext()) {
                                            return j.c("Type parameter bounds mismatch");
                                        }
                                        if(!k.b(((x)object0), ((x)listIterator0.next()), l0)) {
                                            continue;
                                        }
                                        listIterator0.remove();
                                        continue label_30;
                                    }
                                }
                                ++v1;
                                continue;
                            }
                            return j.c("Type parameter bounds mismatch");
                        }
                        k.a(0x30);
                        throw null;
                    }
                    k.a(0x2F);
                    throw null;
                }
                for(int v2 = 0; v2 < arrayList0.size(); ++v2) {
                    if(!k.b(((x)arrayList0.get(v2)), ((x)arrayList1.get(v2)), l0)) {
                        return j.c("Value parameter type mismatch");
                    }
                }
                if(b0 instanceof Me.u && b1 instanceof Me.u && ((Me.u)b0).isSuspend() != ((Me.u)b1).isSuspend()) {
                    return new j(3, "Incompatible suspendability");
                }
                if(z) {
                    x x2 = b0.getReturnType();
                    x x3 = b1.getReturnType();
                    if(x2 != null && x3 != null && (!Hf.c.k(x3) || !Hf.c.k(x2))) {
                        a0 a00 = x3.I();
                        a0 a01 = x2.I();
                        if(!(a00 == a01 ? true : d.f(l0, a00, a01))) {
                            return new j(3, "Return type mismatch");
                        }
                    }
                }
                j j1 = j.c;
                if(j1 != null) {
                    return j1;
                }
                j.a(0);
                throw null;
            }
            k.a(29);
            throw null;
        }
        k.a(28);
        throw null;
    }

    public static boolean o(b b0, x x0, b b1, x x1, L l0) {
        if(b0 != null) {
            if(x0 != null) {
                if(b1 != null) {
                    if(x1 != null) {
                        a0 a00 = x0.I();
                        a0 a01 = x1.I();
                        return a00 == a01 ? true : d.f(l0, a00, a01);
                    }
                    k.a(74);
                    throw null;
                }
                k.a(73);
                throw null;
            }
            k.a(72);
            throw null;
        }
        k.a(71);
        throw null;
    }

    public static boolean p(b b0, b b1) {
        if(b0 != null) {
            if(b1 != null) {
                Integer integer0 = Me.p.b(b0.getVisibility(), b1.getVisibility());
                return integer0 == null || ((int)integer0) >= 0;
            }
            k.a(68);
            throw null;
        }
        k.a(67);
        throw null;
    }

    public static boolean q(b b0, b b1) {
        if(b0 != null) {
            if(b1 != null) {
                boolean z = b0.equals(b1);
                tf.c c0 = tf.c.a;
                if(z || !c0.b(b0.a(), b1.a(), false)) {
                    b b2 = b1.a();
                    LinkedHashSet linkedHashSet0 = new LinkedHashSet();
                    tf.e.b(b0.a(), linkedHashSet0);
                    for(Object object0: linkedHashSet0) {
                        if(!c0.b(b2, ((b)object0), false)) {
                            continue;
                        }
                        return true;
                    }
                    return false;
                }
                return true;
            }
            k.a(14);
            throw null;
        }
        k.a(13);
        throw null;
    }

    public static void r(Me.c c0, we.k k0) {
        o o3;
        o o2;
        o o1;
        o o0;
        if(c0 != null) {
            for(Object object0: c0.f()) {
                Me.c c1 = (Me.c)object0;
                if(c1.getVisibility() == Me.p.g) {
                    k.r(c1, k0);
                }
            }
            if(c0.getVisibility() == Me.p.g) {
                Collection collection0 = c0.f();
                if(collection0 == null) {
                    k.a(107);
                    throw null;
                }
                if(collection0.isEmpty()) {
                    o0 = Me.p.l;
                }
                else {
                    Iterator iterator1 = collection0.iterator();
                    do {
                        o1 = null;
                    label_16:
                        if(!iterator1.hasNext()) {
                            goto label_25;
                        }
                        Object object1 = iterator1.next();
                        o2 = ((Me.c)object1).getVisibility();
                        if(o1 == null) {
                            o1 = o2;
                            goto label_16;
                        }
                        Integer integer0 = Me.p.b(o2, o1);
                    }
                    while(integer0 == null);
                    if(((int)integer0) <= 0) {
                        goto label_16;
                    }
                    o1 = o2;
                    goto label_16;
                label_25:
                    if(o1 != null) {
                        for(Object object2: collection0) {
                            Integer integer1 = Me.p.b(o1, ((Me.c)object2).getVisibility());
                            if(integer1 != null && ((int)integer1) >= 0) {
                                continue;
                            }
                            goto label_34;
                        }
                        o0 = o1;
                        goto label_35;
                    }
                label_34:
                    o0 = null;
                }
            label_35:
                if(o0 == null) {
                    o0 = null;
                }
                else if(c0.getKind() == 2) {
                    for(Object object3: collection0) {
                        if(((Me.c)object3).i() != y.e && !((Me.c)object3).getVisibility().equals(o0)) {
                            o0 = null;
                            break;
                        }
                    }
                }
                else {
                    o0 = Me.p.f(o0.a.c());
                }
                if(o0 == null) {
                    if(k0 != null) {
                        k0.invoke(c0);
                    }
                    o3 = Me.p.e;
                }
                else {
                    o3 = o0;
                }
                if(c0 instanceof I) {
                    if(o3 != null) {
                        ((I)c0).j = o3;
                        for(Object object4: ((Me.L)c0).m()) {
                            k.r(((Me.K)object4), (o0 == null ? null : k0));
                        }
                        return;
                    }
                    I.Q0(20);
                    throw null;
                }
                if(c0 instanceof t) {
                    if(o3 != null) {
                        ((t)c0).l = o3;
                        return;
                    }
                    t.Q0(10);
                    throw null;
                }
                ((Pe.G)c0).k = o3;
                if(o3 != ((Pe.G)c0).t1().getVisibility()) {
                    ((Pe.G)c0).e = false;
                    return;
                }
            }
            return;
        }
        k.a(105);
        throw null;
    }

    public static Object s(Collection collection0, we.k k0) {
        if(collection0.size() == 1) {
            Object object0 = p.j0(collection0);
            if(object0 != null) {
                return object0;
            }
            k.a(78);
            throw null;
        }
        ArrayList arrayList0 = new ArrayList(2);
        ArrayList arrayList1 = new ArrayList(je.q.Q(10, collection0));
        for(Object object1: collection0) {
            arrayList1.add(k0.invoke(object1));
        }
        Object object2 = p.j0(collection0);
        b b0 = (b)k0.invoke(object2);
        for(Object object3: collection0) {
            b b1 = (b)k0.invoke(object3);
            if(b1 != null) {
                for(Object object4: arrayList1) {
                    if(k.k(b1, ((b)object4))) {
                        continue;
                    }
                    goto label_26;
                }
                arrayList0.add(object3);
            label_26:
                if(!k.k(b1, b0) || k.k(b0, b1)) {
                    continue;
                }
                object2 = object3;
                continue;
            }
            k.a(69);
            throw null;
        }
        if(arrayList0.isEmpty()) {
            if(object2 != null) {
                return object2;
            }
            k.a(0x4F);
            throw null;
        }
        if(arrayList0.size() == 1) {
            Object object5 = p.j0(arrayList0);
            if(object5 != null) {
                return object5;
            }
            k.a(80);
            throw null;
        }
        Object object6 = null;
        for(Object object7: arrayList0) {
            if(!Hf.c.l(((b)k0.invoke(object7)).getReturnType())) {
                object6 = object7;
                break;
            }
        }
        if(object6 != null) {
            return object6;
        }
        Object object8 = p.j0(arrayList0);
        if(object8 != null) {
            return object8;
        }
        k.a(82);
        throw null;
    }
}

