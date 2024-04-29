package item;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.LoaiSanPham;
import util.ConnectServer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormLoaiSanPham extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tableLoaiSanPham;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			FormLoaiSanPham dialog = new FormLoaiSanPham();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 * 
	 * @throws RemoteException
	 */
	public FormLoaiSanPham() throws RemoteException {
		setModal(true);
		setBounds(100, 100, 533, 411);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Loại sản phẩm");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 117, 19);
		contentPanel.add(lblNewLabel);

		tableLoaiSanPham = new JTable();
		tableLoaiSanPham.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã loại", "Tên loại" }));
		tableLoaiSanPham.setRowHeight(25);
		JScrollPane scrollPane = new JScrollPane(tableLoaiSanPham);
		scrollPane.setBounds(10, 41, 497, 287);
		contentPanel.add(scrollPane);
		{
			JButton btnLmMi = new JButton("Làm mới");
			btnLmMi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						layDanhSachLoaiSanPham();
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnLmMi.setActionCommand("OK");
			btnLmMi.setBounds(414, 11, 93, 23);
			contentPanel.add(btnLmMi);
		}

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnThm = new JButton("Thêm");
				btnThm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						// hiển thị form nhập số lượng sản phẩm
						String tenLoai = JOptionPane.showInputDialog(null, "Nhập tên loại sản phẩm:", "Tên loại",
								JOptionPane.QUESTION_MESSAGE);

						// kiểm tra dữ liệu nhập vào
						if (tenLoai == null) {
							setVisible(true);
							return;
						}

						// kiểm tra dữ liệu nhập vào
						if (tenLoai.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Vui lòng nhập đẩy đủ thông tin!", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
							setVisible(true);
							return;
						}

						// kiểm tra dữ liệu nhập vào
						if (!tenLoai.matches("[a-zA-Z0-9 ]+")) {
							JOptionPane.showMessageDialog(null, "Tên loại không hợp lệ!", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
							setVisible(true);
							return;
						}

						// thêm loại sản phẩm
						try {
							LoaiSanPham loaiSanPham = new LoaiSanPham();
							loaiSanPham.setTenLoai(tenLoai);
							ConnectServer.loaiSanPhamInf.taoLoaiSanPham(loaiSanPham);
							JOptionPane.showMessageDialog(null, "Thêm loại sản phẩm thành công !", "Thông báo",
									JOptionPane.INFORMATION_MESSAGE);
							setVisible(true);
							layDanhSachLoaiSanPham();
						} catch (RemoteException e1) {
							JOptionPane.showMessageDialog(null, "Thêm loại sản phẩm thất bại !", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnThm.setActionCommand("OK");
				buttonPane.add(btnThm);
			}
			{
				JButton btnCpNht = new JButton("Cập nhật");
				btnCpNht.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if (tableLoaiSanPham.getSelectedRow() == -1) {
							JOptionPane.showMessageDialog(null, "Vui lòng chọn loại sản phẩm cần cập nhật !", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
							return;
						}

						// hiển thị form nhập số lượng sản phẩm
						String tenLoai = JOptionPane.showInputDialog(null, "Nhập tên loại sản phẩm:", "Tên loại",
								JOptionPane.QUESTION_MESSAGE);

						// kiểm tra dữ liệu nhập vào
						if (tenLoai == null) {
							setVisible(true);
							return;
						}

						// kiểm tra dữ liệu nhập vào
						if (tenLoai.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Vui lòng nhập đẩy đủ thông tin!", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
							setVisible(true);
							return;
						}

						// kiểm tra dữ liệu nhập vào
						if (!tenLoai.matches("[a-zA-Z0-9 ]+")) {
							JOptionPane.showMessageDialog(null, "Tên loại không hợp lệ!", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
							setVisible(true);
							return;
						}

						// thêm loại sản phẩm
						try {
							LoaiSanPham loaiSanPham = new LoaiSanPham();
							long maLoaiSanPham = (long) tableLoaiSanPham.getValueAt(tableLoaiSanPham.getSelectedRow(),
									0);
							loaiSanPham.setTenLoai(tenLoai);
							loaiSanPham.setMaLoai(maLoaiSanPham);
							ConnectServer.loaiSanPhamInf.capNhatLoaiSanPham(loaiSanPham);
							JOptionPane.showMessageDialog(null, "Cập nhật loại sản phẩm thành công !", "Thông báo",
									JOptionPane.INFORMATION_MESSAGE);
							setVisible(true);
							layDanhSachLoaiSanPham();
						} catch (RemoteException e1) {
							JOptionPane.showMessageDialog(null, "Cập nhật loại sản phẩm thất bại !", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnCpNht.setActionCommand("OK");
				buttonPane.add(btnCpNht);
			}
			{
				JButton okButton = new JButton("Xóa");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int row = tableLoaiSanPham.getSelectedRow();
						if (row == -1) {
							JOptionPane.showMessageDialog(null, "Vui lòng chọn loại sản phẩm cần xóa !", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
							return;
						}

						long maLoai = (long) tableLoaiSanPham.getValueAt(row, 0);
						String tenLoai = (String) tableLoaiSanPham.getValueAt(row, 1);

						int result = JOptionPane.showConfirmDialog(null,
								"Bạn có chắc chắn muốn xóa loại sản phẩm " + tenLoai + " ?", "Xác nhận",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

						if (result == JOptionPane.YES_OPTION) {
							try {
								ConnectServer.loaiSanPhamInf.xoaLoaiSanPham(maLoai);
								JOptionPane.showMessageDialog(null, "Xóa loại sản phẩm thành công !", "Thông báo",
										JOptionPane.INFORMATION_MESSAGE);
								setVisible(true);
								layDanhSachLoaiSanPham();
							} catch (RemoteException e1) {
								JOptionPane.showMessageDialog(null, "Xóa loại sản phẩm thất bại !", "Lỗi",
										JOptionPane.ERROR_MESSAGE);
								setVisible(true);
							}
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		layDanhSachLoaiSanPham();
	}

	// Lấy danh sách loại sản phẩm từ server
	public void layDanhSachLoaiSanPham() throws RemoteException {

		List<LoaiSanPham> dsLoaiSanPhams = ConnectServer.loaiSanPhamInf.layDanhSachLoaiSanPham();
		DefaultTableModel model = (DefaultTableModel) tableLoaiSanPham.getModel();

		model.setRowCount(0);

		for (LoaiSanPham loaiSanPham : dsLoaiSanPhams) {
			model.addRow(new Object[] { loaiSanPham.getMaLoai(), loaiSanPham.getTenLoai() });
		}
	}
}
