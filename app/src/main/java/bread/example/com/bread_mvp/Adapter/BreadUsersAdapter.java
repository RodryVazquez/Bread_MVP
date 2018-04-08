package bread.example.com.bread_mvp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import bread.example.com.bread_mvp.Model.BreadModel;
import bread.example.com.bread_mvp.R;

/**
 * Created by RodryVazquez on 08/04/18.
 */

public class BreadUsersAdapter extends RecyclerView.Adapter<BreadUsersAdapter.ViewHolder>  {

    List<BreadModel> ds;
    Context context;

    public BreadUsersAdapter(Context context, List<BreadModel> ds) {
        this.context = context;
        this.ds = ds;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BreadModel breadModel = ds.get(position);
        if(breadModel != null){
            holder.txtFullName.setText(breadModel.getFullName());
            holder.txtEmail.setText(breadModel.getMail());
            holder.txtPhoneNumber.setText(breadModel.getPhoneNumber());
            if(breadModel.isMyBreadTurn()){  holder.imgBreadTurn.setImageDrawable(context.getDrawable(R.drawable.ic_check_circle_black_24dp)); }
        }
    }

    @Override
    public int getItemCount() {
        return ds.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtFullName, txtEmail, txtPhoneNumber;
        ImageView imgBreadTurn;

        public ViewHolder(View itemView) {
            super(itemView);
            txtFullName = itemView.findViewById(R.id.fullname);
            txtEmail = itemView.findViewById(R.id.email);
            txtPhoneNumber = itemView.findViewById(R.id.phonenumber);
            imgBreadTurn = itemView.findViewById(R.id.bread_turn);
        }
    }
}
