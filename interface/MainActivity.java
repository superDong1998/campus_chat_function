package d.aninterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Message> messageList = new ArrayList<>();
    private EditText input;
    private Button send;
    private RecyclerView recyclerView;
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        input = findViewById(R.id.input);
        send = findViewById(R.id.send);
        recyclerView = findViewById(R.id.recycler);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new MsgAdapter(messageList);
        recyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = input.getText().toString();
                if(!"".equals(content)) {
                    Message message = new Message(content, Message.SENT,R.drawable.apple);
                    messageList.add(message);
                    adapter.notifyItemInserted(messageList.size() - 1);
                    recyclerView.scrollToPosition(messageList.size() - 1);
                    input.setText("");
                }
            }
        });
    }

    private void init() {
        Message message1 = new Message("hello ,welcome to App!", Message.RECEIVED,R.drawable.banana);
        messageList.add(message1);
        Message message2 = new Message("hhh, thank you!", Message.SENT, R.drawable.apple);
        messageList.add(message2);
        Message message3 = new Message("Having fun!", Message.RECEIVED, R.drawable.banana);
        messageList.add(message3);
    }
}
