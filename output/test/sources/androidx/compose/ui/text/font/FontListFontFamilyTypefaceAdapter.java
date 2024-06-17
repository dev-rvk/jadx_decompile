package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.TypefaceResult;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J!\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJB\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\n0\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00190\u0016H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter;", "Landroidx/compose/ui/text/font/FontFamilyTypefaceAdapter;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "injectedContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/compose/ui/text/font/AsyncTypefaceCache;Lkotlin/coroutines/CoroutineContext;)V", "asyncLoadScope", "Lkotlinx/coroutines/CoroutineScope;", "preload", "", "family", "Landroidx/compose/ui/text/font/FontFamily;", "resourceLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/PlatformFontLoader;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolve", "Landroidx/compose/ui/text/font/TypefaceResult;", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "platformFontLoader", "onAsyncCompletion", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", "createDefaultTypeface", "", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FontListFontFamilyTypefaceAdapter implements FontFamilyTypefaceAdapter {
    private CoroutineScope asyncLoadScope;
    private final AsyncTypefaceCache asyncTypefaceCache;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final FontMatcher fontMatcher = new FontMatcher();
    private static final CoroutineExceptionHandler DropExceptionHandler = new FontListFontFamilyTypefaceAdapter$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE);

    /* JADX WARN: Multi-variable type inference failed */
    public FontListFontFamilyTypefaceAdapter() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public FontListFontFamilyTypefaceAdapter(AsyncTypefaceCache asyncTypefaceCache, CoroutineContext injectedContext) {
        Intrinsics.checkNotNullParameter(asyncTypefaceCache, "asyncTypefaceCache");
        Intrinsics.checkNotNullParameter(injectedContext, "injectedContext");
        this.asyncTypefaceCache = asyncTypefaceCache;
        this.asyncLoadScope = CoroutineScopeKt.CoroutineScope(DropExceptionHandler.plus(injectedContext).plus(SupervisorKt.SupervisorJob((Job) injectedContext.get(Job.INSTANCE))));
    }

    public /* synthetic */ FontListFontFamilyTypefaceAdapter(AsyncTypefaceCache asyncTypefaceCache, EmptyCoroutineContext emptyCoroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new AsyncTypefaceCache() : asyncTypefaceCache, (i & 2) != 0 ? EmptyCoroutineContext.INSTANCE : emptyCoroutineContext);
    }

    public final Object preload(FontFamily family, PlatformFontLoader resourceLoader, Continuation<? super Unit> continuation) {
        List $this$fastDistinctBy$iv;
        if (!(family instanceof FontListFontFamily)) {
            return Unit.INSTANCE;
        }
        List allFonts = ((FontListFontFamily) family).getFonts();
        List $this$fastFilter$iv = ((FontListFontFamily) family).getFonts();
        int $i$f$fastFilter = 0;
        List target$iv = new ArrayList($this$fastFilter$iv.size());
        int index$iv$iv = 0;
        int size = $this$fastFilter$iv.size();
        while (index$iv$iv < size) {
            Font it = $this$fastFilter$iv.get(index$iv$iv);
            List $this$fastFilter$iv2 = $this$fastFilter$iv;
            int loadingStrategy = it.getLoadingStrategy();
            int $i$f$fastFilter2 = $i$f$fastFilter;
            int $i$f$fastFilter3 = FontLoadingStrategy.INSTANCE.m4812getAsyncPKNRLFQ();
            if (FontLoadingStrategy.m4808equalsimpl0(loadingStrategy, $i$f$fastFilter3)) {
                target$iv.add(it);
            }
            index$iv$iv++;
            $this$fastFilter$iv = $this$fastFilter$iv2;
            $i$f$fastFilter = $i$f$fastFilter2;
        }
        List $this$fastMap$iv = target$iv;
        int $i$f$fastMap = 0;
        List target$iv2 = new ArrayList($this$fastMap$iv.size());
        int index$iv$iv2 = 0;
        int size2 = $this$fastMap$iv.size();
        while (index$iv$iv2 < size2) {
            Font it2 = (Font) $this$fastMap$iv.get(index$iv$iv2);
            target$iv2.add(TuplesKt.to(it2.getWeight(), FontStyle.m4818boximpl(it2.getStyle())));
            index$iv$iv2++;
            $this$fastMap$iv = $this$fastMap$iv;
            $i$f$fastMap = $i$f$fastMap;
        }
        List $this$fastDistinctBy$iv2 = target$iv2;
        HashSet set$iv = new HashSet($this$fastDistinctBy$iv2.size());
        List target$iv3 = new ArrayList($this$fastDistinctBy$iv2.size());
        int index$iv$iv3 = 0;
        int size3 = $this$fastDistinctBy$iv2.size();
        while (index$iv$iv3 < size3) {
            Object item$iv$iv = $this$fastDistinctBy$iv2.get(index$iv$iv3);
            if (set$iv.add((Pair) item$iv$iv)) {
                $this$fastDistinctBy$iv = $this$fastDistinctBy$iv2;
                target$iv3.add(item$iv$iv);
            } else {
                $this$fastDistinctBy$iv = $this$fastDistinctBy$iv2;
            }
            index$iv$iv3++;
            $this$fastDistinctBy$iv2 = $this$fastDistinctBy$iv;
        }
        List asyncStyles = target$iv3;
        List asyncLoads = new ArrayList();
        int size4 = asyncStyles.size();
        int index$iv = 0;
        while (index$iv < size4) {
            Object item$iv = asyncStyles.get(index$iv);
            Pair pair = (Pair) item$iv;
            FontWeight fontWeight = (FontWeight) pair.component1();
            int fontStyle = ((FontStyle) pair.component2()).m4824unboximpl();
            List matched = fontMatcher.m4817matchFontRetOiIg((List<? extends Font>) allFonts, fontWeight, fontStyle);
            int index$iv2 = index$iv;
            TypefaceRequest typeRequest = new TypefaceRequest(family, fontWeight, fontStyle, FontSynthesis.INSTANCE.m4836getAllGVVA2EU(), resourceLoader.getCacheKey(), null);
            List asyncFontsToLoad = (List) FontListFontFamilyTypefaceAdapterKt.access$firstImmediatelyAvailable(matched, typeRequest, this.asyncTypefaceCache, resourceLoader, new Function1<TypefaceRequest, Unit>() { // from class: androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$2$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TypefaceRequest typefaceRequest) {
                    invoke2(typefaceRequest);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TypefaceRequest it3) {
                    Intrinsics.checkNotNullParameter(it3, "it");
                }
            }).component1();
            if (asyncFontsToLoad != null) {
                asyncLoads.add(CollectionsKt.first(asyncFontsToLoad));
            }
            index$iv = index$iv2 + 1;
        }
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new FontListFontFamilyTypefaceAdapter$preload$3(asyncLoads, this, resourceLoader, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.text.font.FontFamilyTypefaceAdapter
    public TypefaceResult resolve(TypefaceRequest typefaceRequest, PlatformFontLoader platformFontLoader, Function1<? super TypefaceResult.Immutable, Unit> onAsyncCompletion, Function1<? super TypefaceRequest, ? extends Object> createDefaultTypeface) {
        Intrinsics.checkNotNullParameter(typefaceRequest, "typefaceRequest");
        Intrinsics.checkNotNullParameter(platformFontLoader, "platformFontLoader");
        Intrinsics.checkNotNullParameter(onAsyncCompletion, "onAsyncCompletion");
        Intrinsics.checkNotNullParameter(createDefaultTypeface, "createDefaultTypeface");
        if (!(typefaceRequest.getFontFamily() instanceof FontListFontFamily)) {
            return null;
        }
        List matched = fontMatcher.m4817matchFontRetOiIg(((FontListFontFamily) typefaceRequest.getFontFamily()).getFonts(), typefaceRequest.getFontWeight(), typefaceRequest.m4864getFontStyle_LCdwA());
        Pair access$firstImmediatelyAvailable = FontListFontFamilyTypefaceAdapterKt.access$firstImmediatelyAvailable(matched, typefaceRequest, this.asyncTypefaceCache, platformFontLoader, createDefaultTypeface);
        List asyncFontsToLoad = (List) access$firstImmediatelyAvailable.component1();
        Object synthesizedTypeface = access$firstImmediatelyAvailable.component2();
        if (asyncFontsToLoad == null) {
            return new TypefaceResult.Immutable(synthesizedTypeface, false, 2, null);
        }
        AsyncFontListLoader asyncLoader = new AsyncFontListLoader(asyncFontsToLoad, synthesizedTypeface, typefaceRequest, this.asyncTypefaceCache, onAsyncCompletion, platformFontLoader);
        BuildersKt__Builders_commonKt.launch$default(this.asyncLoadScope, null, CoroutineStart.UNDISPATCHED, new FontListFontFamilyTypefaceAdapter$resolve$1(asyncLoader, null), 1, null);
        return new TypefaceResult.Async(asyncLoader);
    }

    /* compiled from: FontListFontFamilyTypefaceAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter$Companion;", "", "()V", "DropExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getDropExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "fontMatcher", "Landroidx/compose/ui/text/font/FontMatcher;", "getFontMatcher", "()Landroidx/compose/ui/text/font/FontMatcher;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FontMatcher getFontMatcher() {
            return FontListFontFamilyTypefaceAdapter.fontMatcher;
        }

        public final CoroutineExceptionHandler getDropExceptionHandler() {
            return FontListFontFamilyTypefaceAdapter.DropExceptionHandler;
        }
    }
}
