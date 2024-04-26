package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class FormThanhToan extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable table;

    /**
     * Create the panel.
     */
    public FormThanhToan() {
        setBackground(new Color(123, 104, 238));
        setBounds(0, 0, 1120, 709);
        setLayout(null);

        JLabel lblNewLabel = new JLabel("THANH TOÁN");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30)); // Bold font
        lblNewLabel.setBounds(10, 10, 223, 43);
        add(lblNewLabel);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Panel for displaying product information
        JPanel panelTable = new JPanel();
        panelTable.setBounds(10, 64, 780, 624);
        add(panelTable);
        panelTable.setLayout(null);
        
        JLabel lblChiTitHa_1 = new JLabel("CHI TIẾT HÓA ĐƠN");
        lblChiTitHa_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
        lblChiTitHa_1.setBounds(603, 8, 167, 23);
        panelTable.add(lblChiTitHa_1);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Tên sản phẩm", "Loại sản phẩm", "Số lượng", "Đơn giá", "Tổng tiền"
        	}
        ));
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 42, 760, 571);
        panelTable.add(scrollPane);
        

        String[] columnNames = {"Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền" };
        Object[][] data = {
            { "Sản phẩm 1", 5, 10000, 50000 },
            { "Sản phẩm 2", 3, 15000, 45000 },
            { "Sản phẩm 3", 2, 20000, 40000 }
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(800, 10, 310, 614);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblChiTitHa = new JLabel("THÔNG TIN HÓA ĐƠN");
		lblChiTitHa.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
		lblChiTitHa.setBounds(20, 11, 280, 33);
		panel_1.add(lblChiTitHa);
		
		JLabel lblMaSP = new JLabel("Mã nhân viên:");
		lblMaSP.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblMaSP.setBounds(10, 55, 108, 27);
		panel_1.add(lblMaSP);
		
		JLabel txtMaSP_1_1_2 = new JLabel("__________");
		txtMaSP_1_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtMaSP_1_1_2.setBounds(160, 55, 96, 26);
		panel_1.add(txtMaSP_1_1_2);
		
		JLabel txtMaSP_1_1_1 = new JLabel("__________");
		txtMaSP_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtMaSP_1_1_1.setBounds(160, 93, 96, 26);
		panel_1.add(txtMaSP_1_1_1);
		
		JLabel lblTnSanPhm = new JLabel("Ngày lập");
		lblTnSanPhm.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblTnSanPhm.setBounds(10, 93, 108, 27);
		panel_1.add(lblTnSanPhm);
		
		JLabel lblThnhTin = new JLabel("THÀNH TIỀN:");
		lblThnhTin.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
		lblThnhTin.setBounds(10, 526, 251, 33);
		panel_1.add(lblThnhTin);
		
		JLabel lblVnd = new JLabel("______________________VND");
		lblVnd.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
		lblVnd.setBounds(10, 570, 290, 33);
		panel_1.add(lblVnd);
		
		JButton btnLmMi_1 = new JButton("Làm mới");
		btnLmMi_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnLmMi_1.setBounds(392, 27, 83, 26);
		add(btnLmMi_1);
		
		JButton btnThmSnPhm = new JButton("Thêm sản phẩm");
		btnThmSnPhm.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnThmSnPhm.setBounds(485, 27, 119, 26);
		add(btnThmSnPhm);
		
		JButton btnThanhToan_1 = new JButton("THANH TOÁN");
		btnThanhToan_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		btnThanhToan_1.setBounds(800, 635, 310, 53);
		add(btnThanhToan_1);
		
		JButton btnLmMi_1_1 = new JButton("Xóa");
		btnLmMi_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnLmMi_1_1.setBounds(614, 26, 83, 26);
		add(btnLmMi_1_1);
		
		JButton btnLmMi_1_1_1 = new JButton("Cập nhật");
		btnLmMi_1_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnLmMi_1_1_1.setBounds(707, 26, 83, 26);
		add(btnLmMi_1_1_1);

        // Set column headers
        for (int i = 0; i < columnNames.length; i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setHeaderValue(columnNames[i]);
        }
    }
}
