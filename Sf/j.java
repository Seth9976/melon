package sf;

import De.l;
import De.w;
import U4.x;
import com.melon.ui.l0;
import java.util.LinkedHashSet;
import java.util.Set;
import je.y;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.J;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;

public final class j implements i {
    public final l0 A;
    public final l0 B;
    public final l0 C;
    public final l0 D;
    public final l0 E;
    public final l0 F;
    public final l0 G;
    public final l0 H;
    public final l0 I;
    public final l0 J;
    public final l0 K;
    public final l0 L;
    public final l0 M;
    public final l0 N;
    public final l0 O;
    public final l0 P;
    public final l0 Q;
    public final l0 R;
    public final l0 S;
    public final l0 T;
    public final l0 U;
    public final l0 V;
    public final l0 W;
    public final l0 X;
    public static final w[] Y;
    public boolean a;
    public final l0 b;
    public final l0 c;
    public final l0 d;
    public final l0 e;
    public final l0 f;
    public final l0 g;
    public final l0 h;
    public final l0 i;
    public final l0 j;
    public final l0 k;
    public final l0 l;
    public final l0 m;
    public final l0 n;
    public final l0 o;
    public final l0 p;
    public final l0 q;
    public final l0 r;
    public final l0 s;
    public final l0 t;
    public final l0 u;
    public final l0 v;
    public final l0 w;
    public final l0 x;
    public final l0 y;
    public final l0 z;

    static {
        Class class0 = j.class;
        t t0 = new t(class0, "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;", 0);
        J j0 = I.a;
        l l0 = x.c(class0, "withDefinedIn", "getWithDefinedIn()Z", 0, j0);
        l l1 = x.c(class0, "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z", 0, j0);
        l l2 = x.c(class0, "modifiers", "getModifiers()Ljava/util/Set;", 0, j0);
        l l3 = x.c(class0, "startFromName", "getStartFromName()Z", 0, j0);
        l l4 = x.c(class0, "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z", 0, j0);
        l l5 = x.c(class0, "debugMode", "getDebugMode()Z", 0, j0);
        l l6 = x.c(class0, "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z", 0, j0);
        l l7 = x.c(class0, "verbose", "getVerbose()Z", 0, j0);
        l l8 = x.c(class0, "unitReturnType", "getUnitReturnType()Z", 0, j0);
        l l9 = x.c(class0, "withoutReturnType", "getWithoutReturnType()Z", 0, j0);
        l l10 = x.c(class0, "enhancedTypes", "getEnhancedTypes()Z", 0, j0);
        l l11 = x.c(class0, "normalizedVisibilities", "getNormalizedVisibilities()Z", 0, j0);
        l l12 = x.c(class0, "renderDefaultVisibility", "getRenderDefaultVisibility()Z", 0, j0);
        l l13 = x.c(class0, "renderDefaultModality", "getRenderDefaultModality()Z", 0, j0);
        l l14 = x.c(class0, "renderConstructorDelegation", "getRenderConstructorDelegation()Z", 0, j0);
        l l15 = x.c(class0, "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z", 0, j0);
        l l16 = x.c(class0, "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z", 0, j0);
        l l17 = x.c(class0, "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z", 0, j0);
        l l18 = x.c(class0, "includePropertyConstant", "getIncludePropertyConstant()Z", 0, j0);
        l l19 = x.c(class0, "propertyConstantRenderer", "getPropertyConstantRenderer()Lkotlin/jvm/functions/Function1;", 0, j0);
        l l20 = x.c(class0, "withoutTypeParameters", "getWithoutTypeParameters()Z", 0, j0);
        l l21 = x.c(class0, "withoutSuperTypes", "getWithoutSuperTypes()Z", 0, j0);
        l l22 = x.c(class0, "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;", 0, j0);
        l l23 = x.c(class0, "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;", 0, j0);
        l l24 = x.c(class0, "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z", 0, j0);
        l l25 = x.c(class0, "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;", 0, j0);
        l l26 = x.c(class0, "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;", 0, j0);
        l l27 = x.c(class0, "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;", 0, j0);
        l l28 = x.c(class0, "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;", 0, j0);
        l l29 = x.c(class0, "receiverAfterName", "getReceiverAfterName()Z", 0, j0);
        l l30 = x.c(class0, "renderCompanionObjectName", "getRenderCompanionObjectName()Z", 0, j0);
        l l31 = x.c(class0, "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;", 0, j0);
        l l32 = x.c(class0, "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z", 0, j0);
        l l33 = x.c(class0, "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z", 0, j0);
        l l34 = x.c(class0, "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;", 0, j0);
        l l35 = x.c(class0, "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;", 0, j0);
        l l36 = x.c(class0, "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;", 0, j0);
        l l37 = x.c(class0, "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;", 0, j0);
        l l38 = x.c(class0, "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z", 0, j0);
        l l39 = x.c(class0, "renderConstructorKeyword", "getRenderConstructorKeyword()Z", 0, j0);
        l l40 = x.c(class0, "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z", 0, j0);
        l l41 = x.c(class0, "renderTypeExpansions", "getRenderTypeExpansions()Z", 0, j0);
        l l42 = x.c(class0, "renderAbbreviatedTypeComments", "getRenderAbbreviatedTypeComments()Z", 0, j0);
        l l43 = x.c(class0, "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z", 0, j0);
        l l44 = x.c(class0, "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z", 0, j0);
        l l45 = x.c(class0, "renderFunctionContracts", "getRenderFunctionContracts()Z", 0, j0);
        l l46 = x.c(class0, "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z", 0, j0);
        l l47 = x.c(class0, "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z", 0, j0);
        l l48 = x.c(class0, "informativeErrorType", "getInformativeErrorType()Z", 0, j0);
        j.Y = new w[]{j0.e(t0), l0, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22, l23, l24, l25, l26, l27, l28, l29, l30, l31, l32, l33, l34, l35, l36, l37, l38, l39, l40, l41, l42, l43, l44, l45, l46, l47, l48};
    }

    public j() {
        this.b = new l0(b.d, this);
        this.c = new l0(Boolean.TRUE, this);
        this.d = new l0(Boolean.TRUE, this);
        this.e = new l0(h.b, this);
        this.f = new l0(Boolean.FALSE, this);
        this.g = new l0(Boolean.FALSE, this);
        this.h = new l0(Boolean.FALSE, this);
        this.i = new l0(Boolean.FALSE, this);
        this.j = new l0(Boolean.FALSE, this);
        this.k = new l0(Boolean.TRUE, this);
        this.l = new l0(Boolean.FALSE, this);
        this.m = new l0(Boolean.FALSE, this);
        this.n = new l0(Boolean.FALSE, this);
        this.o = new l0(Boolean.TRUE, this);
        this.p = new l0(Boolean.TRUE, this);
        this.q = new l0(Boolean.FALSE, this);
        this.r = new l0(Boolean.FALSE, this);
        this.s = new l0(Boolean.FALSE, this);
        this.t = new l0(Boolean.FALSE, this);
        this.u = new l0(Boolean.FALSE, this);
        this.v = new l0(null, this);
        this.w = new l0(Boolean.FALSE, this);
        this.x = new l0(Boolean.FALSE, this);
        this.y = new l0(d.o, this);
        this.z = new l0(d.r, this);
        this.A = new l0(Boolean.TRUE, this);
        this.B = new l0(m.b, this);
        this.C = new l0(e.a, this);
        this.D = new l0(r.a, this);
        this.E = new l0(n.a, this);
        this.F = new l0(Boolean.FALSE, this);
        this.G = new l0(Boolean.FALSE, this);
        this.H = new l0(o.a, this);
        this.I = new l0(Boolean.FALSE, this);
        this.J = new l0(Boolean.FALSE, this);
        this.K = new l0(y.a, this);
        this.L = new l0(k.a, this);
        this.M = new l0(null, this);
        this.N = new l0(a.c, this);
        this.O = new l0(Boolean.FALSE, this);
        this.P = new l0(Boolean.TRUE, this);
        this.Q = new l0(Boolean.TRUE, this);
        this.R = new l0(Boolean.FALSE, this);
        this.S = new l0(Boolean.FALSE, this);
        this.T = new l0(Boolean.TRUE, this);
        this.U = new l0(Boolean.TRUE, this);
        this.V = new l0(Boolean.FALSE, this);
        this.W = new l0(Boolean.FALSE, this);
        this.X = new l0(Boolean.TRUE, this);
    }

    @Override  // sf.i
    public final void a() {
        this.F.setValue(this, j.Y[30], Boolean.TRUE);
    }

    @Override  // sf.i
    public final void b() {
        this.G.setValue(this, j.Y[0x1F], Boolean.TRUE);
    }

    @Override  // sf.i
    public final void c(c c0) {
        this.b.setValue(this, j.Y[0], c0);
    }

    @Override  // sf.i
    public final void d() {
        this.w.setValue(this, j.Y[21], Boolean.TRUE);
    }

    @Override  // sf.i
    public final void e(n n0) {
        this.E.setValue(this, j.Y[29], n0);
    }

    @Override  // sf.i
    public final void f() {
        this.f.setValue(this, j.Y[4], Boolean.TRUE);
    }

    @Override  // sf.i
    public final Set g() {
        return (Set)this.L.getValue(this, j.Y[36]);
    }

    @Override  // sf.i
    public final void h() {
        this.x.setValue(this, j.Y[22], Boolean.TRUE);
    }

    @Override  // sf.i
    public final void i() {
        this.h.setValue(this, j.Y[6], Boolean.TRUE);
    }

    @Override  // sf.i
    public final void j(Set set0) {
        q.g(set0, "<set-?>");
        this.e.setValue(this, j.Y[3], set0);
    }

    @Override  // sf.i
    public final void k(LinkedHashSet linkedHashSet0) {
        this.L.setValue(this, j.Y[36], linkedHashSet0);
    }

    @Override  // sf.i
    public final void l() {
        this.c.setValue(this, j.Y[1], Boolean.FALSE);
    }

    @Override  // sf.i
    public final void m() {
        this.D.setValue(this, j.Y[28], r.b);
    }

    public final boolean n() {
        return ((Boolean)this.h.getValue(this, j.Y[6])).booleanValue();
    }
}

