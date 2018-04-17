/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.ejb;

import br.edu.ifsul.models.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;

/**
 *
 * @author Mateus de Oliveira
 */
@Singleton
public class BeanChat implements Serializable{
        
    private String message;
    private List<Message> ListMessages = new ArrayList<>();
    private List<User> ListUsers = new ArrayList<>();
    
    public BeanChat(){
    }

    public List<Message> getListMessages() {
        return ListMessages;
    }

    public void setListMessages(List<Message> ListMessages) {
        this.ListMessages = ListMessages;
    }

    public List<User> getListUsers() {
        return ListUsers;
    }

    public void setListUsers(List<User> ListUsers) {
        this.ListUsers = ListUsers;
    }
    
    public String getMessage() {
        return message;
    }    
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public void addUser(User user){
        user.setId(this.ListUsers.size() + 1);
        this.ListUsers.add(user);
    }
    
    public void removeUser(User user){
        ListUsers.remove(user);
    }

    public void addMessage(Message message){
        this.ListMessages.add(message);
    }
    
    public void removeMessage(Message message){
        ListMessages.remove(message);
    }
    
    public int nextUserId(){
        return this.ListUsers.size()+1;
    }
    
        
    public List<User> atualiza(){
        return getListUsers();
    }
       public List<Message> atualizaMSG(){
        return getListMessages();
    }
}
