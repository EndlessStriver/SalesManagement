package vn.thienphu.quanlybanhang.view;

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
    private JTextField txtSL0;
    private JTextField textField;

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

        // Panel for displaying employee name, invoice code, and date
        JPanel panelThongTin = new JPanel();
        panelThongTin.setBounds(10, 63, 780, 71);
        add(panelThongTin);
        panelThongTin.setLayout(null);

        JLabel lblTenNV = new JLabel("Tên nhân viên");
        lblTenNV.setBounds(0, 0, 117, 71);
        lblTenNV.setFont(new Font("Segoe UI Black", Font.PLAIN, 14)); // Bold font, adjust size if necessary
        panelThongTin.add(lblTenNV);

        JLabel lblDate = new JLabel("Ngày lập:");
        lblDate.setBounds(239, 0, 107, 71);
        lblDate.setFont(new Font("Segoe UI Black", Font.PLAIN, 14)); // Bold font, adjust size if necessary
        panelThongTin.add(lblDate);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        JLabel lblDateValue = new JLabel(dateFormat.format(new Date()));
        lblDateValue.setBounds(356, 0, 117, 71);
        lblDateValue.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Bold font, adjust size if necessary
        panelThongTin.add(lblDateValue);
        
        JLabel txtTenNV = new JLabel("Tên nhân viên");
        txtTenNV.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtTenNV.setBounds(126, 12, 117, 49);
        panelThongTin.add(txtTenNV);

        // Panel for displaying product information
        JPanel panelTable = new JPanel();
        panelTable.setBounds(10, 144, 780, 544);
        add(panelTable);
        panelTable.setLayout(new GridLayout(1, 1, 0, 0));

        String[] columnNames = {"Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền" };
        Object[][] data = {
            { "Sản phẩm 1", 5, 10000, 50000 },
            { "Sản phẩm 2", 3, 15000, 45000 },
            { "Sản phẩm 3", 2, 20000, 40000 }
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        panelTable.add(new JScrollPane(table));
        table.setRowHeight(25);
		table.getTableHeader().setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		table.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 13));
		table.setForeground(new Color(0, 0, 0));

        // Set column headers
        for (int i = 0; i < columnNames.length; i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setHeaderValue(columnNames[i]);
        }
        table.getTableHeader().repaint();

        // Panel for adding product
        JPanel panelSP = new JPanel();
        panelSP.setBounds(800, 0, 315, 688);
        add(panelSP);
        panelSP.setLayout(null);

        JButton btnThemSP = new JButton("Thêm sản phẩm");
        btnThemSP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        btnThemSP.setBounds(28, 243, 234, 40);
        panelSP.add(btnThemSP);

        JButton btnThanhToan = new JButton("Thanh toán");
        btnThanhToan.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        btnThanhToan.setBounds(10, 692, 295, 50);
        panelSP.add(btnThanhToan);
        
        JButton btnTimSP = new JButton("Tìm kiếm sản phẩm");
        btnTimSP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
        btnTimSP.setBounds(160, 10, 145, 33);
        panelSP.add(btnTimSP);
        
        JLabel lblMaSP = new JLabel("Mã sản phẩm :");
        lblMaSP.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
        lblMaSP.setBounds(28, 54, 108, 27);
        panelSP.add(lblMaSP);
        
        JLabel lblSL0 = new JLabel("Số lượng :");
        lblSL0.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
        lblSL0.setBounds(28, 208, 88, 24);
        panelSP.add(lblSL0);
        
        txtSL0 = new JTextField();
        txtSL0.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtSL0.setColumns(10);
        txtSL0.setBounds(146, 205, 116, 27);
        panelSP.add(txtSL0);
        
        JLabel lblThongTinSP = new JLabel("Thông Tin Sản Phẩm");
        lblThongTinSP.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
        lblThongTinSP.setBounds(38, 307, 251, 33);
        panelSP.add(lblThongTinSP);
        
        JLabel lblTnSanPhm = new JLabel("Tên sản phẩm:");
        lblTnSanPhm.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
        lblTnSanPhm.setBounds(28, 92, 108, 27);
        panelSP.add(lblTnSanPhm);
        
        JLabel lblnGia = new JLabel("Đơn giá:");
        lblnGia.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
        lblnGia.setBounds(28, 130, 108, 27);
        panelSP.add(lblnGia);
        
        JLabel txtMaSP_1_1 = new JLabel("SP0001");
        txtMaSP_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtMaSP_1_1.setBounds(146, 130, 96, 26);
        panelSP.add(txtMaSP_1_1);
        
        JLabel txtMaSP_1_1_1 = new JLabel("SP0001");
        txtMaSP_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtMaSP_1_1_1.setBounds(146, 92, 96, 26);
        panelSP.add(txtMaSP_1_1_1);
        
        JLabel txtMaSP_1_1_2 = new JLabel("SP0001");
        txtMaSP_1_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtMaSP_1_1_2.setBounds(146, 54, 96, 26);
        panelSP.add(txtMaSP_1_1_2);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(33, 294, 261, 2);
        panelSP.add(separator);
        
        JLabel lblLoaiSanPhm = new JLabel("Loại sản phẩm:");
        lblLoaiSanPhm.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
        lblLoaiSanPhm.setBounds(28, 168, 108, 27);
        panelSP.add(lblLoaiSanPhm);
        
        JLabel txtMaSP_1_1_3 = new JLabel("SP0001");
        txtMaSP_1_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtMaSP_1_1_3.setBounds(146, 168, 96, 26);
        panelSP.add(txtMaSP_1_1_3);
        
        JLabel lblTnSanPhm_1 = new JLabel("Tên sản phẩm:");
        lblTnSanPhm_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
        lblTnSanPhm_1.setBounds(28, 351, 108, 27);
        panelSP.add(lblTnSanPhm_1);
        
        JLabel txtMaSP_1_1_1_1 = new JLabel("SP0001");
        txtMaSP_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtMaSP_1_1_1_1.setBounds(146, 351, 96, 26);
        panelSP.add(txtMaSP_1_1_1_1);
        
        JLabel lblnGia_1 = new JLabel("Đơn giá:");
        lblnGia_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
        lblnGia_1.setBounds(28, 389, 108, 27);
        panelSP.add(lblnGia_1);
        
        JLabel txtMaSP_1_1_4 = new JLabel("SP0001");
        txtMaSP_1_1_4.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtMaSP_1_1_4.setBounds(146, 389, 96, 26);
        panelSP.add(txtMaSP_1_1_4);
        
        JLabel lblLoaiSanPhm_1 = new JLabel("Loại sản phẩm:");
        lblLoaiSanPhm_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
        lblLoaiSanPhm_1.setBounds(28, 427, 108, 27);
        panelSP.add(lblLoaiSanPhm_1);
        
        JLabel txtMaSP_1_1_3_1 = new JLabel("SP0001");
        txtMaSP_1_1_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtMaSP_1_1_3_1.setBounds(146, 427, 96, 26);
        panelSP.add(txtMaSP_1_1_3_1);
        
        JLabel lblSL0_1 = new JLabel("Số lượng :");
        lblSL0_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
        lblSL0_1.setBounds(28, 467, 88, 24);
        panelSP.add(lblSL0_1);
        
        textField = new JTextField();
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        textField.setColumns(10);
        textField.setBounds(146, 464, 116, 27);
        panelSP.add(textField);
        
        JButton btnNewButton = new JButton("Cập nhật sản phẩm");
        btnNewButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
        btnNewButton.setBounds(28, 502, 145, 33);
        panelSP.add(btnNewButton);
        
        JButton btnXoaSanPhm = new JButton("Xóa sản phẩm");
        btnXoaSanPhm.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
        btnXoaSanPhm.setBounds(28, 546, 145, 33);
        panelSP.add(btnXoaSanPhm);
        
        JButton btnThanhToan_1 = new JButton("Thanh toán");
        btnThanhToan_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
        btnThanhToan_1.setBounds(10, 637, 295, 40);
        panelSP.add(btnThanhToan_1);
    }
}
