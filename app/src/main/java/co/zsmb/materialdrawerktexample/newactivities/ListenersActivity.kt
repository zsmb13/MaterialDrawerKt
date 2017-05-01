package co.zsmb.materialdrawerktexample.newactivities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import co.zsmb.materialdrawerkt.builders.drawer
import co.zsmb.materialdrawerkt.draweritems.badgeable.primaryItem
import co.zsmb.materialdrawerkt.draweritems.switchable.switchItem
import co.zsmb.materialdrawerkt.draweritems.toggleable.toggleItem
import co.zsmb.materialdrawerktexample.R
import com.mikepenz.fontawesome_typeface_library.FontAwesome
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.model.interfaces.Nameable
import kotlinx.android.synthetic.main.activity_sample.*
import org.jetbrains.anko.toast

class ListenersActivity : AppCompatActivity() {

    private lateinit var result: Drawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(false)

        result = drawer {
            toolbar = this@ListenersActivity.toolbar
            savedInstance = savedInstanceState

            primaryItem("Item 1") {
                iicon = FontAwesome.Icon.faw_heart
                // onClick { _ -> logToast("Clicked item 1") }
            }

            switchItem("Item 2") {
                iicon = FontAwesome.Icon.faw_heart
                // onClick { _ -> logToast("Clicked item 2") }
                // onToggled { isEnabled -> logToast("Toggled item 2, it's now set to $isEnabled") }
                onSwitchChanged { drawerItem, button, isEnabled ->
                    logToast("Toggled item 2, it's now set to $isEnabled")
                }
            }

            toggleItem("Item 3") {
                iicon = FontAwesome.Icon.faw_heart
                // onClick { _ -> logToast("Clicked item 3") }
                // onToggled { isEnabled -> logToast("Toggled item 3, it's now set to $isEnabled") }
                onToggleChanged { drawerItem, button, isEnabled ->
                    logToast("Toggled item 3, it's now set to $isEnabled")
                }
            }

            onOpened { logToast("Opened drawer") }
            onClosed { logToast("Closed drawer") }
            onSlide { drawerView, slideOffset ->
                log("Drawer is ${slideOffset * 100}% open")
            }

            onItemClick { view, position, drawerItem ->
                logToast("Clicked ${(drawerItem as? Nameable<*>)?.name}")
            }
            onItemLongClick { view, position, drawerItem ->
                logToast("Long clicked ${(drawerItem as? Nameable<*>)?.name}")
            }
        }
    }

    private fun log(message: String): Boolean {
        Log.d("LISTENER", message)
        return false
    }

    private fun logToast(message: String): Boolean {
        log(message)
        toast(message)
        return false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
            when (item.itemId) {
                android.R.id.home -> {
                    onBackPressed(); true
                }
                else -> super.onOptionsItemSelected(item)
            }

    override fun onSaveInstanceState(outState: Bundle?) {
        result.saveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onBackPressed() {
        if (result.isDrawerOpen)
            result.closeDrawer()
        else
            super.onBackPressed()
    }

}
