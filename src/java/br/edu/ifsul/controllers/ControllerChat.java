/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controllers;

import br.edu.ifsul.ejb.BeanChat;
import br.edu.ifsul.models.*;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/*
 * @author Mateus de Oliveira
 */

@Named(value = "controllerChat")
@SessionScoped
public class ControllerChat implements Serializable {

    @EJB
    private BeanChat beanChat;

    private Message message;
    private User user;

    public ControllerChat() {
        this.message = new Message();
        this.user = new User();
    }

    public String returnChat() {
        loginChat();
        return "/chat";
    }
    
    public String exitChat(){
        logoutChat();
        return "/index";
    }

    public void addMessage() {
        this.message.setUser(getUser());
        this.beanChat.addMessage(message);
        this.message = new Message();
    }

    public BeanChat getBeanChat() {
        return beanChat;
    }

    public void setBeanChat(BeanChat beanChat) {
        this.beanChat = beanChat;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void loginChat() {
        this.beanChat.addUser(user);
        this.beanChat.addMessage(
                new Message(beanChat.nextUserId(),
                        user.getName() + " entrou na sala"));
    }

    public void logoutChat() {
        this.beanChat.addMessage(
                new Message(beanChat.nextUserId(),
                        user.getName() + " saiu da sala"));

        this.beanChat.removeUser(user);
        this.user = new User();
    }

    public List<Message> updateListMessages() {
        return beanChat.atualizaMSG();

    }
    
    public List<User> updateListUsers() {
        return beanChat.atualiza();

    }
}