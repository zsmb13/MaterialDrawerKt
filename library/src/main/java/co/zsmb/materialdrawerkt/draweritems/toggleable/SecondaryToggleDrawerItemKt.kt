package co.zsmb.materialdrawerkt.draweritems.toggleable

import co.zsmb.materialdrawerkt.builders.BuilderBase
import com.mikepenz.materialdrawer.model.SecondaryToggleDrawerItem

fun BuilderBase.secondaryToggleItem(
        name: String = "",
        description: String = "",
        setup: SecondaryToggleDrawerItemKt.() -> Unit = {}): SecondaryToggleDrawerItem {
    val item = SecondaryToggleDrawerItemKt(name, description)
    item.setup()
    return item.build().apply { attachItem(this) }
}

class SecondaryToggleDrawerItemKt(name: String, description: String) : AbstractToggleableDrawerItemKt() {

    private val item = SecondaryToggleDrawerItem()

    init {
        super.setItem(item)
        item.withName(name)
                .withDescription(description)
    }

    internal fun build() = item

}
