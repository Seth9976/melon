package com.facebook.gamingservices;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.bolts.TaskCompletionSource;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000E\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001E\u0010\u0003\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tJ\u001E\u0010\u0003\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\t¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/TournamentUpdater;", "", "()V", "update", "Lcom/facebook/bolts/TaskCompletionSource;", "", "tournament", "Lcom/facebook/gamingservices/Tournament;", "score", "", "identifier", "", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class TournamentUpdater {
    @Nullable
    public final TaskCompletionSource update(@NotNull Tournament tournament0, @NotNull Number number0) {
        q.g(tournament0, "tournament");
        q.g(number0, "score");
        return this.update(tournament0.identifier, number0);
    }

    @Nullable
    public final TaskCompletionSource update(@NotNull String s, @NotNull Number number0) {
        q.g(s, "identifier");
        q.g(number0, "score");
        AccessToken accessToken0 = AccessToken.Companion.getCurrentAccessToken();
        if(accessToken0 == null || accessToken0.isExpired()) {
            throw new FacebookException("Attempted to fetch tournament with an invalid access token");
        }
        if(accessToken0.getGraphDomain() == null || !"gaming".equals(accessToken0.getGraphDomain())) {
            throw new FacebookException("User is not using gaming login");
        }
        TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
        Bundle bundle0 = new Bundle();
        bundle0.putInt("score", number0.intValue());
        b b0 = new b(taskCompletionSource0, 1);
        new GraphRequest(accessToken0, s + "/update_score", bundle0, HttpMethod.POST, b0, null, 0x20, null).executeAsync();
        return taskCompletionSource0;
    }

    private static final void update$lambda$0(TaskCompletionSource taskCompletionSource0, GraphResponse graphResponse0) {
        q.g(taskCompletionSource0, "$task");
        q.g(graphResponse0, "response");
        String s = null;
        if(graphResponse0.getError() != null) {
            FacebookRequestError facebookRequestError0 = graphResponse0.getError();
            if((facebookRequestError0 == null ? null : facebookRequestError0.getException()) != null) {
                FacebookRequestError facebookRequestError1 = graphResponse0.getError();
                if(facebookRequestError1 != null) {
                    s = facebookRequestError1.getException();
                }
                taskCompletionSource0.setError(((Exception)s));
                return;
            }
            taskCompletionSource0.setError(new GraphAPIException("Graph API Error"));
            return;
        }
        JSONObject jSONObject0 = graphResponse0.getJSONObject();
        if(jSONObject0 != null) {
            s = jSONObject0.optString("success");
        }
        if(s != null && s.length() != 0) {
            taskCompletionSource0.setResult(Boolean.valueOf(s.equals("true")));
            return;
        }
        taskCompletionSource0.setError(new GraphAPIException("Graph API Error"));
    }
}

