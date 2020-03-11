package com.robby.mobile_04_20192.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.robby.mobile_04_20192.R;
import com.robby.mobile_04_20192.databinding.StudentItemBinding;
import com.robby.mobile_04_20192.entity.Student;

import java.util.List;

/**
 * @author Robby Tan
 */
public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<Student> students;
    private ItemClickListener clickListener;

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item,
                parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = students.get(position);
        holder.binding.setStudent(student);
        holder.itemView.setOnClickListener(view -> clickListener.itemClicked(student));
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public void setStudents(List<Student> students) {
        this.students = students;
        notifyDataSetChanged();
    }

    public void setClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {

        private StudentItemBinding binding;

        private StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

    public interface ItemClickListener {

        void itemClicked(Student student);
    }
}
