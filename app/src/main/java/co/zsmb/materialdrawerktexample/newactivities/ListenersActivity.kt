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

class ListenersActivity : AppCompatActivity() {

    private lateinit var result: Drawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_logging)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(false)

        result = drawer {
            toolbar = this@ListenersActivity.toolbar
            savedInstance = savedInstanceState

            primaryItem("Item 1") {
                iicon = FontAwesome.Icon.faw_heart
            }

            switchItem("Item 2") {
                iicon = FontAwesome.Icon.faw_heart
                onToggled { isEnabled ->
                    log("Toggled item 2, it's now set to $isEnabled")
                }
            }

            toggleItem("Item 3") {
                iicon = FontAwesome.Icon.faw_heart
                onToggled { isEnabled ->
                    log("Toggled item 3, it's now set to $isEnabled")
                }
            }

            onOpened { log("Opened drawer") }
            onClosed { log("Closed drawer") }
            onSlide { _, slideOffset ->
                Log.d("SLIDE", "Drawer is ${slideOffset * 100}% open")
            }

            onItemClick { _, _, drawerItem ->
                log("Clicked ${(drawerItem as? Nameable<*>)?.name}")
            }
            onItemLongClick { _, _, drawerItem ->
                log("Long clicked ${(drawerItem as? Nameable<*>)?.name}")
            }
        }
    }

    private fun log(message: String): Boolean {
        Log.d("LISTENER", message)

        val lines = txtLabel.text.lines() + message
        txtLabel.text = lines.takeLast(20).joinToString("\n")

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
