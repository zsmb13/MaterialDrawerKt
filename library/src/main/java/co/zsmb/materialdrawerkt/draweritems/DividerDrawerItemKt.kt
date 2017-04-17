package co.zsmb.materialdrawerkt.draweritems

import co.zsmb.materialdrawerkt.builders.BuilderBase
import co.zsmb.materialdrawerkt.draweritems.base.AbstractDrawerItemKt
import com.mikepenz.materialdrawer.model.DividerDrawerItem

fun BuilderBase.divider(setup: DividerDrawerItemKt.() -> Unit = {}): DividerDrawerItem {
    val item = DividerDrawerItemKt()
    item.setup()
    return item.build().apply { attachItem(this) }
}

class DividerDrawerItemKt : AbstractDrawerItemKt() {

    private val item = DividerDrawerItem()

    init {
        super.setItem(item)
    }

    internal fun build() = item

}
