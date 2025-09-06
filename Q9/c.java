package Q9;

import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer;
import android.widget.VideoView;
import com.kakaoent.trevi.ad.databinding.TreviCashFriendsVideoFragmentBinding;
import com.kakaoent.trevi.ad.ui.fragment.CashFriendsVideoFragment;

public final class c implements MediaPlayer.OnPreparedListener {
    public final CashFriendsVideoFragment a;
    public final VideoView b;
    public final TreviCashFriendsVideoFragmentBinding c;

    public c(CashFriendsVideoFragment cashFriendsVideoFragment0, VideoView videoView0, TreviCashFriendsVideoFragmentBinding treviCashFriendsVideoFragmentBinding0) {
        this.a = cashFriendsVideoFragment0;
        this.b = videoView0;
        this.c = treviCashFriendsVideoFragmentBinding0;
    }

    @Override  // android.media.MediaPlayer$OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer0) {
        CashFriendsVideoFragment.n(this.a, this.b, this.c, mediaPlayer0);
    }
}

