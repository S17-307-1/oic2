package view;

import gui.Button;
import gui.Carousel;
import gui.GuiDivision;
import gui.GuiString;
import main.OperationIceCream;

public class ControlSettingsView extends View {
  @Override
  void initContinue() {
    GuiDivision titleBar = new GuiDivision("title-bar");
    GuiString tempString = new GuiString("title", "Control Settings", 0, 0);
    tempString.setFont(GuiString.HEADER_FONT);
    tempString.shift(
        (int) ((OperationIceCream.WINDOW_SIZE_X - tempString.getBoundingBox().getWidth()) / 2), 10);
    titleBar.addComponent(tempString);

    Button tempButton = new Button("back-btn", "res/back.png", null, 10, 10);
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(OperationIceCream.MAIN_MENU);
    });
    titleBar.addComponent(tempButton);
    
    tempButton = new Button("", "res/audioSettings.png", null, 
        (int) (titleBar.getBoundingBox().getWidth() + 20), 0);
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(OperationIceCream.AUDIO_SETTINGS);
    });
    titleBar.addComponent(tempButton);
    
    tempButton = new Button("", "res/gameplaySettings.png", null, 
        (int) (titleBar.getBoundingBox().getWidth() + 20), 0);
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(OperationIceCream.GAMEPLAY_SETTINGS);
    });
    titleBar.addComponent(tempButton);
    
    tempButton = new Button("", "res/videoSettings.png", null, 
        (int) (titleBar.getBoundingBox().getWidth() + 20), 0);
    tempButton.setClickEvent(() -> {
      stateBasedGame.enterState(OperationIceCream.VIDEO_SETTINGS);
    });
    titleBar.addComponent(tempButton);
    scene.addComponent(titleBar);
    
    GuiDivision labels = new GuiDivision("");
    
    tempString = new GuiString("", "Movement", 0, 0);
    tempString.shift(0, 
        (int) ((Carousel.HEIGHT - tempString.getBoundingBox().getHeight()) / 2.0));
    labels.addComponent(tempString);
    
    tempString = new GuiString("", "Sensitivity", 0, 0);
    tempString.shift(0, 
        (int) ((Carousel.HEIGHT - tempString.getBoundingBox().getHeight()) / 2.0) + 20 + 40);
    labels.addComponent(tempString);
    
    tempString = new GuiString("", "Aim", 0, 0);
    tempString.shift(0, 
        (int) ((Carousel.HEIGHT - tempString.getBoundingBox().getHeight()) / 2.0) + 40 + 80);
    labels.addComponent(tempString);
    
    tempString = new GuiString("", "Throw Ice Cream", 0, 0);
    tempString.shift(0, 
        (int) ((Carousel.HEIGHT - tempString.getBoundingBox().getHeight()) / 2.0) + 60 + 120);
    labels.addComponent(tempString);
    
    GuiDivision options = new GuiDivision("");
    options.addComponent(labels);
    
    GuiDivision carousels = new GuiDivision("");
    
    Carousel tempCarousel = new Carousel("", new String[] {"WASD", "Arrow Keys"}, 0, 0, 100);
    carousels.addComponent(tempCarousel);
    
    tempCarousel = new Carousel("", new String[] {"Low", "Medium", "High"}, 0, 0, 100);
    tempCarousel.shift(0, (int) (carousels.getBoundingBox().getHeight() + 20));
    carousels.addComponent(tempCarousel);
    
    tempCarousel = new Carousel("", new String[] {"Mouse", "Keyboard"}, 0, 0, 100);
    tempCarousel.shift(0, (int) (carousels.getBoundingBox().getHeight() + 20));
    carousels.addComponent(tempCarousel);
    
    tempCarousel = new Carousel("", new String[] {"Spacebar", "Mouse"}, 0, 0, 100);
    tempCarousel.shift(0, (int) (carousels.getBoundingBox().getHeight() + 20));
    carousels.addComponent(tempCarousel);
    
    carousels.shift((int) (options.getBoundingBox().getWidth() + 20), 0);
    options.addComponent(carousels);
    
    options.shift(
        (int) ((OperationIceCream.WINDOW_SIZE_X - options.getBoundingBox().getWidth()) / 2.0), 300);
    scene.addComponent(options);
  }
}
