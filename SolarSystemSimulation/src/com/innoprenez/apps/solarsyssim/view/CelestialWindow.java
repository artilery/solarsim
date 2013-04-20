
package com.innoprenez.apps.solarsyssim.view;



public class CelestialWindow{}/* extends JFrame{
    //actions
    Action startAction;
    Action stopAction;
    Action addBodyAction;
    Action clearBodiesAction;
    Action exitAction;
    //panels
    CelestialDisplayPanel displayPanel;
    AddBodyDialog dialog;
    public CelestialWindow(){
        super("Solar System Simulation");
        
        setLayout(new BorderLayout());
        
        initializeActions();
        final JPopupMenu pmenu=new JPopupMenu();
        //menu
        JMenuBar menuBar=new JMenuBar();
        JMenu menu=new JMenu("File");
        //menu items
        menu.add(startAction);
        menu.add(stopAction);
        menu.addSeparator();
        menu.add(addBodyAction);
        menu.add(clearBodiesAction);
        menu.addSeparator();
        menu.add(exitAction);
        //pop up set-up
        pmenu.add(addBodyAction);
        pmenu.add(clearBodiesAction);
        pmenu.addSeparator();
        pmenu.add(startAction);
        pmenu.add(stopAction);
        //adding to bar
        menuBar.add(menu);
        //add panels
        add(menuBar,BorderLayout.NORTH);
        CelestialInfoPanel infoDisplay=new CelestialInfoPanel();
        displayPanel=new CelestialDisplayPanel(infoDisplay);
        dialog=new AddBodyDialog(this, true,displayPanel.getBodies());
        displayPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event){
                checkForTriggerEvent(event);
            }
            @Override
            public void mouseReleased(MouseEvent event){
                checkForTriggerEvent(event);
            }
            public void checkForTriggerEvent(MouseEvent event){
                if(event.isPopupTrigger())
                   pmenu.show(event.getComponent(), event.getX(), event.getY());
            }
        });
        add(displayPanel,BorderLayout.CENTER);
        add(infoDisplay,BorderLayout.SOUTH);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 700);
        setVisible(true);
    }
    private void initializeActions(){
        startAction=new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayPanel.startSimulation();
                setEnabled(false);
                stopAction.setEnabled(true);
            }
        };
        startAction.putValue(Action.NAME, "Start Simulation");
        stopAction=new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayPanel.stopSimulation();
                startAction.setEnabled(true);
                setEnabled(false);
            }
        };
        stopAction.putValue(Action.NAME, "Stop Simulation");
        stopAction.setEnabled(false);
        exitAction=new AbstractAction("Exit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        addBodyAction=new AbstractAction("+ Create Celestial Body") {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);
            }
        };
        clearBodiesAction=new AbstractAction("- Clear Celestial Bodies") {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayPanel.clearBodies();
            }
        };
    }
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddBodyDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddBodyDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddBodyDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddBodyDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        new CelestialWindow();
    }
}*/
