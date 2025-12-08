package view.Controllers;

import bean.GaaVendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ControllerConsultasVendas extends AbstractTableModel {

    private List lstVendas;

    public void setList(List lstVendas) {
        this.lstVendas = lstVendas;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lstVendas.size();
    }

    @Override
    public int getColumnCount() {
        return 3; // Código da venda / Vendedor / Total
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GaaVendas venda = (GaaVendas) lstVendas.get(rowIndex);

        if (columnIndex == 0) {
            return venda.getGaaIdVendas();
        } else if (columnIndex == 1) {
            return venda.getGaaVendedor().getGaaNome(); 
        } else if (columnIndex == 2) {
            return venda.getGaaTotal();
        }

        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Código";
        } else if (columnIndex == 1) {
            return "Vendedor";
        } else if (columnIndex == 2) {
            return "Total";
        }
        return "";
    }
}
