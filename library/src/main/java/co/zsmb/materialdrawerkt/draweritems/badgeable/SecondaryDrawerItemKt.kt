package co.zsmb.materialdrawerkt.draweritems.badgeable

fun co.zsmb.materialdrawerkt.builders.BuilderBase.secondaryItem(
        name: String = "",
        description: String = "",
        setup: co.zsmb.materialdrawerkt.draweritems.badgeable.SecondaryDrawerItemKt.() -> Unit = {}): com.mikepenz.materialdrawer.model.SecondaryDrawerItem {
    val item = co.zsmb.materialdrawerkt.draweritems.badgeable.SecondaryDrawerItemKt(name, description)
    item.setup()
    return item.build().apply { attachItem(this) }
}

class SecondaryDrawerItemKt(name: String, description: String) : AbstractBadgeableDrawerItemKt() {

    private val item = com.mikepenz.materialdrawer.model.SecondaryDrawerItem()

    init {
        super.setItem(item)
        item.withName(name)
                .withDescription(description)
    }

    internal fun build() = item

}
