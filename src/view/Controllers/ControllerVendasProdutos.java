/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package view.Controllers;
import bean.GaaVendasProdutos;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import tools.Util;

/**
 *
 * @author ACER
 */
public class ControllerVendasProdutos extends AbstractTableModel{

    private List lstVendProd;

    public void setList(List lstPedidosProdutos) {
        this.lstVendProd = lstPedidosProdutos;
        this.fireTableDataChanged();
    }

    public GaaVendasProdutos getBean(int rowIndex) {
        return (GaaVendasProdutos) lstVendProd.get(rowIndex);
    }
    
     public void addBean(GaaVendasProdutos vendasProdutos){
        this.lstVendProd.add(vendasProdutos);
        this.fireTableDataChanged();
    }
     
     public void removeBean(int rowIndex) {
        this.lstVendProd.remove(rowIndex); 
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        
       return lstVendProd.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         GaaVendasProdutos vendProd = (GaaVendasProdutos) lstVendProd.get(rowIndex);
        if (columnIndex == 0) {
             return vendProd.getGaaProdutos().getGaaIdProdutos();
        }
        if (columnIndex == 1) {
             return vendProd.getGaaProdutos().getGaaNome();
        }
        if (columnIndex == 2) {
             return vendProd.getGaaQuantidade();
        }
        if (columnIndex == 3) {
               return Util.dateToStr(vendProd.getGaaDataEntrega());
        }
        
        if (columnIndex == 4) {
               return (vendProd.getGaaQuantidade() * vendProd.getGaaPrecoUnitario()) - vendProd.getGaaDesconto();
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
            return "Quantidade";
        }
        if (column == 3) {
            return "Data de Entrega";
        }
        if (column == 4) {
            return "Preço";
        }
        return "";
    }
}
    
