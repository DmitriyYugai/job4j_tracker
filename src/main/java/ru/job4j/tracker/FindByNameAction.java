package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find items by name ===");
        String name = input.askStr("Enter name of the items searched: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (int index = 0; index < items.size(); index++) {
                out.println("" + (index + 1) + ". " + items.get(index));
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
