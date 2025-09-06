package m8;

import com.iloen.melon.friend.FriendAddTaskController.AddFriendListener;
import com.iloen.melon.utils.Navigator;

public final class i implements AddFriendListener {
    @Override  // com.iloen.melon.friend.FriendAddTaskController$AddFriendListener
    public final void a(String s) {
        Navigator.openUserMain(s);
    }
}

