package com.example.mordenhistory;

import android.app.FragmentManager;
import android.app.Service;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.mordenhistory.Database.DatabaseHelp3;
import com.google.android.material.textfield.TextInputEditText;

public class NoteFragment extends Fragment {
    TextInputEditText myNoteBook;

    DatabaseHelp3 myDB;

    public NoteFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_note, container, false);
        ImageView imageView3 = (ImageView) v.findViewById(R.id.imageView3);
        myNoteBook = v.findViewById(R.id.myNoteBook);
        //Implement function that touch other space to hide the KeyBoard and shift focus from textView
        //Reference:https://blog.csdn.net/weixin_43766753/article/details/103511807
        v.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //Get the focused view
                    v = getActivity().getCurrentFocus();
                    //Decide whether to hid the Key board
                    if (isShouldHideKeyboard(v, event)) {
                        hideKeyboard(v.getWindowToken());
                    }return false;
                }
                return true;
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStackImmediate();
            }
        });
        //Invoke the database
        myDB = new DatabaseHelp3(getContext());
        try {
            boolean insert = myDB.insertNotes("myNoteBook","");
        }catch(SQLException e){
            e.printStackTrace();
        }
        //Display the existing content
        Cursor c = myDB.getNoteInfo();
        while(c.moveToNext()){
            myNoteBook.setText(c.getString(1));
        }
        //Save the new content and update the database
        ImageView imageView4 = (ImageView) v.findViewById(R.id.imageView4);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB.updateNoteBook("myNoteBook",myNoteBook.getText().toString());
            }
        });
        return v;
    }

    private boolean isShouldHideKeyboard(View v, MotionEvent event) {
        //If the current focus view is editText then decide the position of the click
        if (v instanceof EditText) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0],
                    top = l[1],
                    bottom = top + v.getHeight(),
                    right = left + v.getWidth();
            //If it click the editview, ignore it
            return !(event.getX() > left) || !(event.getX() < right)
                    || !(event.getY() > top) || !(event.getY() < bottom);
        }
        return false;
    }

    //Hide the Keyboard and make editview lose the focus
    private void hideKeyboard(IBinder token) {
        myNoteBook.clearFocus();
        if (token != null) {
            InputMethodManager im = (InputMethodManager) getContext().getSystemService(getContext().INPUT_METHOD_SERVICE);
            if (im != null) {
                im.hideSoftInputFromWindow(token, InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }

}
