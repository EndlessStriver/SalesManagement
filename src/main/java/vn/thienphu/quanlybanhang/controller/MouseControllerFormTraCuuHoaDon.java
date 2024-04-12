package vn.thienphu.quanlybanhang.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import vn.thienphu.quanlybanhang.view.FormTraCuuHoaDon;

public class MouseControllerFormTraCuuHoaDon implements MouseListener{
	
	private FormTraCuuHoaDon formTraCuuHoaDon;

	public MouseControllerFormTraCuuHoaDon(FormTraCuuHoaDon formTraCuuHoaDon) {
		this.formTraCuuHoaDon = formTraCuuHoaDon;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(SwingUtilities.isRightMouseButton(e)) {
			this.formTraCuuHoaDon.showPopupMenu(e);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
