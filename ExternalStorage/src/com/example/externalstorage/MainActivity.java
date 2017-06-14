package com.example.externalstorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	Button btnread,btnwrite;
	EditText editdata;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnread =(Button) findViewById(R.id.btnreaddata);
        btnwrite =(Button) findViewById(R.id.btnwritedata);
        editdata =(EditText) findViewById(R.id.editdata);
        btnread.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(arg0.getId()==R.id.btnreaddata)
		    	{
		    		readData();
		    	}
			}
		});
        btnwrite.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(arg0.getId()==R.id.btnwritedata)
		    	{
		    		writeData();
		    	}
				
			}
		});
    }
    // đọc
    public void readData()
    {
    	 String sdcard=Environment.getExternalStorageDirectory()
    			 .getAbsolutePath()+"/myfile.txt";
    	 try {
    		 Scanner scan=new Scanner(new File(sdcard));
    		 String data="";
    		 while(scan.hasNext())
    		 {
    		 data+=scan.nextLine()+"\n";
    		 }
    		 scan.close();
    		 editdata.setText(data+"");
    		 } catch (IOException e) {
    		 e.printStackTrace();
    		 }
    }
    // viết
    public void writeData()
    {

    		String sdcard=Environment
    		.getExternalStorageDirectory()
    		.getAbsolutePath()+"/myfile.txt";
    		try {
    		OutputStreamWriter writer=
    		new OutputStreamWriter(
    		new FileOutputStream(sdcard));
    		writer.write(editdata.getText()+"");
    		writer.close();
    		} catch (FileNotFoundException e) {
    		e.printStackTrace();
    		} catch (IOException e) {
    		e.printStackTrace();
    		}
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

