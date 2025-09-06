package X0;

import De.l;
import De.w;
import U4.x;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.J;
import kotlin.jvm.internal.t;
import we.k;
import we.n;

public abstract class u {
    public static final w[] a;

    static {
        Class class0 = u.class;
        t t0 = new t(class0, "stateDescription", "getStateDescription(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1);
        J j0 = I.a;
        l l0 = x.c(class0, "progressBarRangeInfo", "getProgressBarRangeInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", 1, j0);
        l l1 = x.c(class0, "paneTitle", "getPaneTitle(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1, j0);
        l l2 = x.c(class0, "liveRegion", "getLiveRegion(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1, j0);
        l l3 = x.c(class0, "focused", "getFocused(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1, j0);
        l l4 = x.c(class0, "isContainer", "isContainer(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1, j0);
        l l5 = x.c(class0, "isTraversalGroup", "isTraversalGroup(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1, j0);
        l l6 = x.c(class0, "contentType", "getContentType(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/autofill/ContentType;", 1, j0);
        l l7 = x.c(class0, "contentDataType", "getContentDataType(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/autofill/ContentDataType;", 1, j0);
        l l8 = x.c(class0, "traversalIndex", "getTraversalIndex(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)F", 1, j0);
        l l9 = x.c(class0, "horizontalScrollAxisRange", "getHorizontalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1, j0);
        l l10 = x.c(class0, "verticalScrollAxisRange", "getVerticalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1, j0);
        l l11 = x.c(class0, "role", "getRole(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1, j0);
        l l12 = x.c(class0, "testTag", "getTestTag(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1, j0);
        l l13 = x.c(class0, "textSubstitution", "getTextSubstitution(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1, j0);
        l l14 = x.c(class0, "isShowingTextSubstitution", "isShowingTextSubstitution(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1, j0);
        l l15 = x.c(class0, "inputText", "getInputText(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1, j0);
        l l16 = x.c(class0, "editableText", "getEditableText(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1, j0);
        l l17 = x.c(class0, "textSelectionRange", "getTextSelectionRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)J", 1, j0);
        l l18 = x.c(class0, "imeAction", "getImeAction(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1, j0);
        l l19 = x.c(class0, "selected", "getSelected(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1, j0);
        l l20 = x.c(class0, "collectionInfo", "getCollectionInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionInfo;", 1, j0);
        l l21 = x.c(class0, "collectionItemInfo", "getCollectionItemInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionItemInfo;", 1, j0);
        l l22 = x.c(class0, "toggleableState", "getToggleableState(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/state/ToggleableState;", 1, j0);
        l l23 = x.c(class0, "isEditable", "isEditable(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1, j0);
        l l24 = x.c(class0, "maxTextLength", "getMaxTextLength(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1, j0);
        l l25 = x.c(class0, "customActions", "getCustomActions(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/util/List;", 1, j0);
        u.a = new w[]{j0.e(t0), l0, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22, l23, l24, l25};
    }

    public static final X0.w a(String s) {
        X0.w w0 = new X0.w(s);
        w0.c = true;
        return w0;
    }

    public static final X0.w b(String s, n n0) {
        return new X0.w(s, true, n0);
    }

    public static final void c(X0.x x0) {
        ((X0.l)x0).g(s.i, H.a);
    }

    public static void d(X0.x x0, k k0) {
        a a0 = new a(null, k0);
        ((X0.l)x0).g(X0.k.a, a0);
    }

    public static final void e(X0.x x0) {
        ((X0.l)x0).g(s.h, H.a);
    }

    public static final void f(X0.x x0, b b0) {
        w w0 = u.a[21];
        s.f.a(x0, b0);
    }

    public static final void g(X0.x x0, c c0) {
        w w0 = u.a[22];
        s.g.a(x0, c0);
    }

    public static final void h(X0.x x0, String s) {
        List list0 = e.k.z(s);
        ((X0.l)x0).g(s.a, list0);
    }

    public static final void i(X0.x x0, List list0) {
        w w0 = u.a[26];
        X0.k.w.a(x0, list0);
    }

    public static final void j(X0.x x0, h h0) {
        w w0 = u.a[1];
        s.c.a(x0, h0);
    }

    public static final void k(X0.x x0, int v) {
        w w0 = u.a[12];
        i i0 = new i(v);
        s.v.a(x0, i0);
    }

    public static final void l(X0.x x0, boolean z) {
        w w0 = u.a[20];
        s.F.a(x0, Boolean.valueOf(z));
    }

    public static final void m(X0.x x0) {
        w w0 = u.a[6];
        s.m.a(x0, Boolean.TRUE);
    }
}

