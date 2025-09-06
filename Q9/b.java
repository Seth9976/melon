package Q9;

import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer;
import com.kakaoent.trevi.ad.databinding.TreviCashFriendsVideoFragmentBinding;
import com.kakaoent.trevi.ad.ui.fragment.CashFriendsVideoFragment;

public final class b implements MediaPlayer.OnCompletionListener {
    public final CashFriendsVideoFragment a;
    public final TreviCashFriendsVideoFragmentBinding b;

    public b(CashFriendsVideoFragment cashFriendsVideoFragment0, TreviCashFriendsVideoFragmentBinding treviCashFriendsVideoFragmentBinding0) {
        this.a = cashFriendsVideoFragment0;
        this.b = treviCashFriendsVideoFragmentBinding0;
    }

    @Override  // android.media.MediaPlayer$OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer0) {
        CashFriendsVideoFragment.l(this.a, this.b, mediaPlayer0);
    }
}

