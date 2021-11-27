package hw3;

import hw3.model.Model;
import hw3.view.View;
import hw3.controller.Controller;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *  App class for running the program which has a bar chart with 3 bars that can be updated in height separately
 */
public class App {

    /**
     * Initializes queue, Model, View, and Controller, and then calls the mainLoop from Controller
     *
     * @param args The command line arguments
     */
    public static void main(String[] args) {

        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();

        Model model = new Model();
        View view = new View(queue, 0, 0, 0);
        Controller controller = new Controller(queue, model, view);
        controller.mainLoop();
    }
}
