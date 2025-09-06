package Ve;

import De.l;
import De.w;
import U4.x;
import We.a;
import androidx.media3.session.legacy.V;
import java.util.ArrayList;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.J;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;
import nf.b;
import nf.d;
import x9.c;

public abstract class o {
    public static final w[] a;
    public static final V b;
    public static final c c;

    static {
        Class class0 = o.class;
        t t0 = new t(class0, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmClass;)Z", 1);
        J j0 = I.a;
        l l0 = x.c(class0, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmConstructor;)Z", 1, j0);
        l l1 = x.c(class0, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmFunction;)Z", 1, j0);
        l l2 = x.c(class0, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmProperty;)Z", 1, j0);
        l l3 = x.c(class0, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1, j0);
        l l4 = x.c(class0, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmValueParameter;)Z", 1, j0);
        l l5 = x.c(class0, "hasAnnotations", "getHasAnnotations(Lkotlin/metadata/KmTypeAlias;)Z", 1, j0);
        l l6 = x.c(class0, "modality", "getModality(Lkotlin/metadata/KmClass;)Lkotlin/metadata/Modality;", 1, j0);
        l l7 = x.c(class0, "visibility", "getVisibility(Lkotlin/metadata/KmClass;)Lkotlin/metadata/Visibility;", 1, j0);
        l l8 = x.c(class0, "kind", "getKind(Lkotlin/metadata/KmClass;)Lkotlin/metadata/ClassKind;", 1, j0);
        l l9 = x.c(class0, "isInner", "isInner(Lkotlin/metadata/KmClass;)Z", 1, j0);
        l l10 = x.c(class0, "isData", "isData(Lkotlin/metadata/KmClass;)Z", 1, j0);
        l l11 = x.c(class0, "isExternal", "isExternal(Lkotlin/metadata/KmClass;)Z", 1, j0);
        l l12 = x.c(class0, "isExpect", "isExpect(Lkotlin/metadata/KmClass;)Z", 1, j0);
        l l13 = x.c(class0, "isValue", "isValue(Lkotlin/metadata/KmClass;)Z", 1, j0);
        l l14 = x.c(class0, "isFunInterface", "isFunInterface(Lkotlin/metadata/KmClass;)Z", 1, j0);
        l l15 = x.c(class0, "hasEnumEntries", "getHasEnumEntries(Lkotlin/metadata/KmClass;)Z", 1, j0);
        l l16 = x.c(class0, "visibility", "getVisibility(Lkotlin/metadata/KmConstructor;)Lkotlin/metadata/Visibility;", 1, j0);
        l l17 = x.c(class0, "isSecondary", "isSecondary(Lkotlin/metadata/KmConstructor;)Z", 1, j0);
        l l18 = x.c(class0, "hasNonStableParameterNames", "getHasNonStableParameterNames(Lkotlin/metadata/KmConstructor;)Z", 1, j0);
        l l19 = x.c(class0, "kind", "getKind(Lkotlin/metadata/KmFunction;)Lkotlin/metadata/MemberKind;", 1, j0);
        l l20 = x.c(class0, "visibility", "getVisibility(Lkotlin/metadata/KmFunction;)Lkotlin/metadata/Visibility;", 1, j0);
        l l21 = x.c(class0, "modality", "getModality(Lkotlin/metadata/KmFunction;)Lkotlin/metadata/Modality;", 1, j0);
        l l22 = x.c(class0, "isOperator", "isOperator(Lkotlin/metadata/KmFunction;)Z", 1, j0);
        l l23 = x.c(class0, "isInfix", "isInfix(Lkotlin/metadata/KmFunction;)Z", 1, j0);
        l l24 = x.c(class0, "isInline", "isInline(Lkotlin/metadata/KmFunction;)Z", 1, j0);
        l l25 = x.c(class0, "isTailrec", "isTailrec(Lkotlin/metadata/KmFunction;)Z", 1, j0);
        l l26 = x.c(class0, "isExternal", "isExternal(Lkotlin/metadata/KmFunction;)Z", 1, j0);
        l l27 = x.c(class0, "isSuspend", "isSuspend(Lkotlin/metadata/KmFunction;)Z", 1, j0);
        l l28 = x.c(class0, "isExpect", "isExpect(Lkotlin/metadata/KmFunction;)Z", 1, j0);
        l l29 = x.c(class0, "hasNonStableParameterNames", "getHasNonStableParameterNames(Lkotlin/metadata/KmFunction;)Z", 1, j0);
        l l30 = x.c(class0, "visibility", "getVisibility(Lkotlin/metadata/KmProperty;)Lkotlin/metadata/Visibility;", 1, j0);
        l l31 = x.c(class0, "modality", "getModality(Lkotlin/metadata/KmProperty;)Lkotlin/metadata/Modality;", 1, j0);
        l l32 = x.c(class0, "kind", "getKind(Lkotlin/metadata/KmProperty;)Lkotlin/metadata/MemberKind;", 1, j0);
        l l33 = x.c(class0, "isVar", "isVar(Lkotlin/metadata/KmProperty;)Z", 1, j0);
        l l34 = x.c(class0, "isConst", "isConst(Lkotlin/metadata/KmProperty;)Z", 1, j0);
        l l35 = x.c(class0, "isLateinit", "isLateinit(Lkotlin/metadata/KmProperty;)Z", 1, j0);
        l l36 = x.c(class0, "hasConstant", "getHasConstant(Lkotlin/metadata/KmProperty;)Z", 1, j0);
        l l37 = x.c(class0, "isExternal", "isExternal(Lkotlin/metadata/KmProperty;)Z", 1, j0);
        l l38 = x.c(class0, "isDelegated", "isDelegated(Lkotlin/metadata/KmProperty;)Z", 1, j0);
        l l39 = x.c(class0, "isExpect", "isExpect(Lkotlin/metadata/KmProperty;)Z", 1, j0);
        l l40 = x.c(class0, "visibility", "getVisibility(Lkotlin/metadata/KmPropertyAccessorAttributes;)Lkotlin/metadata/Visibility;", 1, j0);
        l l41 = x.c(class0, "modality", "getModality(Lkotlin/metadata/KmPropertyAccessorAttributes;)Lkotlin/metadata/Modality;", 1, j0);
        l l42 = x.c(class0, "isNotDefault", "isNotDefault(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1, j0);
        l l43 = x.c(class0, "isExternal", "isExternal(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1, j0);
        l l44 = x.c(class0, "isInline", "isInline(Lkotlin/metadata/KmPropertyAccessorAttributes;)Z", 1, j0);
        l l45 = x.c(class0, "isNullable", "isNullable(Lkotlin/metadata/KmType;)Z", 1, j0);
        l l46 = x.c(class0, "isSuspend", "isSuspend(Lkotlin/metadata/KmType;)Z", 1, j0);
        l l47 = x.c(class0, "isDefinitelyNonNull", "isDefinitelyNonNull(Lkotlin/metadata/KmType;)Z", 1, j0);
        l l48 = x.c(class0, "isReified", "isReified(Lkotlin/metadata/KmTypeParameter;)Z", 1, j0);
        l l49 = x.c(class0, "visibility", "getVisibility(Lkotlin/metadata/KmTypeAlias;)Lkotlin/metadata/Visibility;", 1, j0);
        l l50 = x.c(class0, "declaresDefaultValue", "getDeclaresDefaultValue(Lkotlin/metadata/KmValueParameter;)Z", 1, j0);
        l l51 = x.c(class0, "isCrossinline", "isCrossinline(Lkotlin/metadata/KmValueParameter;)Z", 1, j0);
        l l52 = x.c(class0, "isNoinline", "isNoinline(Lkotlin/metadata/KmValueParameter;)Z", 1, j0);
        l l53 = x.c(class0, "isNegated", "isNegated(Lkotlin/metadata/KmEffectExpression;)Z", 1, j0);
        l l54 = x.c(class0, "isNullCheckPredicate", "isNullCheckPredicate(Lkotlin/metadata/KmEffectExpression;)Z", 1, j0);
        o.a = new w[]{j0.e(t0), l0, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22, l23, l24, l25, l26, l27, l28, l29, l30, l31, l32, l33, l34, l35, l36, l37, l38, l39, l40, l41, l42, l43, l44, l45, l46, l47, l48, l49, l50, l51, l52, l53, l54};
        b b0 = d.c;
        q.f(b0, "HAS_ANNOTATIONS");
        B3.d d0 = new B3.d(b0);
        if(d0.b != 1 || d0.c != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + d0 + " was passed").toString());
        }
        B3.d d1 = new B3.d(b0);
        if(d1.b != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + d1 + " was passed").toString());
        }
        E9.w.r(new B3.d(b0));
        B3.d d2 = new B3.d(b0);
        if(d2.b != 1 || d2.c != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + d2 + " was passed").toString());
        }
        E9.w.Q(new B3.d(b0));
        E9.w.W(new B3.d(b0));
        B3.d d3 = new B3.d(b0);
        if(d3.b != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + d3 + " was passed").toString());
        }
        E9.w.L(g.b);
        E9.w.X(m.b);
        Ve.c c0 = Ve.c.b;
        nf.c c1 = d.f;
        q.f(c1, "CLASS_KIND");
        pe.b b1 = p.e;
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, b1));
        for(Object object0: b1) {
            arrayList0.add(((p)object0).a);
        }
        q.g(c1, "protoSet");
        q.g(b1, "entries");
        V v0 = new V();  // 初始化器: Ljava/lang/Object;-><init>()V
        v0.a = c0;
        v0.b = c1;
        v0.c = b1;
        o.b = v0;
        q.f(d.g, "IS_INNER");
        B3.d d4 = new B3.d(d.g);
        a a0 = a.b;
        if(d4.b != 1 || d4.c != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + d4 + " was passed").toString());
        }
        q.f(d.h, "IS_DATA");
        B3.d d5 = new B3.d(d.h);
        if(d5.b != 1 || d5.c != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + d5 + " was passed").toString());
        }
        q.f(d.i, "IS_EXTERNAL_CLASS");
        B3.d d6 = new B3.d(d.i);
        if(d6.b != 1 || d6.c != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + d6 + " was passed").toString());
        }
        q.f(d.j, "IS_EXPECT_CLASS");
        B3.d d7 = new B3.d(d.j);
        if(d7.b != 1 || d7.c != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + d7 + " was passed").toString());
        }
        q.f(d.k, "IS_VALUE_CLASS");
        o.c = new c(a0, new B3.d(d.k));
        q.f(d.l, "IS_FUN_INTERFACE");
        B3.d d8 = new B3.d(d.l);
        if(d8.b != 1 || d8.c != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + d8 + " was passed").toString());
        }
        q.f(d.m, "HAS_ENUM_ENTRIES");
        B3.d d9 = new B3.d(d.m);
        if(d9.b != 1 || d9.c != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + d9 + " was passed").toString());
        }
        E9.w.X(n.b);
        q.f(d.n, "IS_SECONDARY");
        B3.d d10 = new B3.d(d.n);
        if(d10.b != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + d10 + " was passed").toString());
        }
        q.f(d.o, "IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES");
        B3.d d11 = new B3.d(d.o);
        if(d11.b != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + d11 + " was passed").toString());
        }
        E9.w.J(Ve.d.b);
        E9.w.X(i.b);
        E9.w.L(h.b);
        q.f(d.q, "IS_OPERATOR");
        E9.w.r(new B3.d(d.q));
        q.f(d.r, "IS_INFIX");
        E9.w.r(new B3.d(d.r));
        q.f(d.s, "IS_INLINE");
        E9.w.r(new B3.d(d.s));
        q.f(d.t, "IS_TAILREC");
        E9.w.r(new B3.d(d.t));
        q.f(d.u, "IS_EXTERNAL_FUNCTION");
        E9.w.r(new B3.d(d.u));
        q.f(d.v, "IS_SUSPEND");
        E9.w.r(new B3.d(d.v));
        q.f(d.w, "IS_EXPECT_FUNCTION");
        E9.w.r(new B3.d(d.w));
        q.f(d.x, "IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES");
        E9.w.r(new B3.d(d.x));
        E9.w.X(j.b);
        E9.w.L(e.b);
        E9.w.J(Ve.b.b);
        q.f(d.y, "IS_VAR");
        B3.d d12 = new B3.d(d.y);
        if(d12.b != 1 || d12.c != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + d12 + " was passed").toString());
        }
        q.f(d.B, "IS_CONST");
        B3.d d13 = new B3.d(d.B);
        if(d13.b != 1 || d13.c != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + d13 + " was passed").toString());
        }
        q.f(d.C, "IS_LATEINIT");
        B3.d d14 = new B3.d(d.C);
        if(d14.b != 1 || d14.c != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + d14 + " was passed").toString());
        }
        q.f(d.D, "HAS_CONSTANT");
        B3.d d15 = new B3.d(d.D);
        if(d15.b != 1 || d15.c != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + d15 + " was passed").toString());
        }
        q.f(d.E, "IS_EXTERNAL_PROPERTY");
        B3.d d16 = new B3.d(d.E);
        if(d16.b != 1 || d16.c != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + d16 + " was passed").toString());
        }
        q.f(d.F, "IS_DELEGATED");
        B3.d d17 = new B3.d(d.F);
        if(d17.b != 1 || d17.c != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + d17 + " was passed").toString());
        }
        q.f(d.G, "IS_EXPECT_PROPERTY");
        B3.d d18 = new B3.d(d.G);
        if(d18.b != 1 || d18.c != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + d18 + " was passed").toString());
        }
        E9.w.X(k.b);
        E9.w.L(f.b);
        q.f(d.K, "IS_NOT_DEFAULT");
        E9.w.Q(new B3.d(d.K));
        q.f(d.L, "IS_EXTERNAL_ACCESSOR");
        E9.w.Q(new B3.d(d.L));
        q.f(d.M, "IS_INLINE_ACCESSOR");
        E9.w.Q(new B3.d(d.M));
        B3.d d19 = new B3.d(d.a.b + 1, d.a.c, 1);
        if(d.a.c != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + d19 + " was passed").toString());
        }
        B3.d d20 = new B3.d(d.b.b + 1, d.b.c, 1);
        if(d.b.c != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + d20 + " was passed").toString());
        }
        E9.w.X(Ve.l.b);
        q.f(d.H, "DECLARES_DEFAULT_VALUE");
        E9.w.W(new B3.d(d.H));
        q.f(d.I, "IS_CROSSINLINE");
        E9.w.W(new B3.d(d.I));
        q.f(d.J, "IS_NOINLINE");
        E9.w.W(new B3.d(d.J));
        q.f(d.N, "IS_NEGATED");
        B3.d d21 = new B3.d(d.N);
        if(d21.b != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + d21 + " was passed").toString());
        }
        q.f(d.O, "IS_NULL_CHECK_PREDICATE");
        B3.d d22 = new B3.d(d.O);
        if(d22.b != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + d22 + " was passed").toString());
        }
    }

    public static final p a(N n0) {
        w w0 = o.a[9];
        o.b.getClass();
        q.g(w0, "property");
        return (p)(((Enum)((pe.a)o.b.c).get(((rf.n)((f0.I)o.b.b).d(((Number)((t)o.b.a).get(n0)).intValue())).a())));
    }
}

