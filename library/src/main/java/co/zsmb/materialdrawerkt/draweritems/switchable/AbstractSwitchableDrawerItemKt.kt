package co.zsmb.materialdrawerkt.draweritems.switchable

import android.widget.CompoundButton
import co.zsmb.materialdrawerkt.draweritems.base.BaseDescribeableDrawerItemKt
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.model.AbstractSwitchableDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

abstract class AbstractSwitchableDrawerItemKt : BaseDescribeableDrawerItemKt() {

    private lateinit var item: AbstractSwitchableDrawerItem<*>

    protected fun setItem(item: AbstractSwitchableDrawerItem<*>) {
        super.setItem(item)
        this.item = item
    }

    var checkable: Boolean
        get() = nonReadable()
        set(value) {
            item.withCheckable(value)
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

    var switchEnabled: Boolean
        get() = nonReadable()
        set(value) {
            item.withSwitchEnabled(value)
        }

}
