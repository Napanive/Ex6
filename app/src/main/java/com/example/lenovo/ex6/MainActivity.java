package com.example.lenovo.ex6;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lenovo.ex6.R;

import java.util.Set;
public class MainActivity extends Activity
{
    EditText title,link,description;
    Button b1,b2;
    private String finalUrl="http://tutorialspoint.com/android/sampleXML.xml";
    private HandleXML obj;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = (EditText) findViewById(R.id.editRss);
        link = (EditText) findViewById(R.id.editFeed);
        description = (EditText) findViewById(R.id.editName);
        b1=(Button)findViewById(R.id.btnFetch);
        b2=(Button)findViewById(R.id.btnResult);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                obj = new HandleXML(finalUrl);
                obj.fetchXML();
                while(obj.parsingComplete);
                title.setText(obj.getTitle());
                link.setText(obj.getLink());
                description.setText(obj.getDescription());
            }
        });
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent in=new Intent(MainActivity.this,second.class);
                startActivity(in);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
