package com.iloen.melon.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.iloen.melon.utils.ui.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\'\b\u0007\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000E\u001A\u00020\r2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016¢\u0006\u0004\b\u000E\u0010\u000FR0\u0010\u0018\u001A\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r\u0018\u00010\u00108\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/custom/MelonConnectButton;", "Landroid/widget/RelativeLayout;", "", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "connectName", "Lie/H;", "setConnect", "(Ljava/lang/String;)V", "Lkotlin/Function1;", "", "c", "Lwe/k;", "getStateChangeListener", "()Lwe/k;", "setStateChangeListener", "(Lwe/k;)V", "stateChangeListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonConnectButton extends RelativeLayout {
    public final ImageView a;
    public final TextView b;
    public k c;

    public MelonConnectButton(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null, 6, 0);
    }

    public MelonConnectButton(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        this(context0, attributeSet0, 4, 0);
    }

    public MelonConnectButton(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        super(context0, attributeSet0, v);
        View.inflate(context0, 0x7F0D01A8, this);  // layout:connect_button
        View view0 = this.findViewById(0x7F0A018B);  // id:btn_player_connect
        q.f(view0, "findViewById(...)");
        this.a = (ImageView)view0;
        View view1 = this.findViewById(0x7F0A0925);  // id:player_connect_text
        q.f(view1, "findViewById(...)");
        this.b = (TextView)view1;
    }

    public MelonConnectButton(Context context0, AttributeSet attributeSet0, int v, int v1) {
        if((v & 2) != 0) {
            attributeSet0 = null;
        }
        this(context0, attributeSet0, 0);
    }

    @Nullable
    public final k getStateChangeListener() {
        return this.c;
    }

    public void setConnect(@Nullable String s) {
        this.a.setVisibility(8);
        this.b.setVisibility(0);
        this.b.setText(s);
        ViewUtils.setContentDescriptionWithButtonClassName(this, this.b.getText());
        k k0 = this.c;
        if(k0 != null) {
            k0.invoke(Boolean.TRUE);
        }
    }

    public final void setStateChangeListener(@Nullable k k0) {
        this.c = k0;
    }
}

