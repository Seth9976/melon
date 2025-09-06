package com.facebook.login;

import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000E\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\u0013\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\u000F\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000F\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J?\u0010\u0016\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u000E\b\u0002\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0017\u001A\u00020\u00182\b\u0010\u0019\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001A\u001A\u00020\u001BHÖ\u0001J\t\u0010\u001C\u001A\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0017\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0017\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010¨\u0006\u001D"}, d2 = {"Lcom/facebook/login/LoginResult;", "", "accessToken", "Lcom/facebook/AccessToken;", "authenticationToken", "Lcom/facebook/AuthenticationToken;", "recentlyGrantedPermissions", "", "", "recentlyDeniedPermissions", "(Lcom/facebook/AccessToken;Lcom/facebook/AuthenticationToken;Ljava/util/Set;Ljava/util/Set;)V", "getAccessToken", "()Lcom/facebook/AccessToken;", "getAuthenticationToken", "()Lcom/facebook/AuthenticationToken;", "getRecentlyDeniedPermissions", "()Ljava/util/Set;", "getRecentlyGrantedPermissions", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class LoginResult {
    @NotNull
    private final AccessToken accessToken;
    @Nullable
    private final AuthenticationToken authenticationToken;
    @NotNull
    private final Set recentlyDeniedPermissions;
    @NotNull
    private final Set recentlyGrantedPermissions;

    public LoginResult(@NotNull AccessToken accessToken0, @Nullable AuthenticationToken authenticationToken0, @NotNull Set set0, @NotNull Set set1) {
        q.g(accessToken0, "accessToken");
        q.g(set0, "recentlyGrantedPermissions");
        q.g(set1, "recentlyDeniedPermissions");
        super();
        this.accessToken = accessToken0;
        this.authenticationToken = authenticationToken0;
        this.recentlyGrantedPermissions = set0;
        this.recentlyDeniedPermissions = set1;
    }

    public LoginResult(AccessToken accessToken0, AuthenticationToken authenticationToken0, Set set0, Set set1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 2) != 0) {
            authenticationToken0 = null;
        }
        this(accessToken0, authenticationToken0, set0, set1);
    }

    public LoginResult(@NotNull AccessToken accessToken0, @NotNull Set set0, @NotNull Set set1) {
        q.g(accessToken0, "accessToken");
        q.g(set0, "recentlyGrantedPermissions");
        q.g(set1, "recentlyDeniedPermissions");
        this(accessToken0, null, set0, set1, 2, null);
    }

    @NotNull
    public final AccessToken component1() {
        return this.accessToken;
    }

    @Nullable
    public final AuthenticationToken component2() {
        return this.authenticationToken;
    }

    @NotNull
    public final Set component3() {
        return this.recentlyGrantedPermissions;
    }

    @NotNull
    public final Set component4() {
        return this.recentlyDeniedPermissions;
    }

    @NotNull
    public final LoginResult copy(@NotNull AccessToken accessToken0, @Nullable AuthenticationToken authenticationToken0, @NotNull Set set0, @NotNull Set set1) {
        q.g(accessToken0, "accessToken");
        q.g(set0, "recentlyGrantedPermissions");
        q.g(set1, "recentlyDeniedPermissions");
        return new LoginResult(accessToken0, authenticationToken0, set0, set1);
    }

    public static LoginResult copy$default(LoginResult loginResult0, AccessToken accessToken0, AuthenticationToken authenticationToken0, Set set0, Set set1, int v, Object object0) {
        if((v & 1) != 0) {
            accessToken0 = loginResult0.accessToken;
        }
        if((v & 2) != 0) {
            authenticationToken0 = loginResult0.authenticationToken;
        }
        if((v & 4) != 0) {
            set0 = loginResult0.recentlyGrantedPermissions;
        }
        if((v & 8) != 0) {
            set1 = loginResult0.recentlyDeniedPermissions;
        }
        return loginResult0.copy(accessToken0, authenticationToken0, set0, set1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof LoginResult)) {
            return false;
        }
        if(!q.b(this.accessToken, ((LoginResult)object0).accessToken)) {
            return false;
        }
        if(!q.b(this.authenticationToken, ((LoginResult)object0).authenticationToken)) {
            return false;
        }
        return q.b(this.recentlyGrantedPermissions, ((LoginResult)object0).recentlyGrantedPermissions) ? q.b(this.recentlyDeniedPermissions, ((LoginResult)object0).recentlyDeniedPermissions) : false;
    }

    @NotNull
    public final AccessToken getAccessToken() {
        return this.accessToken;
    }

    @Nullable
    public final AuthenticationToken getAuthenticationToken() {
        return this.authenticationToken;
    }

    @NotNull
    public final Set getRecentlyDeniedPermissions() {
        return this.recentlyDeniedPermissions;
    }

    @NotNull
    public final Set getRecentlyGrantedPermissions() {
        return this.recentlyGrantedPermissions;
    }

    @Override
    public int hashCode() {
        int v = this.accessToken.hashCode();
        return this.authenticationToken == null ? this.recentlyDeniedPermissions.hashCode() + (this.recentlyGrantedPermissions.hashCode() + v * 961) * 0x1F : this.recentlyDeniedPermissions.hashCode() + (this.recentlyGrantedPermissions.hashCode() + (v * 0x1F + this.authenticationToken.hashCode()) * 0x1F) * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "LoginResult(accessToken=" + this.accessToken + ", authenticationToken=" + this.authenticationToken + ", recentlyGrantedPermissions=" + this.recentlyGrantedPermissions + ", recentlyDeniedPermissions=" + this.recentlyDeniedPermissions + ')';
    }
}

