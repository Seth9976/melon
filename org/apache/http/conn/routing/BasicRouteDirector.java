package org.apache.http.conn.routing;

@Deprecated
public class BasicRouteDirector implements HttpRouteDirector {
    public BasicRouteDirector() {
        throw new RuntimeException("Stub!");
    }

    public int directStep(RouteInfo routeInfo0, RouteInfo routeInfo1) {
        throw new RuntimeException("Stub!");
    }

    public int firstStep(RouteInfo routeInfo0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.conn.routing.HttpRouteDirector
    public int nextStep(RouteInfo routeInfo0, RouteInfo routeInfo1) {
        throw new RuntimeException("Stub!");
    }

    public int proxiedStep(RouteInfo routeInfo0, RouteInfo routeInfo1) {
        throw new RuntimeException("Stub!");
    }
}

