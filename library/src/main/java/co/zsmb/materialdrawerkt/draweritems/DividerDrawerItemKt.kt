package co.zsmb.materialdrawerkt.draweritems

import co.zsmb.materialdrawerkt.DrawerMarker
import co.zsmb.materialdrawerkt.builders.BuilderBase
import com.mikepenz.materialdrawer.model.DividerDrawerItem

fun BuilderBase.divider(setup: DividerDrawerItemKt.() -> Unit = {}): DividerDrawerItem {
    val item = DividerDrawerItemKt()
    item.setup()
    return item.build().apply { attachItem(this) }
}

@DrawerMarker
class DividerDrawerItemKt {

    private val item = DividerDrawerItem()

    internal fun build() = item

}
