package com.doms.javaprogramming;

class TaskItem {
    private String text;
    private boolean checked;

    public TaskItem(String text) {
        this.text = text;
        this.checked = false;
    }

    public String getText() {
        return text;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return text; // This is what JList displays
    }
}
