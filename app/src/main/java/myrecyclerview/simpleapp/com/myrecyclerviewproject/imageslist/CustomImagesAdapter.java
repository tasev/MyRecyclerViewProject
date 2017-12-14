package myrecyclerview.simpleapp.com.myrecyclerviewproject.imageslist;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import myrecyclerview.simpleapp.com.myrecyclerviewproject.R;

/**
 * Created by tasev on 12/7/17.
 */

public class CustomImagesAdapter extends
        RecyclerView.Adapter<CustomImagesAdapter.ViewHolder> {

    Context context;
    List<ImageData> imageDataList = new ArrayList<>();
    OnRecyclerViewImageClickListener onRecyclerViewImageClickListener;

    public void setItems(List<ImageData> students) {
        imageDataList = students;
    }

    public CustomImagesAdapter(Context _context, OnRecyclerViewImageClickListener _onRecyclerViewImageClickListener) {
        context = _context;
        onRecyclerViewImageClickListener = _onRecyclerViewImageClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        @BindView(R.id.text)
        TextView textView;

        @BindView(R.id.image)
        ImageView imageView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public CustomImagesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.recyclerview_images_row, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(CustomImagesAdapter.ViewHolder viewHolder,int position) {
        // Get the data model based on position
        final ImageData imageData = imageDataList.get(position);

        viewHolder.textView.setText(imageData.tags);

        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRecyclerViewImageClickListener.onRowClick(imageData);
            }
        });

        Picasso.with(context).load(imageData.previewURL).centerInside().fit().into(viewHolder.imageView);

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return imageDataList.size();
    }

}
