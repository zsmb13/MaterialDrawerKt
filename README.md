# MaterialDrawerKt [![Build Status](https://travis-ci.com/zsmb13/MaterialDrawerKt.svg?token=R4XyYLi9KYiStKDFim5B&branch=master)](https://travis-ci.com/zsmb13/MaterialDrawerKt)

A Kotlin DSL wrapper around the [mikepenz/MaterialDrawer](https://github.com/mikepenz/MaterialDrawer) library.

# Conversion to the DSL

This is how the original API is converted to the DSL.

### Builders

Builders are replaced by functions that are named without the "Builder" suffix.
```
DrawerBuilder()
    .withActivity(this)
    .build()
```
... is replaced with ...
```
drawer { 

}
```

### DrawerItems

Calls to XyzDrawerItem classes are replaced with functions as well. The "Drawer" word is omitted from the function's name. Note that the most often used `with` calls become parameters of the function. 

For example: 

```
PrimaryDrawerItem().withName("Item name")
```
... is replaced with ...
```
primaryItem("Item name") {

}
```

### `with` functions
 
Calls to `.withXyz()` functions are replaced with properties that you can set. 

(Note: do not try to read these properties. They will throw a `NonReadablePropertyException` if you attempt to do so.)
```
AccountHeaderBuilder()
    .withActivity(this)
    .withHeaderBackground(R.color.colorPrimary)
    .build()
```
... is replaced with ...
```
accountHeader {
    headerBackgroundRes = R.color.colorPrimary 
}
```

Note that overloaded functions are replaced with multiple properties, distinguished by suffixes. For example, the above `withHeaderBackground` function's three overloads can be set through the following properties:

Parameter type    | Property name
----------------- | ------------------------------------------
Int               | headerBackground <br/> headerBackgroundRes
Drawable          | headerBackgroundDrawable
ImageHolder       | headerBackgroundImage

Note that there can be defaults without suffixes for what's assumed to be the most popular use case.

### Listeners
```
DrawerBuilder()
        .withActivity(this)
        .withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
            override fun onItemClick(view: View, position: Int, drawerItem: IDrawerItem<out Any?, out RecyclerView.ViewHolder>?): Boolean {
                Log.d("DRAWER", "Clicked!")
                return true
            }
        })
        .build()
```
... is replaced with ...
```
drawer {
    onItemClick { view, position, drawerItem -> 
        Log.d("DRAWER", "Clicked!")
        true
    }
}
```

### Complex listeners
```
DrawerBuilder()
        .withActivity(this)
        .withOnDrawerListener(object : Drawer.OnDrawerListener {
            override fun onDrawerSlide(drawerView: View?, slideOffset: Float) {
                Log.d("DRAWER", "Sliding")
            }

            override fun onDrawerClosed(drawerView: View?) {
                Log.d("DRAWER", "Closed")
            }

            override fun onDrawerOpened(drawerView: View?) {
                Log.d("DRAWER", "Opened")
            }
        })
        .build()
```
... is replaced with ...
```
drawer { 
    onSlide { _, _ ->
        Log.d("DRAWER", "Sliding")
    }
    onClosed {
        Log.d("DRAWER", "Closed")
    }
    onOpened {
        Log.d("DRAWER", "Opened")
    }
}
```
