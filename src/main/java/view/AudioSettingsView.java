package view;

import gui.Carousel;
import gui.GuiDivision;
import gui.GuiString;
import main.OperationIceCream;

public class AudioSettingsView extends View {
  @Override
  void initContinue() {
    initTitleBar("Audio Settings", new String[] {"control", "gameplay", "video"});
    
    GuiDivision labels = new GuiDivision("");
    
    GuiString tempString = new GuiString("", "Music Volume", 0, 0);
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
