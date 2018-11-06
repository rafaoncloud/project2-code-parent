package notifications;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class NotificationsManager
{
    private static HashMap<String, Queue<Message>> messages = new HashMap<>();
    private static final Object lock = new Object();

    public static void addErrorMessage(String id, String message)
    {
        addMessage(id, Message.Type.Error, message);
    }

    public static void addSuccessMessage(String id, String message)
    {
        addMessage(id, Message.Type.Success, message);
    }

    public static void addMessage(String id, Message.Type type, String message)
    {
        synchronized (lock)
        {
            if (!messages.containsKey(id))
                messages.put(id, new LinkedList<>());

            messages.get(id).add(new Message(type, message));
        }
    }

    public static Message pollMessage(String id)
    {
        synchronized (lock)
        {
            if (!messages.containsKey(id))
                return null;

            return messages.get(id).poll();
        }
    }
}
