package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.MouseControllerFormTraCuuThongTin;
import model.LoaiSanPham;
import model.SanPham;
import util.ConnectServer;

import javax.swing.JRadioButton;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class FormTraCuuSanPham extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldMaSanPham;
	private JTextField textFieldTenSanPham;
	private JTextField textFieldGiaSanPham;
	private JTable tableSanPham;
	private MouseControllerFormTraCuuThongTin mouseControllerFormTraCuuThongTin;
	public JButton btnTimKiemSanPham;
	private JComboBox<LoaiSanPham> comboBoxLoaiSanPham;

	/**
	 * Create the panel.
	 * @throws RemoteException 
	 */
	public FormTraCuuSanPham() throws RemoteException {
		mouseControllerFormTraCuuThongTin = new MouseControllerFormTraCuuThongTin(this);
		setSize(1120, 680);
		setLayout(null);
		
		JLabel lblTraCuSn = new JLabel("TRA CỨU SẢN PHẨM");
		lblTraCuSn.setFont(new Font("Segoe UI Black", Font.PLAIN, 28));
		lblTraCuSn.setBounds(412, 11, 313, 55);
		add(lblTraCuSn);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 63, 313, 606);
		add(panel);
		
		JLabel lblMaSanPhm = new JLabel("Mã sản phẩm");
		lblMaSanPhm.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblMaSanPhm.setBounds(10, 79, 94, 29);
		panel.add(lblMaSanPhm);
		
		textFieldMaSanPham = new JTextField();
		textFieldMaSanPham.setEditable(false);
		textFieldMaSanPham.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textFieldMaSanPham.setColumns(10);
		textFieldMaSanPham.setBounds(114, 79, 186, 29);
		panel.add(textFieldMaSanPham);
		
		JLabel lblTnSanPhm = new JLabel("Tên sản phẩm");
		lblTnSanPhm.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblTnSanPhm.setBounds(10, 119, 94, 29);
		panel.add(lblTnSanPhm);
		
		textFieldTenSanPham = new JTextField();
		textFieldTenSanPham.setEditable(false);
		textFieldTenSanPham.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textFieldTenSanPham.setColumns(10);
		textFieldTenSanPham.setBounds(114, 119, 186, 29);
		panel.add(textFieldTenSanPham);
		
		JLabel lblLoaiSanPhm = new JLabel("Loại sản phẩm");
		lblLoaiSanPhm.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblLoaiSanPhm.setBounds(10, 159, 94, 29);
		panel.add(lblLoaiSanPhm);
		
		textFieldGiaSanPham = new JTextField();
		textFieldGiaSanPham.setEditable(false);
		textFieldGiaSanPham.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		textFieldGiaSanPham.setColumns(10);
		textFieldGiaSanPham.setBounds(114, 199, 186, 29);
		panel.add(textFieldGiaSanPham);
		
		JLabel lblGiaSanPhm = new JLabel("Giá sản phẩm");
		lblGiaSanPhm.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblGiaSanPhm.setBounds(10, 199, 94, 29);
		panel.add(lblGiaSanPhm);
		
		comboBoxLoaiSanPham = new JComboBox<LoaiSanPham>();
		comboBoxLoaiSanPham.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		comboBoxLoaiSanPham.setBounds(114, 159, 186, 29);
		panel.add(comboBoxLoaiSanPham);
		
		JLabel lblThngTinSn = new JLabel("Thông Tin Sản Phẩm");
		lblThngTinSn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblThngTinSn.setBounds(56, 38, 201, 30);
		panel.add(lblThngTinSn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(335, 63, 775, 606);
		add(panel_2);
		
		JLabel lblDanhSachSan = new JLabel("Danh sách sản phẩm");
		lblDanhSachSan.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblDanhSachSan.setBounds(10, 0, 168, 30);
		panel_2.add(lblDanhSachSan);
		
		tableSanPham = new JTable();
		tableSanPham.setRowHeight(25);
		tableSanPham.getTableHeader().setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		tableSanPham.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		tableSanPham.setForeground(new Color(0, 0, 0));
		tableSanPham.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Giá sản phẩm"
			}
		));
		
		ListSelectionModel selectionModel = tableSanPham.getSelectionModel();
		selectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = tableSanPham.getSelectedRow();
                    
					if (selectedRow >= 0) {
						
						String maSanPham = String.valueOf(tableSanPham.getValueAt(selectedRow, 0));
						String tenSanPham = String.valueOf(tableSanPham.getValueAt(selectedRow, 1));
						LoaiSanPham loaiSanPhamm = (LoaiSanPham) tableSanPham.getValueAt(selectedRow, 2);
						String giaSanPham = String.valueOf(tableSanPham.getValueAt(selectedRow, 3));
						
						textFieldMaSanPham.setText(maSanPham);
						textFieldTenSanPham.setText(tenSanPham);
						textFieldGiaSanPham.setText(giaSanPham);
						comboBoxLoaiSanPham.setSelectedItem(loaiSanPhamm);
					}
                }
            }
        });
		
		JScrollPane scrollPane = new JScrollPane(tableSanPham);
		scrollPane.setBounds(10, 41, 755, 554);
		panel_2.add(scrollPane);
		
		btnTimKiemSanPham = new JButton("Tìm kiếm");
		btnTimKiemSanPham.addMouseListener(mouseControllerFormTraCuuThongTin);
		btnTimKiemSanPham.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnTimKiemSanPham.setBounds(676, 6, 89, 23);
		panel_2.add(btnTimKiemSanPham);
		
		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					layDanhSachSanPham();
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLamMoi.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		btnLamMoi.setBounds(577, 6, 89, 23);
		panel_2.add(btnLamMoi);
		layDanhSachSanPham();
		layDanhSachLoaiSanPham();
		
	}
	
	public void layDanhSachSanPham() throws RemoteException {
        List<SanPham> sanPhams = ConnectServer.sanPhamInf.layDanhSachSanPham();
        DefaultTableModel model = (DefaultTableModel) tableSanPham.getModel();
        model.setRowCount(0);
        for (SanPham sanPham : sanPhams) {
            model.addRow(new Object[] {sanPham.getIdSanPham(), sanPham.getTenSanPham(), sanPham.getLoaiSanPham(), sanPham.getGiaSanPham()});
        }
    }
	
	public void layDanhSachLoaiSanPham() throws RemoteException {
		List<LoaiSanPham> loaiSanPhams = ConnectServer.loaiSanPhamInf.layDanhSachLoaiSanPham();
		for (LoaiSanPham loaiSanPham : loaiSanPhams) {
			comboBoxLoaiSanPham.addItem(loaiSanPham);
		}
	}

	public void hienThiThongTinTimKiemSanPham(List<SanPham> dsSanPham) {
		DefaultTableModel model = (DefaultTableModel) tableSanPham.getModel();
        model.setRowCount(0);
        for (SanPham sanPham : dsSanPham) {
            model.addRow(new Object[] {sanPham.getIdSanPham(), sanPham.getTenSanPham(), sanPham.getLoaiSanPham(), sanPham.getGiaSanPham()});
        }
	}
}
