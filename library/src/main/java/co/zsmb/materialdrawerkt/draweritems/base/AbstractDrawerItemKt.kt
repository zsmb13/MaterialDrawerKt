@file:Suppress("RedundantVisibilityModifier")

package co.zsmb.materialdrawerkt.draweritems.base

import android.view.View
import co.zsmb.materialdrawerkt.DrawerMarker
import co.zsmb.materialdrawerkt.builders.Builder
import com.mikepenz.materialdrawer.model.AbstractDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

@DrawerMarker
public abstract class AbstractDrawerItemKt<out T : AbstractDrawerItem<*, *>>(protected val item: T) : Builder {

    //region Builder basics

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE", "OverridingDeprecatedMember")
    public override fun attachItem(subItem: IDrawerItem<*, *>) {
        item.withSubItems(subItem)
    }

    internal fun build(): T = item

    //endregion

    //region AbstractDrawerItem methods

    /**
     * Whether the drawer item is enabled (clickable, etc.).
     *
     * Wraps the [AbstractDrawerItem.withEnabled] and [AbstractDrawerItem.isEnabled] methods.
     */
    public var enabled: Boolean
        get() = item.isEnabled
        set(value) {
            item.withEnabled(value)
        }

    /**
     * The identifier of the drawer item. Default value is -1L.
     *
     * Wraps the [AbstractDrawerItem.withIdentifier] and [AbstractDrawerItem.getIdentifier] methods.
     */
    public var identifier: Long
        get() = item.identifier
        set(value) {
            item.withIdentifier(value)
        }

    /**
     * Whether the subitems of this item are visible.
     *
     * Wraps the [AbstractDrawerItem.withIsExpanded] and [AbstractDrawerItem.isExpanded] methods.
     */
    public var isExpanded: Boolean
        get() = item.isExpanded
        set(value) {
            item.withIsExpanded(value)
        }

    /**
     * Adds an event [handler] to the drawer item that's called after the view for the drawer item is created.
     * This is to allow further modifications of the view before it's shown.
     *
     * Wraps the [AbstractDrawerItem.withPostOnBindViewListener] method.
     *
     * @param drawerItem The drawer item itself
     * @param view The view which has been created for the drawer item
     */
    public fun onBindView(handler: (drawerItem: IDrawerItem<*, *>, view: View) -> Unit) {
        item.withPostOnBindViewListener(handler)
    }

    /**
     * Adds an event [handler] to the drawer item that's called when the item is clicked.
     *
     * Convenience for the three parameter [onClick] method, to be used when you don't need all its parameters.
     *
     * Wraps the [AbstractDrawerItem.withOnDrawerItemClickListener] method.
     */
    public fun onClick(handler: (view: View?) -> Boolean) {
        item.withOnDrawerItemClickListener { view, _, _ -> handler(view) }
    }

    /**
     * Adds an event [handler] to the drawer item that's called when the item is clicked.
     *
     * See the one parameter [onClick] method as an alternative.
     *
     * Wraps the [AbstractDrawerItem.withOnDrawerItemClickListener] method.
     *
     * @param view The View that was clicked
     * @param position The position of the item within the drawer
     * @param drawerItem The drawer item itself
     */
    public fun onClick(handler: (view: View?, position: Int, drawerItem: IDrawerItem<*, *>) -> Boolean) {
        item.withOnDrawerItemClickListener(handler)
    }

    /**
     * Whether the drawer item is selectable.
     *
     * Wraps the [AbstractDrawerItem.withSelectable] and [AbstractDrawerItem.isSelectable] methods.
     */
    public var selectable: Boolean
        get() = item.isSelectable
        set(value) {
            item.withSelectable(value)
        }

    /**
     * Whether the drawer item is selected.
     *
     * Convenience for [setSelected]. Wraps the [AbstractDrawerItem.withSetSelected] and [AbstractDrawerItem.isSelected]
     * methods.
     */
    public var selected: Boolean
        get() = item.isSelected
        set(value) {
            item.withSetSelected(value)
        }

    /**
     * Whether the drawer item's background should have a fade animation between the selected and unselected states.
     *
     * Wraps the [AbstractDrawerItem.withSelectedBackgroundAnimated] and
     * [AbstractDrawerItem.isSelectedBackgroundAnimated] methods.
     */
    public var selectedBackgroundAnimated: Boolean
        get() = item.isSelectedBackgroundAnimated
        set(value) {
            item.withSelectedBackgroundAnimated(value)
        }

    /**
     * Whether the drawer item should be set as selected.
     *
     * See [selected] as an alternative.
     *
     * Wraps the [AbstractDrawerItem.withSetSelected] and [AbstractDrawerItem.isSelected] methods.
     */
    @Deprecated(level = DeprecationLevel.WARNING,
            message = "Alternatives are available, check the documentation.")
    public var setSelected: Boolean
        get() = item.isSelected
        set(value) {
            item.withSetSelected(value)
        }

    /**
     * An arbitrary object you can attach to the drawer item.
     *
     * Wraps the [AbstractDrawerItem.withTag] and [AbstractDrawerItem.getTag] methods.
     */
    public var tag: Any?
        get() = item.tag
        set(value) {
            item.withTag(value)
        }

    //endregion

}
