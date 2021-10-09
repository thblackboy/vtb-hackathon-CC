package com.example.vtbhackthoncc;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UsersTopAdapter extends RecyclerView.Adapter<UsersTopAdapter.UsersViewHolder> {
    private List<User> usersList = new ArrayList<>();

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_top_item, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        holder.bind(usersList.get(position));
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public void setItems(Collection<User> users) {
        usersList.addAll(users);
        notifyDataSetChanged();
    }

    class UsersViewHolder extends RecyclerView.ViewHolder {
        private TextView username;
        private TextView skill;

        public UsersViewHolder(View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.nickname_view);
            skill = itemView.findViewById(R.id.skill_view);
        }

        public void bind(User user) {
            username.setText(user.getNickname());
            skill.setText(user.getSkill().toString());
        }
    }
}
