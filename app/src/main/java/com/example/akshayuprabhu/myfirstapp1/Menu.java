package com.example.akshayuprabhu.myfirstapp1;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by akshayuprabhu on 11/10/16.
 */

public class Menu extends ListActivity{

    String classes[] ={"example1","MainActivity","example2","MAINACTIVITY","example4",
            "example5","example6"};

    //classes[4] will be equal to example4
    //when we created a class previously(as in Splash class) we set the content view to some XML file
    //but here we are creating a list view

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_activated_1, classes));
        //here classes is the name of the string which is created before onCreate method tof thhis class
        //the second parameter tells how many list items should be there
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String cheesea = classes[position];

       try {
        //    Class ourClass = Class.forName("com.example.akshayuprabhu."+cheesea.toString());//here cheese must be 'activty name' and not 'action name'
        //    Intent ourIntent = new Intent(Menu.this, ourClass);
            //whenever you see content as the parameter in the method write <presentWorkng .java file's name.this> i.e in this case Menu.this

            Intent ourIntent = new Intent("com.example.akshayuprabhu."+cheesea);

            startActivity(ourIntent);
        }catch (Exception e){
            e.printStackTrace();//this is just for debugging
        }


    }
}
//what happens here is ,we are creating a list using arrayAdapter
//which has the parameters StringArray and its layout  i.e  for every index how many elements in the Sting needs to be taken
//we have "android.R.layout.simple_list_item_1" which assigns 1 string(from the String array) for each listItem
//after this,we define onListItemClick() method which has parameters--'position of the String in the array','View'.'List','its id'
//using these we can do many things like we can assign the string which is clicked to some other String.....etc
//