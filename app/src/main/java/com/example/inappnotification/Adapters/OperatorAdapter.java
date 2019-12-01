package com.example.inappnotification.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inappnotification.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OperatorAdapter extends RecyclerView.Adapter<OperatorAdapter.OperatorViewHolder> {

    Context context;
    List<String> operatorList = new ArrayList<>();

    public OperatorAdapter(Context context, List<String> operatorList) {
        this.context = context;
        this.operatorList = operatorList;
    }

    @NonNull
    @Override
    public OperatorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_operator_list, parent, false);
        return new OperatorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OperatorViewHolder holder, int position) {
        holder.tvName.setText(operatorList.get(position));
    }

    @Override
    public int getItemCount() {
        if(operatorList == null) {
            return 0;
        }
        return operatorList.size();
    }

    public class OperatorViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tvOperatorName)
        TextView tvName;

        public OperatorViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
