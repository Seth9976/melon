package m8;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.l0;
import com.melon.ui.P0;
import com.melon.ui.popup.b;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class i0 extends i implements n {
    public final Activity r;

    public i0(Activity activity0, Continuation continuation0) {
        this.r = activity0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new i0(this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((i0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        Activity activity0 = this.r;
        l0 l00 = null;
        AppCompatActivity appCompatActivity0 = activity0 instanceof AppCompatActivity ? ((AppCompatActivity)activity0) : null;
        if(appCompatActivity0 != null) {
            l00 = appCompatActivity0.getSupportFragmentManager();
        }
        b.x(l00, "안내", "날씨 정보 확인을 위한 위치기반서비스 이용약관에 동의하시겠습니까?\n\n해당 정보는 날씨, 지역에 따른 추천 선곡에 활용됩니다", false, false, null, null, new P0(activity0, 2), null, new P0(activity0, 3), null, 0xAF8);
        return H.a;
    }
}

