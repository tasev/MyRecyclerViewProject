package myrecyclerview.simpleapp.com.myrecyclerviewproject.navigation;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import myrecyclerview.simpleapp.com.myrecyclerviewproject.R;

/**
 * Created by tasev on 12/5/17.
 */

public class FragmentMain extends Fragment {


    private Unbinder mUnbinder;

    @BindView(R.id.image)
    ImageView imageView;

    public static FragmentMain newInstance(String imageUrl) {

        Bundle args = new Bundle();
        args.putString("imageUrl", imageUrl);
        FragmentMain fragment = new FragmentMain();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_screen, null);
        mUnbinder = ButterKnife.bind(this, view);
        if (getArguments() != null && getArguments().getString("imageUrl") != null) {
            Picasso.with(getActivity()).load(getArguments().getString("imageUrl")).centerInside().fit().into(imageView);
        }


        return view;

    }

    @OnClick(R.id.image)
    public void imageClick() {
        Toast.makeText(getActivity(), "toast Fragment 1", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
