package com.company.ResponseClasses;

import java.util.ArrayList;

public class TelegramServerUserIDsResponse {
    boolean ok ;
    ArrayList <UserInfos> items;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public ArrayList<UserInfos> getItems() {
        return items;
    }

    public void setItems(ArrayList<UserInfos> items) {
        this.items = items;
    }
}
