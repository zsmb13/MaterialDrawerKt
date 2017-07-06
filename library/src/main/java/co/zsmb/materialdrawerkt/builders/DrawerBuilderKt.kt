package co.zsmb.materialdrawerkt.builders

import android.app.Activity
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.app.Fragment
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

/**
 * Adds a navigation drawer to this Fragment.
 * @return The created Drawer instance
 */
fun Fragment.drawer(setup: DrawerBuilderKt.() -> Unit = {}): Drawer {
    val builder = DrawerBuilderKt(activity)
    builder.setup()
    return builder.buildForFragment()
}

@DrawerMarker
class DrawerBuilderKt(val activity: Activity) : Builder {

    /* Builder basics */

    val builder = DrawerBuilder(activity)

    internal fun build(): Drawer {
        if (onDrawerListener.isInitialized) {
            builder.withOnDrawerListener(onDrawerListener)
        }

        if (buildViewOnly) {
            return builder.buildView()
        }

        root?.let {
            val drawerResult = builder.buildView()
            it.addView(drawerResult.slider)
            return drawerResult
        }

        primaryDrawer?.let { return builder.append(it) }

        return builder.build()
    }

    internal fun buildForFragment(): Drawer {
        if (onDrawerListener.isInitialized) {
            builder.withOnDrawerListener(onDrawerListener)
        }

        return builder.buildForFragment()
    }

    /**
     * A shadowing method to prevent nesting [drawer][co.zsmb.materialdrawerkt.builders.drawer] calls.
     * ( Credits to hotkey for this solution http://stackoverflow.com/a/43470027/4465208 )
     */
    @Suppress("UNUSED_PARAMETER")
    @Deprecated(level = DeprecationLevel.ERROR,
            message = "Drawers can't be nested.")
    fun drawer(param: () -> Unit = {}) {
    }

    @Deprecated(level = DeprecationLevel.WARNING,
            message = "Only for use with custom drawer items.")
    override fun attachItem(item: IDrawerItem<*, *>) {
        builder.addDrawerItems(item)
    }

    internal fun attachHeader(header: AccountHeader) {
        builder.withAccountHeader(header)
    }

    /* Build helper */

    private var root: ViewGroup? = null

    /**
     * Setting this to true will not attach the drawer to the Activity. Instead, you can call [Drawer.getSlider]  to get
     * the root view of the created drawer, and add it to a ViewGroup yourself.
     * Default value is false.
     *
     * Wraps the [DrawerBuilder.buildView] method.
     */
    var buildViewOnly: Boolean = false

    /**
     * The ViewGroup which the DrawerLayout will be added to.
     *
     * This is equivalent to setting the [buildViewOnly] property, or, with the original library, using
     * [DrawerBuilder.buildView]. The difference is that you don't have to manually add the drawer to the ViewGroup.
     *
     * Non readable property.
     */
    var parentView: ViewGroup
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            root = value
        }

    /**
     * The ViewGroup which the DrawerLayout will be added to, given by its layout ID.
     *
     * This is equivalent to setting the [buildViewOnly] property, or, with the original library, using
     * [DrawerBuilder.buildView]. The difference is that you don't have to manually add the drawer to the ViewGroup.
     *
     * Non readable property.
     */
    var parentViewRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            root = activity.findViewById(value) as ViewGroup?
        }

    /* Listener helper */

    private val onDrawerListener = object : Drawer.OnDrawerListener {
        var isInitialized = false

        var onSlide: ((View, Float) -> Unit)? = null
            set(value) {
                isInitialized = true
                field = value
            }

        override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
            onSlide?.invoke(drawerView, slideOffset)
        }

        var onClosed: ((View) -> Unit)? = null
            set(value) {
                isInitialized = true
                field = value
            }

        override fun onDrawerClosed(drawerView: View) {
            onClosed?.invoke(drawerView)
        }

        var onOpened: ((View) -> Unit)? = null
            set(value) {
                isInitialized = true
                field = value
            }

        override fun onDrawerOpened(drawerView: View) {
            onOpened?.invoke(drawerView)
        }
    }

    /* DrawerBuilder methods */

    /**
     * A custom ActionBarDrawerToggle to be used in with this drawer.
     *
     * Non readable property. Wraps the [DrawerBuilder.withActionBarDrawerToggle] method.
     */
    var actionBarDrawerToggle: ActionBarDrawerToggle
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withActionBarDrawerToggle(value)
        }

    /**
     * Whether the toolbar toggle should be animated when the drawer opens/closes.
     * Default value is false.
     *
     * Non readable property. Wraps the [DrawerBuilder.withActionBarDrawerToggleAnimated] method.
     */
    var actionBarDrawerToggleAnimated: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withActionBarDrawerToggleAnimated(value)
        }

    /**
     * Whether the toolbar should have a toggle on it. Note that this requires the toolbar property to be set.
     * Default value is true.
     *
     * Non readable property. Wraps the [DrawerBuilder.withActionBarDrawerToggle] method.
     */
    var actionBarDrawerToggleEnabled: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(enabled) {
            builder.withActionBarDrawerToggle(enabled)
        }

    /**
     * A custom adapter for the drawer items. Not recommended.
     *
     * Non readable property. Wraps the [DrawerBuilder.withAdapter] method.
     */
    var adapter: FastAdapter<IDrawerItem<out Any?, out RecyclerView.ViewHolder>>
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withAdapter(value)
        }

    /**
     * An adapter which wraps the main adapter used in the RecyclerView to allow extended navigation. Can only be used
     * if the normal adapter property is set. Not recommended.
     *
     * Non readable property. Wraps the [DrawerBuilder.withAdapterWrapper] method.
     */
    var adapterWrapper: RecyclerView.Adapter<out RecyclerView.ViewHolder>
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withAdapterWrapper(value)
        }

    /**
     * Whether the drawer should close if an item is clicked.
     * Default value is true.
     *
     * Non readable property. Wraps the [DrawerBuilder.withCloseOnClick] method.
     */
    var closeOnClick: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withCloseOnClick(value)
        }

    /**
     * Override for the entire drawer view.
     *
     * Non readable property. Wraps the [DrawerBuilder.withCustomView] method.
     */
    var customView: View
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withCustomView(value)
        }

    /**
     * Override for the entire drawer view, as a layout resource.
     *
     * Non readable property. Wraps the [DrawerBuilder.withCustomView] method.
     */
    var customViewRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            val view = activity.layoutInflater.inflate(value, null)
            builder.withCustomView(view)
        }

    /**
     * The delay (in milliseconds) for the drawer click event after a click.
     *
     * This can be used to improve performance and prevent lag, especially when you switch fragments inside the
     * listener. This will ignore the Boolean value you can return in the listener, as the listener is called after the
     * drawer was closed.
     * Default value is -1, which disables this setting entirely.
     *
     * Non readable property. Wraps the [DrawerBuilder.withDelayDrawerClickEvent] method.
     */
    var delayDrawerClickEvent: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withDelayDrawerClickEvent(value)
        }

    /**
     * The delay (in milliseconds) for the drawer close operation after a click.
     *
     * This is a small trick to improve performance and prevent lag if you open a new Activity after a drawer item was
     * selected. Set to -1 to disable this behavior entirely.
     * Default value is 50.
     *
     * Non readable property. Wraps the [DrawerBuilder.withDelayOnDrawerClose] method.
     */
    var delayOnDrawerClose: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withDelayOnDrawerClose(value)
        }

    /**
     * Whether the drawer should be displayed below the status bar.
     * Default value is true.
     *
     * Non readable property. Wraps the [DrawerBuilder.withDisplayBelowStatusBar] method.
     */
    var displayBelowStatusBar: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withDisplayBelowStatusBar(value)
        }

    /**
     * Sets the position of the drawer. Valid values are Gravity.START/LEFT and Gravity.END/RIGHT.
     * Default value is Gravity.START.
     *
     * See [gravity] as an alternative.
     *
     * Non readable property. Wraps the [DrawerBuilder.withDrawerGravity] method.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            message = "Alternatives are available, check the documentation.")
    var drawerGravity: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withDrawerGravity(value)
        }

    /**
     * Override of the entire drawer's layout with a DrawerLayout.
     *
     * Non readable property. Wraps the [DrawerBuilder.withDrawerLayout] method.
     */
    var drawerLayout: DrawerLayout
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withDrawerLayout(value)
        }

    /**
     * Override the entire drawer's layout with a DrawerLayout from a layout resource file.
     *
     * Non readable property. Wraps the [DrawerBuilder.withDrawerLayout] method.
     */
    var drawerLayoutRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withDrawerLayout(value)
        }

    /**
     * The width of the drawer in dps.
     *
     * See [widthDp] as an alternative.
     *
     * Non readable property. Wraps the [DrawerBuilder.withDrawerWidthDp] method.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            message = "Alternatives are available, check the documentation.")
    var drawerWidthDp: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withDrawerWidthDp(value)
        }

    /**
     * The width of the drawer in pixels.
     *
     * See [widthPx] as an alternative.
     *
     * Non readable property. Wraps the [DrawerBuilder.withDrawerWidthPx] method.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            message = "Alternatives are available, check the documentation.")
    var drawerWidthPx: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withDrawerWidthPx(value)
        }

    /**
     * The width of the drawer as a dimension resource.
     *
     * See [widthRes] as an alternative.
     *
     * Non readable property. Wraps the [DrawerBuilder.withDrawerWidthRes] method.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            message = "Alternatives are available, check the documentation.")
    var drawerWidthRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withDrawerWidthRes(value)
        }

    /**
     * If set to true, you'll receive a click event on the item that's selected by default when the drawer is created.
     * Default value is false.
     *
     * Non readable property. Wraps the [DrawerBuilder.withFireOnInitialOnClick] method.
     */
    var fireOnInitialOnClick: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withFireOnInitialOnClick(value)
        }

    /**
     * Whether the footer of the drawer is clickable.
     * Default value is false.
     *
     * Non readable property. Wraps the [DrawerBuilder.withFooterClickable] method.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            message = "This has no effect as of Material Drawer version 5.9.0")
    var footerClickable: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withFooterClickable(value)
        }

    /**
     * Whether there should be a divider above the footer.
     * Default value is true.
     *
     * Non readable property. Wraps the [DrawerBuilder.withFooterDivider] method.
     */
    var footerDivider: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withFooterDivider(value)
        }

    /**
     * An arbitrary View to use as the scrolling footer of the drawer item list.
     *
     * Non readable property. Wraps the [DrawerBuilder.withFooter] method.
     */
    var footerView: View
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withFooter(value)
        }

    /**
     * An arbitrary layout resource to use as the scrolling footer of the drawer item list.
     *
     * Non readable property. Wraps the [DrawerBuilder.withFooter] method.
     */
    var footerViewRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withFooter(value)
        }

    /**
     * Set to true if the used theme has a translucent statusBar and navigationBar and you want to manage the padding
     * on your own. (Documentation inherited from original library. Not sure if it makes any difference.)
     * Default value is false.
     *
     * Non readable property. Wraps the [DrawerBuilder.withFullscreen] method.
     */
    var fullscreen: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withFullscreen(value)
        }

    /**
     * Whether to generate a mini drawer for this drawer as well.
     * Default value is false.
     *
     * Non readable property. Wraps the [DrawerBuilder.withGenerateMiniDrawer] method.
     */
    var generateMiniDrawer: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withGenerateMiniDrawer(value)
        }

    /**
     * Sets the position of the drawer. Valid values are Gravity.START/LEFT and Gravity.END/RIGHT.
     * Default value is Gravity.START.
     *
     * Convenience for [drawerGravity]. Non readable property. Wraps the [DrawerBuilder.withDrawerGravity]
     * method.
     */
    var gravity: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withDrawerGravity(value)
        }

    /**
     * Whether the generated adapter should have its `hasStableIds` set to true. Only enable if you have set unique
     * identifiers for all of your items.
     * Default value is false.
     *
     * Non readable property. Wraps the [DrawerBuilder.withHasStableIds] method.
     */
    var hasStableIds: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withHasStableIds(value)
        }

    /**
     * Whether there should be a divider below the header.
     * Default value is true.
     *
     * Non readable property. Wraps the [DrawerBuilder.withHeaderDivider] method.
     */
    var headerDivider: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withHeaderDivider(value)
        }

    /**
     * The height of the header provided with the [headerView] or [headerViewRes] properties, as a DimenHolder.
     *
     * See [headerHeightDp], [headerHeightPx], and [headerHeightRes] as alternatives.
     *
     * Non readable property. Wraps the [DrawerBuilder.withHeaderHeight] method.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            message = "Use px, dp, or a dimension resource instead.")
    var headerHeight: DimenHolder
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withHeaderHeight(value)
        }

    /**
     * The height of the header provided with the [headerView] or [headerViewRes] properties, in dps.
     *
     * Convenience for [headerHeight]. Non readable property. Wraps the [DrawerBuilder.withHeaderHeight] method.
     */
    var headerHeightDp: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withHeaderHeight(DimenHolder.fromDp(value))
        }

    /**
     * The height of the header provided with the [headerView] or [headerViewRes] properties, in pixels.
     *
     * Convenience for [headerHeight]. Non readable property. Wraps the [DrawerBuilder.withHeaderHeight] method.
     */
    var headerHeightPx: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withHeaderHeight(DimenHolder.fromPixel(value))
        }

    /**
     * The height of the header provided with the [headerView] or [headerViewRes] properties, as a dimension resource.
     *
     * Convenience for [headerHeight]. Non readable property. Wraps the [DrawerBuilder.withHeaderHeight] method.
     */
    var headerHeightRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withHeaderHeight(DimenHolder.fromResource(value))
        }

    /**
     * Whether there should be padding below the header of the drawer.
     * Default value is true.
     *
     * Non readable property. Wraps the [DrawerBuilder.withHeaderPadding] method.
     */
    var headerPadding: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withHeaderPadding(value)
        }

    /**
     * An arbitrary View to use as the header of the drawer.
     *
     * Non readable property. Wraps the [DrawerBuilder.withHeader] method.
     */
    var headerView: View
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withHeader(value)
        }

    /**
     * An arbitrary View to use as the header of the drawer, as a layout resource.
     *
     * Non readable property. Wraps the [DrawerBuilder.withHeader] method.
     */
    var headerViewRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withHeader(value)
        }

    /**
     * Whether the drawer should have an inner shadow on its edge. Recommended to be used with mini drawer.
     * Default value is false.
     *
     * Non readable property. Wraps the [DrawerBuilder.withInnerShadow] method.
     */
    var innerShadow: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withInnerShadow(value)
        }

    /**
     * The ItemAnimator of the internal RecyclerView.
     *
     * Non readable property. Wraps the [DrawerBuilder.withItemAnimator] method.
     */
    var itemAnimator: RecyclerView.ItemAnimator
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withItemAnimator(value)
        }

    /**
     * Toggles if the sticky footer should stay visible upon switching to the profile list. Note that using this with
     * stickyDrawerItems can lead to the selection not being updated correctly. Use with care.
     * Default value is false.
     *
     * Non readable property. Wraps the [DrawerBuilder.withKeepStickyItemsVisible] method.
     */
    var keepStickyItemsVisible: Boolean
        get() = nonReadable()
        set(value) {
            builder.withKeepStickyItemsVisible(value)
        }

    /**
     * The menu resource to inflate items from. These are added to the drawer.
     *
     * Non readable property. Wraps the [DrawerBuilder.inflateMenu] method.
     */
    var menuItemsRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.inflateMenu(value)
        }

    /**
     * Enables multiple selections amongst drawer items.
     * Default value is false.
     *
     * Non readable property. Wraps the [DrawerBuilder.withMultiSelect] method.
     */
    var multiSelect: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withMultiSelect(value)
        }

    /**
     * Adds an event [handler] to the drawer that's called when the drawer is closed.
     *
     * Wraps the [DrawerBuilder.withOnDrawerListener] method.
     *
     * @param drawerView The root View of the drawer
     */
    fun onClosed(handler: (drawerView: View) -> Unit) {
        onDrawerListener.onClosed = handler
    }

    /**
     * Adds an event [handler] to the drawer that's called when an item is clicked. The handler should return true if
     * the event has been completely handled.
     *
     * Convenience for the three parameter [onItemClick] method, to be used when you don't need all its parameters.
     * Wraps the [DrawerBuilder.withOnDrawerItemClickListener] method.
     *
     * @param position The position of the clicked item within the drawer
     */
    fun onItemClick(handler: (position: Int) -> Boolean) {
        builder.withOnDrawerItemClickListener { _, position, _ -> handler(position) }
    }

    /**
     * Adds an event [handler] to the drawer that's called when an item is clicked. The handler should return true if
     * the event has been completely handled.
     *
     * See the one parameter [onItemClick] as an alternative.
     *
     * Wraps the [DrawerBuilder.withOnDrawerItemClickListener] method.
     *
     * @param view The View that was clicked
     * @param position The position of the clicked item within the drawer
     * @param drawerItem The clicked drawer item
     */
    fun onItemClick(handler: (view: View, position: Int, drawerItem: IDrawerItem<*, *>) -> Boolean) {
        builder.withOnDrawerItemClickListener(handler)
    }

    /**
     * Adds an event [handler] to the drawer that's called when an item is long clicked. The handler should return true
     * if the event has been completely handled.
     *
     * Convenience for the three parameter [onItemLongClick] method, to be used when you don't need all its parameters.
     * Wraps the [DrawerBuilder.withOnDrawerItemLongClickListener] method.
     *
     * @param position The position of the clicked item within the drawer
     */
    fun onItemLongClick(handler: (position: Int) -> Boolean) {
        builder.withOnDrawerItemLongClickListener { _, position, _ -> handler(position) }
    }

    /**
     * Adds an event [handler] to the drawer that's called when an item is long clicked. The handler should return true
     * if the event has been completely handled.
     *
     * See the one parameter [onItemLongClick] as an alternative.
     *
     * Wraps the [DrawerBuilder.withOnDrawerItemLongClickListener] method.
     *
     * @param view The View that was clicked
     * @param position The position of the clicked item within the drawer
     * @param drawerItem The clicked drawer item
     */
    fun onItemLongClick(handler: (view: View, position: Int, drawerItem: IDrawerItem<*, *>) -> Boolean) {
        builder.withOnDrawerItemLongClickListener(handler)
    }

    /**
     * Defines a navigation listener for the drawer.
     *
     * Wraps the [DrawerBuilder.withOnDrawerNavigationListener] method.
     *
     * @param handler the handler to call on navigation. Should return true if the event has been handled.
     */
    fun onNavigation(handler: (view: View) -> Boolean) {
        builder.withOnDrawerNavigationListener(handler)
    }

    /**
     * Adds an event [handler] to the drawer that's called when the drawer is opened.
     *
     * Wraps the [DrawerBuilder.withOnDrawerListener] method.
     *
     * @param drawerView The root View of the drawer
     */
    fun onOpened(handler: (drawerView: View) -> Unit) {
        onDrawerListener.onOpened = handler
    }

    /**
     * Adds an event [handler] to the drawer that's called when the drawer is sliding.
     *
     * Wraps the [DrawerBuilder.withOnDrawerListener] method.
     *
     * @param drawerView The root View of the drawer
     * @param slideOffset The amount to which the drawer is open, as a number between 0 (closed) and 1 (open)
     */
    fun onSlide(handler: (drawerView: View, slideOffset: Float) -> Unit) {
        onDrawerListener.onSlide = handler
    }

    /**
     * Whether to use position based state management in the internal adapter. This allows high performance for very
     * long lists. If set to false, the new identifier based state management will be used, which provides more
     * flexibility, but has worse performance with long lists.
     * Default value is true.
     *
     * Non readable property. Wraps the [DrawerBuilder.withPositionBasedStateManagement] method.
     */
    var positionBasedStateManagement: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withPositionBasedStateManagement(value)
        }

    /**
     * The primary drawer that's already present in the Activity. This is to be set when the current drawer is the
     * second drawer in an Activity.
     *
     * Non readable property. Wraps the [DrawerBuilder.append] method.
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
     * Non readable property. Wraps the [DrawerBuilder.withRecyclerView] method.
     */
    var recyclerView: RecyclerView
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withRecyclerView(value)
        }

    /**
     * The ViewGroup which will host the DrawerLayout. The content of this view will be extracted and added as the new
     * content inside the DrawerLayout.
     *
     * Non readable property. Wraps the [DrawerBuilder.withRootView] method.
     */
    var rootView: ViewGroup
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withRootView(value)
        }

    /**
     * The ViewGroup which will host the DrawerLayout, given by its layout id. The content of this view will be
     * extracted and added as the new content inside the DrawerLayout.
     *
     * Non readable property. Wraps the [DrawerBuilder.withRootView] method.
     */
    var rootViewRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withRootView(value)
        }

    /**
     * The bundle to restore state from after a configuration change.
     *
     * Remember to store the Drawer instance and call its
     * [saveInstanceState][com.mikepenz.materialdrawer.Drawer.saveInstanceState] method in the Activity's
     * [onSaveInstanceState][Activity.onSaveInstanceState] method, before calling super, to store the current state of
     * the drawer.
     *
     * Non readable property. Wraps the [DrawerBuilder.withSavedInstance] method.
     */
    var savedInstance: Bundle?
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withSavedInstance(value)
        }

    /**
     * Whether the drawer should scroll to the top after an item has been clicked.
     * Default value is false.
     *
     * Non readable property. Wraps the [DrawerBuilder.withScrollToTopAfterClick] method.
     */
    var scrollToTopAfterClick: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withScrollToTopAfterClick(value)
        }

    /**
     * The identifier of the item that should be selected by default.
     * Default value is 0L.
     *
     * Non readable property. Wraps the [DrawerBuilder.withSelectedItem] method.
     */
    var selectedItem: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withSelectedItem(value)
        }

    /**
     * The position of the item that should be selected by default.
     * Default value is 0.
     *
     * Non readable property. Wraps the [DrawerBuilder.withSelectedItemByPosition] method.
     */
    var selectedItemByPosition: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withSelectedItemByPosition(value)
        }

    /**
     * Whether to automatically open the drawer the first time the user opens this Activity.
     * Default value is false.
     *
     * See [showOnFirstLaunch] as an alternative.
     *
     * Non readable property. Wraps the [DrawerBuilder.withShowDrawerOnFirstLaunch] method.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            message = "Alternatives are available, check the documentation.")
    var showDrawerOnFirstLaunch: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withShowDrawerOnFirstLaunch(value)
        }

    /**
     * Whether to automatically open the drawer every time the user opens this Activity, until they've opened it once
     * themselves.
     * Default value is false.
     *
     * See [showUntilDraggedOpened] as an alternative.
     *
     * Non readable property. Wraps the [DrawerBuilder.withShowDrawerUntilDraggedOpened] method.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            message = "Alternatives are available, check the documentation.")
    var showDrawerUntilDraggedOpened: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withShowDrawerUntilDraggedOpened(value)
        }

    /**
     * Whether to automatically open the drawer the first time the user opens this Activity.
     * Default value is false.
     *
     * Convenience for the [showDrawerOnFirstLaunch] property. Non readable property. Wraps the
     * [DrawerBuilder.withShowDrawerOnFirstLaunch] method.
     */
    var showOnFirstLaunch: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withShowDrawerOnFirstLaunch(value)
        }

    /**
     * Whether to automatically open the drawer every time the user opens this Activity, until they've opened it once
     * themselves.
     * Default value is false.
     *
     * Convenience for [showDrawerUntilDraggedOpened]. Non readable property. Wraps the
     * [DrawerBuilder.withShowDrawerUntilDraggedOpened] method.
     */
    var showUntilDraggedOpened: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withShowDrawerUntilDraggedOpened(value)
        }

    /**
     * The background of the drawer item list, as a drawable resource.
     *
     * Convenience for [sliderBackgroundRes]. Non readable property. Wraps the
     * [DrawerBuilder.withSliderBackgroundDrawableRes] method.
     */
    var sliderBackground: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withSliderBackgroundDrawableRes(value)
        }

    /**
     * The background color of the drawer item list, as an argb Long.
     *
     * Non readable property. Wraps the [DrawerBuilder.withSliderBackgroundColor] method.
     */
    var sliderBackgroundColor: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withSliderBackgroundColor(value.toInt())
        }

    /**
     * The background color of the drawer item list, as a color resource.
     *
     * Non readable property. Wraps the [DrawerBuilder.withSliderBackgroundColorRes] method.
     */
    var sliderBackgroundColorRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withSliderBackgroundColorRes(value)
        }

    /**
     * The background of the drawer item list, as a Drawable.
     *
     * Non readable property. Wraps the [DrawerBuilder.withSliderBackgroundDrawable] method.
     */
    var sliderBackgroundDrawable: Drawable
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withSliderBackgroundDrawable(value)
        }

    /**
     * The background of the drawer item list, as a drawable resource.
     *
     * See [sliderBackground] as an alternative.
     *
     * Non readable property. Wraps the [DrawerBuilder.withSliderBackgroundDrawableRes] method.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            message = "Alternatives are available, check the documentation.")
    var sliderBackgroundRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withSliderBackgroundDrawableRes(value)
        }

    /**
     * An arbitrary View to use as the always visible footer of the drawer itself.
     *
     * Non readable property. Wraps the [DrawerBuilder.withStickyFooter] method.
     */
    var stickyFooter: ViewGroup
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withStickyFooter(value)
        }

    /**
     * Whether there should be a divider above the sticky footer.
     * Default value is false.
     *
     * Non readable property. Wraps the [DrawerBuilder.withStickyFooterDivider] method.
     */
    var stickyFooterDivider: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withStickyFooterDivider(value)
        }

    /**
     * An arbitrary layout resource to use as the always visible footer of the drawer itself.
     *
     * Non readable property. Wraps the [DrawerBuilder.withStickyFooter] method.
     */
    var stickyFooterRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withStickyFooter(value)
        }

    /**
     * Whether the sticky footer should cast a shadow on the drawer item list.
     * Default value is true.
     *
     * Non readable property. Wraps the [DrawerBuilder.withStickyFooterShadow] method.
     */
    var stickyFooterShadow: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withStickyFooterShadow(value)
        }

    /**
     * An arbitrary View to use as the always visible header of the drawer itself.
     *
     * Non readable property. Wraps the [DrawerBuilder.withStickyHeader] method.
     */
    var stickyHeader: ViewGroup
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withStickyHeader(value)
        }

    /**
     * An arbitrary layout resource to use as the always visible header of the drawer itself.
     *
     * Non readable property. Wraps the [DrawerBuilder.withStickyHeader] method.
     */
    var stickyHeaderRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withStickyHeader(value)
        }

    /**
     * Whether the sticky header should cast a shadow on the drawer item list (or the account header, if present).
     * Default value is true.
     *
     * Non readable property. Wraps the [DrawerBuilder.withStickyHeaderShadow] method.
     */
    var stickyHeaderShadow: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withStickyHeaderShadow(value)
        }

    /**
     * To be used when you have a translucent navigation bar.
     * Default value is false.
     *
     * Convenience for [translucentNavigationBar]. Non readable property. Wraps the
     * [DrawerBuilder.withTranslucentNavigationBar] method.
     */
    var supportTranslucentNavBar: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withTranslucentNavigationBar(value)
        }

    /**
     * To be used when you run your Activity in full screen mode, with hidden status bar and toolbar.
     * Default value is false.
     *
     * Non readable property. Wraps the [DrawerBuilder.withSystemUIHidden] method.
     */
    var systemUIHidden: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withSystemUIHidden(value)
        }

    /**
     * The Toolbar in the Activity that's to be used with the drawer. This will handle creating the toggle for opening
     * and closing the drawer.
     *
     * Non readable property. Wraps the [DrawerBuilder.withToolbar] method.
     */
    var toolbar: Toolbar
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withToolbar(value)
        }

    /**
     * If set to true, it makes the navigation bar translucent programmatically.
     * Default value is false.
     *
     * Convenience for [translucentNavigationBarProgrammatically]. Non readable property. Wraps the
     * [DrawerBuilder.withTranslucentNavigationBarProgrammatically] method.
     */
    var translucentNavBar: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withTranslucentNavigationBarProgrammatically(value)
        }

    /**
     * To be used when you have a translucent navigation bar.
     * Default value is false.
     *
     * See [supportTranslucentNavBar] as an alternative.
     *
     * Non readable property. Wraps the [DrawerBuilder.withTranslucentNavigationBar] method.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            message = "Alternatives are available, check the documentation.")
    var translucentNavigationBar: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withTranslucentNavigationBar(value)
        }

    /**
     * If set to true, it makes the navigation bar translucent programmatically.
     * Default value is false.
     *
     * See [translucentNavBar] as an alternative.
     *
     * Non readable property. Wraps the [DrawerBuilder.withTranslucentNavigationBarProgrammatically] method.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            message = "Alternatives are available, check the documentation.")
    var translucentNavigationBarProgrammatically: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withTranslucentNavigationBarProgrammatically(value)
        }

    /**
     * Whether the View hosting the DrawerLayout should have a translucent status bar. This enables displaying the
     * drawer under the status bar.
     * Default value is true.
     *
     * Non readable property. Wraps the [DrawerBuilder.withTranslucentStatusBar] method.
     */
    var translucentStatusBar: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withTranslucentStatusBar(value)
        }

    /**
     * The width of the drawer in dps.
     *
     * Convenience for [drawerWidthDp]. Non readable property. Wraps the [DrawerBuilder.withDrawerWidthDp] method.
     */
    var widthDp: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withDrawerWidthDp(value)
        }

    /**
     * The width of the drawer in pixels.
     *
     * Convenience for [drawerWidthPx]. Non readable property. Wraps the [DrawerBuilder.withDrawerWidthPx] method.
     */
    var widthPx: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withDrawerWidthPx(value)
        }

    /**
     * The width of the drawer as a dimension resource.
     *
     * Convenience for [drawerWidthRes]. Non readable property. Wraps the [DrawerBuilder.withDrawerWidthRes] method.
     */
    var widthRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            builder.withDrawerWidthRes(value)
        }

}
