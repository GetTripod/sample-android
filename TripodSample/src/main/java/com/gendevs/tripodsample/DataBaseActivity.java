package com.gendevs.tripodsample;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.gendevs.tripodsample.db.Comment;
import com.gendevs.tripodsample.db.CommentsDataSource;

import java.util.List;
import java.util.Random;

/**
 * Created by Santhosh on 04/09/15.
 */
public class DataBaseActivity extends BaseActivity {

    private List<Comment> mAllComments;
    private ListView mDBListView;
    private CommentsDataSource datasource;
    private CommentAdapter mCommentAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_db;

    }

    @Override
    protected int getToolbarResource() {

        return R.id.activity_main_toolbar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Comments");
        datasource = new CommentsDataSource(this);
        datasource.open();
        mAllComments = datasource.getAllComments();
        mDBListView = (ListView) findViewById(R.id.db_list_view);
        setUpListView();

    }

    private void setUpListView() {
        mCommentAdapter = new CommentAdapter(this, datasource.getAllComments());
        mDBListView.setAdapter(mCommentAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_add_comment) {
            showAddCommentDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void showAddCommentDialog() {
        // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.add_comment_dialog, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final EditText userInput = (EditText) promptsView
                .findViewById(R.id.editTextDialogUserInput);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                if (userInput.getText().toString().length() > 0)
                                    addComment(userInput.getText().toString());
                                else
                                    userInput.setError("Please enter comment");

                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }


    private void addComment(String commentStr) {
        String osVersion = android.os.Build.VERSION.RELEASE;
        Comment comment = new Comment();
        comment.setComment(commentStr);
        comment.setVersion(osVersion);
        comment.setUser("Android User");
        comment.setOs("Android");
        datasource.addComment(comment);
        setUpListView();

    }
}
