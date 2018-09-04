package com.gendevs.tripodsample;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.gendevs.tripodsample.db.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Santhosh on 03/09/15.
 */
public class CommentAdapter extends ArrayAdapter<Comment> {
    public CommentAdapter(Context context, List<Comment> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Comment comment = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_comment, parent, false);
        }
        TextView tvName = (TextView) convertView.findViewById(R.id.comment_tv);
        tvName.setText("Comment : "+comment.getComment());

        TextView osName = (TextView) convertView.findViewById(R.id.os_tv);

        osName.setText("OS : "+comment.getOs());

        TextView osVersion = (TextView) convertView.findViewById(R.id.os_version_tv);
        osVersion.setText("OS Version : "+comment.getVersion());

        TextView userTv = (TextView) convertView.findViewById(R.id.user_tv);
        userTv.setText("User : "+comment.getUser());

        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
