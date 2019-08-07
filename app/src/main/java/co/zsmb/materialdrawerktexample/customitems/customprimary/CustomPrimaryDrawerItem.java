package co.zsmb.materialdrawerktexample.customitems.customprimary;

import androidx.annotation.NonNull;

import com.mikepenz.materialdrawer.model.AbstractBadgeableDrawerItem;
import com.mikepenz.materialize.holder.ColorHolder;

import java.util.List;

public class CustomPrimaryDrawerItem extends AbstractBadgeableDrawerItem<CustomPrimaryDrawerItem> {

    private ColorHolder background;

    public CustomPrimaryDrawerItem withBackgroundColor(int backgroundColor) {
        this.background = ColorHolder.fromColor(backgroundColor);
        return this;
    }

    public CustomPrimaryDrawerItem withBackgroundRes(int backgroundRes) {
        this.background = ColorHolder.fromColorRes(backgroundRes);
        return this;
    }

    @Override
    public void bindView(@NonNull ViewHolder holder, @NonNull List<Object> payloads) {
        super.bindView(holder, payloads);

        if (background != null) {
            background.applyToBackground(holder.itemView);
        }
    }

}
