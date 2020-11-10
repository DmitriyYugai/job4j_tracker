package ru.job4j.tracker;

import java.util.List;

public class FindAllAction implements UserAction {
    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Show all items ===");
        List<Item> items = tracker.findAll();
        for (int index = 0; index < items.size(); index++) {
            out.println("" + (index + 1) + ". " + items.get(index));
        }
        return true;
    }
}
