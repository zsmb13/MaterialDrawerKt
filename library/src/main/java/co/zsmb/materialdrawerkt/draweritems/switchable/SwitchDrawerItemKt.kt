package co.zsmb.materialdrawerkt.draweritems.switchable

import co.zsmb.materialdrawerkt.builders.BuilderBase
import com.mikepenz.materialdrawer.model.SwitchDrawerItem

/**
 * Adds a new SwitchDrawerItem with the given [name] and [description].
 * @return The created SwitchDrawerItem instance
 */
fun BuilderBase.switchItem(
        name: String = "",
        description: String = "",
        setup: SwitchDrawerItemKt.() -> Unit = {}): SwitchDrawerItem {
    val item = SwitchDrawerItemKt(name, description)
    item.setup()
    return item.build().apply { attachItem(this) }
}

class SwitchDrawerItemKt(name: String, description: String) : AbstractSwitchableDrawerItemKt() {

    /* Builder basics */

    private val item = SwitchDrawerItem()
            .withName(name)
            .withDescription(description)

    init {
        super.setItem(item)
    }

    internal fun build() = item

}
