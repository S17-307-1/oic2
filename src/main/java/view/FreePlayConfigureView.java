package view;

import gui.Button;
import gui.ButtonGroupRadio;
import gui.GuiDivision;
import gui.GuiString;
import main.OperationIceCream;

public class FreePlayConfigureView extends View {
  
  @Override
  void initContinue() {
    GuiDivision titleBar = new GuiDivision("title-bar");
    GuiString tempString = new GuiString("title", "Free Play", 0, 0);
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
    
    /////////////////////////////////////////////////////////////////////////////////////////
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
    /////////////////////////////////////////////////////////////////////////////////////////
    
    diffRow = new GuiDivision("");
    tempString = new GuiString("", "Map", 0, 0);
    diffRow.addComponent(tempString);
    
    diffGroup = new ButtonGroupRadio(3);
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
    
    diffRow.shift((int) (options.getBoundingBox().getWidth() + 20), 0);
    options.addComponent(diffRow);
    /////////////////////////////////////////////////////////////////////////////////////////
    
    diffRow = new GuiDivision("");
    tempString = new GuiString("", "Mode", 0, 0);
    diffRow.addComponent(tempString);
    
    diffGroup = new ButtonGroupRadio(2);
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
    
    diffRow.shift((int) (options.getBoundingBox().getWidth() + 20), 0);
    options.addComponent(diffRow);
    /////////////////////////////////////////////////////////////////////////////////////////
    
    diffRow = new GuiDivision("");
    tempString = new GuiString("", "Character", 0, 0);
    diffRow.addComponent(tempString);
    
    tempButton = new Button("", "CUSTOMIZE", 0, 
        (int) (diffRow.getBoundingBox().getHeight() + 10), 200, false);
    tempButton.setClickEvent(() -> {
      
    });
    diffRow.addComponent(tempButton);
    
    diffGroup = new ButtonGroupRadio(2);
    tempButton = new Button("", "JOE BRO JOE", 0, 
        (int) (diffRow.getBoundingBox().getHeight() + 10), 200, true);
    tempButton.addToRadioGroup(diffGroup);
    tempButton.setClickEvent(() -> {
      
    });
    diffRow.addComponent(tempButton);
    
    tempButton = new Button("", "JASMINE", 0, 
        (int) (diffRow.getBoundingBox().getHeight() + 10), 200, true);
    tempButton.addToRadioGroup(diffGroup);
    tempButton.setClickEvent(() -> {
      
    });
    diffRow.addComponent(tempButton);
    
    diffRow.shift((int) (options.getBoundingBox().getWidth() + 20), 0);
    options.addComponent(diffRow);
    /////////////////////////////////////////////////////////////////////////////////////////
    
    tempButton = new Button("btn-1", "PLAY", 0, 500, 250, false);
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(OperationIceCream.IN_GAME);
    });
    tempButton.shift(
        (int) ((options.getBoundingBox().getWidth() 
            - tempButton.getBoundingBox().getWidth()) / 2.0), 0);
    options.addComponent(tempButton);
    
    options.shift(
        (int) ((OperationIceCream.WINDOW_SIZE_X - options.getBoundingBox().getWidth()) / 2.0), 300);
    scene.addComponent(options);
  }

}
