package n8;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.fragments.melontv.program.TvProgramHomeFragment;
import com.iloen.melon.net.v4x.response.MelonTvBroadcastListRes.RESPONSE.RECMPROGLIST;
import com.iloen.melon.utils.Navigator;

public final class b implements View.OnClickListener {
    public final g a;
    public final int b;

    public b(g g0, int v) {
        this.a = g0;
        this.b = v;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        Navigator.open(TvProgramHomeFragment.newInstance(((RECMPROGLIST)this.a.e.get(this.b)).progSeq));
    }
}

