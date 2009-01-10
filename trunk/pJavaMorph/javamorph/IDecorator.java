package javamorph;

import java.awt.*;

/**
 * @version 1.0
 * <br/>
 * @author claus.erhard.wimmer@googlemail.com
 * <br/>
 * Program: JavaMorph V 1.0.
 * <br/>
 * Class: IDecorator.
 * <br/>
 * License: GPLv2.
 * <br/>
 * Description: Interface to draw some layers to a JComponent.
 * <br/> 
 * Hint: Consider the order of the several drawing steps!
 */
public interface IDecorator {
    /**
     * Draw the content.
     * @param g Graphics context of the JComponent.
     */
    public void paint(Graphics g);
    /** 
     * Notify the decorator implementation of the available size to draw to.
     * @param size Size in screen pixel units.
     */
    public void setSize(Dimension size);
    /**
     * Allow user actions to the decorator.
     * @param active <code>true</code> if the decorator is editable.
     */
    public void setActive(boolean active);
}