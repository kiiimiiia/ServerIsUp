package com.company.ResponseClasses;

import com.company.ResponseClasses.MessageBody;

public class UserInfos {
    long update_id;
    MessageBody messageBody;

    public long getUpdate_id() {
        return update_id;
    }

    public void setUpdate_id(long update_id) {
        this.update_id = update_id;
    }

    public MessageBody getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(MessageBody messageBody) {
        this.messageBody = messageBody;
    }
}
