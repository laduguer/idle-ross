package com.ross.game;

import com.ross.viewmodel.FadingInfoMessageViewModel;
import com.ross.viewmodel.InfoDisplayViewModel;
import com.ross.viewmodel.MessageType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InfoHolder {


    private List<GenericUpdateListener> listeners;
    private List<InfoMessage> messages;
    private long maxMessages = 5;
    private int maxAge = 15;

    public InfoHolder() {
        messages = new ArrayList<>();
        listeners = new ArrayList<>();
    }

    public void addInfo(String text) {
        messages.add(0, new InfoMessage(text, MessageType.Info));
        updateMessageList();
    }

    public void addWarning(String warning) {
        messages.add(0, new InfoMessage(warning, MessageType.Warning));
        updateMessageList();
    }

    private void updateMessageList() {
        messages = messages.stream()
                .limit(maxMessages)
                .filter(i -> i.tickAge < maxAge)
                .collect(Collectors.toList());
    }

    public void tick() {
        messages.forEach(InfoMessage::addTickAge);
        updateMessageList();
        notifyListener();//todo enkel als er echt change is
    }

    private void notifyListener() {
        listeners.forEach(GenericUpdateListener::updated);
    }

    public InfoDisplayViewModel getInfoDisplay() { //hier willen we dees dependency feitelijk niet
        List<FadingInfoMessageViewModel> messageMOdels = messages.stream()
                .map(this::toViewModel)
                .collect(Collectors.toList());
        return new InfoDisplayViewModel(messageMOdels);
    }

    private FadingInfoMessageViewModel toViewModel(InfoMessage message) {
        return new FadingInfoMessageViewModel(message.text, ((double) message.tickAge) / (double) maxAge, message.type);
    }

    public int maxMessages() {
        return (int) maxMessages;
    }

    public void addListener(GenericUpdateListener listener) {
        listeners.add(listener);
    }


    private class InfoMessage {

        private int tickAge;
        private String text;
        private MessageType type;

        public InfoMessage(String message, MessageType type) {
            text = message;
            this.type = type;
            tickAge = 0;

        }

        public void addTickAge() {
            tickAge++;
        }

        public MessageType getType() {
            return type;
        }
    }
}
