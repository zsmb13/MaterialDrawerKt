package co.zsmb.materialdrawerkt.draweritems.badgeable

import co.zsmb.materialdrawerkt.builders.BuilderBase
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem

/**
 * Adds a new SecondaryDrawerItem with the given [name] and [description].
 * @return The created SecondaryDrawerItem instance
 */
fun BuilderBase.secondaryItem(
        name: String = "",
        description: String? = null,
        setup: SecondaryDrawerItemKt.() -> Unit = {}): SecondaryDrawerItem {
    val item = SecondaryDrawerItemKt(name, description)
    item.setup()
    return item.build().apply { attachItem(this) }
}

class SecondaryDrawerItemKt(name: String, description: String?) : AbstractBadgeableDrawerItemKt() {

    /* Builder basics */

    private val item = SecondaryDrawerItem().withName(name)

    init {
        description?.let { item.withDescription(it) }
        super.setItem(item)
    }

    internal fun build() = item

}
