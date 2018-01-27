@file:Suppress("RedundantVisibilityModifier")

package co.zsmb.materialdrawerkt.builders

import co.zsmb.materialdrawerkt.DrawerMarker
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

/**
 * Adds a footer to the drawer.
 */
public fun DrawerBuilderKt.footer(setup: StickyFooterKt.() -> Unit = {}) {
    StickyFooterKt(builder).setup()
}

@DrawerMarker
public class StickyFooterKt(val builder: DrawerBuilder) : Builder {

    //region Builder basics

    override fun attachItem(item: IDrawerItem<*, *>) {
        builder.addStickyDrawerItems(item)
    }

    //endregion

}
