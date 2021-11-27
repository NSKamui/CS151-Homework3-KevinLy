package hw3.controller;

import hw3.Message;
import hw3.UpdateMessage;
import hw3.ResetMessage;
import hw3.model.Model;
import hw3.view.View;

import java.util.concurrent.BlockingQueue;

/**
 *  Controller class which communicates between the Model and View classes, checks messages sent from View
 */
public class Controller {
    BlockingQueue<Message> queue;
    Model model;
    View view;

    /**
     * Constructor that initializes the queue, model, and view that the Controller will be connected to through its fields
     *
     * @param queue BlockingQueue of Messages
     * @param model Model class which Controller will update
     * @param view View class which Controller will receive messages from and send instructions
     */
    public Controller(BlockingQueue<Message> queue, Model model, View view) {
        this.queue = queue;
        this.model = model;
        this.view = view;
    }

    /**
     * Looping method that checks for messages from view class
     */
    public void mainLoop() {

        while (view.isDisplayable()) {
            Message message = null;
            try {
                message = queue.take();
            } catch (InterruptedException exception) {
                //nothing
            }

            if (message.getClass() == UpdateMessage.class) {
                UpdateMessage updateMessage = (UpdateMessage) message;
                model.updateHeights(updateMessage.getRedValue(), updateMessage.getGreenValue(), updateMessage.getBlueValue());
                view.updateBarGraph(model.returnRedHeight(), model.returnGreenHeight(), model.returnBlueHeight());
            } else if (message.getClass() == ResetMessage.class) {
                model.resetHeights();
                view.resetBarGraph();
            }
        }
    }
}
