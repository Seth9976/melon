package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.drawable.Icon;
import android.widget.RemoteViews;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class j {
    public static final void a(@NotNull RemoteViews remoteViews0, int v, @NotNull String s, @Nullable BlendMode blendMode0) {
        q.g(remoteViews0, "rv");
        q.g(s, "method");
        remoteViews0.setBlendMode(v, s, blendMode0);
    }

    public static final void b(@NotNull RemoteViews remoteViews0, int v, @NotNull String s, int v1) {
        q.g(remoteViews0, "rv");
        q.g(s, "method");
        remoteViews0.setCharSequence(v, s, v1);
    }

    public static final void c(@NotNull RemoteViews remoteViews0, int v, @NotNull String s, int v1) {
        q.g(remoteViews0, "rv");
        q.g(s, "method");
        remoteViews0.setCharSequenceAttr(v, s, v1);
    }

    public static final void d(@NotNull RemoteViews remoteViews0, int v, @NotNull String s, int v1) {
        q.g(remoteViews0, "rv");
        q.g(s, "method");
        remoteViews0.setColor(v, s, v1);
    }

    public static final void e(@NotNull RemoteViews remoteViews0, int v, @NotNull String s, int v1) {
        q.g(remoteViews0, "rv");
        q.g(s, "method");
        remoteViews0.setColorAttr(v, s, v1);
    }

    public static final void f(@NotNull RemoteViews remoteViews0, int v, @NotNull String s, int v1, int v2) {
        q.g(remoteViews0, "rv");
        q.g(s, "method");
        remoteViews0.setColorInt(v, s, v1, v2);
    }

    public static final void g(@NotNull RemoteViews remoteViews0, int v, @NotNull String s, int v1) {
        q.g(remoteViews0, "rv");
        q.g(s, "method");
        remoteViews0.setColorStateList(v, s, v1);
    }

    public static final void h(@NotNull RemoteViews remoteViews0, int v, @NotNull String s, @Nullable ColorStateList colorStateList0) {
        q.g(remoteViews0, "rv");
        q.g(s, "method");
        remoteViews0.setColorStateList(v, s, colorStateList0);
    }

    public static final void i(@NotNull RemoteViews remoteViews0, int v, @NotNull String s, @Nullable ColorStateList colorStateList0, @Nullable ColorStateList colorStateList1) {
        q.g(remoteViews0, "rv");
        q.g(s, "method");
        remoteViews0.setColorStateList(v, s, colorStateList0, colorStateList1);
    }

    public static final void j(@NotNull RemoteViews remoteViews0, int v, @NotNull String s, int v1) {
        q.g(remoteViews0, "rv");
        q.g(s, "method");
        remoteViews0.setColorStateListAttr(v, s, v1);
    }

    public static final void k(@NotNull RemoteViews remoteViews0, int v, @NotNull String s, float f, int v1) {
        q.g(remoteViews0, "rv");
        q.g(s, "method");
        remoteViews0.setFloatDimen(v, s, f, v1);
    }

    public static final void l(@NotNull RemoteViews remoteViews0, int v, @NotNull String s, int v1) {
        q.g(remoteViews0, "rv");
        q.g(s, "method");
        remoteViews0.setFloatDimen(v, s, v1);
    }

    public static final void m(@NotNull RemoteViews remoteViews0, int v, @NotNull String s, int v1) {
        q.g(remoteViews0, "rv");
        q.g(s, "method");
        remoteViews0.setFloatDimenAttr(v, s, v1);
    }

    public static final void n(@NotNull RemoteViews remoteViews0, int v, @NotNull String s, @Nullable Icon icon0, @Nullable Icon icon1) {
        q.g(remoteViews0, "rv");
        q.g(s, "method");
        remoteViews0.setIcon(v, s, icon0, icon1);
    }

    public static final void o(@NotNull RemoteViews remoteViews0, int v, @NotNull String s, float f, int v1) {
        q.g(remoteViews0, "rv");
        q.g(s, "method");
        remoteViews0.setIntDimen(v, s, f, v1);
    }

    public static final void p(@NotNull RemoteViews remoteViews0, int v, @NotNull String s, int v1) {
        q.g(remoteViews0, "rv");
        q.g(s, "method");
        remoteViews0.setIntDimen(v, s, v1);
    }

    public static final void q(@NotNull RemoteViews remoteViews0, int v, @NotNull String s, int v1) {
        q.g(remoteViews0, "rv");
        q.g(s, "method");
        remoteViews0.setIntDimenAttr(v, s, v1);
    }
}

