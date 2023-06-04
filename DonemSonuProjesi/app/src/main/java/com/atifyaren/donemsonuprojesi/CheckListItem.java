package com.atifyaren.donemsonuprojesi;

public class CheckListItem {
    private String text;
    private boolean checked;

    public CheckListItem(String text) {
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

}
