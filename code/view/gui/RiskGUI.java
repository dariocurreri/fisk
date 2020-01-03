package risk;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.*;
import javax.swing.*;

public class RiskGUI extends JFrame {

    private static final Integer WIDTH = 1300;
    private static final Integer HEIGHT = 700;
    private final Facade facade;
    private final BoardPanel boardPanel;
    private final LogPanel logPanel;
    private final PlayerPanel playerPanel;

    public RiskGUI(Facade facade) {
        super();
        this.setTitle("Risk");
        this.facade = facade;
        this.playerPanel = new PlayerPanel(RiskGUI.WIDTH / 5, RiskGUI.HEIGHT, facade);
        this.boardPanel = new BoardPanel(RiskGUI.WIDTH - RiskGUI.WIDTH / 5, 
                                         RiskGUI.HEIGHT - RiskGUI.HEIGHT / 6, 
                                         this.facade.getTerritories(), 
                                         this.facade.getAllContinentsBonus(), facade);
        this.boardPanel.updateColors(this.facade.getTerritories());
        this.logPanel = new LogPanel(RiskGUI.WIDTH - RiskGUI.WIDTH / 5, RiskGUI.HEIGHT / 6);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.add(this.playerPanel, BorderLayout.WEST);
        JPanel centerJPanel = new JPanel();
        centerJPanel.setLayout(new BorderLayout(0, 0));
        centerJPanel.setPreferredSize(new Dimension(RiskGUI.WIDTH - RiskGUI.WIDTH / 5, RiskGUI.HEIGHT));
        contentPane.add(centerJPanel, BorderLayout.CENTER);
        centerJPanel.add(this.boardPanel, BorderLayout.NORTH);
        centerJPanel.add(this.logPanel, BorderLayout.CENTER);
        this.setSize(RiskGUI.WIDTH, RiskGUI.HEIGHT);
        this.defaultOperations();
    }

    private void defaultOperations() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void updateLogPanel(String string) {
        this.logPanel.append(string);
    }

    public void updatePlayerPanel(Integer numberOfTerritories, Integer numberOfFreeTanks, String currentStage) {
        this.playerPanel.updateLabels(numberOfTerritories, numberOfFreeTanks, currentStage);
    }

    public void updateLabelsTerritoriesButtons(List<Territory> territories) {
        this.boardPanel.updateLabels(territories);
    }

    public void setClickableTerritories(List<Territory> territories) {
        this.boardPanel.setClickableTerritories(territories);
    }

    public void updateColorsTerritoriesButtons(List<Territory> territories) {
        this.boardPanel.updateColors(territories);
    }
    
    public void enableCardsButton() {
        this.playerPanel.enableCardsButton();
    }
    
    public void enableEndStageButton() {
        this.playerPanel.enableEndStageButton();
    }
    
    public void disableCardsButton() {
        this.playerPanel.disableCardsButton();
    }
    
    public void disableEndStageButton() {
        this.playerPanel.disableEndStageButton();
    }
    
    public void showError(String error) {
        JOptionPane.showMessageDialog(this, error);
    }

    public void showMessage ( String message ){
        JOptionPane.showMessageDialog(this, message);
    }
    
}
