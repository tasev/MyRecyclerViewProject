package myrecyclerview.simpleapp.com.myrecyclerviewproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        CustomStudentsAdapter adapter = new CustomStudentsAdapter(this);

        adapter.setItems(generateList());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    ArrayList<Student> generateList(){
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("student 1", true));
        students.add(new Student("student 2", true));
        students.add(new Student("student 3", true));

        for(int i = 0;i<100;i++){
            students.add(new Student("student "+i, true));
        }


        return students;
    }







    private List<Student> generateStudentsList() {
        List<Student> simpleViewModelList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            simpleViewModelList.add(new Student("Item "+i,true));
        }

        return simpleViewModelList;
    }
}
