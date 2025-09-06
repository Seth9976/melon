package com.facebook.gamingservices;

import android.os.Bundle;
import com.facebook.AccessToken.Companion;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.bolts.TaskCompletionSource;
import com.google.gson.n;
import com.google.gson.o;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¨\u0006\u0007"}, d2 = {"Lcom/facebook/gamingservices/TournamentFetcher;", "", "()V", "fetchTournaments", "Lcom/facebook/bolts/TaskCompletionSource;", "", "Lcom/facebook/gamingservices/Tournament;", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class TournamentFetcher {
    @NotNull
    public final TaskCompletionSource fetchTournaments() {
        TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
        Bundle bundle0 = new Bundle();
        Companion accessToken$Companion0 = AccessToken.Companion;
        AccessToken accessToken0 = accessToken$Companion0.getCurrentAccessToken();
        if(accessToken0 == null || accessToken0.isExpired()) {
            throw new FacebookException("Attempted to fetch tournament with an invalid access token");
        }
        if(accessToken0.getGraphDomain() == null || !"gaming".equals(accessToken0.getGraphDomain())) {
            throw new FacebookException("User is not using gaming login");
        }
        AccessToken accessToken1 = accessToken$Companion0.getCurrentAccessToken();
        b b0 = new b(taskCompletionSource0, 0);
        GraphRequest graphRequest0 = new GraphRequest(accessToken1, "me/tournaments", bundle0, HttpMethod.GET, b0, null, 0x20, null);
        graphRequest0.setParameters(bundle0);
        graphRequest0.executeAsync();
        return taskCompletionSource0;
    }

    private static final void fetchTournaments$lambda$1(TaskCompletionSource taskCompletionSource0, GraphResponse graphResponse0) {
        q.g(taskCompletionSource0, "$task");
        q.g(graphResponse0, "response");
        if(graphResponse0.getError() != null) {
            FacebookRequestError facebookRequestError0 = graphResponse0.getError();
            FacebookException facebookException0 = null;
            if((facebookRequestError0 == null ? null : facebookRequestError0.getException()) != null) {
                FacebookRequestError facebookRequestError1 = graphResponse0.getError();
                if(facebookRequestError1 != null) {
                    facebookException0 = facebookRequestError1.getException();
                }
                taskCompletionSource0.setError(facebookException0);
                return;
            }
            taskCompletionSource0.setError(new GraphAPIException("Graph API Error"));
            return;
        }
        try {
            JSONObject jSONObject0 = graphResponse0.getJSONObject();
            if(jSONObject0 == null) {
                taskCompletionSource0.setError(new GraphAPIException("Failed to get response"));
                return;
            }
            JSONArray jSONArray0 = jSONObject0.getJSONArray("data");
            if(jSONArray0.length() < 1) {
                taskCompletionSource0.setError(new GraphAPIException(String.format(Locale.ROOT, "No tournament found", Arrays.copyOf(new Object[]{jSONArray0.length(), 1}, 2))));
                return;
            }
            n n0 = new o().a();
            String s = jSONArray0.toString();
            q.f(s, "data.toString()");
            Object object0 = n0.e(s, Tournament[].class);
            q.f(object0, "gson.fromJson(dataString…<Tournament>::class.java)");
            taskCompletionSource0.setResult(je.n.z0(((Object[])object0)));
            return;
        }
        catch(JSONException jSONException0) {
        }
        taskCompletionSource0.setError(jSONException0);
    }
}

