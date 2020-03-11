package com.robby.mobile_04_20192.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * @author Robby
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private ArrayList<String> names;

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = new TextView(viewGroup.getContext());
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder departmentViewHolder, int i) {
        departmentViewHolder.txtName.setText(getNames().get(i));
    }

    @Override
    public int getItemCount() {
        return getNames().size();
    }

    public ArrayList<String> getNames() {
        if (names == null) {
            names = new ArrayList<>();
            names.add("John Doe");
            names.add("Susan Bones");
            names.add("Richard Mark");
            names.add("Ronald Gold");
        }
        return names;
    }

    static class ContactViewHolder extends RecyclerView.ViewHolder {

        private final TextView txtName;

        ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txtName = (TextView) itemView;
        }
    }
}
