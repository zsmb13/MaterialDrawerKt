package co.zsmb.materialdrawerkt.builders

import android.app.Activity
import android.graphics.drawable.Drawable
import android.os.Bundle
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

/**
 * Adds a navigation drawer to this Activity.
 * @return The created Drawer instance
 */

fun Activity.drawer(setup: DrawerBuilderKt.() -> Unit = {}): Drawer {
    val builder = DrawerBuilderKt(this)
    builder.setup()
    return builder.build()
}

@Suppress("unused")
@DrawerMarker
class DrawerBuilderKt(val activity: Activity) : BuilderBase() {

    /* Builder basics */

    private val builder = DrawerBuilder(activity)

    internal fun build(): Drawer {
        builder.withOnDrawerListener(onDrawerListener)

        primaryDrawer?.let { return builder.append(it) }

        return builder.build()
    }

    @Deprecated(level = DeprecationLevel.ERROR,
            message = "Drawers can't be nested.")
    fun drawer(param: () -> Unit = {}) {
    }

    /* Special things */

    override fun attachItem(item: IDrawerItem<*, *>) {
        builder.addDrawerItems(item)
    }

    internal fun attachHeader(header: AccountHeader) {
        builder.withAccountHeader(header)
    }

    /* DrawerBuilder methods */

    /**
     * A custom ActionBarDrawerToggle to be used in with this drawer.
     *
     * Non readable property. Wraps the withActionBarDrawerToggle function.
     */
    var actionBarDrawerToggle: ActionBarDrawerToggle
        get() = nonReadable()
        set(value) {
            builder.withActionBarDrawerToggle(value)
        }

    /**
     * Whether the toolbar should have a toggle on it. Note that this requires the toolbar property to be set.
     * Default value is true.
     *
     * Non readable property. Wraps the withActionBarDrawerToggle function.
     */
    var actionBarDrawerToggleEnabled: Boolean
        get() = nonReadable()
        set(enabled) {
            builder.withActionBarDrawerToggle(enabled)
        }

    /**
     * Whether the toolbar toggle should be animated when the drawer opens/closes.
     * Default value is false.
     *
     * Non readable property. Wraps the withActionBarDrawerToggleAnimated function.
     */
    var actionBarDrawerToggleAnimated: Boolean
        get() = nonReadable()
        set(value) {
            builder.withActionBarDrawerToggleAnimated(value)
        }

    /**
     * A custom adapter for the drawer items. Not recommended.
     *
     * Non readable property. Wraps the withAdapter function.
     */
    var adapter: FastAdapter<IDrawerItem<out Any?, out RecyclerView.ViewHolder>>
        get() = nonReadable()
        set(value) {
            builder.withAdapter(value)
        }

    /**
     * An adapter which wraps the main adapter used in the RecyclerView to allow extended navigation. Can only be used
     * if the normal adapter property is set. Not recommended.
     *
     * Non readable property. Wraps the withAdapterWrapper function.
     */
    var adapterWrapper: RecyclerView.Adapter<out RecyclerView.ViewHolder>
        get() = nonReadable()
        set(value) {
            builder.withAdapterWrapper(value)
        }

    /**
     * Whether the drawer should close if an item is clicked.
     * Default value is true.
     *
     * Non readable property. Wraps the withCloseOnClick function.
     */
    var closeOnClick: Boolean
        get() = nonReadable()
        set(value) {
            builder.withCloseOnClick(value)
        }

    /**
     * Override for the entire drawer view.
     *
     * Non readable property. Wraps the withCustomView function.
     */
    var customView: View
        get() = nonReadable()
        set(value) {
            builder.withCustomView(value)
        }

    /**
     * The delay (in milliseconds) for the drawer click event after a click. This can be used to improve performance
     * and prevent lag, especially when you switch fragments inside the listener. This will ignore the Boolean value
     * you can return in the listener, as the listener is called after the drawer was closed.
     * The default value is -1, which disables this setting entirely.
     *
     * Non readable property. Wraps the withDelayDrawerClickEvent function.
     */
    var delayDrawerClickEvent: Int
        get() = nonReadable()
        set(value) {
            builder.withDelayDrawerClickEvent(value)
        }

    /**
     * The delay (in milliseconds) for the drawer close operation after a click. This is a small trick to improve
     * performance and prevent lag if you open a new Activity after a drawer item was selected. Set to -1 to disable
     * this behavior entirely.
     * The default value is 50.
     *
     * Non readable property. Wraps the withDelayOnDrawerClose function.
     */
    var delayOnDrawerClose: Int
        get() = nonReadable()
        set(value) {
            builder.withDelayOnDrawerClose(value)
        }

    /**
     * Whether the drawer should be displayed below the status bar.
     * Default value is true.
     *
     * Non readable property. Wraps the withDisplayBelowStatusBar function.
     */
    var displayBelowStatusBar: Boolean
        get() = nonReadable()
        set(value) {
            builder.withDisplayBelowStatusBar(value)
        }

    /**
     * Sets the position of the drawer. Valid values are Gravity.START/LEFT and Gravity.END/RIGHT.
     * Default value is Gravity.START.
     *
     * Non readable property. Wraps the withDrawerGravity function.
     */
    var drawerGravity: Int
        get() = nonReadable()
        set(value) {
            builder.withDrawerGravity(value)
        }

    /**
     * Sets the position of the drawer. Valid values are Gravity.START/LEFT and Gravity.END/RIGHT.
     * Default value is Gravity.START.
     *
     * Convenience for the `drawerGravity` property. Non readable property. Wraps the withDrawerGravity function.
     */
    var gravity: Int
        get() = nonReadable()
        set(value) {
            builder.withDrawerGravity(value)
        }

    /**
     * Override of the entire drawer with a DrawerLayout.
     *
     * Non readable property. Wraps the withDrawerLayout function.
     */
    var drawerLayout: DrawerLayout
        get() = nonReadable()
        set(value) {
            builder.withDrawerLayout(value)
        }

    /**
     * Override the entire drawer with a layout from a layout resource file.
     *
     * Non readable property. Wraps the withDrawerLayout function.
     */
    var drawerLayoutRes: Int
        get() = nonReadable()
        set(value) {
            builder.withDrawerLayout(value)
        }

    /**
     * The width of the drawer in dps.
     *
     * Non readable property. Wraps the withDrawerWidthDp function.
     */
    var drawerWidthDp: Int
        get() = nonReadable()
        set(value) {
            builder.withDrawerWidthDp(value)
        }

    /**
     * The width of the drawer in dps.
     *
     * Convenience for drawerWidthDp. Non readable property. Wraps the withDrawerWidthDp function.
     */
    var widthDp: Int
        get() = nonReadable()
        set(value) {
            builder.withDrawerWidthDp(value)
        }

    /**
     * The width of the drawer in pixels.
     *
     * Non readable property. Wraps the withDrawerWidthPx function.
     */
    var drawerWidthPx: Int
        get() = nonReadable()
        set(value) {
            builder.withDrawerWidthPx(value)
        }

    /**
     * The width of the drawer in pixels.
     *
     * Convenience for drawerWidthDp. Non readable property. Wraps the withDrawerWidthPx function.
     */
    var widthPx: Int
        get() = nonReadable()
        set(value) {
            builder.withDrawerWidthPx(value)
        }

    /**
     * The width of the drawer as a dimension resource.
     *
     * Non readable property. Wraps the withDrawerWidthRes function.
     */
    var drawerWidthRes: Int
        get() = nonReadable()
        set(value) {
            builder.withDrawerWidthRes(value)
        }

    /**
     * The width of the drawer as a dimension resource.
     *
     * Convenience for drawerWidthDp. Non readable property. Wraps the withDrawerWidthRes function.
     */
    var widthRes: Int
        get() = nonReadable()
        set(value) {
            builder.withDrawerWidthRes(value)
        }

    /**
     * If set to true, you'll receive a click event on the item that's selected by default when the drawer is created.
     *
     * Non readable property. Wraps the withFireOnInitialOnClick function.
     */
    var fireOnInitialOnClick: Boolean
        get() = nonReadable()
        set(value) {
            builder.withFireOnInitialOnClick(value)
        }

    fun footer(setup: StickyFooterKt.() -> Unit = {}) {
        StickyFooterKt(builder).setup()
    }

    /**
     * An arbitrary View to use as the scrolling footer of the drawer item list.
     *
     * Non readable property. Wraps the withFooter function.
     */
    var footerView: View
        get() = nonReadable()
        set(value) {
            builder.withFooter(value)
        }

    /**
     * An arbitrary layout resource to use as the scrolling footer of the drawer item list.
     *
     * Non readable property. Wraps the withFooter function.
     */
    var footerRes: Int
        get() = nonReadable()
        set(value) {
            builder.withFooter(value)
        }

    /**
     * Whether the footer of the drawer is clickable.
     *
     * Non readable property. Wraps the withFooterClickable function.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            message = "This has no effect as of Material Drawer version 5.9.0")
    var footerClickable: Boolean
        get() = nonReadable()
        set(value) {
            builder.withFooterClickable(value)
        }

    /**
     * Whether there should be a divider above the footer.
     * Default value is true.
     *
     * Non readable property. Wraps the withFooterDivider function.
     */
    var footerDivider: Boolean
        get() = nonReadable()
        set(value) {
            builder.withFooterDivider(value)
        }

    /**
     * Set to true if the used theme has a translucent statusBar and navigationBar and you want to manage the padding
     * on your own. (Documentation inherited from original library. Not sure if it makes any difference.)
     * Default value is false.
     *
     * Non readable property. Wraps the withFullscreen function.
     */
    var fullscreen: Boolean
        get() = nonReadable()
        set(value) {
            builder.withFullscreen(value)
        }

    /**
     * Whether the generated adapter should have its `hasStableIds` set to true. Only enable if you have set unique
     * identifiers for all of your items.
     * Default value is false.
     *
     * Non readable property. Wraps the withHasStableIds function.
     */
    var hasStableIds: Boolean
        get() = nonReadable()
        set(value) {
            builder.withHasStableIds(value)
        }

    /**
     * An arbitrary View to use as the header of the drawer.
     *
     * Non readable property. Wraps the withHeader function.
     */
    var header: View
        get() = nonReadable()
        set(value) {
            builder.withHeader(value)
        }

    /**
     * An arbitrary View to use as the header of the drawer, as a layout resource.
     *
     * Non readable property. Wraps the withHeader function.
     */
    var headerRes: Int
        get() = nonReadable()
        set(value) {
            builder.withHeader(value)
        }

    /**
     * Whether there should be a divider below the header.
     * Default value is true.
     *
     * Non readable property. Wraps the withHeaderDivider function.
     */
    var headerDivider: Boolean
        get() = nonReadable()
        set(value) {
            builder.withHeaderDivider(value)
        }

    /**
     * The height of the header provided with the `headerView` or `headerRes` properties, as a DimenHolder.
     *
     * Non readable property. Wraps the withHeaderHeight function.
     */
    var headerHeight: DimenHolder
        get() = nonReadable()
        set(value) {
            builder.withHeaderHeight(value)
        }

    /**
     * The height of the header provided with the `headerView` or `headerRes` properties, in dps.
     *
     * Convenience for headerHeight. Non readable property. Wraps the withHeaderHeight function.
     */
    var headerHeightDp: Int
        get() = nonReadable()
        set(value) {
            builder.withHeaderHeight(DimenHolder.fromDp(value))
        }

    /**
     * The height of the header provided with the `headerView` or `headerRes` properties, in pixels.
     *
     * Convenience for headerHeight. Non readable property. Wraps the withHeaderHeight function.
     */
    var headerHeightPx: Int
        get() = nonReadable()
        set(value) {
            builder.withHeaderHeight(DimenHolder.fromPixel(value))
        }

    /**
     * The height of the header provided with the `headerView` or `headerRes` properties, as a dimension resource.
     *
     * Convenience for headerHeight. Non readable property. Wraps the withHeaderHeight function.
     */
    var headerHeightRes: Int
        get() = nonReadable()
        set(value) {
            builder.withHeaderHeight(DimenHolder.fromResource(value))
        }

    /**
     * Whether there should be padding below the header of the drawer.
     * Default value is true.
     *
     * Non readable property. Wraps the withHeaderPadding function.
     */
    var headerPadding: Boolean
        get() = nonReadable()
        set(value) {
            builder.withHeaderPadding(value)
        }

    /**
     * Whether the drawer should have an inner shadow on its edge. Recommended to be used with mini drawer.
     * Default value is false.
     *
     * Non readable property. Wraps the withInnerShadow function.
     */
    var innerShadow: Boolean
        get() = nonReadable()
        set(value) {
            builder.withInnerShadow(value)
        }

    /**
     * The ItemAnimator of the internal RecyclerView.
     *
     * Non readable property. Wraps the withItemAnimator function.
     */
    var itemAnimator: RecyclerView.ItemAnimator
        get() = nonReadable()
        set(value) {
            builder.withItemAnimator(value)
        }

    /**
     * Inflates DrawerItems from the given menu resource and adds them to the drawer.
     *
     * Non readable property. Wraps the inflateMenu method.
     */
    var menuItemsRes: Int
        get() = nonReadable()
        set(value) {
            builder.inflateMenu(value)
        }

    /**
     * Enables multiple selections amongst drawer items.
     *
     * Non readable property. Wraps the withMultiSelect function.
     */
    var multiSelect: Boolean
        get() = nonReadable()
        set(value) {
            builder.withMultiSelect(value)
        }

    /**
     * Adds an event [handler] to the drawer that's called when an item is clicked. The handler should return true if
     * the event has been completely handled.
     *
     * Wraps the withOnDrawerItemClickListener method.
     *
     * @param view The View that was clicked
     * @param position The position of the clicked item within the drawer
     * @param drawerItem The clicked drawer item
     */
    fun onItemClick(handler: (view: View, position: Int, drawerItem: IDrawerItem<*, *>) -> Boolean) {
        builder.withOnDrawerItemClickListener(handler)
    }

    /**
     * Adds an event [handler] to the drawer that's called when an item is clicked. The handler should return true if
     * the event has been completely handled.
     *
     * Convenience for the three parameter onItemClick() method, to be used when you don't need all its parameters.
     * Wraps the withOnDrawerItemClickListener method.
     *
     * @param position The position of the clicked item within the drawer
     */
    fun onItemClick(handler: (position: Int) -> Boolean) {
        builder.withOnDrawerItemClickListener { view, position, drawerItem -> handler(position) }
    }

    /**
     * Adds an event [handler] to the drawer that's called when an item is long clicked. The handler should return true
     * if the event has been completely handled.
     *
     * Wraps the withOnDrawerItemLongClickListener method.
     *
     * @param view The View that was clicked
     * @param position The position of the clicked item within the drawer
     * @param drawerItem The clicked drawer item
     */
    fun onItemLongClick(handler: (view: View, position: Int, drawerItem: IDrawerItem<*, *>) -> Boolean) {
        builder.withOnDrawerItemLongClickListener(handler)
    }

    /**
     * Adds an event [handler] to the drawer that's called when an item is long clicked. The handler should return true
     * if the event has been completely handled.
     *
     * Convenience for the three parameter onItemLongClick() method, to be used when you don't need all its parameters.
     * Wraps the withOnDrawerItemLongClickListener method.
     *
     * @param position The position of the clicked item within the drawer
     */
    fun onItemLongClick(handler: (position: Int) -> Boolean) {
        builder.withOnDrawerItemLongClickListener { view, position, drawerItem -> handler(position) }
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

    /**
     * Adds an event [handler] to the drawer that's called when the drawer is sliding.
     *
     * Wraps the withOnDrawerListener method.
     *
     * @param drawerView The root View of the drawer
     * @param slideOffset The amount to which the drawer is open, as a number between 0 (closed) and 1 (open)
     */
    fun onSlide(handler: (drawerView: View, slideOffset: Float) -> Unit) {
        onDrawerListener.onSlide = handler
    }

    /**
     * Adds an event [handler] to the drawer that's called when the drawer is closed.
     *
     * Wraps the withOnDrawerListener method.
     *
     * @param drawerView The root View of the drawer
     */
    fun onClosed(handler: (drawerView: View) -> Unit) {
        onDrawerListener.onClosed = handler
    }

    /**
     * Adds an event [handler] to the drawer that's called when the drawer is opened.
     *
     * Wraps the withOnDrawerListener method.
     *
     * @param drawerView The root View of the drawer
     */
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

    /**
     * Whether to use position based state management in the internal adapter. This allows high performance for very
     * long lists. If set to false, the new identifier based state management will be used, which provides more
     * flexibility, but has worse performance with long lists.
     * Default value is true.
     *
     * Non readable property. Wraps the withPositionBasedStateManagement function.
     */
    var positionBasedStateManagement: Boolean
        get() = nonReadable()
        set(value) {
            builder.withPositionBasedStateManagement(value)
        }

    /**
     * The primary drawer that's already present in the Activity. This is to be set when the current drawer is the
     * second drawer in an Activity.
     *
     * Non readable property. Wraps the append(value) function.
     */
    var primaryDrawer: Drawer? = null
        get() = field
        set(value) {
            if (value != null) {
                field = value
            }
        }

    /**
     * A custom RecyclerView for the drawer items. Not recommended.
     *
     * Non readable property. Wraps the withRecyclerView function.
     */
    var recyclerView: RecyclerView
        get() = nonReadable()
        set(value) {
            builder.withRecyclerView(value)
        }

    /**
     * The ViewGroup which will host the DrawerLayout. The content of this view will be extracted and added as the new
     * content inside the DrawerLayout.
     *
     * Non readable property. Wraps the withRootView function.
     */
    var rootView: ViewGroup
        get() = nonReadable()
        set(value) {
            builder.withRootView(value)
        }

    /**
     * The ViewGroup which will host the DrawerLayout, as a layout resource. The content of this view will be extracted
     * and added as the new content inside the DrawerLayout.
     *
     * Non readable property. Wraps the withRootView function.
     */
    var rootViewRes: Int
        get() = nonReadable()
        set(value) {
            builder.withRootView(value)
        }

    /**
     * The bundle to restore state from after a configuration change. Remember to store the Drawer instance and call
     * its `saveInstanceState` method in the Activity's `onSaveInstanceState` method, before calling super, to store
     * the current state of the drawer.
     *
     * Non readable property. Wraps the withSavedInstance function.
     */
    var savedInstance: Bundle?
        get() = nonReadable()
        set(value) {
            builder.withSavedInstance(value)
        }

    /**
     * Whether the drawer should scroll to the top after an item has been clicked.
     * Default value is false.
     *
     * Non readable property. Wraps the withScrollToTopAfterClick function.
     */
    var scrollToTopAfterClick: Boolean
        get() = nonReadable()
        set(value) {
            builder.withScrollToTopAfterClick(value)
        }

    /**
     * The identifier of the item that should be selected by default.
     * Default value is 0L.
     *
     * Non readable property. Wraps the withSelectedItem function.
     */
    var selectedItem: Long
        get() = nonReadable()
        set(value) {
            builder.withSelectedItem(value)
        }

    /**
     * The position of the item that should be selected by default.
     * Default value is 0.
     *
     * Non readable property. Wraps the withSelectedItemByPosition function.
     */
    var selectedItemByPosition: Int
        get() = nonReadable()
        set(value) {
            builder.withSelectedItemByPosition(value)
        }

    /**
     * Whether to automatically open the drawer the first time the user opens this Activity.
     * Default value is false.
     *
     * Non readable property. Wraps the withShowDrawerOnFirstLaunch function.
     */
    var showDrawerOnFirstLaunch: Boolean
        get() = nonReadable()
        set(value) {
            builder.withShowDrawerOnFirstLaunch(value)
        }

    /**
     * Whether to automatically open the drawer the first time the user opens this Activity.
     * Default value is false.
     *
     * Convenience for the `showDrawerOnFirstLaunch` property. Non readable property. Wraps the
     * withShowDrawerOnFirstLaunch method.
     */
    var showOnFirstLaunch: Boolean
        get() = nonReadable()
        set(value) {
            builder.withShowDrawerOnFirstLaunch(value)
        }

    /**
     * Whether to automatically open the drawer every time the user opens this Activity, until they've opened it once
     * themselves.
     * Default value is false.
     *
     * Non readable property. Wraps the withShowDrawerUntilDraggedOpened function.
     */
    var showDrawerUntilDraggedOpened: Boolean
        get() = nonReadable()
        set(value) {
            builder.withShowDrawerUntilDraggedOpened(value)
        }

    /**
     * Whether to automatically open the drawer every time the user opens this Activity, until they've opened it once
     * themselves.
     * Default value is false.
     *
     * Convenience for the `showDrawerUntilDraggedOpened` property. Non readable property. Wraps the
     * withShowDrawerUntilDraggedOpened method.
     */
    var showUntilDraggedOpened: Boolean
        get() = nonReadable()
        set(value) {
            builder.withShowDrawerUntilDraggedOpened(value)
        }

    /**
     * The background color of the drawer item list, given as an argb Long.
     *
     * Non readable property. Wraps the withSliderBackgroundColor function.
     */
    var sliderBackgroundColor: Long
        get() = nonReadable()
        set(value) {
            builder.withSliderBackgroundColor(value.toInt())
        }

    /**
     * The background color of the drawer item list, given as a color resource.
     *
     * Non readable property. Wraps the withSliderBackgroundColorRes function.
     */
    var sliderBackgroundColorRes: Int
        get() = nonReadable()
        set(value) {
            builder.withSliderBackgroundColorRes(value)
        }

    /**
     * The background of the drawer item list, given as a Drawable.
     *
     * Non readable property. Wraps the withSliderBackgroundDrawable function.
     */
    var sliderBackgroundDrawable: Drawable
        get() = nonReadable()
        set(value) {
            builder.withSliderBackgroundDrawable(value)
        }

    /**
     * The background of the drawer item list, given as a drawable resource.
     *
     * Non readable property. Wraps the withSliderBackgroundDrawableRes function.
     */
    var sliderBackgroundDrawableRes: Int
        get() = nonReadable()
        set(value) {
            builder.withSliderBackgroundDrawableRes(value)
        }

    /**
     * An arbitrary View to use as the always visible footer of the drawer itself.
     *
     * Non readable property. Wraps the withStickyFooter function.
     */
    var stickyFooter: ViewGroup
        get() = nonReadable()
        set(value) {
            builder.withStickyFooter(value)
        }

    /**
     * An arbitrary layout resource to use as the always visible footer of the drawer itself.
     *
     * Non readable property. Wraps the withStickyFooter function.
     */
    var stickyFooterRes: Int
        get() = nonReadable()
        set(value) {
            builder.withStickyFooter(value)
        }

    /**
     * Whether there should be a divider above the sticky footer.
     * Default value is false.
     *
     * Non readable property. Wraps the withStickyFooterDivider function.
     */
    var stickyFooterDivider: Boolean
        get() = nonReadable()
        set(value) {
            builder.withStickyFooterDivider(value)
        }

    /**
     * Whether the sticky footer should cast a shadow on the drawer item list.
     * Default value is true.
     *
     * Non readable property. Wraps the withStickyFooterShadow function.
     */
    var stickyFooterShadow: Boolean
        get() = nonReadable()
        set(value) {
            builder.withStickyFooterShadow(value)
        }

    /**
     * An arbitrary View to use as the always visible header of the drawer itself.
     *
     * Non readable property. Wraps the withStickyHeader function.
     */
    var stickyHeader: ViewGroup
        get() = nonReadable()
        set(value) {
            builder.withStickyHeader(value)
        }

    /**
     * An arbitrary layout resource to use as the always visible header of the drawer itself.
     *
     * Non readable property. Wraps the withStickyHeader function.
     */
    var stickyHeaderRes: Int
        get() = nonReadable()
        set(value) {
            builder.withStickyHeader(value)
        }

    /**
     * Whether the sticky header should cast a shadow on the drawer item list (or the account header, if present).
     * Default value is true.
     *
     * Non readable property. Wraps the withStickyHeaderShadow function.
     */
    var stickyHeaderShadow: Boolean
        get() = nonReadable()
        set(value) {
            builder.withStickyHeaderShadow(value)
        }

    /**
     * To be used when you run your Activity in full screen mode, with hidden status bar and toolbar.
     * Default value is false.
     *
     * Non readable property. Wraps the withSystemUIHidden function.
     */
    var systemUIHidden: Boolean
        get() = nonReadable()
        set(value) {
            builder.withSystemUIHidden(value)
        }

    /**
     * The Toolbar in the Activity that's to be used with the drawer. This will handle creating the toggle for opening
     * and closing the drawer.
     *
     * Non readable property. Wraps the withToolbar function.
     */
    var toolbar: Toolbar
        get() = nonReadable()
        set(value) {
            builder.withToolbar(value)
        }

    /**
     * To be used when you have a translucent navigation bar.
     * Default value is false.
     *
     * Non readable property. Wraps the withTranslucentNavigationBar function.
     */
    var translucentNavigationBar: Boolean
        get() = nonReadable()
        set(value) {
            builder.withTranslucentNavigationBar(value)
        }

    /**
     * To be used when you have a translucent navigation bar.
     * Default value is false.
     *
     * Convenience for the `translucentNavigationBar` property. Non readable property. Wraps the
     * withTranslucentNavigationBar method.
     */
    var supportTranslucentNavBar: Boolean
        get() = nonReadable()
        set(value) {
            builder.withTranslucentNavigationBar(value)
        }

    /**
     * If set to true, it makes the navigation bar translucent programatically.
     * Default value is false.
     *
     * Non readable property. Wraps the withTranslucentNavigationBarProgrammatically function.
     */
    var translucentNavigationBarProgrammatically: Boolean
        get() = nonReadable()
        set(value) {
            builder.withTranslucentNavigationBarProgrammatically(value)
        }

    /**
     * If set to true, it makes the navigation bar translucent programatically.
     * Default value is false.
     *
     * Convenience for the `translucentNavigationBarProgrammatically` property. Non readable property. Wraps the
     * withTranslucentNavigationBarProgrammatically function.
     */
    var translucentNavBar: Boolean
        get() = nonReadable()
        set(value) {
            builder.withTranslucentNavigationBarProgrammatically(value)
        }

    /**
     * Whether the View hosting the DrawerLayout should have a translucent status bar. This enables displaying the
     * drawer under the status bar.
     * Default value is true.
     *
     * Non readable property. Wraps the withTranslucentStatusBar function.
     */
    var translucentStatusBar: Boolean
        get() = nonReadable()
        set(value) {
            builder.withTranslucentStatusBar(value)
        }

}
