package com.mswm.todoapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.mswm.todoapp.Utils.Util;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "ToDoApp";
    public static final String ITEM_TO_EDIT = "ITEM_TO_EDIT";
    public static final String ITEM_TO_EDIT_POS = "ITEM_TO_EDIT_POS";
    private static final int EDIT_ITEM_CODE = 10;

    List<String> todoItems;
    ArrayAdapter<String> aToDoAdapter;
    ListView lvItems;
    EditText etEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateArrayItems();
        findViews();
        setFocusOnEditText();
        setupListViewListener();
    }

    private void findViews() {
        lvItems = (ListView) findViewById(R.id.lv_items);
        lvItems.setAdapter(aToDoAdapter);
        etEditText = (EditText) findViewById(R.id.add_item);
    }

    private void setFocusOnEditText() {
        etEditText.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(etEditText, InputMethodManager.SHOW_IMPLICIT);
    }

    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view,
                                           int position, long id) {
                todoItems.remove(position);
                aToDoAdapter.notifyDataSetChanged();
                Util.writeItems(MainActivity.this, todoItems);
                return true;
            }
        });

        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {
                Intent editIntent = new Intent(MainActivity.this, EditItemActivity.class);
                editIntent.putExtra(ITEM_TO_EDIT, todoItems.get(position));
                editIntent.putExtra(ITEM_TO_EDIT_POS, position);
                startActivityForResult(editIntent, EDIT_ITEM_CODE);
            }
        });
    }

    public void populateArrayItems() {
        todoItems = new ArrayList<>();
        List<String> todoList = Util.readItems(this);
        if (todoList != null) { // List can be null at first
            todoItems.addAll(todoList);
        }
        aToDoAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_expandable_list_item_1, todoItems);
    }

    public void addOnItem(View view) {
        String todoItemInput = etEditText.getText().toString();
        if (TextUtils.isEmpty(todoItemInput)) {
            etEditText.setError(getString(R.string.error_enter_non_empty_item));
        } else {
            aToDoAdapter.add(etEditText.getText().toString());
            etEditText.setText("");
            Util.writeItems(MainActivity.this, todoItems);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == EDIT_ITEM_CODE && resultCode == RESULT_OK) {
            todoItems.clear();
            todoItems.addAll(Util.readItems(this));
            Log.d(TAG, "todoItems: " + todoItems);
            aToDoAdapter.notifyDataSetChanged();
        }
    }
}
