@file:Suppress("RedundantVisibilityModifier")

package co.zsmb.materialdrawerkt.draweritems.base

import android.graphics.Typeface
import android.view.View
import co.zsmb.materialdrawerkt.DrawerMarker
import co.zsmb.materialdrawerkt.builders.Builder
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.holder.ColorHolder
import com.mikepenz.materialdrawer.model.AbstractDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.OnPostBindViewListener

@DrawerMarker
public abstract class AbstractDrawerItemKt<out T : AbstractDrawerItem<*, *>>(protected val item: T) : Builder {

    //region Builder basics

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE", "OverridingDeprecatedMember")
    public override fun attachItem(subItem: IDrawerItem<*>) {
        item.subItems.add(subItem)
    }

    internal fun build(): T = item

    //endregion

    //region AbstractDrawerItem methods
    /**
     * Defines the content description of the item.
     *
     * Wraps the [AbstractDrawerItem.contentDescription] property.
     */
    public var contentDescription: String?
        get() = item.contentDescription
        set(value) {
            item.contentDescription = value
        }

    /**
     * The color of the drawer item's text when it's disabled, as an argb Long.
     *
     * Non-readable property. Wraps the [AbstractDrawerItem.disabledTextColor] property.
     */
    public var disabledTextColor: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non-readable property.")
        get() = nonReadable()
        set(value) {
            item.disabledTextColor = ColorHolder.fromColor(value.toInt())
        }

    /**
     * The color of the drawer item's text when it's disabled, as a color resource.
     *
     * Non-readable property. Wraps the [AbstractDrawerItem.disabledTextColor] property.
     */
    public var disabledTextColorRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non-readable property.")
        get() = nonReadable()
        set(value) {
            item.disabledTextColor = ColorHolder.fromColorRes(value)
        }

    /**
     * Whether the drawer item is enabled (clickable, etc.).
     *
     * Wraps the [AbstractDrawerItem.isEnabled] property.
     */
    public var enabled: Boolean
        get() = item.isEnabled
        set(value) {
            item.isEnabled = value
        }

    /**
     * The identifier of the drawer item. Default value is -1L.
     *
     * Wraps the [AbstractDrawerItem.identifier] property.
     */
    public var identifier: Long
        get() = item.identifier
        set(value) {
            item.identifier = value
        }

    /**
     * Whether the subitems of this item are visible.
     *
     * Wraps the [AbstractDrawerItem.isExpanded] property.
     */
    public var isExpanded: Boolean
        get() = item.isExpanded
        set(value) {
            item.isExpanded = value
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
    public fun onBindView(handler: (drawerItem: IDrawerItem<*>, view: View) -> Unit) {
        item.withPostOnBindViewListener(object : OnPostBindViewListener {
            override fun onBindView(drawerItem: IDrawerItem<*>, view: View) {
                handler(drawerItem, view)
            }
        })
    }

    /**
     * Adds an event [handler] to the drawer item that's called when the item is clicked.
     *
     * Convenience for the three parameter [onClick] method, to be used when you don't need all its parameters.
     *
     * Wraps the [AbstractDrawerItem.withOnDrawerItemClickListener] method.
     */
    public fun onClick(handler: (view: View?) -> Boolean) {
        item.withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
            override fun onItemClick(view: View?, position: Int, drawerItem: IDrawerItem<*>): Boolean {
                return handler(view)
            }
        })
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
    public fun onClick(handler: (view: View?, position: Int, drawerItem: IDrawerItem<*>) -> Boolean) {
        item.withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
            override fun onItemClick(view: View?, position: Int, drawerItem: IDrawerItem<*>): Boolean {
                return handler(view, position, drawerItem)
            }
        })
    }

    /**
     * Whether the drawer item is selectable.
     *
     * Wraps the [AbstractDrawerItem.isSelectable] property.
     */
    public var selectable: Boolean
        get() = item.isSelectable
        set(value) {
            item.isSelectable = value
        }

    /**
     * Whether the drawer item is selected.
     *
     * Wraps the [AbstractDrawerItem.isSelected] property.
     */
    public var selected: Boolean
        get() = item.isSelected
        set(value) {
            item.isSelected = value
        }

    /**
     * Whether the drawer item's background should have a fade animation between the selected and unselected states.
     *
     * Wraps the [AbstractDrawerItem.isSelectedBackgroundAnimated] property.
     */
    public var selectedBackgroundAnimated: Boolean
        get() = item.isSelectedBackgroundAnimated
        set(value) {
            item.isSelectedBackgroundAnimated = value
        }

    /**
     * The color of the profile item in the profile switcher list when it's selected, as an argb Long.
     *
     * Non-readable property. Wraps the [AbstractDrawerItem.selectedColor] property.
     */
    public var selectedColor: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non-readable property.")
        get() = nonReadable()
        set(value) {
            item.selectedColor = ColorHolder.fromColor(value.toInt())
        }

    /**
     * The color of the profile item in the profile switcher list when it's selected, as a color resource.
     *
     * Non-readable property. Wraps the [AbstractDrawerItem.selectedColor] property.
     */
    public var selectedColorRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non-readable property.")
        get() = nonReadable()
        set(value) {
            item.selectedColor = ColorHolder.fromColorRes(value)
        }

    /**
     * The color of the profile item's text in the profile switcher list when it's selected, as an argb Long.
     *
     * Non-readable property. Wraps the [AbstractDrawerItem.selectedTextColor] property.
     */
    public var selectedTextColor: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non-readable property.")
        get() = nonReadable()
        set(value) {
            item.selectedTextColor = ColorHolder.fromColor(value.toInt())
        }

    /**
     * The color of the profile item's text in the profile switcher list when it's selected, as a color resource.
     *
     * Non-readable property. Wraps the [AbstractDrawerItem.selectedTextColor] property.
     */
    public var selectedTextColorRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non-readable property.")
        get() = nonReadable()
        set(value) {
            item.selectedTextColor = ColorHolder.fromColorRes(value)
        }

    /**
     * An arbitrary object you can attach to the drawer item.
     *
     * Wraps the [AbstractDrawerItem.tag] property.
     */
    public var tag: Any?
        get() = item.tag
        set(value) {
            item.tag = value
        }

    /**
     * The color of the drawer item's text, as an argb Long.
     *
     * Non-readable property. Wraps the [AbstractDrawerItem.textColor] property.
     */
    public var textColor: Long
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non-readable property.")
        get() = nonReadable()
        set(value) {
            item.textColor = ColorHolder.fromColor(value.toInt())
        }

    /**
     * The color of the drawer item's text, as a color resource.
     *
     * Non-readable property. Wraps the [AbstractDrawerItem.textColor] property.
     */
    public var textColorRes: Int
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non-readable property.")
        get() = nonReadable()
        set(value) {
            item.textColor = ColorHolder.fromColorRes(value)
        }

    /**
     * The typeface to use for the profile item's text.
     *
     * Non-readable property. Wraps the [AbstractDrawerItem.typeface] property.
     */
    public var typeface: Typeface
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non-readable property.")
        get() = nonReadable()
        set(value) {
            item.typeface = value
        }
    //endregion

}
