package myrecyclerview.simpleapp.com.myrecyclerviewproject;

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

/**
 * Created by tasev on 12/7/17.
 */

public class CustomStudentsAdapter extends
        RecyclerView.Adapter<CustomStudentsAdapter.ViewHolder> {

    Context context;
    List<Student> studentList = new ArrayList<>();

    public void setItems(List<Student> students) {
        studentList = students;
    }

    public CustomStudentsAdapter(Context _context) {
        context = _context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        @BindView(R.id.text)
        TextView textView;

        @BindView(R.id.text2)
        TextView textView2;

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
    public CustomStudentsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.recyclerview_row, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(CustomStudentsAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Student student = studentList.get(position);

        viewHolder.textView.setText(student.sName);

        if (student.sOnline) {
            viewHolder.textView2.setText("Online");
            viewHolder.textView2.setBackgroundColor(Color.GREEN);
        } else {
            viewHolder.textView2.setText("OffLine");
            viewHolder.textView2.setBackgroundColor(Color.RED);
        }

        Picasso.with(context).load("https://upload.wikimedia.org/wikipedia/commons/4/47/PNG_transparency_demonstration_1.png").centerInside().fit().into(viewHolder.imageView);

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return studentList.size();
    }

}
