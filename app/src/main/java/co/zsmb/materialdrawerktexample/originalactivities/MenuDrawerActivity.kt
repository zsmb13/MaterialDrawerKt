package co.zsmb.materialdrawerktexample.originalactivities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.zsmb.materialdrawerktexample.R
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.model.interfaces.Nameable

class MenuDrawerActivity : AppCompatActivity() {

    private lateinit var result: Drawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_dark_toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(false)

        result = drawer {
            toolbar = this@MenuDrawerActivity.toolbar
            savedInstance = savedInstanceState
            menuItemsRes = R.menu.example_menu

            onItemClick { _, _, drawerItem ->
                if (drawerItem is Nameable<*>) {
                    toast(drawerItem.name.getText(this@MenuDrawerActivity))
                }
                false
            }
        }
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
