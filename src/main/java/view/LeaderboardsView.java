package view;

import org.newdawn.slick.Color;

import gui.Button;
import gui.GuiDivision;
import gui.GuiString;
import gui.IFrame;
import main.OperationIceCream;

public class LeaderboardsView extends View {
  @Override
  void initContinue() {
    GuiDivision titleBar = new GuiDivision("title-bar");
    GuiString tempString = new GuiString("title", "Leaderboards", 0, 0);
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
    
    GuiDivision entries = new GuiDivision("");
    addEntry("Rank", "Name", "Score", entries, 600);
    addEntry("1.", "Collin Dutter", "1001", entries, 600);
    addEntry("2.", "Dr. Falessi", "1000", entries, 600);
    addEntry("3.", "John Bradbury", "999.75", entries, 600);
    addEntry("4.", "Stephanie Lascola", "750", entries, 600);
    addEntry("5.", "Arya Karnik", "743", entries, 600);
    addEntry("6.", "Megan Pieczynski", "Score", entries, 600);
    addEntry("7.", "Sean Slater", "Score", entries, 600);
    IFrame entriesFrame = new IFrame("", (OperationIceCream.WINDOW_SIZE_X - 600) / 2, 
        400, 600, 400, Color.white);
    entriesFrame.addComponent(entries);
    scene.addComponent(entriesFrame);
  }
  
  private void addEntry(String rank, String name, String score, GuiDivision entries, int width) {
    GuiDivision tempRow = new GuiDivision("");
    GuiString tempString = new GuiString("", rank, 10, 10);
    tempRow.addComponent(tempString);
    
    tempString = new GuiString("", name, 0, 10);
    tempString.shift((int) ((width - tempString.getBoundingBox().getWidth()) / 2.0), 0);
    tempRow.addComponent(tempString);
    
    tempString = new GuiString("", score, 0, 10);
    tempString.shift((int) (width - tempString.getBoundingBox().getWidth() - 10), 0);
    tempRow.addComponent(tempString);
    
    tempRow.shift(0, (int) (entries.getBoundingBox().getHeight() + 10));
    entries.addComponent(tempRow);
  }
}
