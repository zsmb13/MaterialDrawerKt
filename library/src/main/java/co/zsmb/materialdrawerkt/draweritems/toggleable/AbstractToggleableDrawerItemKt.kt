@file:Suppress("RedundantVisibilityModifier")

package co.zsmb.materialdrawerkt.draweritems.toggleable

import android.widget.CompoundButton
import co.zsmb.materialdrawerkt.draweritems.base.BaseDescribeableDrawerItemKt
import com.mikepenz.materialdrawer.model.AbstractToggleableDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

@Suppress("FINITE_BOUNDS_VIOLATION_IN_JAVA")
public abstract class AbstractToggleableDrawerItemKt<out T : AbstractToggleableDrawerItem<*>>(item: T) :
        BaseDescribeableDrawerItemKt<T>(item) {

    /**
     * Whether the drawer item's toggle is currently in its "on" state.
     * Default value is false.
     *
     * Wraps the [AbstractToggleableDrawerItem.withChecked] and [AbstractToggleableDrawerItem.isChecked] methods.
     */
    public var checked: Boolean
        get() = item.isChecked
        set(value) {
            item.withChecked(value)
        }

    /**
     * Adds an event [handler] to the drawer item that's called when the toggle's state is changed.
     *
     * Wraps the [AbstractToggleableDrawerItem.withOnCheckedChangeListener] method.
     *
     * @param drawerItem The drawer item itself
     * @param button The CompoundButton View whose state has changed
     * @param isChecked True if the toggle is now in an "on" state
     */
    @Deprecated(level = DeprecationLevel.ERROR,
            replaceWith = ReplaceWith("onToggledChanged(handler)"),
            message = "Use onToggledChanged instead.")
    public fun onCheckedChange(handler: (drawerItem: IDrawerItem<*, *>, button: CompoundButton, isChecked: Boolean) -> Unit) {
        item.withOnCheckedChangeListener(handler)
    }

    /**
     * Adds an event [handler] to the drawer item that's called when the toggle's state is changed.
     *
     * Replacement for [onCheckedChange]. Wraps the [AbstractToggleableDrawerItem.withOnCheckedChangeListener] method.
     *
     * @param drawerItem The drawer item itself
     * @param button The CompoundButton View whose state has changed
     * @param isEnabled True if the toggle is now in an "on" state
     */
    public fun onToggleChanged(handler: (drawerItem: IDrawerItem<*, *>, button: CompoundButton, isEnabled: Boolean) -> Unit) {
        item.withOnCheckedChangeListener(handler)
    }

    /**
     * Adds an event [handler] to the drawer item that's called when the toggle's state is changed.
     *
     * Alternative to the three parameter [onToggleChanged] method, to be used when you don't need all its parameters.
     *
     * Wraps the [AbstractToggleableDrawerItem.withOnCheckedChangeListener] method.
     *
     * @param isEnabled True if the toggle is now in an "on" state
     */
    public fun onToggled(handler: (isEnabled: Boolean) -> Unit) {
        item.withOnCheckedChangeListener { _, _, isEnabled ->
            handler(isEnabled)
        }
    }

    /**
     * Whether the drawer item's toggle can be toggled by the user.
     * Default value is true.
     *
     * Wraps the [AbstractToggleableDrawerItem.withToggleEnabled] and [AbstractToggleableDrawerItem.isToggleEnabled]
     * methods.
     */
    public var toggleEnabled: Boolean
        get() = item.isToggleEnabled
        set(value) {
            item.withToggleEnabled(value)
        }

}
