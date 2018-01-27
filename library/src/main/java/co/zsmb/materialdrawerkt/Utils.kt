package co.zsmb.materialdrawerkt

import co.zsmb.materialdrawerkt.builders.Builder
import co.zsmb.materialdrawerkt.draweritems.base.BaseDescribeableDrawerItemKt
import com.mikepenz.materialdrawer.model.BaseDescribeableDrawerItem

fun <KtDrawerItem : BaseDescribeableDrawerItemKt<DrawerItem>, DrawerItem : BaseDescribeableDrawerItem<*, *>>
        Builder.createItem(builderItem: KtDrawerItem,
                           name: String,
                           description: String?,
                           setup: KtDrawerItem.() -> Unit): DrawerItem {
    builderItem.name = name
    description?.let { builderItem.description = it }
    builderItem.setup()
    return builderItem.build().also { attachItem(it) }
}

fun <KtDrawerItem : BaseDescribeableDrawerItemKt<DrawerItem>, DrawerItem : BaseDescribeableDrawerItem<*, *>>
        Builder.createItem(builderItem: KtDrawerItem,
                           nameRes: Int,
                           descriptionRes: Int?,
                           setup: KtDrawerItem.() -> Unit): DrawerItem {
    builderItem.nameRes = nameRes
    descriptionRes?.let { builderItem.descriptionRes = it }
    builderItem.setup()
    return builderItem.build().also { attachItem(it) }
}
