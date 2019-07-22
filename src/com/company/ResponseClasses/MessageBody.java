package com.company.ResponseClasses;

import com.company.ResponseClasses.Chat;
import com.company.ResponseClasses.Entities;
import com.company.ResponseClasses.Form;

public class MessageBody {
    long message_id;
    Form form ;
    Chat chat;
    long date;
    String text;
    Entities entities;

    public long getMessage_id() {
        return message_id;
    }

    public void setMessage_id(long message_id) {
        this.message_id = message_id;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Entities getEntities() {
        return entities;
    }

    public void setEntities(Entities entities) {
        this.entities = entities;
    }
}
