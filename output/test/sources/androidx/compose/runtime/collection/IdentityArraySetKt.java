package androidx.compose.runtime.collection;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IdentityArraySet.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0006H\u0080\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, d2 = {"fastForEach", "", "T", "", "", "block", "Lkotlin/Function1;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class IdentityArraySetKt {
    public static final <T> void fastForEach(Set<? extends T> set, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (set instanceof IdentityArraySet) {
            IdentityArraySet this_$iv = (IdentityArraySet) set;
            Object[] values$iv = this_$iv.getValues();
            int size = this_$iv.size();
            for (int i$iv = 0; i$iv < size; i$iv++) {
                Object obj = values$iv[i$iv];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                block.invoke(obj);
            }
            return;
        }
        Set<? extends T> $this$forEach$iv = set;
        for (Object element$iv : $this$forEach$iv) {
            block.invoke(element$iv);
        }
    }
}
