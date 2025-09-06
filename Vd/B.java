package vd;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.w;
import com.iloen.melon.adapters.PopupTextListAdapter.OnAddPositionSetListener;
import com.iloen.melon.popup.DjPlaylistAddPopup;
import com.iloen.melon.popup.NormalPlaylistAddPopup;
import com.iloen.melon.popup.PlaylistAddPopup;
import i.n.i.b.a.s.e.M3;
import kotlin.jvm.internal.q;

public final class b extends w {
    public final a a;
    public OnAddPositionSetListener b;

    public b(a a0) {
        this.a = a0;
    }

    @Override  // androidx.fragment.app.w
    public final Dialog onCreateDialog(Bundle bundle0) {
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null) {
            switch(this.a.ordinal()) {
                case 0: {
                    return new PlaylistAddPopup(fragmentActivity0, null, new String[]{this.getString(0x7F13002B), this.getString(0x7F130027), this.getString(0x7F130028)}, null);  // string:addposition_first "목록 맨 처음"
                }
                case 1: {
                    return new NormalPlaylistAddPopup(fragmentActivity0, null, new String[]{this.getString(0x7F13002B), this.getString(0x7F130028)}, null);  // string:addposition_first "목록 맨 처음"
                }
                case 2: {
                    return new DjPlaylistAddPopup(fragmentActivity0, null, new String[]{this.getString(0x7F13002B), this.getString(0x7F130028)}, null);  // string:addposition_first "목록 맨 처음"
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
        }
        throw new IllegalStateException("Activity cannot be null");
    }

    @Override  // androidx.fragment.app.w
    public final void onDismiss(DialogInterface dialogInterface0) {
        q.g(dialogInterface0, "dialog");
        super.onDismiss(dialogInterface0);
        OnAddPositionSetListener popupTextListAdapter$OnAddPositionSetListener0 = this.b;
        if(popupTextListAdapter$OnAddPositionSetListener0 != null) {
            popupTextListAdapter$OnAddPositionSetListener0.g();
        }
    }
}

