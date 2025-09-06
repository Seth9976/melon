package z9;

import com.iloen.melon.userstore.utils.UserDataSyncTask;
import kotlin.jvm.internal.q;

public final class j extends k {
    public final UserDataSyncTask a;

    public j(UserDataSyncTask userDataSyncTask0) {
        this.a = userDataSyncTask0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof j ? q.b(this.a, ((j)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Success(syncTask=" + this.a + ")";
    }
}

