package org.chromium.support_lib_boundary;

import java.lang.reflect.InvocationHandler;

public interface WebViewNavigationClientBoundaryInterface extends FeatureFlagHolderBoundaryInterface {
    void onFirstContentfulPaint(InvocationHandler arg1);

    void onNavigationCompleted(InvocationHandler arg1);

    void onNavigationRedirected(InvocationHandler arg1);

    void onNavigationStarted(InvocationHandler arg1);

    void onPageDOMContentLoadedEventFired(InvocationHandler arg1);

    void onPageDeleted(InvocationHandler arg1);

    void onPageLoadEventFired(InvocationHandler arg1);
}

