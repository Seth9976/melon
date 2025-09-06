package androidx.car.app;

import I6.E0;
import I6.b0;
import I6.v0;
import androidx.car.app.navigation.model.NavigationTemplate;
import java.util.Objects;
import java.util.Set;

public class SessionInfo {
    private static final b0 CLUSTER_SUPPORTED_TEMPLATES_API_6 = null;
    private static final b0 CLUSTER_SUPPORTED_TEMPLATES_LESS_THAN_API_6 = null;
    public static final SessionInfo DEFAULT_SESSION_INFO = null;
    public static final int DISPLAY_TYPE_CLUSTER = 1;
    public static final int DISPLAY_TYPE_MAIN = 0;
    private static final char DIVIDER = '/';
    private final int mDisplayType;
    private final String mSessionId;

    static {
        SessionInfo.CLUSTER_SUPPORTED_TEMPLATES_API_6 = new E0(NavigationTemplate.class);
        SessionInfo.CLUSTER_SUPPORTED_TEMPLATES_LESS_THAN_API_6 = v0.j;
        SessionInfo.DEFAULT_SESSION_INFO = new SessionInfo(0, "main");
    }

    private SessionInfo() {
        this.mSessionId = "main";
        this.mDisplayType = 0;
    }

    public SessionInfo(int v, String s) {
        this.mDisplayType = v;
        this.mSessionId = s;
    }

    // 去混淆评级： 低(26)
    @Override
    public boolean equals(Object object0) {
        if(!(object0 instanceof SessionInfo)) {
            return false;
        }
        return object0 == this ? true : this.getDisplayType() == ((SessionInfo)object0).getDisplayType();
    }

    public int getDisplayType() {
        return this.mDisplayType;
    }

    public String getSessionId() [...] // 潜在的解密器

    public Set getSupportedTemplates(int v) {
        if(this.mDisplayType == 1) {
            return v < 6 ? SessionInfo.CLUSTER_SUPPORTED_TEMPLATES_LESS_THAN_API_6 : SessionInfo.CLUSTER_SUPPORTED_TEMPLATES_API_6;
        }
        return null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mSessionId, this.mDisplayType});
    }

    @Override
    public String toString() {
        return String.valueOf(this.mDisplayType) + '/' + this.mSessionId;
    }
}

