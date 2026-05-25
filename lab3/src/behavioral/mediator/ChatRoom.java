package behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements ChatMediator {
    private final List<ChatUser> users = new ArrayList<>();

    @Override
    public void addUser(ChatUser user) { users.add(user); }

    @Override
    public void sendMessage(String message, ChatUser sender) {
        for (ChatUser user : users) {
            if (user != sender) user.receive(message, sender);
        }
    }
}
