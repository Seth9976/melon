package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Arrays;

public final class U0 {
    public int[] a;
    public ArrayList b;

    public final void a(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0) {
        if(this.b == null) {
            this.b = new ArrayList();
        }
        int v = this.b.size();
        for(int v1 = 0; v1 < v; ++v1) {
            StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem1 = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.b.get(v1);
            if(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem1.a == staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0.a) {
                this.b.remove(v1);
            }
            if(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem1.a >= staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0.a) {
                this.b.add(v1, staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0);
                return;
            }
        }
        this.b.add(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0);
    }

    public final void b() {
        int[] arr_v = this.a;
        if(arr_v != null) {
            Arrays.fill(arr_v, -1);
        }
        this.b = null;
    }

    public final void c(int v) {
        int[] arr_v = this.a;
        if(arr_v == null) {
            int[] arr_v1 = new int[Math.max(v, 10) + 1];
            this.a = arr_v1;
            Arrays.fill(arr_v1, -1);
            return;
        }
        if(v >= arr_v.length) {
            int v1;
            for(v1 = arr_v.length; v1 <= v; v1 *= 2) {
            }
            int[] arr_v2 = new int[v1];
            this.a = arr_v2;
            System.arraycopy(arr_v, 0, arr_v2, 0, arr_v.length);
            Arrays.fill(this.a, arr_v.length, this.a.length, -1);
        }
    }

    public final void d(int v) {
        ArrayList arrayList0 = this.b;
        if(arrayList0 != null) {
            for(int v1 = arrayList0.size() - 1; v1 >= 0; --v1) {
                if(((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.b.get(v1)).a >= v) {
                    this.b.remove(v1);
                }
            }
        }
        this.g(v);
    }

    public final StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem e(int v, int v1, int v2) {
        ArrayList arrayList0 = this.b;
        if(arrayList0 != null) {
            int v3 = arrayList0.size();
            for(int v4 = 0; v4 < v3; ++v4) {
                StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0 = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.b.get(v4);
                int v5 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0.a;
                if(v5 >= v1) {
                    break;
                }
                if(v5 >= v && (v2 == 0 || staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0.b == v2 || staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0.d)) {
                    return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0;
                }
            }
        }
        return null;
    }

    public final StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem f(int v) {
        ArrayList arrayList0 = this.b;
        if(arrayList0 != null) {
            for(int v1 = arrayList0.size() - 1; v1 >= 0; --v1) {
                StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0 = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.b.get(v1);
                if(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0.a == v) {
                    return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0;
                }
            }
        }
        return null;
    }

    public final int g(int v) {
        int v3;
        if(this.a == null || v >= this.a.length) {
            return -1;
        }
        if(this.b == null) {
            v3 = -1;
        }
        else {
            StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0 = this.f(v);
            if(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0 != null) {
                this.b.remove(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0);
            }
            int v1 = this.b.size();
            int v2;
            for(v2 = 0; true; ++v2) {
                if(v2 >= v1) {
                    v2 = -1;
                    break;
                }
                if(((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.b.get(v2)).a >= v) {
                    break;
                }
            }
            if(v2 == -1) {
                v3 = -1;
            }
            else {
                StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem1 = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.b.get(v2);
                this.b.remove(v2);
                v3 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem1.a;
            }
        }
        if(v3 == -1) {
            Arrays.fill(this.a, v, this.a.length, -1);
            return this.a.length;
        }
        int v4 = Math.min(v3 + 1, this.a.length);
        Arrays.fill(this.a, v, v4, -1);
        return v4;
    }

    public final void h(int v, int v1) {
        if(this.a != null && v < this.a.length) {
            int v2 = v + v1;
            this.c(v2);
            System.arraycopy(this.a, v, this.a, v2, this.a.length - v - v1);
            Arrays.fill(this.a, v, v2, -1);
            ArrayList arrayList0 = this.b;
            if(arrayList0 != null) {
                for(int v3 = arrayList0.size() - 1; v3 >= 0; --v3) {
                    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0 = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.b.get(v3);
                    int v4 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0.a;
                    if(v4 >= v) {
                        staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0.a = v4 + v1;
                    }
                }
            }
        }
    }

    public final void i(int v, int v1) {
        if(this.a != null && v < this.a.length) {
            int v2 = v + v1;
            this.c(v2);
            System.arraycopy(this.a, v2, this.a, v, this.a.length - v - v1);
            Arrays.fill(this.a, this.a.length - v1, this.a.length, -1);
            ArrayList arrayList0 = this.b;
            if(arrayList0 != null) {
                for(int v3 = arrayList0.size() - 1; v3 >= 0; --v3) {
                    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0 = (StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)this.b.get(v3);
                    int v4 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0.a;
                    if(v4 >= v) {
                        if(v4 < v2) {
                            this.b.remove(v3);
                        }
                        else {
                            staggeredGridLayoutManager$LazySpanLookup$FullSpanItem0.a = v4 - v1;
                        }
                    }
                }
            }
        }
    }
}

