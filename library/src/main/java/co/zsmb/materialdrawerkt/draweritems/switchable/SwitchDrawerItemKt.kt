package co.zsmb.materialdrawerkt.draweritems.switchable

import co.zsmb.materialdrawerkt.builders.BuilderBase
import co.zsmb.materialdrawerkt.draweritems.PrimaryDrawerItemKt
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.SwitchDrawerItem

fun BuilderBase.switchItem(
        name: String = "",
        description: String = "",
        setup: SwitchDrawerItemKt.() -> Unit = {}): SwitchDrawerItem {
    val item = SwitchDrawerItemKt(name, description)
    item.setup()
    return item.build().apply { attachItem(this) }
}

class SwitchDrawerItemKt(name: String, description: String) : AbstractSwitchableDrawerItemKt() {

    private val item = SwitchDrawerItem()

    init {
        super.setItem(item)
        item.withName(name)
                .withDescription(description)
    }

    internal fun build() = item

}
