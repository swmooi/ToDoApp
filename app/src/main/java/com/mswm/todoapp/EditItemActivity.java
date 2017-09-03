package com.mswm.todoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.mswm.todoapp.Utils.Util;

import java.util.List;

public class EditItemActivity extends AppCompatActivity {

    private EditText editItem;
    private List<String> toDoItems;
    private int positionToEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        editItem = (EditText) findViewById(R.id.edit_item);
        getData();
    }

    private void getData() {
        toDoItems = Util.readItems(this);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            positionToEdit = bundle.getInt(MainActivity.ITEM_TO_EDIT_POS);
            editItem.setText(bundle.getString(MainActivity.ITEM_TO_EDIT));
        }
    }

    public void saveItem(View view) {
        toDoItems.set(positionToEdit, editItem.getText().toString());
        Util.writeItems(this, toDoItems);
        setResult(RESULT_OK);
        finish();
    }
}
