@file:Suppress("RedundantVisibilityModifier")

package co.zsmb.materialdrawerkt.draweritems.switchable

import android.widget.CompoundButton
import co.zsmb.materialdrawerkt.draweritems.base.BaseDescribeableDrawerItemKt
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.interfaces.OnCheckedChangeListener
import com.mikepenz.materialdrawer.model.AbstractSwitchableDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

@Suppress("FINITE_BOUNDS_VIOLATION_IN_JAVA")
public abstract class AbstractSwitchableDrawerItemKt<out T : AbstractSwitchableDrawerItem<*>>(item: T) :
        BaseDescribeableDrawerItemKt<T>(item) {

    /**
     * Whether the drawer item is selectable.
     *
     * Non readable property. Wraps the [AbstractSwitchableDrawerItem.withCheckable] method.
     */
    @Deprecated(level = DeprecationLevel.ERROR,
            replaceWith = ReplaceWith("selectable"),
            message = "Use the selectable property instead.")
    public var checkable: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = "Non readable property.")
        get() = nonReadable()
        set(value) {
            item.withCheckable(value)
        }

    /**
     * Whether the drawer item's switch is currently in its "on" state.
     * Default value is false.
     *
     * Wraps the [AbstractSwitchableDrawerItem.isChecked] property.
     */
    public var checked: Boolean
        get() = item.isChecked
        set(value) {
            item.isChecked = value
        }

    /**
     * Adds an event [handler] to the drawer item that's called when the switch's state is changed.
     *
     * Wraps the [AbstractSwitchableDrawerItem.withOnCheckedChangeListener] method.
     *
     * @param drawerItem The drawer item itself
     * @param button The CompoundButton View whose state has changed
     * @param isChecked True if the switch is now in an "on" state
     */
    @Deprecated(level = DeprecationLevel.ERROR,
            replaceWith = ReplaceWith("onSwitchChanged(handler)"),
            message = "Use onSwitchChanged instead.")
    public fun onCheckedChange(handler: (drawerItem: IDrawerItem<*>, buttonView: CompoundButton, isChecked: Boolean) -> Unit) {
        item.withOnCheckedChangeListener(object : OnCheckedChangeListener {
            override fun onCheckedChanged(drawerItem: IDrawerItem<*>, buttonView: CompoundButton, isChecked: Boolean) {
                handler(drawerItem, buttonView, isChecked)
            }
        })
    }

    /**
     * Adds an event [handler] to the drawer item that's called when the switch's state is changed.
     *
     * Replacement for [onCheckedChange]. Wraps the [AbstractSwitchableDrawerItem.withOnCheckedChangeListener] method.
     *
     * @param drawerItem The drawer item itself
     * @param button The CompoundButton View whose state has changed
     * @param isEnabled True if the switch is now in an "on" state
     */
    @Suppress("MemberVisibilityCanBePrivate")
    public fun onSwitchChanged(handler: (drawerItem: IDrawerItem<*>, buttonView: CompoundButton, isEnabled: Boolean) -> Unit) {
        item.withOnCheckedChangeListener(object : OnCheckedChangeListener {
            override fun onCheckedChanged(drawerItem: IDrawerItem<*>, buttonView: CompoundButton, isChecked: Boolean) {
                handler(drawerItem, buttonView, isChecked)
            }
        })
    }

    /**
     * Adds an event [handler] to the drawer item that's called when the toggle's state is changed.
     *
     * Alternative to the three parameter [onSwitchChanged] method, to be used when you don't need all its parameters.
     *
     * Wraps the [AbstractSwitchableDrawerItem.withOnCheckedChangeListener] method.
     *
     * @param isEnabled True if the switch is now in an "on" state
     */
    public fun onToggled(handler: (isEnabled: Boolean) -> Unit) {
        item.withOnCheckedChangeListener(object : OnCheckedChangeListener {
            override fun onCheckedChanged(drawerItem: IDrawerItem<*>, buttonView: CompoundButton, isChecked: Boolean) {
                handler(isChecked)
            }
        })
    }

    /**
     * Whether the drawer item's switch can be toggled by the user.
     * Default value is true.
     *
     * Wraps the [AbstractSwitchableDrawerItem.isSwitchEnabled] property.
     */
    public var switchEnabled: Boolean
        get() = item.isSwitchEnabled
        set(value) {
            item.isSwitchEnabled = value
        }

}
