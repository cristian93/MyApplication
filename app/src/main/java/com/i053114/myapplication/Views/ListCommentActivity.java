package com.i053114.myapplication.Views;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.i053114.myapplication.Adapters.CommentAdapter;
import com.i053114.myapplication.Helpers.SqliteHelper;
import com.i053114.myapplication.Models.Comment;
import com.i053114.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ListCommentActivity extends Activity {
    RecyclerView recyclerViewComments;
    CommentAdapter commentAdapter;
    List<Comment> commentList = new ArrayList<>();
    SqliteHelper sqliteHelper;
    Integer idContact ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_comment);

        recyclerViewComments = (RecyclerView) findViewById(R.id.id_rv_item_comments);

        sqliteHelper = new SqliteHelper(this, "db_comment", null, 1);

        //idContact = getIntent().getExtras().getInt("idi");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewComments.setLayoutManager(linearLayoutManager);

        listComents();
    }

    public void listComents() {

        SQLiteDatabase db = sqliteHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("select idCommentUser,titleComent,descriptionComment from commentsUsers  order by idCommentUser desc", null);

        while (cursor.moveToNext()) {
            Comment comment = new Comment();
            comment.setIdCommentUser(cursor.getInt(0));
            comment.setTitleComent(cursor.getString(1));
            comment.setDescriptionComment(cursor.getString(2));
            comment.setIdi2(cursor.getInt(3));
            commentList.add(comment);
        }

        cursor.close();

        if (commentList.size() != 0) {
            processData();
            //Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Lista vacia 1", Toast.LENGTH_SHORT).show();
        }


    }

    public void processData() {
        commentAdapter = new CommentAdapter(commentList, getApplicationContext());
        recyclerViewComments.setAdapter(commentAdapter);
    }
}
