package mayanksghrathore.example.com.myhelpwali;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MaidAdapter extends RecyclerView.Adapter<MaidAdapter.ViewHolder> {

    private List<ListItemModel> listItems ;
    private Context context;

    public OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener Listener){
        mListener = Listener;
    }


    public MaidAdapter(List<ListItemModel> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListItemModel listitem = listItems.get(position);

        holder.textViewHead.setText(listitem.getName());
        holder.textViewDesc.setText(listitem.getDescription());
        Picasso.with(context).load(listitem.getPicture_url()).placeholder(R.drawable.maiddefault).into(holder.imageView);
        holder.textViewPrice.setText("₹" + listitem.getSalary());
        holder.textViewArea.setText(listitem.getArea());
        holder.textViewRate.setText(listitem.getRating());
        holder.ratingBar.setRating(Float.parseFloat(listitem.getRating()));

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewHead;
        public TextView textViewDesc;
        public ImageView imageView;
        public TextView textViewRate, textViewPrice, textViewArea;
        public RatingBar ratingBar;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textViewHead = (TextView) itemView.findViewById(R.id.textViewHeading);
            textViewDesc = (TextView) itemView.findViewById(R.id.textViewBody);
            textViewArea = (TextView) itemView.findViewById(R.id.textViewArea);
            textViewRate = (TextView) itemView.findViewById(R.id.textViewRating);
            textViewPrice = (TextView) itemView.findViewById(R.id.textViewPrice);
            ratingBar = (RatingBar)itemView.findViewById(R.id.maidRateBar);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(mListener!=null){

                        int position = getAdapterPosition();
                        if(position!= RecyclerView.NO_POSITION){

                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
