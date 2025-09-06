package X8;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.MyMusicFriendInsertPhoneFriendReq.Params;
import com.iloen.melon.net.v4x.request.MyMusicFriendInsertPhoneFriendReq;
import com.iloen.melon.net.v4x.response.MyMusicFriendInsertPhoneFriendRes;
import com.iloen.melon.utils.log.LogU;
import kotlin.coroutines.Continuation;

public final class f extends x8.f {
    public String a;
    public String b;
    public String c;
    public String d;

    @Override  // x8.f
    public final Object backgroundWork(Object object0, Continuation continuation0) {
        String s;
        Void void0 = (Void)object0;
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        Params myMusicFriendInsertPhoneFriendReq$Params0 = new Params();
        myMusicFriendInsertPhoneFriendReq$Params0.phoneNumber = this.a;
        myMusicFriendInsertPhoneFriendReq$Params0.invtFrendName = this.b;
        myMusicFriendInsertPhoneFriendReq$Params0.inviteUserId = this.c;
        myMusicFriendInsertPhoneFriendReq$Params0.reInviteYn = this.d;
        MyMusicFriendInsertPhoneFriendReq myMusicFriendInsertPhoneFriendReq0 = new MyMusicFriendInsertPhoneFriendReq(MelonAppBase.instance.getContext(), myMusicFriendInsertPhoneFriendReq$Params0);
        try {
            s = ((MyMusicFriendInsertPhoneFriendRes)RequestBuilder.newInstance(myMusicFriendInsertPhoneFriendReq0).tag("PhoneFriendAddAsyncTask").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0)).isSuccessful() ? "" : "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요.";
        }
        catch(VolleyError volleyError0) {
            s = volleyError0.getMessage();
        }
        LogU.w("PhoneFriendAddAsyncTask", "doInBackground() errorMsg : " + s);
        return null;
    }
}

