package androidx.window.embedding;

import Tf.o;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import androidx.window.R.styleable;
import java.util.HashSet;
import java.util.Set;
import je.y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\t\u001A\u00020\b*\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0007\u001A\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001F\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001F\u0010\u0013\u001A\u00020\u00122\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001F\u0010\u0016\u001A\u00020\u00152\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\rH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001F\u0010\u0019\u001A\u00020\u00182\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\rH\u0002¢\u0006\u0004\b\u0019\u0010\u001AJ\u001F\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\rH\u0002¢\u0006\u0004\b\u001C\u0010\u001DJ\u001F\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\rH\u0002¢\u0006\u0004\b\u001F\u0010 J!\u0010&\u001A\u00020%2\u0006\u0010\"\u001A\u00020!2\b\u0010$\u001A\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b&\u0010\'J)\u0010-\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010*2\u0006\u0010\f\u001A\u00020\u000B2\b\b\u0001\u0010)\u001A\u00020(H\u0000¢\u0006\u0004\b+\u0010,¨\u0006."}, d2 = {"Landroidx/window/embedding/RuleParser;", "", "<init>", "()V", "Ljava/util/HashSet;", "Landroidx/window/embedding/EmbeddingRule;", "Lkotlin/collections/HashSet;", "rule", "Lie/H;", "addRuleWithDuplicatedTagCheck", "(Ljava/util/HashSet;Landroidx/window/embedding/EmbeddingRule;)V", "Landroid/content/Context;", "context", "Landroid/content/res/XmlResourceParser;", "parser", "Landroidx/window/embedding/SplitPairRule;", "parseSplitPairRule", "(Landroid/content/Context;Landroid/content/res/XmlResourceParser;)Landroidx/window/embedding/SplitPairRule;", "Landroidx/window/embedding/SplitPlaceholderRule;", "parseSplitPlaceholderRule", "(Landroid/content/Context;Landroid/content/res/XmlResourceParser;)Landroidx/window/embedding/SplitPlaceholderRule;", "Landroidx/window/embedding/SplitPairFilter;", "parseSplitPairFilter", "(Landroid/content/Context;Landroid/content/res/XmlResourceParser;)Landroidx/window/embedding/SplitPairFilter;", "Landroidx/window/embedding/ActivityRule;", "parseActivityRule", "(Landroid/content/Context;Landroid/content/res/XmlResourceParser;)Landroidx/window/embedding/ActivityRule;", "Landroidx/window/embedding/ActivityFilter;", "parseActivityFilter", "(Landroid/content/Context;Landroid/content/res/XmlResourceParser;)Landroidx/window/embedding/ActivityFilter;", "Landroidx/window/embedding/DividerAttributes;", "parseDividerAttributes", "(Landroid/content/Context;Landroid/content/res/XmlResourceParser;)Landroidx/window/embedding/DividerAttributes;", "", "pkg", "", "clsSeq", "Landroid/content/ComponentName;", "buildClassName", "(Ljava/lang/String;Ljava/lang/CharSequence;)Landroid/content/ComponentName;", "", "staticRuleResourceId", "", "parseRules$window_release", "(Landroid/content/Context;I)Ljava/util/Set;", "parseRules", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class RuleParser {
    @NotNull
    public static final RuleParser INSTANCE;

    static {
        RuleParser.INSTANCE = new RuleParser();
    }

    private final void addRuleWithDuplicatedTagCheck(HashSet hashSet0, EmbeddingRule embeddingRule0) {
        String s = embeddingRule0.getTag();
        for(Object object0: hashSet0) {
            if(s != null && s.equals(((EmbeddingRule)object0).getTag())) {
                throw new IllegalArgumentException("Duplicated tag: " + s + " for " + embeddingRule0 + ". The tag must be unique in XML rule definition.");
            }
            if(false) {
                break;
            }
        }
        hashSet0.add(embeddingRule0);
    }

    private final ComponentName buildClassName(String s, CharSequence charSequence0) {
        if(charSequence0 == null || charSequence0.length() == 0) {
            throw new IllegalArgumentException("Activity name must not be null");
        }
        String s1 = charSequence0.toString();
        if(s1.charAt(0) == 46) {
            return new ComponentName(s, s + s1);
        }
        int v = o.E0(s1, '/', 0, 6);
        if(v > 0) {
            s = s1.substring(0, v);
            q.f(s, "substring(...)");
            s1 = s1.substring(v + 1);
            q.f(s1, "substring(...)");
        }
        return s1.equals("*") || o.E0(s1, '.', 0, 6) >= 0 ? new ComponentName(s, s1) : new ComponentName(s, s + '.' + s1);
    }

    private final ActivityFilter parseActivityFilter(Context context0, XmlResourceParser xmlResourceParser0) {
        TypedArray typedArray0 = context0.getTheme().obtainStyledAttributes(xmlResourceParser0, styleable.ActivityFilter, 0, 0);
        String s = typedArray0.getString(styleable.ActivityFilter_activityName);
        String s1 = typedArray0.getString(styleable.ActivityFilter_activityAction);
        q.d("com.iloen.melon");
        return new ActivityFilter(this.buildClassName("com.iloen.melon", s), s1);
    }

    private final ActivityRule parseActivityRule(Context context0, XmlResourceParser xmlResourceParser0) {
        TypedArray typedArray0 = context0.getTheme().obtainStyledAttributes(xmlResourceParser0, styleable.ActivityRule, 0, 0);
        String s = typedArray0.getString(styleable.ActivityRule_tag);
        boolean z = typedArray0.getBoolean(styleable.ActivityRule_alwaysExpand, false);
        typedArray0.recycle();
        Builder activityRule$Builder0 = new Builder(y.a).setAlwaysExpand(z);
        if(s != null) {
            activityRule$Builder0.setTag(s);
        }
        return activityRule$Builder0.build();
    }

    private final DividerAttributes parseDividerAttributes(Context context0, XmlResourceParser xmlResourceParser0) {
        TypedArray typedArray0 = context0.getTheme().obtainStyledAttributes(xmlResourceParser0, styleable.DividerAttributes, 0, 0);
        int v = typedArray0.getInt(styleable.DividerAttributes_embeddingDividerType, 0);
        boolean z = typedArray0.hasValue(styleable.DividerAttributes_dragRangeMinRatio);
        boolean z1 = typedArray0.hasValue(styleable.DividerAttributes_dragRangeMaxRatio);
        DividerAttributes.Companion.validateXmlDividerAttributes$window_release(v, z, z1);
        int v1 = typedArray0.getInt(styleable.DividerAttributes_embeddingDividerWidthDp, -1);
        int v2 = typedArray0.getColor(styleable.DividerAttributes_embeddingDividerColor, 0xFF000000);
        float f = typedArray0.getFloat(styleable.DividerAttributes_dragRangeMinRatio, -1.0f);
        float f1 = typedArray0.getFloat(styleable.DividerAttributes_dragRangeMaxRatio, -1.0f);
        return DividerAttributes.Companion.createDividerAttributes$window_release(v, v1, v2, f, f1);
    }

    @Nullable
    public final Set parseRules$window_release(@NotNull Context context0, int v) {
        SplitPlaceholderRule splitPlaceholderRule1;
        SplitPairRule splitPairRule1;
        ActivityRule activityRule1;
        XmlResourceParser xmlResourceParser0;
        q.g(context0, "context");
        Resources resources0 = context0.getResources();
        try {
            xmlResourceParser0 = resources0.getXml(v);
            q.f(xmlResourceParser0, "getXml(...)");
        }
        catch(Resources.NotFoundException unused_ex) {
            return null;
        }
        Set set0 = new HashSet();
        int v1 = xmlResourceParser0.getDepth();
        int v2 = xmlResourceParser0.next();
        SplitPairRule splitPairRule0 = null;
        ActivityRule activityRule0 = null;
        SplitPlaceholderRule splitPlaceholderRule0 = null;
        while(v2 != 1 && (v2 != 3 || xmlResourceParser0.getDepth() > v1)) {
            if(xmlResourceParser0.getEventType() == 2 && !"split-config".equals(xmlResourceParser0.getName())) {
                String s = xmlResourceParser0.getName();
                if(s != null) {
                    switch(s) {
                        case "ActivityFilter": {
                            if(activityRule0 == null && splitPlaceholderRule0 == null) {
                                throw new IllegalArgumentException("Found orphaned ActivityFilter");
                            }
                            ActivityFilter activityFilter0 = this.parseActivityFilter(context0, xmlResourceParser0);
                            if(activityRule0 != null) {
                                ((HashSet)set0).remove(activityRule0);
                                activityRule1 = activityRule0.plus$window_release(activityFilter0);
                                this.addRuleWithDuplicatedTagCheck(((HashSet)set0), activityRule1);
                                activityRule0 = activityRule1;
                            }
                            else if(splitPlaceholderRule0 != null) {
                                ((HashSet)set0).remove(splitPlaceholderRule0);
                                splitPlaceholderRule1 = splitPlaceholderRule0.plus$window_release(activityFilter0);
                                this.addRuleWithDuplicatedTagCheck(((HashSet)set0), splitPlaceholderRule1);
                                splitPlaceholderRule0 = splitPlaceholderRule1;
                            }
                            break;
                        }
                        case "ActivityRule": {
                            activityRule1 = this.parseActivityRule(context0, xmlResourceParser0);
                            this.addRuleWithDuplicatedTagCheck(((HashSet)set0), activityRule1);
                            splitPairRule0 = null;
                            splitPlaceholderRule0 = null;
                            activityRule0 = activityRule1;
                            break;
                        }
                        case "DividerAttributes": {
                            if(splitPairRule0 == null && splitPlaceholderRule0 == null) {
                                throw new IllegalArgumentException("Found orphaned DividerAttributes");
                            }
                            DividerAttributes dividerAttributes0 = this.parseDividerAttributes(context0, xmlResourceParser0);
                            if(splitPairRule0 != null) {
                                ((HashSet)set0).remove(splitPairRule0);
                                SplitAttributes splitAttributes0 = new androidx.window.embedding.SplitAttributes.Builder(splitPairRule0.getDefaultSplitAttributes()).setDividerAttributes(dividerAttributes0).build();
                                splitPairRule1 = new androidx.window.embedding.SplitPairRule.Builder(splitPairRule0).setDefaultSplitAttributes(splitAttributes0).build();
                                this.addRuleWithDuplicatedTagCheck(((HashSet)set0), splitPairRule1);
                                splitPairRule0 = splitPairRule1;
                            }
                            else if(splitPlaceholderRule0 != null) {
                                ((HashSet)set0).remove(splitPlaceholderRule0);
                                SplitAttributes splitAttributes1 = new androidx.window.embedding.SplitAttributes.Builder(splitPlaceholderRule0.getDefaultSplitAttributes()).setDividerAttributes(dividerAttributes0).build();
                                splitPlaceholderRule1 = new androidx.window.embedding.SplitPlaceholderRule.Builder(splitPlaceholderRule0).setDefaultSplitAttributes(splitAttributes1).build();
                                this.addRuleWithDuplicatedTagCheck(((HashSet)set0), splitPlaceholderRule1);
                                splitPlaceholderRule0 = splitPlaceholderRule1;
                            }
                            break;
                        }
                        case "SplitPairFilter": {
                            if(splitPairRule0 == null) {
                                throw new IllegalArgumentException("Found orphaned SplitPairFilter outside of SplitPairRule");
                            }
                            SplitPairFilter splitPairFilter0 = this.parseSplitPairFilter(context0, xmlResourceParser0);
                            ((HashSet)set0).remove(splitPairRule0);
                            splitPairRule1 = splitPairRule0.plus$window_release(splitPairFilter0);
                            this.addRuleWithDuplicatedTagCheck(((HashSet)set0), splitPairRule1);
                            splitPairRule0 = splitPairRule1;
                            break;
                        }
                        case "SplitPairRule": {
                            splitPairRule1 = this.parseSplitPairRule(context0, xmlResourceParser0);
                            this.addRuleWithDuplicatedTagCheck(((HashSet)set0), splitPairRule1);
                            activityRule0 = null;
                            splitPlaceholderRule0 = null;
                            splitPairRule0 = splitPairRule1;
                            break;
                        }
                        case "SplitPlaceholderRule": {
                            splitPlaceholderRule1 = this.parseSplitPlaceholderRule(context0, xmlResourceParser0);
                            this.addRuleWithDuplicatedTagCheck(((HashSet)set0), splitPlaceholderRule1);
                            splitPairRule0 = null;
                            activityRule0 = null;
                            splitPlaceholderRule0 = splitPlaceholderRule1;
                        }
                    }
                }
            }
            v2 = xmlResourceParser0.next();
        }
        return set0;
    }

    private final SplitPairFilter parseSplitPairFilter(Context context0, XmlResourceParser xmlResourceParser0) {
        TypedArray typedArray0 = context0.getTheme().obtainStyledAttributes(xmlResourceParser0, styleable.SplitPairFilter, 0, 0);
        String s = typedArray0.getString(styleable.SplitPairFilter_primaryActivityName);
        String s1 = typedArray0.getString(styleable.SplitPairFilter_secondaryActivityName);
        String s2 = typedArray0.getString(styleable.SplitPairFilter_secondaryActivityAction);
        q.d("com.iloen.melon");
        return new SplitPairFilter(this.buildClassName("com.iloen.melon", s), this.buildClassName("com.iloen.melon", s1), s2);
    }

    private final SplitPairRule parseSplitPairRule(Context context0, XmlResourceParser xmlResourceParser0) {
        TypedArray typedArray0 = context0.getTheme().obtainStyledAttributes(xmlResourceParser0, styleable.SplitPairRule, 0, 0);
        String s = typedArray0.getString(styleable.SplitPairRule_tag);
        float f = typedArray0.getFloat(styleable.SplitPairRule_splitRatio, 0.5f);
        int v = typedArray0.getInteger(styleable.SplitPairRule_splitMinWidthDp, 600);
        int v1 = typedArray0.getInteger(styleable.SplitPairRule_splitMinHeightDp, 600);
        int v2 = typedArray0.getInteger(styleable.SplitPairRule_splitMinSmallestWidthDp, 600);
        float f1 = typedArray0.getFloat(styleable.SplitPairRule_splitMaxAspectRatioInPortrait, SplitRule.SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT.getValue$window_release());
        float f2 = typedArray0.getFloat(styleable.SplitPairRule_splitMaxAspectRatioInLandscape, SplitRule.SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT.getValue$window_release());
        int v3 = typedArray0.getInt(styleable.SplitPairRule_splitLayoutDirection, LayoutDirection.LOCALE.getValue$window_release());
        int v4 = typedArray0.getInt(styleable.SplitPairRule_finishPrimaryWithSecondary, FinishBehavior.NEVER.getValue$window_release());
        int v5 = typedArray0.getInt(styleable.SplitPairRule_finishSecondaryWithPrimary, FinishBehavior.ALWAYS.getValue$window_release());
        boolean z = typedArray0.getBoolean(styleable.SplitPairRule_clearTop, false);
        int v6 = typedArray0.getColor(styleable.SplitPairRule_animationBackgroundColor, 0);
        typedArray0.recycle();
        SplitAttributes splitAttributes0 = new androidx.window.embedding.SplitAttributes.Builder().setSplitType(SplitType.Companion.buildSplitTypeFromValue$window_release(f)).setLayoutDirection(LayoutDirection.Companion.getLayoutDirectionFromValue$window_release(v3)).setAnimationParams(new androidx.window.embedding.EmbeddingAnimationParams.Builder().setAnimationBackground(EmbeddingAnimationBackground.Companion.buildFromValue$window_release(v6)).build()).build();
        return new androidx.window.embedding.SplitPairRule.Builder(y.a).setTag(s).setMinWidthDp(v).setMinHeightDp(v1).setMinSmallestWidthDp(v2).setMaxAspectRatioInPortrait(EmbeddingAspectRatio.Companion.buildAspectRatioFromValue$window_release(f1)).setMaxAspectRatioInLandscape(EmbeddingAspectRatio.Companion.buildAspectRatioFromValue$window_release(f2)).setFinishPrimaryWithSecondary(FinishBehavior.Companion.getFinishBehaviorFromValue$window_release(v4)).setFinishSecondaryWithPrimary(FinishBehavior.Companion.getFinishBehaviorFromValue$window_release(v5)).setClearTop(z).setDefaultSplitAttributes(splitAttributes0).build();
    }

    private final SplitPlaceholderRule parseSplitPlaceholderRule(Context context0, XmlResourceParser xmlResourceParser0) {
        TypedArray typedArray0 = context0.getTheme().obtainStyledAttributes(xmlResourceParser0, styleable.SplitPlaceholderRule, 0, 0);
        String s = typedArray0.getString(styleable.SplitPlaceholderRule_tag);
        String s1 = typedArray0.getString(styleable.SplitPlaceholderRule_placeholderActivityName);
        boolean z = typedArray0.getBoolean(styleable.SplitPlaceholderRule_stickyPlaceholder, false);
        int v = typedArray0.getInt(styleable.SplitPlaceholderRule_finishPrimaryWithPlaceholder, FinishBehavior.ALWAYS.getValue$window_release());
        if(v == FinishBehavior.NEVER.getValue$window_release()) {
            throw new IllegalArgumentException("Never is not a valid configuration for Placeholder activities. Please use FINISH_ALWAYS or FINISH_ADJACENT instead or refer to the current API");
        }
        float f = typedArray0.getFloat(styleable.SplitPlaceholderRule_splitRatio, 0.5f);
        int v1 = typedArray0.getInteger(styleable.SplitPlaceholderRule_splitMinWidthDp, 600);
        int v2 = typedArray0.getInteger(styleable.SplitPlaceholderRule_splitMinHeightDp, 600);
        int v3 = typedArray0.getInteger(styleable.SplitPlaceholderRule_splitMinSmallestWidthDp, 600);
        float f1 = typedArray0.getFloat(styleable.SplitPlaceholderRule_splitMaxAspectRatioInPortrait, SplitRule.SPLIT_MAX_ASPECT_RATIO_PORTRAIT_DEFAULT.getValue$window_release());
        float f2 = typedArray0.getFloat(styleable.SplitPlaceholderRule_splitMaxAspectRatioInLandscape, SplitRule.SPLIT_MAX_ASPECT_RATIO_LANDSCAPE_DEFAULT.getValue$window_release());
        int v4 = typedArray0.getInt(styleable.SplitPlaceholderRule_splitLayoutDirection, LayoutDirection.LOCALE.getValue$window_release());
        int v5 = typedArray0.getColor(styleable.SplitPlaceholderRule_animationBackgroundColor, 0);
        typedArray0.recycle();
        SplitAttributes splitAttributes0 = new androidx.window.embedding.SplitAttributes.Builder().setSplitType(SplitType.Companion.buildSplitTypeFromValue$window_release(f)).setLayoutDirection(LayoutDirection.Companion.getLayoutDirectionFromValue$window_release(v4)).setAnimationParams(new androidx.window.embedding.EmbeddingAnimationParams.Builder().setAnimationBackground(EmbeddingAnimationBackground.Companion.buildFromValue$window_release(v5)).build()).build();
        q.d("com.iloen.melon");
        ComponentName componentName0 = RuleParser.INSTANCE.buildClassName("com.iloen.melon", s1);
        Intent intent0 = new Intent().setComponent(componentName0);
        q.f(intent0, "setComponent(...)");
        return new androidx.window.embedding.SplitPlaceholderRule.Builder(y.a, intent0).setTag(s).setMinWidthDp(v1).setMinHeightDp(v2).setMinSmallestWidthDp(v3).setMaxAspectRatioInPortrait(EmbeddingAspectRatio.Companion.buildAspectRatioFromValue$window_release(f1)).setMaxAspectRatioInLandscape(EmbeddingAspectRatio.Companion.buildAspectRatioFromValue$window_release(f2)).setSticky(z).setFinishPrimaryWithPlaceholder(FinishBehavior.Companion.getFinishBehaviorFromValue$window_release(v)).setDefaultSplitAttributes(splitAttributes0).build();
    }
}

