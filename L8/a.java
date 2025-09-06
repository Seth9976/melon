package l8;

import android.content.Intent;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.iloen.melon.custom.ToReceiverView.Receiver;
import com.iloen.melon.utils.log.LogU;
import e1.u;
import java.util.ArrayList;
import va.e0;
import va.o;

public final class a implements b {
    public final c a;

    public a(c c0) {
        this.a = c0;
    }

    public final boolean a(FragmentActivity fragmentActivity0, Receiver toReceiverView$Receiver0) {
        c c0 = this.a;
        LogU.d("AddedFriendListHelper", "onAdd() : " + toReceiverView$Receiver0 + ", size : " + c0.a.size() + ", max : " + c0.d);
        boolean z = u.v(((e0)o.a()).j()).equals(toReceiverView$Receiver0.a);
        com.melon.ui.popup.b b0 = com.melon.ui.popup.b.a;
        if(z) {
            b0.c(((AppCompatActivity)fragmentActivity0).getSupportFragmentManager(), "안내", "회원 본인을 수신자로 선택할 수 없습니다.");
            return false;
        }
        if(c0.a.contains(toReceiverView$Receiver0)) {
            b0.c(((AppCompatActivity)fragmentActivity0).getSupportFragmentManager(), "안내", "이미 추가된 친구 입니다.");
            return false;
        }
        if(c0.a.size() >= c0.d) {
            b0.c(((AppCompatActivity)fragmentActivity0).getSupportFragmentManager(), "안내", fragmentActivity0.getString(0x7F1300DE, new Object[]{c0.d}));  // string:alert_max_msg_user_count "한번에 최대 %d명에게만 보낼 수 있습니다."
            return false;
        }
        c0.b.add(toReceiverView$Receiver0);
        return c0.a.add(toReceiverView$Receiver0);
    }

    public final boolean b(Receiver toReceiverView$Receiver0) {
        LogU.d("AddedFriendListHelper", "onRemove() : " + toReceiverView$Receiver0);
        this.a.b.remove(toReceiverView$Receiver0);
        return this.a.a.remove(toReceiverView$Receiver0);
    }

    public final void c(FragmentActivity fragmentActivity0) {
        if(fragmentActivity0 == null) {
            LogU.e("AddedFriendListHelper", "sendActivityResult() invalid activity");
        }
        ArrayList arrayList0 = this.a.a;
        Intent intent0 = new Intent();
        intent0.putParcelableArrayListExtra("argSearchResultValues", arrayList0);
        intent0.putExtra("argAttachedSharable", ((Parcelable)this.a.c));
        if(fragmentActivity0.getParent() == null) {
            fragmentActivity0.setResult(-1, intent0);
        }
        else {
            fragmentActivity0.getParent().setResult(-1, intent0);
        }
        fragmentActivity0.finish();
    }
}

