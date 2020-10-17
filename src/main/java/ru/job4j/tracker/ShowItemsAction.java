package ru.job4j.tracker;

public class ShowItemsAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        for (int index = 0; index < items.length; index++) {
            System.out.println("" + (index + 1) + ". " + items[index]);
        }
        System.out.println();
        return true;
    }
}
