package co.zsmb.materialdrawerktexample.customitems.overflow

import android.support.v7.widget.PopupMenu
import android.view.MenuItem
import co.zsmb.materialdrawerkt.builders.Builder
import co.zsmb.materialdrawerkt.draweritems.base.BaseDescribeableDrawerItemKt

// Functions so that the item can be used in the appropriate parts of the DSL
// the exact same way as a library item

// For use with no params or String params
fun Builder.overflowMenuItem(
        name: String = "",
        description: String? = null,
        setup: OverflowMenuDrawerItemKt.() -> Unit): OverflowMenuDrawerItem {
    val item = OverflowMenuDrawerItemKt()
    item.name = name
    description?.let { item.description = it }
    item.setup()
    return item.build().apply { attachItem(this) }
}

// For use with String resource params
fun Builder.overflowMenuItem(
        nameRes: Int,
        descriptionRes: Int,
        setup: OverflowMenuDrawerItemKt.() -> Unit): OverflowMenuDrawerItem {
    val item = OverflowMenuDrawerItemKt()
    item.nameRes = nameRes
    item.descriptionRes = descriptionRes
    item.setup()
    return item.build().apply { attachItem(this) }
}

// Wrapper class for nice DSL access
class OverflowMenuDrawerItemKt : BaseDescribeableDrawerItemKt() {

    // Builder

    private val item = OverflowMenuDrawerItem()

    init {
        super.setItem(item)
    }

    fun build() = item

    // Props and methods

    var menu
        get() = item.menu
        set(value) {
            item.menu = value
        }

    fun onDismiss(handler: (PopupMenu) -> Unit) {
        item.onDismissListener = PopupMenu.OnDismissListener { handler(it) }
    }

    fun onMenuItemClick(handler: (MenuItem) -> Boolean) {
        item.onMenuItemClickListener = PopupMenu.OnMenuItemClickListener { handler(it) }
    }
}
