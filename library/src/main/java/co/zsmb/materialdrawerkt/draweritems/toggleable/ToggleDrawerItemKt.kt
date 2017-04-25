package co.zsmb.materialdrawerkt.draweritems.toggleable

import co.zsmb.materialdrawerkt.builders.BuilderBase
import com.mikepenz.materialdrawer.model.ToggleDrawerItem

/**
 * Adds a new ToggleDrawerItem with the given [name] and [description].
 * @return The created ToggleDrawerItem instance
 */
fun BuilderBase.toggleItem(
        name: String = "",
        description: String? = null,
        setup: ToggleDrawerItemKt.() -> Unit = {}): ToggleDrawerItem {
    val item = ToggleDrawerItemKt(name, description)
    item.setup()
    return item.build().apply { attachItem(this) }
}

class ToggleDrawerItemKt(name: String, description: String?) : AbstractToggleableDrawerItemKt() {

    /* Builder basics */

    private val item = ToggleDrawerItem().withName(name)

    init {
        description?.let { item.withDescription(it) }
        super.setItem(item)
    }

    internal fun build() = item

}
