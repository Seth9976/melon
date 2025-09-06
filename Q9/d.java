package Q9;

import com.kakaoent.trevi.ad.databinding.TreviCashFriendsVideoFragmentBinding;
import com.kakaoent.trevi.ad.ui.fragment.CashFriendsVideoFragment;

public final class d implements Runnable {
    public final CashFriendsVideoFragment a;
    public final double b;
    public final TreviCashFriendsVideoFragmentBinding c;

    public d(CashFriendsVideoFragment cashFriendsVideoFragment0, double f, TreviCashFriendsVideoFragmentBinding treviCashFriendsVideoFragmentBinding0) {
        this.a = cashFriendsVideoFragment0;
        this.b = f;
        this.c = treviCashFriendsVideoFragmentBinding0;
    }

    @Override
    public final void run() {
        CashFriendsVideoFragment.o(this.a, this.b, this.c);
    }
}

