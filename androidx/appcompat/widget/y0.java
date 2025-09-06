package androidx.appcompat.widget;

import D6.f;
import P1.c;
import Q0.p1;
import U4.x;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.Drawable;
import android.net.Uri.Builder;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import h2.a;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

public final class Y0 extends a implements View.OnClickListener {
    public int B;
    public int D;
    public int E;
    public int G;
    public int I;
    public int M;
    public static final int N;
    public final int h;
    public final int i;
    public final LayoutInflater j;
    public final SearchView k;
    public final SearchableInfo l;
    public final Context m;
    public final WeakHashMap n;
    public final int o;
    public int r;
    public ColorStateList w;

    public Y0(Context context0, SearchView searchView0, SearchableInfo searchableInfo0, WeakHashMap weakHashMap0) {
        int v = searchView0.getSuggestionRowLayout();
        super();
        this.b = true;
        this.c = null;
        this.a = false;
        this.d = -1;
        this.e = new p1(this);
        this.f = new f(this, 2);
        this.i = v;
        this.h = v;
        this.j = (LayoutInflater)context0.getSystemService("layout_inflater");
        this.r = 1;
        this.B = -1;
        this.D = -1;
        this.E = -1;
        this.G = -1;
        this.I = -1;
        this.M = -1;
        this.k = searchView0;
        this.l = searchableInfo0;
        this.o = searchView0.getSuggestionCommitIconResId();
        this.m = context0;
        this.n = weakHashMap0;
    }

    @Override  // h2.a
    public final void a(View view0, Cursor cursor0) {
        ActivityInfo activityInfo0;
        Drawable drawable0;
        String s2;
        Object object0 = view0.getTag();
        int v = this.M == -1 ? 0 : cursor0.getInt(this.M);
        TextView textView0 = ((X0)object0).a;
        TextView textView1 = ((X0)object0).b;
        ImageView imageView0 = ((X0)object0).e;
        if(textView0 != null) {
            String s = Y0.h(cursor0, this.B);
            textView0.setText(s);
            if(TextUtils.isEmpty(s)) {
                textView0.setVisibility(8);
            }
            else {
                textView0.setVisibility(0);
            }
        }
        Context context0 = this.m;
        if(textView1 != null) {
            String s1 = Y0.h(cursor0, this.E);
            if(s1 == null) {
                s2 = Y0.h(cursor0, this.D);
            }
            else {
                if(this.w == null) {
                    TypedValue typedValue0 = new TypedValue();
                    context0.getTheme().resolveAttribute(0x7F040613, typedValue0, true);  // attr:textColorSearchUrl
                    this.w = context0.getResources().getColorStateList(typedValue0.resourceId);
                }
                s2 = new SpannableString(s1);
                ((SpannableString)s2).setSpan(new TextAppearanceSpan(null, 0, 0, this.w, null), 0, s1.length(), 33);
            }
            if(!TextUtils.isEmpty(s2)) {
                if(textView0 != null) {
                    textView0.setSingleLine(true);
                    textView0.setMaxLines(1);
                }
            }
            else if(textView0 != null) {
                textView0.setSingleLine(false);
                textView0.setMaxLines(2);
            }
            textView1.setText(s2);
            if(TextUtils.isEmpty(s2)) {
                textView1.setVisibility(8);
            }
            else {
                textView1.setVisibility(0);
            }
        }
        ImageView imageView1 = ((X0)object0).c;
        if(imageView1 != null) {
            int v1 = this.G;
            if(v1 == -1) {
                drawable0 = null;
            }
            else {
                drawable0 = this.f(cursor0.getString(v1));
                if(drawable0 == null) {
                    ComponentName componentName0 = this.l.getSearchActivity();
                    String s3 = componentName0.flattenToShortString();
                    WeakHashMap weakHashMap0 = this.n;
                    if(weakHashMap0.containsKey(s3)) {
                        Drawable.ConstantState drawable$ConstantState0 = (Drawable.ConstantState)weakHashMap0.get(s3);
                        drawable0 = drawable$ConstantState0 == null ? null : drawable$ConstantState0.newDrawable(context0.getResources());
                    }
                    else {
                        PackageManager packageManager0 = context0.getPackageManager();
                        try {
                            activityInfo0 = packageManager0.getActivityInfo(componentName0, 0x80);
                        }
                        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                            Log.w("SuggestionsAdapter", packageManager$NameNotFoundException0.toString());
                            drawable0 = null;
                            goto label_74;
                        }
                        int v2 = activityInfo0.getIconResource();
                        if(v2 == 0) {
                            drawable0 = null;
                        }
                        else {
                            Drawable drawable1 = packageManager0.getDrawable(componentName0.getPackageName(), v2, activityInfo0.applicationInfo);
                            if(drawable1 == null) {
                                StringBuilder stringBuilder0 = x.n(v2, "Invalid icon resource ", " for ");
                                stringBuilder0.append(componentName0.flattenToShortString());
                                Log.w("SuggestionsAdapter", stringBuilder0.toString());
                                drawable0 = null;
                            }
                            else {
                                drawable0 = drawable1;
                            }
                        }
                    label_74:
                        weakHashMap0.put(s3, (drawable0 == null ? null : drawable0.getConstantState()));
                    }
                    if(drawable0 == null) {
                        drawable0 = context0.getPackageManager().getDefaultActivityIcon();
                    }
                }
            }
            imageView1.setImageDrawable(drawable0);
            if(drawable0 == null) {
                imageView1.setVisibility(4);
            }
            else {
                imageView1.setVisibility(0);
                drawable0.setVisible(false, false);
                drawable0.setVisible(true, false);
            }
        }
        ImageView imageView2 = ((X0)object0).d;
        if(imageView2 != null) {
            Drawable drawable2 = this.I == -1 ? null : this.f(cursor0.getString(this.I));
            imageView2.setImageDrawable(drawable2);
            if(drawable2 == null) {
                imageView2.setVisibility(8);
            }
            else {
                imageView2.setVisibility(0);
                drawable2.setVisible(false, false);
                drawable2.setVisible(true, false);
            }
        }
        if(this.r != 2 && (this.r != 1 || (v & 1) == 0)) {
            imageView0.setVisibility(8);
            return;
        }
        imageView0.setVisibility(0);
        imageView0.setTag(textView0.getText());
        imageView0.setOnClickListener(this);
    }

    @Override  // h2.a
    public final void b(Cursor cursor0) {
        try {
            super.b(cursor0);
            if(cursor0 != null) {
                this.B = cursor0.getColumnIndex("suggest_text_1");
                this.D = cursor0.getColumnIndex("suggest_text_2");
                this.E = cursor0.getColumnIndex("suggest_text_2_url");
                this.G = cursor0.getColumnIndex("suggest_icon_1");
                this.I = cursor0.getColumnIndex("suggest_icon_2");
                this.M = cursor0.getColumnIndex("suggest_flags");
            }
        }
        catch(Exception exception0) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", exception0);
        }
    }

    @Override  // h2.a
    public final String c(Cursor cursor0) {
        if(cursor0 != null) {
            String s = Y0.h(cursor0, cursor0.getColumnIndex("suggest_intent_query"));
            if(s != null) {
                return s;
            }
            SearchableInfo searchableInfo0 = this.l;
            if(searchableInfo0.shouldRewriteQueryFromData()) {
                String s1 = Y0.h(cursor0, cursor0.getColumnIndex("suggest_intent_data"));
                if(s1 != null) {
                    return s1;
                }
            }
            if(searchableInfo0.shouldRewriteQueryFromText()) {
                String s2 = Y0.h(cursor0, cursor0.getColumnIndex("suggest_text_1"));
                return s2 == null ? null : s2;
            }
        }
        return null;
    }

    @Override  // h2.a
    public final View d(ViewGroup viewGroup0) {
        View view0 = this.j.inflate(this.h, viewGroup0, false);
        view0.setTag(new X0(view0));
        ((ImageView)view0.findViewById(0x7F0A040E)).setImageResource(this.o);  // id:edit_query
        return view0;
    }

    public final Drawable e(Uri uri0) {
        int v1;
        Resources resources0;
        String s = uri0.getAuthority();
        if(TextUtils.isEmpty(s)) {
            throw new FileNotFoundException("No authority: " + uri0);
        }
        try {
            resources0 = this.m.getPackageManager().getResourcesForApplication(s);
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            throw new FileNotFoundException("No package found for authority: " + uri0);
        }
        List list0 = uri0.getPathSegments();
        if(list0 == null) {
            throw new FileNotFoundException("No path: " + uri0);
        }
        int v = list0.size();
        if(v == 1) {
            try {
                v1 = Integer.parseInt(((String)list0.get(0)));
            }
            catch(NumberFormatException unused_ex) {
                throw new FileNotFoundException("Single path segment is not a resource ID: " + uri0);
            }
        }
        else {
            if(v != 2) {
                throw new FileNotFoundException("More than two path segments: " + uri0);
            }
            v1 = resources0.getIdentifier(((String)list0.get(1)), ((String)list0.get(0)), s);
        }
        if(v1 == 0) {
            throw new FileNotFoundException("No resource found for: " + uri0);
        }
        return resources0.getDrawable(v1);
    }

    public final Drawable f(String s) {
        Drawable drawable4;
        WeakHashMap weakHashMap0 = this.n;
        Context context0 = this.m;
        Drawable drawable0 = null;
        if(s != null && !s.isEmpty() && !"0".equals(s)) {
            try {
                int v = Integer.parseInt(s);
                Drawable.ConstantState drawable$ConstantState0 = (Drawable.ConstantState)weakHashMap0.get("android.resource://com.iloen.melon/" + v);
                Drawable drawable1 = drawable$ConstantState0 == null ? null : drawable$ConstantState0.newDrawable();
                if(drawable1 != null) {
                    return drawable1;
                }
                Drawable drawable2 = c.getDrawable(context0, v);
                if(drawable2 != null) {
                    weakHashMap0.put("android.resource://com.iloen.melon/" + v, drawable2.getConstantState());
                }
                return drawable2;
            }
            catch(NumberFormatException unused_ex) {
                Drawable.ConstantState drawable$ConstantState1 = (Drawable.ConstantState)weakHashMap0.get(s);
                Drawable drawable3 = drawable$ConstantState1 == null ? null : drawable$ConstantState1.newDrawable();
                if(drawable3 != null) {
                    return drawable3;
                }
                Uri uri0 = Uri.parse(s);
                try {
                    if("android.resource".equals(uri0.getScheme())) {
                        try {
                            drawable0 = this.e(uri0);
                        }
                        catch(Resources.NotFoundException unused_ex) {
                            throw new FileNotFoundException("Resource does not exist: " + uri0);
                        }
                    }
                    else {
                        InputStream inputStream0 = context0.getContentResolver().openInputStream(uri0);
                        if(inputStream0 == null) {
                            throw new FileNotFoundException("Failed to open " + uri0);
                        }
                        try {
                            drawable4 = Drawable.createFromStream(inputStream0, null);
                        }
                        finally {
                            try {
                                inputStream0.close();
                            }
                            catch(IOException iOException0) {
                                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri0, iOException0);
                            }
                        }
                        drawable0 = drawable4;
                    }
                }
                catch(FileNotFoundException fileNotFoundException0) {
                    Log.w("SuggestionsAdapter", "Icon not found: " + uri0 + ", " + fileNotFoundException0.getMessage());
                }
                if(drawable0 != null) {
                    weakHashMap0.put(s, drawable0.getConstantState());
                    return drawable0;
                }
            }
            catch(Resources.NotFoundException unused_ex) {
                Log.w("SuggestionsAdapter", "Icon resource not found: " + s);
                return null;
            }
        }
        return null;
    }

    public final Cursor g(SearchableInfo searchableInfo0, String s) {
        String[] arr_s = null;
        if(searchableInfo0 != null) {
            String s1 = searchableInfo0.getSuggestAuthority();
            if(s1 != null) {
                Uri.Builder uri$Builder0 = new Uri.Builder().scheme("content").authority(s1).query("").fragment("");
                String s2 = searchableInfo0.getSuggestPath();
                if(s2 != null) {
                    uri$Builder0.appendEncodedPath(s2);
                }
                uri$Builder0.appendPath("search_suggest_query");
                String s3 = searchableInfo0.getSuggestSelection();
                if(s3 == null) {
                    uri$Builder0.appendPath(s);
                }
                else {
                    arr_s = new String[]{s};
                }
                uri$Builder0.appendQueryParameter("limit", "50");
                Uri uri0 = uri$Builder0.build();
                return this.m.getContentResolver().query(uri0, null, s3, arr_s, null);
            }
        }
        return null;
    }

    @Override  // h2.a
    public final View getDropDownView(int v, View view0, ViewGroup viewGroup0) {
        try {
            return super.getDropDownView(v, view0, viewGroup0);
        }
        catch(RuntimeException runtimeException0) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", runtimeException0);
            View view1 = this.j.inflate(this.i, viewGroup0, false);
            if(view1 != null) {
                ((X0)view1.getTag()).a.setText(runtimeException0.toString());
            }
            return view1;
        }
    }

    @Override  // h2.a
    public final View getView(int v, View view0, ViewGroup viewGroup0) {
        try {
            return super.getView(v, view0, viewGroup0);
        }
        catch(RuntimeException runtimeException0) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", runtimeException0);
            View view1 = this.d(viewGroup0);
            ((X0)view1.getTag()).a.setText(runtimeException0.toString());
            return view1;
        }
    }

    public static String h(Cursor cursor0, int v) {
        if(v == -1) {
            return null;
        }
        try {
            return cursor0.getString(v);
        }
        catch(Exception exception0) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", exception0);
            return null;
        }
    }

    @Override  // android.widget.BaseAdapter
    public final boolean hasStableIds() {
        return false;
    }

    @Override  // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        Bundle bundle0 = this.c == null ? null : this.c.getExtras();
        if(bundle0 != null) {
            bundle0.getBoolean("in_progress");
        }
    }

    @Override  // android.widget.BaseAdapter
    public final void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        Bundle bundle0 = this.c == null ? null : this.c.getExtras();
        if(bundle0 != null) {
            bundle0.getBoolean("in_progress");
        }
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        Object object0 = view0.getTag();
        if(object0 instanceof CharSequence) {
            this.k.p(((CharSequence)object0));
        }
    }
}

