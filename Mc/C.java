package Mc;

import Nc.K;
import android.os.Bundle;
import androidx.fragment.app.I;
import androidx.viewpager2.adapter.h;
import com.iloen.melon.fragments.genre.GenreFragmentFactory;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.musicwave.ChannelInfoData;
import java.util.List;
import jd.A;
import kotlin.jvm.internal.q;

public final class c extends h {
    public final int a;
    public final Object b;

    public c(I i0, List list0, int v) {
        this.a = v;
        super(i0);
        this.b = list0;
    }

    @Override  // androidx.viewpager2.adapter.h
    public final I createFragment(int v) {
        Object object0 = this.b;
        if(this.a != 0) {
            ChannelInfoData channelInfoData0 = (ChannelInfoData)((List)object0).get(v);
            q.g(channelInfoData0, "channelInfoData");
            I i0 = new A();
            LogU.debug$default(A.k, "chatId " + channelInfoData0.a, null, false, 6, null);
            LogU.debug$default(A.k, "chat type " + channelInfoData0.f, null, false, 6, null);
            Bundle bundle0 = new Bundle();
            bundle0.putParcelable("channelInfoData", channelInfoData0);
            bundle0.putInt("channelPosition", v);
            i0.setArguments(bundle0);
            return i0;
        }
        K k0 = (K)((List)object0).get(v);
        I i1 = GenreFragmentFactory.create(k0.a, k0.b, k0.c);
        q.d(i1);
        return i1;
    }

    @Override  // androidx.recyclerview.widget.j0
    public final int getItemCount() {
        return ((List)this.b).size();
    }
}

