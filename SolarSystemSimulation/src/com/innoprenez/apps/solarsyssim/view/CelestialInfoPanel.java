/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innoprenez.apps.solarsyssim.view;


/**
 *
 * @author zinhle
 */
public class CelestialInfoPanel{} /*extends JPanel implements Updatable{
    JTextField nameField;
    JTextField positionField;
    public CelestialInfoPanel(){
        JLabel nameLabel=new JLabel("Celestial body:");
        nameField=new JTextField("Body name",16);
        nameField.setEditable(false);
        
        JLabel positionL=new JLabel("Position:");
        positionField=new JTextField("(,)",6);
        positionField.setEditable(false);
        
        setLayout(new FlowLayout());
        
        add(nameLabel,FlowLayout.LEFT);
        add(nameField);
        add(positionL);
        add(positionField);
        setBorder(new BevelBorder(BevelBorder.LOWERED));
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

    @Override
    public void update(CelestialBody body) {
        nameField.setText(body.getName());
        positionField.setText(body.getCenter().toString());
    }
}*/
