package co.zsmb.materialdrawerkt.draweritems.toggleable

import co.zsmb.materialdrawerkt.builders.BuilderBase
import com.mikepenz.materialdrawer.model.SecondaryToggleDrawerItem

/**
 * Adds a new SecondaryToggleDrawerItem with the given [name] and [description].
 * @return The created SecondaryToggleDrawerItem instance
 */
fun BuilderBase.secondaryToggleItem(
        name: String = "",
        description: String = "",
        setup: SecondaryToggleDrawerItemKt.() -> Unit = {}): SecondaryToggleDrawerItem {
    val item = SecondaryToggleDrawerItemKt(name, description)
    item.setup()
    return item.build().apply { attachItem(this) }
}

class SecondaryToggleDrawerItemKt(name: String, description: String) : AbstractToggleableDrawerItemKt() {

    /* Builder basics */

    private val item = SecondaryToggleDrawerItem()
            .withName(name)
            .withDescription(description)

    init {
        super.setItem(item)
    }

    internal fun build() = item

}
