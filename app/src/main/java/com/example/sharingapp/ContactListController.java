package com.example.sharingapp;

import android.content.Context;

import java.util.ArrayList;

/**
 * ItemController is responsible for all communication between views and Item object
 */
public class ContactListController {

    private ContactList contactList;

    public ContactListController(ContactList contactList) {
        this.contactList = contactList;
    }

    public ArrayList<Contact> getContacts() {
        return contactList.getContacts();
    }

    public void setContacts(ArrayList<Contact> contact_list) {
        contactList.setContacts(contact_list);
    }

    public ArrayList<String> getAllUsernames() {
        return contactList.getAllUsernames();
    }

    public boolean addContact(Contact contact, Context context) {
        AddContactCommand addContactCommand = new AddContactCommand(contactList, contact, context);
        addContactCommand.execute();
        return addContactCommand.isExecuted();
    }

    public boolean deleteContact(Contact contact, Context context) {
        DeleteContactCommand deleteContactCommand = new DeleteContactCommand(contactList, contact, context);
        deleteContactCommand.execute();
        return deleteContactCommand.isExecuted();
    }

    public boolean editContact(Contact old, Contact updated, Context context) {
        EditContactCommand editContactCommand = new EditContactCommand(contactList, old, updated, context);
        editContactCommand.execute();
        return editContactCommand.isExecuted();
    }

    public Contact getContact(int index) {
        return contactList.getContact(index);
    }

    public int getSize() {
        return contactList.getSize();
    }

    public boolean hasContact(Contact contact) {
        return contactList.hasContact(contact);
    }

    public int getIndex(Contact contact) {
        return contactList.getIndex(contact);
    }

    public boolean isUsernameAvailable(String username) {
        return contactList.isUsernameAvailable(username);
    }

    public void loadContacts(Context context) {
        contactList.loadContacts(context);
    }


    public void addObserver(Observer observer) {
        contactList.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        contactList.removeObserver(observer);
    }

    public Contact getContactByUsername(String username) {
        return contactList.getUserByUsername(username);
    }
}
