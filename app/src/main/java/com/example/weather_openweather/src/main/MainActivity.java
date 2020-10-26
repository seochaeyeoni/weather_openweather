package com.example.weather_openweather.src.main;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.weather_openweather.R;
import com.example.weather_openweather.src.BaseActivity;
import com.example.weather_openweather.src.main.interfaces.MainActivityView;
import com.example.weather_openweather.src.main.weather.WeatherFrag;

public class MainActivity extends BaseActivity implements MainActivityView {
    private DrawerLayout mDrawerLayout;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WeatherFrag weatherFrag = new WeatherFrag();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main_frame, weatherFrag);
        ft.commit();






//        //내비게이션 드로어
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayShowTitleEnabled(false); //기존 title 지우기
//        actionBar.setDisplayHomeAsUpEnabled(true); //버튼 만들기
//        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24); //버튼 이미지 지정
//
//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(MenuItem menuItem) {
//                menuItem.setChecked(true);
//                mDrawerLayout.closeDrawers();
//
//                int id = menuItem.getItemId();
//                String title = menuItem.getTitle().toString();
//
//                if(id == R.id.account){
//                    Toast.makeText(context, title + ": 계정 정보를 확인합니다.", Toast.LENGTH_SHORT).show();
//                }
//                else if(id == R.id.setting){
//                    Toast.makeText(context, title + ": 설정 정보를 확인합니다.", Toast.LENGTH_SHORT).show();
//                }
//                else if(id == R.id.logout){
//                    Toast.makeText(context, title + ": 로그아웃 시도중", Toast.LENGTH_SHORT).show();
//                }
//
//                return true;
//            }
//        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ // 뒤로가기 버튼 눌렀을 때
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

//    //프래그먼트 교체가 일어나는 실행문
//    private void setFrag(int n) {
//        fm = getSupportFragmentManager();
//        ft = fm.beginTransaction();
//        switch (n) {
//            case 0:
//                ft.replace(R.id.main_frame, weatherFrag);
//                ft.commit();
//                break;
//                case 1:
//                    ft.replace(R.id.main_frame, frag2);
//                    ft.commit();
//                    break;
//                case 2:
//                    ft.replace(R.id.main_frame, frag3);
//                    ft.commit();
//                    break;
//                case 3:
//                    ft.replace(R.id.main_frame, frag4);
//                    ft.commit();
//                    break;
//                case 4:
//                    ft.replace(R.id.main_frame, frag5);
//                    ft.commit();
//                    break;
//        }
//    }




    private void tryGetTest() {
        showProgressDialog();

        final MainService mainService = new MainService(this);
        mainService.getTest();
    }

    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();

    }

    @Override
    public void validateFailure(@Nullable String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

//    public void customOnClick(View view) {
//        switch (view.getId()) {
//            case R.id.main_btn_hello_world:
//                tryGetTest();
//                break;
//            default:
//                break;
//        }
//    }
}
