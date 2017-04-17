package co.zsmb.materialdrawerkt.builders

import android.app.Activity
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.annotation.MenuRes
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.ViewGroup
import co.zsmb.materialdrawerkt.DrawerMarker
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.holder.DimenHolder
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

@DrawerMarker
class DrawerBuilderKt(val activity: Activity) : BuilderBase() {

    /* Builder basics */

    private val builder = DrawerBuilder()

    init {
        builder.withActivity(activity)
    }

    internal fun build(): Drawer = builder
            .withOnDrawerListener(onDrawerListener)
            .build()

    /* Special things */

    override fun attachItem(item: IDrawerItem<*, *>) {
        builder.addDrawerItems(item)
    }

    override fun attachHeader(header: AccountHeader) {
        builder.withAccountHeader(header)
    }

    fun footer(setup: StickyFooterKt.() -> Unit = {}) {
        StickyFooterKt(builder).setup()
    }

    /* DrawerBuilder methods */

    fun inflateMenu(@MenuRes menuRes: Int) {
        builder.inflateMenu(menuRes)
    }

    var actionBarDrawerToggle: ActionBarDrawerToggle
        get() = nonReadable()
        set(value) {
            builder.withActionBarDrawerToggle(value)
        }

    var actionBarDrawerToggleEnabled: Boolean
        get() = nonReadable()
        set(enabled) {
            builder.withActionBarDrawerToggle(enabled)
        }

    var actionBarDrawerToggleAnimated: Boolean
        get() = nonReadable()
        set(value) {
            builder.withActionBarDrawerToggleAnimated(value)
        }

    var adapter: FastAdapter<IDrawerItem<out Any?, out RecyclerView.ViewHolder>>
        get() = nonReadable()
        set(value) {
            builder.withAdapter(value)
        }

    var adapterWrapper: RecyclerView.Adapter<out RecyclerView.ViewHolder>
        get() = nonReadable()
        set(value) {
            builder.withAdapterWrapper(value)
        }

    /**
     *
     *
     * Wraps the append function.
     */
    fun append(drawer: Drawer) {
        builder.append(drawer)
    }

    var closeOnClick: Boolean
        get() = nonReadable()
        set(value) {
            builder.withCloseOnClick(value)
        }

    var customView: View
        get() = nonReadable()
        set(value) {
            builder.withCustomView(value)
        }

    var delayDrawerClickEvent: Int
        get() = nonReadable()
        set(value) {
            builder.withDelayDrawerClickEvent(value)
        }

    var delayOnDrawerClose: Int
        get() = nonReadable()
        set(value) {
            builder.withDelayOnDrawerClose(value)
        }

    var displayBelowStatusBar: Boolean
        get() = nonReadable()
        set(value) {
            builder.withDisplayBelowStatusBar(value)
        }

    var drawerGravity: Int
        get() = nonReadable()
        set(@MenuRes value) {
            builder.withDrawerGravity(value)
        }

    /**
     * Convenience for drawerGravity
     */
    var gravity: Int
        get() = nonReadable()
        set(@MenuRes value) {
            builder.withDrawerGravity(value)
        }

    var drawerLayout: DrawerLayout
        get() = nonReadable()
        set(value) {
            builder.withDrawerLayout(value)
        }

    var drawerLayoutRes: Int
        get() = nonReadable()
        set(value) {
            builder.withDrawerLayout(value)
        }

    var drawerWidthDp: Int
        get() = nonReadable()
        set(value) {
            builder.withDrawerWidthDp(value)
        }

    /**
     * Convenience for drawerWidthDp
     */
    var widthDp: Int
        get() = nonReadable()
        set(value) {
            builder.withDrawerWidthDp(value)
        }

    var drawerWidthPx: Int
        get() = nonReadable()
        set(value) {
            builder.withDrawerWidthPx(value)
        }

    /**
     * Convenience for drawerWidthDp
     */
    var widthPx: Int
        get() = nonReadable()
        set(value) {
            builder.withDrawerWidthPx(value)
        }

    var drawerWidthRes: Int
        get() = nonReadable()
        set(value) {
            builder.withDrawerWidthRes(value)
        }

    /**
     * Convenience for drawerWidthDp
     */
    var widthRes: Int
        get() = nonReadable()
        set(value) {
            builder.withDrawerWidthRes(value)
        }

    var fireOnInitialOnClick: Boolean
        get() = nonReadable()
        set(value) {
            builder.withFireOnInitialOnClick(value)
        }

    var footer: View
        get() = nonReadable()
        set(value) {
            builder.withFooter(footer)
        }

    var footerRes: Int
        get() = nonReadable()
        set(value) {
            builder.withFooter(value)
        }

    var footerClickable: Boolean
        get() = nonReadable()
        set(value) {
            builder.withFooterClickable(value)
        }

    var footerDivider: Boolean
        get() = nonReadable()
        set(value) {
            builder.withFooterDivider(value)
        }

    var fullscreen: Boolean
        get() = nonReadable()
        set(value) {
            builder.withFullscreen(value)
        }

    var hasStableIds: Boolean
        get() = nonReadable()
        set(value) {
            builder.withHasStableIds(value)
        }

    var header: View
        get() = nonReadable()
        set(value) {
            builder.withHeader(value)
        }

    var headerRes: Int
        get() = nonReadable()
        set(value) {
            builder.withHeader(value)
        }

    var headerDivider: Boolean
        get() = nonReadable()
        set(value) {
            builder.withHeaderDivider(value)
        }

    var headerHeight: DimenHolder
        get() = nonReadable()
        set(value) {
            builder.withHeaderHeight(value)
        }

    /**
     * Convenience for headerHeight to avoid having to create a DimenHolder
     */
    var headerHeightDp: Int
        get() = nonReadable()
        set(value) {
            builder.withHeaderHeight(DimenHolder.fromDp(value))
        }

    /**
     * Convenience for headerHeight to avoid having to create a DimenHolder
     */
    var headerHeightPx: Int
        get() = nonReadable()
        set(value) {
            builder.withHeaderHeight(DimenHolder.fromPixel(value))
        }

    /**
     * Convenience for headerHeight to avoid having to create a DimenHolder
     */
    var headerHeightRes: Int
        get() = nonReadable()
        set(value) {
            builder.withHeaderHeight(DimenHolder.fromResource(value))
        }

    var headerPadding: Boolean
        get() = nonReadable()
        set(value) {
            builder.withHeaderPadding(value)
        }

    var innerShadow: Boolean
        get() = nonReadable()
        set(value) {
            builder.withInnerShadow(value)
        }

    var itemAnimator: RecyclerView.ItemAnimator
        get() = nonReadable()
        set(value) {
            builder.withItemAnimator(value)
        }

    var multiSelect: Boolean
        get() = nonReadable()
        set(value) {
            builder.withMultiSelect(value)
        }

    /**
     * Defines an item click listener for the drawer
     *
     * @param handler the handler to call when an item has been clicked. Should return true if the click has been handled.
     */
    fun onItemClick(handler: (view: View, position: Int, drawerItem: IDrawerItem<*, *>) -> Boolean) {
        builder.withOnDrawerItemClickListener(handler)
    }

    /**
     * Alternative to the 3 parameter onItemClick method
     */
    fun onItemClick(handler: (view: View, position: Int) -> Boolean) {
        builder.withOnDrawerItemClickListener { view, position, drawerItem -> handler(view, position) }
    }

    /**
     * Defines an item long click listener for the drawer
     *
     * @param handler the handler to call when an item has been clicked. Should return true if the click has been handled.
     */
    fun onItemLongClick(handler: (view: View, position: Int, drawerItem: IDrawerItem<*, *>) -> Boolean) {
        builder.withOnDrawerItemLongClickListener(handler)
    }

    /**
     * Alternative to the 3 parameter onItemLongClick method
     */
    fun onItemLongClick(handler: (view: View, position: Int) -> Boolean) {
        builder.withOnDrawerItemLongClickListener { view, position, drawerItem -> handler(view, position) }
    }

    private val onDrawerListener = object : Drawer.OnDrawerListener {
        var onSlide: ((View, Float) -> Unit)? = null
        override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
            onSlide?.invoke(drawerView, slideOffset)
        }

        var onClosed: ((View) -> Unit)? = null
        override fun onDrawerClosed(drawerView: View) {
            onClosed?.invoke(drawerView)
        }

        var onOpened: ((View) -> Unit)? = null
        override fun onDrawerOpened(drawerView: View) {
            onOpened?.invoke(drawerView)
        }
    }

    fun onSlide(handler: (drawerView: View, slideOffset: Float) -> Unit) {
        onDrawerListener.onSlide = handler
    }

    fun onClosed(handler: (drawerView: View) -> Unit) {
        onDrawerListener.onClosed = handler
    }

    fun onOpened(handler: (drawerView: View) -> Unit) {
        onDrawerListener.onOpened = handler
    }

    /**
     * Defines a navigation listener for the drawer
     *
     * @param handler the handler to call on navigation. Should return true if the event has been handled.
     */
    fun onNavigation(handler: (view: View) -> Boolean) {
        builder.withOnDrawerNavigationListener(handler)
    }

    var positionBasedStateManagement: Boolean
        get() = nonReadable()
        set(value) {
            builder.withPositionBasedStateManagement(value)
        }

    /**
     *
     *
     * Convenience for append.
     *
     * Non readable property.
     */
    var primaryDrawer: Drawer
        get() = nonReadable()
        set(value) {
            builder.append(value)
        }

    var recyclerView: RecyclerView
        get() = nonReadable()
        set(value) {
            builder.withRecyclerView(value)
        }

    var rootView: ViewGroup
        get() = nonReadable()
        set(value) {
            builder.withRootView(value)
        }

    var rootViewRes: Int
        get() = nonReadable()
        set(value) {
            builder.withRootView(value)
        }

    var savedInstance: Bundle
        get() = nonReadable()
        set(value) {
            builder.withSavedInstance(value)
        }

    var scrollToTopAfterClick: Boolean
        get() = nonReadable()
        set(value) {
            builder.withScrollToTopAfterClick(value)
        }

    var selectedItem: Long
        get() = nonReadable()
        set(value) {
            builder.withSelectedItem(value)
        }

    var selectedItemByPosition: Int
        get() = nonReadable()
        set(value) {
            builder.withSelectedItemByPosition(value)
        }

    var showDrawerOnFirstLaunch: Boolean
        get() = nonReadable()
        set(value) {
            builder.withShowDrawerOnFirstLaunch(value)
        }

    /**
     * Convenience for showDrawerOnFirstLaunch
     */
    var showOnFirstLaunch: Boolean
        get() = nonReadable()
        set(value) {
            builder.withShowDrawerOnFirstLaunch(value)
        }

    // TODO document well
    var showDrawerUntilDraggedOpened: Boolean
        get() = nonReadable()
        set(value) {
            builder.withShowDrawerUntilDraggedOpened(value)
        }

    /**
     * Convenience for showDrawerUntilDraggedOpened
     */
    // TODO consider renaming
    var showUntilDraggedOpened: Boolean
        get() = nonReadable()
        set(value) {
            builder.withShowDrawerUntilDraggedOpened(value)
        }

    var sliderBackgroundColor: Int
        get() = nonReadable()
        set(value) {
            builder.withSliderBackgroundColor(value)
        }

    var sliderBackgroundColorRes: Int
        get() = nonReadable()
        set(value) {
            builder.withSliderBackgroundColorRes(value)
        }

    var sliderBackgroundDrawable: Drawable
        get() = nonReadable()
        set(value) {
            builder.withSliderBackgroundDrawable(value)
        }

    var sliderBackgroundDrawableRes: Int
        get() = nonReadable()
        set(value) {
            builder.withSliderBackgroundDrawableRes(value)
        }

    var stickyFooter: ViewGroup
        get() = nonReadable()
        set(value) {
            builder.withStickyFooter(value)
        }

    var stickyFooterRes: Int
        get() = nonReadable()
        set(value) {
            builder.withStickyFooter(value)
        }

    var stickyFooterDivider: Boolean
        get() = nonReadable()
        set(value) {
            builder.withStickyFooterDivider(value)
        }

    var stickyFooterShadow: Boolean
        get() = nonReadable()
        set(value) {
            builder.withStickyFooterShadow(value)
        }

    var stickyHeader: ViewGroup
        get() = nonReadable()
        set(value) {
            builder.withStickyHeader(value)
        }

    var stickyHeaderRes: Int
        get() = nonReadable()
        set(value) {
            builder.withStickyHeader(value)
        }

    var stickyHeaderShadow: Boolean
        get() = nonReadable()
        set(value) {
            builder.withStickyHeaderShadow(value)
        }

    var systemUIHidden: Boolean
        get() = nonReadable()
        set(value) {
            builder.withSystemUIHidden(value)
        }

    var toolbar: Toolbar
        get() = nonReadable()
        set(value) {
            builder.withToolbar(value)
        }

    var translucentNavigationBar: Boolean
        get() = nonReadable()
        set(value) {
            builder.withTranslucentNavigationBar(value)
        }

    /**
     * Convenience for translucentNavigationBar
     */
    var supportTranslucentNavBar: Boolean
        get() = nonReadable()
        set(value) {
            builder.withTranslucentNavigationBar(value)
        }

    var translucentNavigationBarProgrammatically: Boolean
        get() = nonReadable()
        set(value) {
            builder.withTranslucentNavigationBarProgrammatically(value)
        }

    /**
     * Convenience for translucentNavigationBarProgrammatically
     */
    var translucentNavBar: Boolean
        get() = nonReadable()
        set(value) {
            builder.withTranslucentNavigationBarProgrammatically(value)
        }

    var translucentStatusBar: Boolean
        get() = nonReadable()
        set(value) {
            builder.withTranslucentStatusBar(value)
        }

}
