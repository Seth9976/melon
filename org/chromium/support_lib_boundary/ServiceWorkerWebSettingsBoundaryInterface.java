package org.chromium.support_lib_boundary;

import java.util.Set;
import org.jspecify.annotations.NullMarked;

@NullMarked
public interface ServiceWorkerWebSettingsBoundaryInterface {
    boolean getAllowContentAccess();

    boolean getAllowFileAccess();

    boolean getBlockNetworkLoads();

    int getCacheMode();

    boolean getIncludeCookiesOnIntercept();

    Set getRequestedWithHeaderOriginAllowList();

    void setAllowContentAccess(boolean arg1);

    void setAllowFileAccess(boolean arg1);

    void setBlockNetworkLoads(boolean arg1);

    void setCacheMode(int arg1);

    void setIncludeCookiesOnIntercept(boolean arg1);

    void setRequestedWithHeaderOriginAllowList(Set arg1);
}

