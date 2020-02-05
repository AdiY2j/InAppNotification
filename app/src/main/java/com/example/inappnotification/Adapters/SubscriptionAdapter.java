package com.example.inappnotification.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inappnotification.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubscriptionAdapter extends RecyclerView.Adapter<SubscriptionAdapter.SubscriptionViewHolder> {

    Context context;
    OnTopicSelectListener listener;
    ArrayList<String> topicList;

    public SubscriptionAdapter(Context context, ArrayList<String> topicList, OnTopicSelectListener listener) {
        this.context = context;
        this.listener = listener;
        this.topicList = topicList;
    }

    @NonNull
    @Override
    public SubscriptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_topic, parent, false);
        return new SubscriptionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubscriptionViewHolder holder, int position) {
        holder.tvTopicName.setText(topicList.get(position));
        holder.cbTopic.setOnClickListener(view -> {
            if(holder.cbTopic.isChecked()){
                listener.onTopicSelected(topicList.get(position));
            }else{
                listener.onTopicUnSelected(topicList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        if(topicList != null){
            return topicList.size();
        }
        return 0;
    }

    class SubscriptionViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.cbTopic)
        CheckBox cbTopic;
        @BindView(R.id.tvTopicName)
        TextView tvTopicName;

        public SubscriptionViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnTopicSelectListener{
        void onTopicSelected(String name);
        void onTopicUnSelected(String name);
    }
}
