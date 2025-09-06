package com.facebook.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import androidx.fragment.app.I;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\u0007J\u001F\u0010\r\u001A\u00020\f2\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0006\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\r\u0010\u000ER(\u0010\u0010\u001A\u0004\u0018\u00010\u00022\b\u0010\u000F\u001A\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000E¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013R(\u0010\u0014\u001A\u0004\u0018\u00010\u00062\b\u0010\u000F\u001A\u0004\u0018\u00010\u00068\u0006@BX\u0086\u000E¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\u0017R\u0013\u0010\u001B\u001A\u0004\u0018\u00010\u00188F¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001A¨\u0006\u001C"}, d2 = {"Lcom/facebook/internal/FragmentWrapper;", "", "Landroidx/fragment/app/I;", "fragment", "<init>", "(Landroidx/fragment/app/I;)V", "Landroid/app/Fragment;", "(Landroid/app/Fragment;)V", "Landroid/content/Intent;", "intent", "", "requestCode", "Lie/H;", "startActivityForResult", "(Landroid/content/Intent;I)V", "<set-?>", "supportFragment", "Landroidx/fragment/app/I;", "getSupportFragment", "()Landroidx/fragment/app/I;", "nativeFragment", "Landroid/app/Fragment;", "getNativeFragment", "()Landroid/app/Fragment;", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "activity", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FragmentWrapper {
    @Nullable
    private Fragment nativeFragment;
    @Nullable
    private I supportFragment;

    public FragmentWrapper(@NotNull Fragment fragment0) {
        q.g(fragment0, "fragment");
        super();
        this.nativeFragment = fragment0;
    }

    public FragmentWrapper(@NotNull I i0) {
        q.g(i0, "fragment");
        super();
        this.supportFragment = i0;
    }

    @Nullable
    public final Activity getActivity() {
        I i0 = this.supportFragment;
        if(i0 != null) {
            return i0.getActivity();
        }
        return this.nativeFragment == null ? null : this.nativeFragment.getActivity();
    }

    @Nullable
    public final Fragment getNativeFragment() {
        return this.nativeFragment;
    }

    @Nullable
    public final I getSupportFragment() {
        return this.supportFragment;
    }

    public final void startActivityForResult(@Nullable Intent intent0, int v) {
        I i0 = this.supportFragment;
        if(i0 != null) {
            i0.startActivityForResult(intent0, v);
            return;
        }
        Fragment fragment0 = this.nativeFragment;
        if(fragment0 != null) {
            fragment0.startActivityForResult(intent0, v);
        }
    }
}

