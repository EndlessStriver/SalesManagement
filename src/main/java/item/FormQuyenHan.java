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
import model.Quyen;
import util.ConnectServer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormQuyenHan extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tableQuyenHan;

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
	public FormQuyenHan() throws RemoteException {
		setModal(true);
		setBounds(100, 100, 533, 411);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Danh sách quyền hạn");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 173, 19);
		contentPanel.add(lblNewLabel);

		tableQuyenHan = new JTable();
		tableQuyenHan.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã quyền", "Tên quyền" }));
		tableQuyenHan.setRowHeight(25);
		JScrollPane scrollPane = new JScrollPane(tableQuyenHan);
		scrollPane.setBounds(10, 41, 497, 287);
		contentPanel.add(scrollPane);
		{
			JButton btnLmMi = new JButton("Làm mới");
			btnLmMi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						layDanhSachQuyenHan();
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

						// hiển thị form nhap ten quyen
						String tenQuyen = JOptionPane.showInputDialog(null, "Nhập tên quyền:", "Tên quyền",
								JOptionPane.QUESTION_MESSAGE);

						// kiểm tra dữ liệu nhập vào
						if (tenQuyen == null) {
							setVisible(true);
							return;
						}

						// kiểm tra dữ liệu nhập vào
						if (tenQuyen.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Vui lòng nhập đẩy đủ thông tin!", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
							setVisible(true);
							return;
						}

						// kiểm tra dữ liệu nhập vào
						if (!tenQuyen.matches("[a-zA-Z ]+")) {
							JOptionPane.showMessageDialog(null, "Tên quyền không hợp lệ!", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
							setVisible(true);
							return;
						}

						// thêm quyền hạn
						try {
							Quyen quyen = new Quyen();
							quyen.setTenQuyen(tenQuyen);
							ConnectServer.quyenInf.taoQuyen(quyen);
							JOptionPane.showMessageDialog(null, "Thêm quyền hạn thành công !", "Thông báo",
									JOptionPane.INFORMATION_MESSAGE);
							layDanhSachQuyenHan();
							setVisible(true);
						} catch (RemoteException e1) {
							JOptionPane.showMessageDialog(null, "Thêm quyền hạn thất bại !", "Lỗi",
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
						
						if (tableQuyenHan.getSelectedRow() == -1) {
							JOptionPane.showMessageDialog(null, "Vui lòng quyền hạn cần cập nhật !", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						
						// hiển thị form nhap ten quyen
						String tenQuyen = JOptionPane.showInputDialog(null, "Nhập tên quyền:", "Tên quyền",
								JOptionPane.QUESTION_MESSAGE);

						// kiểm tra dữ liệu nhập vào
						if (tenQuyen == null) {
							setVisible(true);
							return;
						}

						// kiểm tra dữ liệu nhập vào
						if (tenQuyen.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Vui lòng nhập đẩy đủ thông tin!", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
							setVisible(true);
							return;
						}

						// kiểm tra dữ liệu nhập vào
						if (!tenQuyen.matches("[a-zA-Z ]+")) {
							JOptionPane.showMessageDialog(null, "Tên quyền không hợp lệ!", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
							setVisible(true);
							return;
						}

						// thêm loại sản phẩm
						try {
							int maQuyen = Integer.parseInt(tableQuyenHan.getValueAt(tableQuyenHan.getSelectedRow(), 0).toString());
							Quyen quyen = new Quyen();
							quyen.setIdQuyen(maQuyen);
							quyen.setTenQuyen(tenQuyen);
							ConnectServer.quyenInf.capNhatQuyen(quyen);
							JOptionPane.showMessageDialog(null, "Cập nhật quyền hạn thành công !", "Thông báo",
									JOptionPane.INFORMATION_MESSAGE);
							setVisible(true);
							layDanhSachQuyenHan();
						} catch (RemoteException e1) {
							JOptionPane.showMessageDialog(null, "Cập nhật quyền hạn thất bại !", "Lỗi",
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
						int row = tableQuyenHan.getSelectedRow();
						if (row == -1) {
							JOptionPane.showMessageDialog(null, "Vui lòng chọn quyền hạn cần xóa !", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
							return;
						}

						int maQuyen = Integer.parseInt(tableQuyenHan.getValueAt(row, 0).toString());
						String tenQuyen = (String) tableQuyenHan.getValueAt(row, 1);

						int result = JOptionPane.showConfirmDialog(null,
								"Bạn có chắc chắn muốn xóa loại sản phẩm " + tenQuyen + " ?", "Xác nhận",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

						if (result == JOptionPane.YES_OPTION) {
							try {
								ConnectServer.quyenInf.xoaQuyen(maQuyen);
								JOptionPane.showMessageDialog(null, "Xóa quyền hạn thành công !", "Thông báo",
										JOptionPane.INFORMATION_MESSAGE);
								setVisible(true);
								layDanhSachQuyenHan();
							} catch (RemoteException e1) {
								JOptionPane.showMessageDialog(null, e1.getMessage(), "Lỗi",
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
		layDanhSachQuyenHan();
	}

	// lấy danh sách quyền hạn từ server
	public void layDanhSachQuyenHan() throws RemoteException {

		List<Quyen> dsQuyen = ConnectServer.quyenInf.layDanhSachQuyen();
		DefaultTableModel model = (DefaultTableModel) tableQuyenHan.getModel();
		model.setRowCount(0);
		
		for (Quyen quyen : dsQuyen) {
			model.addRow(new Object[] { quyen.getIdQuyen(), quyen.getTenQuyen() });
		}
	}
}
