package myrecyclerview.simpleapp.com.myrecyclerviewproject;

/**
 * Created by tasev on 12/7/17.
 */

public class Student {
    public String sName;
    public boolean sOnline;

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public boolean issOnline() {
        return sOnline;
    }

    public void setsOnline(boolean sOnline) {
        this.sOnline = sOnline;
    }

    public Student(String sName, boolean sOnline) {
        this.sName = sName;
        this.sOnline = sOnline;
    }
}

