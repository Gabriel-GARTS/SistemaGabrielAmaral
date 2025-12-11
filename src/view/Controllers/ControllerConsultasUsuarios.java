/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.Controllers;

import bean.GaaClientes;

import bean.GaaUsuarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class ControllerConsultasUsuarios extends AbstractTableModel {

    private List lstUsuarios;

    public void setList(List lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lstUsuarios.size();
                
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GaaUsuarios usuarios = (GaaUsuarios) lstUsuarios.get( rowIndex);
        if ( columnIndex == 0 ){
            return usuarios.getGaaIdusuarios();
        } else if (columnIndex ==1) {
            return usuarios.getGaaNome();        
        } else if (columnIndex ==2) {
            return usuarios.getGaaApelido();
        } 
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome";         
        } else if ( columnIndex == 2) {
            return "Apelido";
        }
        return "";
    }
}
