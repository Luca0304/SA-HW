package com.codurance.training.tasks.app;


import com.codurance.training.tasks.adapters.controller.CommandController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TaskListApp implements Runnable {
    private final BufferedReader in;
    private final PrintWriter out;
    private final CommandController commandController = new CommandController();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TaskListApp(in, out).run();
    }

    public TaskListApp(BufferedReader reader, PrintWriter writer) {
        this.in = new BufferedReader(reader);
        this.out = new PrintWriter(writer);
    }

    public void run() {
        while (true) {
            out.printf("> ");
            out.flush();
            String command;
            try {
                command = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals("quit")) {
                break;
            }
            this.out.printf(commandController.execute(command).exeOut());
        }
    }

}
