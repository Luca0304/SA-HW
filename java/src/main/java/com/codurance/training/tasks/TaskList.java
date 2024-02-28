package com.codurance.training.tasks;

import com.codurance.training.tasks.Command.Command;
import com.codurance.training.tasks.Command.CommandCreater;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public final class TaskList implements Runnable {
    public final Map<String, List<Task>> tasks = new LinkedHashMap<>();
    private final BufferedReader in;
    public final PrintWriter out;
    public long lastId = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TaskList(in, out).run();
    }

    public TaskList(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
    }

    public void run() {
        while (true) {
            out.print("> ");
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
            execute(command);
        }
    }

    private void execute(String commandLine) {
        Command command = CommandCreater.create(commandLine, this);
        command.executeCommand();
    }
}
