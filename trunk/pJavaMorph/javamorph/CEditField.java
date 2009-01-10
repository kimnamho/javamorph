package javamorph;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @version 1.0
 * <br/>
 * @author claus.erhard.wimmer@googlemail.com
 * <br/>
 * Program: JavaMorph V 1.0.
 * <br/>
 * Class: CEditField.
 * <br/>
 * License: GPLv2.
 * <br/>
 * Description: Graphical pair of label & text field. Used to enter
 * configuration data.
 * <br/>
 * Hint: Not valid values are clipped.
 */
public class CEditField extends JComponent implements FocusListener{
    /** Java API. */
    private static final long serialVersionUID = 1L;
    /** Show a short description of the input field to the user. */
    private JLabel key = new JLabel();
    /** Text field for user input. */
    private JTextField value = new JTextField(37);
    /** Minimum valid numerical value. */
    private int min;
    /** Maximum valid numerical value. */
    private int max;
    /**
     * Constructor for numerical value.
     * @param key Short description of the input field.
     * @param value Initial value of the input field.
     * @param min Minimum valid numerical value.
     * @param max Maximum valid numerical value.
     * @param edit When <code>true</code> then the input field is edit able.
     */
    public CEditField(String key, int value, int min, int max, boolean edit){
        this.min = min;
        this.max = max;
        this.key.setText(key);
        this.value.setText("" + value);
        this.value.setEditable(edit);
        this.setLayout(new BorderLayout());
        this.add("Center", this.key);
        this.add("East", this.value);
        this.key.setToolTipText("" + min + " <= value <= " + max);
        this.value.setToolTipText("" + min + " <= value <= " + max);
        this.value.addFocusListener(this);
    }
    /**
     * Constructor for a string value.
     * @param key Short description of the input field.
     * @param value Initial value of the input field.
     * @param edit When <code>true</code> then the input field is edit able.
     */
    public CEditField(String key, String value, boolean edit){
        this.key.setText(key);
        this.value.setText(value);
        this.value.setEditable(edit);
        this.setLayout(new BorderLayout());
        this.add("Center", this.key);
        this.add("East", this.value);
    }
    /**
     * Get function.
     * @return Numerical value of the input field.
     */
    public int getNumber(){
        try{
            return Integer.parseInt(value.getText());
        }catch(Exception e){
            return min;
        }
    }
    /**
     * Get function.
     * @return Content of the input field as string.
     */
    public String getValue(){
        return this.value.getText();
    }
    /**
     * Set function.
     * @param value Numerical value for assignment to the input field.
     */
    public void setValue(int value){
        this.value.setText("" + value);
    }
    /**
     * Set function.
     * @param value String value for assignment to the input field.
     */
    public void setValue(String value){
        this.value.setText(value);
    }
    /**
     * Call back to clip invalid numerical values of the input field.
     * If the old value is smaller than the minimum then the new value is the 
     * minimum.
     * If the old value is bigger than the maximum then the new value is the 
     * maximum.
     */
    private void checkValue(){
        int number = this.getNumber();
        number = Math.min(max, Math.max(number, min));
        value.setText("" + number);
    }
    /** Event API. */
    public void focusGained(FocusEvent e){}
    /**
     *  Check the numerical value when the text field loses the input focus.
     */
    public void focusLost(FocusEvent e){
        this.checkValue();   
    }
}
