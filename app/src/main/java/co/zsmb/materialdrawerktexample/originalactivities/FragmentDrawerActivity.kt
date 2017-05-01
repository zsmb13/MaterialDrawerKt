package co.zsmb.materialdrawerktexample.originalactivities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import co.zsmb.materialdrawerktexample.R
import co.zsmb.materialdrawerktexample.fragments.DrawerFragment
import co.zsmb.materialdrawerktexample.fragments.SecondDrawerFragment
import kotlinx.android.synthetic.main.activity_sample_fragment_dark_toolbar.*

class FragmentDrawerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_fragment_dark_toolbar)
        setSupportActionBar(toolbar)

        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, DrawerFragment.newInstance("Demo"))
                .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.fragment_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
            when (item.itemId) {
                R.id.menu_1 -> {
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, DrawerFragment.newInstance("Demo"))
                            .commit()
                    true
                }
                R.id.menu_2 -> {
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, SecondDrawerFragment.newInstance("Demo 2"))
                            .commit()
                    true
                }
                android.R.id.home -> {
                    onBackPressed()
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }

}
