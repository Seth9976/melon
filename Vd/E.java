package vd;

import De.I;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.custom.MelonTextView;
import com.melon.ui.a0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lvd/e;", "Lcom/melon/ui/a0;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class e extends a0 {
    public boolean e;
    public String f;

    public e() {
        this.e = true;
    }

    @Override  // com.melon.ui.a0
    public final boolean getShouldRetain() {
        return this.e;
    }

    @Override  // com.melon.ui.a0
    public final Dialog onCreateDialog(Bundle bundle0) {
        Dialog dialog0 = new d(this.requireContext(), 0x7F1401AB);  // 初始化器: Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V
        dialog0.setCanceledOnTouchOutside(false);
        return dialog0;
    }

    @Override  // androidx.fragment.app.I
    public final View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D0059, viewGroup0, false);  // layout:blocking_progress_dialog_layout
        MelonTextView melonTextView0 = (MelonTextView)I.C(view0, 0x7F0A07FB);  // id:message
        if(melonTextView0 == null) {
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(0x7F0A07FB));  // id:message
        }
        String s = this.f;
        if(s == null) {
            s = this.getString(0x7F130618);  // string:melon_please_wait "잠시만 기다려주세요…"
            q.f(s, "getString(...)");
        }
        melonTextView0.setText(s);
        q.f(((ConstraintLayout)view0), "getRoot(...)");
        return (ConstraintLayout)view0;
    }

    @Override  // com.melon.ui.a0
    public final void setShouldRetain(boolean z) {
        this.e = z;
    }
}

