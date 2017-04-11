package co.zsmb.materialdrawerkt.draweritems.base

import android.view.View
import co.zsmb.materialdrawerkt.DrawerMarker
import co.zsmb.materialdrawerkt.nonReadable
import com.mikepenz.materialdrawer.model.AbstractDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

@DrawerMarker
abstract class AbstractDrawerItemKt {

    private lateinit var item: AbstractDrawerItem<*, *>

    protected fun setItem(item: AbstractDrawerItem<*, *>) {
        this.item = item
    }

    var enabled: Boolean
        get() = nonReadable()
        set(value) {
            item.withEnabled(value)
        }

    var identifier: Long
        get() = nonReadable()
        set(value) {
            item.withIdentifier(value)
        }

    var isExpanded: Boolean
        get() = nonReadable()
        set(value) {
            item.withIsExpanded(true)
        }

    fun onClick(handler: (view: View, position: Int, drawerItem: IDrawerItem<*, *>) -> Boolean) {
        item.withOnDrawerItemClickListener(handler)
    }

    /**
     * Convenience for the three parameter onClick() method
     */
    fun onClick(handler: (view: View) -> Boolean) {
        item.withOnDrawerItemClickListener { view, _, _ -> handler(view) }
    }

    fun onBindView(handler: (drawerItem: IDrawerItem<*, *>, view: View) -> Unit) {
        item.withPostOnBindViewListener(handler)
    }

    var selectable: Boolean
        get() = nonReadable()
        set(value) {
            item.withSelectable(value)
        }

    var selectedBackgroundAnimated: Boolean
        get() = nonReadable()
        set(value) {
            item.withSelectedBackgroundAnimated(value)
        }

    var setSelected: Boolean
        get() = nonReadable()
        set(value) {
            item.withSetSelected(value)
        }

    /**
     * Convenience for setSelected
     */
    var selected: Boolean
        get() = nonReadable()
        set(value) {
            item.withSetSelected(value)
        }

    var tag: Any
        get() = nonReadable()
        set(value) {
            item.withTag(value)
        }

}
