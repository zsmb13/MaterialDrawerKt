package co.zsmb.materialdrawerkt.draweritems.switchable

import co.zsmb.materialdrawerkt.builders.BuilderBase
import co.zsmb.materialdrawerkt.draweritems.PrimaryDrawerItemKt
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.SecondarySwitchDrawerItem
import com.mikepenz.materialdrawer.model.SwitchDrawerItem

fun BuilderBase.secondarySwitchItem(
        name: String = "",
        description: String = "",
        setup: SecondarySwitchDrawerItemKt.() -> Unit = {}): SecondarySwitchDrawerItem {
    val item = SecondarySwitchDrawerItemKt(name, description)
    item.setup()
    return item.build().apply { attachItem(this) }
}

class SecondarySwitchDrawerItemKt(name: String, description: String) : AbstractSwitchableDrawerItemKt() {

    private val item = SecondarySwitchDrawerItem()

    init {
        super.setItem(item)
        item.withName(name)
                .withDescription(description)
    }

    internal fun build() = item

}
