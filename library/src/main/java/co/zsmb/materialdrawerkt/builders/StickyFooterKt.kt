package co.zsmb.materialdrawerkt.builders

import co.zsmb.materialdrawerkt.DrawerMarker
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

/**
 * Adds a footer to the drawer.
 */
fun DrawerBuilderKt.footer(setup: StickyFooterKt.() -> Unit = {}) {
    StickyFooterKt(builder).setup()
}

@DrawerMarker
class StickyFooterKt(val builder: DrawerBuilder) : Builder {

    /* Builder basics */

    override fun attachItem(item: IDrawerItem<*, *>) {
        builder.addStickyDrawerItems(item)
    }

}
