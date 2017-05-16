package gui;

public class ButtonGroupRadio {
  private Button[] buttons;
  private int buttonLen;

  public ButtonGroupRadio(int groupsize) {
    buttons = new Button[groupsize];
    buttonLen = 0;
  }

  void addButton(Button button) {
    buttons[buttonLen] = button;
    buttonLen++;
  }

  void deselectButtons() {
    for (int i = 0; i < buttonLen; i++) {
      buttons[i].deactivate();
    }
  }
}
