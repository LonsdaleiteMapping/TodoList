package SnakeGame.EventSystem;

import SnakeGame.Enums.ListenerNames;
import TodoList.TodoList;
import TodoList.Item;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EventHandler extends TodoList {

    private static EventHandler eventHandler_instance = null;

    Map<ListenerNames, List<PropertyChangeSupport>> propertyChangeMap;

    private EventHandler(){
        propertyChangeMap = new HashMap<>();
    }

    public void trackAddItem(PropertyChangeListener l){
        PropertyChangeSupport pcs = new PropertyChangeSupport(this);
        pcs.addPropertyChangeListener(ListenerNames.ITEM_ADDED.toString(),l);

        if(!propertyChangeMap.containsKey(ListenerNames.ITEM_ADDED)){
            propertyChangeMap.put(ListenerNames.ITEM_ADDED,new ArrayList<>());
        }
        propertyChangeMap.get(ListenerNames.ITEM_ADDED).add(pcs);
    }

    public void trackItemDone(PropertyChangeListener l){
        PropertyChangeSupport pcs = new PropertyChangeSupport(this);
        pcs.addPropertyChangeListener(ListenerNames.ITEM_SET_DONE.toString(),l);

        if(!propertyChangeMap.containsKey(ListenerNames.ITEM_SET_DONE)){
            propertyChangeMap.put(ListenerNames.ITEM_SET_DONE,new ArrayList<>());
        }
        propertyChangeMap.get(ListenerNames.ITEM_SET_DONE).add(pcs);
    }

    public static EventHandler getInstance(){
        if(eventHandler_instance == null)
            eventHandler_instance = new EventHandler();
        return eventHandler_instance;
    }

    @Override
    public void addItem(Item item){
        super.addItem(item);
        propertyChangeMap.get(ListenerNames.ITEM_ADDED)
                .forEach( listener -> listener.firePropertyChange(ListenerNames.ITEM_ADDED.toString(),null,item));

    }

    // Probably need to see if this works
    @Override
    public void setItemDone(int index){
        Item updatedItem = super.getItem(index);
        updatedItem.setDone(true);
        propertyChangeMap.get(ListenerNames.ITEM_SET_DONE)
                .forEach( listener -> listener.firePropertyChange(ListenerNames.ITEM_SET_DONE.toString(),null,updatedItem));

    }

    public void setItemDone(Item item){
        Item updatedItem = super.getItem(item);
        updatedItem.setDone(true);
        propertyChangeMap.get(ListenerNames.ITEM_SET_DONE)
                .forEach( listener -> listener.firePropertyChange(ListenerNames.ITEM_SET_DONE.toString(),null,updatedItem));

    }

}
