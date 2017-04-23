package co.zsmb.materialdrawerkt.draweritems.toggleable

import android.widget.CompoundButton
import co.zsmb.materialdrawerkt.draweritems.base.BaseDescribeableDrawerItemKt
import com.mikepenz.materialdrawer.model.AbstractToggleableDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

abstract class AbstractToggleableDrawerItemKt : BaseDescribeableDrawerItemKt() {

    /* Builder basics */

    private lateinit var item: AbstractToggleableDrawerItem<*>

    protected fun setItem(item: AbstractToggleableDrawerItem<*>) {
        super.setItem(item)
        this.item = item
    }

    /* AbstractToggleableDrawerItem methods */

    /**
     * Whether the drawer item's toggle is currently in its "on" state.
     *
     * Wraps the withChecked and isChecked functions.
     */
    var checked: Boolean
        get() = item.isChecked
        set(value) {
            item.withChecked(value)
        }

    /**
     * Adds an event [handler] to the drawer item that's called when the toggle's state is changed.
     *
     * Wraps the withOnCheckedChangeListener function.
     *
     * @param drawerItem The drawer item itself
     * @param button The CompoundButton View whose state has changed
     * @param isChecked True if the toggle is now in an "on" state
     */
    @Deprecated(level = DeprecationLevel.ERROR,
            replaceWith = ReplaceWith("onToggledChanged(handler)"),
            message = "Use onToggledChanged instead.")
    fun onCheckedChange(handler: (drawerItem: IDrawerItem<*, *>, button: CompoundButton, isChecked: Boolean) -> Unit) {
        item.withOnCheckedChangeListener(handler)
    }

    /**
     * Adds an event [handler] to the drawer item that's called when the toggle's state is changed.
     *
     * Replacement for onCheckedChange.
     *
     * Wraps the withOnCheckedChangeListener function.
     *
     * @param drawerItem The drawer item itself
     * @param button The CompoundButton View whose state has changed
     * @param isEnabled True if the toggle is now in an "on" state
     */
    fun onToggleChanged(handler: (drawerItem: IDrawerItem<*, *>, button: CompoundButton, isEnabled: Boolean) -> Unit) {
        item.withOnCheckedChangeListener(handler)
    }

    /**
     * Adds an event [handler] to the drawer item that's called when the toggle's state is changed.
     *
     * Alternative to the 3 parameter onToggleChanged method, to be used when you don't need all its parameters.
     *
     * Wraps the withOnCheckedChangeListener function.
     *
     * @param isEnabled True if the toggle is now in an "on" state
     */
    fun onToggled(handler: (isEnabled: Boolean) -> Unit) {
        item.withOnCheckedChangeListener { _, _, isEnabled ->
            handler(isEnabled)
        }
    }

    /**
     * Whether the drawer item's toggle can be toggled by the user.
     *
     * Wraps the withToggleEnabled and isToggleEnabled functions.
     */
    var toggleEnabled: Boolean
        get() = item.isToggleEnabled
        set(value) {
            item.withToggleEnabled(value)
        }

}
