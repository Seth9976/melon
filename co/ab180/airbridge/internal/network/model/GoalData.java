package co.ab180.airbridge.internal.network.model;

import co.ab180.airbridge.internal.parser.RuleWith;
import co.ab180.airbridge.internal.parser.d;
import co.ab180.airbridge.internal.parser.e.l;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RuleWith(l.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\n\b\u0081\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u0002\u0012\u0014\b\u0002\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u0003\u0018\u00010\u0005\u0012\u0014\b\u0002\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u0003\u0018\u00010\u0005¢\u0006\u0004\b\u001B\u0010\u001CJ\u0012\u0010\u0003\u001A\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001C\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u0003\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001C\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u0003\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007JH\u0010\f\u001A\u00020\u00002\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u00022\u0014\b\u0002\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u0003\u0018\u00010\u00052\u0014\b\u0002\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u0003\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000E\u0010\u0004J\u0010\u0010\u0010\u001A\u00020\u000FHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001A\u0010\u0014\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001E\u0010\t\u001A\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001A\u0004\b\u0017\u0010\u0004R(\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u0003\u0018\u00010\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001A\u0004\b\u0019\u0010\u0007R(\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u0003\u0018\u00010\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000B\u0010\u0018\u001A\u0004\b\u001A\u0010\u0007¨\u0006\u001D"}, d2 = {"Lco/ab180/airbridge/internal/network/model/GoalData;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/Map;", "component3", "category", "semanticAttributes", "customAttributes", "copy", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)Lco/ab180/airbridge/internal/network/model/GoalData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCategory", "Ljava/util/Map;", "getSemanticAttributes", "getCustomAttributes", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class GoalData {
    @d("category")
    @Nullable
    private final String category;
    @d("customAttributes")
    @Nullable
    private final Map customAttributes;
    @d("semanticAttributes")
    @Nullable
    private final Map semanticAttributes;

    public GoalData() {
        this(null, null, null, 7, null);
    }

    public GoalData(@Nullable String s, @Nullable Map map0, @Nullable Map map1) {
        this.category = s;
        this.semanticAttributes = map0;
        this.customAttributes = map1;
    }

    public GoalData(String s, Map map0, Map map1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            s = null;
        }
        if((v & 2) != 0) {
            map0 = null;
        }
        if((v & 4) != 0) {
            map1 = null;
        }
        this(s, map0, map1);
    }

    @Nullable
    public final String component1() {
        return this.category;
    }

    @Nullable
    public final Map component2() {
        return this.semanticAttributes;
    }

    @Nullable
    public final Map component3() {
        return this.customAttributes;
    }

    @NotNull
    public final GoalData copy(@Nullable String s, @Nullable Map map0, @Nullable Map map1) {
        return new GoalData(s, map0, map1);
    }

    public static GoalData copy$default(GoalData goalData0, String s, Map map0, Map map1, int v, Object object0) {
        if((v & 1) != 0) {
            s = goalData0.category;
        }
        if((v & 2) != 0) {
            map0 = goalData0.semanticAttributes;
        }
        if((v & 4) != 0) {
            map1 = goalData0.customAttributes;
        }
        return goalData0.copy(s, map0, map1);
    }

    // 去混淆评级： 低(40)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof GoalData && q.b(this.category, ((GoalData)object0).category) && q.b(this.semanticAttributes, ((GoalData)object0).semanticAttributes) && q.b(this.customAttributes, ((GoalData)object0).customAttributes);
    }

    @Nullable
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    public final Map getCustomAttributes() {
        return this.customAttributes;
    }

    @Nullable
    public final Map getSemanticAttributes() {
        return this.semanticAttributes;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.category == null ? 0 : this.category.hashCode();
        int v2 = this.semanticAttributes == null ? 0 : this.semanticAttributes.hashCode();
        Map map0 = this.customAttributes;
        if(map0 != null) {
            v = map0.hashCode();
        }
        return (v1 * 0x1F + v2) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        return "GoalData(category=" + this.category + ", semanticAttributes=" + this.semanticAttributes + ", customAttributes=" + this.customAttributes + ")";
    }
}

