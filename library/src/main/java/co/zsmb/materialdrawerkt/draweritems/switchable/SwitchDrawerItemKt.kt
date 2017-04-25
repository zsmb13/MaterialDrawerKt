package co.zsmb.materialdrawerkt.draweritems.switchable

import co.zsmb.materialdrawerkt.builders.BuilderBase
import com.mikepenz.materialdrawer.model.SwitchDrawerItem

/**
 * Adds a new SwitchDrawerItem with the given [name] and [description].
 * @return The created SwitchDrawerItem instance
 */
fun BuilderBase.switchItem(
        name: String = "",
        description: String? = null,
        setup: SwitchDrawerItemKt.() -> Unit = {}): SwitchDrawerItem {
    val item = SwitchDrawerItemKt()
    item.name = name
    description?.let { item.description = it }
    item.setup()
    return item.build().apply { attachItem(this) }
}

class SwitchDrawerItemKt : AbstractSwitchableDrawerItemKt() {

    /* Builder basics */

    private val item = SwitchDrawerItem()

    init {
        super.setItem(item)
    }

    internal fun build() = item

}
