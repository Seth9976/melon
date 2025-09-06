package X8;

import android.text.TextUtils;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.l1;
import com.iloen.melon.net.HttpResponse.Notification;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.MelonError;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.NotificationActionTypeHelper;
import com.iloen.melon.net.v6x.request.DeleteFriendReq;
import com.iloen.melon.net.v6x.request.InsertFriendReq;
import com.iloen.melon.net.v6x.response.DeleteFriendRes;
import com.iloen.melon.net.v6x.response.InsertFriendRes;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import k8.Y;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import x8.f;

public final class b extends f {
    public a a;
    public String b;
    public String c;
    public boolean d;
    public boolean e;

    @Override  // x8.f
    public final Object backgroundWork(Object object0, Continuation continuation0) {
        Void void0 = (Void)object0;
        Companion logU$Companion0 = LogU.Companion;
        Y.w("backgroundWork() fMemberKey : ", this.b, logU$Companion0, "FriendAddOrDeleteAsyncTask");
        Y.w("backgroundWork() menuId : ", this.c, logU$Companion0, "FriendAddOrDeleteAsyncTask");
        l1.B("backgroundWork() isAdd : ", this.d, logU$Companion0, "FriendAddOrDeleteAsyncTask");
        boolean z = false;
        String s = null;
        if(this.d) {
            RequestFuture requestFuture0 = RequestFuture.newFuture();
            InsertFriendReq insertFriendReq0 = new InsertFriendReq(Y.a(MelonAppBase.Companion), this.b, this.c);
            try {
                HttpResponse httpResponse0 = RequestBuilder.newInstance(insertFriendReq0).tag("FriendAddOrDeleteAsyncTask").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.InsertFriendRes");
                if(((InsertFriendRes)httpResponse0).isSuccessful()) {
                    logU$Companion0.d("FriendAddOrDeleteAsyncTask", "backgroundWork() add");
                    return null;
                }
                VolleyError volleyError1 = MelonError.from(((InsertFriendRes)httpResponse0));
                if(volleyError1 != null) {
                    s = volleyError1.getMessage();
                }
                Notification httpResponse$Notification0 = ((InsertFriendRes)httpResponse0).notification;
                if(httpResponse$Notification0 != null) {
                    z = NotificationActionTypeHelper.hasInteractionNotification(httpResponse$Notification0);
                }
                this.e = z;
                return s;
            }
            catch(VolleyError volleyError0) {
                return volleyError0.getMessage();
            }
        }
        RequestFuture requestFuture1 = RequestFuture.newFuture();
        DeleteFriendReq deleteFriendReq0 = new DeleteFriendReq(Y.a(MelonAppBase.Companion), this.b, this.c);
        try {
            HttpResponse httpResponse1 = RequestBuilder.newInstance(deleteFriendReq0).tag("FriendAddOrDeleteAsyncTask").listener(requestFuture1).errorListener(requestFuture1).requestSync(requestFuture1);
            q.e(httpResponse1, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.DeleteFriendRes");
            if(((DeleteFriendRes)httpResponse1).isSuccessful()) {
                logU$Companion0.d("FriendAddOrDeleteAsyncTask", "doInBackground() delete");
                return null;
            }
            VolleyError volleyError3 = MelonError.from(((DeleteFriendRes)httpResponse1));
            if(volleyError3 != null) {
                s = volleyError3.getMessage();
            }
            Notification httpResponse$Notification1 = ((DeleteFriendRes)httpResponse1).notification;
            if(httpResponse$Notification1 != null) {
                z = NotificationActionTypeHelper.hasInteractionNotification(httpResponse$Notification1);
            }
            this.e = z;
            return s;
        }
        catch(VolleyError volleyError2) {
            return volleyError2.getMessage();
        }
    }

    @Override  // x8.f
    public final void postTask(Object object0) {
        if(!TextUtils.isEmpty(((String)object0)) && !this.e) {
            ToastManager.show(((String)object0));
        }
        a a0 = this.a;
        if(a0 != null) {
            a0.onJobComplete(((String)object0));
        }
    }
}

