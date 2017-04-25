package co.zsmb.materialdrawerkt.draweritems.badgeable

import co.zsmb.materialdrawerkt.builders.BuilderBase
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem

/**
 * Adds a new PrimaryDrawerItem with the given [name] and [description].
 * @return The created PrimaryDrawerItem instance
 */
fun BuilderBase.primaryItem(
        name: String = "",
        description: String? = null,
        setup: PrimaryDrawerItemKt.() -> Unit = {}): PrimaryDrawerItem {
    val item = PrimaryDrawerItemKt()
    item.name = name
    description?.let { item.description = it }
    item.setup()
    return item.build().apply { attachItem(this) }
}

class PrimaryDrawerItemKt : AbstractBadgeableDrawerItemKt() {

    /* Builder basics */

    private val item = PrimaryDrawerItem()

    init {
        super.setItem(item)
    }

    internal fun build() = item

}
