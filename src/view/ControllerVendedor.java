/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package view;

import bean.GaaVendedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author ACER
 */
public class ControllerVendedor extends AbstractTableModel{

    private List lista;

    public void setList(List lista) {
        this.lista = lista;
    }

    public Object getBean(int rowIndex) {
       return lista.get(rowIndex);    
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GaaVendedor vendedor = (GaaVendedor) lista.get(rowIndex);
        if (columnIndex == 0) {
            return vendedor.getGaaIdVendedor();
        }
        if (columnIndex == 1) {
            return vendedor.getGaaNome();
        }
        if (columnIndex == 2) {
            return vendedor.getGaaCpf();
        }
        if (columnIndex == 3) {
            return vendedor.getGaaSalario();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Código";
        }
        if (column == 1) {
            return "Nome";
        }
        if (column == 2) {
            return "Cpf";
        }
        if (column == 3) {
            return "Salário";
        }
        return "";
    }
}
    

