package com.dojo.actividad.models;

public class Chat {

    private String chat;

    public Chat(String chat) {
        this.chat = chat;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public void transformarAPalabraCorrecta(String chat){
        this.chat = this.chat.toUpperCase();
        this.chat = this.chat.replace(chat, "****");
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((chat == null) ? 0 : chat.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Chat other = (Chat) obj;
        if (chat == null) {
            if (other.chat != null)
                return false;
        } else if (!chat.equals(other.chat))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Chat [chat=" + chat + "]";
    }

    
    
}
