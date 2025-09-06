package td;

import com.melon.ui.playermusic.PlayerMoreView;
import jd.e3;
import we.a;

public final class x1 implements Runnable {
    public final int a;
    public final PlayerMoreView b;
    public final a c;

    public x1(PlayerMoreView playerMoreView0, a a0, int v) {
        this.a = v;
        this.b = playerMoreView0;
        this.c = a0;
        super();
    }

    @Override
    public final void run() {
        a a0 = this.c;
        PlayerMoreView playerMoreView0 = this.b;
        if(this.a != 0) {
            playerMoreView0.post(new x1(playerMoreView0, new e3(playerMoreView0, 16), 0));
            a0.invoke();
            return;
        }
        PlayerMoreView.e(playerMoreView0, a0);
    }
}

