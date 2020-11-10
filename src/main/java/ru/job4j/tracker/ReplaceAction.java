package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, MemTracker tracker) {
        out.println("=== Edit item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name of the new item: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("Заявка успешно обновлена");
        } else {
            out.println("Не удалось обновить заявку");
        }
        return true;
    }
}
