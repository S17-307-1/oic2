package view;

import gui.Button;
import gui.ButtonGroupRadio;
import gui.GuiDivision;
import gui.GuiImage;
import gui.GuiString;
import main.OperationIceCream;

public class CampaignConfigureView extends View {
  @Override
  void initContinue() {
    GuiDivision titleBar = new GuiDivision("title-bar");
    GuiString tempString = new GuiString("title", "Campaign", 0, 0);
    tempString.setFont(GuiString.HEADER_FONT);
    tempString.shift(
        (int) ((OperationIceCream.WINDOW_SIZE_X - tempString.getBoundingBox().getWidth()) / 2), 10);
    titleBar.addComponent(tempString);

    Button tempButton = new Button("back-btn", "res/back.png", null, 10, 10);
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(OperationIceCream.GAME_MODE_SELECT);
    });
    titleBar.addComponent(tempButton);
    scene.addComponent(titleBar);
    
    GuiDivision diffRow = new GuiDivision("");
    tempString = new GuiString("", "Difficulty", 0, 0);
    diffRow.addComponent(tempString);
    
    ButtonGroupRadio diffGroup = new ButtonGroupRadio(3);
    tempButton = new Button("", "res/easy.png", "res/easy_selected.png", 
        0, (int) (diffRow.getBoundingBox().getHeight() + 10));
    tempButton.addToRadioGroup(diffGroup);
    tempButton.activate();
    tempButton.setClickEvent(() -> {
      
    });
    diffRow.addComponent(tempButton);
    
    tempButton = new Button("", "res/medium.png", "res/medium_selected.png", 
        0, (int) (diffRow.getBoundingBox().getHeight() + 10));
    tempButton.addToRadioGroup(diffGroup);
    tempButton.setClickEvent(() -> {
      
    });
    diffRow.addComponent(tempButton);
    
    tempButton = new Button("", "res/hard.png", "res/hard_selected.png", 
        0, (int) (diffRow.getBoundingBox().getHeight() + 10));
    tempButton.addToRadioGroup(diffGroup);
    tempButton.setClickEvent(() -> {
      
    });
    diffRow.addComponent(tempButton);
    
    GuiDivision options = new GuiDivision("");
    options.addComponent(diffRow);
    
    options.addComponent(new GuiImage("", "res/characterCard.png", 
        options.getBoundingBox().getWidth() + 10, 0));
    
    tempButton = new Button("", "CUSTOMIZE CHARACTER", 
        (int) (options.getBoundingBox().getWidth() + 10), 0, 10);
    options.addComponent(tempButton);
    
    tempButton = new Button("", "PLAY", 
        0, (int) (options.getBoundingBox().getHeight() + 10), 10);
    options.addComponent(tempButton);
    
    options.shift(
        (int) ((OperationIceCream.WINDOW_SIZE_X - options.getBoundingBox().getWidth()) / 2.0), 100);
    scene.addComponent(options);
  }
}
