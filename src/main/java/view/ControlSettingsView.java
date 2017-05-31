package view;

import gui.Carousel;
import gui.GuiDivision;
import gui.GuiString;
import main.OperationIceCream;

public class ControlSettingsView extends View {
  @Override
  void initContinue() {
    initTitleBar("Control Settings", new String[] {"audio", "gameplay", "video"});
    
    GuiDivision labels = new GuiDivision("");
    
    GuiString tempString = new GuiString("", "Movement", 0, 0);
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
