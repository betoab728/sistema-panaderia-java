/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.entities;

import java.awt.Component;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author ELIAS
 */
public class ClaveRender extends JPasswordField implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText((String)table.getValueAt(row, column));
        setBorder(null);
        return this;
    }
    
}
