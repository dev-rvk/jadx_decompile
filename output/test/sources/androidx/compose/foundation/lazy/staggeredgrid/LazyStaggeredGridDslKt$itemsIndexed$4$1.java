package androidx.compose.foundation.lazy.staggeredgrid;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* compiled from: LazyStaggeredGridDsl.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "T", "index", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
/* loaded from: classes.dex */
final class LazyStaggeredGridDslKt$itemsIndexed$4$1 extends Lambda implements Function1<Integer, StaggeredGridItemSpan> {
    final /* synthetic */ List<T> $items;
    final /* synthetic */ Function2<Integer, T, StaggeredGridItemSpan> $span;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LazyStaggeredGridDslKt$itemsIndexed$4$1(Function2<? super Integer, ? super T, StaggeredGridItemSpan> function2, List<? extends T> list) {
        super(1);
        this.$span = function2;
        this.$items = list;
    }

    public final StaggeredGridItemSpan invoke(int index) {
        return this.$span.invoke(Integer.valueOf(index), this.$items.get(index));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ StaggeredGridItemSpan invoke(Integer num) {
        return invoke(num.intValue());
    }
}
