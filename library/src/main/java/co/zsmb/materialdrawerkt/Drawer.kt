package co.zsmb.materialdrawerkt

import android.app.Activity
import android.graphics.drawable.Drawable
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem

class ProfileDrawerItemKt(name: String, email: String) {

    private val item = ProfileDrawerItem()

    init {
        item.withName(name)
        item.withEmail(email)
    }

    var icon: Int?
        get() = null
        set(value) {
            if (value == null) {
                item.withIcon(null as Drawable?)
                return
            }
            item.withIcon(value)
        }

    internal fun build() = item

}

class AccountHeaderKt(activity: Activity) {

    private val builder = AccountHeaderBuilder()

    init {
        builder.withActivity(activity)
    }

    var background: Int?
        get() = null
        set(value) {
            if (value == null) {
                builder.withHeaderBackground(null as Drawable?)
                return
            }
            builder.withHeaderBackground(value)
        }

    fun profile(name: String, email: String,
                setup: ProfileDrawerItemKt.() -> Unit) {
        val item = ProfileDrawerItemKt(name, email)
        item.setup()
        builder.addProfiles(item.build())
    }

    internal fun build(): AccountHeader = builder.build()

}

class PrimaryDrawerItemKt(name: String) {

    private val item = PrimaryDrawerItem()

    init {
        item.withName(name)
    }

    var icon: Int?
        get() = null
        set(value) {
            if (value == null) {
                item.withIcon(null as Drawable?)
                return
            }
            item.withIcon(value)
        }

    var iconTintingEnabled: Boolean?
        get() = null
        set(value) {
            if (value == null) {
                return
            }
            item.withIconTintingEnabled(value)
        }

    internal fun build() = item

}

class SecondaryDrawerItemKt(name: String) {

    private val item = SecondaryDrawerItem()

    init {
        item.withName(name)
    }

    var icon: Int?
        get() = null
        set(value) {
            if (value == null) {
                item.withIcon(null as Drawable?)
                return
            }
            item.withIcon(value)
        }

    var iconTintingEnabled: Boolean?
        get() = null
        set(value) {
            if (value == null) {
                return
            }
            item.withIconTintingEnabled(value)
        }

    internal fun build() = item

}

class DividerDrawerItemKt {

    private val item = DividerDrawerItem()

    internal fun build() = item

}

class DrawerBuilderKt(val activity: Activity) {

    private val builder = DrawerBuilder()

    init {
        builder.withActivity(activity)
    }

    internal fun build(): Drawer = builder.build()

    fun accountHeader(setup: AccountHeaderKt.() -> Unit = {}): AccountHeader {
        val header = AccountHeaderKt(activity)
        header.setup()
        return header.build().apply { builder.withAccountHeader(this) }
    }

    fun primaryItem(name: String, setup: PrimaryDrawerItemKt.() -> Unit = {}): PrimaryDrawerItem {
        val item = PrimaryDrawerItemKt(name)
        item.setup()
        return item.build().apply { builder.addDrawerItems(this) }
    }

    fun secondaryItem(name: String, setup: SecondaryDrawerItemKt.() -> Unit = {}): SecondaryDrawerItem {
        val item = SecondaryDrawerItemKt(name)
        item.setup()
        return item.build().apply { builder.addDrawerItems(this) }
    }

    fun divider(setup: DividerDrawerItemKt.() -> Unit = {}): DividerDrawerItem {
        val item = DividerDrawerItemKt()
        item.setup()
        return item.build().apply { builder.addDrawerItems(this) }
    }

}

fun Activity.drawer(setup: DrawerBuilderKt.() -> Unit = {}): Drawer {
    val builder = DrawerBuilderKt(this)
    builder.setup()
    return builder.build()
}
