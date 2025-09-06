package X8;

import com.iloen.melon.friend.FriendAddTaskController;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class d extends i implements n {
    public boolean r;
    public final FriendAddTaskController w;

    public d(FriendAddTaskController friendAddTaskController0, Continuation continuation0) {
        this.w = friendAddTaskController0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new d(this.w, continuation0);
        continuation1.r = ((Boolean)object0).booleanValue();
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Boolean)object0).booleanValue();
        ((d)this.create(((Boolean)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        boolean z = this.r;
        d5.n.D(object0);
        LogU logU0 = new LogU("FriendAddTaskController");
        logU0.setCategory(Category.Login);
        logU0.setUseThreadInfo(true);
        LogU.debug$default(logU0, "FriendAddTaskController - isLogin: " + z, null, false, 6, null);
        if(z) {
            FriendAddTaskController friendAddTaskController0 = this.w;
            if(!"F".equals(FriendAddTaskController.access$getMMode$p(friendAddTaskController0))) {
                FriendAddTaskController.access$addFriend(friendAddTaskController0);
            }
        }
        return H.a;
    }
}

