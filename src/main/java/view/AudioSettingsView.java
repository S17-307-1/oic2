package view;

import gui.Button;
import gui.GuiDivision;
import gui.GuiString;
import main.OperationIceCream;

public class AudioSettingsView extends View {
  @Override
  void initContinue() {
    GuiDivision titleBar = new GuiDivision("title-bar");
    GuiString tempString = new GuiString("title", "Audio Settings", 0, 0);
    tempString.setFont(GuiString.HEADER_FONT);
    tempString.shift(
        (int) ((OperationIceCream.WINDOW_SIZE_X - tempString.getBoundingBox().getWidth()) / 2), 10);
    titleBar.addComponent(tempString);

    Button tempButton = new Button("back-btn", "res/back.png", null, 10, 10);
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(OperationIceCream.MAIN_MENU);
    });
    titleBar.addComponent(tempButton);
    scene.addComponent(titleBar);
  }
}
