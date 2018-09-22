package co.zsmb.materialdrawerktexample.customitems.customurl;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
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
