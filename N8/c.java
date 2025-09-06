package n8;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.fragments.melontv.MelonTvProgramBaseFragment;
import com.iloen.melon.fragments.melontv.f;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.Navigator;
import com.melon.net.res.common.MvInfoBase;

public final class c implements View.OnClickListener {
    public final int a;
    public final MvInfoBase b;
    public final i c;

    public c(i i0, MvInfoBase mvInfoBase0, int v) {
        this.a = v;
        this.c = i0;
        this.b = mvInfoBase0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                Navigator.openMvInfo(this.b.mvId, this.c.getMenuId());
                return;
            }
            case 1: {
                Navigator.openMvInfo(this.b.mvId, this.c.getMenuId());
                return;
            }
            default: {
                i i0 = this.c;
                f f0 = i0.d;
                if(f0 != null) {
                    String s = i0.getMenuId();
                    Playable playable0 = Playable.from(this.b, s, null);
                    MelonTvProgramBaseFragment.d0(f0.a, playable0);
                }
            }
        }
    }
}

