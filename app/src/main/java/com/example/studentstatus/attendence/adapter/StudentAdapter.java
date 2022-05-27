package com.example.studentstatus.attendence.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentstatus.R;
import com.example.studentstatus.attendence.model.StudentModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> implements Filterable{

    private List<StudentModel> studentStudentModelList;
    private Context context;
    List<StudentModel> studentStudentModelListAll;

    public StudentAdapter(List<StudentModel> studentStudentModelList, Context context) {
        this.studentStudentModelList = studentStudentModelList;
        this.context = context;
        studentStudentModelListAll = new ArrayList<>(studentStudentModelList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.studetn_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        StudentModel studentModel = studentStudentModelList.get(position);
        holder.rollno.setText(studentModel.getRoll());
        holder.name.setText(studentModel.getName());
        holder.absent.setText(studentModel.getAbsent());
        holder.present.setText(studentModel.getPresent());
        holder.percent.setText(studentModel.getPercent());

    }

    @Override
    public int getItemCount() {
        return studentStudentModelList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView rollno,name,absent,present,percent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rollno = itemView.findViewById(R.id.rollno);
            name = itemView.findViewById(R.id.name);
            absent = itemView.findViewById(R.id.absent);
            present = itemView.findViewById(R.id.present);
            percent = itemView.findViewById(R.id.percent);
        }
    }
    @Override
    public Filter getFilter() {


        return studentFilter;
    }
    Filter studentFilter =new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<StudentModel> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(studentStudentModelListAll);
            }else{
                String filteredPattern = constraint.toString().toLowerCase().trim();


                for(StudentModel item : studentStudentModelListAll){


                    if (item.getRoll().toLowerCase().contains(filteredPattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            studentStudentModelList.clear();
            studentStudentModelList.addAll((Collection<? extends StudentModel>) results.values);
            notifyDataSetChanged();

        }
    };

}

