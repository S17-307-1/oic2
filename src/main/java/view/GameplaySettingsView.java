package view;

import gui.Button;
import gui.ButtonGroupRadio;
import gui.Carousel;
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
    
    tempButton = new Button("", "res/controlSettings.png", null, 
        (int) (titleBar.getBoundingBox().getWidth() + 20), 0);
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(OperationIceCream.CONTROL_SETTINGS);
    });
    titleBar.addComponent(tempButton);
    
    tempButton = new Button("", "res/audioSettings.png", null, 
        (int) (titleBar.getBoundingBox().getWidth() + 20), 0);
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(OperationIceCream.AUDIO_SETTINGS);
    });
    titleBar.addComponent(tempButton);
    
    tempButton = new Button("", "res/videoSettings.png", null, 
        (int) (titleBar.getBoundingBox().getWidth() + 20), 0);
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(OperationIceCream.VIDEO_SETTINGS);
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
    
    GuiDivision labels = new GuiDivision("");
    
    tempString = new GuiString("", "Music Volume", 0, 0);
    tempString.shift(0, 
        (int) ((Carousel.HEIGHT - tempString.getBoundingBox().getHeight()) / 2.0));
    labels.addComponent(tempString);
    
    tempString = new GuiString("", "Game Volume", 0, 0);
    tempString.shift(0, 
        (int) ((Carousel.HEIGHT - tempString.getBoundingBox().getHeight()) / 2.0) + 20 + 40);
    labels.addComponent(tempString);
    
    tempString = new GuiString("", "Ambient Noise", 0, 0);
    tempString.shift(0, 
        (int) ((Carousel.HEIGHT - tempString.getBoundingBox().getHeight()) / 2.0) + 40 + 80);
    labels.addComponent(tempString);
    
    tempString = new GuiString("", "Output Type", 0, 0);
    tempString.shift(0, 
        (int) ((Carousel.HEIGHT - tempString.getBoundingBox().getHeight()) / 2.0) + 60 + 120);
    labels.addComponent(tempString);
    
    GuiDivision options = new GuiDivision("");
    options.addComponent(labels);
    
    GuiDivision carousels = new GuiDivision("");
    
    Carousel tempCarousel = new Carousel("", 0, 100, 1, "%", 0, 0, 100);
    carousels.addComponent(tempCarousel);
    
    tempCarousel = new Carousel("", 0, 100, 1, "%", 0, 0, 100);
    tempCarousel.shift(0, (int) (carousels.getBoundingBox().getHeight() + 20));
    carousels.addComponent(tempCarousel);
    
    tempCarousel = new Carousel("", new String[] {"Enabled", "Disabled"}, 0, 0, 100);
    tempCarousel.shift(0, (int) (carousels.getBoundingBox().getHeight() + 20));
    carousels.addComponent(tempCarousel);
    
    tempCarousel = new Carousel("", new String[] {"Stereo", "Something Else"}, 0, 0, 100);
    tempCarousel.shift(0, (int) (carousels.getBoundingBox().getHeight() + 20));
    carousels.addComponent(tempCarousel);
    
    carousels.shift((int) (options.getBoundingBox().getWidth() + 20), 0);
    options.addComponent(carousels);
    
    options.shift(
        (int) ((OperationIceCream.WINDOW_SIZE_X - options.getBoundingBox().getWidth()) / 2.0), 300);
    scene.addComponent(options);
  }
}
