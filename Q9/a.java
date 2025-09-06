package Q9;

import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer;
import com.kakaoent.trevi.ad.databinding.TreviCashFriendsVideoFragmentBinding;
import com.kakaoent.trevi.ad.ui.fragment.CashFriendsVideoFragment;

public final class a implements MediaPlayer.OnInfoListener {
    public final CashFriendsVideoFragment a;
    public final TreviCashFriendsVideoFragmentBinding b;

    public a(CashFriendsVideoFragment cashFriendsVideoFragment0, TreviCashFriendsVideoFragmentBinding treviCashFriendsVideoFragmentBinding0) {
        this.a = cashFriendsVideoFragment0;
        this.b = treviCashFriendsVideoFragmentBinding0;
    }

    @Override  // android.media.MediaPlayer$OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer0, int v, int v1) {
        return CashFriendsVideoFragment.m(this.a, this.b, mediaPlayer0, v, v1);
    }
}

