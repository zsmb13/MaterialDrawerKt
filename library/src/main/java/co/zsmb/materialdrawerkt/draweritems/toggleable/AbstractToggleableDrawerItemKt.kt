package co.zsmb.materialdrawerkt.draweritems.toggleable

import android.widget.CompoundButton
import co.zsmb.materialdrawerkt.draweritems.base.BaseDescribeableDrawerItemKt
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.model.AbstractToggleableDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

abstract class AbstractToggleableDrawerItemKt: BaseDescribeableDrawerItemKt() {

    private lateinit var item: AbstractToggleableDrawerItem<*>

    protected fun setItem(item: AbstractToggleableDrawerItem<*>) {
        super.setItem(item)
        this.item = item
    }

    var checked: Boolean
        get() = nonReadable()
        set(value) {
            item.withChecked(value)
        }

    @Deprecated(level = DeprecationLevel.ERROR,
            replaceWith = ReplaceWith("onCheckedChanged(handler)"),
            message = "Use onCheckedChanged instead.")
    fun onCheckedChange(handler: (drawerItem: IDrawerItem<*, *>, button: CompoundButton, isChecked: Boolean) -> Unit) {
        onCheckedChanged(handler)
    }

    /**
     * Replacement for onCheckedChange
     */
    fun onCheckedChanged(handler: (drawerItem: IDrawerItem<*, *>, button: CompoundButton, isChecked: Boolean) -> Unit) {
        item.withOnCheckedChangeListener(handler)
    }

    /**
     * Alternative to onCheckedChanged
     */
    fun onChecked(handler: (isChecked: Boolean) -> Unit) {
        item.withOnCheckedChangeListener { _, _, isChecked ->
            handler(isChecked)
        }
    }

    var toggleEnabled: Boolean
        get() = nonReadable()
        set(value) {
            item.withToggleEnabled(value)
        }

}
