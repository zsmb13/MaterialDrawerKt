package co.zsmb.materialdrawerktexample.customitems.customprimary

import co.zsmb.materialdrawerkt.builders.Builder
import co.zsmb.materialdrawerkt.draweritems.badgeable.AbstractBadgeableDrawerItemKt
import co.zsmb.materialdrawerkt.nonReadable

fun Builder.customPrimaryItem(
        name: String = "",
        description: String? = null,
        setup: CustomPrimaryDrawerItemKt.() -> Unit = {}): CustomPrimaryDrawerItem {
    val item = CustomPrimaryDrawerItemKt()
    item.name = name
    description?.let { item.description = it }
    item.setup()
    return item.build().apply { attachItem(this) }
}

fun Builder.customPrimaryItem(
        nameRes: Int,
        descriptionRes: Int? = null,
        setup: CustomPrimaryDrawerItemKt.() -> Unit = {}): CustomPrimaryDrawerItem {
    val item = CustomPrimaryDrawerItemKt()
    item.nameRes = nameRes
    descriptionRes?.let { item.descriptionRes = it }
    item.setup()
    return item.build().apply { attachItem(this) }
}

class CustomPrimaryDrawerItemKt : AbstractBadgeableDrawerItemKt() {

    // Builder

    private val item = CustomPrimaryDrawerItem()

    init {
        super.setItem(item)
    }

    fun build() = item

    // Props and methods

    var backgroundColor: Int
        get() = nonReadable()
        set(value) {
            item.withBackgroundColor(value)
        }

    var backgroundRes: Int
        get() = nonReadable()
        set(value) {
            item.withBackgroundRes(value)
        }

}
