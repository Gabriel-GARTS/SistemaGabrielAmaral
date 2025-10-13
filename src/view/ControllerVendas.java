/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package view;
import bean.GaaVendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author ACER
 */
public class ControllerVendas extends AbstractTableModel{

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
        GaaVendas vendas = (GaaVendas) lista.get(rowIndex);
        if (columnIndex == 0) {
            return vendas.getGaaIdVendas();
        }
        if (columnIndex == 1) {
            return vendas.getGaaClientes();
        }
        if (columnIndex == 2) {
            return vendas.getGaaVendedor();
        }
        if (columnIndex == 3) {
            return vendas.getGaaTotal();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Código Venda";
        }
        if (column == 1) {
            return "Código Cliente";
        }
        if (column == 2) {
            return "Código Vendedor";
        }
        if (column == 3) {
            return "Total";
        }
        return "";
    }
}
    
