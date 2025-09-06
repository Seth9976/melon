package jd;

import P0.r;
import T2.a;
import android.view.View.OnClickListener;
import android.view.View;
import androidx.lifecycle.f0;
import com.iloen.melon.net.v4x.response.StreamGetSongInfoRes.RESPONSE.ContentsInfo;
import com.iloen.melon.utils.network.NetUtils;
import com.melon.ui.q4;
import com.melon.ui.t4;
import java.util.ArrayList;
import java.util.ListIterator;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

public final class y1 implements View.OnClickListener {
    public final int a;
    public final F1 b;

    public y1(F1 f10, int v) {
        this.a = v;
        this.b = f10;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            Y1 y10 = (Y1)this.b.getViewModel();
            y10.getClass();
            if(!NetUtils.isConnected()) {
                y10.sendUiEvent(new q4(28, "", "", null, null));
                return;
            }
            ArrayList arrayList0 = new ArrayList();
            ListIterator listIterator0 = y10.d.listIterator();
            while(((r)listIterator0).hasNext()) {
                Object object0 = ((r)listIterator0).next();
                if(!((ContentsInfo)object0).isadult && ((ContentsInfo)object0).isservice) {
                    arrayList0.add(object0);
                }
            }
            if(y10.f.length() == 0) {
                y10.sendUiEvent(new t4(""));
                return;
            }
            if(arrayList0.size() < 2) {
                y10.sendUiEvent(new t4(""));
                return;
            }
            if(arrayList0.size() > 1000) {
                y10.sendUiEvent(new t4(""));
                return;
            }
            a a0 = f0.h(y10);
            R1 r10 = new R1(y10, arrayList0, null);
            BuildersKt__Builders_commonKt.launch$default(a0, y10.b, null, r10, 2, null);
            return;
        }
        this.b.sendUserEvent(M1.a);
    }
}

