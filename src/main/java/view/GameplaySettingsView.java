package view;

import gui.Button;
import gui.ButtonGroupRadio;
import gui.GuiDivision;
import gui.GuiString;
import main.OperationIceCream;

public class GameplaySettingsView extends View {
  @Override
  void initContinue() {
    GuiDivision titleBar = new GuiDivision("title-bar");
    GuiString tempString = new GuiString("title", "Gameplay Settings", 0, 0);
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
    
    ButtonGroupRadio diffGroup = new ButtonGroupRadio(3);
    tempButton = new Button("", "res/easy.png", "res/easy_selected.png", 0, 0);
    tempButton.addToRadioGroup(diffGroup);
    tempButton.activate();
    tempButton.setClickEvent(() -> {
      
    });
    GuiDivision diffRow = new GuiDivision("");
    diffRow.addComponent(tempButton);
    
    tempButton = new Button("", "res/medium.png", "res/medium_selected.png", 
        (int) (diffRow.getBoundingBox().getWidth() + 10), 0);
    tempButton.addToRadioGroup(diffGroup);
    tempButton.setClickEvent(() -> {
      
    });
    diffRow.addComponent(tempButton);
    
    tempButton = new Button("", "res/hard.png", "res/hard_selected.png", 
        (int) (diffRow.getBoundingBox().getWidth() + 10), 0);
    tempButton.addToRadioGroup(diffGroup);
    tempButton.setClickEvent(() -> {
      
    });
    diffRow.addComponent(tempButton);
    
    diffRow.shift(
        (int) ((OperationIceCream.WINDOW_SIZE_X - diffRow.getBoundingBox().getWidth()) / 2.0), 100);
    scene.addComponent(diffRow);
  }
}
