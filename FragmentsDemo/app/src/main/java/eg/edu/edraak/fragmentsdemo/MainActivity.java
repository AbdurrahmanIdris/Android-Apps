package eg.edu.edraak.fragmentsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayoutAdapter adapter;
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.myViewPager);
        tabLayout = findViewById(R.id.myTabLayout);
        adapter = new TabLayoutAdapter(getSupportFragmentManager());
        adapter.addFragment(new FirstFragment(), "Tab 1");
        adapter.addFragment(new SecondFragment(), "Tab2");
        adapter.addFragment(new ThirdFragment(), "Tab 3");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }//end onCreate
}//end class
