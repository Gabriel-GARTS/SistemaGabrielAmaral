/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package view;
import bean.GaaVendasProdutos;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ACER
 */
public class ControllerVendasProdutos extends AbstractTableModel{

    private List lista;

    public void setList(List lista) {
        this.lista = lista;
    }

    public Object getBean(int rowIndex) {
       return lista.get(rowIndex);    
    }
    
    @Override
    public int getRowCount() {
        
        return 0; 
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         GaaVendasProdutos vendasProdutos = (GaaVendasProdutos) lista.get(rowIndex);
        if (columnIndex == 0) {
            return vendasProdutos.getGaaIdVendasProdutos();
        }
        if (columnIndex == 1) {
            return vendasProdutos.getGaaVendas();
        }
        if (columnIndex == 2) {
            return vendasProdutos.getGaaProdutos();
        }
        if (columnIndex == 3) {
            return vendasProdutos.getGaaDataEntrega();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Código";
        }
        if (column == 1) {
            return "Código da Venda";
        }
        if (column == 2) {
            return "Código do Produto";
        }
        if (column == 3) {
            return "Data de entrega";
        }
        return "";
    }
}
    
