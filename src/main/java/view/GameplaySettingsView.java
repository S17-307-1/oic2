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
    initTitleBar("Gameplay Settings", new String[] {"control", "audio", "video"});
    
    ButtonGroupRadio diffGroup = new ButtonGroupRadio(3);
    Button tempButton = new Button("", "res/easy.png", "res/easy_selected.png", 0, 0);
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
    
    GuiString tempString = new GuiString("", "Base Player Health", 0, 0);
    tempString.shift(0, 
        (int) ((Carousel.HEIGHT - tempString.getBoundingBox().getHeight()) / 2.0));
    labels.addComponent(tempString);
    
    tempString = new GuiString("", "Base Enemy Health", 0, 0);
    tempString.shift(0, 
        (int) ((Carousel.HEIGHT - tempString.getBoundingBox().getHeight()) / 2.0) + 20 + 40);
    labels.addComponent(tempString);
    
    tempString = new GuiString("", "Base Player Speed", 0, 0);
    tempString.shift(0, 
        (int) ((Carousel.HEIGHT - tempString.getBoundingBox().getHeight()) / 2.0) + 40 + 80);
    labels.addComponent(tempString);
    
    tempString = new GuiString("", "Base Enemy Speed", 0, 0);
    tempString.shift(0, 
        (int) ((Carousel.HEIGHT - tempString.getBoundingBox().getHeight()) / 2.0) + 60 + 120);
    labels.addComponent(tempString);
    
    tempString = new GuiString("", "Base Enemies Per Wave", 0, 0);
    tempString.shift(0, 
        (int) ((Carousel.HEIGHT - tempString.getBoundingBox().getHeight()) / 2.0) + 80 + 160);
    labels.addComponent(tempString);
    
    tempString = new GuiString("", "Ice Cream Effectiveness", 0, 0);
    tempString.shift(0, 
        (int) ((Carousel.HEIGHT - tempString.getBoundingBox().getHeight()) / 2.0) + 100 + 200);
    labels.addComponent(tempString);
    
    GuiDivision options = new GuiDivision("");
    options.addComponent(labels);
    
    GuiDivision carousels = new GuiDivision("");
    
    Carousel tempCarousel = new Carousel(1, 20, 1, " Lives", 0, 0, 100);
    carousels.addComponent(tempCarousel);
    
    tempCarousel = new Carousel(1, 20, 1, " Lives", 0, 0, 100);
    tempCarousel.shift(0, (int) (carousels.getBoundingBox().getHeight() + 20));
    carousels.addComponent(tempCarousel);
    
    tempCarousel = new Carousel(1, 20, 1, " m/s", 0, 0, 100);
    tempCarousel.shift(0, (int) (carousels.getBoundingBox().getHeight() + 20));
    carousels.addComponent(tempCarousel);
    
    tempCarousel = new Carousel(1, 20, 1, " m/s", 0, 0, 100);
    tempCarousel.shift(0, (int) (carousels.getBoundingBox().getHeight() + 20));
    carousels.addComponent(tempCarousel);
    
    tempCarousel = new Carousel(1, 20, 1, "", 0, 0, 100);
    tempCarousel.shift(0, (int) (carousels.getBoundingBox().getHeight() + 20));
    carousels.addComponent(tempCarousel);
    
    tempCarousel = new Carousel(50, 200, 25, "%", 0, 0, 100);
    tempCarousel.shift(0, (int) (carousels.getBoundingBox().getHeight() + 20));
    carousels.addComponent(tempCarousel);
    
    carousels.shift((int) (options.getBoundingBox().getWidth() + 20), 0);
    options.addComponent(carousels);
    
    options.shift(
        (int) ((OperationIceCream.WINDOW_SIZE_X - options.getBoundingBox().getWidth()) / 2.0), 300);
    scene.addComponent(options);
  }
}
