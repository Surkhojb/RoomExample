package patterns.juanjo.roomexample.features.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.ArrayList;
import java.util.List;
import patterns.juanjo.roomexample.R;
import patterns.juanjo.roomexample.data.entity.Message;

/**
 * Created by juanj on 26/09/2017.
 */

public class MessageListAdapter extends RecyclerView.Adapter<MessageListAdapter.MessageViewHolder> {
  List<Message> messages = new ArrayList<>();

  public MessageListAdapter() {
  }

  public void setMessages(List<Message> messages) {
    this.messages = messages;
    notifyDataSetChanged();
  }

  @Override
  public MessageListAdapter.MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_list, parent, false);
    return new MessageViewHolder(v);
  }

  @Override
  public void onBindViewHolder(MessageListAdapter.MessageViewHolder holder, int position) {
    holder.imgColor.setBackgroundColor(messages.get(position).getColor());
    holder.tvMessage.setText(messages.get(position).getMessage());
    holder.tvDate.setText(messages.get(position).getTimeOfDay());
  }

  @Override public int getItemCount() {
    return messages.size();
  }

  public class MessageViewHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.img_color)
    CircleImageView imgColor;
    @BindView(R.id.tv_message)
    TextView tvMessage;
    @BindView(R.id.tv_date)
    TextView tvDate;

    public MessageViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this,itemView);
    }
  }
}
