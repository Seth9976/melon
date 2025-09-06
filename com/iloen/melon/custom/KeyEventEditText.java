package com.iloen.melon.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;
import androidx.lifecycle.b;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@SuppressLint({"AppCompatCustomView"})
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001:\u0001\fB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001B\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u0004\u0010\u000BJ\u0017\u0010\u000F\u001A\u00020\u000E2\b\u0010\r\u001A\u0004\u0018\u00010\f¢\u0006\u0004\b\u000F\u0010\u0010J\'\u0010\u000F\u001A\u00020\u000E2\u0018\u0010\u0013\u001A\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000E0\u0011¢\u0006\u0004\b\u000F\u0010\u0014R$\u0010\r\u001A\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u0010¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/custom/KeyEventEditText;", "Landroid/widget/EditText;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/iloen/melon/custom/b0;", "onKeyListener", "Lie/H;", "setOnKeyEventListener", "(Lcom/iloen/melon/custom/b0;)V", "Lkotlin/Function2;", "Landroid/view/KeyEvent;", "listener", "(Lwe/n;)V", "a", "Lcom/iloen/melon/custom/b0;", "getOnKeyListener", "()Lcom/iloen/melon/custom/b0;", "setOnKeyListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class KeyEventEditText extends EditText {
    public b0 a;

    public KeyEventEditText(@NotNull Context context0) {
        q.g(context0, "context");
        super(context0);
    }

    public KeyEventEditText(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        super(context0, attributeSet0);
    }

    public KeyEventEditText(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        super(context0, attributeSet0, v);
    }

    @Nullable
    public final b0 getOnKeyListener() {
        return this.a;
    }

    @Override  // android.widget.TextView
    public final boolean onKeyPreIme(int v, KeyEvent keyEvent0) {
        q.g(keyEvent0, "event");
        b0 b00 = this.a;
        if(b00 != null) {
            ((n)((b)b00).b).invoke(v, keyEvent0);
        }
        return false;
    }

    public final void setOnKeyEventListener(@Nullable b0 b00) {
        this.a = b00;
    }

    public final void setOnKeyEventListener(@NotNull n n0) {
        q.g(n0, "listener");
        this.a = new b(n0, 27);
    }

    public final void setOnKeyListener(@Nullable b0 b00) {
        this.a = b00;
    }
}

