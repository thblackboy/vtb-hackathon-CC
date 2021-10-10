package com.example.vtbhackthoncc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
   /* public ArrayList<News> news= new ArrayList<News>();
    public News current_news;
    public int newsnum=0;
    public int userscore = 0;

    */
    private BottomNavigationView botnav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botnav=findViewById(R.id.botnav);
        botnav.setOnNavigationItemSelectedListener(bottomNavMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new ActiiFragment()).commit();
      //  get_json();
       // get_next();
        //test
    }
    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod=new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment=null;
                    switch(item.getItemId()){
                        case R.id.actii:
                            fragment=new ActiiFragment();
                            break;
                        case R.id.allnews:
                            fragment=new NewsFragment();
                            break;
                        case R.id.buyact:
                            fragment =new BuyFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();

                    return true;
                }
            };


    public void changePrice(View view){
        ActiiFragment.actiiList.get(0).setPrice(15);
    }
   /* public void clickbutton(View view){
        Button button = (Button) view;
        String buy= current_news.getBuy();
        String newsbuy=button.getTag().toString();
        update_score(buy.equals(newsbuy));

        newsnum++;
        get_next();

    }

    public void update_score(boolean res){
        TextView textscore=(TextView) findViewById(R.id.score);

        if (res) {
            userscore += 100;
            textscore.setText(""+userscore);
            Toast.makeText(this,"Правильное решение! Так держать!",Toast.LENGTH_LONG).show();
        }else{
            userscore -= 100;
            textscore.setText(""+userscore);
            Toast.makeText(this,"Мы несем убытки!",Toast.LENGTH_LONG).show();
        }
    }


    public void get_next(){
        if (newsnum<news.size()){
            current_news= news.get(newsnum);
            TextView newsTopic=(TextView) findViewById(R.id.newsTopic);
            TextView newsMessage=(TextView) findViewById(R.id.newsmessage);
            newsTopic.setText(current_news.getHead());
            newsMessage.setText(current_news.getMess());
        }
        else
            Toast.makeText(this,"Нет новостей",Toast.LENGTH_LONG).show();
    }
    public void get_json(){
        String json;
        try {
            InputStream is=getAssets().open("mess.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0;i< jsonArray.length();i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                news.add(new News(obj.getString("head"),obj.getString("mess"),obj.getString("buy")));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

    }

    */
}