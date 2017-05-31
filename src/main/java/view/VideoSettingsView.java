package view;

import gui.Carousel;
import gui.GuiDivision;
import gui.GuiString;
import main.OperationIceCream;

public class VideoSettingsView extends View {
  @Override
  void initContinue() {
    initTitleBar("Video Settings", new String[] {"control", "gameplay", "audio"});
    
    GuiDivision labels = new GuiDivision("");
    
    GuiString tempString = new GuiString("", "Resolution", 0, 0);
    tempString.shift(0, 
        (int) ((Carousel.HEIGHT - tempString.getBoundingBox().getHeight()) / 2.0));
    labels.addComponent(tempString);
    
    tempString = new GuiString("", "Anti-Aliasing", 0, 0);
    tempString.shift(0, 
        (int) ((Carousel.HEIGHT - tempString.getBoundingBox().getHeight()) / 2.0) + 20 + 40);
    labels.addComponent(tempString);
    
    tempString = new GuiString("", "FPS", 0, 0);
    tempString.shift(0, 
        (int) ((Carousel.HEIGHT - tempString.getBoundingBox().getHeight()) / 2.0) + 40 + 80);
    labels.addComponent(tempString);
    
    tempString = new GuiString("", "V-Sync", 0, 0);
    tempString.shift(0, 
        (int) ((Carousel.HEIGHT - tempString.getBoundingBox().getHeight()) / 2.0) + 60 + 120);
    labels.addComponent(tempString);
    
    GuiDivision options = new GuiDivision("");
    options.addComponent(labels);
    
    GuiDivision carousels = new GuiDivision("");
    
    Carousel tempCarousel = new Carousel("", new String[] {"1920x1080", "lowerxlower"}, 0, 0, 100);
    carousels.addComponent(tempCarousel);
    
    tempCarousel = new Carousel("", new String[] {"Enabled", "Disabled"}, 0, 0, 100);
    tempCarousel.shift(0, (int) (carousels.getBoundingBox().getHeight() + 20));
    carousels.addComponent(tempCarousel);
    
    tempCarousel = new Carousel("", new String[] {"120 FPS", "60 FPS"}, 0, 0, 100);
    tempCarousel.shift(0, (int) (carousels.getBoundingBox().getHeight() + 20));
    carousels.addComponent(tempCarousel);
    
    tempCarousel = new Carousel("", new String[] {"Enabled", "Disabled"}, 0, 0, 100);
    tempCarousel.shift(0, (int) (carousels.getBoundingBox().getHeight() + 20));
    carousels.addComponent(tempCarousel);
    
    carousels.shift((int) (options.getBoundingBox().getWidth() + 20), 0);
    options.addComponent(carousels);
    
    options.shift(
        (int) ((OperationIceCream.WINDOW_SIZE_X - options.getBoundingBox().getWidth()) / 2.0), 300);
    scene.addComponent(options);
  }
}
