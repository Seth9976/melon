package com.google.protobuf;

public final class d2 implements j2 {
    public j2[] a;

    @Override  // com.google.protobuf.j2
    public final D2 a(Class class0) {
        j2[] arr_j2 = this.a;
        for(int v = 0; v < arr_j2.length; ++v) {
            j2 j20 = arr_j2[v];
            if(j20.b(class0)) {
                return j20.a(class0);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: " + class0.getName());
    }

    @Override  // com.google.protobuf.j2
    public final boolean b(Class class0) {
        j2[] arr_j2 = this.a;
        for(int v = 0; v < arr_j2.length; ++v) {
            if(arr_j2[v].b(class0)) {
                return true;
            }
        }
        return false;
    }
}

