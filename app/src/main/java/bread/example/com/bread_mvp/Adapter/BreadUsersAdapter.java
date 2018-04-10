package bread.example.com.bread_mvp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import bread.example.com.bread_mvp.Model.BreadModel;
import bread.example.com.bread_mvp.R;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * Created by RodryVazquez on 08/04/18.
 */
public class BreadUsersAdapter extends RecyclerView.Adapter<BreadUsersAdapter.ViewHolder> {

    List<BreadModel> ds;
    Context context;

    public BreadUsersAdapter(Context context, List<BreadModel> ds) {
        this.context = context;
        this.ds = ds;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.lst_bread_users_adapter, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BreadModel breadModel = ds.get(position);
        if (breadModel != null) {
            holder.txtFullName.setText(breadModel.getFullName());
            holder.txtEmail.setText(breadModel.getMail());
            holder.txtPhoneNumber.setText(breadModel.getPhoneNumber());
            if (breadModel.isMyBreadTurn()) {
                holder.imgBreadTurn.setImageDrawable(context.getDrawable(R.drawable.ic_check_circle_black_24dp));
            }
        }
    }

    @Override
    public int getItemCount() {
        return ds.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.fullname)
        TextView txtFullName;
        @BindView(R.id.email)
        TextView txtEmail;
        @BindView(R.id.phonenumber)
        TextView txtPhoneNumber;
        @BindView(R.id.bread_turn)
        ImageView imgBreadTurn;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
