package item;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.LoaiSanPham;
import model.SanPham;
import util.ConnectServer;
import view.FormQuanTriSanPham;
import view.FormTraCuuSanPham;

import javax.swing.JLabel;
import java.awt.Font;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormTimKiemSanPham extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldMaSanPham;
	private JTextField textFieldTenSanPham;
	private JPanel myView;
	private JComboBox comboBoxLoaiSanPham;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			FormTimKiemSanPham dialog = new FormTimKiemSanPham();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 * @throws RemoteException 
	 */
	public FormTimKiemSanPham(JPanel viewShow) throws RemoteException {
		myView = viewShow;
		setModal(true);
		setBounds(100, 100, 325, 219);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Mã sản phẩm");
			lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
			lblNewLabel.setBounds(10, 11, 94, 29);
			contentPanel.add(lblNewLabel);
		}
		{
			textFieldMaSanPham = new JTextField();
			textFieldMaSanPham.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
			textFieldMaSanPham.setColumns(10);
			textFieldMaSanPham.setBounds(114, 11, 186, 29);
			contentPanel.add(textFieldMaSanPham);
		}
		{
			textFieldTenSanPham = new JTextField();
			textFieldTenSanPham.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
			textFieldTenSanPham.setColumns(10);
			textFieldTenSanPham.setBounds(114, 51, 186, 29);
			contentPanel.add(textFieldTenSanPham);
		}
		{
			JLabel lblHoVaTn = new JLabel("Tên sản phẩm");
			lblHoVaTn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
			lblHoVaTn.setBounds(10, 51, 94, 29);
			contentPanel.add(lblHoVaTn);
		}
		{
			JLabel lblSinThoai = new JLabel("Loại sản phẩm");
			lblSinThoai.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
			lblSinThoai.setBounds(10, 91, 94, 29);
			contentPanel.add(lblSinThoai);
		}
		{
			comboBoxLoaiSanPham = new JComboBox();
			comboBoxLoaiSanPham.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
			comboBoxLoaiSanPham.setBounds(114, 91, 186, 29);
			contentPanel.add(comboBoxLoaiSanPham);
		}
		{
			JButton btnTimKiem = new JButton("Tìm kiếm");
			btnTimKiem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (myView instanceof FormTraCuuSanPham) {
						FormTraCuuSanPham formTraCuuSanPham = (FormTraCuuSanPham) myView;
						try {
							List<SanPham> dsSanPham = ConnectServer.sanPhamInf.timKiemSanPham(textFieldMaSanPham.getText(), 
									textFieldTenSanPham.getText(), 
									((LoaiSanPham) comboBoxLoaiSanPham.getSelectedItem()) != null ? ((LoaiSanPham) comboBoxLoaiSanPham.getSelectedItem()).getTenLoai() : "");
							formTraCuuSanPham.hienThiThongTinTimKiemSanPham(dsSanPham);
							dispose();
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					if(myView instanceof FormQuanTriSanPham) {
						FormQuanTriSanPham formQuanTriSanPham = (FormQuanTriSanPham) myView;
						try {
							List<SanPham> dsSanPham = ConnectServer.sanPhamInf.timKiemSanPham(
									textFieldMaSanPham.getText(), textFieldTenSanPham.getText(),
									((LoaiSanPham) comboBoxLoaiSanPham.getSelectedItem()) != null
											? ((LoaiSanPham) comboBoxLoaiSanPham.getSelectedItem()).getTenLoai()
											: "");
							formQuanTriSanPham.hienThiThongTinTimKiemSanPham(dsSanPham);
							dispose();
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});
			btnTimKiem.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
			btnTimKiem.setBounds(114, 131, 186, 38);
			contentPanel.add(btnTimKiem);
		}
		
		layDanhSachLoaiSanPham();
	}
	
	public void layDanhSachLoaiSanPham() throws RemoteException {
		List<LoaiSanPham> loaiSanPhams = ConnectServer.loaiSanPhamInf.layDanhSachLoaiSanPham();
		comboBoxLoaiSanPham.addItem(null);
		for (LoaiSanPham loaiSanPham : loaiSanPhams) {
			comboBoxLoaiSanPham.addItem(loaiSanPham);
		}
	}

}
