package co.zsmb.materialdrawerktexample.customitems.customurl;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import co.zsmb.materialdrawerktexample.R;

class CustomBaseViewHolder extends RecyclerView.ViewHolder {
    final View view;
    final ImageView icon;
    final TextView name;
    final TextView description;

    CustomBaseViewHolder(View view) {
        super(view);

        this.view = view;
        this.icon = (ImageView) view.findViewById(R.id.material_drawer_icon);
        this.name = (TextView) view.findViewById(R.id.material_drawer_name);
        this.description = (TextView) view.findViewById(R.id.material_drawer_description);
    }

}
