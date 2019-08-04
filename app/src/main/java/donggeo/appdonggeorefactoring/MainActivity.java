package donggeo.appdonggeorefactoring;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    BottomNavigationView navigation;
    ViewPager viewPager;
    int images[] = {R.drawable.make, R.drawable.south_korea, R.drawable.north_korea, R.drawable.vietnam, R.drawable.united_kingdom};
    MyCustomPagerAdapter myCustomPagerAdapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        Intent intent;
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            item.setChecked(true);
            navigation.getMenu().findItem(navigation.getSelectedItemId());

            switch (item.getItemId()) {
                case R.id.navigation_main:
                    intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_search:
                    intent = new Intent(MainActivity.this, SearchByContinent.class);
                    startActivity(intent);
                    finish();
                    return true;
                case R.id.navigation_write:
                    intent = new Intent(MainActivity.this, WritePostActivity.class);
                    startActivity(intent);
                    finish();
                    return true;
                case R.id.navigation_mypage:
                    item.setChecked(true);
                    return true;
            }
            return false;
        }
    };

    /*public void onPageSelected(int position) {
        if (prevBottomNavigation != null) {
            prevBottomNavigation.setChecked(false);
        }
        prevBottomNavigation = navigation.getMenu().getItem(position);
        prevBottomNavigation.setChecked(true);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_main);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        viewPager = (ViewPager)findViewById(R.id.viewPager);

        myCustomPagerAdapter = new MyCustomPagerAdapter(MainActivity.this, images);
        viewPager.setAdapter(myCustomPagerAdapter);
    }

}
