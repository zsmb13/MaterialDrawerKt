package co.zsmb.materialdrawerkt.draweritems.base

import android.view.View
import co.zsmb.materialdrawerkt.DrawerMarker
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.model.AbstractDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

@DrawerMarker
abstract class AbstractDrawerItemKt {

    private lateinit var item: AbstractDrawerItem<*, *>

    protected fun setItem(item: AbstractDrawerItem<*, *>) {
        this.item = item
    }

    /**
     * Whether the drawer item is enabled (clickable, etc.).
     *
     * Wraps the withEnabled function. Non-readable property.
     */
    var enabled: Boolean
        get() = nonReadable()
        set(value) {
            item.withEnabled(value)
        }

    /**
     * The identifier of the drawer item. Default value is -1L.
     *
     * Wraps the withIdentifier and getIdentifier functions.
     */
    var identifier: Long
        get() = item.identifier
        set(value) {
            item.withIdentifier(value)
        }

    /**
     * Whether the subitems of this item are visible.
     *
     * Wraps the withIsExpanded and isExpanded functions.
     */
    var isExpanded: Boolean
        get() = item.isExpanded
        set(value) {
            item.withIsExpanded(value)
        }

    /**
     * Adds an event [handler] to the drawer item that's called when the item is clicked.
     *
     * Wraps the withOnDrawerItemClickListener function.
     *
     * @param view The View that was clicked
     * @param position The position of the item within the drawer
     * @param drawerItem The drawer item itself
     */
    fun onClick(handler: (view: View, position: Int, drawerItem: IDrawerItem<*, *>) -> Boolean) {
        item.withOnDrawerItemClickListener(handler)
    }

    /**
     * Adds an event [handler] to the drawer item that's called when the item is clicked.
     *
     * Convenience for the three parameter onClick() method, to be used when you don't need all its parameters.
     */
    fun onClick(handler: (view: View) -> Boolean) {
        item.withOnDrawerItemClickListener { view, _, _ -> handler(view) }
    }

    /**
     * Adds an event [handler] to the drawer item that's called after the view for the drawer item is created.
     * This is to allow further modifications of the view before it's shown.
     *
     * Wraps the withPostOnBindViewListener function.
     *
     * @param drawerItem The drawer item itself
     * @param view The view which has been created for the drawer item
     */
    fun onBindView(handler: (drawerItem: IDrawerItem<*, *>, view: View) -> Unit) {
        item.withPostOnBindViewListener(handler)
    }

    /**
     * Whether the drawer item is selectable.
     *
     * Wraps the withSelectable and isSelectable functions.
     */
    var selectable: Boolean
        get() = item.isSelectable
        set(value) {
            item.withSelectable(value)
        }

    /**
     * Whether the drawer item's background should have a fade animation between the selected and unselected states.
     *
     * Wraps the withSelectedBackgroundAnimated and isSelectedBackgroundAnimated functions.
     */
    var selectedBackgroundAnimated: Boolean
        get() = item.isSelectedBackgroundAnimated
        set(value) {
            item.withSelectedBackgroundAnimated(value)
        }

    /**
     * Whether the drawer item should be set as selected.
     *
     * Wraps the withSetSelected and isSelected functions.
     */
    var setSelected: Boolean
        get() = item.isSelected
        set(value) {
            item.withSetSelected(value)
        }

    /**
     * Whether the drawer item is selected.
     *
     * Convenience for the setSelected property. Wraps the withSetSelected and isSelected functions.
     */
    var selected: Boolean
        get() = item.isSelected
        set(value) {
            item.withSetSelected(value)
        }

    /**
     * An arbitrary object you can attach to the drawer item.
     *
     * Wraps the withTag and getTag functions.
     */
    var tag: Any?
        get() = item.tag
        set(value) {
            item.withTag(value)
        }

}
